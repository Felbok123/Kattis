package engineering;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class EngineeringEnglish {

    public static void main(String[] args) {

        Kattio io = new Kattio(System.in, System.out);
        HashSet<String> checkSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> words = new ArrayList<>();

        String readLine = io.getWord();

        while (readLine != null) {

            String currentWord = readLine;

            String[] line = currentWord.split("\\s+");
            Collections.addAll(words, line);
            readLine = io.getWord();

        }
        for (String word : words) {
            if (checkSet.contains(word.toLowerCase())) {
                sb.append(". ");
                checkSet.add(word.toLowerCase());

            } else {
                sb.append(word).append(" ");
                checkSet.add(word.toLowerCase());
            }
        }

        io.print(sb.toString());
        io.close();
    }
}
