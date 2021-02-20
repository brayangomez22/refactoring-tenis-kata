
public class TennisGame1 implements TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerTwoName;
    private String playerOneName;

    public TennisGame1(String playerTwoName, String playerOneName) {
        this.playerTwoName = playerTwoName;
        this.playerOneName = playerOneName;
    }

    public void wonPoint(String playerName) {
        int i = (playerName == playerOneName) ?(playerOneScore += 1) : (playerTwoScore += 1);
    }

    public String getScore() {
        String score = "";

        if (playerOneScore==playerTwoScore)
        {
            switch (playerOneScore)
            {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        }
        else if (playerOneScore>=4 || playerTwoScore>=4)
        {
            int minusResult = playerOneScore-playerTwoScore;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            int tempScore = 0;

            for (int i=1; i<3; i++) {
                if (i == 1) {
                    tempScore = playerOneScore;
                } else {
                    score+="-";
                    tempScore = playerTwoScore;
                }
                score = computeScore(score, tempScore);
            }
        }
        return score;
    }

    private String computeScore(String score, int points) {
        switch(points)
        {
            case 0:
                score+="Love";
                break;
            case 1:
                score+="Fifteen";
                break;
            case 2:
                score+="Thirty";
                break;
            case 3:
                score+="Forty";
                break;
        }
        return score;
    }
}