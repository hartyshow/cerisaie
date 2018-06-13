package ejb;

import meserreurs.MonException;
import metier.*;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import service.Service;

/**
 * Message-Driven Bean implementation class for: CerisaieTopic
 */
// On se connecte � la file d'attente InscriptionTopic
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/topic/CerisaieTopic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")}, mappedName = "CerisaieTopic")
public class CerisaieTopic implements MessageListener {

    @Resource
    private MessageDrivenContext context;

    /*
     * Default constructor.
     */
    public CerisaieTopic() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        // TODO Auto-generated method stub
        boolean ok = false;
        // On g�re le message r�cup�r� dans le topic
        try {
            // On transforme le message en demande d'inscription
            if (message != null) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                Activite uneActivite = (Activite) objectMessage.getObject();
                try {
                    // on construit un objet Entity
                    ActiviteEntity activiteEntity = new ActiviteEntity();
                    // on tansf�re les donn�es re�ues dans l'objet Entity
                    activiteEntity.setCodesport(uneActivite.getCodesport());
                    activiteEntity.setDatejour(uneActivite.getDatejour());
                    activiteEntity.setNbloc(uneActivite.getNbloc());
                    activiteEntity.setNumsej(uneActivite.getNumsejour());

                    Service service = new Service();
                    // On v�rifie si l'activit� et d�j� enregistr�e en BDD ou pas
                    ActiviteEntity activite = service.getActiviteIfExist(activiteEntity.getNumsej(), activiteEntity.getCodesport(), activiteEntity.getDatejour());
                    if(activite != null && activite.equals(activiteEntity))
                        service.updateActivite(activiteEntity, activite.getNbloc());
                    else
                        service.insertionActivite(activiteEntity);
                } catch (NamingException er) {
                    EcritureErreur(er.getMessage());
                } catch (MonException e) {
                    EcritureErreur(e.getMessage());
                } catch (Exception ex) {
                    EcritureErreur(ex.getMessage());
                }
            }

        } catch (JMSException jmse) {
            System.out.println(jmse.getMessage());
            EcritureErreur(jmse.getMessage());
            context.setRollbackOnly();
        }
    }

    /**
     * Permet d'enregistrer une erreur dans un fichier log
     *
     * @param message Le message d'erreur
     */
    public void EcritureErreur(String message) {
        BufferedWriter wr;
        String nomf = "erreurs.log";
        Date madate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm");
        try {
            // On �crit � la fin du fichier
            wr = new BufferedWriter(new FileWriter(nomf, true));
            wr.newLine();
            wr.write(sdf.format(madate));
            wr.newLine();
            wr.write(message);
            wr.close();
        } catch (FileNotFoundException ef) {
            ;
        } catch (IOException eio) {
            ;
        }
    }
}
