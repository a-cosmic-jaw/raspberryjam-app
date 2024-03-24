import app.raspberryjam.cli.action.MonitorDirectory
import app.raspberryjam.cli.action.NoOp
import app.raspberryjam.cli.command.Environment
import app.raspberryjam.cli.command.Main
import app.raspberryjam.cli.command.Monitor
import app.raspberryjam.cli.command.Project
import app.raspberryjam.cli.common.Glob
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.mordant.terminal.Terminal
import kotlinx.coroutines.runBlocking

fun getAction(subcommand: String, monitor: Monitor, project: Project, environment: Environment) = when (subcommand) {
    Glob.settings.MONITOR_COMMAND_NAME -> {
        MonitorDirectory(monitor.directory)
    }
    else -> {
        NoOp(subcommand)
    }
}

fun main(args: Array<String>) = runBlocking {
    val monitor = Monitor()
    val project = Project()
    val environment = Environment()
    val raspberryjam = Main(Terminal(hyperlinks = true)).subcommands(monitor, project, environment)
    raspberryjam.main(args)

    args.forEach {
        println("args=$it")
    }
    getAction(args[0], monitor, project, environment).also { action ->
        action.doBefore(null)
        action.run()
        //action.doAfter(null)
    }

    return@runBlocking
}

