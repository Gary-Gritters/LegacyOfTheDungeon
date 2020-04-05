package PlayerCharacter;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input character name: ");
        PlayerCharacter.setCharName(scanner.next());

    }
}
