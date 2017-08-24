package reportgenerator.pdfManager;

import java.util.ArrayList;

public class linker {

    private String projectName;
    private String meetingNumber;
    private String date;
    private attendee host;
    private ArrayList <attendee> attendeesPresents = new ArrayList<>();
    private ArrayList <attendee> attendeesExcused = new ArrayList<>();
    private ArrayList <attendee> attendees = new ArrayList<>();
    private ArrayList <topic> topics = new ArrayList<>();
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

    public attendee getHost() {
        return host;
    }

    public void addHost(String firstName, String lastName, String mail) {
        this.host = new attendee(firstName, lastName, mail);
    }

    public ArrayList<attendee> getAttendees() {
        return attendees;
    }


    //Création d'array differents contenant respectivement les présents et les absents.
    public void addAttendees(String firstName, String lastName, String mail, String status) {
        if (status == "checked"){
            attendeesPresents.add(new attendee(firstName, lastName, mail, status));
        }
        else {
            attendeesExcused.add(new attendee(firstName, lastName, mail, status));
        }
    }


    /**Fait en sorte que les deux array contenant les Presents et Excused font la même taille et sont remplis par des null puis va transvaser les deux array en alternant dans l'arrayList attendees**/
    public void mergeAttendees(){

        while (attendeesPresents.size() != attendeesExcused.size()) {

            if (attendeesPresents.size() < attendeesExcused.size()) {

                attendeesPresents.add(new attendee("", "", "", ""));

            } else if (attendeesPresents.size() > attendeesExcused.size()) {

                attendeesExcused.add(new attendee("", "", "", ""));

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

    public ArrayList<topic> getTopics() {
        return topics;
    }


    public void addTopics(String topic, String desicion, String outcome) {
        topics.add(new topic(topic, desicion, outcome));
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
