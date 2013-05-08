package ie.cit.clouddev.domain;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TPlayers {
	public List<Player> players = new ArrayList<Player>();

	public TPlayers() {
	}

	public TPlayers(List<Player> players) {
		super();
		this.players = players;
		
	}

}
