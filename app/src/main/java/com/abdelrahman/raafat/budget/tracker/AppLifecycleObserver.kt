package com.abdelrahman.raafat.budget.tracker


import android.util.Log
import com.google.firebase.crashlytics.ktx.crashlytics
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.google.firebase.ktx.Firebase
import kotlin.math.log

const val TAG = "Abdooooooooo"
class AppLifecycleObserver : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.i(TAG, "onCreate: ")
        Firebase.crashlytics.setCustomKey("app_state", "ON_CREATE")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.i(TAG, "onStart: ")
        Firebase.crashlytics.setCustomKey("app_state", "ON_START")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.i(TAG, "onResume: ")
        Firebase.crashlytics.setCustomKey("app_state", "ON_RESUME")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.i(TAG, "onPause: ")
        Firebase.crashlytics.setCustomKey("app_state", "ON_PAUSE")
    }


    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Log.i(TAG, "onStop: ")
        Firebase.crashlytics.setCustomKey("app_state", "ON_STOP")
    }
    
    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.i(TAG, "onDestroy: ")
        Firebase.crashlytics.setCustomKey("app_state", "ON_DESTROY")
    }
    
}

