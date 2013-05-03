package ie.cit.clouddev.domain.dao;


import ie.cit.clouddev.domain.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPlayerRepos implements PlayersRepository {

		private Map<String, Player> data = new HashMap<String, Player>();

		@Override
		public Player findPlayerId(String playerId) {
			return data.get(playerId);
		}

		
		@Override
		public List<Player> getAllP() {
			return new ArrayList<Player>(data.values());
		}
		
		@Override
		public List<Player> getAllfitP() {
			return new ArrayList<Player>(data.values());
		}

		@Override
		public void add(Player player) {
			data.put(player.getPlayerId(), player);
		}

		@Override
		public void delete(String PlayerId) {
			data.remove(PlayerId);
		}

		@Override
		public void update(Player player) {
			data.put(player.getPlayerId(), player);
		}


		
		

		

		

	}

	
	
