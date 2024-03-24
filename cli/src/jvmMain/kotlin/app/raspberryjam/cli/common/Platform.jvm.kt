package app.raspberryjam.cli.common

import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.defaultLazy
import com.github.ajalt.clikt.parameters.options.*
import com.github.ajalt.clikt.parameters.types.file
import com.github.ajalt.clikt.parameters.types.int
import com.github.ajalt.clikt.parameters.types.path
import java.nio.file.Path
import kotlin.io.path.absolutePathString

actual class Platform {
    actual fun readLine(): String = System.`in`.readBytes().toString()

    actual fun getName(): String = "JVM"

    actual fun getEnvVar(name: String): String = System.getenv(name)
}




