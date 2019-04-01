package com.github.lopezantonio.easypav;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MaterialAdapter extends RecyclerView.Adapter<MaterialAdapter.MaterialViewHolder> {

    private ArrayList<Material> materials;
    private Context context;

    public MaterialAdapter(ArrayList<Material> materials) {
        this.materials = materials;

    }

    public MaterialViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        return new MaterialViewHolder(LayoutInflater.from(context).inflate(R.layout.material_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MaterialViewHolder materialViewHolder, int i) {
        Material material = materials.get(materialViewHolder.getAdapterPosition());

        materialViewHolder.iv_material.setImageResource(material.getImg());
        materialViewHolder.tv_material.setText(material.getNombre());


    }

    @Override
    public int getItemCount() {
        return materials.size();
    }

    public class MaterialViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView iv_material;
        private TextView tv_material;

        public MaterialViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_material = itemView.findViewById(R.id.iv_material);
            tv_material = itemView.findViewById(R.id.tv_title_material);
        }
    }
}
