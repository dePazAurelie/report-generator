package reportgenerator.window;

import net.miginfocom.swing.MigLayout;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import reportgenerator.pdfManager.linker;
import reportgenerator.pdflayout.pageLayout;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

public class Window extends JFrame {

    boolean presence= false;
    int cmpt = 0;
    JPanel panel = new JPanel();

    //1 ligne = Meeting informations
    JLabel ProjectName = new JLabel("Project Name: ");
    JLabel number = new JLabel("Project number: ");

    //****************************************************
    JTextField txtprojectname = new JTextField(20);
    //public void getTxtprojectname(linker link){
    //    link.setProjectName(txtprojectname.getText());
    //}

    private void getTxtprojectname(linker link){
        if (txtprojectname.getText().equals("") || txtprojectname.getText().equals("Enter a project")) {
            txtprojectname.setText("Enter a project");
            cmpt++;
        } else {
            link.setProjectName(txtprojectname.getText());
        }
    }

    //****************************************************
    JTextField projectnamenumber = new JTextField(5);
    private void getprojectnamenumber(linker link){
        if (projectnamenumber.getText().equals("") || projectnamenumber.getText().equals("Enter a number")) {
            projectnamenumber.setText("Enter a number");
        } else {
            link.setMeetingNumber(projectnamenumber.getText());
        }
    }

    //2 ligne : meeting date
    JLabel meetingdate = new JLabel("Meeting Date :");

    //****************************************************
    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());

    private void getdateofmeeting(linker link){
        Object s = datePicker.getModel().getValue();
        if (s == null) {
            link.setDate(new Date().toString());
        } else {
            link.setDate(((Date) datePicker.getModel().getValue()).toString());
        }
    }

    //3 ligne : ****HOST****
    JLabel host = new JLabel("HOST");

    //4 ligne : host details
    JLabel hostname = new JLabel("Name:");
    JTextField jtfhostname = new JTextField(10);


    JLabel hostfirstname = new JLabel("Firstname :");
    JTextField jtfhostfirstname = new JTextField(10);

    JLabel hostmail = new JLabel("Mail :");
    JTextField jtfhostmail = new JTextField(20);
    //****************************************************
    public void getjtfhostdetails(linker link) {
        if (jtfhostname.getText().equals("") || jtfhostname.getText().equals("Enter a name")) {
            jtfhostname.setText("Enter a name");
            cmpt++;
            if (jtfhostfirstname.getText().equals("") || jtfhostfirstname.getText().equals("Enter a name")) {
                jtfhostfirstname.setText("Enter a name");
                cmpt++;
            }

            if (jtfhostmail.getText().equals("") || jtfhostmail.getText().equals("Enter a e-mail")) {
                jtfhostmail.setText("Enter a e-mail");
                cmpt++;
            }

            if (cmpt == 0) {
                link.addAttendees(jtfhostname.getText(), jtfhostfirstname.getText(), jtfhostmail.getText(), presence);
                link.mergeAttendees();
            }
        }
    }

    //5 ligne : **ATTENDEES**
    JLabel attendees = new JLabel("ATTENDEES");

    //6 ligne : attendees details
    JLabel attendeename = new JLabel("Name:");
    JTextField jtfattendeename = new JTextField(10);

    JLabel attendeefirstname = new JLabel("Firstname :");
    JTextField jtfattendeefirstname = new JTextField(10);

    JLabel attendeemail = new JLabel("Mail :");
    JTextField jtfattendeemail = new JTextField(20);

    JLabel attendeepresence = new JLabel("Present :");
    JCheckBox jcbatteddeepresent = new JCheckBox();
    //si "checked" string est set à présent.
    //****************************************************
    public void getjtfattendeedetails(linker link){
        link.addAttendees(jtfattendeename.getText(), jtfattendeefirstname.getText(), jtfattendeemail.getText(), presence);
        link.mergeAttendees();
    }

    //7 ligne : ***Recap***
    JLabel recap = new JLabel("MEETING REVIEW");

    //8 ligne : Recap detail
    JLabel topic = new JLabel("Meeting Topic");
    JTextArea topicarea = new JTextArea(10,20);
    JLabel decision = new JLabel("Decision");
    JTextArea decisionarea = new JTextArea(10,20);
    JLabel action = new JLabel("Action");
    JTextArea actionarea = new JTextArea(10,20);
    //****************************************************
    public void getjtftopicsdetails(linker link){
        link.addTopics(topicarea.getText(), decisionarea.getText(), actionarea.getText());
    }

    //9 ligne : Notes
    JLabel Notes = new JLabel("Notes");

    //10 ligne : Notesarea
    JTextArea Notesarea = new JTextArea(10,10);
    //****************************************************
    public void getnotes(linker link){
        link.setNotes(Notesarea.getText());
    }

    //11 boutton : Generate report
    JButton createreport = new JButton("CREATE REPORT");


    public Window(){
        this.setTitle("MY MEETING APP");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        panel.setLayout(new MigLayout());

        //Première ligne = Meeting informations
        panel.add(ProjectName,"split4");
        panel.add(txtprojectname, "pushx, growx");


        panel.add(number);
        panel.add(projectnamenumber, "pushx, growx, wrap");

        //Deuxieme ligne : meeting date
        panel.add(meetingdate,"split2");
        panel.add(datePicker,"wrap");

        //troisieme ligne : ****HOST****
        panel.add(host, "wrap");

        //quatrieme ligne : host details
        panel.add(hostname, "split6");
        panel.add(jtfhostname,"pushx, growx");
        panel.add(hostfirstname);
        panel.add(jtfhostfirstname,"pushx, growx");
        panel.add(hostmail);
        panel.add(jtfhostmail, "pushx, growx, wrap");

        //cinquieme ligne : attendees
        panel.add(attendees, "wrap");

        //sixieme ligne : attendees details
        panel.add(attendeename, "split8");
        panel.add(jtfattendeename,"pushx, growx");
        panel.add(attendeefirstname);
        panel.add(jtfattendeefirstname,"pushx, growx");
        panel.add(attendeemail);
        panel.add(jtfattendeemail, "pushx, growx");
        panel.add(attendeepresence);
        panel.add(jcbatteddeepresent, "pushx,wrap");

        //7 ligne : ***Recap****
        panel.add(recap, "wrap");

        //8 ligne : ***Recap detail****
        panel.add(new JScrollPane(topicarea), "split3");
        topicarea.setText("Meeting topic");
        panel.add(new JScrollPane(decisionarea));
        decisionarea.setText("Decision");
        panel.add(new JScrollPane(actionarea), "wrap");
        actionarea.setText("Action");

        //9 ligne : ***Notes****
        panel.add(Notes,"wrap");

        //10 ligne : ***Notes****
        panel.add(new JScrollPane(Notesarea), "growx, wrap");

        //11 ligne : ***Generate Report****
        panel.add(createreport, "growx, wrap");

        jcbatteddeepresent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jcbatteddeepresent.isSelected()) {
                    presence = true;
                } else {
                    presence = false;
                }
            }
        });

        createreport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cmpt = 0;
                linker link = new linker();
                getTxtprojectname(link);
                getprojectnamenumber(link);
                getdateofmeeting(link);
                getjtfattendeedetails(link);
                getjtfhostdetails(link);
                getjtftopicsdetails(link);
                getnotes(link);
                System.out.println(cmpt);

                if (cmpt == 0) {
                    pageLayout layout = new pageLayout(link);
                    System.out.println(cmpt);
                }
            }
        });
        panel.setOpaque(false);
        add(panel);
        pack();
        setVisible(true);
    }
}