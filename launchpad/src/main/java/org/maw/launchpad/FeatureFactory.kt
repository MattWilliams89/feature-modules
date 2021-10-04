package org.maw.launchpad

import android.content.Context
import androidx.lifecycle.ViewModel
import org.maw.bootstrapping.ViewModelCoordinator
import org.maw.bootstrapping.ViewModelFactory
import org.maw.featurea.FeatureAModule
import org.maw.featureb.FeatureBViewModel

class FeatureFactory {

    fun setup() {
        val serviceLocator = ServiceLocator()
        FeatureAModule.someDependency = Object()

        ViewModelCoordinator.viewModelFactory = object : ViewModelFactory {
            override fun <T: ViewModel> createViewModel(context: Context, viewModelClass: Class<T>): T? {
                when {
                    viewModelClass.isAssignableFrom(FeatureBViewModel::class.java) -> {
                        return FeatureBViewModel() as T
                    }
                }
                return null
            }

        }
    }
}

