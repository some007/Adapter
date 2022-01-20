package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarListadapter2 extends RecyclerView.Adapter<CarListadapter2.ViewHolder> {
    private final CarListData[] carListData;
    Context context;

    public CarListadapter2(CarListData[] carListData, CarCatergoriesActivity context) {
        this.carListData = carListData;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View ListItem = layoutInflater.inflate(R.layout.activity_carlistadadapter_adapter_2, parent, false);
        ViewHolder viewHolder = new ViewHolder(ListItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CarListData carListDatan = carListData[position];
        holder.afl_tv.setText(carListDatan.getDescription());
        holder.afl_iv.setImageResource(carListDatan.getImgId());


    }

    @Override
    public int getItemCount() {
        return carListData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView afl_iv;
        public TextView afl_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            this.afl_iv = (ImageView) itemView.findViewById(R.id.afl_iv);
            this.afl_tv = (TextView) itemView.findViewById(R.id.afl_tv);

        }
    }
}
