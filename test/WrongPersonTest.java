import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class WrongPersonTest {

    @Test
    public void test_case_with_same_object() throws Exception {
        WrongPerson p1 = new WrongPerson("shital",18);
        WrongPerson p2 = new WrongPerson("shital",18);
        boolean actual = p1.equals(p2);
        boolean expected = false;
        assertEquals(actual,expected);
    }
    @Test
    public void test_case_with_different_object() throws Exception {
        WrongPerson p1 = new WrongPerson("shital",18);
        WrongPerson p2 = new WrongPerson("samiksha",17);
        boolean actual = p1.equals(p2);
        boolean expected = false;
        assertEquals(actual,expected);
    }

    @Test
    public void test_case_for_hash_code() throws Exception {
        WrongPerson p1 = new WrongPerson("shital",18);
        WrongPerson p2 = new WrongPerson("shital",18);
        int p1HashCode = p1.hashCode();
        int p2HashCode = p2.hashCode();
        assertNotSame(p1HashCode, p2HashCode);
    }

    @Test
    public void test_case_for_hash_code_but_different_object_value() throws Exception {
        WrongPerson p1 = new WrongPerson("kajal",18);
        WrongPerson p2 = new WrongPerson("shital",18);
        int p1HashCode = p1.hashCode();
        int p2HashCode = p2.hashCode();
        assertNotSame(p1HashCode, p2HashCode);
    }
}
