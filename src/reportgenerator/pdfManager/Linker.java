package reportgenerator.pdfManager;
import java.util.ArrayList;

public class Linker {

    private String projectName;
    private String meetingNumber;
    private String date;
    private Attendee host;
    private ArrayList <Attendee> attendeesPresents = new ArrayList<>();
    private ArrayList <Attendee> attendeesExcused = new ArrayList<>();
    private ArrayList <Attendee> attendees = new ArrayList<>();
    private ArrayList <Topic> topics = new ArrayList<>();
    private String notes;

    //getters & setters pour faire le lien entre le GUI et l'export. Respecte l'ordre des champs.
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getMeetingNumber() {
        return meetingNumber;
    }

    public void setMeetingNumber(String meetingNumber) {
        this.meetingNumber = meetingNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Attendee getHost() {
        return host;
    }

    public void addHost(String firstName, String lastName, String mail) {
        this.host = new Attendee(firstName, lastName, mail);
    }

    public ArrayList<Attendee> getAttendees() {
        return attendees;
    }


    //Création d'array differents contenant respectivement les présents et les absents.
    public void addAttendees(String firstName, String lastName, String mail, boolean status) {
        if (status == true){
            attendeesPresents.add(new Attendee(firstName, lastName, mail, status));
        }
        else {
            attendeesExcused.add(new Attendee(firstName, lastName, mail, status));
        }
    }


    /**Fait en sorte que les deux array contenant les Presents et Excused font la même taille et sont remplis par des null puis va transvaser les deux array en alternant dans l'arrayList attendees**/
    public void mergeAttendees(){

        while (attendeesPresents.size() != attendeesExcused.size()) {
            if (attendeesPresents.size() < attendeesExcused.size()) {
                attendeesPresents.add(new Attendee("", "", "", true));

            } else if (attendeesPresents.size() > attendeesExcused.size()) {
                attendeesExcused.add(new Attendee("", "", "", false));

            } else {
                System.out.print("error on mergeAttendees");
                break;
            }
        }

        for (int i = 0; i < attendeesPresents.size(); i++) {

            attendees.add(attendeesPresents.get(i));
            attendees.add(attendeesExcused.get(i));

        }
    }

    public ArrayList<Topic> getTopics() {
        return topics;
    }


    public void addTopics(String topic, String desicion, String outcome) {
        topics.add(new Topic(topic, desicion, outcome));
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}