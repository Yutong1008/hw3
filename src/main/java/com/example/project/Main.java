package com.example.project;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {



    public static void main(String[] args) {
        try {
            String url = "https://dummy.restapiexample.com/api/v1/employees";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            int responseCode = con.getResponseCode();
            System.out.println("send GET request: " + url);
            System.out.println("Response code: " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
            JSONObject object = new JSONObject(sb.toString());

//            System.out.println(object);
            System.out.println("status: " + object.getString("status"));
//            System.out.println("data: " + object.getString("data"));
            System.out.println("message: " + object.getString("message"));
            JSONArray table = new JSONArray(object.getJSONArray("data").toString());
            System.out.println("data: " + table);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
