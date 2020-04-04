//
// Created by Sem Allush on 01/04/2020.
//

#ifndef SINTEZI_ENVELOPE_H
#define SINTEZI_ENVELOPE_H

//#include <stdint.h>


class Envelope {
    void setAttack(double attack);
    void setDecay(double decay);
    void setSustain(double sustain);
    void setRelease(double release);
   // float render(float *audioData, int32_t numFrames);

private:
    float attack_ = 0;
    float decay_ = 0;
    float sustain_= 0;
    float release_ = 0;

};


#endif //SINTEZI_ENVELOPE_H
