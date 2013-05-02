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
@RequestMapping("api")  // for all mappings
public class TPlayerRestController {     // list of players in jason
	
	@Autowired
	private TplayersService tplayersService;

	
	@RequestMapping(value = "player", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public TPlayers players() {
		return new TPlayers(tplayersService.getAllPlayers());	
	}

		
	@RequestMapping(value = "player/{playerId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody		
	public Player player(@PathVariable String playerId) {
		Player player = tplayersService.get(playerId);
		if (player == null)
			throw new NotFoundException();
		return player;
	}

			
	@RequestMapping(value = "player", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestParam String name, HttpServletRequest req,
			HttpServletResponse resp) {
		Player player= tplayersService.newplayer(name);
		StringBuffer url = req.getRequestURL().append("/{playerId}");
		UriTemplate uriTemplate = new UriTemplate(url.toString());
		resp.addHeader("location", uriTemplate.expand(player.getPlayerId()).toASCIIString());
	}

	
	@RequestMapping(value = "player/{playerId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String playerId) {
		tplayersService.delete(playerId);
	}

			
	@RequestMapping(value = "player/{playerId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable String playerId, @RequestBody Player player) {
	Player existing = tplayersService.get(playerId);
	if (existing == null)
		throw new NotFoundException();
	existing.setName(player.getName());
  //  existing.setFittoplay(player.setFittoplay());
	}
	
	

	@ResponseStatus(HttpStatus.NOT_FOUND)
	class NotFoundException extends RuntimeException {
			private static final long serialVersionUID = 1L;
	}
		
			
	}
	
	
	
		
	
