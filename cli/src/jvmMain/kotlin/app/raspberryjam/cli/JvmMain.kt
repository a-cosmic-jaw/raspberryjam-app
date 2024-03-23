package app.raspberryjam.cli

import app.raspberryjam.cli.common.Platform

fun main(args: Array<String>) {
    println("Greetings from ${Platform().getName()}")
}
