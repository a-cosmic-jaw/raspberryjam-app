package app.raspberryjam.cli.common

import kotlinx.cinterop.ExperimentalForeignApi

actual class Platform {
    actual fun readLine(): String = readln()

    actual fun getName(): String = "MacOS"

    @OptIn(ExperimentalForeignApi::class)
    actual fun getEnvVar(name: String): String = platform.posix.getenv(name).toString()
}