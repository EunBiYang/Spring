package anno5;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")  // prototype : 매번 객체 생성, singleton : 1번만 객체 생성
public class MyMessage {
	private String message;
	
	public MyMessage() {
		message = "즐겁게 삽시다.";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}
