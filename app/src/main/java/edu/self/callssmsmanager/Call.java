package edu.self.callssmsmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Call extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
    }

    public void Compose (View v){
        EditText t = findViewById(R.id.editText);
        Intent implicit = new Intent(Intent.ACTION_DIAL);
        String uri = "tel:" + t.getText().toString();
        implicit.setData(Uri.parse(uri));
        startActivity(implicit);
    }

    public void Call (View v){
        EditText t = findViewById(R.id.editText);
        Intent implicit = new Intent(Intent.ACTION_CALL);
        String uri = "tel:" + t.getText().toString();
        implicit.setData(Uri.parse(uri));
        try {
            startActivity(implicit);
        }catch(SecurityException e){
            ActivityCompat.requestPermissions(
                    Call.this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1);
        }
        return;
    }

}
