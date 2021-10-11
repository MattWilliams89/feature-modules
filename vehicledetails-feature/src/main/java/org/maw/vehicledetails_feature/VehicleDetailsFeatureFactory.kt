package org.maw.vehicledetails_feature

import org.maw.beef_client.BeefClient
import org.maw.vehicledetails_feature.repo.BeefClientVehicleDetailsRepository

fun createVehicleDetailsFeature(beefClient: BeefClient) : VehicleDetailsDependencies {
    return VehicleDetailsDependencies(vehicleDetailsRepository = BeefClientVehicleDetailsRepository(beefClient))
}