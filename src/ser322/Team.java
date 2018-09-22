package ser322;

public class Team {
    private Integer teamID;

    private String  shortName;
    private String  longName;
    private Integer wins;
    private Integer losses;
    private Integer championships;
    private Location  location;

    public Team(Integer teamID, String shortName, String longName) {
        this.teamID = teamID;
        this.shortName = shortName;
        this.longName = longName;
    }


    public Integer getTeamID() {
        return teamID;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Integer getChampionships() {
        return championships;
    }

    public void setChampionships(Integer championships) {
        this.championships = championships;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
