package reportgenerator.window;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

    //Première ligne = Meeting informations
    JPanel panel = new JPanel();
    JLabel ProjectName = new JLabel("Project Name: ");
    JLabel number = new JLabel("Project number: ");
    JTextField txtprojectname = new JTextField(20);
    JTextField projectnamenumber = new JTextField(5);

    //Deuxieme ligne : meeting date
    JLabel meetingdate = new JLabel("Meeting Date :");
    JTextField dateofthemeeting = new JTextField(10);

    //troisieme ligne : ****HOST****
    JLabel host = new JLabel("HOST");

    //quatrieme ligne : host details
    JLabel hostname = new JLabel("Name:");
    JTextField jtfhostname = new JTextField(10);

    JLabel hostfirstname = new JLabel("Firstname :");
    JTextField jtfhostfirstname = new JTextField(10);

    JLabel hostmail = new JLabel("Mail :");
    JTextField jtfhostmail = new JTextField(20);

    //cinquieme ligne : Recap
    JLabel review = new JLabel("MEETING REVIEW");

    //sixieme ligne : Recap detail
    JLabel topic = new JLabel("Meeting Topic");
    JTextArea topicarea = new JTextArea(10,20);
    JLabel decision = new JLabel("Decision");
    JTextArea decisionarea = new JTextArea(10,20);
    JLabel action = new JLabel("Action");
    JTextArea actionarea = new JTextArea(10,20);

    //septieme ligne : Notes
    JLabel Notes = new JLabel("Notes");
    JTextArea Notesarea = new JTextArea(10,100);


    public Window(){

                this.setTitle("MY MEETING APP");

                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);

                panel.setLayout(new MigLayout());

                 //Première ligne = Meeting informations
                panel.add(ProjectName, "split4");
                panel.add(txtprojectname, "pushx, growx");
                panel.add(number,"split2");
                panel.add(projectnamenumber, "pushx, growx, wrap");
                //Deuxieme ligne : meeting date
                panel.add(meetingdate,"split2");
                panel.add(dateofthemeeting, "pushx, growx, wrap");
                //troisieme ligne : ****HOST****
                panel.add(host, "wrap");
                //quatrieme ligne : host details
                panel.add(hostname, "split6");
                panel.add(jtfhostname,"pushx, growx");
                panel.add(hostfirstname,"split2");
                panel.add(jtfhostfirstname,"pushx, growx");
                panel.add(hostmail,"split2");
                panel.add(jtfhostmail, "pushx, growx, wrap");
                //cinquieme ligne : ***Recap****
                panel.add(review, "wrap");
                 //sixieme ligne : ***Recap champs****
                panel.add(topic);
                panel.add(decision);
                panel.add(action, "wrap");
                //septieme ligne : ***Recap area****
                panel.add(new JScrollPane(topicarea), "pushx");
                panel.add(new JScrollPane(decisionarea), "pushx");
                panel.add(new JScrollPane(actionarea), "pushx, wrap");
                //septieme ligne : ***Notes****
                panel.add(Notes,"wrap");
                panel.add(new JScrollPane(Notesarea), "push");




                add(panel);
                pack();
                setVisible(true);



            }
        }

