import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            List<Integer> combinedCalories = new ArrayList<>();
            List<Integer> topCalories = new ArrayList<>();
            int result = 0;
            while (line != null) {
                if(line.isEmpty()){
                    System.out.println("New Elf");
                    combinedCalories.add(result);
                    result = 0;
                }
                else {
                    result += Integer.parseInt(line);
                }
                line = reader.readLine();
            }
            for(int i = 0; i < 3; i++){
                topCalories.add(Collections.max(combinedCalories));
                combinedCalories.remove(Collections.max(combinedCalories));
            }
            topCalories.forEach(System.out::println);
            System.out.println("Top 3 calories combined: " + topCalories.stream().mapToInt(Integer::valueOf).sum());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}