package app.raspberryjam.cli.jvm

import app.raspberryjam.cli.command.Environment
import app.raspberryjam.cli.jvm.command.JvmMonitor
import app.raspberryjam.cli.command.Main
import app.raspberryjam.cli.command.Project
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.mordant.terminal.Terminal

fun main(args: Array<String>) =
    Main(Terminal()).subcommands(JvmMonitor(), Project(), Environment()).main(args)

