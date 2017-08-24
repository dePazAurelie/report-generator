package reportgenerator.window;

import javax.swing.*;

public class MyAttendee extends JPanel{

    int myattendeepanelnumber = 0;
    MyAttendee myAttendeepanel;

    JLabel attendeename = new JLabel("Name:");
    JTextField jtfattendeename = new JTextField(10);

    JLabel attendeefirstname = new JLabel("Firstname :");
    JTextField jtfattendeefirstname = new JTextField(10);

    JLabel attendeemail = new JLabel("Mail :");
    JTextField jtfattendeemail = new JTextField(10);

    JLabel attendeepresence = new JLabel("Present :");
    JCheckBox jcbatteddeepresent = new JCheckBox();


    public MyAttendee() {

        myAttendeepanel = this;
        setOpaque(false);
        add(attendeename, "split9");
        add(jtfattendeename);
        add(attendeefirstname);
        add(jtfattendeefirstname);
        add(attendeemail);
        add(jtfattendeemail);
        add(attendeepresence);
        add(jcbatteddeepresent,"wrap");
        myattendeepanelnumber++;
    }
}
