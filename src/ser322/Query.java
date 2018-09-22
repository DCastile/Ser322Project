package ser322;

import java.sql.*;
import java.util.ArrayList;

public class Query {

    private Connection conn;

    public Query() {
        try {
            String db_url = "jdbc:sqlite:roster.db";
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


    private Player createPlayer(ResultSet rs){
        Player player;
        Location loc;
        try {
            player = new Player(rs.getInt("PersonID"), rs.getString("FirstName"), rs.getString("LastName"));
            player.setNumber(rs.getInt("Number"));
            player.setHeightInches(rs.getInt("HeightInches"));
            player.setWeightPounds(rs.getInt("WeightPounds"));
            player.setPosition(rs.getString("Position"));
            player.setAcademicYear(rs.getString("AcademicYear"));
            player.setHighSchool(rs.getString("HighSchool"));

            loc = new Location(rs.getInt("HomeTownID"), rs.getString("HomeCity"), rs.getString("HomeState"), rs.getString("HomeCountry"));

            player.setHomeTown(loc);

            return player;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    public ArrayList<Player> getPlayersByTeam(Integer teamID) {
        ArrayList<Player> players = new ArrayList<>();

        String qry = "select * from v_player where TeamID = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(qry);
            stmt.setInt(1, teamID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                players.add(createPlayer(rs));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return players;
    }

    public ArrayList<Player> getPlayersByState(String state) {
        ArrayList<Player> players = new ArrayList<>();

        String qry = "select * from v_player where HomeState = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(qry);
            stmt.setString(1, state);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                players.add(createPlayer(rs));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return players;
    }
}
