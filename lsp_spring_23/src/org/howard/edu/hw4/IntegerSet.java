package org.howard.edu.hw4;

import java.util.ArrayList;


/**
 * 
 * @author jabezagyemang-prempeh
 * IntegerSet class
 */

public class IntegerSet {
	
	private ArrayList<Integer> set;
	
	
	/**
	 * Sole Constructor
	 */
	
	public IntegerSet() { 
		set = new ArrayList<Integer>();
		
	}
	
	
	/**
	 * Removes all elements from set
	 */
	public void clear() { 
		set.clear();
		
	}
	
	
	/**
	 * Method to retrieve element at a particular index
	 * 
	 * @param index - the index of the value of which to return
	 * @return value at index specified
	 */
	public int get(int index) { 
		return set.get(index);
	}
	
	
	/**
	 * Method to add a number to the set
	 * @param number - this is the number to be added to the set
	 * 
	 */
	
	public void add(int number) { 
		if (!set.contains(number)) {
			set.add(number);
		}
	}
	

	/**
	 * Method get the length of the set
	 * @return returns the size of the set
	 */
	
	public int length() { 
		return set.size();
	}

	/**
	 * Method to check the equivalence of two sets by checking if they have the same elements
	 * @param setC - this is the set to be checked against for equivalence
	 * @return Returns True if sets are equal and False if they aren't equal
	 */
	public boolean equal(IntegerSet setC) {
		if (set.size() != setC.length()) {
	        return false;
	    }
		for (int i = 0; i < set.size(); i++) {
	        if (!set.get(i).equals(setC.get(i))) {
	            return false;
	        }
	    }
	    return true;
	}
	

	/**
	 * Method to check if the set contains a element "value"
	 * @param value - this is the value you want to check if the set contains
	 * @return returns True if value is in set and False if it isnt
	 */
	public boolean contains(int value) { 
		return set.contains(value);
	}
	

	/**
	 * Method to get the largest element in the set
	 *
	 * @throws IntegerSetException If the set is empty.
	 * @return returns the Largest value in the set
	 */
	public int largest() throws IntegerSetException{ 
		if (set.isEmpty()) {
	        throw new IntegerSetException("Set is Empty!");
	    }
	    int largest_val = set.get(0);
	    for (int i = 1; i < set.size(); i++) {
	        int current = set.get(i);
	        if (current > largest_val) {
	            largest_val = current;
	        }
	    }
	    return largest_val;
		
	}
	

	/**
	 * Method to return the smallest value in the set
	 * 
	 * @throws IntegerSetException if the set is empty
	 * @return returns the smallest value in the set
	 */
	
	public int smallest() throws IntegerSetException{ 
		if (set.isEmpty() ) {
			throw new IntegerSetException("Set is Empty!");
		}
		int smallest_val = set.get(0);
		for (int i = 1; i < set.size(); i++) {
			int current = set.get(i);
			if (current < smallest_val) {
				smallest_val = current;
			}
		}
		
		return smallest_val;
	}

	/**
	 * Method to remove an element from a set
	 * @param value - value to be removed from set
	 */
	public void remove(int value) { //method to remove element from set
		if (set.contains(value)) {
			 set.remove(Integer.valueOf(value));
		}
		
	}
	

	/**
	 * Method to combine/unionize two sets together
	 * @param setB - set to add combine with
	 */
	
	public void union(IntegerSet setB) { 
		if (!setB.isEmpty()) {
			for (int i = 0; i < setB.length();i++) {
				int value = setB.get(i);
				if (!set.contains(value)) {
					set.add(value);
				}
			}
		}
	}
	
	

	/**
	 * Method to find the intersection between two sets
	 * @param setC - set to look for intersection in
	 */
	
	public void intersect(IntegerSet setC) { 
		if (!setC.isEmpty()) {
			for (int i = 0; i < set.size();i++) {
				int value = set.get(i);
				if (!setC.contains(value)) {
					set.remove(i);
				}
			}
		}
	}
	

	/**
	 * Method to find the set difference between two sets
	 * @param setD - set to find the difference with
	 */
	
	public void diff(IntegerSet setD) { 
		if (!setD.isEmpty()) {
			for (int i = 0; i < set.size();i++) {
				int value = set.get(i);
				if (setD.contains(value)) {
					set.remove(i);
				}
			}
		}
		
	}
	

	/**
	 * method to check if the set is empty
	 * @return Returns True if the set is empty and returns False if set is not empty
	 */

	public boolean isEmpty() { 
		if(set.isEmpty()) {
			return true;
		}
		return false;
	}
	
	

	/**
	 * Method to return a string representation of elements in set
	 * @return Returns a string type representation of set 
	 */
	
	
	public String toString() { //Using string builder to concatenate elements to string in set form []
		 StringBuilder sb = new StringBuilder();
	        sb.append("[");
	        for (Integer value : set) {
	        	sb.append(value);
	        	sb.append(",");
	        }
	        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == ',') {
	        	 sb.deleteCharAt(sb.length() - 1);
	        } 
     
	        sb.append("]");
	        return sb.toString();
		
	}
	
	
}
