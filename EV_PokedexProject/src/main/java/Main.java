import models.Pokemon;

import utilities.FileLogger;
import utilities.Logger;
import utilities.LoggerHTMLDecorator;

import views.HtmlGeneratorInterface;
import views.Printer;
import views.FileHTMLLogger;
import views.PrinterHTML;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        int interested = 1; // initializing the next loop variable
        System.out.print("Welcome to the Pokedex ! \n");
        while (interested != 0) { // while not "uninterested"
            Scanner sc = new Scanner(System.in); //System.in is a standard input stream
            if (interested == 2) { // message after the first pass through the loop
                int c = 3; // initializing the next loop variable
                while (c != 1 && c != 0) { // loop while not valid input
                    System.out.print("Would you like to search another Pokémon ? Yes(1) / No (0) : ");
                    c = sc.nextInt(); // reads int. if 1 do nothing in the current loop
                    System.out.print("You have entered: " + c + "\n");
                    if (c == 0) { // if the user wants to leave, break the loop. Ends up ending the program
                        interested = 0;
                        System.out.println("You had decided to leave :(. " +
                                "Thanks for visiting the Pokedex, see you soon !");
                        break;
                    }
                    if (c != 1 && c != 0) { // if the input is not valid
                        System.out.print("The input : " + c + " is not valid, try again \n");
                    }
                }
            }
            if (interested != 0) { // if still interested, ask for a Pokémon index to search. if not, end the program
                System.out.print("Enter an integer for the Pokémon index : ");
                int i = sc.nextInt(); // reads int
                System.out.print("You have entered: " + i + "\n");
                System.out.println("==========================");
                interested = 2; // set that the next Pokémon is not the first one searched
                int rp = -1;
                String gt = null;
                while (rp == -1) {
                    System.out.print("\n Would you like to read the data from api (1) or sql (2)," + //ask for db source
                            " if you want to exit put (0): ");
                    int db = sc.nextInt(); //reads string
                    System.out.print("You have entered: " + db + "\n");
                    Pokemon mp = new Pokemon();
                    rp = Printer.run(mp, i, db); // Print generator
                    Logger logger = new FileLogger();
                    // log
                    logger = new LoggerHTMLDecorator(logger);
                    String msg = PrinterHTML.getHTML(mp, i, db);
                    logger.log(msg);
                    // log
                    if (rp == 0) {
                        interested = 0; // if 0 returned, we break the current loop and end the program
                        break;
                    }
                }
            }
        }
    }
}
