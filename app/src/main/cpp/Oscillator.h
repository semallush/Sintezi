//
// Created by Sem Allush on 31/03/2020.
//

#ifndef SINTEZI_OSCILLATOR_H
#define SINTEZI_OSCILLATOR_H

#include <atomic>
#include <stdint.h>

enum wave{Sin,Square,Triangle,Saw};

class Oscillator {
public:
    void setWaveOn(bool isWaveOn, float frequency);
    void setSampleRate(int32_t sampleRate);
    void render(float *audioData, int32_t numFrames);
    void setWaveShape(wave waveShape);

private:
    std::atomic<bool> isWaveOn_{false};
    double phase_ = 0.0;
    double phaseIncrement_ = 0.0;
    float frequency_ = 0.0;
    int sampleRate_ = 0;
    wave waveShape_ = Sin;

};


#endif //SINTEZI_OSCILLATOR_H
