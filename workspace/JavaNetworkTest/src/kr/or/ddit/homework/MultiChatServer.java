package kr.or.ddit.homework;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MultiChatServer {

	// 대화명, 클라이언트의 Socket을 저장하기 위한 Map 변수 선언
	private Map<String, Socket> clients;
	
	// 생성자
	public MultiChatServer() {
		// 동기화 처리가 가능하도록 Map객체 생성
		clients = Collections.synchronizedMap(new HashMap<>());
	}
	
	// 서버 시작
	public void serverStart() {
		
		Socket socket = null;
		
		try(ServerSocket serverSocket = new ServerSocket(7777)){
			System.out.println("서버가 시작되었습니다.");
			
			while (true) {
				// 클라이언트의 접속을 대기한다.
				socket = serverSocket.accept();
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속하였습니다.");
				
				// 메시지 전송 처리를 하는 스레드 생성 및 실행
				ServerReceiver receiver = new ServerReceiver(socket);
				receiver.start();
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} 
		
		// 위와 동일
//		ServerSocket serverSocket = null;
//		
//		try {
//			serverSocket = new ServerSocket(7777)
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		} finally {
//			serverSocket.close();
//		}
		
	}
	
	/**
	 * 
	 * @param msg
	 */
	public void sendMessage(String msg) {
		// Map에 저장된 사용자의 대화명 리스트 추출(key값 구하기)
		Iterator<String> it = clients.keySet().iterator();
		
		while(it.hasNext()) {
			try {
				String name = it.next(); // 대화명
				
				// 대화명에 해당하는 Socket객체에서 OutputStream 꺼내기
				DataOutputStream dos = new DataOutputStream(clients.get(name).getOutputStream());
					dos.writeUTF(msg); // 메시지 전송하기
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * 대화방 즉, Map에 저장된 전체 유저에게 대화 메시지를 전송하는 메서드
	 * @param msg
	 * @param from
	 */
	public void sendMessage(String msg, String from) {
		sendMessage("[" + from + "] : " + msg);
	}
	
	/**
	 * 채팅방 기능을 알려주는 메서드
	 * @param to
	 * @throws IOException 
	 */
	public void sendUtilityMessage(String from) throws IOException {
		DataOutputStream dos = new DataOutputStream(clients.get(from).getOutputStream());
		StringBuilder utility = new StringBuilder();
		utility.append("■■■■■■■■■■■■■■■■■■■■■■■■■■대화방 기능■■■■■■■■■■■■■■■■■■■■■■■■■■\n");
		utility.append("/w 이름 내용 => '이름'에게 귓속말로 '내용'을 보낼 수 있습니다.\n");
		utility.append("/l           => 현재 접속 중인 회원 목록을 볼 수 있습니다.\n");
//		utility.append("");
		dos.writeUTF(utility.toString());
	}
	
	/**
	 * 대화방에 호출하는 회원이 존재하지 않는 것을 알려주는 메서드
	 * @param to
	 * @throws IOException
	 */
	public void sendUnexistMessage(String from, String to) throws IOException {
		DataOutputStream dos = new DataOutputStream(clients.get(from).getOutputStream());
		dos.writeUTF(to + "(이)라는 회원이 존재하지 않습니다.");
		
	}
	
	/**
	 * 귓속말을 보내주는 메서드
	 * @param from
	 * @param msg
	 * @param to
	 * @throws IOException
	 */
	public void sendPrivateMessage(String from, String msg, String to) throws IOException { // split()으로 해보
		DataOutputStream dos = new DataOutputStream(clients.get(to).getOutputStream());
		dos.writeUTF("[" + from + "](으)로부터 " + "[" + to + "]에게 : "  + msg);
	}
	
	
	// 서버에서 클라이언트로 메시지를 전송할 Thread클래스를 Inner클래스로 정의 시
	// 부모(Outer)클래스의 멤버들을 직접 사용할 수 있다.
	class ServerReceiver extends Thread {
		private Socket socket;
		private DataInputStream dis;
		private String name;
		
		public ServerReceiver(Socket socket) {
			this.socket = socket; // 멤버변수에 잠깐 담아두겠다는 의미
			
			try {
				// 수신용
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				// 서버에서 클라이언트가 보내는 최초의 메시지 즉, 대화명을 수신해야 한다.
				name = dis.readUTF();
				
				// 대화명을 받아서 다른 모든 클라이언트에게 대화방 참여 메시지를 보낸다.
				sendMessage('#' + name + "님이 입장했습니다.");
				
				// 대화명과 소켓객체를 Map에 저장한다.`
				clients.put(name, socket);
				
				
				System.out.println("현재 서버 접속자 수는 " + clients.size() + "명 입니다.");
				
				sendUtilityMessage(name);
				
				
				// 이 이후의 메시지 처리는 반복문을 처리한다.
				// 한 클라이언트가 보낸 메시지를 다른 특정 클라리언트들에게 보내준다.
				while(dis != null) {
					String content =  dis.readUTF();
					if(content.substring(0, 2).equals("/w")) { // 만약 /w를 썼다면!
						for (String keyName : clients.keySet()) {
							if (content.contains(keyName)) { // 만약 /w 다음 나오는 닉네임이 clients의 키에 있다면!
								String form = "/w " + keyName + " "; // 귓속말 양식
								sendPrivateMessage(name, content.replaceAll(form, ""), keyName); // 귓속말을 보낸다.
								System.out.println(keyName);
//							} else { // 만약 /w 다음 나오는 닉네임이 clients의 키에 없다면!
//								sendUnexistMessage(name, keyName); // 귓속말을 보낼 상대의 부재를 알려준다.
//								System.out.println(keyName);
							}
						} 
					} else {
						// 한 클라이언트가 보낸 메시지를 다른 모든 클라리언트들에게 보내준다.
						sendMessage(content, name);
					}
				}

				
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				// 이 finally 영역이 실행된다는 것은 클라이언트의 접속이 종료되었다는 의미이다.
				sendMessage(name + "님이 나가셨습니다.");
				
				// Map에서 해당 대화명을 삭제한다.
				clients.remove(name);
				
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "] 에서 접속을 종료하였습니다.");
				System.out.println("현재 서버 접속자 수는 " + clients.size() + "명 입니다.");
				System.out.println("현재 서버 접속자" + clients.get(name));
			}
		}
		
	}
	public static void main(String[] args) {
		new MultiChatServer().serverStart();
	}
}
