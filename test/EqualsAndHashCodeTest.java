import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class EqualsAndHashCodeTest {
    @Test
    public void test_equals_for_distinct_persons() throws Exception {
        Person p1 = new Person("John", 20);
        Person p2 = new Person("Martin", 22);
        boolean actual = p1.equals(p2);
        assertEquals(false, actual);
    }

    @Test
    public void test_equals_for_same_persons() throws Exception {
        Person p1 = new Person("John", 20);
        Person p2 = new Person("John", 20);
        boolean actual = p1.equals(p2);
        assertEquals(true, actual);
    }

    @Test
    public void test_hashCode_for_same_person_reference() throws Exception {
        Person p1 = new Person("John", 20);
        Person p2 = p1;
        boolean actual = p1.hashCode() == p2.hashCode();
        assertEquals(true, actual);
    }

    @Test
    public void test_hashCode_for_same_persons() throws Exception {
        Person p1 = new Person("John", 20);
        Person p2 = new Person("John", 20);
        boolean actual = p1.hashCode() == p2.hashCode();
        assertEquals(true, actual);
    }

    @Test
    public void test_hashCode_for_distinct_persons() throws Exception {
        Person p1 = new Person("John", 20);
        Person p2 = new Person("Martin", 22);
        boolean actual = p1.hashCode() == p2.hashCode();
        assertEquals(false, actual);
    }

    Person John = new Person("John", 20);
    Person Martin = new Person("John", 20);
    WrongPerson wrongJohn = new WrongPerson("wrongJohn", 20);
    WrongPerson wrongMartin = new WrongPerson("wrongJohn", 20);

    @Test
    public void test_hashMap_overwrites_duplicate_data() {
        HashMap<Person, Person> map1 = new HashMap<Person, Person>();
        map1.put(John, John);
        map1.put(Martin, Martin);
        int actual = map1.size();
        assertEquals(1, actual);
    }

    @Test
    public void test_inserts_same_person_in_set_when_wrong_implementation_of_equals() {
        Set<WrongPerson> people = new HashSet<WrongPerson>();
        people.add(wrongJohn);
        people.add(wrongMartin);
        int actual = people.size();
        assertEquals(1, actual);
    }

    @Test(expected = ClassCastException.class)
    public void test_insert_in_ArrayList_throws_exception() {
        ArrayList list = new ArrayList<Person>();
        Assert.assertTrue(list.add("hello"));
        Person p1 = (Person) list.get(0);
    }
}