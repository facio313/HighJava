package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		
		// InetAddress 클래스 => IP주소를 다루기 위한 클래스
		
		// getByName() 메서드는 www.naver.com 또는 SEM-PC등과 같은 머신이름이나 IP주소를 통해 유효한 InetAddress 객체를 제공한다.
		// 주소 자체의 유효성 체크가 이루어짐
		// domain(www.naver.com)은 편하라고 만들어진 것 원래는 그냥 IP주소..
		
		// 네이버의 IP정보 가져오기
		InetAddress naverIp = InetAddress.getByName("www.naver.com"); // getByName() 할 때 UnknownHostException 발생
		System.out.println("Host Name => " + naverIp.getHostName());
		System.out.println("Host Address => " + naverIp.getHostAddress());
		System.out.println();
		
		// 자기 자신 컴퓨터의 IP정보 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 Host Name => " + localIp.getHostName());
		System.out.println("내 컴퓨터의 Host Address => " + localIp.getHostAddress());
		System.out.println();
		
		// IP 주소가 여러 개인 호스트의 정보 가져오기
		InetAddress[] naverIps = InetAddress.getAllByName("naver.com");
		for (InetAddress iAddr : naverIps) {
			System.out.println(iAddr.toString());
		}
	}
}