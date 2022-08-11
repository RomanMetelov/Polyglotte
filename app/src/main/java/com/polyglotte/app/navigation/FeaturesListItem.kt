package com.polyglotte.app.navigation

import android.view.Menu

data class FeaturesListItem(
	var labelId: Int,
	var imageId: Int,
	var destinationId: Int,
	var index: Int = 0,
	val category: Int = Menu.NONE,
	var available: Boolean
)
