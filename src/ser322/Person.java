package ser322;

public class Person {
    private Integer personID;
    private String firstName;
    private String lastName;

    private Location homeTown;

    private Team team;

    public Person(Integer personID, String firstName, String lastName) {
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Integer getPersonID() {
        return personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public Location getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(Location homeTown) {
        this.homeTown = homeTown;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
