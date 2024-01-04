import org.apache.commons.csv.CSVRecord

interface CsvManager {

    fun readCsv(): List<CSVRecord>
    fun writeCsv(clients: List<Client>)
    fun getClients(csvRecords: List<CSVRecord>): List<Client>
}