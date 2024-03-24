package app.raspberryjam.cli.command

import app.raspberryjam.cli.action.MonitorDirectory
import app.raspberryjam.cli.common.Glob
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.convert
import com.github.ajalt.clikt.parameters.arguments.optional
import kotlinx.coroutines.runBlocking
import okio.Path
import okio.Path.Companion.toPath

open class Monitor: CliktCommand(
        name = Glob.settings.MONITOR_COMMAND_NAME,
        help = Glob.settings.MONITOR_HELP) {
    open val directory: String by argument()

    override fun run() {

    }
}
