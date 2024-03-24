package app.raspberryjam.cli.action

enum class ActionDefaultMessages {
    BEFORE,
    AFTER
}
abstract class Base(
    val name: String,
    val messages: Map<ActionDefaultMessages, String> = mapOf()
) {
    open suspend fun doBefore(message: String?) {
        println(message
            ?: messages[ActionDefaultMessages.BEFORE]
            ?: "Running '$name' action...")
    }

    abstract suspend fun run()

    open suspend fun doAfter(message: String?) {
        println(message
            ?: messages[ActionDefaultMessages.AFTER]
            ?: "Ceasing '$name' action...")
    }
}