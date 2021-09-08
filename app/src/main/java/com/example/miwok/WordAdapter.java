package com.example.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<word> {
    private int mColorResourceID;
    public WordAdapter(Activity context, ArrayList<word> words,int ColorResourceID) {
        super(context, 0, words);
        mColorResourceID=ColorResourceID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        word currentWord = getItem(position);


        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());


        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        /** find the image view in list_item.xml layout with the id provided*/
        ImageView imgview = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            imgview.setImageResource(currentWord.getImageResourceID());
        } else {
            imgview.setVisibility(View.GONE);
        }
        /**set the theme color for the list item*/
        View textContainer = listItemView.findViewById(R.id.text_container);
        /** find color that resource id maps to*/
        int color= ContextCompat.getColor(getContext(),mColorResourceID);
        /** set the background color of the text containter view*/
        textContainer.setBackgroundColor(color);


        return listItemView;
    }
}
