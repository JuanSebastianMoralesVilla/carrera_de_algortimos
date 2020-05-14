package model;

import java.util.ArrayList;

public class Competition {

	public ArrayList<Long> getData(int size){
		ArrayList<Long> numbers = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			long num = (long) ((Math.random() * Long.MAX_VALUE) + Long.MIN_VALUE);
			numbers.add(num);
		}
		return numbers;
	}
	
}
