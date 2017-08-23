package reportgenerator.pdfManager;

import java.util.ArrayList;

public class linker {

    private String projectName;
    private String meetingNumber;
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

    public void addAttendees(String firstName, String lastName, String mail, String status) {
        attendees.add(new attendee(firstName, lastName, mail, status));
    }

    public ArrayList<topic> getTopics() {
        return topics;
    }

    //pas encore fait
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
