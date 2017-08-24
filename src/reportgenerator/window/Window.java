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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

public class Window extends JFrame {

    String presence= "";
    ImageIcon imageIcon = new ImageIcon("c:/Users/Aurélie de Paz/Desktop/report-generator/src/reportgenerator/window/Ressources/calming.gif"); // here your Image Path
    JLabel background=new JLabel(imageIcon);

    JPanel panel = new JPanel();

    //1 ligne = Meeting informations
    JLabel ProjectName = new JLabel("Project Name: ");
    JLabel number = new JLabel("Project number: ");

    //****************************************************
    JTextField txtprojectname = new JTextField(20);
    public void getTxtprojectname(linker link){
        link.setProjectName(txtprojectname.getText());
    }

    //****************************************************
    JTextField projectnamenumber = new JTextField(5);
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
        link.setDate(((Date) datePicker.getModel().getValue()).toString());
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
    JTextField jtfattendeemail = new JTextField(20);

    JLabel attendeepresence = new JLabel("Present :");
    JCheckBox jcbatteddeepresent = new JCheckBox();
    //si "checked" string est set à présent.
    //****************************************************
    public void getjtfattendeedetails(linker link){
        link.addAttendees(jtfattendeename.getText(), jtfattendeefirstname.getText(), jtfattendeemail.getText(), presence);
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
                add(background);
                background.setLayout(new FlowLayout());

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
                        String presence = "présent";
                    }
                });

                createreport.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        linker link = new linker();
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


                panel.setOpaque(false);

                background.add(panel);
                pack();
                setVisible(true);



            }
        }

