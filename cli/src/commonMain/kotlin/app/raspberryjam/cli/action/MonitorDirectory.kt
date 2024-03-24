package app.raspberryjam.cli.action

import io.github.irgaly.kfswatch.KfsDirectoryWatcher
import io.github.irgaly.kfswatch.KfsDirectoryWatcherEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext


class MonitorDirectory(val directory: String): Base(
        name = "monitor-directory") {
    private lateinit var watcher: KfsDirectoryWatcher

    override suspend fun run() {
        val scope = CoroutineScope(coroutineContext)
        watcher = KfsDirectoryWatcher(scope)

        // Add watching directories, and start watching
        watcher.add(directory)

        // Observe events from Flow
        scope.launch {
            println("debug")
            watcher.onEventFlow.collect { event: KfsDirectoryWatcherEvent ->
                println("Event received: $event")
            }
        }
    }

    override suspend fun doAfter(message: String?) {
        super.doAfter(message)

        // Stop watching
        watcher.removeAll()

        // Release all system's resources
        watcher.close() // or scope.cancel() will trigger watcher.close() automatically
    }

}