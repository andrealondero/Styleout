package com.example.mytutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import android.widget.Button;
import android.widget.CheckBox;


public class MainActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

    }
  //      Button b = (Button) findViewById(R.id.done);
 /*       CheckBox ce = (CheckBox) findViewById(R.id.elegantaccess);

        b.setVisibility(b.INVISIBLE);

        b.setOnClickListener(new View.OnClickListener()
    {
        if (cause) {
            b.setVisibility( View.VISIBLE );
        }

        if (!cause) {
            b.setVisibility( View.GONE );
        }
    } */

    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, SecondActivity.class));

  //     b.setVisibility( View.VISIBLE );
    }
}


