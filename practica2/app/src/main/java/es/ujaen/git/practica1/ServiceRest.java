package es.ujaen.git.practica1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by windic on 13/11/2016.
 */

public class ServiceRest {
    String urlpost, postparams;

    public ServiceRest(String urlpost, String postparams) {
        this.postparams = postparams;
    }
    public String Autenticacion(){
        String urlautentica = "/servidor_g05/autentica.php";
        reqPost(urlpost+urlautentica);
        return null;
    }
    private String reqPost(String surl ) {

        InputStream in = null;
        OutputStream os = null;
        HttpURLConnection conn = null;
        String result = "";
        String contentAsString = "";
        String tempString = "";


        try {
            URL url = new URL(surl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            //Send request
            os = conn.getOutputStream();
            BufferedWriter wr = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));

            wr.write(postparams);
            wr.flush();
            wr.close();
            // Starts the query
            conn.connect();
            final int response = conn.getResponseCode();

            in = conn.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));

            while ((tempString = br.readLine()) != null) {
                contentAsString = contentAsString + tempString;

            }
            in.close();
            conn.disconnect();
            result = contentAsString;
        } catch (IOException e) {
            result = e.getMessage();
            e.printStackTrace();
        }
        return result;
    }
}
