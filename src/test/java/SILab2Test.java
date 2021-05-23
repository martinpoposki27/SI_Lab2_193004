import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    SILab2 siLab2 = new SILab2();

    private List<Time> createList(Time... elems) {
        return new ArrayList<>(Arrays.asList(elems));
    }

    @Test
    void everyBranchTest() {
        RuntimeException ex;
        Time time1 = new Time(23,14,11);
        Time time2 = new Time(-1,23,21);
        Time time3 = new Time(25,11,11);
        Time time4 = new Time(3,76,11);
        Time time5 = new Time(5,12,100);
        Time time6 = new Time(24,0,0);
        Time time7 = new Time(24,0,1);
        List<Integer> list1 = new ArrayList<>(Arrays.asList(86400));

        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(time1, time2)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(time3)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(time4)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(time5)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        assertEquals(list1, siLab2.function(createList(time6)), "Not a normal flow");

        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(time7)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));
    }

    @Test
    void multipleConditionsTest() {
        RuntimeException ex;
        Time time1 = new Time(-1,23,21);
        Time time2 = new Time(25,11,11);
        Time time3 = new Time(3,76,11);
        Time time4 = new Time(3, -5, 11);
        Time time5 = new Time(5,12,100);
        Time time6 = new Time(5,12,-2);
        Time time7 = new Time(23,14,11);
        Time time8 = new Time(24,1,23);
        Time time9 = new Time(24,0,1);
        Time time10 = new Time(24,0,0);
        List<Integer> list1 = new ArrayList<>(Arrays.asList(83651));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(86400));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(86401));


        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(time1)));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(time2)));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(time3)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(time4)));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));

        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(time5)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(time6)));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        assertEquals(list1, siLab2.function(createList(time7)), "The test with time7 does not work!");

        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(time8)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        ex = assertThrows(RuntimeException.class, () -> siLab2.function(createList(time9)));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        assertEquals(list2, siLab2.function(createList(time10)), "The test with time10 does not work!");

    }
}