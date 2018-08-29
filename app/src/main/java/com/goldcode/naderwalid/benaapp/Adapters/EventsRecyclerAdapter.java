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

import com.goldcode.naderwalid.benaapp.Activities.HomeActivity;
import com.goldcode.naderwalid.benaapp.Event;
import com.goldcode.naderwalid.benaapp.R;

import java.util.ArrayList;

/**
 * Created by NaderWalid on 7/30/2018.
 */

public class EventsRecyclerAdapter extends RecyclerView.Adapter<EventsRecyclerAdapter.MyHolder> {
    ArrayList<Event> events_list = new ArrayList<>();
    LayoutInflater inflater;
    Context thisContext;
//    String [] images ;

    public EventsRecyclerAdapter(Context context, ArrayList<Event> list/*, String[] imagesArray*/){
        this.events_list = list;
//        this.images = imagesArray;
        inflater = LayoutInflater.from(context);
        thisContext = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.event_list_item, parent, false);
        return new MyHolder(view);    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        Event event = events_list.get(position);

        holder.event_name.setText(event.getName());
        holder.event_desc.setText(event.getDescription());
        holder.event_author.setText(event.getAuthor());
//        holder.event_img.setImageResource(images[position]);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ONCLICKCARD",position+"");
                Log.d("CARDNAME",events_list.get(position).getName());
                Toast.makeText(thisContext,events_list.get(position).getName()
                        +" on :"+position , Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return events_list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView event_name,event_desc,event_author;
        ImageView event_img;
        CardView cardView;
        public MyHolder(View itemView) {
            super(itemView);
            event_img = itemView.findViewById(R.id.event_img);
            event_name =  itemView.findViewById(R.id.event_name);
            event_desc =  itemView.findViewById(R.id.event_desc);
            event_author = itemView.findViewById(R.id.event_author);
            cardView = itemView.findViewById(R.id.event_cardview);
        }
    }
}
