package com.polyglotte.app.data

object AppFeaturesDefaultOrderRepository {
	fun get(): Map<Int, AppFeatureName> {

		val unorderedList = AppFeaturesRepository.getAllFeaturesList()
		val orderedList: MutableMap<Int, AppFeatureName> = mutableMapOf()

		unorderedList.forEach { (key, _) ->
			val index = orderedList.size
			if (key != AppFeatureName.ALL) {
				orderedList[index] = key
			}
		}

		return orderedList.toMap()
	}
}
