import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


public class PersonTest {
        //--------------  Test cases for the literels Strings  --------------------

        @Test
        public void test_case_for_same_string_literels() throws Exception {
            String simpleString = "banful";
            String object = new String("banful");
            boolean actual = simpleString.equals(object);
            boolean expected = true;
            assertEquals(actual,expected);
        }
        @Test
        public void test_case_for_diffrent_string_literels() throws Exception {
            String simpleString = "banful";
            String object = new String("samiksha");
            boolean actual = simpleString.equals(object);
            boolean expected = false;
            assertEquals(actual,expected);
        }
        //--------------  Test cases for the Equals of person  --------------------
        @Test
        public void test_case_for_different_objects() throws Exception {
            Person p1 = new Person("kajal",19);
            Person p2 = new Person("shital",18);
            boolean actual = p1.equals(p2);
            boolean expected = false;
            assertEquals(actual,expected);
        }
        //
        @Test
        public void test_case_for_same_objects() throws Exception {
            Person p1 = new Person("shital",18);
            Person p2 = new Person("shital",18);
            boolean actual = p1.equals(p2);
            boolean expected = true;
            assertEquals(actual,expected);
        }

        // -------------- Test case for the hash code -----------------------
        @Test
        public void test_case_for_hash_code() throws Exception {
            Person p1 = new Person("shital",18);
            Person p2 = new Person("shital",18);
            int p1HashCode = p1.hashCode();
            int p2HashCode = p2.hashCode();
            assertEquals(p1HashCode,p2HashCode);
        }

        @Test
        public void test_case_for_hash_code_but_different_object_value() throws Exception {
            Person p1 = new Person("kajal",18);
            Person p2 = new Person("shital",18);
            int p1HashCode = p1.hashCode();
            int p2HashCode = p2.hashCode();
            assertNotSame(p1HashCode, p2HashCode);
        }

// ---------------------  Test cases for Arraylist ---------------------------------

        @Test
        public void testEquals_arraylists_are_not_equals() throws Exception {
            Person p1 = new Person("Shital",45);
            Person p2 = new Person("manali",45);

            List<Person> one  = new ArrayList<Person>();
            List<Person> two  = new ArrayList<Person>();

            one.add(p1);
            one.add(p2);

            two.add(p2);
            two.add(p1);
            boolean[] result = new boolean[2];
            for (int i = 0; i < 2 ; i++)
                result[i] = one.get(i).equals(two.get(i));
            boolean[] expected = {false,false,false};
            for (int i = 0; i < 2 ; i++)
                assertEquals(result[i],expected[i]);
        }
        @Test
        public void testEquals_arraylists_are_equals() throws Exception {
            Person p1 = new Person("Shital",45);
            Person p2 = new Person("Shital",45);

            List<Person> one  = new ArrayList<Person>();
            List<Person> two  = new ArrayList<Person>();

            one.add(p1);
            one.add(p2);

            two.add(p1);
            two.add(p2);
            boolean[] result = new boolean[2];
            for (int i = 0; i < 2 ; i++)
                result[i] = one.get(i).equals(two.get(i));
            boolean[] expected = {true,true};
            for (int i = 0; i < 2 ; i++)
                assertEquals(result[i],expected[i]);
        }
        // ----------------  Test cases for hash map ----------------------------------
        @Test
        public void test_case_for_hash_map_having_same_object_in_a_single_list() throws Exception {
            Person p1 = new Person("kajal",18);
            Person p2 = new Person("kajal",18);
            List<Person> myListKajal = new ArrayList<Person>();
            myListKajal.add(p1);
            myListKajal.add(p2);
            Map<String,List<Person>> map = new HashMap<String, List<Person>>();
            map.put("A",myListKajal);
            List prateek = map.get("A");

            boolean actual = prateek.get(0).equals(prateek.get(1));
            int p1HashCode = prateek.get(0).hashCode();
            int p2HashCode = prateek.get(1).hashCode();

            boolean expected = true;
            assertEquals(actual,expected);
            assertEquals(p1HashCode,p2HashCode);
        }
        @Test
        public void test_case_for_hash_map_having_same_object_in_a_different_list() throws Exception {
            Person p1 = new Person("shital",18);
            Person p2 = new Person("kajal",18);
            List<Person> myListKajal = new ArrayList<Person>();
            myListKajal.add(p1);
            myListKajal.add(p2);
            Map<String,List<Person>> map = new HashMap<String, List<Person>>();
            map.put("A",myListKajal);

            Person p3 = new Person("shital",18);
            Person p4 = new Person("shital",18);
            List<Person> myListShital = new ArrayList<Person>();
            myListShital.add(p3);
            myListShital.add(p4);
            map.put("B",myListShital);

            List prateek = map.get("A");
            List sumit = map.get("B");
            int p1HashCode = prateek.get(0).hashCode();
            int p3HashCode = sumit.get(0).hashCode();

            boolean actual = prateek.get(0).equals(sumit.get(0));
            boolean expected = true;
            assertEquals(actual,expected);
            assertEquals(p1HashCode,p3HashCode);
        }

