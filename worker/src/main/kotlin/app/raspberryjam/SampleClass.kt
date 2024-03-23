package app.raspberryjam

data class SampleClass(private val key: String, private val value: String) {
    fun echo(): String {
        return "$key=$value"
    }
}