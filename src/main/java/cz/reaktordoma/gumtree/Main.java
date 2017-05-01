package cz.reaktordoma.gumtree;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rhubner on 01/05/17.
 */
public class Main {


    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yy");


    public static void main(String[] args) throws Exception {

        AddressBook book = new AddressBook(readAddressFile());

        System.out.printf("we have %1d males in address book\n", book.howManyMales());

        System.out.printf("Oldest person is %1s \n", book.getOldestPerson().getName());

        System.out.printf("Bill McKnight is %1d days older that Paul Robinson\n",
                book.calculateDayDifference("Bill McKnight", "Paul Robinson").get());


    }


    private static final List<AddressEntry> readAddressFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        Main.class.getClassLoader().getResourceAsStream("AddressBook")))) {

            List<AddressEntry> addressEntries = new LinkedList<>();

            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);

            for(CSVRecord record : records) {
                addressEntries.add(new AddressEntry(
                        record.get(0),
                        Gender.getInstance(record.get(1)),
                        LocalDate.parse(record.get(2).trim(), DATE_FORMAT)
                ));
            }
            return addressEntries;
        }
    }




}
