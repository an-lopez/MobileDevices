package com.escom.materialexample.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.escom.materialexample.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NavDrawerItemAdapter extends RecyclerView.Adapter<NavDrawerItemAdapter.MyViewHolder>{

    private List<NavigationDrawerItem> items;

    public NavDrawerItemAdapter(List<NavigationDrawerItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_navigation_drawer, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NavigationDrawerItem item = items.get(position);
        holder.texto.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_text)
        TextView texto;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
