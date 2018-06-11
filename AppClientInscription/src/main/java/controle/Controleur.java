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
import java.util.List;

import javax.annotation.Resource;
import meserreurs.MonException;
import metier.Activite;
import metier.Sport;
import service.Utils;

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

	@Resource(lookup = "java:jboss/exported/topic/CerisaieTopic")
	private Topic topic;
	// On accède à l'EJB

	@Resource(mappedName = "java:/ConnectionFactory")
	private TopicConnectionFactory cf;

	// Session établie avec le serveur
	private TopicSession session = null;

	// Le client utilise un Producteur de messsage pour envoyer une demande de formation
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		// Affichage du formulaire d'inscription à une activité
		if (AJOUTER_INSCRIPTION.equals(actionName)) {
			request.setAttribute("sports", new Utils().getSports());
			request.setAttribute("activites", new Utils().getActivites());
			request.setAttribute("emplacements", new Utils().getEmplacements());

			request.getRequestDispatcher("AjouteInscription.jsp").forward(request, response);
		}

		else if (RETOUR_ACCUEIL.equals(actionName)) {
			this.getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
		}

		else if (ENVOI_INSCRIPTION.equals(actionName))
		{
			response.setContentType("text/html;charset=UTF-8");

			try {
				// On récupère la valeur des autres champs saisis par l'utilisateur
				int codeSport = Integer.getInteger(request.getParameter("code_sport"));
				int numEmplacement = Integer.getInteger(request.getParameter("num_emplacement"));
				Date dateReservation = Date.valueOf(request.getParameter("datejour"));

				// On crée une demande d'inscription avec ces valeurs
				Activite uneActivite = new Activite();
				uneActivite.setCodesport(codeSport);
				uneActivite.setNumsejour(numEmplacement);
				uneActivite.setDatejour(dateReservation);

				// On envoie cette demande d'inscription dans le topic
				boolean ok = envoi(uneActivite);
				if (ok)
					// On retourne à la page d'accueil
					this.getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
				else {
					this.getServletContext().getRequestDispatcher("/Erreur.jsp").include(request, response);
				}
			}
			catch (MonException m) {
				// On passe l'erreur à  la page JSP
				request.setAttribute("MesErreurs", m.getMessage());
				request.getRequestDispatcher("PostMessage.jsp").forward(request, response);
			}
			catch (Exception e) {
				// On passe l'erreur à la page JSP
				System.out.println("Erreur client  :" + e.getMessage());
				request.setAttribute("MesErreurs", e.getMessage());
				request.getRequestDispatcher("PostMessage.jsp").forward(request, response);
			}
		}
	}

	/**
	 * Permet de publier une demande d'inscription dans le topic
	 * 
	 * @param uneActivite
	 *            La demande d'inscription � publier
	 * @return
	 * @throws Exception
	 */
	boolean envoi(Activite uneActivite) throws Exception {

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
			message.setObject(uneActivite);
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
