package reportgenerator.window;

import net.miginfocom.swing.MigLayout;
import org.apache.commons.lang3.StringUtils;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import reportgenerator.pdfManager.Linker;
import reportgenerator.pdfLayout.PageLayout;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class Window extends JFrame {
    private ArrayList<MyAttendee> myAttendees = new ArrayList<>();
    private ArrayList<MyReviewPanel> myTopics = new ArrayList<>();
    private JPanel attendeespanel = new JPanel();
    private JPanel myreviewpanel = new JPanel();


    //****************************************************
    private JTextField txtprojectname = new JTextField("",20);
    private void getTxtprojectname(Linker link) {
        link.setProjectName(txtprojectname.getText());
    }


    //****************************************************
    private JTextField projectnamenumber = new JTextField("",3);
    private void getprojectnamenumber(Linker link){
        link.setMeetingNumber(projectnamenumber.getText());
    }


    //****************************************************
    private UtilDateModel model = new UtilDateModel(new Date());
    private JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
    private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());

    private void getdateofmeeting(Linker link){
        String value = datePicker.getModel().getValue().toString();
        String date = value.substring(0, StringUtils.ordinalIndexOf(value, " ", 3));
        link.setDate(date);
    }


    //****************************************************************
    private JTextField jtfhostname = new JTextField("",10);
    private JTextField jtfhostfirstname = new JTextField("",10);
    private JTextField jtfhostmail = new JTextField("",20);
    private void getjtfhostdetails(Linker link){
        link.addHost(jtfhostname.getText(), jtfhostfirstname.getText(), jtfhostmail.getText());
    }


    //6 ligne : attendees details voir classe MyAttendees
    private void getjtfattendeedetails(Linker link){
        for (MyAttendee myAttendee : myAttendees) {
            link.addAttendees(myAttendee.getJtfattendeename(), myAttendee.getJtfattendeefirstname(),
                    myAttendee.getJtfattendeemail(), myAttendee.isPresence());
        }
        link.mergeAttendees();
        myAttendees.clear();
    }

    //get topics
    private void getjtftopicsdetails(Linker link){
        for (MyReviewPanel myTopic : myTopics) {
            link.addTopics(myTopic.getTopicarea(), myTopic.getDecisionarea(),
                    myTopic.getActionarea());
        }
    }


    //10 ligne : Notesarea
    private JTextArea Notesarea = new JTextArea("",10,10);
    private void getnotes(Linker link){
        link.setNotes(Notesarea.getText());
    }


    //Constructeur
    public Window(){
        setTitle("MY MEETING APP");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Les panels
        JPanel mybigpanel = new JPanel();
        mybigpanel.setLayout(new MigLayout());

        JPanel myprojectpanel = new JPanel();
        myprojectpanel.setLayout(new MigLayout());

        JPanel attendeesplusplane = new JPanel();
        attendeesplusplane.setLayout(new MigLayout());

        attendeespanel.setLayout(new MigLayout());

        JPanel meetingreveiwpluspanel = new JPanel();
        meetingreveiwpluspanel.setLayout(new MigLayout());

        myreviewpanel.setLayout(new MigLayout());

        JPanel noteplusreportcreation = new JPanel();
        noteplusreportcreation.setLayout(new MigLayout());


        //Première ligne = Meeting informations
        JLabel projectName = new JLabel("Project Name: ");
        myprojectpanel.add(projectName,"split4");
        myprojectpanel.add(txtprojectname, "pushx");

        JLabel number = new JLabel("Project number: ");
        myprojectpanel.add(number);
        myprojectpanel.add(projectnamenumber, "pushx, wrap");


        //Deuxieme ligne : meeting date
        JLabel meetingdate = new JLabel("Meeting Date :");
        myprojectpanel.add(meetingdate,"split2");
        myprojectpanel.add(datePicker,"wrap");


        //troisieme ligne : ****HOST****
        JLabel host = new JLabel("HOST");
        myprojectpanel.add(host, "wrap");


        //quatrieme ligne : host details
        JLabel hostname = new JLabel("Name:");
        myprojectpanel.add(hostname, "split6");
        myprojectpanel.add(jtfhostname,"pushx, growx");
        JLabel hostfirstname = new JLabel("Firstname :");
        myprojectpanel.add(hostfirstname);
        myprojectpanel.add(jtfhostfirstname,"pushx, growx");
        JLabel hostmail = new JLabel("Mail :");
        myprojectpanel.add(hostmail);
        myprojectpanel.add(jtfhostmail, "pushx, growx, wrap");


        //cinquieme ligne : attendees
        JLabel attendees = new JLabel("ATTENDEES");
        attendeesplusplane.add(attendees);
        ImageIcon addimage = new ImageIcon("add.png");
        JButton addmoreattendee = new JButton(addimage);
        attendeesplusplane.add(addmoreattendee,"pushx, wrap");


        //sixieme ligne : attendees details
        MyAttendee myAttendee = new MyAttendee();
        attendeespanel.add(myAttendee, "wrap");
        myAttendees.add(myAttendee);


        //7 ligne : ***Recap****
        JLabel recap = new JLabel("MEETING REVIEW");
        meetingreveiwpluspanel.add(recap);
        ImageIcon addimage2 = new ImageIcon("add.png");
        JButton addmortopics = new JButton(addimage2);
        meetingreveiwpluspanel.add(addmortopics,"pushx, wrap");


        //8 ligne : ***Recap detail****
        MyReviewPanel myReviewPanel = new MyReviewPanel();
        myreviewpanel.add(myReviewPanel, "wrap");
        myTopics.add(myReviewPanel);


        //9 ligne : ***Notes****
        JLabel notes = new JLabel("Notes");
        noteplusreportcreation.add(notes,"wrap");


        //10 ligne : ***Notes****
        noteplusreportcreation.add(new JScrollPane(Notesarea), "split1, growx, pushx, wrap");


        //11 ligne : ***Generate Report****
        JButton createreport = new JButton("CREATE REPORT");
        noteplusreportcreation.add(createreport, "growx, wrap");


        createreport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Linker link = new Linker();
                getTxtprojectname(link);
                getprojectnamenumber(link);
                getdateofmeeting(link);
                getjtfattendeedetails(link);
                getjtfhostdetails(link);
                getjtftopicsdetails(link);
                getnotes(link);

                PageLayout layout = new PageLayout(link);
            }
        });


        addmoreattendee.addActionListener(e -> {
            MyAttendee myNextAttendee = new MyAttendee();
            attendeespanel.add(myNextAttendee, "wrap");
            myAttendees.add(myNextAttendee);
            setVisible(true);
        });


        addmortopics.addActionListener(e -> {
            MyReviewPanel myNextReviewPanel = new MyReviewPanel();
            myreviewpanel.add(myNextReviewPanel,"wrap");
            myTopics.add(myNextReviewPanel);
            setVisible(true);
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