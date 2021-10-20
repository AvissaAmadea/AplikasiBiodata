package com.avissa.biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button a, b, c;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = (Button) findViewById(R.id.alamat);
        b = (Button) findViewById(R.id.cp);
        c = (Button) findViewById(R.id.email);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, Mapsku.class);
                startActivity(it);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nmr = "088216398343";
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.fromParts("tel",nmr,null));
                startActivity(call);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"111202012572@mhs.dinus.ac.id"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Haiii...");

                try {
                    startActivity(Intent.createChooser(intent,"Apakah Anda ingin mengirim email?"));
                } catch (ActivityNotFoundException ex){
                }
            }
        });
    }
}