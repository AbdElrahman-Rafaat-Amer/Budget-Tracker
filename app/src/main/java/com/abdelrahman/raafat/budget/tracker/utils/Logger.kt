package com.abdelrahman.raafat.budget.tracker.utils

import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.crashlytics.setCustomKeys
import com.google.firebase.ktx.Firebase
import java.util.Locale

fun logDataForFirebase(screenName: String) {
    val crashlytics = Firebase.crashlytics
    crashlytics.setCustomKeys {
        key("screen_name", screenName)
        key("user_language", Locale.getDefault().language)
        key("user_region", Locale.getDefault().country)
        key("user_displayCountry", Locale.getDefault().displayCountry)
    }
}
