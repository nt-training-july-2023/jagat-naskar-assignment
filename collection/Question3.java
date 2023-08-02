package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question3 {

	public static void main(String[] args) {
		Tree1 t1 = new Tree1("Yellow", 55);
		Tree1 t2 = new Tree1("Red", 44);
		Tree1 t3 = new Tree1("Green", 1);
		Tree1 t4 = new Tree1("Blue", 4);
		Tree1 t5 = new Tree1("Light Greeen", 56);
		List<Tree1> list = new ArrayList<Tree1>();
		list.add(t5);
		list.add(t4);
		list.add(t3);
		list.add(t2);
		list.add(t1);
		System.out.println(list);
		Collections.sort(list, new Tree1(null, 0));
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}

}

class Tree1 implements Comparable<Tree1>, Comparator<Tree1>{
	String leavesColorString;
	int noOfBranches;
	
	public Tree1(String leavesColorString, int noOfBranches) {
		super();
		this.leavesColorString = leavesColorString;
		this.noOfBranches = noOfBranches;
	}
	@Override
	public String toString() {
		return "Tree [leavesColorString=" + leavesColorString + ", noOfBranches=" + noOfBranches + "]";
	}
	
	public String getLeavesColorString() {
		return leavesColorString;
	}

	public void setLeavesColorString(String leavesColorString) {
		this.leavesColorString = leavesColorString;
	}

	public int getNoOfBranches() {
		return noOfBranches;
	}

	public void setNoOfBranches(int noOfBranches) {
		this.noOfBranches = noOfBranches;
	}
	
	@Override
	public int compare(Tree1 o1, Tree1 o2) {
		System.out.println("compare method overriden");
		return o1.noOfBranches - o2.noOfBranches;
	}

	@Override
	public int compareTo(Tree1 o) {
		System.out.println("compareToooo method called");
		return this.leavesColorString.compareTo(o.leavesColorString);
	}
	
	
}