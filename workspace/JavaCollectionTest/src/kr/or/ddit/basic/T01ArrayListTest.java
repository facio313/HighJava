package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class T01ArrayListTest {
	public static void main(String[] args) {

		 /*
		  * 리스트를 쓰는 이유 : 여러 개의 데이터를 저장하기 위함
		  * ArrayList도 배열로 돼있음.
		  * 배열 생성 시 무조건 몇 개를 넣을 건가 정해줘야 함
		  * 배열 10자리 생성 후 하나를 더 추가하고 싶다면 아예 새로운 배열 11자리를 만들어야 함
		  * ArrayList는 그것을 알아서 다 해줌!
		  */

		// Default_Capacity = 10;
		List list1 = new ArrayList();//ArrayList -> LinkedList로 바꿔도 괜찮음(인터페이스라서!!)

		// add()메서드를 이용하여 데이터를 추가한다.
		// 객체로 만듬. 객체화시키기 위해 int면 Integer클래스로 객체가 생김
		list1.add("aaa");
		list1.add("bbb");
		list1.add('d');
		list1.add(111); // 오토박싱 = list.add(new Integer(111));
		list1.add(true);
		list1.add(12.34);

		// size() => 데이터 개수
		System.out.println("size => " + list1.size());
		System.out.println("list1 => " + list1);

		// get()으로 데이터 꺼내오기
		System.out.println("1번째로 자료 : " + list1.get(0)); // index!

		// 데이터 끼워 넣기도 같다.
		list1.add(0, "zzz");
		System.out.println("list1 => " + list1);

		// 데이터 변경하기(set 메서드)
		String temp = (String) list1.set(0, "YYY"); // set 리턴값이 있다
		System.out.println("temp => " + temp);
		System.out.println("list1 => " + list1);

		// 삭제하기(remove 메서드)
		list1.remove(0);
		System.out.println("삭제 후 : " + list1);

		list1.remove("bbb");
		System.out.println("bbb 삭제 후 : " + list1);
		System.out.println("=========================");

		list1.remove(new Integer("111")); // list1.remove(2)
		System.out.println("111 삭제 후 : " + list1);
		System.out.println("=========================");

		// 제네릭을 지정하여 선언할 수 있다.
		// 제너릭 문법을 쓰면 리스트 안에 들어갈 수 있는 타입을 지정할 수 있음 ex) <String>
		List<String> list2 = new ArrayList<String>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
//		list2.add(1111); 제너릭으로 String이 지정되어 그 외의 타입은 올 수 없다

		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + " : " + list2.get(i));

		}
		System.out.println("-----------------------------------");

		// contain(비교객체); => 리스트에 '비교객체'가 있으면 true, 없으면 false 리턴
		System.out.println(list2.contains("DDD"));
		System.out.println(list2.contains("ZZZ"));

		// indexOf(비교객체); => 리스트에서 '비교객체'를 찾아 '비교객체'가 있는 index값을 반환한다. 없으면 -1을 반환함.
		System.out.println("DDD의 index값 : " + list2.indexOf("DDD"));
		System.out.println("ZZZ의 index값 : " + list2.indexOf("ZZZ"));
		System.out.println("-----------------------------------");

		// 리스트 삭제
		for (int i = 0; i < list2.size(); i++) {
			list2.remove(list2.get(i));
		}
		
		System.out.println("리스트 삭제 후 : " + list2);
		/*
		 * 다 지워도 남아있음
		 * ArrayList는 해당 인덱스에 있는 값을 지우면 땡겨짐
		 * A | B | C | D | E 에서 a,c,e를 지우면
		 * B | D |   |   |   로 남아 있음
		 * 그럼 어떻게 지워야 함???? -> i값을 size()-1로 하고 i--로 하면 됨
		 */
		
		for (int i = list2.size() - 1; 0 <= i; i--) {
			list2.remove(list2.get(i));
		}
		
		System.out.println("리스트 삭제 후 : " + list2);
		
		//아니면 iterator 쓰면 됨
		Iterator<String> iter = list2.iterator();
		while(iter.hasNext()) {
			iter.next(); iter.remove();
		}
		
		System.out.println("리스트 삭제 후 : " + list2);
	}
}