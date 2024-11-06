// Use linked hash set and remove the duplicate char in the string name = "Java for Testing"


import java.util.LinkedHashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String name = "Java for Testing";
        LinkedHashSet<Character> charSet = new LinkedHashSet<>();

        // Add each character to the LinkedHashSet
        for (char c : name.toCharArray()) {
            charSet.add(c);
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (char c : charSet) {
            result.append(c);
        }

        System.out.println("String after removing duplicates: " + result.toString());
    }
}

// Explanation:
// LinkedHashSet: This collection allows you to store characters while maintaining their insertion order and automatically handles duplicates.
// StringBuilder: Used to efficiently build the final string without duplicates.
// When you run this code, it will output:
// String after removing duplicates: jav for tesing
