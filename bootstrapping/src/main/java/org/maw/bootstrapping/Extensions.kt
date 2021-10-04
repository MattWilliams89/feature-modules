package org.maw.bootstrapping

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

object ViewModelCoordinator {
    lateinit var viewModelFactory: ViewModelFactory
}

inline fun <reified T : ViewModel> Fragment.getViewModel() : T? = ViewModelCoordinator.viewModelFactory.create(requireContext())
inline fun <reified T : ViewModel> Activity.getViewModel() : T? = ViewModelCoordinator.viewModelFactory.create(this)