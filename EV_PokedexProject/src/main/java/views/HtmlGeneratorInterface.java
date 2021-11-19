package views;

import models.Pokemon;
import services.HTTPRequest;
import services.SQLLite;
import utilities.OutputGeneratorInterface;

public class HtmlGeneratorInterface implements OutputGeneratorInterface {

    //int i = 6; //have to change

    public String generateText(int i, int db) {
        System.out.println("=========================="); // debugging
        System.out.println("generator text running ");
        System.out.println("==========================");
        Pokemon mp = new Pokemon();
        if (db == 1) { // if requested, the method use the HTTP source
            HTTPRequest.run(mp, i);
            System.out.println("==========================");
            System.out.println("Pokémon # " + mp.getId());
            System.out.println("Name : " + mp.getName());
            System.out.println("Height : " + mp.getHeight());
            System.out.println("Weight : " + mp.getWeight());
            System.out.println("==========================");
            return null;
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
            return null;
        }
        if (db == 0) { // if requested, no database is used and the program ends
            System.out.println("You had decided to leave :(. Thanks for visiting the Pokedex, see you soon !");
            return null;
        } else { // if the input is not valid, returns
            System.out.println("The input is not valid, try again");
            return null;
        }
    }
        public String generateHtml( int i, int db) {
            System.out.println("=========================="); // debugging
            System.out.println("generator htmls running ");
            System.out.println("==========================");
            Pokemon mp = new Pokemon();
            HTTPRequest.run(mp, i);
            return "<h1>" + mp.getName() + "</h1>\n"
                    + "<ul>\n" +
                    "<li> Id : " + mp.getId() + "<li>\n"
                    + "<li> Height : " + mp.getHeight() + "<li>\n" +
                    "<li> Weight : " + mp.getWeight() + "<li>\n"
                    + "<li> Description : " + mp.getDescription() + "<li>\n" +
                    "</ul>";
    }
}
