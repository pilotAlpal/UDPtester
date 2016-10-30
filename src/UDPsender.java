import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPsender {

	private DatagramPacket sendPacket;
	private DatagramSocket senderSocket;
	public UDPsender(){
		Scanner teclado=new Scanner(System.in);
		try {
			senderSocket=new DatagramSocket();
			System.out.println("Wich IP you want to send to?");
			String ipString=teclado.nextLine();
			try {
					InetAddress	ipAddr = InetAddress.getByName(ipString);
					System.out.println("What message you want to send?");
					String port=teclado.nextLine();
					int puerto= Integer.valueOf(port);
					String message=teclado.nextLine();
					byte[] sendData=message.getBytes();
					System.out.println("Wich port you want to send to?");
					sendPacket=new DatagramPacket(sendData,sendData.length,ipAddr,puerto);
			} catch (UnknownHostException e) {
				System.err.println("Invalid IP address");
				e.printStackTrace();
			}
		} catch (SocketException e) {
			System.err.println("Couldn´t oppen socket");
			e.printStackTrace();
		}
	}
	public void sendUDP() {
		try {
			senderSocket.send(sendPacket);
		} catch (IOException e) {
			System.err.println("IOException");
			e.printStackTrace();
		}
		
	}

}
