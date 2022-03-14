package com.example.stensaxpase;

import java.util.Random;


public class RockPaperScissors {

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
            GameBean.addTie();
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
