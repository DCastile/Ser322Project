package ser322.gui;

import ser322.backend.Coach;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Vector;

public class CoachTableModel extends AbstractTableModel {

    private Vector<String> columnNames = new Vector<>();
    private Vector<Vector<String>> data;

    CoachTableModel(ArrayList<Coach> rows) {
        super();

        System.out.println("Coach!");

        columnNames.add("Team");
        columnNames.add("Name");
        columnNames.add("Title");
        columnNames.add("Home Town");

        data = new Vector<Vector<String>>();
        for (Coach coach : rows) {
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
