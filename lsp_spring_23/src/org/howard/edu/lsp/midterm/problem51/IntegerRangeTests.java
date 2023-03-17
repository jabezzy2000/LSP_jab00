package org.howard.edu.lsp.midterm.problem51;

import org.junit.Test;
import static org.junit.Assert.*;
import org.howard.edu.lsp.midterm.problem51.*;

public class IntegerRangeTests {

    @Test
 // Test whether contains() method returns true for values within the range
    // and false for values outside of the range
    public void testContains1() {
        IntegerRange range = new IntegerRange(1, 10);

        assertTrue(range.contains(1));
        assertTrue(range.contains(5));
        assertTrue(range.contains(10));
        assertFalse(range.contains(0));
        assertFalse(range.contains(11));
    }

    @Test
 // Test whether overlaps() method returns true when ranges overlap and 
    // false when they don't overlap.
    // Also test whether EmptyRangeException is thrown when null range is passed
    public void testOverlaps1() throws EmptyRangeException {
        IntegerRange range1 = new IntegerRange(1, 10);
        IntegerRange range2 = new IntegerRange(5, 15);
        IntegerRange range3 = new IntegerRange(11, 20);

        assertTrue(range1.overlaps(range2));
        assertTrue(range2.overlaps(range1));
        assertFalse(range1.overlaps(range3));
        assertFalse(range3.overlaps(range1));
        assertTrue(range2.overlaps(range3));
        assertTrue(range3.overlaps(range2));
        
     // Test that EmptyRangeException is thrown when null is passed
       assertThrows(EmptyRangeException.class, () -> range1.overlaps(null));
        
    }

    @Test(expected = EmptyRangeException.class)
    public void testOverlapsNull() throws EmptyRangeException {
        IntegerRange range = new IntegerRange(1, 10);
        range.overlaps(null);
    }

    @Test
 // Test whether size() method returns the correct size of the range
    public void testSize() {
        IntegerRange range1 = new IntegerRange(1, 10);
        IntegerRange range2 = new IntegerRange(5, 15);
        IntegerRange range3 = new IntegerRange(11, 20);

        assertEquals(10, range1.size());
        assertEquals(11, range2.size());
        assertEquals(10, range3.size());
    }
    
 // Additional tests for edge cases
    @Test
    public void testContains() {
        IntegerRange range1 = new IntegerRange(1, 10);
        IntegerRange range2 = new IntegerRange(0, 0);

        assertTrue(range1.contains(1));
        assertTrue(range1.contains(5));
        assertTrue(range1.contains(10));
        assertFalse(range1.contains(0));
        assertFalse(range1.contains(11));
        
        assertFalse(range2.contains(1));
        assertFalse(range2.contains(-1));
        assertTrue(range2.contains(0));
    }

    @Test
 // Test whether overlaps() method works for different overlapping cases
    // including ranges with a single number, ranges with the same lower and upper bounds
    // and ranges that fully contain one another
    public void testOverlaps() throws EmptyRangeException {
        IntegerRange range1 = new IntegerRange(1, 10);
        IntegerRange range2 = new IntegerRange(5, 15);
        IntegerRange range3 = new IntegerRange(11, 20);
        IntegerRange range4 = new IntegerRange(10, 10);
        IntegerRange range5 = new IntegerRange(10, 11);
        IntegerRange range6 = new IntegerRange(9, 10);
        IntegerRange range7 = new IntegerRange(10, 20);
        IntegerRange range8 = new IntegerRange(20, 30);

        assertTrue(range1.overlaps(range2));
        assertTrue(range2.overlaps(range1));
        assertFalse(range1.overlaps(range3));
        assertFalse(range3.overlaps(range1));
        assertTrue(range1.overlaps(range4));
        assertTrue(range4.overlaps(range1));
        assertTrue(range4.overlaps(range5));
        assertTrue(range5.overlaps(range4));
        assertTrue(range4.overlaps(range6));
        assertTrue(range6.overlaps(range4));
        assertTrue(range1.overlaps(range7));
        assertTrue(range7.overlaps(range1));
        assertFalse(range1.overlaps(range8));
        assertFalse(range8.overlaps(range1));
    }

    @Test(expected = EmptyRangeException.class)
    public void testOverlapsNull1() throws EmptyRangeException {
        IntegerRange range = new IntegerRange(1, 10);
        range.overlaps(null);
    }

    @Test
    public void testSize1() {
        IntegerRange range1 = new IntegerRange(1, 10);
        IntegerRange range2 = new IntegerRange(5, 15);
        IntegerRange range3 = new IntegerRange(11, 20);
        IntegerRange range4 = new IntegerRange(-10, -1);
        IntegerRange range5 = new IntegerRange(-5, 5);
        IntegerRange range6 = new IntegerRange(-1, 1);

        assertEquals(10, range1.size());
        assertEquals(11, range2.size());
        assertEquals(10, range3.size());
        assertEquals(10, range4.size());
        assertEquals(11, range5.size());
        assertEquals(3, range6.size());
    }
}