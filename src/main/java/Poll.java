import java.util.*;

public class Poll {
    private String question;
    private List<String> options;
    private Map<String, Integer> votes;

    public Poll(String question, List<String> options) {
        this.question = question;
        this.options = options;
        this.votes = new HashMap<>();
        initializeVotes();
    }

    private void initializeVotes() {
        for (String option : options) {
            votes.put(option, 0);
        }
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void vote(String option) {
        if (votes.containsKey(option)) {
            votes.put(option, votes.get(option) + 1);
            System.out.println("Voted for " + option);
        } else {
            System.out.println("Invalid option!");
        }
    }

    public void displayResults() {
        System.out.println("Poll Question: " + question);
        System.out.println("Options:");
        for (String option : options) {
            System.out.println(option + " : " + votes.get(option) + " votes");
        }
    }
}
