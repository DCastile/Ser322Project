package ser322.backend;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        Team team;
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

            team = new Team(rs.getInt("TeamID"), rs.getString("Team"));
            player.setTeam(team);

            return player;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    public String[] getDistinctTeams() {
        ArrayList<String> teams = new ArrayList<>();

        String qry = "select distinct ShortName from v_team order by ShortName";
        try {
            ResultSet rs = conn.createStatement().executeQuery(qry);
            while (rs.next()) {
                teams.add(rs.getString("ShortName"));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return teams.toArray(new String[0]);
    }

    public String[] getDistinctStates(String type) {
        ArrayList<String> states = new ArrayList<>();
        String qry;
        switch (type) {
            case "team": {
                qry = "select distinct State from Location where LocationID in (select LocationID from Team) order by State";
                break;
            }
            case "player": {
                qry = "select distinct State from Location where LocationID in (select LocationID from Person) order by State";
                break;
            }
            default: qry = "select distinct State from Location order by State";
        }

        try {
            ResultSet rs = conn.createStatement().executeQuery(qry);
            while (rs.next()) {
                states.add(rs.getString("State"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return  states.toArray(new String[0]);
    }


    public ArrayList<Player> getPlayersByTeam(String teamShortName) {
        ArrayList<Player> players = new ArrayList<>();

        String qry = "select * from v_player where Team = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(qry);
            stmt.setString(1, teamShortName);
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



    private Coach createCoach(ResultSet rs) {
        Coach coach;
        Location loc;
        Team team;
        try {
            coach = new Coach(rs.getInt("PersonID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Title"));
            loc = new Location(rs.getInt("HomeTownID"), rs.getString("HomeCity"), rs.getString("HomeState"), rs.getString("HomeCountry"));
            coach.setHomeTown(loc);

            team = new Team(rs.getInt("TeamID"), rs.getString("Team"));
            coach.setTeam(team);

            return coach;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    public ArrayList<Coach> getCoachesByTeam(String teamShortName) {
        ArrayList<Coach> coaches = new ArrayList<>();

        String qry = "select * from v_coach where Team = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(qry);
            stmt.setString(1, teamShortName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                coaches.add(createCoach(rs));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return coaches;
    }



    private Team createTeam(ResultSet rs) {
        Team team;
        Location loc;
        try {
            team = new Team(rs.getInt("TeamID"), rs.getString("ShortName"));
            team.setLongName(rs.getString("Name"));
            team.setWins(rs.getInt("Wins"));
            team.setLosses(rs.getInt("Losses"));
            team.setChampionships(rs.getInt("Championships"));

            loc = new Location(rs.getInt("LocationID"), rs.getString("City"), rs.getString("State"), rs.getString("Country"));
            team.setLocation(loc);

            return team;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }
    public ArrayList<Team> getTeams() {
        ArrayList<Team> team = new ArrayList<>();

        String qry = "select * from v_team";
        try {
            PreparedStatement stmt = conn.prepareStatement(qry);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                team.add(createTeam(rs));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return team;
    }

    public ArrayList<Team> getTeamByState(String state) {
        ArrayList<Team> team = new ArrayList<>();

        String qry = "select * from v_team where State = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(qry);
            stmt.setString(1, state);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                team.add(createTeam(rs));
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return team;
    }
}
