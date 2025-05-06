package com.mifos.app.health.logging

import io.github.aakira.napier.Napier

private const val TAG = "AppHealthLogger"

object AppHealthLogger {
    private val logger = Napier

    fun debug(message: String, throwable: Throwable? = null) = logger.d(tag = TAG, message = message, throwable = throwable)
    fun info(message: String, throwable: Throwable? = null) = logger.i(tag = TAG, message = message, throwable = throwable)
    fun warning(message: String, throwable: Throwable? = null) = logger.w(tag = TAG, message = message, throwable = throwable)
    fun error(message: String, throwable: Throwable? = null) = logger.e(tag = TAG, message = message, throwable = throwable)
}
