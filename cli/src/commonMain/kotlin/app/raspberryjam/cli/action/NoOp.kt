package app.raspberryjam.cli.action

class NoOp(private val subcommand: String): Base(
    name = "no-operation"
) {
    override fun run() {
        println("No action defined for '$subcommand'!")
    }
}