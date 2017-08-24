package reportgenerator.pdfManager;

public class topic {

    private String topic;
    private String decision;
    private String outcome;

    public topic(String topic, String decision, String outcome) {
        this.topic = topic;
        this.decision = decision;
        this.outcome = outcome;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }
}
