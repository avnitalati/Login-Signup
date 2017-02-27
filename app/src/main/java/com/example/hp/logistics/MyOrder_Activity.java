package com.example.hp.logistics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MyOrder_Activity extends AppCompatActivity {
     /*   ListView listView;
    String Ordername[];
    String From[];
    String To[];
    String Price[];*/
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        getSupportActionBar() .setDisplayHomeAsUpEnabled(true);
        getSupportActionBar() .setDisplayShowCustomEnabled(true);
        /*Ordername=getResources().getStringArray(R.array.ordername);
        From=getResources().getStringArray(R.array.from);
        To=getResources().getStringArray(R.array.to);
        Price=getResources().getStringArray(R.array.price);
        listView =(ListView)  findViewById(R.id.list_one);*/
        position=getIntent().getIntExtra("position",-1);


        /*ObjectHolder.myorderModel=new ArrayList<>();
        MyorderModel model=new MyorderModel() ;
        model.setOrdername("Furniture Transport");
        model.setFrom("From:ahemdabad");
        model.setTo("To:khambhat");
        model.setPrice("Rs:1000");
        ObjectHolder.myorderModel.add(model);
        CustomMyOrderAdapter adapter=new CustomMyOrderAdapter(this,ObjectHolder.myorderModel);
        listView.setAdapter(adapter );*/

        if(ObjectHolder.myorderModel!=null && position!=-1){
            String Ordername=ObjectHolder.myorderModel.get(position).getOrdername();
        }

    }
}
