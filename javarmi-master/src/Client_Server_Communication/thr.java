package Client_Server_Communication;

public class thr extends Thread implements t{
	String txt = null;
	
	@Override
	public Void in(String x) {
		// TODO Auto-generated method stub
		this.txt = x;
		return null;
	}
	public void run(){
		System.out.println("client: " + txt);
		
	}
}
