package reportgenerator.window;

import javax.swing.*;

public class MyAttendee extends JPanel{
    private boolean presence = false;

    private JLabel attendeename = new JLabel("Name:");
    private JTextField jtfattendeename = new JTextField("",10);

    private JLabel attendeefirstname = new JLabel("Firstname :");
    private JTextField jtfattendeefirstname = new JTextField("",10);

    private JLabel attendeemail = new JLabel("Mail :");
    private JTextField jtfattendeemail = new JTextField("",10);

    private JLabel attendeepresence = new JLabel("Present :");
    private JCheckBox jcbatteddeepresent = new JCheckBox();


    public MyAttendee() {
        MyAttendee myAttendeepanel = this;
        add(attendeename, "split9");
        add(jtfattendeename);
        add(attendeefirstname);
        add(jtfattendeefirstname);
        add(attendeemail);
        add(jtfattendeemail);
        add(attendeepresence);
        add(jcbatteddeepresent,"wrap");

        jcbatteddeepresent.addActionListener(e -> {
            if (jcbatteddeepresent.isSelected()) {
                presence = true;
            } else {
                presence = false;
            }
        });
    }

    public String getJtfattendeename() {
        return jtfattendeename.getText();
    }

    public String getJtfattendeefirstname() {
        return jtfattendeefirstname.getText();
    }

    public String getJtfattendeemail() {
        return jtfattendeemail.getText();
    }

    public boolean isPresence() {
        return presence;
    }
}
