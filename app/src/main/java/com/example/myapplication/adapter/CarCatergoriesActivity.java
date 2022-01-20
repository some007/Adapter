package com.example.myapplication.adapter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class CarCatergoriesActivity extends AppCompatActivity {
    RecyclerView list_rev, list_rev2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_adapter_lists);

        list_rev = findViewById(R.id.list_rev);
        list_rev2 = findViewById(R.id.recycleview);
        CarListData[] carListData = new CarListData[]{
                new CarListData("Four Wheeler", R.drawable.water_purifier),
                new CarListData("Two Wheeler", R.drawable.water_purifier),


        };
        CarListData[] carListData3 = new CarListData[]{
                new CarListData("Air Conditionor", R.drawable.air_conditioner),
                new CarListData("Refrigerator", R.drawable.refrigerator),
                new CarListData("TeliVision", R.drawable.tv),
                new CarListData("Washing Machine", R.drawable.washing_machine),

                new CarListData("Air Conditionor", R.drawable.air_conditioner),
                new CarListData("Refrigerator", R.drawable.refrigerator),
                new CarListData("TeliVision", R.drawable.tv),
                new CarListData("Washing Machine", R.drawable.washing_machine),

                new CarListData("Air Conditionor", R.drawable.air_conditioner),
                new CarListData("Refrigerator", R.drawable.refrigerator),
                new CarListData("TeliVision", R.drawable.tv),
                new CarListData("Washing Machine", R.drawable.washing_machine),

                new CarListData("Air Conditionor", R.drawable.air_conditioner),
                new CarListData("Refrigerator", R.drawable.refrigerator),
                new CarListData("TeliVision", R.drawable.tv),
                new CarListData("Washing Machine", R.drawable.washing_machine),
                new CarListData("Dish Washer", R.drawable.home_appliances),
                new CarListData("Water Purifier", R.drawable.water_purifier),

                new CarListData("Air Conditionor", R.drawable.air_conditioner),
                new CarListData("Refrigerator", R.drawable.refrigerator),
                new CarListData("Air Conditionor", R.drawable.air_conditioner),
                new CarListData("Refrigerator", R.drawable.refrigerator),
                new CarListData("TeliVision", R.drawable.tv),
                new CarListData("Washing Machine", R.drawable.washing_machine),


                new CarListData("Air Conditionor", R.drawable.air_conditioner),
                new CarListData("Refrigerator", R.drawable.refrigerator),
                new CarListData("Air Conditionor", R.drawable.air_conditioner),
                new CarListData("Refrigerator", R.drawable.refrigerator),
                new CarListData("TeliVision", R.drawable.tv),
                new CarListData("Washing Machine", R.drawable.washing_machine),


        };

        CarListadapter listAdapter = new CarListadapter(carListData, CarCatergoriesActivity.this);
        list_rev.setAdapter(listAdapter);

        CarListadapter2 listAdapter2 = new CarListadapter2(carListData3, CarCatergoriesActivity.this);
        list_rev2.setAdapter(listAdapter2);


        listAdapter.setOnItemClickListner((position, click_rl, rowIndex) -> {

            if (position == 0) {
                click_rl.setBackgroundColor(this.getResources().getColor(R.color.white));
                CarListadapter2 listAdapter3 = new CarListadapter2(carListData3, CarCatergoriesActivity.this);
                list_rev2.setAdapter(listAdapter3);
                listAdapter.notifyDataSetChanged();
            } else if(position == 1) {
                CarListadapter2 listAdapter4 = new CarListadapter2(carListData, CarCatergoriesActivity.this);
                list_rev2.setAdapter(listAdapter4);
                click_rl.setBackgroundColor(this.getResources().getColor(R.color.white));
                listAdapter.notifyDataSetChanged();
            }
            else {
                click_rl.setBackgroundColor(this.getResources().getColor(R.color.white));
                listAdapter.notifyDataSetChanged();
            }

        });


//        Listadapter2 listadapter2 = new Listadapter2(myListData1,MainActivity.this);


    }
}