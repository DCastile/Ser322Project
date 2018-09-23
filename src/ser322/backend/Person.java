package ser322.backend;

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



    public String getName() {
        return firstName + " " + lastName;
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


    public String getHomeTown() {
        return homeTown.getCity() + ", " + homeTown.getState() + ", " + homeTown.getCountry();
    }

    public void setHomeTown(Location homeTown) {
        this.homeTown = homeTown;
    }

    public String getTeam() {
        return team.getShortName();
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
