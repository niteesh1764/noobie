package auction.observer;
import auction.entities.*;
public interface AuctionObserver{
	void onUpdate(Auction auction , String message);
}
