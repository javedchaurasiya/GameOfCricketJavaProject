public class PlayerScoreCard {
    private Player player;
    private int runsScored=0;
    private int bowlsPlayed=0;
    private Player wicketTaker;
    private int wicketsTaken=0;

    private int bowlsBowled=0;

    public PlayerScoreCard(Player player){
        this.player=player;
    }
    public void setWicketsTaken(){
        wicketsTaken++;
        bowlsBowled++;
    }
    public void setWicketTaker(Player wicketTaker){
        this.wicketTaker=wicketTaker;
    }

    public Player getWicketTaker(){
        return wicketTaker;
    }
    public void setRunsScored(int runs) {
        this.runsScored += runs;
    }

    public int getRunsScored(){
        return runsScored;
    }

    public int getBowlsPlayed(){
        return bowlsPlayed;
    }

    public void setBowlsPlayed(){
        this.bowlsPlayed++;
    }
    public void setBowlsBowled(){
        this.bowlsBowled++;
    }

    public int getBowlsBowled(){
        return this.bowlsBowled;
    }
    public Player getPlayer(){
        return player;
    }
}
