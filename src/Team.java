public class Team {
    private String name;
    private PlayerScoreCard players[];

    public Team(String name){
        this.name=name;
        players=new PlayerScoreCard[11];
        for(int i=0;i<11;i++)
        {
            //considering 6 batsmen and 5 bowlers
            Player player=i<6?new Batsman():new Bowler();
            players[i]=new PlayerScoreCard(player);
        }
    }
    public PlayerScoreCard[] getPlayers(){
        return players;
    }
    public String getName(){
        return this.name;
    }
}
