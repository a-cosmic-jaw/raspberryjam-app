package app.raspberryjam.cli.command

import app.raspberryjam.cli.common.Glob
import com.github.ajalt.clikt.completion.completionOption
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.context
import com.github.ajalt.clikt.parameters.options.versionOption
import com.github.ajalt.mordant.terminal.Terminal

class Main(t: Terminal): CliktCommand(
        name = Glob.settings.RASPBERRYJAM_EXECUTABLE_NAME,
        help = Glob.settings.RASPBERRYJAM_HELP,
        autoCompleteEnvvar = Glob.envvars.RASPBERRYJAM_CLI_AUTOCOMPLETE.name,
        allowMultipleSubcommands = true) {
    init {
        //https://github.com/jmfayard/kotlin-cli-starter/blob/3db002190449a51d1df84df7a3e8a882bd6f7f3c/src/commonMain/kotlin/cli/CliCommand.kt
        //completionOption()
        versionOption("0.0.2")
        completionOption()

        context {
            terminal = t
            autoEnvvarPrefix = "RASPBERRYJAM_CLI"
        }
    }

    override fun run() {

    }
}