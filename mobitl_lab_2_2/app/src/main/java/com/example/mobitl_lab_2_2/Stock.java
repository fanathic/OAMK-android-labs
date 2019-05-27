package com.example.mobitl_lab_2_2;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Stock {

    private String name;
    private String price;
    private String id;

    public Stock(String name, String id){
        this.name = name;
        this.id = id;
        this.price = "test";
        getPriceFromApi();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceFromApi()
    {
        URL url = null;
        try {
            url = new URL("https://financialmodelingprep.com/api/company/price/" + getId());
        } catch (Exception ex) {

        }
        new LoadTextualContentFromWebTask().execute(url);

        return "";
    }


    private class LoadTextualContentFromWebTask extends AsyncTask<URL, Integer, String> {
        protected String doInBackground(URL... urls) {
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) urls[0].openConnection();
                try {

                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    return (readStream(in));

                } catch (IOException ex) {

                } finally {
                    urlConnection.disconnect();
                }
            } catch (Exception ex) {

            }
            return "Something went wrong";
        }

        private String readStream(InputStream is) {
            try {
                ByteArrayOutputStream bo = new ByteArrayOutputStream();
                int i = is.read();
                while (i != -1) {
                    bo.write(i);
                    i = is.read();
                }
                return bo.toString();
            } catch (IOException e) {
                return "";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            int beginIndex = result.indexOf("\"price\": ");
            String price = result.substring(beginIndex + 9, beginIndex+14);
            setPrice(Double.toString(Double.parseDouble(price)));

        }


    }
}
