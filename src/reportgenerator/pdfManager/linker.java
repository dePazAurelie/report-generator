package reportgenerator.pdfManager;

import java.util.ArrayList;

public class linker {

    private String projectName;
    private String projectNumber;
    private String date;
    private attendee host;
    private ArrayList <attendee> attendees;
    private ArrayList <topic> topics;
    private String notes;

    //getters & setters pour faire le lien entre le GUI et l'export. Respecte l'ordre des champs.
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
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

    public void setHost(String firstName, String lastName, String mail) {
        new attendee(firstName, lastName, mail);
        this.host = host;
    }

    public ArrayList<attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(String firstName, String lastName, String mail, String status) {
        attendees.add(new attendee(firstName, lastName, mail, status));
        this.attendees = attendees;
    }

    public ArrayList<topic> getTopics() {
        return topics;
    }

    //pas encore fait
    public void setTopics() {

        this.topics = topics;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
