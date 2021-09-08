package com.example.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the view that shows the number category
        TextView numbers=(TextView) findViewById(R.id.numbers);

        //set a click listener on that view
        numbers.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });



        TextView phrases=(TextView) findViewById(R.id.phrases);
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent(MainActivity.this, Phrases.class);
                startActivity(phrasesIntent);
            }
        });




        TextView colors=(TextView) findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorsIntent = new Intent(MainActivity.this, Colors.class);
                startActivity(colorsIntent);
            }
        });




        TextView family=(TextView) findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familyIntent = new Intent(MainActivity.this, Family_members.class);
                startActivity(familyIntent);
            }
        });

    }
}