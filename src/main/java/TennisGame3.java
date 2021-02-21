
public class TennisGame3 implements TennisGame {

    private int playerOnePoints;
    private int playerTwoPoints;
    private String playerOneName;
    private String playerTwoName;
    private String[] points = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    private String score;

    public TennisGame3(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getScore() {
        if (this.isDraw()) {
            return this.getDraws();
        } else {
            if (this.isDeuce())
                return "Deuce";
            return this.getAdvantageWinner();
        }
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.playerOnePoints += 1;
        else
            this.playerTwoPoints += 1;
    }

    private String getName(){
        return this.score = this.playerOnePoints > this.playerTwoPoints ? this.playerOneName : this.playerTwoName;
    }

    private String getAdvantageWinner(){
        this.getName();
        return ((this.playerOnePoints-this.playerTwoPoints)*(this.playerOnePoints-this.playerTwoPoints) == 1) ? "Advantage " + this.score : "Win for " + this.score;
    }

    private boolean isDeuce(){
        return this.playerOnePoints == this.playerTwoPoints;
    }

    private String getDraws(){
        this.score = this.points[playerOnePoints];
        return (this.playerOnePoints == this.playerTwoPoints) ? this.score + "-All" : this.score + "-" + this.points[playerTwoPoints];
    }

    private boolean isDraw(){
        return this.playerOnePoints < 4 && this.playerTwoPoints < 4 && !(this.playerOnePoints + this.playerTwoPoints == 6);
    }

}
