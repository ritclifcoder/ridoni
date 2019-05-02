package com.example.berberuyg;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.berberuyg.pojos.Places;


public class CustomAdapter extends BaseAdapter {

    MainActivity mainActivity;
    Places places;

    public CustomAdapter(MainActivity mainActivity, Places myPlaces) {
        this.mainActivity = mainActivity;
        this.places = myPlaces;
    }

    @Override
    public int getCount() {
        return places.getList().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mainActivity);
        View view = layoutInflater.inflate(R.layout.items,null);

        TextView nameTextView = view.findViewById(R.id.name_tv);
        TextView vicinitTextView = view.findViewById(R.id.vicinity_tv);

        nameTextView.setText(places.getList().get(position).getName());
        vicinitTextView.setText(places.getList().get(position).getVicinity());

        return view;
    }
}
