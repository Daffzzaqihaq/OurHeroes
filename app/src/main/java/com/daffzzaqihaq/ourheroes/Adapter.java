package com.daffzzaqihaq.ourheroes;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daffzzaqihaq.ourheroes.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    int[] gambarHeroes;
    String[] namaHeroes,detailHeroes;

    public Adapter(Context context,int[] gambarHeroes, String[] namaHeroes, String[] detailHeroes){
        this.context = context;
        this.gambarHeroes = gambarHeroes;
        this.namaHeroes = namaHeroes;
        this.detailHeroes = detailHeroes;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listheroes, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(namaHeroes[i]);
        Glide.with(context).load(gambarHeroes[i]).into(viewHolder.imgLogo);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context,DetailHeroesActivity.class);
                pindah.putExtra("nh",namaHeroes[i]);
                pindah.putExtra("dh",detailHeroes[i]);
                pindah.putExtra("gh",gambarHeroes[i]);
                context.startActivity(pindah);

            }
        });
    }



    @Override
    public int getItemCount() {
        return gambarHeroes.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView txtNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imgList);
            txtNama = itemView.findViewById(R.id.txtListTitle);

        }
    }
}

