package org.maw.bootstrapping

import android.content.Context
import androidx.lifecycle.ViewModel

interface ViewModelFactory {
    fun <T: ViewModel> createViewModel(context: Context, viewModelClass: Class<T>): T?
}

inline fun <reified T : ViewModel> ViewModelFactory.create(context: Context): T? = createViewModel(context, T::class.java)

