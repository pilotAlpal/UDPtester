import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		askAction();
	}
	
	private static void askAction(){
		System.out.println("What you want to do?");
		System.out.println("1)-Send udp");
		System.out.println("2)-Listen udp");
		System.out.println("3)-Print localIP");
		System.out.println("4)-Usage example");
		System.out.println("5)-Quit");
		String response=new Scanner(System.in).nextLine();
		parse(response);
	}

	
	private static void askAgain(){
		System.out.println("Action performed.");
		askAction();
	}
	
    private static void parse(String res){
    	boolean quit=false,reask=false;
    	String res1=res.trim();
    	if(res1.equalsIgnoreCase("1")){
    		UDPsender sender=new UDPsender();
    		sender.sendUDP();
    	}
    	else if(res.equalsIgnoreCase("2")){
    		UDPlistener listener=new UDPlistener();
    		listener.start();
    	}
    	else if(res.equalsIgnoreCase("3")){
    		try {
				System.out.println(InetAddress.getLocalHost().getHostAddress());
			} catch (UnknownHostException e) {
				System.err.println("Could´t get local IP address");
				e.printStackTrace();
			}
    	}
    	else if(res.equalsIgnoreCase("4")){
    		System.out.println("A: Select option 3) for getting your ipAddress");
    		System.out.println("B: Select option 2 and choose a local port from your"
    				+ " computer to listen it.");
    		System.out.println("C: System asks to quit again, choose no");
    		System.out.println("D: Select option 3 and send the data you want, to your IP address"
    				+ " which you got in A, and to the port you are listening to, chose on B");
    		System.out.println("E: You sould be told some data incomed");
    	}
    	else if(res.equalsIgnoreCase("5"))
    		quit=true;
    
    	else{
    		System.out.println("Invalid option, try again");
    		reask=true;
    		askAction();
    	}
    	if(!quit&&!reask)
    		askAgain();
    }

}
