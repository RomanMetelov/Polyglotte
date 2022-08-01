package com.polyglotte.menu.domain

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitHelper {

	private const val baseUrl = "https://polyglotte-lycra.ondigitalocean.app"

	fun getInstance(): Retrofit {
		return Retrofit.Builder().baseUrl(baseUrl)
			.addConverterFactory(GsonConverterFactory.create())
			// we need to add converter factory to
			// convert JSON object to Java object
			.build()
	}
}

interface TestApi {
	@GET("/")
	suspend fun getResponseItem(): Response<TestDataClass>
}

data class TestDataClass(
	val count: Int
)
