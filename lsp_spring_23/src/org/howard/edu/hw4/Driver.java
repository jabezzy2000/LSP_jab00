package org.howard.edu.hw4;

import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        IntegerSet setA = new IntegerSet();
        
   
        // Add elements to set A
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        
        // Add elements to set B
        IntegerSet setB = new IntegerSet();
        setB.add(1);
        setB.add(2);
        setB.add(3);
        setB.add(4);
        
        
        // Add elements to set C
        IntegerSet setC = new IntegerSet();
        setC.add(3);
        setC.add(4);
        setC.add(5);
        
        // Add elements to set D
        IntegerSet setD = new IntegerSet();
        setD.add(2);
        setD.add(4);
        setD.add(6);
        setA.diff(setD);

        // Test clear method
        setA.clear();
        System.out.println("Set A after clearing: " + setA.toString());

        // Test add method
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        setA.add(1); // duplicate value
        System.out.println("Set A after adding elements: " + setA.toString());

        // Test length method
        System.out.println("Length of set A: " + setA.length());

        // Test equal method
        System.out.println("Set A and set B are equal: " + setA.equal(setB)); //True
        System.out.println("Set A and set C are equal: " + setA.equal(setC));
        

        // Test contains method
        System.out.println("Set A contains value 3: " + setA.contains(3)); //True
        System.out.println("Set A contains value 200: " + setA.contains(200)); // False

        // Test largest method
        try {
            int largest = setA.largest();
            System.out.println("Largest element in set A: " + largest);
        } catch (IntegerSetException e) {
            System.out.println(e.getMessage());
        }

        // Test smallest method
        try {
            int smallest = setA.smallest();
            System.out.println("Smallest element in set A: " + smallest);
        } catch (IntegerSetException e) {
            System.out.println(e.getMessage());
        }
        
        
        IntegerSet emptySet = new IntegerSet();
        // Test largest method with empty set
        try {
            int largest = emptySet.largest();
            System.out.println("Largest element in set emptySet: " + largest);
        } catch (IntegerSetException e) {
            System.out.println(e.getMessage());
        }
        
        // Test smallest method with empty set
        try {
            int smallest = emptySet.smallest();
            System.out.println("Smallest element in set A: " + smallest);
        } catch (IntegerSetException e) {
            System.out.println(e.getMessage());
        }
        

        // Test remove method
        setA.remove(2);
        System.out.println("Set A after removing element 2: " + setA.toString());

        // Test union method
        setA.union(setB);
        System.out.println("Set A after union with set B: " + setA.toString());

        // Test intersect method
        setA.intersect(setC);
        System.out.println("Set A after intersection with set C: " + setA.toString());

        // Test diff method
        System.out.println("Set A after difference with set D: " + setA.toString());
    }
}
