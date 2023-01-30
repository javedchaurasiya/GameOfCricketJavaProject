public abstract class Player {
    private String name;
    int age;
    int jerseyNumber=69;
    int totalMatchesPlayed=696;

    public Player(){
        this.name=RandomDataGenerator.getRandomName();
        this.age=RandomDataGenerator.getRandomInt(35,20);
    }
    public Player(String name,int age,int jerseyNumber,int totalMatchesPlayed){
        this.name=name;
        this.age=age;
        this.jerseyNumber=jerseyNumber;
        this.totalMatchesPlayed=totalMatchesPlayed;
    }

    public String getName(){
        return name;
    }
}
