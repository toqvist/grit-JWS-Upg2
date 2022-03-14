package com.example.stensaxpase;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
public class RPSController {

    //@RequestMapping(value = "/", method = RequestMethod.GET)
    

    //localhost:8080/
    //curl -X POST -F 'choice=rock' localhost:8080/
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String play(String choice) {
        
        String gameResult = RockPaperScissors.play(choice);
        return gameResult;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String play() {
        String gameState = GameBean.getGameState();
        return gameState;
    }
}
