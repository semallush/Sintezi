#include <jni.h>
#include <string>
#include <android/input.h>
#include "AudioEngine.h"

static AudioEngine *audioEngine = new AudioEngine();

extern "C" {

JNIEXPORT void JNICALL
Java_com_io_sintezi_MainActivity_touchEvent(JNIEnv *env, jobject obj, jint action, jfloat frequency) {
    switch (action) {
        case AMOTION_EVENT_ACTION_DOWN:
            audioEngine->setToneOn(true, frequency);
        break;
        case AMOTION_EVENT_ACTION_UP:
            audioEngine->setToneOn(false, frequency);
        break;
        default:
        break;
    }
}

JNIEXPORT void JNICALL
Java_com_io_sintezi_MainActivity_startEngine(JNIEnv *env, jobject /* this */) {
audioEngine->start();
}

JNIEXPORT void JNICALL
Java_com_io_sintezi_MainActivity_stopEngine(JNIEnv *env, jobject /* this */) {
audioEngine->stop();
}

}