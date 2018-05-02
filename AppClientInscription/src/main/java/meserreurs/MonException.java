package meserreurs;

public class MonException  extends Exception  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
    private String type;

    public MonException() {
    }

    public MonException( String libelle,  String type) {
        this.message = libelle;
        this.type = type;
    }

    public MonException( String libelle) {
        this.message = libelle;
       
    }

    /**
     * Gets the libelle value for this ErreurExpo.
     * 
     * @return libelle
     */
    public String getMessage() {
        return message;
    }
     
    public void setMessage(String libelle) {
        this.message = libelle;
    }
    /**
     * Gets the type value for this ErreurExpo.
     * 
     * @return type
     */
    public String getType() {
        return type;
    }
    /**
     * Sets the type value for this ErreurExpo.
     * 
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
}
