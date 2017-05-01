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


    private static final AddressEntry MIRKA_NOVAKOVA = new AddressEntry("Mirka Novakova", Gender.FEMALE, LocalDate.of(1980, 10, 25));

    private static final List<AddressEntry> sampleList = Arrays.asList(
            new AddressEntry("Pepa Novak", Gender.MALE, LocalDate.of(1984, 10, 25)),
            MIRKA_NOVAKOVA
    );


    @Test
    public void hotManyMens() {
        AddressBook b = new AddressBook(sampleList);
        long ret = b.howManyMales();
        assertThat(ret, is(1L));
    }

    @Test
    public void getOldestPersonTest() {
        AddressBook b = new AddressBook(sampleList);

        AddressEntry olders = b.getOldestPerson();

        assertThat(olders, is(MIRKA_NOVAKOVA));

    }



}
