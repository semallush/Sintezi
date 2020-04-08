//
// Created by Sem Allush on 31/03/2020.
//

#include "Oscillator.h"
#include <math.h>
#include <time.h>
#include <android/log.h>

#define  LOG_TAG    "testjni"
#define  ALOG(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)

#define TWO_PI (3.14159 * 2)
#define AMPLITUDE 1
#define FREQUENCY 220.0

void Oscillator::setSampleRate(int32_t sampleRate) {
    sampleRate_ = sampleRate;
    phaseIncrement_ = (TWO_PI * frequency_) / (double) sampleRate;

}

void Oscillator::setWaveOn(bool isWaveOn, float frequency) {
    isWaveOn_.store(isWaveOn);
    frequency_ = frequency;
    phaseIncrement_ = (TWO_PI * frequency_) / (double) sampleRate_;

}

void Oscillator::setWaveShape(wave waveShape) {
    waveShape_ = waveShape;
}

void Oscillator::render(float *audioData, int32_t numFrames) {






    if (!isWaveOn_.load()) phase_ = 0;
    double amp = AMPLITUDE;


    //ALOG("%f", amp);

    for (int i = 0; i < numFrames; i++) {

        if (isWaveOn_.load()) {

                // Calculates the next sample value for the sine wave.
                if (waveShape_ == Sin) {

                    audioData[i] = (float) (sin(phase_) * amp);

                } else if (waveShape_ == Square) {

                    if (phase_ > (TWO_PI / 2)) {
                        audioData[i] = (float) -amp;
                    } else {
                        audioData[i] = (float) amp;
                    }

                } else if (waveShape_ == Triangle) {

                    audioData[i] = (asin(cos(phase_)) / (TWO_PI / 4)) * amp;

                } else if (waveShape_ == Saw) {

                    if (phase_ < (TWO_PI / 2)) {
                        audioData[i] = amp * (((phase_ + TWO_PI / 2) / (TWO_PI / 2)) - 1);
                    } else {
                        audioData[i] = amp * (((phase_) / (TWO_PI / 2)) - 2);
                    }

                } else {
                    audioData[i] = (float) (sin(phase_) * amp);
                }


            // Increments the phase, handling wrap around.
            phase_ += phaseIncrement_;
            if (phase_ > TWO_PI) phase_ -= TWO_PI;

        } else {
            // Outputs silence by setting sample value to zero.
            audioData[i] = 0;
        }
    }
}