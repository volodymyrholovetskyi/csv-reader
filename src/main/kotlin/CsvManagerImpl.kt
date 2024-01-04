import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVPrinter
import org.apache.commons.csv.CSVRecord
import java.io.BufferedReader
import java.io.FileWriter
import java.lang.Exception

class CsvManagerImpl(private val bufferedReader: BufferedReader,
                     private val fileWriter: FileWriter): CsvManager {

    private val csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT)
    private val csvPrinter = CSVPrinter(fileWriter, CSVFormat.DEFAULT)
    override fun readCsv(): List<CSVRecord> {
        try {
            return csvParser.records
        } catch (e: Exception) {
            e.printStackTrace()
            csvParser.close()
        }
        return emptyList()
    }

    override fun writeCsv(clients: List<Client>) {
        for (client in clients) {
            val data = listOf(client.name, client.surname, client.identifier)
            csvPrinter.printRecord(data)
        }
        csvPrinter.close()
    }

    override fun getClients(csvRecords: List<CSVRecord>): List<Client> {
        val clients = ArrayList<Client>()
        for (record in csvRecords) {
            val name = record.get(0)
            val surname = record.get(1)
            val identifier = record.get(2)

            val client = Client(name, surname, identifier)
            clients.add(client)
        }
        return clients
    }
}