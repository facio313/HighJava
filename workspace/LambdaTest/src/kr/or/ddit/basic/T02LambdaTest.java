package kr.or.ddit.basic;

import java.util.function.Consumer;

public class T02LambdaTest {
	public static void main(String[] args) {
		
		// 람다식을 사용하지 않았을 경우
		LambdaInterface1 lam1 = new LambdaInterface1() {
			
			@Override
			public void test() {
				System.out.println("안녕하세요.");
				System.out.println("익명 구현 객체 방식입니다.");
			}
		};
		lam1.test();
		
		// 람다식을 사용한 경우
		LambdaInterface1 lam2 = ()->{
			System.out.println("반가워요\n람다식으로 처리하는 방식입니다.");
		};
		lam2.test();
		System.out.println("-------------------------------------------------");
		
		/*
		 * 람다식 작성 방법에 대하여... 
		 * 
		 * 기본형식) (자료형이름 매개변수명, ...) -> {실행문들;...}
		 * 
		 * 1) 매개변수의 '자료형이름'은 생략할 수 있다.
		 * ex) (int a) -> {System.out.println(a);}
		 * 		   (a) -> {System.out.println(a);}
		 * 
		 * 2) 매개변수가 1개일 경우에는 괄호'()'를 생략할 수 있다.
		 * (단, '자료형이름'을 지정할 경우에는 생략할 수 없다.)
		 * ex)      a  -> {System.out.println(a);}
		 * 
		 * 3) '실행문'이 1개일 경우에는 '{}'를 생략할 수 있다.
		 * (이때 문장의 끝을 나타내는 세미콜론(;)도 생략한다.)
		 * ex)      a  ->  System.out.println(a)
		 * 
		 * 4) 매개변수가 하나도 없으면 괄호'()'를 생략할 수 없다.
		 * (아예 없다는 것을 명시적으로 표현해야 함)
		 * ex)		() ->  System.out.println("안녕")
		 * 
		 * 5) 반환값이 있을 경우에는 return 명령을 사용한다.
		 * ex)  (a, b) -> {return a+b;}
		 * 		(a, b) ->  return a+b        --3번도 적용
		 * 
		 * 6) 실행문에 return문만 있을 경우 return명령과 '{}'를 생략할 수 있다.
		 * ex)  (a, b) -> a + b
		 * 
		 * 
		 */
		
		LambdaInterface2 lam3 = 
			(int z) -> {
				int result = z + 100;
				System.out.println("result = " + result);
			};
		lam3.test(30);
		
		//Consumer 인터페이스로 사용하기
//		Consumer<Integer> lam3 = 
////				(Integer z) -> {
//				z -> {
//					int result = z + 100;
//					System.out.println("result = " + result);
//				};
//				lam3.accept(30);

		LambdaInterface2 lam4 = 
			z -> {
				int result = z + 300;
				System.out.println("result = " + result);
			};
		lam4.test(60);

		LambdaInterface2 lam5 = 
			z -> System.out.println("result = " + (z + 500));
		lam5.test(90);

		System.out.println("-------------------------------------------------");
		
		LambdaInterface3 lam6 = 
			(int x, int y) -> {
			int r = x + y;
			return r;
		};
		int k = lam6.test(20,  50);
		System.out.println("k = " + k);
		
		LambdaInterface3 lam7 = 
			(x, y) -> {
				return x + y;
			};
		k = lam7.test(80,  50);
		System.out.println("k = " + k);
		
		LambdaInterface3 lam8 =
				(x, y) -> x + y;
		k = lam8.test(100, 200);
		System.out.println("k = " + k);
				
		LambdaInterface3 lam9 =
				(x, y) -> x > y ? x : y;
				
		k = lam9.test(100, 200);
		System.out.println("k = " + k);
		
	}
}