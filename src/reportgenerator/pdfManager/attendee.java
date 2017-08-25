package reportgenerator.pdfManager;

public class attendee {

    private String firstName;
    private String lastName;
    private String mail;
    private boolean presence = false;

    public attendee(String firstName, String lastName, String mail, String presence) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.presence = presenceCheck(presence);
    }

    public attendee(String firstName, String lastName, String mail){
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
    }

    //Créer un boolean à partir du string pour savoir si les personnes étaient présentes ou pas
    public boolean presenceCheck(String arg){
        if(arg == "checked"){
            presence = true;
        }
        else {
            presence = false;
        }
        return (presence = false);
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
