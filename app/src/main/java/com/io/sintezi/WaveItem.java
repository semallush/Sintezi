package com.io.sintezi;

public class WaveItem {
    private String mWaveName;
    private int mWaveImage;

    public WaveItem(String waveName, int waveImage) {
        mWaveName = waveName;
        mWaveImage = waveImage;
    }

    public String getWaveName() {
        return mWaveName;
    }

    public int getWaveImage() {
        return mWaveImage;
    }
}
