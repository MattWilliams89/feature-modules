package org.maw.bootstrapping

import android.content.Context

interface FeatureFactory {
    fun <T> create(context: Context, klass: Class<T>): T
}

inline fun <reified T> FeatureFactory.create(context: Context): T = create(context, T::class.java)

