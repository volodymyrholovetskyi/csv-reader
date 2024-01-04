import java.io.BufferedReader
import java.io.FileReader
import java.io.FileWriter

fun main(args: Array<String>) {
    val bufferedReader =
        BufferedReader(FileReader("C:\\IT\\KOTLIN\\EDUCATION\\CSVReader\\src\\main\\resources\\clients.csv"))
    val fileWriter =
        FileWriter("C:\\IT\\KOTLIN\\EDUCATION\\CSVReader\\src\\main\\resources\\clients.csv", true)

    val csvManager = CsvManagerImpl(bufferedReader, fileWriter)

    val csvRecords = csvManager.readCsv()
    val clients = csvManager.getClients(csvRecords)

    for (client in clients) {
        println("Name: ${client.name}")
    }

    val newClient = Client("Jones", "Smith", "988787")
    csvManager.writeCsv(listOf(newClient))
}