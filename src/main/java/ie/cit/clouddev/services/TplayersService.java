package ie.cit.clouddev.services;

import java.util.List;

import ie.cit.clouddev.domain.Player;
import ie.cit.clouddev.domain.TPlayers;

public interface TplayersService {

	List<Player> getAllPlayers();

	Player newplayer(String name, String contactno, String dob);

	void delete(String playerId);

	void fit(String playerId);

	Player get(String playerId);

	void notfit(String playerId);

	List<Player> getAllFitPlayers();

}
