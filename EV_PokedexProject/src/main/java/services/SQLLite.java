package services;

import models.Pokemon;

import java.sql.*;
import java.text.MessageFormat;

public class SQLLite {
    public static void run( Pokemon mp, int i  ) {
        /* Connect to the database */
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:/tmp/pokemondatabase.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            PreparedStatement stmt  = conn.prepareStatement("SELECT name, description, height, weight" +
                    " FROM pokemons WHERE id = ?");
            stmt.setInt(1, i);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            mp.setId( i );
            mp.setName( rs.getString("name") );
            mp.setHeight( rs.getInt("height") );
            mp.setWeight( rs.getInt("weight") );
            mp.setDescription( rs.getString("description") );
            //System.out.println("SQL -> Pokémon name : " + rs.getString("name"));
            //System.out.println("SQL -> Pokémon description : " + rs.getString("description"));
        } catch (SQLException e) {
            String mes = MessageFormat.format("No Pokemon find with index {0}, " +
                    "please try again with a different index", i);
            System.err.println(mes);
            System.out.println(e.getMessage());
        }

    }
}
