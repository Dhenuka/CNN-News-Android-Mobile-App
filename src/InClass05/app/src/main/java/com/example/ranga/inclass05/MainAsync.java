package com.example.ranga.inclass05;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by ranga on 2/13/2017.
 */

public class MainAsync extends AsyncTask<String,Void,ArrayList<News>>{
    IActivity activity;
   public MainAsync(IActivity activity) {
        this.activity = activity;
    }

    @Override
    protected ArrayList<News> doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            int statusCode = con.getResponseCode();
            if(statusCode == HttpURLConnection.HTTP_OK) {
                InputStream in = con.getInputStream();
                return NewsUtil.PullParser.parseNews(in);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute(ArrayList<News> news) {
        if(news!=null){
            activity.setList(news);
            Log.d("demo",news.toString());
        }
    }

    public interface IActivity
    {
        public void setList(ArrayList<News> news);
    }
}
