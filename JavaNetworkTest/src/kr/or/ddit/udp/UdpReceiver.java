package kr.or.ddit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpReceiver {
	private DatagramSocket ds;
	private DatagramPacket dp;
	
	private byte[] msg;
	
	public UdpReceiver() {
		try {
			msg = new byte[100];
			
			// 소켓객체 생성(포트번호를 명시하지 않으면 사용 가능한 포트번호 중에서 임의의 번호로 할당됨)
			ds = new DatagramSocket();
			
		} catch (SocketException ex) {
			ex.printStackTrace();
		}
	}
	
	public void start() throws IOException {
		
		InetAddress serverAddr = InetAddress.getByName("192.168.35.90");
		dp = new DatagramPacket(msg, 1, serverAddr, 8888); // 패킷을 보낼 용도라 데이터는 의미가 없기에!
		ds.send(dp); // 전송
		
		dp = new DatagramPacket(msg, msg.length);
		ds.receive(dp); // 패킷 수신...
		
		System.out.println("현재 서버 시간 => " + new String(dp.getData()));
		
	}
	
	public static void main(String[] args) throws IOException {
		new UdpReceiver().start();
	}
}
