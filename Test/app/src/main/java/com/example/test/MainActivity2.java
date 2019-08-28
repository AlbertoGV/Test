package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity2 extends AppCompatActivity {
    Button button5, button6, button7;

    Serializable resultTest1;

    enum state implements Serializable {
        MIDDLE2,
        SMALL2,
        NONE2,
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        resultTest1 = getIntent().getSerializableExtra("STATE");
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(MainActivity2.this,ResultsActivity.class);
            i.putExtra("STATE1",state.MIDDLE2);
            i.putExtra("STATE",resultTest1);
            startActivity(i);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this,ResultsActivity.class);
                i.putExtra("STATE1",state.SMALL2);
                i.putExtra("STATE",resultTest1);
                startActivity(i);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this,ResultsActivity.class);
                i.putExtra("STATE1",state.NONE2);
                i.putExtra("STATE",resultTest1);
                startActivity(i);
            }
        });



    }
}
