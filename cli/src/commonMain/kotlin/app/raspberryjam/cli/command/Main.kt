package app.raspberryjam.cli.command

import app.raspberryjam.cli.common.Glob
import com.github.ajalt.clikt.completion.completionOption
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.versionOption

class MainCommand(): CliktCommand(name = Glob.strings.RASPBERRYJAM_EXECUTABLE_NAME) {
    init {
        //https://github.com/jmfayard/kotlin-cli-starter/blob/3db002190449a51d1df84df7a3e8a882bd6f7f3c/src/commonMain/kotlin/cli/CliCommand.kt
        //completionOption()
        versionOption("0.0.2")
        completionOption()
    }

    override fun run() {

    }
}