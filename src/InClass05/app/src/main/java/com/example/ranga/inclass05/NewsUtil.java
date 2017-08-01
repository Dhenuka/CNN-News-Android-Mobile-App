package com.example.ranga.inclass05;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by ranga on 2/13/2017.
 */

public class NewsUtil {


    static public class PullParser {

        static ArrayList<News> parseNews(InputStream in) throws Exception {
            String checkInput = "";
            XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
            parser.setInput(in, "UTF-8");
            News news = null;
            ArrayList<News> NewsArrayList = new ArrayList<>();
            int event = parser.getEventType();


            while (event != XmlPullParser.END_DOCUMENT) {
                switch (event) {
                    case XmlPullParser.START_TAG:
                        Log.d("demo", parser.getName());
                        if (parser.getName().equals("ttl")) {
                            checkInput = parser.nextText();
                        }
                        if (parser.getName().equals("item")) {
                            Log.d("demo", "strat");
                            news = new News();
                        }
                        if (!(checkInput.equals(""))) {
                            if (parser.getName().equals("title")) {
                                news.setTitle(parser.nextText());
                            } else if (parser.getName().equals("description")) {
                                news.setDescription(parser.nextText());
                            } else if (parser.getName().equals("pubDate")) {
                                news.setPubDate(parser.nextText());
                            } else if (parser.getName().equals("media:content")) {
                                if (parser.getAttributeValue(null, "height").equals(parser.getAttributeValue(null, "width"))) {
                                    news.setSqImage(parser.getAttributeValue(null, "url"));

                                }
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (parser.getName().equals("item")) {
                            Log.d("demo", "end");
                            NewsArrayList.add(news);
                            news = null;
                        }

                        break;
                }
                event = parser.next();
            }

            return NewsArrayList;
        }


    }
}
