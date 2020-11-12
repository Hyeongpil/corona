package com.example.coronavirus.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coronavirus.R;
import com.example.coronavirus.restclient.dto.sido.Item;

import java.util.ArrayList;

public class SidoAdapter extends RecyclerView.Adapter<SidoAdapter.ModelViewHolder>{

    private ArrayList<Item> sidoItemList = new ArrayList<>();

    @NonNull
    @Override
    public ModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sido ,parent, false);
        return new ModelViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return sidoItemList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ModelViewHolder holder, int position) {
        holder.onBind(sidoItemList.get(position));
    }

    public void setData(ArrayList<Item> sidoItemList){
        this.sidoItemList = sidoItemList;
        notifyDataSetChanged();
    }

    class ModelViewHolder extends RecyclerView.ViewHolder {
        private TextView tvSido;
        private TextView tvInc;
        private TextView tvPercent;

        public ModelViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSido = itemView.findViewById(R.id.tv_sido_sido);
            tvInc = itemView.findViewById(R.id.tv_sido_inc);
            tvPercent = itemView.findViewById(R.id.tv_sido_percent);
        }

        void onBind(Item sidoItem){
            tvSido.setText(sidoItem.getGubun());
            tvInc.setText(sidoItem.getIncDec());
            try {
                tvPercent.setText(String.valueOf(sidoItem.getQurRate())+"%");
            } catch (NullPointerException e) {
                tvPercent.setText("-");
                e.printStackTrace();
            }
        }

    }
}
