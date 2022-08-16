package com.polyglotte.app.data

import com.polyglotte.R

/**
 * all available in app features list
 */

object AppFeaturesRepository {
	private val allFeatures: Map<AppFeatureName, AppFeaturesRepositoryItem> = mapOf(
		Pair(
			AppFeatureName.ALARM,
			AppFeaturesRepositoryItem(R.string.title_alarm, R.drawable.ic_alarm_black_24dp, R.id.navigation_alarm, available = true)
		),
		Pair(
			AppFeatureName.ALGORITHMS,
			AppFeaturesRepositoryItem(R.string.title_algorithms, R.drawable.ic_algorithm_black_24dp, R.id.navigation_algorithms, available = true)
		),
		Pair(
			AppFeatureName.ALL,
			AppFeaturesRepositoryItem(R.string.title_all_features, R.drawable.ic_all_features_black_24dp, R.id.navigation_all_features, available = true)
		),
		Pair(
			AppFeatureName.ANDROID,
			AppFeaturesRepositoryItem(R.string.title_anne_droid, R.drawable.ic_anne_droid_black_24dp, R.id.navigation_anne_droid, available = true)
		),
		Pair(
			AppFeatureName.BOOKS,
			AppFeaturesRepositoryItem(R.string.title_books, R.drawable.ic_books_black_24dp, R.id.navigation_books, available = true)
		),
		Pair(
			AppFeatureName.CARS,
			AppFeaturesRepositoryItem(R.string.title_cars, R.drawable.ic_car_black_24dp, R.id.navigation_cars, available = true)
		),
		Pair(
			AppFeatureName.CIRCLES,
			AppFeaturesRepositoryItem(R.string.title_circles, R.drawable.ic_circles_black_24dp, R.id.navigation_circles, available = true)
		),
		Pair(
			AppFeatureName.CRYPTO,
			AppFeaturesRepositoryItem(R.string.title_crypto, R.drawable.ic_crypto_black_24dp, R.id.navigation_crypto, available = true)
		),
		Pair(
			AppFeatureName.DATES,
			AppFeaturesRepositoryItem(R.string.title_dates, R.drawable.ic_alarm_black_24dp, R.id.navigation_alarm, available = true)
		),
		Pair(
			AppFeatureName.DEUTSCH,
			AppFeaturesRepositoryItem(R.string.title_deutsch, R.drawable.ic_deutsch_black_24dp, R.id.navigation_alarm, available = true)
		),
		Pair(
			AppFeatureName.ENGLISH,
			AppFeaturesRepositoryItem(R.string.title_english, R.drawable.ic_english_black_24dp, R.id.navigation_english, available = true)
		),
		Pair(
			AppFeatureName.ESPANOL,
			AppFeaturesRepositoryItem(R.string.title_espanol, R.drawable.ic_espanol_black_24dp, R.id.navigation_espanol, available = true)
		),
		Pair(
			AppFeatureName.FINANCE,
			AppFeaturesRepositoryItem(R.string.title_finance, R.drawable.ic_finance_black_24dp, R.id.navigation_finance, available = true)
		),
		Pair(
			AppFeatureName.FITNESS,
			AppFeaturesRepositoryItem(R.string.title_fitness, R.drawable.ic_fitness_black_24dp, R.id.navigation_fitness, available = true)
		),
		Pair(
			AppFeatureName.FRANCAIS,
			AppFeaturesRepositoryItem(R.string.title_francais, R.drawable.ic_francais_black_24dp, R.id.navigation_francais, available = true)
		),
		Pair(
			AppFeatureName.HANDMADE,
			AppFeaturesRepositoryItem(R.string.title_handmade, R.drawable.ic_handmade_black_24dp, R.id.navigation_handmade, available = true)
		),
		Pair(
			AppFeatureName.HOLOUGHTS,
			AppFeaturesRepositoryItem(R.string.title_holoughts, R.drawable.ic_holoughts_black_24dp, R.id.navigation_holoughts, available = true)
		),
		Pair(
			AppFeatureName.MINISTRIES,
			AppFeaturesRepositoryItem(R.string.title_ministries, R.drawable.ic_ministries_black_24dp, R.id.navigation_ministries, available = true)
		),
		Pair(
			AppFeatureName.MUSIC,
			AppFeaturesRepositoryItem(R.string.title_music, R.drawable.ic_music_black_24dp, R.id.navigation_music, available = true)
		),
		Pair(
			AppFeatureName.NOTES,
			AppFeaturesRepositoryItem(R.string.title_notes, R.drawable.ic_notes_black_24dp, R.id.navigation_notes, available = true)
		),
		Pair(
			AppFeatureName.NUTRITION,
			AppFeaturesRepositoryItem(R.string.title_nutrition, R.drawable.ic_nutrition_black_24dp, R.id.navigation_nutrition, available = true)
		),
		Pair(
			AppFeatureName.SCHEDULER,
			AppFeaturesRepositoryItem(R.string.title_scheduler, R.drawable.ic_scheduler_black_24dp, R.id.navigation_scheduler, available = true)
		),
		Pair(
			AppFeatureName.SELF_IMPROVEMENT,
			AppFeaturesRepositoryItem(R.string.title_self_improvement, R.drawable.ic_self_improvement_black_24dp, R.id.navigation_self_improvement, available = true)
		),
		Pair(
			AppFeatureName.SETTINGS,
			AppFeaturesRepositoryItem(R.string.title_settings, R.drawable.ic_settings_black_24dp, R.id.navigation_settings, available = true)
		),
		Pair(
			AppFeatureName.SPORTS,
			AppFeaturesRepositoryItem(R.string.title_sports, R.drawable.ic_sports_black_24dp, R.id.navigation_sports, available = true)
		),
		Pair(
			AppFeatureName.STOCKS,
			AppFeaturesRepositoryItem(R.string.title_stocks, R.drawable.ic_stocks_black_24dp, R.id.navigation_stocks, available = true)
		)
	)

	fun getAllFeaturesList(): Map<AppFeatureName, AppFeaturesRepositoryItem> {
		return allFeatures
	}

	fun getFeaturesListItemByKey(key: AppFeatureName): AppFeaturesRepositoryItem? {
		return allFeatures[key]
	}
}
