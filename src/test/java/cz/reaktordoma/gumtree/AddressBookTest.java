package cz.reaktordoma.gumtree;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by rhubner on 01/05/17.
 */
public class AddressBookTest {


    private static final List<AddressEntry> sampleList = Arrays.asList(
            new AddressEntry("Pepa Novak", Gender.MALE, LocalDate.of(1984, 10, 25)),
            new AddressEntry("Mirka Novakova", Gender.FEMALE, LocalDate.of(1985, 10, 25))
    );


    @Test
    public void hotManyMens() {
        AddressBook b = new AddressBook(sampleList);
        long ret = b.howManyMales();
        assertThat(ret, is(1L));
    }



}
