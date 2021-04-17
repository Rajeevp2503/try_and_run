package com.example.volley_json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class myadapter extends RecyclerView.Adapter <myadapter.myviewholder> {

    Datum [] datasource;
    Context context;

    public myadapter(Datum[] datasource, Context context) {
        this.datasource = datasource;
        this.context = context;
    }



    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
       View view = inflater.inflate(R.layout.single_row,parent,false);
        return new myviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        Datum datum = datasource[position];
         holder.tv.setText(datum.getTitle());
        //Glide.with(this).load("url").into(holder.img);
        Glide.with(holder.img.getContext()).load(datum.getThumbnailUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
       return datasource.length;
    }

    public class  myviewholder extends  RecyclerView.ViewHolder{

        ImageView img;
        TextView tv;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img =(ImageView)itemView.findViewById(R.id.imageholder);
            tv =(TextView)itemView.findViewById(R.id.theader);



        }
    }
}
