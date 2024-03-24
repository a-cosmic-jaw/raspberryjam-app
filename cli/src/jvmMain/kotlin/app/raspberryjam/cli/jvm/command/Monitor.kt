package app.raspberryjam.cli.jvm.command

import app.raspberryjam.cli.command.Monitor
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.convert
import com.github.ajalt.clikt.parameters.types.path
import okio.Path
import okio.Path.Companion.toPath
import kotlin.io.path.absolutePathString

class JvmMonitor() : Monitor() {
    override val directory: String by argument().path(
            mustExist = true,
            mustBeReadable = true,
            mustBeWritable = true).convert {
        it.absolutePathString()
    }
}

