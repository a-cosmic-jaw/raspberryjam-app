package app.raspberryjam.cli.jvm

import app.raspberryjam.cli.command.Environment
import app.raspberryjam.cli.jvm.command.JvmMonitor
import app.raspberryjam.cli.command.Main
import app.raspberryjam.cli.command.Project
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.mordant.terminal.Terminal
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    val raspberryjam = Main(Terminal(hyperlinks = true)).subcommands(JvmMonitor(), Project(), Environment())
    raspberryjam.main(args)
//    println(raspberryjam.commandName)
//    raspberryjam.messages.forEach {
//        println(it)
//    }
}

