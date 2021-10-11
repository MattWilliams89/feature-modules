package org.maw.launchpad.factories

import org.maw.beef_client.BeefClient
import org.maw.featureb.SearchRepository

class BeefSearchRepository(private val beefClient: BeefClient) : SearchRepository