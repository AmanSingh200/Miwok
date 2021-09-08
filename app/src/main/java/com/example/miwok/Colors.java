package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        final ArrayList<word> words =new ArrayList<word>();
        words.add(new word("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        words.add(new word("green","chokokki",R.drawable.color_green,R.raw.color_green));
        words.add(new word("brown","ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
        words.add(new word("gray", "ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
        words.add(new word("black","kululli",R.drawable.color_black,R.raw.color_black));
        words.add(new word("white","kelelli",R.drawable.color_white,R.raw.color_white));
        words.add(new word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                word wd=words.get(i);
                mMediaPlayer= MediaPlayer.create(Colors.this,wd.getAudioResourceID());
                mMediaPlayer.start();
            }
        });

    }
    @Override
    protected void onStop(){
        super.onStop();
        releaseMediaPlayer();

    }
    private void releaseMediaPlayer(){
        if (mMediaPlayer!=null)
            mMediaPlayer.release();
    }
}