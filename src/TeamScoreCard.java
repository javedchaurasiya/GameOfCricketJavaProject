public class TeamScoreCard {
    private Team team;
    private int ballsPlayed=0;
    private int wicketsFallen=0;
    private int runsScored=0;

    public TeamScoreCard(Team team){
        this.team=team;
    }

    public int getBallsPlayed() {
        return ballsPlayed;
    }

    public void setBallsPlayed() {
        this.ballsPlayed++;
    }

    public Team getTeam() {
        return team;
    }

    public int getWicketsFallen() {
        return wicketsFallen;
    }

    public void setWicketsFallen() {
        this.wicketsFallen++;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runs) {
        this.runsScored+=runs;
    }
}
