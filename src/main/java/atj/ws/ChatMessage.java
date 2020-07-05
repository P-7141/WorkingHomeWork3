package atj.ws;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class ChatMessage {

	@JsonbProperty("imie")
	private String user;
	@JsonbProperty(nillable = true)
	private String email;
	@JsonbProperty("wiadomosc")
	private String message;
	@JsonbTransient
	private int msgLenght;

	public ChatMessage() {

	}

	public ChatMessage(String user, String email, String message) {
		super();
		this.user = user;
		this.email = email;
		this.message = message;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getMsgLenght() {
		return msgLenght;
	}

	public void setMsgLenght(int msgLenght) {
		this.msgLenght = msgLenght;
	}

	@Override
	public String toString() {
		return String.format("[%s] %s", getUser(), getMessage());
	}

}
