package app.raspberryjam.cli.common

expect class Platform {
    fun readLine(): String

    fun getName(): String

    fun getEnvVar(name: String): String
}