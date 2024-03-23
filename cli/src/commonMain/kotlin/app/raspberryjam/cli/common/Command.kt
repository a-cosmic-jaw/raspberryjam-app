package app.raspberryjam.cli.common

import kotlinx.cli.*


class Command() {
    val parser = ArgParser("raspberryjam")
    val version by parser.option(ArgType.String, "version", "v", "Yields version number.")

    @OptIn(ExperimentalCli::class)
    class Monitor: Subcommand("monitor", "Monitor a RaspberryJam project directory for changes.") {
        override fun execute() {

        }
    }

    @OptIn(ExperimentalCli::class)
    class Project: Subcommand("project", "Create and administer projects.") {
        val id by argument(ArgType.String, description = "The id of the project.")

        override fun execute() {

        }
    }

    val monitor = Monitor()
    val project = Project()

    @OptIn(ExperimentalCli::class)
    fun run(args: Array<String>) {
        parser.subcommands(monitor, project)
        parser.parse(args)
    }
}