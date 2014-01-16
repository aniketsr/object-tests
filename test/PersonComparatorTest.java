import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class PersonComparatorTest {
    public static List<Person> addPeopleToList(Person... persons) {
        List<Person> people = new ArrayList<Person>();
        Collections.addAll(people, persons);
        return people;
    }

    Person john = new Person("John", 10);
    Person martin = new Person("Martin", 20);
    Person lisa = new Person("Lisa", 30);

    @Test
    public void test_comparator_of_person() {
        List<Person> people = addPeopleToList(lisa, martin, john);
        Collections.sort(people);
        String actual;
        String expected;
        expected = people.get(0).getName();
        actual = "John";
        assertEquals(expected, actual);
        expected = people.get(1).getName();
        actual = "Lisa";
        assertEquals(expected, actual);
        expected = people.get(2).getName();
        actual = "Martin";
        assertEquals(expected, actual);
    }

    @Test
    public void test_comparator_for_name_length() {
        List<Person> people = addPeopleToList(lisa, martin, john);
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().length() - p2.getName().length();
            }
        });
        String actual;
        String expected;
        expected = people.get(2).getName();
        actual = "Martin";
        assertEquals(expected, actual);
        expected = people.get(0).getName();
        actual = "Lisa";
        assertEquals(expected, actual);
        expected = people.get(1).getName();
        actual = "John";
        assertEquals(expected, actual);
    }

    @Test
    public void test_comparator_for_reverse_of_name_length() {
        List<Person> people = addPeopleToList(lisa, martin, john);
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p2.getName().length() - p1.getName().length();
            }
        });
        String actual;
        String expected;
        expected = people.get(0).getName();
        actual = "Martin";
        assertEquals(expected, actual);
        expected = people.get(1).getName();
        actual = "Lisa";
        assertEquals(expected, actual);
        expected = people.get(2).getName();
        actual = "John";
        assertEquals(expected, actual);
    }
}
