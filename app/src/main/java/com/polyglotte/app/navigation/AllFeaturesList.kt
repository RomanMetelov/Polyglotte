package com.polyglotte.app.navigation

import com.polyglotte.R

/**
 * all available in app features list
 * add getter and field for topLevelDestinations or not
 * dunno, need to rewrite it but later
 * don't like it this way
 *
 * and don't use title as a key, use id
 */

object AllFeaturesList {
	private val allFeatures: Map<Int, FeaturesListItem> = mapOf(
		Pair(
			R.string.title_alarm,
			FeaturesListItem(R.string.title_alarm, R.drawable.ic_alarm_black_24dp, R.id.navigation_alarm, available = true)
		),
		Pair(
			R.string.title_algorithms,
			FeaturesListItem(R.string.title_algorithms, R.drawable.ic_algorithm_black_24dp, R.id.navigation_algorithms, available = true)
		),
		Pair(
			R.string.title_all_features,
			FeaturesListItem(
				R.string.title_all_features, R.drawable.ic_all_features_black_24dp, R.id.navigation_all_features,
				available = true
			)
		),
		Pair(
			R.string.title_anne_droid,
			FeaturesListItem(
				R.string.title_anne_droid, R.drawable.ic_anne_droid_black_24dp, R.id.navigation_anne_droid,
				available = true
			)
		),
		Pair(
			R.string.title_books,
			FeaturesListItem(R.string.title_books, R.drawable.ic_books_black_24dp, R.id.navigation_books, available = true)
		),
		Pair(
			R.string.title_cars,
			FeaturesListItem(R.string.title_cars, R.drawable.ic_car_black_24dp, R.id.navigation_cars, available = true)
		),
		Pair(
			R.string.title_circles,
			FeaturesListItem(R.string.title_circles, R.drawable.ic_circles_black_24dp, R.id.navigation_circles, available = true)
		),
		Pair(
			R.string.title_crypto,
			FeaturesListItem(R.string.title_crypto, R.drawable.ic_crypto_black_24dp, R.id.navigation_crypto, available = true)
		),
		Pair(
			R.string.title_dates,
			FeaturesListItem(R.string.title_dates, R.drawable.ic_alarm_black_24dp, R.id.navigation_alarm, available = true)
		),
		Pair(
			R.string.title_deutsch,
			FeaturesListItem(R.string.title_deutsch, R.drawable.ic_deutsch_black_24dp, R.id.navigation_alarm, available = true)
		),
		Pair(
			R.string.title_english,
			FeaturesListItem(R.string.title_english, R.drawable.ic_english_black_24dp, R.id.navigation_english, available = true)
		),
		Pair(
			R.string.title_espanol,
			FeaturesListItem(R.string.title_espanol, R.drawable.ic_espanol_black_24dp, R.id.navigation_espanol, available = true)
		),
		Pair(
			R.string.title_finance,
			FeaturesListItem(R.string.title_finance, R.drawable.ic_finance_black_24dp, R.id.navigation_finance, available = true)
		),
		Pair(
			R.string.title_fitness,
			FeaturesListItem(R.string.title_fitness, R.drawable.ic_fitness_black_24dp, R.id.navigation_fitness, available = true)
		),
		Pair(
			R.string.title_francais,
			FeaturesListItem(R.string.title_francais, R.drawable.ic_francais_black_24dp, R.id.navigation_francais, available = true)
		),
		Pair(
			R.string.title_handmade,
			FeaturesListItem(R.string.title_handmade, R.drawable.ic_handmade_black_24dp, R.id.navigation_handmade, available = true)
		),
		Pair(
			R.string.title_holoughts,
			FeaturesListItem(R.string.title_holoughts, R.drawable.ic_holoughts_black_24dp, R.id.navigation_holoughts, available = true)
		),
		Pair(
			R.string.title_ministries,
			FeaturesListItem(
				R.string.title_ministries, R.drawable.ic_ministries_black_24dp, R.id.navigation_ministries,
				available = true
			)
		),
		Pair(
			R.string.title_music,
			FeaturesListItem(R.string.title_music, R.drawable.ic_music_black_24dp, R.id.navigation_music, available = true)
		),
		Pair(
			R.string.title_notes,
			FeaturesListItem(R.string.title_notes, R.drawable.ic_notes_black_24dp, R.id.navigation_notes, available = true)
		),
		Pair(
			R.string.title_nutrition,
			FeaturesListItem(R.string.title_nutrition, R.drawable.ic_nutrition_black_24dp, R.id.navigation_nutrition, available = true)
		),
		Pair(
			R.string.title_scheduler,
			FeaturesListItem(R.string.title_scheduler, R.drawable.ic_scheduler_black_24dp, R.id.navigation_scheduler, available = true)
		),
		Pair(
			R.string.title_self_improvement,
			FeaturesListItem(
				R.string.title_self_improvement, R.drawable.ic_self_improvement_black_24dp, R.id.navigation_self_improvement,
				available = true
			)
		),
		Pair(
			R.string.title_settings,
			FeaturesListItem(R.string.title_settings, R.drawable.ic_settings_black_24dp, R.id.navigation_settings, available = true)
		),
		Pair(
			R.string.title_sports,
			FeaturesListItem(R.string.title_sports, R.drawable.ic_sports_black_24dp, R.id.navigation_sports, available = true)
		),
		Pair(
			R.string.title_stocks,
			FeaturesListItem(R.string.title_stocks, R.drawable.ic_stocks_black_24dp, R.id.navigation_stocks, available = true)
		),
	)

	fun getAllFeaturesList(): List<FeaturesListItem> {
		return allFeatures.values.toList()
	}

	fun getFeaturesListItemByKey(key: Int): FeaturesListItem? {
		return allFeatures[key]
	}
}
