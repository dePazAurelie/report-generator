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

    JPanel mybigpanel = new JPanel();

    JPanel myprojectpanel = new JPanel();
    JPanel attendeesplusplane = new JPanel();
    JPanel attendeespanel = new JPanel();
    JPanel meetingreveiwpluspanel = new JPanel();
    JPanel myreviewpanel = new JPanel();
    JPanel noteplusreportcreation = new JPanel();

    boolean presence= false;
    int cmpt = 0;

    //1 ligne = Meeting informations
    JLabel ProjectName = new JLabel("Project Name: ");
    JLabel number = new JLabel("Project number: ");

    //****************************************************
    JTextField txtprojectname = new JTextField(20);
    //public void getTxtprojectname(linker link){
    //    link.setProjectName(txtprojectname.getText());
    //}

    private void getTxtprojectname(linker link) {
        link.setProjectName(txtprojectname.getText());
    }

    //****************************************************
    JTextField projectnamenumber = new JTextField(3);
    public void getprojectnamenumber(linker link){
        link.setMeetingNumber(projectnamenumber.getText());
    }

    //2 ligne : meeting date
    JLabel meetingdate = new JLabel("Meeting Date :");

    //****************************************************
    UtilDateModel model = new UtilDateModel();
    JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties());
    JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());

    public void getdateofmeeting(linker link){
        String value = datePicker.getModel().getValue().toString();
        String date = value.substring(0, StringUtils.ordinalIndexOf(value, " ", 3));
      
        Object s = datePicker.getModel().getValue();
        if (s == null) {
            link.setDate(new Date().toString());
        } else {
            link.setDate(date);
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
    public void getjtfhostdetails(linker link){
        link.addHost(jtfhostname.getText(), jtfhostfirstname.getText(), jtfhostmail.getText());
    }

    //5 ligne : **ATTENDEES**
    JLabel attendees = new JLabel("ATTENDEES");

    //6 ligne : attendees details
    JLabel attendeename = new JLabel("Name:");
    JTextField jtfattendeename = new JTextField(10);

    JLabel attendeefirstname = new JLabel("Firstname :");
    JTextField jtfattendeefirstname = new JTextField(10);

    JLabel attendeemail = new JLabel("Mail :");
    JTextField jtfattendeemail = new JTextField(10);

    JLabel attendeepresence = new JLabel("Present :");
    JCheckBox jcbatteddeepresent = new JCheckBox();
    //si "checked" string est set à présent.
    //****************************************************
    public void getjtfattendeedetails(linker link){
        link.addAttendees(jtfattendeename.getText(), jtfattendeefirstname.getText(), jtfattendeemail.getText(), presence);
        link.mergeAttendees();
    }

    ImageIcon addimage = new ImageIcon("/Users/charles/Desktop/Formation Epitech/report-generator/src/Ressources/add.png");
    JButton addmoreattendee = new JButton(addimage);

    ImageIcon addimage2 = new ImageIcon("/Users/charles/Desktop/Formation Epitech/report-generator/src/Ressources/add.png");
    JButton addmortopics = new JButton(addimage2);

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

                if (cmpt == 0) {
                    pageLayout layout = new pageLayout(link);
                }
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