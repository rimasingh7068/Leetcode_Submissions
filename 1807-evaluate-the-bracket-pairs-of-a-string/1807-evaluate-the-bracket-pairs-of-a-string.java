import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // Step 1: Populate the knowledge base into a HashMap
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        StringBuilder keyBuilder = new StringBuilder();
        boolean insideBracket = false;

        // Step 2: Iterate through the string s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                insideBracket = true;
            } else if (c == ')') {
                insideBracket = false;
                String key = keyBuilder.toString();
                // Replace with value if found, otherwise '?'
                result.append(map.getOrDefault(key, "?"));
                keyBuilder.setLength(0); // Reset key buffer
            } else {
                if (insideBracket) {
                    keyBuilder.append(c);
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}