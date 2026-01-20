package stackoverflow.entities;

import java.util.UUID;

public class Answer extends Post{
	public boolean isAccepted = false;

	public Answer(String body, User author){
		super(UUID.randomUUID().toString(),body,author);
	}
	
	public void setAccepted(boolean bool){
		isAccepted = bool;
	}
	public boolean isAccepted() {
		return isAccepted;
	}

}
