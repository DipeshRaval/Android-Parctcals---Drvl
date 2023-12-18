package com.example.recycleviewlearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class RecyleAdapter extends RecyclerView.Adapter<RecyleAdapter.RecycleHolder> {
    LinkedList<String> data;
    LayoutInflater inflater;
    public RecyleAdapter(Context context, LinkedList<String> linkedList)
    {
        inflater = LayoutInflater.from(context);
        data = linkedList;
    }
    @NonNull
    @Override
    public RecyleAdapter.RecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.name_row,parent,false);
        return new RecycleHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyleAdapter.RecycleHolder holder, int position) {
        String setTextVal = data.get(position);
        holder.txt.setText(setTextVal);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class RecycleHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        TextView txt;
        public RecycleHolder(@NonNull View itemView,RecyleAdapter adapter) {
            super(itemView);
            txt = itemView.findViewById(R.id.textRecyle);
            txt.setOnClickListener(this);
        }

        @Override
        public void onClick(@NonNull View view){
            Toast.makeText(view.getContext(), "Clicked !", Toast.LENGTH_SHORT).show();
        }
    }
}
