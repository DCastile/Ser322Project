package ser322.gui;

import ser322.backend.Team;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Vector;

public class TeamTableModel extends AbstractTableModel {

    private Vector<String> columnNames = new Vector<>();
    private Vector<Vector<String>> data;

    TeamTableModel(ArrayList<Team> rows) {
        super();

        System.out.println("Team!");

        columnNames.add("Short Name");
        columnNames.add("Name");
        columnNames.add("Wins");
        columnNames.add("Losses");
        columnNames.add("Championships");
        columnNames.add("Location");

        data = new Vector<Vector<String>>();
        for (Team team : rows) {
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
