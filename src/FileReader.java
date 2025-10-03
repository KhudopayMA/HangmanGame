import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class FileReader {
    public static String getWordFromFile() throws FileNotFoundException {
        String separator = File.separator;
        File file = new File("." + separator + "src" + separator + "Words.txt");
        Scanner scanner = new Scanner(file);
        List<String> words = new ArrayList<>(0);
        while (scanner.hasNextLine()){
            String fileLine = scanner.nextLine();
            String[] fileLineWords =  fileLine.split(", ");
            for (String word: fileLineWords){
                words.add(word);
            }
        }
        if (words.isEmpty()){
            throw new FileNotFoundException();
        }
        Random random = new Random();
        return words.get(random.nextInt(words.size())).toLowerCase();
    }
}
