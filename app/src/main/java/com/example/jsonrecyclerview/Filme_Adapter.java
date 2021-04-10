package com.example.jsonrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Filme_Adapter  extends RecyclerView.Adapter<Filme_Adapter.MyViewHolder> {

    private Context mContext;
    private List<Filme_Classe> mData;

    public Filme_Adapter(Context mContext, List<Filme_Classe> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.filmes_itens, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.id.setText(mData.get(position).getId());
        holder.nome.setText(mData.get(position).getId());

        Glide.with(mContext)
                .load(mData.get(position).getImg())
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView nome;
        ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id_txt);
            nome = itemView.findViewById(R.id.nome_txt);
            img = itemView.findViewById(R.id.imageView);
        }
    }
}