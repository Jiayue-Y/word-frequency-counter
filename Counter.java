import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Counter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> wordCountMap = new HashMap<>();
        String text = "";

        do {
            System.out.println("Enter any texts (Enter 'exit' to exit): ");
            text = sc.nextLine().toLowerCase()
                    .replaceAll("[^a-zA-Z0-9\\s]", "");

            if (!text.equals("exit")) {
                //Convert all text to lower case
                String[] words = text.split("\\s+"); // Split into words

                for (String word : words)
                    if (!word.isEmpty()) { // Ignore empty strings
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
            }
        } while (!text.equals("exit"));

        sc.close();

        TreeMap<String, Integer> sortedMap = new TreeMap<>(wordCountMap);

        System.out.println("\nWord Frequencies:");
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nThanks for using word frequency counter!");
    }
}
