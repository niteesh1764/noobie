package stackoverflow.service;

import stackoverflow.entities.*;
import stackoverflow.enums.*;
import stackoverflow.strategy.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverflowService{
	
	private final Map<String,User> users = new ConcurrentHashMap<>();
	private final Map<String,Answer> answers = new ConcurrentHashMap<>();
	private final Map<String,Question> questions = new ConcurrentHashMap<>();

	public User createUser(String name){
		User user = new User(name);
		users.put(user.getId(), user);
		return user;
	}

	public Question postQuestion(String body, String title, Set<Tag> tags, String userId){
		User author = users.get(userId);
		Question question = new Question(title,tags, body, author);
		questions.put(question.getId(), question);
		return question;
	}
	
	public Answer postAnswer(String body, String userId, String questionId){
		User author = users.get(userId);
		Question question = questions.get(questionId);
		Answer answer = new Answer(body, author);
		question.addAnswer(answer);
		answers.put(answer.getId(), answer);
		return answer;
	}
	public void voteOnPost(String postId, VoteType voteType, String userId){
		User user = users.get(userId);
		Post post = getPostById(postId);
		post.vote(user, voteType);
	}

	public void acceptAnswer(String questionId, String answerId){
		Question question = questions.get(questionId);
		Answer answer = answers.get(answerId);
		question.acceptAnswer(answer);
	}

	private Post getPostById(String id){
		if(answers.containsKey(id)){
			return answers.get(id);
		}
		else if(questions.containsKey(id)){
			return questions.get(id);
		}
		throw new NoSuchElementException("Post Not Found");
	}

	public List<Question> searchQuestions(List<SearchStrategy> strategies){
		List<Question> results = new ArrayList<>(questions.values());

		for(SearchStrategy strategy : strategies){
			results = strategy.filter(results);
		}
		return results;
	}

}
