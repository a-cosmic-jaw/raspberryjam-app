package app.raspberryjam.cli.common

actual class Platform {
    actual fun readLine(): String = System.`in`.readBytes().toString()

    actual fun getName(): String = "JVM (PLATFORM_MAGIC_SAUCE)"
    actual fun getEnvVar(name: String): String = System.getenv(name)
}
