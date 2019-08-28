package com.example.test;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.Serializable;

import static com.example.test.MainActivity.state.MIDDLE;
import static com.example.test.MainActivity.state.SMALL;
import static com.example.test.MainActivity2.state.MIDDLE2;
import static com.example.test.MainActivity2.state.SMALL2;
import static com.example.test.MainActivity2.state.NONE2;
import static com.example.test.MainActivity.state.BIG;
import static com.example.test.MainActivity.state.NONE;

public class ResultsActivity extends AppCompatActivity {

    Serializable resultTest1, resultTest2;
    int nivel=0;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_activity);

        textView = findViewById(R.id.textView);

        resultTest1 = getIntent().getSerializableExtra("STATE");

        resultTest2  = getIntent().getSerializableExtra("STATE1");


        if(resultTest1 == MIDDLE && resultTest2 == MIDDLE2){
            nivel=1;
        }else if(resultTest1 == SMALL && resultTest2 == SMALL2){
            nivel=5;
        }else if(resultTest1 == NONE && resultTest2 == NONE){
            nivel=0;
        }

        textView.setText(nivel+"");






    }
}
