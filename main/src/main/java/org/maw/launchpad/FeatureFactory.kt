package org.maw.launchpad

import android.content.Context
import androidx.lifecycle.ViewModel
import org.maw.beef_client.createBeefClient
import org.maw.bootstrapping.ViewModelCoordinator
import org.maw.bootstrapping.FeatureFactory
import org.maw.featureb.SearchDependencies
import org.maw.launchpad.factories.createSearchFeature
import org.maw.vehicledetails_feature.VehicleDetailsDependencies
import org.maw.vehicledetails_feature.createVehicleDetailsFeature

fun setupFeatureFactory() {
    val serviceLocator = ServiceLocator(beefClient = createBeefClient())
    ViewModelCoordinator.featureFactory = ServiceLocatorAwareFeatureFactory(serviceLocator)
}

class ServiceLocatorAwareFeatureFactory(private val serviceLocator: ServiceLocator) : FeatureFactory {
    override fun <T> create(
        context: Context,
        klass: Class<T>
    ): T {
        when {
            klass.isAssignableFrom(SearchDependencies::class.java) -> {
                return createSearchFeature(serviceLocator.beefClient) as T
            }
            klass.isAssignableFrom(VehicleDetailsDependencies::class.java) -> {
                return createVehicleDetailsFeature(serviceLocator.beefClient) as T
            }
        }
        throw UnknownFeatureModelException(klass)
    }
}

class UnknownFeatureModelException(klass: Class<*>) : Throwable(klass.toString())

