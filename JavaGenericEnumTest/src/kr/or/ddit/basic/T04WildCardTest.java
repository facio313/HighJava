package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T04WildCardTest {
/*
 와일드 카드에 대하여...
 
 와일드 카드(?)는 제너릭 타입을 이용한 타입 안전한 코딩을 위해 사용되는
 특별한 종류의 인수(Argument)로서 변수선언, 객체생성 및 메서드 정의 시 사용된다.
 (제너릭 타입 선언 시에는 사용할 수 없다.)
 제너릭이 없는 와일드카드는 없음
 
 <? extends T> => 와일드 카드의 상한 제한. T와 그 자손들만 가능
 <? Super T) => 와일드 카드의 하한 제한. T와 그 조상들만 가능
 <?> => 허용 가능한 모든 타입이 가능<? extends Object>와 동일
 */
	
	//Pair<Integer, ?> p1 = new Pair<Integer, String>(1, "홍길동"); => 요건 되고 (무슨 타입이든 담을 수 있다?)
	//Pair<Integer, String> p1 = new Pair<Integer, ?>(1, "홍길동"); => 이건 안 됨
	
//	List<?> strList = new ArrayList<String>();//리스트는 제너릭 인터페이스
//	List<?> strList2 = new ArrayList<Integer>();//리스트는 제너릭 인터페이스
	
	public static void main(String[] args) {
		
		// 과일상자, 원래는 뒤 생성자 <>에 Fruit 넣어야 하지만 생략 가능(diamond grammar)
		FruitBox<Fruit> fruitBox = new FruitBox<>(); // 그냥 과일 상자 만들기
		FruitBox<Apple> appleBox = new FruitBox<>(); // 사과만 들어갈 수 있는 사과 상자 만들기
//		FruitBox<Garbage> garbageBox = new FruitBox<>();
		
		fruitBox.add(new Apple()); // FruitBox는 제너릭 클래스라 다 들어올 수 있지만
		fruitBox.add(new Grape()); // (사과랑 포도 하나씩 넣음)
		
		appleBox.add(new Apple()); // 사과상자에 사과만 넣음
		appleBox.add(new Apple());
//		appleBox.add(new Grape()); // AppleBox는  Apple타입만 들어갈 수 있음
		
//		garbageBox.add(new Garbage());
//		garbageBox.add(new Garbage());

		Juicer.makeJuice(fruitBox); // 사과랑 포도로 쥬스 만듬
		Juicer.makeJuice(appleBox); // 사과로 쥬스 만듬
//		Juicer.makeJuice(garbageBox);
		
	
	}
}

// 쥬서 클래스
class Juicer {
	
//	static <T extends Fruit> void makeJuice(FruitBox<T> box) {
	static void makeJuice(FruitBox<?> box) {
		
		String fruitListStr = ""; // 과일 목록
		
		int cnt = 0;
		for(Object f : box.getFruitList()) {
			if(cnt == 0) {
				fruitListStr += f;
			} else {
				fruitListStr += ", " + f;
			}
			cnt++;
		}
	}
}

class Fruit {
	private String name;

	public Fruit(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "과일(" + name + ")";
	}
}

class Apple extends Fruit {
	
	public Apple() {
		super("사과");
	}
}

class Grape extends Fruit {
	
	public Grape() {
		super("포도");
	}
}

// 과일상자
class FruitBox<T extends Fruit> { //T는 Apple이나 Grape가 올 수 있겠지?
	private List<T> fruitList;
	
	public FruitBox() { // 생성자를 호출하거나 통해 객체를 만들면 
		fruitList = new ArrayList<T>(); // T(Apple or Grape)의 객체가 들어갈 수 있는 ArrayList를 만들어낸다!
	}

	public List<T> getFruitList() {
		return fruitList;
	}
	
	public void add(T fruit) {
		fruitList.add(fruit);
	}
}

class Garbage{
	private String name;

	public String getName() {
		return "쓰레기";
	}

	public void setName(String name) {
		this.name = name;
	}
}