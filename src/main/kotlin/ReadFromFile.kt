import java.io.File

class ReadFromFile {
    companion object {
        fun readFromFile(fileName: String): List<String> {
            return File(fileName).bufferedReader().readLines()
        }
    }
}