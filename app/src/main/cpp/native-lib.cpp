#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_abdelrahman_raafat_budget_tracker_MainActivity_stringFromJNI(JNIEnv *env, jobject object) {
    std::string hello = "Hello from dweweeJni";
    return env->NewStringUTF(hello.c_str());
}