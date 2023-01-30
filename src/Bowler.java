public class Bowler extends Player{
    int totalWicketsTaken=0;

    public Bowler() {
        super();
    }
    public Bowler(String name,int age ,int jerseyNumber,int totalMatchesPlayed,int totalWicketsTaken){
        super(name,age,jerseyNumber,totalMatchesPlayed);
        this.totalWicketsTaken=totalWicketsTaken;
    }
    @Override
    public String toString(){
        return "Jersey Number "+ jerseyNumber + ", "+getName()+" has taken a total of "+ totalWicketsTaken + " wickets";
    }
}
