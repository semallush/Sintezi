//
// Created by Sem Allush on 31/03/2020.
//

#ifndef SINTEZI_AUDIOENGINE_H
#define SINTEZI_AUDIOENGINE_H

#include <aaudio/AAudio.h>
#include "Oscillator.h"

class AudioEngine {
public:
    bool start();
    void stop();
    void restart();
    void setToneOn(bool isToneOn, float frequency);
    void setWaveShape(int waveShape);

private:
    Oscillator oscillator_;
    AAudioStream *stream_;
};


#endif //SINTEZI_AUDIOENGINE_H
