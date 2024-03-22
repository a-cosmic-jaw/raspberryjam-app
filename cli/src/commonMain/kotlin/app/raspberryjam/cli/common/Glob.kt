package app.raspberryjam.cli.common

import com.github.ajalt.mordant.rendering.TextColors
import com.github.ajalt.mordant.rendering.Theme


object Glob {
    data class Strings(
        val VERBOSE_HELP: String = "Prints debug information.",
        val MAIN_HELP: String = "A command to show of Clikt multiplatform."
    )

    val strings = Strings()

    public val theme = Theme {
        // Use ANSI-16 codes for help colors
        styles["info"] = TextColors.green
        styles["warning"] = TextColors.blue
        styles["danger"] = TextColors.magenta
        styles["muted"] = TextColors.gray

        // Remove the border around code blocks
        flags["markdown.code.block.border"] = false
    }
}