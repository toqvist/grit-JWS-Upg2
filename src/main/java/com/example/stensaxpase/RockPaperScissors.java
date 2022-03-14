package com.example.stensaxpase;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class RockPaperScissors {

    //localhost:8080/
    //curl -X POST -F 'choice=rock' localhost:8080/
    //@RequestMapping(path = "/", method = RequestMethod.POST)
    public static String play(String choice) {

        String result = "";
        
        String playerChoice = choice;
        String opponentChoice = generateOpponentChoice();

        if (playerChoice.equals(opponentChoice)) {
            
            result = "Draw!";
        
        } else if ((playerChoice.equals("rock") && opponentChoice.equals("paper") ) ||
                (playerChoice.equals("scissors") && opponentChoice.equals("rock") ) ||
                (playerChoice.equals("paper") && opponentChoice.equals("scissors") ) ) {

            result = "Player lost!";
            System.out.println("player lost");

        } else {
            result = "Player won!";
            System.out.println("player won");
        }

        switch(result) {
        case "Player won!":
            GameBean.addWin();
            break;
        case "Player lost!":
            GameBean.addLoss();
            break;
        case "Draw!":
            break;
        }
        GameBean.addGameRound();
        String gameState = "Player chose " + playerChoice + "   AI chose " + opponentChoice + "   " + result + "   Wins:" + GameBean.getWins() + "   Losses: " + GameBean.getLosses();
        return gameState;
    }

    private static String generateOpponentChoice() {

        Random random = new Random();
        int randomNumber = random.nextInt(3);
        System.out.println(randomNumber);

        String returnString = "";

        switch (randomNumber) {
            case 0:
                returnString = "rock";
                break;
            case 1:
                returnString = "paper";
                break;
            case 2:
                returnString = "scissors";
                break;
        }
        return returnString;
    }
}
