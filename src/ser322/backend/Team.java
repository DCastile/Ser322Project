package ser322.backend;

public class Team {
    private Integer teamID;

    private String  shortName;
    private String  longName;
    private Integer wins;
    private Integer losses;
    private Integer championships;
    private Location  location;

    public Team(Integer teamID, String shortName) {
        this.teamID = teamID;
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return getShortName() + " - " + getWins() + "-" + getLosses();
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

    public void setLongName(String longName) {
        this.longName = longName;
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

    public String getLocation() {
        return location.getCity() + ", " + location.getState() + ", " + location.getCountry();
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