        @Test
        public void test_case_for_hash_map_having_different_object_in_a_same_list() throws Exception {
            Person p1 = new Person("shital",18);
            Person p2 = new Person("kajal",18);
            List<Person> myListKajal = new ArrayList<Person>();
            myListKajal.add(p1);
            myListKajal.add(p2);
            Map<String,List<Person>> map = new HashMap<String, List<Person>>();
            map.put("A",myListKajal);
            List prateek = map.get("A");
            boolean actual = prateek.get(0).equals(prateek.get(1));
            boolean expected = false;
            assertEquals(actual,expected);
            int p1HashCode = prateek.get(0).hashCode();
            int p2HashCode = prateek.get(1).hashCode();
            assertNotSame(p1HashCode,p2HashCode);
        }

        @Test
        public void test_case_for_hash_map_having_different_object_in_a_different_list() throws Exception {
            Person p1 = new Person("shital",18);
            Person p2 = new Person("kajal",18);
            List<Person> myListKajal = new ArrayList<Person>();
            myListKajal.add(p1);
            myListKajal.add(p2);
            Map<String,List<Person>> map = new HashMap<String, List<Person>>();
            map.put("A",myListKajal);

            Person p3 = new Person("manali",18);
            Person p4 = new Person("shital",18);
            List<Person> myListShital = new ArrayList<Person>();
            myListShital.add(p3);
            myListShital.add(p4);
            map.put("B",myListShital);

            List prateek = map.get("A");
            List sumit = map.get("B");

            boolean actual = prateek.get(0).equals(sumit.get(0));
            boolean expected = false;
            assertEquals(actual,expected);

            int p1HashCode = prateek.get(0).hashCode();
            int p2HashCode = sumit.get(0).hashCode();
            assertNotSame(p1HashCode,p2HashCode);
        }


// ----------------- Test cases for Hash set -----------------------------

        @Test
        public void test_case_for_hash_set_having() throws Exception {
            Person p1 = new Person("shital",18);
            Person p2 = new Person("shital",18);
            Set<Person> one = new HashSet<Person>();
            one.add(p1);
            one.add(p2);
            assertEquals(one.size(),1);
        }
        @Test
        public void test_case_for_hash_set_not_having_values() throws Exception {
            Person p1 = new Person("shital",18);
            Person p2 = new Person("kajal",18);
            Person p3 = new Person("manali",70);

            Set<Person> one = new HashSet<Person>();
            one.add(p1);
            one.add(p2);
            one.add(p3);
            assertEquals(3,one.size());
        }

// -------------------  Test cases for checking ArrayList for the different type casting --------------
    @Test(expected = java.lang.ClassCastException.class)
    public void testGivesExceptionWhenTryingToGetStringInsteadOfObjectFromList() throws ClassCastException {
        ArrayList list = new ArrayList<String>();
        list.add(new Object());
        list.add(new Object());
        String a = (String)list.get(0);
    }

    @Test(expected = java.lang.ClassCastException.class)
    public void testGivesExceptionWhenTryingToGetIntegerInsteadOfObjectFromList() throws ClassCastException {
        ArrayList list = new ArrayList<String>();
        list.add(new Object());
        list.add(new Object());
        Integer a = (Integer)list.get(0);
    }

    @Test(expected = java.lang.ClassCastException.class)
    public void testGivesExceptionWhenTryingToGetFloatInsteadOfObjectFromList() throws ClassCastException {
        ArrayList list = new ArrayList<String>();
        list.add(new Object());
        list.add(new Object());
        Float a = (Float)list.get(0);
    }

    @Test(expected = java.lang.ClassCastException.class)
    public void testGivesExceptionWhenTryingToGetDoubleInsteadOfObjectFromList() throws ClassCastException {
        ArrayList list = new ArrayList<String>();
        list.add(new Object());
        list.add(new Object());
        Double a = (Double)list.get(0);
    }
}

