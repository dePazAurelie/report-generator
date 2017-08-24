package reportgenerator.pdfManager;

public class attendee {

    private String firstName = "";
    private String lastName = "";
    private String mail = "";
    private boolean presence = false;

    public attendee(String firstName, String lastName, String mail, boolean presence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.presence = presence;
    }

    public attendee(String firstName, String lastName, String mail){
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public boolean isPresence() {
        return presence;
    }
}
