package com.example.stensaxpase;

public class GameBean {
    private static int wins = 0;
    private static int losses = 0;
    private static int gameRounds = 0;

    // public ScoreBean () {
    //     this.wins = 0;
    //     this.losses = 0;
    // }

    public static void addWin() {
        wins++;
    }

    public static void addLoss () {
        losses++;
    }

    public static int getWins () {
        return wins;
    }

    public static int getLosses () {
        return losses;
    }

    public static void addGameRound () {
        gameRounds++;
    }

    public static String getGameState () {
        

        // String pattern = "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
		// return String.format(pattern, ScoreBean.WINS, ScoreBean.LOSSES, ScoreBean.TIES);
        
        //String returnJSON = "{ \"wins\":\"wins\", \"losses\":\"losses\", \"rounds\": \"gameRounds\"}";
        String returnJSON = "{\"wins\":\"" + wins + "\"}";
        System.out.println(returnJSON);
        return returnJSON;
    }
}
