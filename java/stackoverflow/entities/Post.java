package stackoverflow.entities;

import stackoverflow.enums.VoteType;

import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Post extends Content{
	private final AtomicInteger voteCount = new AtomicInteger(0);
	private final Map<String, VoteType> voters= new ConcurrentHashMap<>();
	private final List<Comment> comments = new CopyOnWriteArrayList<>();

	public Post(String id, String body, User author){
		super(id,body,author);
	}
	
	public synchronized void vote(User user, VoteType voteType){
		String userId = user.getId();

		if(voters.get(userId) == voteType){
			return;
		}

		int scoreChange = 0;
		if(voters.containsKey(userId)) {
			scoreChange = (voteType == VoteType.UPVOTE)? 2:-2;
		}
		else{
			scoreChange = (voteType == VoteType.UPVOTE)? 1:-1;
		}

		voters.put(userId,voteType);
		voteCount.addAndGet(scoreChange);
	}
}
