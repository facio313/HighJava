package kr.or.ddit.basic;

/*
 제너릭 메서드 <T, R> R method(T t)
 파라미터 타입과 리턴 타입으로 타입글자를 가지는 메서드 
 선언방법 : 리턴타입 앞에 <> 기호를 추가하고 타입글자를 기술한 후 사용함
*/

class Util {
	
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;
	}
}

/**
 * 멀티타입<K, V>를 가지는 제너릭 클래스
 * @param <K>
 * @param <V>
 */
class Pair<K, V> { // 클래스 옆에다 제네릭을 붙이면, 해당 클래스 내에서 사용할 수 있는 타입으로 일반화할 수 있음
	private K key;
	private V value;

	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	// 키와 값을 모두 출력
	public <K, V> void displayAll(K key, V val) { //여기 <K, V>는 위의 <K, V>가 아님
		System.out.println(key + " : " + val);
	}
}

public class T02GenericMethodTest {
	public static void main(String[] args) {
		// 객체를 만들 때는 타입을 명시적으로 알려줘야 함
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "홍길동");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "홍길동");

		// 구체적 타입을 명시적으로 지정(생략가능)
		boolean result1 = Util.<Integer, String>compare(p1, p2);

		if (result1) {
			System.out.println("논리(의미)적으로 동일한 객체임.");
		} else {
			System.out.println("논리(의미)적으로 동일한 객체 아님.");
		}

		Pair<String, String> p3 = new Pair<String, String>("001", "홍길동");
		Pair<String, String> p4 = new Pair<String, String>("002", "홍길동");

		boolean result2 = Util.compare(p3, p4);

		if (result2) {
			System.out.println("논리(의미)적으로 동일한 객체임.");
		} else {
			System.out.println("논리(의미)적으로 동일한 객체 아님.");
		}

//		public void displayAll(K key, V val) // 여기서 K와 V는 클래스에 지정해놓은 <K, V>임
//		p1.displayAll("키", 180); // 생성할 때 타입을 <Integer, String>으로 고정시켜서 에러 뜸
		
//		public <K, V> void displayAll(K key, V val)
		p1.<String, Integer>displayAll("키", 180); // <String, Integer>에서 <K, V>는 지역 제너릭?임
		
		
	}
}