public class Batsman extends Player {

    int totalRunsScored=69699;

    public Batsman(){
        super();
    }
    public Batsman(String name,int age ,int jerseyNumber,int totalMatchesPlayed, int totalRunsScored){
        super(name,age,jerseyNumber,totalMatchesPlayed);
        this.totalRunsScored=totalRunsScored;
    }
    @Override
    public String toString(){
        String s="Jersey Number "+ jerseyNumber + ", "+getName()+" has scored a total of "+ totalRunsScored + " runs";
//        System.out.println("Jersey Number "+ jerseyNumber + ", "+name+"has scored a total of "+ totalRunsScored + "runs");
        return s;
    }
}
