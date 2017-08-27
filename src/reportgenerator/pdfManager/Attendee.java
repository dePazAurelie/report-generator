package reportgenerator.pdfManager;

public class Attendee {

    private String firstName;
    private String lastName;
    private String mail;
    private boolean presence = false;

    public Attendee(String firstName, String lastName, String mail, boolean presence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.presence = presence;
    }

    public Attendee(String firstName, String lastName, String mail){
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }
}
