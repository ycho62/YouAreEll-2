package controllers;

//import spiffyUrlManipulator

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
        import java.net.URL;

import static java.util.logging.Level.parse;

public class ServerController<JsonString> {
    HttpURLConnection connection;
    private String rootURL = "http://zipcode.rocks:8085";

    private static ServerController svr = new ServerController();

    private ServerController() {}

    public static ServerController shared() {
        return svr;
    }

    public JsonString idGet() {
        BufferedReader reader;
        String line;
        StringBuffer response = new StringBuffer();
        JSONParser jsonParser = new JSONParser();
        try {
            URL url = new URL("http://zipcode.rocks:8085/ids");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();
        System.out.println(status);
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                Object obj = jsonParser.parse(reader);
                JSONArray ids = (JSONArray) obj;
            }else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                Object obj = jsonParser.parse(reader);
                JSONArray ids = (JSONArray) obj;
                System.out.println(ids);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return (JsonString) response;
        // url -> /ids/
        // send the server a get with url
        // return json from server
    }
//    public JsonString idPost(JsonTypeInfo.Id) {
//        // url -> /ids/
//        // create json from Id
//        // request
//        // reply
//        // return json
//    }
//    public JsonString idPut(JsonTypeInfo.Id) {
//        // url -> /ids/
//    }


}

// ServerController.shared.doGet()