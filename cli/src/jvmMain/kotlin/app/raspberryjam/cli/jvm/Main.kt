package app.raspberryjam.cli.jvm

import app.raspberryjam.cli.common.Command
import app.raspberryjam.cli.common.Platform

fun main(args: Array<String>) {
    println("Greetings from ${Platform().getName()}")

    Command().run(args)
}
