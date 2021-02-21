
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
        if (playerName == "player1")
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    public String getScore() {
        String score = "";

        if (playerOneScore==playerTwoScore)
        {
            return getPointsAll(playerOneScore);
        }
        else if (playerOneScore>=4 || playerTwoScore>=4)
        {
            int minusResult = playerOneScore-playerTwoScore;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else {
            return Score.nameFromPoints(playerOneScore) + "-" + Score.nameFromPoints(playerTwoScore);
        }
        return score;
    }

    private String getPointsAll(int playerOneScore) {
        switch (playerOneScore)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private String getScoreByPoints(int points) {
        return Score.nameFromPoints(points);
    }

    enum Score {
        Love, Fifteen, Thirty, Forty;

        public static String nameFromPoints(int points) {
            return values()[points].name();
        }
    }
}