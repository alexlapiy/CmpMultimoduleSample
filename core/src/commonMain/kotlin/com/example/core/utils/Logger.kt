package com.example.core.utils

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

fun initDebugLogger() {
    Napier.base(DebugAntilog())
}