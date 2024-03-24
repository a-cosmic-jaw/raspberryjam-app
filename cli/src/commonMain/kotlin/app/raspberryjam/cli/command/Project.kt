package app.raspberryjam.cli.command

import app.raspberryjam.cli.common.Glob
import com.github.ajalt.clikt.completion.completionOption
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.optionalValueLazy

class Project: CliktCommand(
    name = Glob.strings.PROJECT_COMMAND_NAME,
    help = Glob.strings.PROJECT_HELP) {
    val id by option(envvar = Glob.envvars.RASPBERRYJAM_DEFAULT_PROJECT.name, help = Glob.strings.PROJECT_HELP_ID).default("default_id (loaded from ~/.raspberryjam/)")
    val new: Boolean by option("-n", "--new", help = Glob.strings.PROJECT_HELP_NEW).flag()
    val workerAddress by option("-w", "--worker-address", help = Glob.strings.PROJECT_WORKER_ADDRESS_HELP, envvar = Glob.envvars.RASPBERRYJAM_WORKER_ADDRESS.name).default("localhost:8080")

    init {
    }

    override fun run() {
        println("id=$id")
        println("new=$new")
    }
}