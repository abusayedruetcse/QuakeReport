package com.example.android.quakereport;

import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WordAdapter extends ArrayAdapter<Word> {
    private static final String stringSeparator="of";
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
        //splitting location into offset and primary
        String offsetLocation;
        String primaryLocation;
        String originalLocation=wordItem.getLocation();
        if(originalLocation.contains(stringSeparator))
        {
            String[] parts=originalLocation.split(stringSeparator);
            offsetLocation=parts[0]+stringSeparator;
            primaryLocation=parts[1];
        }
        else
        {
            offsetLocation=getContext().getString(R.string.near) ;
            primaryLocation=originalLocation;
        }
        //offsetLocation
        TextView textOffset=(TextView)listItemView.findViewById(R.id.offsetLocation);
        textOffset.setText(offsetLocation);
        //primaryLocation
        TextView textPrimary=(TextView)listItemView.findViewById(R.id.primaryLocation);
        textPrimary.setText(primaryLocation);

        //Date and time converting from miliseconds.
        long timeInMilliseconds=wordItem.getDateCreated();
        Date dateObject = new Date(timeInMilliseconds);
        //date format
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);
        //time format
        SimpleDateFormat timeFormatter=new SimpleDateFormat("h:mm a");
        String timeToDisplay =timeFormatter.format(dateObject);
        TextView textDate=(TextView)listItemView.findViewById(R.id.date);
        textDate.setText(dateToDisplay);
        TextView textTime=(TextView)listItemView.findViewById(R.id.time);
        textTime.setText(timeToDisplay);






        return listItemView;
    }
}
