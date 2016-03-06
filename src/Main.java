import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

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
			
			InetSocketAddress sockaddr = (InetSocketAddress)packet.getSocketAddress();
			InetAddress inet_address = sockaddr.getAddress();

			String ip = inet_address.getHostAddress();
			int port = sockaddr.getPort();

			byte[] reply_data = packet.getData();
	        DatagramPacket dp = new DatagramPacket(reply_data, reply_data.length, inet_address, port);
	        socket.send(dp);
		}
	}

}
