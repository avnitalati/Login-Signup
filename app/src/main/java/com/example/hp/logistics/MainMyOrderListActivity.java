package com.example.hp.logistics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.widget.ListView;

public class MainMyOrderListActivity extends AppCompatActivity {
    ListView listview;
    String ordername[];
    String from[];
    String to[];
    String price[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_my_order_list);
        getSupportActionBar() .setDisplayHomeAsUpEnabled(true);
        getSupportActionBar() .setDisplayShowCustomEnabled(true);

       /* ordername =getResources() .getStringArray(R.array.ordername);
        from =getResources() .getStringArray(R.array.from);
        to=getResources() .getStringArray(R.array.to);
        price=getResources() .getStringArray(R.array .price);*/

       // listview =(ListView)findViewById(R.id.list_one);
       // CustomMyOrderAdapter customMyOrderAdapter=new CustomMyOrderAdapter(this,ordername,from ,to ,price );
        //listview .setAdapter(customMyOrderAdapter);



    }
}
