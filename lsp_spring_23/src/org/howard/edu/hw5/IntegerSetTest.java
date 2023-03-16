package org.howard.edu.hw5;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.howard.edu.hw5.IntegerSet;
import static org.junit.Assert.*;

public class IntegerSetTest {

    @Test
    @DisplayName("Test case for testClear method")
    public void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(0);;
        set.add(2);
        set.clear();
        assertEquals(0, set.length());
    }
    
    @Test
    @DisplayName("Test case for testGet method")
    public void testGet() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        assertEquals(2, set.get(1));
    }
    
    @Test
    @DisplayName("Test case for testAdd method")
    public void testAdd() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(2);
        assertEquals(2, set.length());
    }
    
    @Test
    @DisplayName("Test case for testLength method")
    public void testLength() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(3, set.length());
    }
    
    @Test
    @DisplayName("Test case for testEqual method")
    public void testEqual() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        IntegerSet set2 = new IntegerSet();
        set2.add(1);
        set2.add(2);
        assertTrue(set1.equal(set2));
    }
    
    @Test
    @DisplayName("Test case for testContains method")
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        assertTrue(set.contains(1));
        assertFalse(set.contains(3));
    }
    
    @Test
    @DisplayName("Test case for testLargest method")
    public void testLargest() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(3, set.largest());
    }
    
    @Test(expected = IntegerSetException.class)
    @DisplayName("Test case for testLargest is Empty")
    public void testLargestEmptySet() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.largest();
    }
    
    @Test
    @DisplayName("Test case for testSmallest method")
    public void testSmallest() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(1, set.smallest());
    }
    
    @Test(expected = IntegerSetException.class)
    @DisplayName("Test case for testSmallest is Empty")
    public void testSmallestEmptySet() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.smallest();
    }
    
    @Test
    @DisplayName("Test case for testRemove method")
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.remove(2);
        assertEquals(1, set.length());
    }
    
    @Test
    @DisplayName("Test case for testUnion method")
    public void testUnion() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set1.union(set2);
        assertEquals(3, set1.length());
    }
    
    @Test
    @DisplayName("Test case for testIntersect method")
    public void testIntersect() {
    	IntegerSet set1 = new IntegerSet();
    	set1.add(1);
        set1.add(2);
        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set1.intersect(set2);
        assertEquals(1, set1.length());
    }
    
    @Test
    @DisplayName("Test case for test to String method")
    public void testToString() {
    	IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        String expected = "[1,2,3]";
        String actual = set.toString();
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test case for testDifference method")
    public void testDiff() {
    	
    	IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        
        IntegerSet setD = new IntegerSet();
        setD.add(2);
        setD.add(4);
        set.diff(setD);

        String expected = "[1,3]";
        String actual = set.toString();
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test case for test is Empty method returning true")
    public void testIsEmptyTrue() {
    	IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Test case for test is empty returning false")
    public void testIsEmptyFalse() {
    	IntegerSet set = new IntegerSet();
        set.add(1);
        assertFalse(set.isEmpty());
    }
    }
    

       