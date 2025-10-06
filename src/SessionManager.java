import java.io.FileNotFoundException;
import java.util.Scanner;

public class SessionManager {
    private Integer numberOfMistakes;

    public SessionManager(){
        numberOfMistakes = 0;
    }

    private void addMistake(){
        numberOfMistakes++;
    }

    public void startGameSession() throws FileNotFoundException {
        try {
            HiddenWord hiddenWord = new HiddenWord();
            Scanner scanner = new Scanner(System.in);
            boolean validationError = false;
            while (true) {
                if (numberOfMistakes < 6){
                    Drawer.draw(numberOfMistakes);
                    System.out.println("Number of errors: " + numberOfMistakes);
                    System.out.println("Guessed letters: " + hiddenWord.getAlreadyGuessedLetters());
                    System.out.println("Hidden word: " + hiddenWord.getGuessedLetters());
                    if (validationError){
                        System.out.println("Wrong Input! Please enter a Cyrillic letter.");
                        validationError = false;
                    }
                    System.out.print("Enter a letter: ");
                    String userInput = scanner.nextLine();
                    if (validateUserInput(userInput)){
                        if (!hiddenWord.guessLetter(Character.toLowerCase(userInput.charAt(0)))) {
                            addMistake();
                        }
                    if (hiddenWord.isWordGuessed()){
                        System.out.println("The hidden word is " + hiddenWord.getHiddenWord());
                        System.out.println("You won!");
                        break;
                    }
                    } else {
                        validationError = true;
                    }
                } else {
                    Drawer.draw(numberOfMistakes);
                    System.out.println("You lost.");
                    System.out.println("The hidden word is " + hiddenWord.getHiddenWord());
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }

    public boolean validateUserInput(String userInput){
        return userInput.matches("[а-яА-ЯёЁ]");
    }
}

