package com.ergegananputra.jetpack_compose.utils

class StringCheckerUtils(private val string: String) {
    fun isHttpUrl(): Boolean {
        return string
            .isNotEmpty() && string
            .startsWith("http://") || string
            .startsWith("https://")
    }


}