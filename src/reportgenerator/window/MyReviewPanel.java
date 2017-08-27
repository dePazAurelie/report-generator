package reportgenerator.window;

import javax.swing.*;

public class MyReviewPanel extends JPanel{
    JTextArea topicarea;
    JTextArea decisionarea;
    JTextArea actionarea;

    public MyReviewPanel() {
        MyReviewPanel myreviewpanel = this;
        JScrollPane fortopic = new JScrollPane(topicarea);
        fortopic.setHorizontalScrollBarPolicy(fortopic.HORIZONTAL_SCROLLBAR_NEVER);


        topicarea = new JTextArea("",10,20);
        decisionarea = new JTextArea("",10,20);
        actionarea = new JTextArea("",10,20);

        topicarea.setText("Meeting topic");
        add(new JScrollPane(topicarea), "split3");
        decisionarea.setText("Decision");
        add(new JScrollPane(decisionarea));
        actionarea.setText("Action");
        add(new JScrollPane(actionarea), "wrap");
    }

    public String getTopicarea() {
        return topicarea.getText();
    }

    public String getDecisionarea() {
        return decisionarea.getText();
    }

    public String getActionarea() {
        return actionarea.getText();
    }
}
