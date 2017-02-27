package com.example.hp.logistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Place_Add_Order_Activity extends AppCompatActivity {
    private Button btnplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place__add__order_);
        btnplace=(Button)findViewById(R.id.btn_place_order);
        btnplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Place_Add_Order_Activity.this,Place_Order_Activity.class);
                startActivity(intent);

            }
        });

        }
}
