import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dictionary {
    private static final List<String> dictionary = new ArrayList<>();

    public static void createDictionaryFromFile() {
        String separator = File.separator;
        File file = new File("." + separator + "src" + separator + "Words.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String fileLine = scanner.nextLine();
                String[] fileLineWords = fileLine.split(", ");
                dictionary.addAll(Arrays.asList(fileLineWords));
            }
            if (dictionary.isEmpty()) {
                throw new RuntimeException();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException();
        }
    }

    public static String getRandomWord(){
            Random random = new Random();
            return dictionary.get(random.nextInt(dictionary.size())).toLowerCase();
        }
}
