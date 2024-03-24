package app.raspberryjam.cli.jvm

import app.raspberryjam.cli.action.MonitorDirectory
import app.raspberryjam.cli.action.NoOp
import app.raspberryjam.cli.command.Environment
import app.raspberryjam.cli.jvm.command.JvmMonitor
import app.raspberryjam.cli.command.Main
import app.raspberryjam.cli.command.Project
import app.raspberryjam.cli.common.Glob
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.mordant.terminal.Terminal
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
fun getAction(subcommand: String, monitor: JvmMonitor, project: Project, environment: Environment) = when (subcommand) {
    Glob.settings.MONITOR_COMMAND_NAME -> {
        NoOp(subcommand)
    }
    else -> {
        NoOp(subcommand)
    }
}

fun main(args: Array<String>) = runBlocking {
    val monitor = JvmMonitor()
    val project = Project()
    val environment = Environment()
    val raspberryjam = Main(Terminal(hyperlinks = true)).subcommands(monitor, project, environment)
    raspberryjam.main(args)

    getAction(args[0], monitor, project, environment).also { action ->
        val md = action as MonitorDirectory
        md.doBefore(null)
        md.run()
        //action.doAfter(null)
    }

    return@runBlocking
}

