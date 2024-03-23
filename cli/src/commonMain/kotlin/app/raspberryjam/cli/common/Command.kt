package app.raspberryjam.cli.common

import kotlinx.cli.*


class Command() {
    val parser = ArgParser("raspberryjam")
    val version by parser.option(ArgType.Boolean, "version", "v", "Yields version number.").default(false)

    @OptIn(ExperimentalCli::class)
    class Monitor: Subcommand("monitor", "Monitor a RaspberryJam project directory for changes.") {
        val directory by argument(ArgType.String, "directory", "d", "The base directory of the RaspberryJam project you would like to have monitored.").optional()
        override fun execute() {

        }
    }

    @OptIn(ExperimentalCli::class)
    class Project: Subcommand("project", "Create and administer projects.") {
        val id by argument(ArgType.String, description = "The id of the RaspberryJam project.")
        val new by option(ArgType.Boolean, "new", "n", "Create a new project.").default(false)

        override fun execute() {
            println("Hej")
            val input = readln()
            println("input = $input")
        }
    }

    @OptIn(ExperimentalCli::class)
    class Environment: Subcommand("environment", "Creates and administers your RaspberryJam development environments.") {
        val checkEnvVars by option(ArgType.Boolean, "environmentVariables", "Check the environment for the required environment variables.")
        // --generate-completion
        override fun execute() {

        }
    }

    private val monitor = Monitor()
    private val project = Project()
    private val environment = Environment()

    @OptIn(ExperimentalCli::class)
    fun run(args: Array<String>) {
        parser.subcommands(monitor, project, environment)
        parser.parse(args)

    }
}