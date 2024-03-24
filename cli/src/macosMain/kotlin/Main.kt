import app.raspberryjam.cli.command.Environment
import app.raspberryjam.cli.command.Main
import app.raspberryjam.cli.command.Monitor
import app.raspberryjam.cli.command.Project
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.mordant.terminal.Terminal
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    Main(Terminal(hyperlinks = true)).subcommands(Monitor(), Project(), Environment()).main(args)
}

