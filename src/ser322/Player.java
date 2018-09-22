package ser322;

public class Player extends Person {

    private Integer number;
    private Integer  heightInches;

    @Override
    public String toString() {
        return getLastName() + ", " + getFirstName() + " - #" + getNumber() + " - @" + getBuild();
    }

    private Integer weightPounds;
    private String  position;
    private String  academicYear;
    private String  highSchool;

    public Player(Integer personID, String firstName, String lastName) {
        super(personID, firstName, lastName);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHeight() {
        return Integer.toString(heightInches / 12) + "' " + Integer.toString(heightInches % 12) + '"';
    }

    public String getBuild() {
        return getHeight() + " & " + getWeightPounds() + "lbs";
    }

    public Integer getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(Integer heightInches) {
        this.heightInches = heightInches;
    }

    public Integer getWeightPounds() {
        return weightPounds;
    }

    public void setWeightPounds(Integer weightPounds) {
        this.weightPounds = weightPounds;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }
}
