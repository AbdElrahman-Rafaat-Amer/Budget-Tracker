package com.abdelrahman.raafat.budget.tracker

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase

class BTApp : Application() {
    override fun onCreate() {
        super.onCreate()

        Firebase.crashlytics.isCrashlyticsCollectionEnabled = BuildConfig.IS_DEBUG.not()

        val appLifecycleObserver = AppLifecycleObserver()
        ProcessLifecycleOwner.get().lifecycle.addObserver(appLifecycleObserver)
    }
}
