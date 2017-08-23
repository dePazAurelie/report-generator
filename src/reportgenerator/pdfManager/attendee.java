package reportgenerator.pdfManager;

public class attendee {

    private String firstName;
    private String lastName;
    private String mail;
    private boolean presence = true;

    public attendee(String firstNameArg, String lastNameArg, String mailArg, String presenceArg) {
        firstName = firstNameArg;
        lastName = lastNameArg;
        mail = mailArg;
        presence = presenceCheck(presenceArg);
    }

    public attendee(String firstNameArg, String lastNameArg, String mailArg){
        firstName = firstNameArg;
        lastName = lastNameArg;
        mail = mailArg;
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
