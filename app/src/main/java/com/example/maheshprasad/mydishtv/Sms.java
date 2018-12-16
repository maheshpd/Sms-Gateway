package com.example.maheshprasad.mydishtv;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Sms extends AppCompatActivity {

    EditText edt_mobile,edt_message;
    Button btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        edt_message=findViewById(R.id.message);
        edt_mobile=findViewById(R.id.mobile);
        btn_send=findViewById(R.id.sendMessage);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    // Construct data
                    String apiKey = "apikey=" + "tvKMKzwIkXg-97fTiH5LL65hQJgaflvmWojsJ7B88R";
                    String message = "&message=" + edt_message.getText().toString();
                    String sender = "&sender=" + "TXTLCL";
                    String numbers = "&numbers=" + edt_mobile.getText().toString();

                    // Send data
                    HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
                    String data = apiKey + numbers + message + sender;
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                    conn.getOutputStream().write(data.getBytes("UTF-8"));
                    final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    final StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = rd.readLine()) != null) {
                        Toast.makeText(Sms.this, line.toString(), Toast.LENGTH_SHORT).show();
                    }
                    rd.close();


                } catch (Exception e) {
                    Toast.makeText(Sms.this, e.toString(), Toast.LENGTH_SHORT).show();

                }

            }
        });

        StrictMode.ThreadPolicy st = new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(st);


    }
}
