package edu.self.callssmsmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Sms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
    }
    public void Compose (View v){
        EditText phonenumber = findViewById(R.id.number);
        EditText message = findViewById(R.id.message);

        Intent intent = new Intent(Intent.ACTION_SEND);
        String uri = "tel:" + phonenumber.getText().toString();
        intent.setData(Uri.parse(uri));
        intent.putExtra("sms_body", message.toString());
        try {
            startActivity(intent);
        }catch(SecurityException e){
            ActivityCompat.requestPermissions(
                    Sms.this,
                    new String[]{Manifest.permission.SEND_SMS},
                    1);
        }
        return;
    }

}
