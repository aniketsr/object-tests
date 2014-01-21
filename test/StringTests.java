import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StringTests {
    @Test
    public void test_equals_for_distinct_strings() throws Exception {
        String a = "John";
        String b = "Martin";
        boolean actual = a.equals(b);
        assertEquals(false, actual);
    }

    @Test
    public void test_wrongEquals_for_same_strings() throws Exception {
        String a = "John";
        String b = "Martin";
        assertEquals(false, (a == b));
    }

    @Test
    public void test_equals_for_same_strings() throws Exception {
        String a = "John";
        String b = "John";
        boolean actual = a.equals(b);
        assertEquals(true, actual);
    }

    @Test
    public void test_equals_for_same_string_constructors() throws Exception {
        String a = new String("John");
        String b = new String("John");
        boolean actual = a.equals(b);
        assertEquals(true, actual);
    }

    @Test
    public void test_equals_for_distinct_string_constructors() throws Exception {
        String a = new String("John");
        String b = new String("Martin");
        boolean actual = a.equals(b);
        assertEquals(false, actual);
    }
}