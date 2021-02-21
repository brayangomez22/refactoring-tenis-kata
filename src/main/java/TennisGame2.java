import java.util.HashMap;
import java.util.Map;

public class TennisGame2 implements TennisGame {
    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;

    private String playerOneScore = "";
    private String playerTwoScore = "";
    private String playerOneName;
    private String playerTwoName;

    private static final Map<Integer, String> PUNTUACIONES = new HashMap<>();

    static{
        PUNTUACIONES.put(0, "Love");
        PUNTUACIONES.put(1, "Fifteen");
        PUNTUACIONES.put(2, "Thirty");
        PUNTUACIONES.put(3, "Forty");
    }

    public TennisGame2(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getScore(){

        if (this.isDraw()) {
            return this.getDraws();
        }

        if (this.isNotOverTime()) {
            return this.getPartialScore();
        }

        if(this.isOverTime()){
            return this.getAdvantage();
        }

        return this.getWinner();
    }

    public void wonPoint(String player) {
        if (player.equals(playerOneName))
            incrementPlayerOneScore();
        else
            incrementPlayerTwoScore();
    }

    private void incrementPlayerOneScore(){
        playerOnePoints++;
    }

    private void incrementPlayerTwoScore(){
        playerTwoPoints++;
    }

    private String getDraws(){
        return this.playerOnePoints < 3? getPlayerScore(playerOnePoints) + "-All": "Deuce";
    }

    private String getPlayerScore(int points){
        return PUNTUACIONES.get(points);
    }

    private String getPartialScore(){
        this.playerOneScore = this.getPlayerScore(this.playerOnePoints);
        this.playerTwoScore = this.getPlayerScore(this.playerTwoPoints);

        return this.playerOneScore + "-" + this.playerTwoScore;
    }

    private String getAdvantage(){
        return this.playerOnePoints > this.playerTwoPoints? "Advantage " + this.playerOneName: "Advantage " + this.playerTwoName;
    }

    private String getWinner(){
        return this.playerOnePoints > this.playerTwoPoints? "Win for " + this.playerOneName : "Win for " + this.playerTwoName;
    }

    private boolean isNotOverTime(){
        return (this.playerOnePoints <= 3 && this.playerTwoPoints <= 3);
    }

    private boolean isOverTime(){
        boolean minimumPointsCondition = this.playerOnePoints >= 3 || this.playerTwoPoints >=3;
        boolean pointDifferenceCondition = Math.abs(this.playerOnePoints - this.playerTwoPoints) == 1;

        return minimumPointsCondition && pointDifferenceCondition;
    }

    private boolean isDraw(){
        return this.playerOnePoints == this.playerTwoPoints;
    }
}