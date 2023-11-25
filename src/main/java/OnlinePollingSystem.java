import java.util.*;

public class OnlinePollingSystem {
    public static void main(String[] args) {
        // Creating a sample poll
        List<String> options = Arrays.asList("Option A", "Option B", "Option C");
        Poll poll = new Poll("What is your preferred option?", options);

        // Simulating voting process
        Scanner scanner = new Scanner(System.in);
        boolean pollingActive = true;

        System.out.println("Welcome to the Online Polling System!");
        while (pollingActive) {
            System.out.println("Poll Question: " + poll.getQuestion());
            System.out.println("Options:");
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.println("Enter your choice (1-" + options.size() + ") or 'exit' to end: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                pollingActive = false;
            } else {
                try {
                    int choice = Integer.parseInt(userInput);
                    if (choice >= 1 && choice <= options.size()) {
                        poll.vote(options.get(choice - 1));
                    } else {
                        System.out.println("Invalid choice!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input!");
                }
            }
        }

        // Displaying results after polling ends
        poll.displayResults();
        scanner.close();
    }
}
