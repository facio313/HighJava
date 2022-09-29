package kr.or.ddit.basic.homework;

import java.util.Arrays;
import java.util.List;

public class test {
	private static String[] track = {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"};
	
	//싱글톤(공유)
	private static test instance = new test();
	private test() {}
	public  static test getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			//>---
			//>>--
			track[i] = ">";
			
			try {
				//>---
				//->--
				track[i-1] = "-";
			} catch (ArrayIndexOutOfBoundsException e) {
			}
//			Arrays.asList(track);
			
//			print(track);
			test t = test.getInstance();
			System.out.println(t.toString());
		}//end for
	}
	
	//둘 중에 아무거나 쓰면 됨
	
	@Override
	public String toString() {
		List<String> list = Arrays.asList(track);
		String str = "";
		
		for(int i=0;i<list.size();i++) {
			str += list.get(i);
		}
		
		return str;
	}


	public static void print(String[] track) {
		for(String str : track) {
			System.out.print(str);
		}
		System.out.println();
	}
}
