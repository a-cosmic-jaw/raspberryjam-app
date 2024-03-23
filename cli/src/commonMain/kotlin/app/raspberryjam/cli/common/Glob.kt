package app.raspberryjam.cli.common

object Glob {
    data class Strings(
        val VERBOSE_HELP: String = "Prints debug information.",
        val MAIN_HELP: String = "A command to show of Clikt multiplatform."
    )

    val strings = Strings()
}