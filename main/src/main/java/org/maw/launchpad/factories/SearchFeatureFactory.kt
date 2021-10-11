package org.maw.launchpad.factories

import org.maw.beef_client.BeefClient
import org.maw.featureb.SearchDependencies

fun createSearchFeature(beefClient: BeefClient): SearchDependencies {
    return SearchDependencies(searchRepository = BeefSearchRepository(beefClient))
}

