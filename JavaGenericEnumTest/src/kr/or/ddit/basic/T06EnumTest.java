package kr.or.ddit.basic;

public class T06EnumTest {
/*
 열거형 상수 선언하는 방법
 
 enum 열거형이름{ 상수값1, 상수값2, ..., 상수값n };
 */
	
	// City 열거형 객체 선언(기본값을 이용하는 열거형)
	public enum City {서울, 부산, 대구, 광주, 대전
//		City() {
//		
//		}
	};
//	public enum City {서울(), 부산(), 대구(), 광주(), 대전()};와 같음
	
	public enum Hometown {대구, 서울, 대전, 부산, 울산, 진주};
	
	
	// 데이터 값을 임의로 지정한 열거형 객체 선언
	// 데이터 값을 정해줄 경우에는 생성자를 만들어서 괄호 속의 값이 변수에 저장되도록 해야 한다.
	public enum Season { //마치 클래스를 만드는 느낌
		봄("3월부터 5월까지"), 여름("6월부터 8월까지"),
		가을("9월부터 11월까지"), 겨울("12월부터 2월까지");
		
		// 괄호 속의 값이 저장될 변수 선언
		private String str;
		
		// 생성자 만들기(열거형의 생성자는 제어자가 묵시적으로 'private'이다.)
		// 외부에서 생성자를 못 만듬! '나'만 쓸 수 있음 --> 열거형은 상수로 쓰려고 만든 객체 하나만 만듬
		// 새로 만들 필요가 없음, 새로 만들면 메모리만 낭비
		Season(String data) { // (private) Season(String data)와 같음. public이 들어가면 에러남
			this.str = data;
		}
		
		// 값을 반환하는 메서드(Setter)
		public String getStr() {
			return this.str;
		}
	}
	
	public static void main(String[] args) {
	/*
	 열거형에서 사용되는 메서드
	 1. name() => 열거형 상수의 이름을 문자열(String)로 반환한다.
	 2. ordinal() => 열거형 상수가 정의된 순서값을 반환한다.(기본적으로 0부터 시작) (서수, 순서)
	 3. valueOf("열거형상수이름") => 지정된 열거형에서 '열거형상수이름'과 일치하는 열거형상수를 반환한다.
	 */
		
		City myCity1; // 열거형 객체변수 선언
		City myCity2;
		
		// 위에 것과 밑에 것은 똑같음
		
		myCity1 = City.서울; // 서울이라는 상수가 myCity1에 들어감
		myCity2 = City.valueOf("서울");
		
		
		System.out.println("myCity1 : " + myCity1.name());
		System.out.println("myCity1의 ordinal : " + myCity1.ordinal()); // 0부터 시작
		System.out.println();
		System.out.println("myCity2 : " + myCity2.name());
		System.out.println("myCity2의 ordinal : " + myCity2.ordinal());
		System.out.println("==========================================");
		
		Season ss = Season.valueOf("여름");
		System.out.println("name => " + ss.name());
		System.out.println("ordinal => " + ss.ordinal());
		System.out.println("get메서드 호출 => " + ss.getStr()); // 클래스를 선언한 것처럼 메소드를 호출할 수 있음
		System.out.println("------------------------------------------");
		
		// 열거형이름.values() => 데이터를 배열로 리턴함.
		Season[] ssArr = Season.values();
		for(Season s : ssArr) {
			System.out.println(s.name() + " : " + s.getStr());
			
		}
		System.out.println();
		
		for(City city : City.values()) {
			System.out.println(city + " : " + city.ordinal());
		}
		
		City city = City.대구; // City는 Enum타입임
		Enum<City> city2 = City.대구; // 그래서 이것도 됨 like 우리가 만든 모든 것은 Object 같은 것
		
		System.out.println(city == City.대전);
		System.out.println(city == City.대구);
//		System.out.println(city == Hometown.대구); // 다른 대구임. 타입이 다름! 타입 안전한 코딩을 도와준다(타입체크까지 하고 있다)
		
		
		System.out.println("대구 => " + city.compareTo(City.대구)); // 같으니까 0
		System.out.println("서울 => " + city.compareTo(City.서울)); // 앞에 것이 더 커서 양수
		System.out.println("대전 => " + city.compareTo(City.대전)); // 뒤에 것이 더 커서 음수
		// 무엇을 비교한 것인가?! ordinal()!!!!값 기준
	}
}
