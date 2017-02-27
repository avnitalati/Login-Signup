package com.example.hp.logistics;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class Service_Activity extends AppCompatActivity {

    //private RadioButton service_cargo;
   // private RadioButton service_parcel;
    //private RadioButton service_post;
    //private RadioButton service_courior;
     private TextView cargo_tv;
     private TextView post_tv;
     private TextView parcel_tv;
    private TextView courier_tv;
    private ImageView cargo_img;
    private ImageView post_img;
    private ImageView parcel_img;
    private ImageView courier_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_);

      //  service_cargo=(RadioButton) findViewById(R.id.cargo_service);
        //service_post=(RadioButton) findViewById(R.id.post_service);
        //service_courior=(RadioButton) findViewById(R.id.courier_service);
       // service_parcel=(RadioButton) findViewById(R.id.parcel_service);
        cargo_tv=(TextView)findViewById(R.id.tv_cargo);
        post_tv=(TextView)findViewById(R.id.tv_post);
        parcel_tv=(TextView)findViewById(R.id.tv_parcel);
        courier_tv=(TextView)findViewById(R.id.tv_courior);
        cargo_img=(ImageView)findViewById(R.id.img_cargo);
        post_img=(ImageView)findViewById(R.id.img_post);
        parcel_img=(ImageView)findViewById(R.id.img_parcel);
        courier_img=(ImageView)findViewById(R.id.img_courier);
        cargo_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Service_Activity.this,Cargo_Activity.class);
                startActivity(intent);
            }
        });
        cargo_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Service_Activity.this,Cargo_Activity.class);
                startActivity(intent);

            }
        });
        post_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Service_Activity.this,Post_Activity.class);
                startActivity(intent);

            }
        });
        post_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Service_Activity.this,Post_Activity.class);
                startActivity(intent);

            }
        });
        parcel_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Service_Activity.this,Parcel_Activity.class);
                startActivity(intent);

            }
        });
        parcel_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Service_Activity.this,Parcel_Activity.class);
                startActivity(intent);

            }
        });
        courier_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Service_Activity.this,Courier_Activity.class);
                startActivity(intent);

            }
        });
        courier_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Service_Activity.this,Courier_Activity.class);
                startActivity(intent);


            }
        });





    }
}
