package kr.or.ddit.basic;

import java.util.LinkedList;

public class T02StackQueueTest {
	public static void main(String[] args) {
		/*
		 * Stack => 후입선출(LIFO)의 자료구조
		 * Queue => 선입선출(FIFO)의 자료구조
		 */
		
		LinkedList<String> stack = new LinkedList<String>(); //밑에 LinkedList만의 메소드를 써서 List로 바꾸면 밑에 에러 천지됨
		/*
		 * LinkedList는 링크를 하나 하나 타고 가야 하기 때문에 Array리스트와 달리 느릴 수 있지만
		 * 중간에 링크가 지워지면 그냥 연결하면 돼서 ArrayList의 단점인 배열의 index가 땡겨지는 걸 방지할 수 있음
		 * 1 - 2 - 3 - 4 - 5에서 3의 링크를 지워버리면 
		 * 1 - 2 -   - 4 - 5로 돼서 2 다음 4가 나오지만 index 값은 고정됨
		 */
		
		
		/*
		 * Stack 방식의 메서드
		 * 1) 자료 입력 : push(저장할 값)
		 * 2) 자료 출력 : pop() => 자료를 꺼내온 후 꺼내온 자료를 Stack에서 삭제한다.
		 */
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		System.out.println("현재 stack값들 : "  + stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 자료 : " + data);
		System.out.println("꺼내온 자료 : " + stack.pop());
		System.out.println("현재 stack 값들 : " + stack);
		
		stack.push("성춘향");
		System.out.println("현재 stack값들 : " + stack);
		System.out.println("꺼내온 자료 : " + stack.pop());
		
		System.out.println("==========================================");
		System.out.println();
		
		LinkedList<String> queue = new LinkedList<String>();
		
		/*
		 * Queue 방식의 메서드
		 * 1) 자료 입력 : offer(저장할 값)
		 * 2) 자료 출력 : pull() => 자료를 queue에서 꺼내온 후 꺼내온 자료를 queue에서 삭제한다.
		 */
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		
		System.out.println("현재  queue의 값 : " + queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 자료 : " + temp);
		System.out.println("꺼내온 자료 : " + queue.poll());
		System.out.println("현재 queue의 값 : " + queue);
		
		if (queue.offer("성춘향")) {
			System.out.println("신규 등록 자료 : 성춘향");
		}
		System.out.println("현재 queue의 값 : " + queue);
		System.out.println("꺼내온 자료 : " + queue.poll());
		
	}
}
