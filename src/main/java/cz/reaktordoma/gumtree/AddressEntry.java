package cz.reaktordoma.gumtree;

import java.time.LocalDate;

/**
 * Created by rhubner on 01/05/17.
 */
public class AddressEntry {

    private final String name;
    private final Gender gender;
    private final LocalDate birthdate;


    public AddressEntry(String name, Gender gender, LocalDate birthdate) {
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
    }


    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }




}
