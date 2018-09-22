package ser322;

import java.sql.*;
import java.util.ArrayList;

public class Query {

    private Connection conn;

    public Query() {
        try {
            String db_url = "jdbc:sqlite:roster.sqlite";
            conn = DriverManager.getConnection(db_url);
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }


    public ArrayList<Player> getPlayers(Integer teamID) {
        ArrayList<Player> players = new ArrayList<>();

        String qry = "select\n" +
                "\tpers.PersonID,\n" +
                "\tFirstName,\n" +
                "\tLastName,\n" +
                "\tNumber,\n" +
                "\tHeightInches,\n" +
                "\tWeightPounds,\n" +
                "\tPosition,\n" +
                "\tAcademicYear,\n" +
                "\tHighSchool,\n" +
                "\n" +
                "\tpers.HomeTownID,\n" +
                "\tloc.City HomeCity,\n" +
                "\tloc.State HomeState,\n" +
                "\tloc.Country HomeCountry\n" +
                "from Player play\n" +
                "     left join Person pers\n" +
                "\t     on play.PersonID = pers.PersonID\n" +
                "\tleft join Location loc\n" +
                "\t\t on pers.HomeTownID = loc.LocationID\n" +
                "\tleft join Team team\n" +
                "\t\t on pers.TeamID = team.TeamID\n" +
                "where pers.TeamID = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(qry);
            stmt.setInt(1, teamID);
            ResultSet rs = stmt.executeQuery();

            Player player;
            Location loc;
            while (rs.next()) {
                player = new Player(rs.getInt("PersonID"), rs.getString("FirstName"), rs.getString("LastName"));
                player.setNumber(rs.getInt("Number"));
                player.setHeightInches(rs.getInt("HeightInches"));
                player.setWeightPounds(rs.getInt("WeightPounds"));
                player.setPosition(rs.getString("Position"));
                player.setAcademicYear(rs.getString("AcademicYear"));
                player.setHighSchool(rs.getString("HighSchool"));

                loc = new Location(rs.getInt("HomeTownID"), rs.getString("HomeCity"), rs.getString("HomeState"), rs.getString("HomeCountry"));

                player.setHomeTown(loc);

                players.add(player);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return players;
    }
}
