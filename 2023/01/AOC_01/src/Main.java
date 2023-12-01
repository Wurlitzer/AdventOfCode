import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class Main {
    static List<String> allowedStrings = Arrays.asList
            (
                    "one","two","three","four","five","six","seven",
                    "eight","nine"
            );
    public static void main(String[] args) throws IOException {

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            int result = 0;
            while (line != null) {
                //List<Integer> intList = new ArrayList<>();
                System.out.println("Input: " + line);

                line = convertToInt(line);
                System.out.println("after conversion: " + line);

                line = line.replaceAll("[^0-9]+", "");
                System.out.println("Nums: " + line);
                line = line.replace("", " ").trim();
                System.out.println("Nums /w space: " + line);

                String[] parts = line.split(" ");
                int[] numsInString = new int[parts.length];
                for(int n = 0; n < parts.length; n++) {
                    numsInString[n] = Integer.parseInt(parts[n]);
                }
                result += Integer.parseInt(Integer.toString(numsInString[0]) + Integer.toString(numsInString[numsInString.length-1]));
                System.out.println("First num: " + numsInString[0]);
                System.out.println("Last num: " + numsInString[numsInString.length-1]);
                System.out.println("result: " + result);
                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = "qtwonetwodgbhqmtzf82onefive48";

    }

    static String convertToInt(String input){
        String out = "";

        for (int i = 0; i < allowedStrings.size(); i++)
        {
            input = input.replaceAll(allowedStrings.get(i), allowedStrings.get(i).charAt(0) + String.valueOf(i+1) + allowedStrings.get(i).charAt(allowedStrings.get(i).length()-1));
        }
        return input;
    }
}