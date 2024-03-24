package app.raspberryjam.cli.action

import io.github.irgaly.kfswatch.KfsDirectoryWatcher
import io.github.irgaly.kfswatch.KfsDirectoryWatcherEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext


expect class MonitorDirectory(directory: String): Base {
    override fun doBefore(message: String?)

    override fun run()

    override fun doAfter(message: String?)
}