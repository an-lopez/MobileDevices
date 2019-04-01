package com.github.lopezantonio.easypav;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;

public class PracticeAdapter extends RecyclerView.Adapter<PracticeAdapter.PracticeViewHolder> {

    private ArrayList<Practice> practices;
    private Context context;

    public PracticeAdapter(ArrayList<Practice> practices) {
        this.practices = practices;
    }

    public PracticeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        return new PracticeViewHolder(LayoutInflater.from(context).inflate(R.layout.practica_item, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PracticeViewHolder practiceViewHolder, int i) {
        final Practice practice = practices.get(practiceViewHolder.getAdapterPosition());


        practiceViewHolder.img.setImageResource(practice.img);
        practiceViewHolder.title.setText(practice.nombre);
        practiceViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, test.class);
                intent.putExtra("practice", practice.nombre);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return practices.size();
    }

    public class PracticeViewHolder extends RecyclerView.ViewHolder{
        private YouTubeThumbnailView img;
        private TextView title;
        private CardView cardView;

        public PracticeViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cv_item);
            img = itemView.findViewById(R.id.tbn_image);
            title = itemView.findViewById(R.id.tv_title);

        }
    }
}
