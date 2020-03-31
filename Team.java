package soccer;

public class Team implements Comparable {

    private String teamName;
    private Player[] playerArray;
    private int pointsTotal;
    private int goalsTotal;

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, Player[] players) {
        this(teamName);
        this.playerArray = players;
    }

    public Team() {
    }

    public int compareTo(Object theTeam) {
        int returnValue = -1;
        if (this.getPointsTotal() < ((Team)theTeam).getPointsTotal()) {
            returnValue = 1;
        }

        return returnValue;
    }

    public void incGoalsTotal(int goals) {
        this.goalsTotal = this.goalsTotal + goals;
    }


    public void incPointsTotal(int pointsTotal) {
        this.pointsTotal += pointsTotal;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Player[] getPlayerArray() {
        return playerArray;
    }

    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
    }

    public int getPointsTotal() {
        return pointsTotal;
    }

    public void setPointsTotal(int pointsTotal) {
        this.pointsTotal = pointsTotal;
    }
}