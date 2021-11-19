package services;

import models.Pokemon;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.MessageFormat;

public class HTTPRequest {
    public static void run( Pokemon mp, int i ) {
        String jsonResponse = "";
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            String url = MessageFormat.format("https://pokeapi.co/api/v2/pokemon/{0}", i);
            HttpGet request = new HttpGet(url);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(jsonResponse);
            if (resultObject instanceof JSONObject) {
                JSONObject obj =(JSONObject)resultObject;

                mp.setId( obj.get("id") );
                mp.setName( obj.get("name") );
                mp.setHeight( obj.get("height") );
                mp.setWeight( obj.get("weight") );
                mp.setDescription("No description available");
                //System.out.println("Pokémon # " + obj.get("id"));
                //System.out.println("Name : " + obj.get("name"));
                //System.out.println("Height : " + obj.get("height"));
                //System.out.println("Weight : " + obj.get("weight"));
            } else {
                System.err.println("Error, we expected a JSON Object from the API");
            }


        } catch (IOException  e) {
            e.printStackTrace();
        } catch (ParseException e) {
            String mes = MessageFormat.format("No Pokemon find with index {0}, " +
                    "please try again with a different index", i);
            System.err.println(mes);
            //System.err.println("Could not parse the response given by the API as JSON");
            //System.err.println("Response body is :");
            //System.err.println(jsonResponse);
            //e.printStackTrace();
        }
    }
}
