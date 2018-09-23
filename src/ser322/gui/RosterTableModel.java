package ser322.gui;

import ser322.backend.Coach;
import ser322.backend.Player;
import ser322.backend.Team;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Vector;

public class RosterTableModel extends AbstractTableModel {

    private Vector<String> columnNames;
    private Vector<Vector<String>> data;


    RosterTableModel() {
        super();
    }


    public void setDataFromTeams(ArrayList<Team> teams) {
        columnNames = new Vector<>();
        columnNames.add("Short Name");
        columnNames.add("Name");
        columnNames.add("Wins");
        columnNames.add("Losses");
        columnNames.add("Championships");
        columnNames.add("Location");

        data = new Vector<Vector<String>>();
        for (Team team : teams) {
            Vector<String> row = new Vector<>();
            row.add(team.getShortName());
            row.add(team.getLongName());
            row.add(String.valueOf(team.getWins()));
            row.add(String.valueOf(team.getLosses()));
            row.add(String.valueOf(team.getChampionships()));
            row.add(team.getLocation());

            data.add(row);
        }
    }

    public void setDataFromPlayers(ArrayList<Player> players) {
        columnNames.add("Team");
        columnNames.add("Name");
        columnNames.add("Number");
        columnNames.add("Height");
        columnNames.add("Weight");
        columnNames.add("Position");
        columnNames.add("Academic Year");
        columnNames.add("Home Town");

        data = new Vector<Vector<String>>();
        for (Player player : players) {
            Vector<String> row = new Vector<>();
            row.add(player.getTeam());
            row.add(player.getName());
            row.add(String.valueOf(player.getNumber()));
            row.add(player.getHeight());
            row.add(String.valueOf(player.getWeightPounds()));
            row.add(player.getPosition());
            row.add(player.getAcademicYear());
            row.add(player.getHomeTown());

            data.add(row);
        }
    }

    public void setDataFromCoaches(ArrayList<Coach> coaches) {
        columnNames.add("Team");
        columnNames.add("Name");
        columnNames.add("Title");
        columnNames.add("Home Town");

        data = new Vector<Vector<String>>();
        for (Coach coach : coaches) {
            Vector<String> row = new Vector<>();
            row.add(coach.getTeam());
            row.add(coach.getName());
            row.add(coach.getTitle());
            row.add(coach.getHomeTown());

            data.add(row);
        }
    }

    public String getColumnName(int col) {
        return columnNames.get(col);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }

}
