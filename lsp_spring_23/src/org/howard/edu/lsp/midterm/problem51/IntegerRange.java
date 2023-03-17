package org.howard.edu.lsp.midterm.problem51;

public class IntegerRange implements Range {
	private int upper;
	private int lower;
	
    public IntegerRange(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }


	@Override
	public boolean contains(int value) {
		// TODO Auto-generated method stub
		if (value >= lower && value <= upper) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public boolean overlaps(Range other) throws EmptyRangeException {
		// TODO Auto-generated method stub
		if (other == null) {
			throw new EmptyRangeException("The range given is null");
		}
		//casting other to IntegerRange to access .getLower()
		return this.contains(((IntegerRange) other).getLower()) || other.contains(this.lower);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int computedSize = upper - lower + 1;
		return computedSize;
	}
	
	public int getLower() {
		return lower;
	}
	
	public int getUpper() {
		return upper;
	}

}
