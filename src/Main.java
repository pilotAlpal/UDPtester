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
		Scanner t=new Scanner(System.in);
		String response=t.nextLine();
		parse(response);
	}

	
	private static void askAgain(){
		Scanner te=new Scanner(System.in);
		System.out.println("Action performed, do you want to quit?(Yes/No)");
		String res=te.nextLine();
		res=res.trim();
		if(res.equalsIgnoreCase("no"))
			askAction();
		else if(!res.equalsIgnoreCase("yes")){
			System.out.println("Sorry I didn´t understood you,");
			askAgain();
		}
	}
	
    private static void parse(String res){
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
				System.out.println(InetAddress.getLocalHost().toString());
			} catch (UnknownHostException e) {
				System.err.println("Could´t get local IP address");
				e.printStackTrace();
			}
    	}
    	else if(res.equalsIgnoreCase("4")){
    		System.out.println("A: Select option 3) for getting your ipAddress");
    		System.out.println("B: System asks to quit, choose no");
    		System.out.println("C: Select option 2 and choose a local port from your"
    				+ "computer to listen it.");
    		System.out.println("D: System asks to quit again, choose no");
    		System.out.println("E: Select option 3 and send the data you want, to your IP address"
    				+ "which you got in B, and to the port you are listening to, chose on C");
    		System.err.println("You sould be told some data incomed");
    	}
    	else {
    		System.out.println("Invalid option, try again");
    		askAction();
    	}
    	askAgain();
    }

}
