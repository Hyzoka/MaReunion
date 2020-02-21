package com.ocr.mareunion;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ReunionAdapter extends RecyclerView.Adapter<ReunionAdapter.ViewHolder>  {

    ArrayList<Meeting> mReunion;


    public ReunionAdapter(ArrayList<Meeting> items) {
        mReunion = items;

    }

    public ArrayList<Meeting> getReunion() {
        return mReunion;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Meeting reunion = mReunion.get(position);
        holder.tvSujet.setText(reunion.getSujet());
        holder.imageView.setImageDrawable(reunion.getAvatar());

        holder.tvHeure.setText(reunion.getHeure()+"h"+ reunion.getMinute());
        holder.tvMail.setText(reunion.getMail());
        holder.tvSalle.setText(reunion.getSalle());

        //au click sur la recycler on redirige vers les détail avec les données corespondante
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    removeAt(position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mReunion.size();
    }

    public void removeAt(int position) {
        mReunion.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();

    }



    public void updateData(ArrayList<Meeting> meetings) {
       mReunion = meetings;
        notifyDataSetChanged();

    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tvSalle;
        public TextView tvMail;
        public TextView tvHeure;
        public TextView tvSujet;
        public ImageButton delete;


        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.avatar);
            this.tvSalle = (TextView) itemView.findViewById(R.id.salle);
            this.tvMail = (TextView) itemView.findViewById(R.id.mail);
            this.tvHeure= (TextView) itemView.findViewById(R.id.heure);
            this.tvSujet = (TextView) itemView.findViewById(R.id.sujet);
            this.delete= (ImageButton) itemView.findViewById(R.id.delete);
        }
    }


}