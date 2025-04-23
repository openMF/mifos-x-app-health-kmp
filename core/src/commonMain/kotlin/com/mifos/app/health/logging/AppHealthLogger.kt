package com.mifos.app.health.logging

import com.diamondedge.logging.KmLogging

private const val TAG = "AppHealthLogger"

object AppHealthLogger {
    private val logger = KmLogging

    fun debug(message: String) = logger.debug(TAG,message)
    fun info(message: String) = logger.info(TAG,message)
    fun warning(message: String) = logger.warn(TAG,message)
    fun error(message: String, throwable: Throwable? = null) = logger.error(TAG, message, throwable)
}
