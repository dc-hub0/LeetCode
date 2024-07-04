import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> lineWords = new ArrayList<>();
        int lineLength = 0;
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            if (!lineWords.isEmpty() && lineLength + lineWords.size() + word.length() > maxWidth) {
                StringBuilder lineBuilder = new StringBuilder();
                int spacesNeeded = maxWidth - lineLength;
                int slots = lineWords.size() - 1;
                
                if (slots == 0) {
                    lineBuilder.append(lineWords.get(0));
                    lineBuilder.append(" ".repeat(spacesNeeded));
                } else {
                    int baseSpaces = spacesNeeded / slots;
                    int extraSpaces = spacesNeeded % slots;
                    
                    for (int j = 0; j < lineWords.size() - 1; j++) {
                        lineBuilder.append(lineWords.get(j));
                        lineBuilder.append(" ".repeat(baseSpaces));
                        if (j < extraSpaces) {
                            lineBuilder.append(" ");
                        }
                    }
                    lineBuilder.append(lineWords.get(lineWords.size() - 1));
                }
                
                result.add(lineBuilder.toString());
                lineWords.clear();
                lineLength = 0;
            }
            
            lineWords.add(word);
            lineLength += word.length();
        }
        
        // Last line
        if (!lineWords.isEmpty()) {
            StringBuilder lastLine = new StringBuilder();
            for (int i = 0; i < lineWords.size(); i++) {
                lastLine.append(lineWords.get(i));
                if (i < lineWords.size() - 1) {
                    lastLine.append(" ");
                }
            }
            lastLine.append(" ".repeat(maxWidth - lastLine.length()));
            result.add(lastLine.toString());
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth1 = 16;
        List<String> result1 = solution.fullJustify(words1, maxWidth1);
        for (String line : result1) {
            System.out.println(line);
        }
        
        String[] words2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth2 = 16;
        List<String> result2 = solution.fullJustify(words2, maxWidth2);
        for (String line : result2) {
            System.out.println(line);
        }
        
        String[] words3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth3 = 20;
        List<String> result3 = solution.fullJustify(words3, maxWidth3);
        for (String line : result3) {
            System.out.println(line);
        }
    }
}
