package reportgenerator.window;

import javax.swing.*;

public class MyReviewPanel extends JPanel{

    MyReviewPanel myreviewpanel;

    int myreviewpanelnumber = 0;

    JLabel topic = new JLabel("Meeting Topic");
    JTextArea topicarea = new JTextArea(10,20);
    JLabel decision = new JLabel("Decision");
    JTextArea decisionarea = new JTextArea(10,20);
    JLabel action = new JLabel("Action");
    JTextArea actionarea = new JTextArea(10,20);


    public MyReviewPanel() {

        myreviewpanel = this;
        setOpaque(false);

        topicarea.setText("Meeting topic");
        add(new JScrollPane(topicarea), "split3");
        decisionarea.setText("Decision");
        add(new JScrollPane(decisionarea));
        actionarea.setText("Action");
        add(new JScrollPane(actionarea), "wrap");

        myreviewpanelnumber++;

    }

}
