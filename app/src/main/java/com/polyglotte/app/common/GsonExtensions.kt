package com.polyglotte.app.common

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> Gson.fromJson(json: String) = fromJson<T>(json, object : TypeToken<T>() {}.type)
//TODO
//I did it myself but don't understand what I did and how exactly it works
