package app.raspberryjam.cli.command

import app.raspberryjam.cli.common.Glob
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.convert
import okio.Path
import okio.Path.Companion.toPath

open class Monitor: CliktCommand(
        name = Glob.settings.MONITOR_COMMAND_NAME,
        help = Glob.settings.MONITOR_HELP) {
    open val directory: Path by argument().convert {
        it.toPath()
    }

    init {
    }

    override fun run() {

        println("directory=$directory")
    }
}
