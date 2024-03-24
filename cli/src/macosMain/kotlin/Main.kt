import app.raspberryjam.cli.command.Environment
import app.raspberryjam.cli.command.Main
import app.raspberryjam.cli.command.Monitor
import app.raspberryjam.cli.command.Project
import com.github.ajalt.clikt.core.subcommands

fun main(args: Array<String>) =
    Main().subcommands(Monitor(), Project(), Environment()).main(args)
