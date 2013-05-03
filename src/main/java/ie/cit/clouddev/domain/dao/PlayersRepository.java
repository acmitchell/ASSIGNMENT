package ie.cit.clouddev.domain.dao;

import java.util.List;


import ie.cit.clouddev.domain.Player;
import ie.cit.clouddev.domain.TPlayers;

public interface PlayersRepository {
	
	Player findPlayerId(String playerId);
	
	void add(Player player);
	
	void delete(String playerId);
	
	void update(Player player);

	List<Player> getAllP();


	List<Player> getAllfitP();
	


}
