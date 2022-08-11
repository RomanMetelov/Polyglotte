package com.polyglotte.app.navigation

import com.polyglotte.R

/**
 * max list size - 5
 */

class BottomNavBarMenuItemsUseCase {
	fun get(): List<FeaturesListItem> {

		val maxFeatureListSize = 5

		val keys: List<Int> = listOf(
			R.string.title_crypto,
			R.string.title_english,
			R.string.title_anne_droid,
			R.string.title_francais,
			R.string.title_all_features
		)

		val features: MutableList<FeaturesListItem> = mutableListOf()

		keys.forEach { key ->
			run {
				val item = AllFeaturesList.getFeaturesListItemByKey(key)
				if (item != null) features.add(item)
			}
		}

		val bottomMenuFeatureListSize = Integer.min(maxFeatureListSize, keys.size)


		return features.toList().subList(0, bottomMenuFeatureListSize)
	}
}
