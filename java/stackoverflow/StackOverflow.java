package stackoverflow;

import java.util.*;

import stackoverflow.entities.*;
import stackoverflow.strategy.*;
import stackoverflow.enums.*;
import stackoverflow.service.*;

public class StackOverflow{
	
	public static void main(String[] args){
		StackOverflowService service = new StackOverflowService();

		User ulli = service.createUser("ulli");
		User niti = service.createUser("niti");
		User motu = service.createUser("motu");

		System.out.println("---Ulli Posts a Question");
		Tag javaTag = new Tag("java");
		Tag designTag = new Tag("design");
		Set<Tag> tags = Set.of(javaTag, designTag);
		Question question = service.postQuestion("How to implement Observer Pattern", "OOPS Patterns" , tags, ulli.getId());
		
		System.out.println("---Niti and Motu post answers");
		Answer nanswer = service.postAnswer("Very Useful", niti.getId(), question.getId());
		Answer manswer = service.postAnswer("true", motu.getId(),question.getId());

		System.out.println("--- Voting");
		service.voteOnPost(question.getId(), VoteType.UPVOTE , niti.getId());
		service.voteOnPost(nanswer.getId(), VoteType.UPVOTE , motu.getId());
		service.voteOnPost(manswer.getId(), VoteType.UPVOTE , ulli.getId());
		
		System.out.println("--- Accepting answer");
		service.acceptAnswer(question.getId(), nanswer.getId());

		System.out.println("--- ulli java question strat");

		List<SearchStrategy> strategies = List.of(new UserSearchStrategy(ulli), new TagSearchStrategy(javaTag));

		List<Question> results = service.searchQuestions(strategies);
		results.forEach(r -> System.out.println("-- Found: " + r.getTitle()));
	}
}
