package com.example.cmpmultimodulesample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform