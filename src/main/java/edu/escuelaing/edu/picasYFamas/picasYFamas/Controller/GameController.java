package edu.escuelaing.edu.picasYFamas.picasYFamas.Controller;

import edu.escuelaing.edu.picasYFamas.picasYFamas.model.GameModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {
     int famas;
     List<String> valores = new ArrayList<>();
     int picas;
     String numberTry;
     int randomNum;
     GameModel gameRules = new GameModel();
        public GameController(){

            picas = 0;
            famas = 0;
            numberTry = null;
            randomNum =(int) (1000*Math.random());

        }
    @RequestMapping(
                value = "/play",
                method = RequestMethod.POST,
                params = {"reset"}
            )
    public String restart() {
        gameRules.restart();
        return "redirect:/play";
    }

    @GetMapping("/play")
    public String getInfo(Model model) {
        model.addAttribute("random",gameRules.getRandomNum());
        model.addAttribute("valores",gameRules.getIntentos());
        model.addAttribute("picas",gameRules.getPicas());
        model.addAttribute("famas",gameRules.getFamas());

        return "play";
    }
    @PostMapping("/play")
    public String play(String number) {
        valores.add(number);
        this.numberTry = number;
        this.picas = gameRules.getPicas();
        this.famas = gameRules.getFamas();
        this.valores = gameRules.getIntentos();
        gameRules.picasFamas(numberTry);
        return "redirect:/play";
    }


}
