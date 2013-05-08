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
	public String index(Model model) {
		model.addAttribute("players", tplayersService.getAllPlayers());
		model.addAttribute("fitplayers", tplayersService.getAllFitPlayers());
		return "TeamPlayers.jsp";
	}

	@RequestMapping("fitplayers")
	public String fitplayers(Model model) {
		model.addAttribute("fitplayers", tplayersService.getAllFitPlayers());
		return "TeamPlayers.jsp";
	}

	@RequestMapping("newplayer")
	public String newplayer(@RequestParam String name, String contactno,
			String dob, Model model) {
		tplayersService.newplayer(name, contactno, dob);
		model.addAttribute("players", tplayersService.getAllPlayers());
		model.addAttribute("fitplayers", tplayersService.getAllFitPlayers());
		return "TeamPlayers.jsp";
	}

	@RequestMapping("notfit")
	public String notfit(@RequestParam String playerId, Model model) {
		tplayersService.notfit(playerId);
		model.addAttribute("players", tplayersService.getAllPlayers());
		model.addAttribute("fitplayers", tplayersService.getAllFitPlayers());
		return "TeamPlayers.jsp";
	}

	@RequestMapping("delete")
	public String delete(@RequestParam String playerId, Model model) {
		tplayersService.delete(playerId);
		model.addAttribute("players", tplayersService.getAllPlayers());
		model.addAttribute("fitplayers", tplayersService.getAllFitPlayers());
		return "TeamPlayers.jsp";
	}

	@RequestMapping("fit")
	public String fit(@RequestParam String playerId, Model model) {
		tplayersService.fit(playerId);
		model.addAttribute("players", tplayersService.getAllPlayers());
		model.addAttribute("fitplayers", tplayersService.getAllFitPlayers());
		return "TeamPlayers.jsp";
	}

}
