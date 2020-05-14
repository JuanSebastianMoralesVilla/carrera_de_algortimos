package model;

import java.util.ArrayList;

public class Arraylist {
	
	private long time;
	private int progress;
	private ArrayList<Long> nums = new ArrayList<Long>();
	
	public Arraylist() {
		
	}

	public Arraylist(long time, int progress) {
		this.time = time;
		this.progress = progress;
	}


	public long getTime() {
		return time;
	}


	public void setTime(long time) {
		this.time = time;
	}


	public int getProgress() {
		return progress;
	}


	public void setProgress(int progress) {
		this.progress = progress;
	}


	public ArrayList<Long> getNums() {
		return nums;
	}


	public void setNums(ArrayList<Long> nums) {
		this.nums = nums;
	}
	
	public void addNum(long num) {
		nums.add(num);
	}
	
	public boolean deleteIterative(long value) {
		if (!nums.isEmpty()) {
			for (int i = 0; i < nums.size(); i++) {
				if (nums.get(i) == value) {
					nums.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	public boolean searchIterative(long num) {
		if (nums.isEmpty() != false) {
			for (int i = 0; i < nums.size(); i++) {
				if (nums.get(i) == num) {
					return true;
				}
			}
		}
		return false;
	}

	// -------------------------------------
	// Recursive
	// -------------------------------------


	public boolean removeRec(long num){
		try {
			if (!nums.isEmpty()) {
				return removeRec(0, num);
			}
		} catch (StackOverflowError e) {
			
		}
		return false;
	}

	private boolean removeRec(int index, long num){
		boolean remove = false;
		try {
			if (index > (nums.size() - 1)) {
				remove = false;
				return remove;
			}
			if (nums.get(index) == num) {
				nums.remove(index);
				remove = true;
				return remove;
			} else {
				return removeRec(index + 1, num);
			}
		} catch (Exception e) {
			
		}
		return remove;
	}
	
	public boolean searchRec(long num){
		try {
			if (!nums.isEmpty()) {
				return searchRecursive(0, num);
			}
		} catch (StackOverflowError e) {
			
		}
		return false;
	}

	private boolean searchRecursive(int index, long value){
		boolean search = false;
		try {
			if (index > (nums.size() - 1)) {
				search = false;
				return search;
			}else {
				if (nums.get(index) == value) {
					search = true;
					return search;
				}else {
					return searchRecursive(index + 1, value);  
				}	
			}
		} catch (StackOverflowError e) {
			
		}
		return search;
	}

}


