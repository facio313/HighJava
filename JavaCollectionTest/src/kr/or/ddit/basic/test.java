package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.List;

public class Test{
    public static void main(String[] args) {
    	List<Integer> list = new LinkedList();
    	
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	list.add(5);
    	
    	for(int i : list) {
    		System.out.println(i);
    	}
    	System.out.println("----------");
    	list.remove(3);
    	
    	for(int i : list) {
    		System.out.println(i);
    	}
    	System.out.println("----------");
    	System.out.println(list.get(0));
    	System.out.println(list.get(1));
    	System.out.println(list.get(2));
    	System.out.println(list.get(3));
    	System.out.println(list.get(4));
    }
}