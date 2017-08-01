package com.example.ranga.inclass05;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainAsync.IActivity,ImageAsync.IImage {

    ArrayList<News> newsArrayList = new ArrayList<News>();
    Button getNews,finish;
    ImageView iv;
    ScrollView sv;
    ImageView next,prev,first,last;
    ProgressBar pg;
    LinearLayout ll;
    TextView load;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("CNN News");
        getSupportActionBar().setIcon(R.drawable.cnn);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getNews = (Button) findViewById(R.id.getNewsID);
        ll = (LinearLayout) findViewById(R.id.linearLaVerID);
        next = (ImageView) findViewById(R.id.nextID);
        prev= (ImageView) findViewById(R.id.prevID);
        first = (ImageView) findViewById(R.id.firstID);
        last = (ImageView) findViewById(R.id.lastId);
        finish = (Button) findViewById(R.id.finishID);
        ll = (LinearLayout) findViewById(R.id.linearLaVerID);
        iv = (ImageView) findViewById(R.id.imageID);
        sv = (ScrollView) findViewById(R.id.scrollView2);
        next.setEnabled(false);
        prev.setEnabled(false);
        first.setEnabled(false);
        last.setEnabled(false);
        finish.setEnabled(false);
        pg = (ProgressBar) findViewById(R.id.progressBarID);
        load = (TextView) findViewById(R.id.loadTextID);
        pg.setVisibility(View.INVISIBLE);
        load.setVisibility(View.INVISIBLE);

        getNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pg.setVisibility(View.VISIBLE);
                load.setVisibility(View.VISIBLE);
                next.setEnabled(true);
                prev.setEnabled(true);
                first.setEnabled(true);
                last.setEnabled(true);
                finish.setEnabled(true);
                getNews.setVisibility(View.INVISIBLE);
                new MainAsync(MainActivity.this).execute("http://rss.cnn.com/rss/cnn_tech.rss");

            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (prev.isEnabled()) {
                    if (i >= 1) {
                        i = i - 1;
                        ll.removeAllViews();
                        final News currentNews = newsArrayList.get(i);
                        String image = currentNews.getSqImage();
                        if (image != null) {
                            new ImageAsync(MainActivity.this).execute(image);
                        } else {
                            iv.setImageBitmap(null);
                        }
                        LinearLayout horizLL = new LinearLayout(MainActivity.this);
                        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(android.app.ActionBar.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        horizLL.setLayoutParams(layout);
                        horizLL.setOrientation(LinearLayout.HORIZONTAL);
                        TextView titleLabel = new TextView(MainActivity.this);
                        TextView title = new TextView(MainActivity.this);
                        title.setText(currentNews.getTitle());
                        title.setLayoutParams(layout);
                        titleLabel.setLayoutParams(layout);
                        titleLabel.setText("News Title : ");
                        horizLL.addView(titleLabel);
                        horizLL.addView(title);
                        LinearLayout horizLL1 = new LinearLayout(MainActivity.this);
                        horizLL1.setLayoutParams(layout);
                        horizLL1.setOrientation(LinearLayout.HORIZONTAL);
                        TextView publishedOn = new TextView(MainActivity.this);
                        TextView pub_title = new TextView(MainActivity.this);
                        pub_title.setLayoutParams(layout);
                        publishedOn.setLayoutParams(layout);
                        pub_title.setText("Published On : ");
                        publishedOn.setText(currentNews.getPubDate());
                        horizLL1.addView(pub_title);
                        horizLL1.addView(publishedOn);
                        LinearLayout verticalLL1 = new LinearLayout(MainActivity.this);
                        verticalLL1.setLayoutParams(layout);
                        verticalLL1.setOrientation(LinearLayout.VERTICAL);
                        TextView desr_title = new TextView(MainActivity.this);
                        TextView description = new TextView(MainActivity.this);
                        desr_title.setLayoutParams(layout);
                        description.setLayoutParams(layout);
                        desr_title.setText("Description : ");
                        description.setText(currentNews.getDescription());
                        verticalLL1.addView(desr_title);
                        verticalLL1.addView(description);

                        ll.addView(horizLL);
                        ll.addView(horizLL1);
                        ll.addView(verticalLL1);
                    }

                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (next.isEnabled()) {
                    if (i < newsArrayList.size() - 1) {
                        i = i + 1;
                        ll.removeAllViews();
                        final News currentNews = newsArrayList.get(i);
                        String image = currentNews.getSqImage();
                        if (image != null) {
                            new ImageAsync(MainActivity.this).execute(image);
                        } else {
                            iv.setImageBitmap(null);
                        }
                        LinearLayout horizLL = new LinearLayout(MainActivity.this);
                        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(android.app.ActionBar.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        horizLL.setLayoutParams(layout);
                        horizLL.setOrientation(LinearLayout.HORIZONTAL);
                        TextView titleLabel = new TextView(MainActivity.this);
                        TextView title = new TextView(MainActivity.this);
                        title.setText(currentNews.getTitle());
                        title.setLayoutParams(layout);
                        titleLabel.setLayoutParams(layout);
                        titleLabel.setText("News Title : ");
                        horizLL.addView(titleLabel);
                        horizLL.addView(title);
                        LinearLayout horizLL1 = new LinearLayout(MainActivity.this);
                        horizLL1.setLayoutParams(layout);
                        horizLL1.setOrientation(LinearLayout.HORIZONTAL);
                        TextView publishedOn = new TextView(MainActivity.this);
                        TextView pub_title = new TextView(MainActivity.this);
                        pub_title.setLayoutParams(layout);
                        publishedOn.setLayoutParams(layout);
                        pub_title.setText("Published On : ");
                        publishedOn.setText(currentNews.getPubDate());
                        horizLL1.addView(pub_title);
                        horizLL1.addView(publishedOn);
                        LinearLayout verticalLL1 = new LinearLayout(MainActivity.this);
                        verticalLL1.setLayoutParams(layout);
                        verticalLL1.setOrientation(LinearLayout.VERTICAL);
                        TextView desr_title = new TextView(MainActivity.this);
                        TextView description = new TextView(MainActivity.this);
                        desr_title.setLayoutParams(layout);
                        description.setLayoutParams(layout);
                        desr_title.setText("Description : ");
                        description.setText(currentNews.getDescription());
                        verticalLL1.addView(desr_title);
                        verticalLL1.addView(description);

                        ll.addView(horizLL);
                        ll.addView(horizLL1);
                        ll.addView(verticalLL1);
                    }
                }
            }
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (first.isEnabled()) {
                    i = 0;
                    ll.removeAllViews();
                    final News currentNews = newsArrayList.get(i);
                    String image = currentNews.getSqImage();
                    if (image != null) {
                        new ImageAsync(MainActivity.this).execute(image);
                    } else {
                        iv.setImageBitmap(null);
                    }
                    LinearLayout horizLL = new LinearLayout(MainActivity.this);
                    LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(android.app.ActionBar.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    horizLL.setLayoutParams(layout);
                    horizLL.setOrientation(LinearLayout.HORIZONTAL);
                    TextView titleLabel = new TextView(MainActivity.this);
                    TextView title = new TextView(MainActivity.this);
                    title.setText(currentNews.getTitle());
                    title.setLayoutParams(layout);
                    titleLabel.setLayoutParams(layout);
                    titleLabel.setText("News Title : ");
                    horizLL.addView(titleLabel);
                    horizLL.addView(title);
                    LinearLayout horizLL1 = new LinearLayout(MainActivity.this);
                    horizLL1.setLayoutParams(layout);
                    horizLL1.setOrientation(LinearLayout.HORIZONTAL);
                    TextView publishedOn = new TextView(MainActivity.this);
                    TextView pub_title = new TextView(MainActivity.this);
                    pub_title.setLayoutParams(layout);
                    publishedOn.setLayoutParams(layout);
                    pub_title.setText("Published On : ");
                    publishedOn.setText(currentNews.getPubDate());
                    horizLL1.addView(pub_title);
                    horizLL1.addView(publishedOn);
                    LinearLayout verticalLL1 = new LinearLayout(MainActivity.this);
                    verticalLL1.setLayoutParams(layout);
                    verticalLL1.setOrientation(LinearLayout.VERTICAL);
                    TextView desr_title = new TextView(MainActivity.this);
                    TextView description = new TextView(MainActivity.this);
                    desr_title.setLayoutParams(layout);
                    description.setLayoutParams(layout);
                    desr_title.setText("Description : ");
                    description.setText(currentNews.getDescription());
                    verticalLL1.addView(desr_title);
                    verticalLL1.addView(description);

                    ll.addView(horizLL);
                    ll.addView(horizLL1);
                    ll.addView(verticalLL1);
                }
            }
        });
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (last.isEnabled()) {
                    i = newsArrayList.size() - 1;
                    ll.removeAllViews();
                    final News currentNews = newsArrayList.get(i);
                    String image = currentNews.getSqImage();
                    if (image != null) {
                        new ImageAsync(MainActivity.this).execute(image);
                    } else {
                        iv.setImageBitmap(null);
                    }
                    LinearLayout horizLL = new LinearLayout(MainActivity.this);
                    LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(android.app.ActionBar.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    horizLL.setLayoutParams(layout);
                    horizLL.setOrientation(LinearLayout.HORIZONTAL);
                    TextView titleLabel = new TextView(MainActivity.this);
                    TextView title = new TextView(MainActivity.this);
                    title.setText(currentNews.getTitle());
                    title.setLayoutParams(layout);
                    titleLabel.setLayoutParams(layout);
                    titleLabel.setText("News Title : ");
                    horizLL.addView(titleLabel);
                    horizLL.addView(title);
                    LinearLayout horizLL1 = new LinearLayout(MainActivity.this);
                    horizLL1.setLayoutParams(layout);
                    horizLL1.setOrientation(LinearLayout.HORIZONTAL);
                    TextView publishedOn = new TextView(MainActivity.this);
                    TextView pub_title = new TextView(MainActivity.this);
                    pub_title.setLayoutParams(layout);
                    publishedOn.setLayoutParams(layout);
                    pub_title.setText("Published On : ");
                    publishedOn.setText(currentNews.getPubDate());
                    horizLL1.addView(pub_title);
                    horizLL1.addView(publishedOn);
                    LinearLayout verticalLL1 = new LinearLayout(MainActivity.this);
                    verticalLL1.setLayoutParams(layout);
                    verticalLL1.setOrientation(LinearLayout.VERTICAL);
                    TextView desr_title = new TextView(MainActivity.this);
                    TextView description = new TextView(MainActivity.this);
                    desr_title.setLayoutParams(layout);
                    description.setLayoutParams(layout);
                    desr_title.setText("Description : ");
                    description.setText(currentNews.getDescription());
                    verticalLL1.addView(desr_title);
                    verticalLL1.addView(description);

                    ll.addView(horizLL);
                    ll.addView(horizLL1);
                    ll.addView(verticalLL1);

                }
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




    }

    @Override
    public void setList(ArrayList<News> news) {

            newsArrayList = news;
          //  pd.dismiss();
            Log.d("demo", "In setList");
        Log.d("demo",news.size()+"");
        if(news.size()!=0)
        {
            getNews.setVisibility(View.VISIBLE);
            pg.setVisibility(View.INVISIBLE);
            load.setText("");
            iv.setVisibility(View.VISIBLE);
            sv.setVisibility(View.VISIBLE);
        }
        final News currentNews = newsArrayList.get(0);
        String image = currentNews.getSqImage();
        if (image != null) {
            new ImageAsync(this).execute(image);
        }else
        {
           iv.setImageBitmap(null);
        }

               /* TextView tv = new TextView(this);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, NewsDetailsActivity.class);
                        intent.putExtra(NEWS_KEYS, currentNews);
                        startActivity(intent);
                    }
                });
                tv.setText(currentNews.getTitle());*/

            /*    iv = new ImageView(this);
                new LoadImage().execute(new StringAndBitmap(iv, currentNews.getSqThunail()));

                LinearLayout horizLL = new LinearLayout(this);
                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(android.app.ActionBar.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                horizLL.setLayoutParams(layout);
                horizLL.setOrientation(LinearLayout.HORIZONTAL);
                iv.setLayoutParams(layout);
                horizLL.addView(iv);
                horizLL.addView(tv);
                ll.addView(horizLL);*/
                LinearLayout horizLL = new LinearLayout(this);
                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(android.app.ActionBar.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                horizLL.setLayoutParams(layout);
                horizLL.setOrientation(LinearLayout.HORIZONTAL);
                TextView titleLabel = new TextView(this);
                TextView title = new TextView(this);
                title.setText(currentNews.getTitle());
                title.setLayoutParams(layout);
                titleLabel.setLayoutParams(layout);
                titleLabel.setText("News Title : ");
                horizLL.addView(titleLabel);
                horizLL.addView(title);
                LinearLayout horizLL1 = new LinearLayout(this);
                 horizLL1.setLayoutParams(layout);
                horizLL1.setOrientation(LinearLayout.HORIZONTAL);
                TextView publishedOn = new TextView(this);
                TextView pub_title = new TextView(this);
                pub_title.setLayoutParams(layout);
                publishedOn.setLayoutParams(layout);
                pub_title.setText("Published On : ");
                publishedOn.setText(currentNews.getPubDate());
                horizLL1.addView(pub_title);
                horizLL1.addView(publishedOn);
                LinearLayout verticalLL1 = new LinearLayout(this);
                verticalLL1.setLayoutParams(layout);
                verticalLL1.setOrientation(LinearLayout.VERTICAL);
                TextView desr_title = new TextView(this);
                TextView description = new TextView(this);
                desr_title.setLayoutParams(layout);
                description.setLayoutParams(layout);
                desr_title.setText("Description : ");
                description.setText(currentNews.getDescription());
                verticalLL1.addView(desr_title);
                verticalLL1.addView(description);

                ll.addView(horizLL);
                ll.addView(horizLL1);
                ll.addView(verticalLL1);





            }

    @Override
    public void setUpImage(Bitmap bitmap) throws InterruptedException {
        if(bitmap!=null) {
            iv.setImageBitmap(bitmap);
        }else{
            iv.setImageBitmap(null);
        }
    }
}



