package controle;

import java.io.IOException;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.text.SimpleDateFormat;


import java.sql.Date;

import javax.annotation.Resource;
import meserreurs.MonException;
import metier.Inscription;

import javax.naming.NamingException;

/**
 * Servlet implementation class Traitement
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {

	private static final long serialVersionUID = 10L;
	private static final String ACTION_TYPE = "action";
	private static final String AJOUTER_INSCRIPTION = "ajouteInscription";
	private static final String ENVOI_INSCRIPTION = "envoiInscription";
	private static final String RETOUR_ACCUEIL = "Retour";

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	@Resource(lookup = "java:jboss/exported/topic/InscriptionJmsTopic")
	private Topic topic;
	// On accède à l'EJB

	@Resource(mappedName = "java:/ConnectionFactory")
	private TopicConnectionFactory cf;

	// Session établie avec le serveur
	private TopicSession session = null;

	// Le client utilise un Producteur de messsage pour envoyer une demande de
	// formation
	private TopicPublisher producer;

	/**
	 * Constructeur par défaut de la classe
	 */
	public Controleur() {
		super();
	}

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			TraiteRequete(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			TraiteRequete(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Procédure principale de démarrage
	 */
	public void TraiteRequete(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// On récupère l'action
		String actionName = request.getParameter(ACTION_TYPE);

		// Si on veut afficher l'ensemble des demandes d'inscription
		if (AJOUTER_INSCRIPTION.equals(actionName)) {

			request.getRequestDispatcher("AjouteInscription.jsp").forward(request, response);

			} else if (RETOUR_ACCUEIL.equals(actionName)) {
			this.getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
		}

		else if (ENVOI_INSCRIPTION.equals(actionName))
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			response.setContentType("text/html;charset=UTF-8");
			// On récupère les informations sisies
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");

			if ((nom != null) && (prenom != null)) {
				try {
					// On récupère la valeur des autres champs saisis par
					// l'utilisateur
					// on transfome la date
					// au format Mysql java.sql.Date
					String datenaissance = request.getParameter("datenaissance");
					java.util.Date initDate = new SimpleDateFormat("dd/MM/yyyy").parse(datenaissance);
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					String parsedDate = formatter.format(initDate);
					initDate= formatter.parse(parsedDate);
					Date uneDate = new Date(initDate.getTime());

					String adresse = request.getParameter("adresse");
					String cpostal = request.getParameter("cpostal");
					String ville = request.getParameter("ville");

					// On crée une demande d'inscription avec ces valeurs
					Inscription unedemande = new Inscription();
					unedemande.setNomcandidat(nom);
					unedemande.setPrenomcandidat(prenom);
					unedemande.setDatenaissance(uneDate);
					unedemande.setAdresse(adresse);
					unedemande.setCpostal(cpostal);
					unedemande.setVille(ville);

					// On envoie cette demande d'inscription dans le topic
					boolean ok = envoi(unedemande);
					if (ok)
						// On retourne àla page d'accueil
						this.getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
					else {
						this.getServletContext().getRequestDispatcher("/Erreur.jsp").include(request, response);
					}
				}catch (MonException m) {
					// On passe l'erreur à  la page JSP
					request.setAttribute("MesErreurs", m.getMessage());
					request.getRequestDispatcher("PostMessage.jsp").forward(request, response);
				}catch (Exception e) {
					// On passe l'erreur à la page JSP
					System.out.println("Erreur client  :" + e.getMessage());
					request.setAttribute("MesErreurs", e.getMessage());
					request.getRequestDispatcher("PostMessage.jsp").forward(request, response);
				}
			}
		}
	}

	/**
	 * Permet de publier une demande d'inscription dans le topic
	 * 
	 * @param uneDemande
	 *            La demande d'inscription � publier
	 * @return
	 * @throws Exception
	 */
	boolean envoi(Inscription uneDemande) throws Exception {

		boolean ok = true;
		TopicConnection connection = null;

		try {

			// On crée la connexion JMS , session, producteur et message;
			/*
			 * connection = connectionFactory.createConnection(
			 * System.getProperty("username", DEFAULT_USERNAME),
			 * System.getProperty("password", DEFAULT_PASSWORD));
			 */

			// Création Connection et Session JMS
			connection = cf.createTopicConnection();
			session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

			// On crée le producteur utilisé pour envoyer un message
			producer = session.createPublisher(topic);
			// On lance la connection
			connection.start();
			ObjectMessage message = session.createObjectMessage();
			message.setObject(uneDemande);
			// On publie le message
			producer.publish(message);
			producer.close();
			session.close();
			connection.close();
		} catch (JMSException j) {
			new MonException(j.getMessage());
			ok=false;
		}catch (Exception e) {
			new MonException(e.getMessage());
			ok=false;
		}
		return ok;
	}
}
