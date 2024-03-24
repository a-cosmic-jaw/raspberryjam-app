import app.raspberryjam.cli.command.Environment
import app.raspberryjam.cli.command.MainCommand
import app.raspberryjam.cli.command.Monitor
import app.raspberryjam.cli.command.Project
import com.github.ajalt.clikt.core.subcommands

fun main(args: Array<String>) {
    MainCommand().subcommands(Monitor(), Project(), Environment()).main(args)
}
