package stackoverflow.entities;

import java.util.*;

public class Question extends Post{
	
	private final String title;
	private Answer acceptedAnswer;
	private final Set<Tag> tags;
	private final List<Answer> answers = new ArrayList<>();

	
	public Question(String title,Set<Tag> tags, String body, User author){
		super(UUID.randomUUID().toString(), body, author);
		this.title = title;
		this.tags = tags;
	}

	public void addAnswer(Answer answer) {
		this.answers.add(answer);
	}

	public synchronized void acceptAnswer(Answer answer){
		if(!this.author.getId().equals(answer.author.getId()) && this.acceptedAnswer == null){
			this.acceptedAnswer = answer;
			answer.setAccepted(true);
		}
	}
	public String getTitle(){
		return title;
	}
	public Set<Tag> getTags(){
		return tags;
	}
	public List<Answer> getAnswers(){
		return answers;
	}
	public Answer getAcceptedAnswer(){
		return acceptedAnswer;
	}

}
