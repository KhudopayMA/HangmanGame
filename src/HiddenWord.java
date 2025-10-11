import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HiddenWord {
    private final String hiddenWord;
    private final List<Character> guessedLetters;
    private final Set<Character> alreadyGuessedLetters;

    public HiddenWord() throws FileNotFoundException {
        this.hiddenWord = Dictionary.getRandomWord();
        this.guessedLetters = new ArrayList<>(this.hiddenWord.length());
        for (int index = 0; index < this.hiddenWord.length(); index++) {
            guessedLetters.add('_');
        }
        this.alreadyGuessedLetters = new HashSet<>();
    }

    public String getHiddenWord(){
        return hiddenWord;
    }

    public String getGuessedLetters(){
        StringBuilder sb = new StringBuilder(guessedLetters.size());
        for (char letter: guessedLetters){
            sb.append(letter);
        }
        return sb.toString();
    }

    public String getAlreadyGuessedLetters(){
        return alreadyGuessedLetters.toString();
    }

    public boolean guessLetter(char letter){
        if (alreadyGuessedLetters.contains(letter)){
            return true;
        }
        boolean letterWasFound = false;
        for (int index = 0; index < this.hiddenWord.length(); index++) {
            if (hiddenWord.charAt(index) == letter){
                if (!letterWasFound){
                    letterWasFound = true;
                    alreadyGuessedLetters.add(letter);
                }
                guessedLetters.set(index, letter);
            }
        }
        return letterWasFound;
    }

    public boolean isWordGuessed(){
        for (char letter: guessedLetters){
            if (hiddenWord.indexOf(letter) == -1){
                return false;
            }
        }
        return true;
    }

}
