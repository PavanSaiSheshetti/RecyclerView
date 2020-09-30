package com.example.ignis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecord extends RecyclerView.Adapter<AdapterRecord.HolderRecord> {
    private Context context;
    private ArrayList<ModelRecord> recordsList;

    public AdapterRecord(Context context, ArrayList<ModelRecord> recordsList) {
        this.context = context;
        this.recordsList = recordsList;
    }

    @NonNull
    @Override
    public HolderRecord onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context) .inflate(R.layout.new_customer,parent , false);
        return new HolderRecord(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecord holder, int position) {

        ModelRecord model = recordsList.get(position);
        String id = model.getId();
        String name = model.getName();
        String number = model.getNo();
        String date = model.getDate();
        String prob = model.getProb();
        String odo = model.getOdo();
        String fuel = model.getFuel();
        String type = model.getType();
        String belong = model.getBelong();
        String dent = model.getDent();
        String est = model.getEst();
        String front = model.getFront();
        String rear = model.getRear();
        String right = model.getRight();
        String left = model.getLeft();
        String odofuel = model.getFuel();
        String shield = model.getShield();
        String tyre = model.getTyre();
        String paint = model.getPaint();
        String oil = model.getOil();
        String cool = model.getCool();
        String list = model.getList();
        String by = model.getBy();
        String pick = model.getPick();
        String custsign = model.getCust_sign();

        holder.name.setText(name);
        holder.number.setText(number);

    }

    @Override
    public int getItemCount() {
        return recordsList.size();
    }

    class HolderRecord extends RecyclerView.ViewHolder{

        TextView name,number;

        public HolderRecord(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.vehicle1);
            number = itemView.findViewById(R.id.number1);
        }
    }
}
