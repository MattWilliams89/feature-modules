package org.maw.bootstrapping

import android.app.Activity
import androidx.fragment.app.Fragment

inline fun <reified T> Fragment.get() : T = FeatureCoordinator.featureFactory.create(requireContext())
inline fun <reified T> Activity.get() : T = FeatureCoordinator.featureFactory.create(this)