package kr.or.ddit.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpChatServer {
	public static void main(String[] args) {

		ServerSocket server = null;
		Socket socket = null;
		
		try {
			server = new ServerSocket(7777);
			System.out.println("서버 준비 완료...");
			socket = server.accept(); // mainThread가 block됨 - 클라이언트가 접속 요청해서 둘만의 소켓이 만들어지면 풀림
			System.out.println("접속되었습니다.");
			
			Sender sender = new Sender(socket);
			sender.start();
			
			Receiver receiver = new Receiver(socket);
			receiver.start();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
}
