package edu.self.callssmsmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startCall (View v){
        Intent i = new Intent(this, Call.class);
        startActivity(i);
    }
    public void startSms (View v){
        Intent i = new Intent(this, Sms.class);
        startActivity(i);
    }
}