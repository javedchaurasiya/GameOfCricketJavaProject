public class Cricket {
    private Scoreboard scoreboard;

    public Cricket(String teamA, String teamB) {
        this.scoreboard = new Scoreboard(new Team(teamA), new Team(teamB));
    }

    public void toss() {
        //can do better with the code.
        int randomNum = RandomDataGenerator.getRandomInt(1, 2);
        if (randomNum == 2) scoreboard.swapTeams();
        Team battingTeam = scoreboard.getBattingTeam().getTeam();
        System.out.println("Team " + battingTeam.getName() + " has won the toss and has decided to bat first!");
    }

    //util function to update the scoreboard
    public void setScoreboard(int runs) {
        scoreboard.updateScoreBoardUtility(runs);
    }

    public void play() {
        System.out.println("Starting the match, prepare for the toss");
        toss();
        while (!scoreboard.isMatchOver()) {
            int runs = RandomDataGenerator.getRandomRun();
            setScoreboard(runs);
        }
    }
    public void printResults(){
        //print the Scoreboard of 1st innings--> then 2nd innings->>> then the overall result.
        //the current bowling team is the one who batted first.
        scoreboard.printOverallScoreboardUtil();
    }

}
