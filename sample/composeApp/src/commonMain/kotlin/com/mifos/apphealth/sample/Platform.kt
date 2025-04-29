package com.mifos.apphealth.sample

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform