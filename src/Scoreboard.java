public class Scoreboard {
    private int totalBalls = 24;
    private int target = 0;
    private boolean chasing = false;
    private int batsmanIndex;
    private int bowlerIndex;

    private TeamScoreCard battingTeam;
    private TeamScoreCard bowlingTeam;

    public Scoreboard(Team battingTeam, Team bowlingTeam) {
        this.battingTeam = new TeamScoreCard(battingTeam);
        this.bowlingTeam = new TeamScoreCard(bowlingTeam);
        this.batsmanIndex = 0;
        this.bowlerIndex = RandomDataGenerator.getRandomInt(6, 10);
    }

    private int getNoOfBalls() {
        return battingTeam.getBallsPlayed();
    }

    private void setNoOfBalls() {
        battingTeam.setBallsPlayed();
        battingTeam.getTeam().getPlayers()[batsmanIndex].setBowlsPlayed();
        //update the bowler stats
        bowlingTeam.getTeam().getPlayers()[bowlerIndex].setBowlsBowled();
        //change if the current bowler bowled 6 deliveries
        if (battingTeam.getBallsPlayed() % 6 == 0) setBowler(bowlingTeam.getTeam().getPlayers()[bowlerIndex].getPlayer());
        //if innings ended
        if (isInningsOver()) {
            //if it's the end of 1st innings
            if (!chasing) switchSides();
                // it's the end of the match
//            else System.out.println("Match is over");
        }
    }

    private int getCurrentRuns() {
        return battingTeam.getRunsScored();
    }

    public void setCurrentRuns(int runs) {
        battingTeam.setRunsScored(runs);
        //update the scorecard of the batter
        battingTeam.getTeam().getPlayers()[batsmanIndex].setRunsScored(runs);
    }

    public int getWickets() {
        return battingTeam.getWicketsFallen();
    }

    private void setWickets() {
        battingTeam.setWicketsFallen();
        //updating the bowler scorecard
        bowlingTeam.getTeam().getPlayers()[bowlerIndex].setWicketsTaken();
        //updating the batter scorecard, and bringing in the new batter.
        battingTeam.getTeam().getPlayers()[batsmanIndex].setWicketTaker(bowlingTeam.getTeam().getPlayers()[bowlerIndex].getPlayer());
        setBatsman();
    }

    private int getTarget() {
        return target;
    }

    private void setTarget(int target) {
        this.target = target;
    }

    private boolean isChasing() {
        return chasing;
    }

    private void setChasing(boolean chasing) {
        this.chasing = chasing;
    }

    private void setBatsman() {
        //bring the new batter to the crease, if possible.
        if (isInningsOver()) return;
        this.batsmanIndex++;
    }

    private Player getBatsman() {
        return battingTeam.getTeam().getPlayers()[batsmanIndex].getPlayer();
    }

    private Player getBowler() {
        return bowlingTeam.getTeam().getPlayers()[bowlerIndex].getPlayer();
    }

    private void setBowler(Player bowler) {
        int newBowler = RandomDataGenerator.getRandomInt(6, 10);
        //just to make sure the next bowler is different from the last bowler.
        while (newBowler == this.bowlerIndex) newBowler = RandomDataGenerator.getRandomInt(6, 10);
        this.bowlerIndex = newBowler;
    }

    private void printTeamScoreboard(TeamScoreCard team) {
        //will do later
        System.out.println("Team : " + team.getTeam().getName());
        System.out.println(team.getRunsScored() + " / " + team.getWicketsFallen() + " " + team.getBallsPlayed() + " balls");
    }

    private String printPlayerScorecard(PlayerScoreCard scorecard) {
        String wicketTakerInfo = scorecard.getWicketTaker() != null ? " W " + scorecard.getWicketTaker().getName() : "";
        return scorecard.getPlayer().getName() + " " + scorecard.getRunsScored() + " in " + scorecard.getBowlsPlayed() + " balls" + wicketTakerInfo;
    }

    private void printPlayerScorecardUtil(Team team) {
        for (PlayerScoreCard scorecard : team.getPlayers()) {
            System.out.println(printPlayerScorecard(scorecard));
        }
    }

    public void swapTeams() {
        TeamScoreCard temp = this.battingTeam;
        this.battingTeam = bowlingTeam;
        this.bowlingTeam = temp;
    }

    private void switchSides() {
        //set the target and reset every other things
        this.target = battingTeam.getRunsScored();
        this.batsmanIndex = 0;
        this.bowlerIndex = RandomDataGenerator.getRandomInt(6, 10);
        this.chasing = true;
        //swapping the bowling and batting teams
        swapTeams();
    }

    private boolean isInningsOver() {
        return battingTeam.getWicketsFallen() == 11 || battingTeam.getBallsPlayed() == totalBalls;
    }

    public boolean isMatchOver() {
        return chasing && isInningsOver();
    }

    public TeamScoreCard getBattingTeam() {
        return battingTeam;
    }

    //util function to update scoreboard
    public void updateScoreBoardUtility(int runs) {
        //updating the bowls bowled info first.
        setNoOfBalls();
        //wicket's taken
        if (runs == -1) {
            setWickets();
        } else {
            setCurrentRuns(runs);
        }
    }

    private void printOverallScoreboard(TeamScoreCard team){
        printTeamScoreboard(team);
        printPlayerScorecardUtil(team.getTeam());
    }
    private void printResult(){
        System.out.println("Printing Result here!!");

        if(battingTeam.getRunsScored()>target){
            System.out.println("Team : "+battingTeam.getTeam().getName()+" has won the game by "+(11-battingTeam.getWicketsFallen())+" wickets");
        }
        else if(battingTeam.getRunsScored()<target){
            System.out.println("Team : "+bowlingTeam.getTeam().getName()+" has won the game by "+(target-battingTeam.getRunsScored())+" runs");
        }
        else{
            System.out.println("Match has ended in a tie");
        }
    }
    public void printOverallScoreboardUtil(){
        printOverallScoreboard(bowlingTeam);
        printOverallScoreboard(battingTeam);
        printResult();
    }
}
