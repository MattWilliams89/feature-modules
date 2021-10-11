package org.maw.featureplayground

import android.app.Application
import org.maw.launchpad.setupFeatureFactory

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setupFeatureFactory()
    }
}