package reportgenerator.window;

import net.miginfocom.swing.MigLayout;
import org.apache.commons.lang3.StringUtils;
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

    private JPanel mybigpanel = new JPanel();

    private JPanel myprojectpanel = new JPanel();
    private JPanel attendeesplusplane = new JPanel();
    private JPanel attendeespanel = new JPanel();
    private JPanel meetingreveiwpluspanel = new JPanel();
    private JPanel myreviewpanel = new JPanel();
    private JPanel noteplusreportcreation = new JPanel();

    private boolean presence = false;

    //1 ligne = Meeting informations
    private JLabel ProjectName = new JLabel("Project Name: ");
    private JLabel number = new JLabel("Project number: ");

    //****************************************************
    private JTextField txtprojectname = new JTextField("",20);

    private void getTxtprojectname(linker link) {
        link.setProjectName(txtprojectname.getText());
    }

    //****************************************************
    private JTextField projectnamenumber = new JTextField("",3);
    private void getprojectnamenumber(linker link){
        link.setMeetingNumber(projectnamenumber.getText());
    }

    //2 ligne : meeting date
    private JLabel meetingdate = new JLabel("Meeting Date :");

    //****************************************************
    private UtilDateModel model = new UtilDateModel(new Date());
    private JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
    private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());

    private void getdateofmeeting(linker link){
        String value = datePicker.getModel().getValue().toString();
        String date = value.substring(0, StringUtils.ordinalIndexOf(value, " ", 3));
        link.setDate(date);
    }

    //3 ligne : ****HOST****
    private JLabel host = new JLabel("HOST");

    //4 ligne : host details
    private JLabel hostname = new JLabel("Name:");
    private JTextField jtfhostname = new JTextField("",10);


    private JLabel hostfirstname = new JLabel("Firstname :");
    private JTextField jtfhostfirstname = new JTextField("",10);

    private JLabel hostmail = new JLabel("Mail :");
    private JTextField jtfhostmail = new JTextField("",20);

    //****************************************************
    private void getjtfhostdetails(linker link){
        link.addHost(jtfhostname.getText(), jtfhostfirstname.getText(), jtfhostmail.getText());
    }

    //5 ligne : **ATTENDEES**
    private JLabel attendees = new JLabel("ATTENDEES");

    //6 ligne : attendees details
    private JLabel attendeename = new JLabel("Name:");
    private JTextField jtfattendeename = new JTextField("",10);

    private JLabel attendeefirstname = new JLabel("Firstname :");
    private JTextField jtfattendeefirstname = new JTextField("",10);

    private JLabel attendeemail = new JLabel("Mail :");
    private JTextField jtfattendeemail = new JTextField("",10);

    private JLabel attendeepresence = new JLabel("Present :");
    private JCheckBox jcbatteddeepresent = new JCheckBox();

    //****************************************************
    private void getjtfattendeedetails(linker link){
        link.addAttendees(jtfattendeename.getText(), jtfattendeefirstname.getText(), jtfattendeemail.getText(), presence);
        link.mergeAttendees();
    }

    private ImageIcon addimage = new ImageIcon("/Users/charles/Desktop/Formation Epitech/report-generator/src/Ressources/add.png");
    private JButton addmoreattendee = new JButton(addimage);

    private ImageIcon addimage2 = new ImageIcon("/Users/charles/Desktop/Formation Epitech/report-generator/src/Ressources/add.png");
    private JButton addmortopics = new JButton(addimage2);

    //7 ligne : ***Recap***
    private JLabel recap = new JLabel("MEETING REVIEW");

    //8 ligne : Recap detail
    private JLabel topic = new JLabel("Meeting Topic");
    private JTextArea topicarea = new JTextArea("",10,20);
    private JLabel decision = new JLabel("Decision");
    private JTextArea decisionarea = new JTextArea("",10,20);
    private JLabel action = new JLabel("Action");
    private JTextArea actionarea = new JTextArea("",10,20);

    //****************************************************
    private void getjtftopicsdetails(linker link){
        link.addTopics(topicarea.getText(), decisionarea.getText(), actionarea.getText());
    }

    //9 ligne : Notes
    private JLabel Notes = new JLabel("Notes");

    //10 ligne : Notesarea
    private JTextArea Notesarea = new JTextArea("",10,10);
    //****************************************************
    private void getnotes(linker link){
        link.setNotes(Notesarea.getText());
    }

    //11 boutton : Generate report
    private JButton createreport = new JButton("CREATE REPORT");


    public Window(){
        setTitle("MY MEETING APP");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mybigpanel.setLayout(new MigLayout());
        myprojectpanel.setLayout(new MigLayout());
        attendeesplusplane.setLayout(new MigLayout());
        attendeespanel.setLayout(new MigLayout());
        meetingreveiwpluspanel.setLayout(new MigLayout());
        myreviewpanel.setLayout(new MigLayout());
        noteplusreportcreation.setLayout(new MigLayout());

        //Première ligne = Meeting informations
        myprojectpanel.add(ProjectName,"split4");
        myprojectpanel.add(txtprojectname, "pushx");
        myprojectpanel.add(number);
        myprojectpanel.add(projectnamenumber, "pushx, wrap");

        //Deuxieme ligne : meeting date
        myprojectpanel.add(meetingdate,"split2");
        myprojectpanel.add(datePicker,"wrap");

        //troisieme ligne : ****HOST****
        myprojectpanel.add(host, "wrap");

        //quatrieme ligne : host details
        myprojectpanel.add(hostname, "split6");
        myprojectpanel.add(jtfhostname,"pushx, growx");
        myprojectpanel.add(hostfirstname);
        myprojectpanel.add(jtfhostfirstname,"pushx, growx");
        myprojectpanel.add(hostmail);
        myprojectpanel.add(jtfhostmail, "pushx, growx, wrap");

        //cinquieme ligne : attendees
        attendeesplusplane.add(attendees);
        attendeesplusplane.add(addmoreattendee,"pushx, wrap");

        //sixieme ligne : attendees details
        attendeespanel.add(new MyAttendee(), "wrap");
        attendeespanel.add(new MyAttendee(), "wrap");
        attendeespanel.add(attendeename, "split8");
        attendeespanel.add(jtfattendeename,"pushx, growx");
        attendeespanel.add(attendeefirstname);
        attendeespanel.add(jtfattendeefirstname,"pushx, growx");
        attendeespanel.add(attendeemail);
        attendeespanel.add(jtfattendeemail, "pushx, growx");
        attendeespanel.add(attendeepresence);
        attendeespanel.add(jcbatteddeepresent, "pushx,wrap");

        //7 ligne : ***Recap****
        meetingreveiwpluspanel.add(recap);
        meetingreveiwpluspanel.add(addmortopics,"pushx, wrap");

        //8 ligne : ***Recap detail****
        topicarea.setText("Meeting topic");
        JScrollPane fortopic = new JScrollPane(topicarea);
        fortopic.setHorizontalScrollBarPolicy(fortopic.HORIZONTAL_SCROLLBAR_NEVER);
        myreviewpanel.add(fortopic, "split3");
        decisionarea.setText("Decision");
        myreviewpanel.add(new JScrollPane(decisionarea));
        actionarea.setText("Action");
        myreviewpanel.add(new JScrollPane(actionarea), "wrap");

        //9 ligne : ***Notes****
        noteplusreportcreation.add(Notes,"wrap");

        //10 ligne : ***Notes****
        noteplusreportcreation.add(new JScrollPane(Notesarea), "split1, growx, pushx, wrap");

        //11 ligne : ***Generate Report****
        noteplusreportcreation.add(createreport, "growx, wrap");

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
            linker link = new linker();
            @Override
            public void actionPerformed(ActionEvent e) {
                getTxtprojectname(link);
                getprojectnamenumber(link);
                getdateofmeeting(link);
                getjtfattendeedetails(link);
                getjtfhostdetails(link);
                getjtftopicsdetails(link);
                getnotes(link);

                pageLayout layout = new pageLayout(link);
            }
        });

        addmoreattendee.addActionListener(e -> {
            attendeespanel.add(new MyAttendee(), "wrap");
        });

        addmortopics.addActionListener(e -> {
            myreviewpanel.add(new MyReviewPanel(),"wrap");
        });

        //CONFIGURATION GéNéRALE DE LA FENETRE
        JScrollPane scrollpane = new JScrollPane(mybigpanel);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollpane);

        mybigpanel.add(myprojectpanel,"wrap");
        mybigpanel.add(attendeesplusplane,"wrap");
        mybigpanel.add(attendeespanel,"wrap");
        mybigpanel.add(meetingreveiwpluspanel,"wrap");
        mybigpanel.add(myreviewpanel,"wrap");
        mybigpanel.add(noteplusreportcreation,"growx, wrap");

        setVisible(true);
        pack();
    }
}