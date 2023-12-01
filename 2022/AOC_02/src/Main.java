import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
//    static Map<String, String> opponentActions{
//
//    };
    static Map<String, String> draw = new HashMap<String, String>()
    {{
        put("A", "A");
        put("B", "B");
        put("C", "C");
    }};
    static Map<String, String> win = new HashMap<String, String>()
    {{
        put("A", "B");
        put("B", "C");
        put("C", "A");
    }};
    static Map<String, String> lose = new HashMap<String, String>()
    {{
        put("A", "C");
        put("B", "A");
        put("C", "B");
    }};
    static Map<String, Integer> myActions = new HashMap<String, Integer>()
    {{
        put("A", 1);
        put("B", 2);
        put("C", 3);
    }};

    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            int result = 0;
            while (line != null) {
                String[] parts = line.split(" ");
                switch (parts[1]) {
                    case "X":
                        result += myActions.get(lose.get(parts[0]));
                        break;
                    case "Y":
                        result += 3 + myActions.get(draw.get(parts[0]));
                        break;
                    case "Z":
                        result += 6 + myActions.get(win.get(parts[0]));
                        break;
                }
                line = reader.readLine();
            }
            System.out.println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}