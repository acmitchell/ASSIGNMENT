package ie.cit.clouddev.services;

import ie.cit.clouddev.domain.Player;
import ie.cit.clouddev.domain.TPlayers;
import ie.cit.clouddev.domain.dao.PlayersRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class TplayersServiceImpl implements TplayersService {

	private PlayersRepository repo;

	public TplayersServiceImpl(PlayersRepository repo) {
		this.repo = repo;
	}

	public List<Player> getAllPlayers() {
		return repo.getAllP();
	}

	public List<Player> getAllFitPlayers() {
		return repo.getAllfitP();
	}

	public Player newplayer(String name, String contactno, String dob) {
		Player player = new Player();
		player.setName(name);
		player.setContactno(contactno);
		player.setDob(dob);
		repo.add(player);
		return player;
	}

	public void fit(String playerId) {
		Player player = repo.findPlayerId(playerId);
		if (player != null) {
			player.setFittoplay(true);
			repo.update(player);
		}
	}

	public void notfit(String playerId) {
		Player player = repo.findPlayerId(playerId);
		if (player != null) {
			player.setFittoplay(false);
			repo.update(player);
		}
	}

	public Player get(String playerId) {

		return repo.findPlayerId(playerId);
	}

	@Override
	public void delete(String PlayerId) {
		repo.delete(PlayerId);
	}

}
