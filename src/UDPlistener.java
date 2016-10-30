import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class UDPlistener extends Thread {

	private String address;
	private int port;
	private DatagramSocket listenerSocket;
	private byte[] recieveData=new byte[1024];
	public UDPlistener(){
		Scanner teclado=new Scanner(System.in);
		System.out.println("What port do you want to listen?");
		String puerto=teclado.nextLine();
		port=Integer.valueOf(puerto);
		address="Not assigned";
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
			System.out.println("UDP recieved at"+LocalDateTime.now());
			byte[] b=recievedPacket.getData();
			int len=recievedPacket.getLength();
			String incomed="";
			for(int i=0;i<len;i++)
				incomed+=(char)b[i];
			System.out.println("Recieved data: "+incomed);
			address=recievedPacket.getAddress().getHostAddress();
			System.out.println("Data sender: "+address);
		} catch (IOException e) {
			System.err.println("IOE recieving at listener");
			e.printStackTrace();
		}
		
	}
	
	public int getPort(){
		return port;
	}

	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}
}
