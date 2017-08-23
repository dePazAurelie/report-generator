package reportgenerator.pdfManager;

public class attendee {

    private String firstName;
    private String lastName;
    private String mail;
    private boolean presence = true;

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
        if(arg == "Checked"){
            presence = true;
        }
        else {
            presence = false;
        }

        return presence;
    }
}
