package ser322.gui;


import ser322.backend.Query;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class GUI extends JPanel implements ActionListener {
    private boolean DEBUG = false;


    private JButton allTeamsButton;
    private JButton teamsByStateButton;
    private JButton coachesByTeamButton;
    private JButton playersByTeamButton;
    private JButton playersByStateButton;


    private JScrollPane scrollPane;
    private JTable table;
    private AbstractTableModel tableModel;

    public GUI() {
        super(new GridBagLayout());

        registerButtons();

        initTable();


    }

    private void registerButtons() {
        GridBagConstraints c = new GridBagConstraints();

        allTeamsButton = new JButton("All teams");
        allTeamsButton.setActionCommand("all_teams");
        allTeamsButton.addActionListener(this);

        teamsByStateButton = new JButton("Query team by state");
        teamsByStateButton.setActionCommand("teams_by_state");
        teamsByStateButton.addActionListener(this);


        coachesByTeamButton = new JButton("Coaches by team");
        coachesByTeamButton.setActionCommand("coaches_by_team");
        coachesByTeamButton.addActionListener(this);

        playersByTeamButton = new JButton("Players by team");
        playersByTeamButton.setActionCommand("players_by_team");
        playersByTeamButton.addActionListener(this);

        playersByStateButton = new JButton("Players by state");
        playersByStateButton.setActionCommand("players_by_state");
        playersByStateButton.addActionListener(this);


        add(allTeamsButton, c);
        add(teamsByStateButton, c);
        add(coachesByTeamButton, c);
        add(playersByTeamButton, c);
        add(playersByStateButton, c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        Query query = new Query();

        String queryParameter;
        switch (e.getActionCommand()) {
            case "all_teams": {
                tableModel = new TeamTableModel(query.getTeams());
                break;
            }
            case "teams_by_state": {
                queryParameter = getInputFromDiaglogBox("Enter state");
                tableModel = new TeamTableModel(query.getTeamByState(queryParameter));
                break;
            }
            case "coaches_by_team": {
                queryParameter = getInputFromDiaglogBox("Enter team id");
                tableModel = new CoachTableModel(query.getCoachesByTeam(Integer.parseInt(queryParameter)));
                break;
            }
            case "players_by_team": {
                queryParameter = getInputFromDiaglogBox("Enter team id");
                tableModel = new PlayerTableModel(query.getPlayersByTeam(Integer.parseInt(queryParameter)));
                break;
            }
            case "players_by_state": {
                queryParameter = getInputFromDiaglogBox("Enter state");
                tableModel = new PlayerTableModel(query.getPlayersByState(queryParameter));
                break;
            }
        }

        table.setModel(tableModel);
    }

    private String getInputFromDiaglogBox(String message) {
        return (String)JOptionPane.showInputDialog(
                this,
                message,
                "Enter parameter for query",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "type here...");
    }


    private void initTable() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 2;
        c.gridwidth = 5;

        Query query = new Query();

        tableModel = new TeamTableModel(query.getTeams());
        table = new JTable(tableModel);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


        table.setPreferredScrollableViewportSize(new Dimension(1000, 300));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane, c);

        query.close();
    }


    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Roster");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        GUI newContentPane = new GUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}

