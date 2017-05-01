package cz.reaktordoma.gumtree;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Created by rhubner on 01/05/17.
 */
public class AddressBook {

    private final List<AddressEntry> book;

    public AddressBook(List<AddressEntry> book) {
        this.book = Collections.unmodifiableList(book);
    }

    public long howManyMales() {
        return book.stream().filter(x -> x.getGender() == Gender.MALE).count();
    }

    public AddressEntry getOldestPerson() {
        return book.stream().min(Comparator.comparing(AddressEntry::getBirthdate)).get();
    }

    public Optional<Long> calculateDayDifference(String name1, String name2) {
        Optional<AddressEntry> entry1 = book.stream().filter(x -> name1.equals(x.getName())).findFirst();
        Optional<AddressEntry> entry2 = book.stream().filter(x -> name2.equals(x.getName())).findFirst();

        //I want for for comprehension from scala  :'(

        return entry1.flatMap( e1 -> entry2.flatMap(e2 -> processEntry(e1, e2)));
    }

    private Optional<Long> processEntry(AddressEntry entry1, AddressEntry entry2) {
        return Optional.ofNullable(DAYS.between(entry1.getBirthdate(), entry2.getBirthdate()));
    }

}
