package views;

import models.Pokemon;
import services.HTTPRequest;
import services.SQLLite;

public class PrinterHTML {
    public static String getHTML(Pokemon mp, int i, int db ) {
        System.out.println("=========================="); // debugging
        System.out.println("Printer running 2");
        System.out.println("==========================");
        if (db == 1) { // if requested, the method use the HTTP source
            HTTPRequest.run(mp, i);
            String msg1 = "<h1>" + mp.getName() + "</h1>\n"
                    + "<ul>\n" +
                    "<li> Id : " + mp.getId() + "<li>\n"
                    + "<li> Height : " + mp.getHeight() + "<li>\n" +
                    "<li> Weight : " + mp.getWeight() + "<li>\n" +
                    "</ul>\n";
            return msg1 ;
        }
        if (db == 2) { // if requested, the method use the SQL source
            SQLLite.run(mp, i);
            String msg2 = "<h1>" + mp.getName() + "</h1>\n"
                    + "<ul>\n" +
                    "<li> Id : " + mp.getId() + "<li>\n"
                    + "<li> Height : " + mp.getHeight() + "<li>\n" +
                    "<li> Weight : " + mp.getWeight() + "<li>\n"
                    + "<li> Description : " + mp.getDescription() + "<li>\n" +
                    "</ul>\n";
            return msg2;
        }
        return null;
    }
}
