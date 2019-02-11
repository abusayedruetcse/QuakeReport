package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Context context, ArrayList<Word> banglaword)
    {
        super(context,0,banglaword);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word wordItem=getItem(position);
        TextView textMagnitude=(TextView)listItemView.findViewById(R.id.magnitude);
        textMagnitude.setText(wordItem.getMagnitude()+"");
        TextView textCity=(TextView)listItemView.findViewById(R.id.city);
        textCity.setText(wordItem.getCity());
        TextView textDate=(TextView)listItemView.findViewById(R.id.date);
        textDate.setText(wordItem.getDateCreated());




        return listItemView;
    }
}
