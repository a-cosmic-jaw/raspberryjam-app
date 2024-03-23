package app.raspberryjam.cli.common


class Command(args: Array<String>) {
   /*
    val parser = ArgParser("example")
    val output by parser.option(ArgType.String, "output", "o", "Output file")
    class Summary: Subcommand("summary", "Calculate summary") {
        val invert by option(ArgType.Boolean, "invert", "i", "Invert results").default(false)
        val addendums by argument(ArgType.Int, "addendums", description = "Addendums").vararg()
        var result: Int = 0

        override fun execute() {
            result = addendums.sum()
            result = if (invert!!) -1 * result else result
        }
    }
    class Multiply: Subcommand("mul", "Multiply") {
        val numbers by argument(ArgType.Int, description = "Addendums").vararg()
        var result: Int = 0

        override fun execute() {
            result = numbers.reduce{ acc, it -> acc * it }
        }
    }
    val summary = Summary()
    val multiple = Multiply()
    parser.subcommands(summary, multiple)

    parser.parse(args)
    */
}