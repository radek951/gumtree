package cz.reaktordoma.gumtree;

import java.util.Collections;
import java.util.List;

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


}
