package kr.or.ddit.basic.homework;

public class Planet {

	public enum Planets {
		수성(2439), 금성(6052), 지구(6371), 화성(3390), 목성(69911), 토성(58232), 천왕성(25362), 해왕성(24622);

		// enum필드, 열거형 상수와는 다른 값을 연결하기 위해 선언한 변수
		// 위에 것 중에 ()안에 쓰인 것
		private int radius;

		// enum의 생성자는 private만 허용함
		Planets(int radius) {
			this.radius = radius;
		}

		// 열거형 메소드
		public int getRadius() {
			return radius;
		}

	};

	public static void main(String[] args) {
		// 구의 면적을 구하는 공식 : 4πrr

		// r(radius)와 이름을 나타내기 위해 enum Planets 객체 만들기
		Planets[] planetList = Planets.values(); 
		// values() 메서드는 해당 열거체의 모든 상수를 저장한 배열을 생성하여 반환함
		// valueOf() 메서드는 전달된 문자열과 일치하는 해당 열거체의 상수를 반환함
		// ordinal() 메서드는 해당 열거체 상수가 열거체 정의에서 정의돈 순서(0부터)를 반환함
		
		// foreach로 Planets에 있는 행성들 면적 나타내기(name()과 enum에 선언한 메서드)
		for (Planets p : planetList) {
			System.out.println("-----------------------------------------");
			System.out.println(p.name() + "의 면적 : " + 4 * Math.PI * p.getRadius() * p.getRadius() + "km2");
		}
		System.out.println("-----------------------------------------");
	}
}