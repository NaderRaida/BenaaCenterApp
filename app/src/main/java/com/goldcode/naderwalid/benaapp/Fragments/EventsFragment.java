package com.goldcode.naderwalid.benaapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.goldcode.naderwalid.benaapp.Adapters.EventsRecyclerAdapter;
import com.goldcode.naderwalid.benaapp.Event;
import com.goldcode.naderwalid.benaapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by NaderWalid on 7/16/2018.
 */

public class EventsFragment extends android.support.v4.app.Fragment {
    RecyclerView eventsRecyclerView;
//    ArrayList<Event> events_list;
//    String[] images;
ArrayList<Event> jsonEvents = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        events_list = this.getArguments().getParcelableArrayList(AppConstants.INTENT_KEY_EVENT);
//        images = getArguments().getStringArray(AppConstants.INTENT_KEY_EVENT_IMG);
        getJson();
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        eventsRecyclerView = view.findViewById(R.id.event_recycler_view);
        eventsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        EventsRecyclerAdapter myRecyclerAdapter = new EventsRecyclerAdapter(getContext(), jsonEvents/*, images*/);
        eventsRecyclerView.setAdapter(myRecyclerAdapter);


        return view;
    }
    private void getJson() {
        String json;
        try {
            InputStream inputStream = this.getActivity().getAssets().open("events.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                jsonEvents.add(new Event(String.valueOf(jsonObject.get("name")),
                        String.valueOf(jsonObject.get("description")),
                        String.valueOf(jsonObject.get("author"))/*,
                        String.valueOf(jsonObject.get("photo"))*/
                ));
            }
           /* for (int j = 0; j < jsonEvents.size(); j++) {
                drawable[j] = jsonEvents.get(j).getImage();
            }*/
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
}
