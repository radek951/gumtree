package cz.reaktordoma.gumtree;

/**
 * Created by rhubner on 01/05/17.
 */
public enum Gender {

    MALE, FEMALE;



    public static Gender getInstance(String _gender) {
        String gender = _gender.toLowerCase().trim();
        if("male".equals(gender)) {
            return MALE;
        } else if("female".equals(gender)) {
            return FEMALE;
        }else {
            throw new RuntimeException("Unexpected gender");
        }
    }

}
