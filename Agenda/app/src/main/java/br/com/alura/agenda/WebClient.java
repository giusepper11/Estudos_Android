package br.com.alura.agenda;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebClient {
    public String post(String json) {
        try {
            URL url = new URL("https://www.caelum.com.br/mobile");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type","application/json");
            connection.setRequestProperty("Accept","application/json");


            connection.setDoOutput(true);
            PrintStream output = new PrintStream(connection.getOutputStream());
            output.println(json);

            connection.connect();
            Scanner scanner = new Scanner(connection.getInputStream());
            return scanner.next();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
