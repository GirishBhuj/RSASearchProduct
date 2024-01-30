package Learning;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SecondHighestOccurrence {
    public static void main(String[] args) {
        String inputString = "Banana";
        char secondHighestOccurrence = findSecondHighestOccurrence(inputString);
        System.out.println("Second highest occurrence: " + secondHighestOccurrence);
    }

    private static char findSecondHighestOccurrence(String input) {
        // Remove spaces and convert the string to lowercase for case-insensitive comparison
        input = input.replaceAll("\\s", "").toLowerCase();

        // Create a map to store the count of each character
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Populate the map with character occurrences
        for (char c : input.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Find the maximum and second maximum occurrences
        int maxCount = 0;
        int secondMaxCount = 0;
        char maxChar = 0;
        char secondMaxChar = 0;

        for (Entry<Character, Integer> entry : charCountMap.entrySet()) {
            int count = entry.getValue();
            if (count > maxCount) {
                secondMaxCount = maxCount;
                secondMaxChar = maxChar;
                maxCount = count;
                maxChar = entry.getKey();
            } else if (count > secondMaxCount && count != maxCount) {
                secondMaxCount = count;
                secondMaxChar = entry.getKey();
            }
        }

        return secondMaxChar;
    }
}
