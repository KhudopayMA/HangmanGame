import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameManager {
    public static void startGame(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("""
                    Please enter your choice:
                   
                    Y - Start Game
                    N - Quit Game
                   
                    Your choice is:\s""");
            String userInput = scanner.nextLine();
            if (userInput.equals("Y") | userInput.equals("y")){
                try {
                    SessionManager gameSession = new SessionManager();
                    gameSession.startGameSession();
                    System.out.println("-".repeat(100));
                } catch (FileNotFoundException e){
                    System.out.println("-".repeat(100));
                    System.out.println("File Words.txt with words not found.");
                    break;
                }
            } else if (userInput.equals("N") | userInput.equals("n")){
                System.out.println("-".repeat(100));
                System.out.println("You have left the game.");
                break;
            } else {
                System.out.println("-".repeat(100));
                System.out.println("Wrong choice!");
            }
        }
    }
}
