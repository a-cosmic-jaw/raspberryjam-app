package app.raspberryjam.cli.command

import app.raspberryjam.cli.common.Glob
import com.github.ajalt.clikt.completion.completionOption
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.convert
import okio.Path
import okio.Path.Companion.toPath

open class Monitor: CliktCommand(
    name = Glob.strings.MONITOR_COMMAND_NAME,
    help = Glob.strings.MONITOR_HELP) {
    open val directory: Path by argument().convert {
        it.toPath()
    }

    init {
    }

    override fun run() {

        println("directory=$directory")
    }
}
