package com.example.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarListadapter extends RecyclerView.Adapter<CarListadapter.ViewHolder> {
    public static int row_index = -1;
    private final CarListData[] carListData;
    Context context;
    String rowIndex;
    private OnItemClickListner mListner;


    public CarListadapter(CarListData[] carListData, CarCatergoriesActivity context) {
        this.carListData = carListData;
        this.context = context;
        this.rowIndex = rowIndex;
    }

    public interface OnItemClickListner {
        void onTimeClick(int position, RelativeLayout click_rl, int rowIndex);
    }

    //------------------------------------Creating method that we call from main page (step 3)-------------------------------------------------------------------------

    public void setOnItemClickListner(OnItemClickListner listner) {
        mListner = listner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View ListItem = layoutInflater.inflate(R.layout.activity_appliance_adapter, parent, false);
//        ViewHolder viewHolder = new ViewHolder(ListItem);

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_carlist_adapters, parent, false);
        return new ViewHolder(itemView, mListner);

        //return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CarListData carListDatan = carListData[position];
        holder.afl_tv.setText(carListDatan.getDescription());
        holder.afl_iv.setImageResource(carListDatan.getImgId());

       /* holder.relativ_rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                row_index = holder.getAdapterPosition();
                Log.d("TAG", String.valueOf(row_index));
                notifyDataSetChanged();

            }
        });*/


        if (row_index == position) {
            holder.relativ_rv.setBackgroundColor(context.getResources().getColor(R.color.white));
            Log.d("TAG", "Row_1" + row_index);
        } else {
            holder.relativ_rv.setBackgroundColor(context.getResources().getColor(R.color.adpColor));
            Log.d("TAG", "Row_2" + row_index);
        }


    }

    @Override
    public int getItemCount() {
        return carListData.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView afl_iv;
        public TextView afl_tv;
        LinearLayout card_rv, linear_rv;
        RelativeLayout relativ_rv;

        public ViewHolder(View itemView, final OnItemClickListner listner) {
            super(itemView);
            this.afl_iv = (ImageView) itemView.findViewById(R.id.afl_iv);
            this.afl_tv = (TextView) itemView.findViewById(R.id.afl_tv);
            this.card_rv = itemView.findViewById(R.id.card_rv);
            this.linear_rv = itemView.findViewById(R.id.linear_rv);
            this.relativ_rv = itemView.findViewById(R.id.relativ_rv);


            relativ_rv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        row_index = position;
                        listner.onTimeClick(position, relativ_rv,row_index);

                        // Log.w("ROW_INDEX", String.valueOf(row_index));
                    }
                }
            });

        }
    }
}
