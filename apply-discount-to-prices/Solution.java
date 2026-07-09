import java.util.regex.*;

class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            if (word.startsWith("$") && word.length() > 1 && word.substring(1).matches("\\d+")) {
                double price = Double.parseDouble(word.substring(1));
                double discountedPrice = price * (1 - discount / 100.0);
                result.append(String.format("$%.2f ", discountedPrice));
            } else {
                result.append(word).append(" ");
            }
        }
        
        return result.toString().trim();
    }
}