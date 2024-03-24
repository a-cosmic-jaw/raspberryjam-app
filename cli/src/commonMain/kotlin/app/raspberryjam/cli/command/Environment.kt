package app.raspberryjam.cli.command

import app.raspberryjam.cli.common.Glob
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option

class Environment: CliktCommand(
        name = Glob.settings.ENVIRONMENT_COMMAND_NAME,
        help = Glob.settings.ENVIRONMENT_HELP) {
    val printEnvVars by option("-e", "--environment-variables", help = Glob.settings.ENVIRONEMNT_ENVVARS_HELP).flag(default = false)

    init {
    }

    override fun run() {
        if (printEnvVars) {
            Glob.envvars.entries.forEach {
                println("${it.name} - ${it.help}")
            }
        }
    }
}