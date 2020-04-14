package com.io.sintezi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ToneAdapter extends ArrayAdapter<ToneItem> {

    public ToneAdapter(Context context, ArrayList<ToneItem> toneList) {
        super(context, 0, toneList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.tone_spinner_row, parent, false
            );
        }

        TextView textViewName = convertView.findViewById(R.id.text_view_name);

        ToneItem currentItem = getItem(position);

        if (currentItem != null) {
            textViewName.setText(currentItem.getCountryName());
        }

        return convertView;
}
}
