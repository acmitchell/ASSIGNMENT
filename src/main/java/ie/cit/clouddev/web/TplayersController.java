package ie.cit.clouddev.web;

import ie.cit.clouddev.services.TplayersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TplayersController {
	
	@Autowired
	private TplayersService tplayersService;
	
	@RequestMapping("index")
	public String index(Model model){
		model.addAttribute("players", tplayersService.getAllPlayers());
		return "TeamPlayers.jsp";
	}
	
	@RequestMapping("newplayer")
	public String newplayer(@RequestParam String name , Model model){
		tplayersService.newplayer(name);
		model.addAttribute("players", tplayersService.getAllPlayers());
		return "TeamPlayers.jsp";
	}
	
	@RequestMapping("notfit")
	public String close(@RequestParam String playerId , Model model){
		tplayersService.notfit(playerId);
		model.addAttribute("players", tplayersService.getAllPlayers());
		return "TeamPlayers.jsp";
	}
	
	@RequestMapping("fit")
	public String open(@RequestParam String playerId , Model model){
		tplayersService.fit(playerId);
		model.addAttribute("players", tplayersService.getAllPlayers());
		return "TeamPlayers.jsp";
	}
	
	

}
