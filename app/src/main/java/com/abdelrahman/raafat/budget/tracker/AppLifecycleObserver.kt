package com.abdelrahman.raafat.budget.tracker

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase

class AppLifecycleObserver : DefaultLifecycleObserver {
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Firebase.crashlytics.setCustomKey("app_state", "ON_CREATE")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Firebase.crashlytics.setCustomKey("app_state", "ON_START")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Firebase.crashlytics.setCustomKey("app_state", "ON_RESUME")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Firebase.crashlytics.setCustomKey("app_state", "ON_PAUSE")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        Firebase.crashlytics.setCustomKey("app_state", "ON_STOP")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Firebase.crashlytics.setCustomKey("app_state", "ON_DESTROY")
    }
}
