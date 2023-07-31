package collection;

import java.util.ArrayList;
import java.util.Collections;

public class Question1 {
	public static void main(String[] args) {
//		Create a Integer collection and store 20 elements in it
//		● Display elements of in reverse order without using for loop
//		● Update elements of list by 5 whenever there is an element
//		greater than 50 is encountered.
//		● Display elements less than 60
		
		ArrayList<Integer> list=new ArrayList<Integer>(20);
		for(int i=1;i<=20;i++)
		{
			list.add(i*6);
		}
		System.out.println("Element in the list: ");
		System.out.println(list);
		System.out.println("After reversing the list the element in the list: ");
		Collections.reverse(list);
		System.out.println(list);
		for(Integer i:list)
		{
			if(i>50)
			{
				int index = list.indexOf(i);
				list.set(index, i+=5);
			}
		}
		System.out.println("List after increasing the element which are greater than 50 :");
		System.out.println(list);
		System.out.println("Element less than 60 are: ");
		for(Integer i:list)
		{
			if(i<60)
			{
				System.out.print(i+" ");
			}
		}
	}

}
