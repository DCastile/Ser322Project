package ser322;

public class Coach extends Person {
    private String title;

    public Coach(Integer personID, String firstName, String lastName, String title) {
        super(personID, firstName, lastName);
        this.title = title;
    }

    @Override
    public String toString() {
        return getLastName() + ", " + getFirstName() + " - " + getTitle();
    }

    public String getTitle() {
        return title;
    }
}
