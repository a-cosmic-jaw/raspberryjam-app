package app.raspberryjam.cli.action

import io.github.irgaly.kfswatch.KfsDirectoryWatcher
import io.github.irgaly.kfswatch.KfsDirectoryWatcherEvent
import io.github.irgaly.kfswatch.KfsLogger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext

class MyLogger: KfsLogger {
    override fun debug(message: String) {
        println("Macos Kfs debug=$message")
    }

    override fun error(message: String) {
        println("Macos Kfs error=$message")
    }

}
actual class MonitorDirectory actual constructor(private val directory: String) : Base(
    name = "monitor-directory"
) {
    var watcher: KfsDirectoryWatcher? = null
    var scope: CoroutineScope? = null

    actual override fun doBefore(message: String?) {
        super.doBefore(message)
        println("doBefore")
        runBlocking {
            launch {
                scope = this
                watcher = KfsDirectoryWatcher(scope = scope!!, logger = MyLogger())

                watcher!!.add(directory)
                println("size=${watcher!!.watchingDirectories.size}")
            }
        }
    }

    actual override fun run() {
        // Observe events from Flow
        runBlocking {
            launch {
                println("debug")
                println("size=${watcher!!.watchingDirectories.size}")
                watcher!!.onEventFlow.collect { event: KfsDirectoryWatcherEvent ->
                    println("Event received: $event")
                }
            }
        }

        runBlocking {
            launch {
                // Stop watching
                watcher!!.removeAll()

                // Release all system's resources
                watcher!!.close() // or scope.cancel() will trigger watcher.close() automatically
            }
        }
    }

    actual override fun doAfter(message: String?) {
        super.doAfter(message)

    }
}