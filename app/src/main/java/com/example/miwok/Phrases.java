package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        final ArrayList<word> words =new ArrayList<word>();
        words.add(new word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        words.add(new word("My name is...","oyaaset...",R.raw.phrase_my_name_is));
        words.add(new word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        words.add(new word("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        words.add(new word("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        words.add(new word("I’m coming.","әәnәm",R.raw.phrase_im_coming));
        words.add(new word("Let’s go.","yoowutis",R.raw.phrase_lets_go));
        words.add(new word("Come Here","әnni'nem",R.raw.phrase_come_here));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                word wd=words.get(i);
                mMediaPlayer= MediaPlayer.create(Phrases.this,wd.getAudioResourceID());
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