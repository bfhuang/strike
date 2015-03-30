package controller;

import model.PersonWithStrike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.StrikeService;

import java.util.List;

@RequestMapping("/")
@Controller
public class StrikeController {
    @Autowired
    private StrikeService strikeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String show(ModelMap model) {
        List<PersonWithStrike> allPersonWithStrike = strikeService.getAllPersonWithStrike();
        model.put("persons", allPersonWithStrike);
        return "personWithStrike";
    }

    @RequestMapping(value = "/strike", method = RequestMethod.POST)
    public String strike(@RequestParam("personId") int personId) {
        strikeService.strike(personId);
        return "redirect:/";
    }

    @RequestMapping(value = "/punish", method = RequestMethod.POST)
    public String punish(@RequestParam("personId") int personId) {
        strikeService.punish(personId);
        return "redirect:/";
    }
}
