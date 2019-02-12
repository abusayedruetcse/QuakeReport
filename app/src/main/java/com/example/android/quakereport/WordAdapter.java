package com.example.android.quakereport;

import android.content.Context;
import android.location.Location;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.graphics.drawable.GradientDrawable;

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
        //DecimalFormatting
        Double magnitude=wordItem.getMagnitude();
        DecimalFormat formatter = new DecimalFormat("0.0");
        String outputMagnitude = formatter.format(magnitude);
        TextView textMagnitude=(TextView)listItemView.findViewById(R.id.magnitude);
        textMagnitude.setText(outputMagnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) textMagnitude.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = this.getMagnitudeColor(magnitude);  //calling method self defined.

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


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
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
