package app.raspberryjam.cli.jvm

import app.raspberryjam.cli.command.Environment
import app.raspberryjam.cli.command.JvmMonitor
import app.raspberryjam.cli.command.MainCommand
import app.raspberryjam.cli.command.Project
import app.raspberryjam.cli.common.Platform
import com.github.ajalt.clikt.core.subcommands

fun main(args: Array<String>) {
    println("Greetings from ${Platform().getName()}")

    MainCommand().subcommands(JvmMonitor(), Project(), Environment()).main(args)
}
