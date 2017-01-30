package com.baudiabatash.exceltest.HTTP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Created by Sohel on 1/29/2017.
 */

public class MyHttp {

    public static String loadUrl(final String url, final String data)
            throws Exception {
        HttpURLConnection urlConnection = null;
        BufferedReader br = null;
        final StringBuilder result = new StringBuilder();

        try {
            urlConnection = (HttpURLConnection)new URL(url).openConnection();

            if (data != null) {
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                urlConnection.setRequestProperty("Content-Length",
                        Integer.toString(data.length()));
                urlConnection.setDoOutput(true);

                DataOutputStream dos = new DataOutputStream(
                        urlConnection.getOutputStream());
                dos.writeBytes(data.toString());
                dos.flush();
                dos.close();

                urlConnection.connect();
            }

            br = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));

            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
        } finally {
            try { urlConnection.disconnect(); } catch (Exception e) {}
            try { br.close(); } catch (Exception e) {}
        }

        return result.toString();
    }
}
