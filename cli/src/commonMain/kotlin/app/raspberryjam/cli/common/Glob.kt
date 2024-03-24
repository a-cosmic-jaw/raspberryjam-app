package app.raspberryjam.cli.common

import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object Glob {
    data class Strings(
        val RASPBERRYJAM: String = "RaspberryJam",
        val MAIN_HELP: String = "A command to show of Clikt multiplatform.",
        val MONITOR_HELP_DIRECTORY: String = "The directory containing a $RASPBERRYJAM project to monitor while developing.",
        val MONITOR_COMMAND_NAME: String = "monitor",
        val PROJECT_COMMAND_NAME: String = "project",
        val PROJECT_HELP: String = "Create and administer projects.",
        val PROJECT_HELP_ID: String = "The id of the project. If left blank '${envvars.RASPBERRYJAM_DEFAULT_PROJECT}' will be used.",
        val PROJECT_HELP_NEW: String = "Runs you trough creating a new $RASPBERRYJAM project step by step.",
        val RASPBERRYJAM_EXECUTABLE_NAME: String = "raspberryjam",
        val VERBOSE_HELP: String = "Prints debug information.",
        val MONITOR_HELP: String = "Monitors a project for changes while developing.",
        val ENVIRONMENT_COMMAND_NAME: String = "environment",
        val ENVIRONMENT_HELP: String = "Checks your environment setup.",
        val ENVIRONEMNT_ENVVARS_HELP: String = "Prints the names of the projects environment variables and their usage.",
        val PROJECT_WORKER_ADDRESS_HELP: String = "The IP and port of the worker."
    )

    val strings = Strings()

    enum class envvars(val help: String) {
        RASPBERRYJAM_DEFAULT_PROJECT("The default project at this computer."),
        RASPBERRYJAM_WORKER_ADDRESS("The address of your worker (ex. 'localhost:8080' or '<version>.raspberryjam-worker.local:8080'")
    }
}