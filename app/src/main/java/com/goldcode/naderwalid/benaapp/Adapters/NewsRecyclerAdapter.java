package com.goldcode.naderwalid.benaapp.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.goldcode.naderwalid.benaapp.Event;
import com.goldcode.naderwalid.benaapp.New;
import com.goldcode.naderwalid.benaapp.R;

import java.util.ArrayList;

/**
 * Created by NaderWalid on 8/8/2018.
 */

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.MyHolder> {
    ArrayList<New> news_list = new ArrayList<>();
    LayoutInflater inflater;
    Context thisContext;
//    String [] images ;

    public NewsRecyclerAdapter(Context context, ArrayList<New> list/*, String[] imagesArray*/) {
        this.news_list = list;
//        this.images = imagesArray;
        inflater = LayoutInflater.from(context);
        thisContext = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.new_list_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        New news = news_list.get(position);

//        holder.event_name.setText(news.getName());
//        holder.event_desc.setText(news.getDescription());
//        holder.event_author.setText(news.getAuthor());
////        holder.event_img.setImageResource(images[position]);
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("ONCLICKCARD",position+"");
//                Log.d("CARDNAME", news_list.get(position).getName());
//                Toast.makeText(thisContext, news_list.get(position).getName()
//                        +" on :"+position , Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return news_list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView new_name, new_desc, new_author;
        ImageView new_img;
        CardView cardView;

        public MyHolder(View itemView) {
            super(itemView);
            new_img = itemView.findViewById(R.id.new_img);
            new_name = itemView.findViewById(R.id.new_title);
            new_desc = itemView.findViewById(R.id.new_content);
            new_author = itemView.findViewById(R.id.new_author);
            cardView = itemView.findViewById(R.id.new_cardview);
        }
    }
}

