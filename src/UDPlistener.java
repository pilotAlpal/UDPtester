import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class UDPlistener extends Thread {

	private DatagramSocket listenerSocket;
	private byte[] recieveData=new byte[1024];
	public UDPlistener(){
		Scanner teclado=new Scanner(System.in);
		System.out.println("What port do you want to listen?");
		String puerto=teclado.nextLine();
		int port=Integer.valueOf(puerto);
		try {
			listenerSocket=new DatagramSocket(port);
			recieveData=new byte[1024];
		} catch (SocketException e) {
			System.err.println("Couldn´t open listener socket");
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		DatagramPacket recievedPacket=new DatagramPacket(recieveData, recieveData.length);
		try {
			listenerSocket.receive(recievedPacket);
			System.out.println(recievedPacket+" recieved"+LocalDateTime.now());
			byte[] b=recievedPacket.getData();
			int len=recievedPacket.getLength();
			String incomed="";
			System.out.println("Incoming data: "+b[0]);
			for(int i=0;i<len;i++){
				incomed+=(char)b[i];
			}
			System.out.println("Recieved data: "+incomed);
		} catch (IOException e) {
			System.err.println("IOE recieving from listener");
			e.printStackTrace();
		}
		
	}
}
