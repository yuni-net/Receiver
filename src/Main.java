import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {
	private static int port = 9696;

	public static void main(String[] args) throws Exception {
		System.out.println("Server started.");
		DatagramSocket socket = new DatagramSocket(port);
		
		while(true) {
			System.out.println("server's IP: " + InetAddress.getLocalHost().getHostAddress());
			System.out.println("server's port: " + port);
			System.out.println("waiting...");
	
			byte buffer[] = new byte[512];
			DatagramPacket packet = new DatagramPacket(buffer,  buffer.length);
			socket.receive(packet);
	
			System.out.println("You got a message:");
			System.out.println("    " + new String(packet.getData()));
		}
	}

}
