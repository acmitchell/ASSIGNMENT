package ie.cit.clouddev.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// import ie.cit.clouddev.web.NotFoundException;
import ie.cit.clouddev.domain.Player;
import ie.cit.clouddev.domain.TPlayers;
import ie.cit.clouddev.services.TplayersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriTemplate;

@Controller
@RequestMapping("api")
// for all mappings
public class TPlayerRestController { // list of players in jason

	@Autowired
	private TplayersService tplayersService;

	// curl -u cat:clever -X GET -i http://tplayers/cloudfoundry.comfitplayers
	@RequestMapping(value = "fitplayers", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public TPlayers fitplayers() {
		return new TPlayers(tplayersService.getAllFitPlayers());
	}
	// curl -u cat:clever -X GET -i http://tplayers/cloudfoundry.com/players
	@RequestMapping(value = "players", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public TPlayers players() {
		return new TPlayers(tplayersService.getAllPlayers());
	}

	// curl -u cat:clever -X GET -i http://tplayers/cloudfoundry.com/player/{playerId}
	@RequestMapping(value = "player/{playerId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Player player(@PathVariable String playerId) {
		Player player = tplayersService.get(playerId);
		if (player == null)
			throw new NotFoundException();
		return player;
	}

	// curl -u cat:clever -X POST -i http://tplayers/cloudfoundry.com/player/ ?name=Tomas ?contactno=087666666 ?dob=1/4/2000
	@RequestMapping(value = "player", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestParam String name, String contactno, String dob,
			HttpServletRequest req, HttpServletResponse resp) {
		Player player = tplayersService.newplayer(name, contactno, dob);
		StringBuffer url = req.getRequestURL().append("/{playerId}");
		UriTemplate uriTemplate = new UriTemplate(url.toString());
		resp.addHeader("location", uriTemplate.expand(player.getPlayerId())
				.toASCIIString());
	}

	// curl -X DELETE -i http://tplayers/cloudfoundry.com/player/{playId}
	@RequestMapping(value = "player/{playerId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String playerId) {
		tplayersService.delete(playerId);
	}

	// curl -X PUT -i http://tplayer/cloudfoundry.com/player/{id} -d
		// '{"name":"Thomas","fittoplay":true}'
	@RequestMapping(value = "player/{playerId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable String playerId, @RequestBody Player player) {
		Player existing = tplayersService.get(playerId);
		if (existing == null)
			throw new NotFoundException();
		existing.setName(player.getName());
		existing.setFittoplay(player.isfittoplay());
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	class NotFoundException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}

}
