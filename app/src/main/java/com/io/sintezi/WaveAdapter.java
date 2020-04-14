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

public class WaveAdapter extends ArrayAdapter<WaveItem> {

    public WaveAdapter(Context context, ArrayList<WaveItem> waveList) {
        super(context, 0, waveList);
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
                    R.layout.wave_spinner_row, parent, false
            );
        }

        ImageView imageViewWave = convertView.findViewById(R.id.image_view_wave);
        TextView textViewWave = convertView.findViewById(R.id.text_view_name);

        WaveItem currentItem = getItem(position);

        if (currentItem != null) {
            imageViewWave.setImageResource(currentItem.getWaveImage());
            textViewWave.setText(currentItem.getWaveName());
        }

        return convertView;
    }
}
