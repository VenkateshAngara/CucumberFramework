package Com.Wipro.APIFrameWork;

public class Message {
	private String message;
	private String greet;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getGreet() {
		return greet;
	}
	public void setGreet(String greet) {
		this.greet = greet;
	}
public static void main(String[] args) {
	Message m = new Message();
	m.setMessage("Hello Venkatesh");
	m.setGreet("Hi Angara");
	System.out.println(m.getGreet());
	System.out.println(m.getMessage());
}

}
