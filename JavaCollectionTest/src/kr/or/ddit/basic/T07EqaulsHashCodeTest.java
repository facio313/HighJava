package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class T07EqaulsHashCodeTest { // hashCode는 hashCode를 얻어내기 위한 메서드
	/*
	 * 해시함수(hash funtcion)는 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑해주는 함수이다. 해시는 빠른 게 특징! 해시
	 * 함수에 의해 얻어지는 값은 해시값, 해시코드, 해시 체크썸 또는 간단하게 해시라고 한다.
	 * 
	 * HashSet, HashMap, Hashtable과 같은 객체들을 사용할 경우 객체가 서로 같은지를 비교하기 위해 equals()와
	 * hashCode()를 호출한다. 그래서 객체가 서로 같은지 여부를 결정하려면 두 메서드를 재정의해야 한다. HashSet, HashMap,
	 * Hashtable에서 객체가 같은지 여부는 데이터를 추가할 대 검사한다.
	 * 
	 * - equals() => 두 객체의 내용(값)이 같은지 비교하는 메서드 - hashCode() => 객체에 대한 해시코드 값을 반환하는
	 * 메서드
	 *
	 * equals()와 hashCode()에 관한 규칙 
	 * 1. 두 객체가 같으면 반드시 hashCode를 가져야 한다. 
	 * 2. 두 객체가 같으면 equals()메서드를 호출했을 때 true값은 반환해야 한다. 즉, 객체a, b가 같다면 a.equals(b)와 b.equals)a) 둘 다 true이어야 한다. 
	 * 3. 두 객체의 hashCode가 같다고 해서 반드시 같은 객체는 아니다. 하지만 하지만 두 객체가 같으면 반드시 hashCode가 같아야 한다 
	 * 4. equals()를 override하면 반드시 hashCode()도 override 해야 함 
	 * 5. hashCode() 기본적으로 Heap 메모리에 있는 각 객체에 대한 메모리 주소 매핑 정보를 기반으로 정수값 반환함.
	 *  그러므로 클래스에서 hashCode() 메서드를 override하지 않으면 절대로 두 객체가 같은 해시값을 반환하지 않는다.
	 * - hashCode()에서 사용하는 '해싱알고리즘'에서 서로 다른 객체에 대하여 같은 hashCode값을 만들어낼 수 있다. 그래서 객체가 같지 않더라도 hashCode 값이 같을 수 있다.
	 */

	public static void main(String[] args) {

		System.out.println("Aa".hashCode());
		System.out.println("BB".hashCode());
		// hashCode가 같게 나옴. 이럴 때는 equals로 돌려봐야 됨. hashCode가 다르면 그냥 다른 거임.

		Person p1 = new Person(1, "홍길동");
		Person p2 = new Person(1, "홍길동");
		Person p3 = new Person(1, "이순신");

		System.out.println("p1.equals(p2) : " + p1.equals(p2)); // p1과 p2는 엄연히 다른 객체 => false가 나옴.
		// 둘 다 같은 것이라고 해주고 싶다면 새롭게 override해야 함
		System.out.println("p1 == p2 : " + (p1 == p2)); // 동등비교

		Set<Person> pSet = new HashSet<Person>();

		System.out.println("pSet.add(p1) 성공 여부 : " + pSet.add(p1));
		System.out.println("pSet.add(p2) 성공 여부 : " + pSet.add(p2));
		
//		pSet.add(p1);
//		pSet.add(p2);

		System.out.println("p1, p2 등록 후 데이터 : ");
		Iterator<Person> it = pSet.iterator();
		while (it.hasNext()) {
			Person p = it.next();
			System.out.println(p.getId() + " : " + p.getName());
		}
		// 왜 둘 다 들어간 것임? 중복되지 않음? 다른 것이라고 판단함. but 같은 것이라고 봐야 한다고 의도했기 때문에 override 해야 함
		// 하나만 된 이유는 같은 해쉬코드이기 때문에 같은 것이라고 판단함(Person 클래스에서 hashCode()를 override했기 때문)

		System.out.println("add(p3) 성공 여부 : " + pSet.add(p3));

		System.out.println("add(p3) 후 데이터 : ");
		for (Person p : pSet) { // 향상된 for문 이용할 수 있는 것 : 배열, List, Set 등등(iterable 인터페이스가 구현된 클래스는 다 쓸  수 있음)
			System.out.println(p.getId() + " : " + p.getName());
		}
		
	

		System.out.println("remove(p2) 성공 여부 : " + pSet.remove(p2));
		System.out.println("remove(p2) 후 데이터 : ");
		for (Person p : pSet) {
			System.out.println(p.getId() + " : " + p.getName());
		}
	}
}

class Person {
	private int id;
	private String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Person [id=%s, name=%s]", id, name);
	}
	/*
	 * @Override public boolean equals(Object obj) { Person p = (Person) obj;
	 * 
	 * return (this.getId() == p.getId()) && this.getName().equals(p.getName()); //
	 * id는 int여서 ==동등비교, name은 String이어서 equals() 메서드 }
	 * 
	 * @Override public int hashCode() {
	 * 
	 * return (name + id).hashCode(); // String + int => String / 이미 String클래스에
	 * hashCode 메서드가 override 돼있음 }
	 */

	// 이클립스에서 이미 만들어놓은 것도 있음
	// alt shift s -> hashCode and equals

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}