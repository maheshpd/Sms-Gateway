package com.example.maheshprasad.mydishtv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button btn_newCustomer,btn_viewCustomer,active_customer,btn_deactivecustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_newCustomer=findViewById(R.id.new_customer);
        btn_viewCustomer=findViewById(R.id.view_customer);
        active_customer=findViewById(R.id.active_customer);
        btn_deactivecustomer=findViewById(R.id.deactive_customer);

        btn_newCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,NewCustomer.class));
            }
        });
    }

}
