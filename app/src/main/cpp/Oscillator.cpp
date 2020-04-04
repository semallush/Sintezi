//
// Created by Sem Allush on 31/03/2020.
//

#include "Oscillator.h"
#include <math.h>

#define TWO_PI (3.14159 * 2)
#define AMPLITUDE 2
#define FREQUENCY 880.0

void Oscillator::setSampleRate(int32_t sampleRate) {
    phaseIncrement_ = (TWO_PI * FREQUENCY) / (double) sampleRate;

}

void Oscillator::setWaveOn(bool isWaveOn) {
    isWaveOn_.store(isWaveOn);

}

void Oscillator::setWaveShape(wave waveShape) {
    waveShape_ = waveShape;
}

void Oscillator::render(float *audioData, int32_t numFrames) {

    if (!isWaveOn_.load()) phase_ = 0;

    for (int i = 0; i < numFrames; i++) {

        if (isWaveOn_.load()) {



            // Calculates the next sample value for the sine wave.
            if (waveShape_ == Sin){

                audioData[i] = (float) (sin(phase_) * AMPLITUDE);

            }else if (waveShape_ == Square){

                if (phase_ > (TWO_PI/2)) {
                    audioData[i] = (float) -AMPLITUDE;
                }else {
                    audioData[i] = (float) AMPLITUDE;
                }

            }else if (waveShape_ == Triangle){

                audioData[i] = (asin(cos(phase_)) / (TWO_PI/4))*AMPLITUDE;

            }else if (waveShape_ == Saw){

                if (phase_ < (TWO_PI/2)) {
                    audioData[i] = AMPLITUDE *(((phase_ + TWO_PI/2)/(TWO_PI/2)) -1);
                }else {
                    audioData[i] = AMPLITUDE *(((phase_)/(TWO_PI/2)) -2);
                }

            }else {
                audioData[i] = (float) (sin(phase_) * AMPLITUDE);
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