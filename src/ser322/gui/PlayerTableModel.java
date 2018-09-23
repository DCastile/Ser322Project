package ser322.gui;

import ser322.backend.Coach;
import ser322.backend.Player;
import ser322.backend.Team;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Vector;

public class PlayerTableModel extends AbstractTableModel {

    private Vector<String> columnNames = new Vector<>();
    private Vector<Vector<String>> data;

    PlayerTableModel(ArrayList<Player> rows) {
        super();

        System.out.println("Player!");

        columnNames.add("Team");
        columnNames.add("Name");
        columnNames.add("Number");
        columnNames.add("Height");
        columnNames.add("Weight");
        columnNames.add("Position");
        columnNames.add("Academic Year");
        columnNames.add("Home Town");

        data = new Vector<Vector<String>>();
        for (Player player : rows) {
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
