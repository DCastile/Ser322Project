package ser322;

public class Location {
    private Integer locationID;
    private String city;
    private String state;
    private String country;

    public Location(Integer locationID, String city, String state, String country) {
        this.locationID = locationID;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String toString() {
        return this.city + ", " + this.state + ", " + this.country;
    }

    public Integer getLocationID() {
        return locationID;
    }


    public String getCity() {
        return city;
    }


    public String getState() {
        return state;
    }


    public String getCountry() {
        return country;
    }

}
