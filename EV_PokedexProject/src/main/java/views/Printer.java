package views;

import models.Pokemon;
import services.HTTPRequest;
import services.SQLLite;

public class Printer {
    public static int run(Pokemon mp, int i, int db ) {
        System.out.println("=========================="); // debugging
        System.out.println("Printer running ");
        System.out.println("==========================");
        if (db == 1) { // if requested, the method use the HTTP source
            HTTPRequest.run(mp, i);
            System.out.println("==========================");
            System.out.println("Pokémon # " + mp.getId());
            System.out.println("Name : " + mp.getName());
            System.out.println("Height : " + mp.getHeight());
            System.out.println("Weight : " + mp.getWeight());
            System.out.println("==========================");
            String msg = "<h1>" + mp.getName() + "</h1>\n"
                    + "<ul>\n" +
                    "<li> Id : " + mp.getId() + "<li>\n"
                    + "<li> Height : " + mp.getHeight() + "<li>\n" +
                    "<li> Weight : " + mp.getWeight() + "<li>\n"
                    + "<li> Description : " + mp.getDescription() + "<li>\n" +
                    "</ul>";
            return db ;
        }
        if (db == 2) { // if requested, the method use the SQL source
            SQLLite.run(mp, i);
            System.out.println("==========================");
            System.out.println("Pokémon # " + mp.getId());
            System.out.println("Name : " + mp.getName());
            System.out.println("Height : " + mp.getHeight());
            System.out.println("Weight : " + mp.getWeight());
            System.out.println("Description : " + mp.getDescription());
            System.out.println("==========================");
            return db;
        }
        if (db == 0 ) { // if requested, no database is used and the program ends
            System.out.println("You had decided to leave :(. Thanks for visiting the Pokedex, see you soon !");
            return db;
        }
        else { // if the input is not valid, returns a value that keeps a loop
            System.out.println("The input is not valid, try again");
            return  -1;
        }
    }
}
