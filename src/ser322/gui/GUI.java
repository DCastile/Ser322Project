package ser322.gui;


import ser322.backend.Query;

import javax.swing.*;
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
    private RosterTableModel tableModel;

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

        switch (e.getActionCommand()) {
            case "all_teams": {
                tableModel.setDataFromTeams(query.getTeams());
                break;
            }
            case "teams_by_state": {
                tableModel.setDataFromTeams(query.getTeamByState("GA"));
                break;
            }
            case "coaches_by_team": {
                tableModel.setDataFromCoaches(query.getCoachesByTeam(1));
                break;
            }
            case "players_by_team": {
                tableModel.setDataFromPlayers(query.getPlayersByTeam(1));
                break;
            }
            case "players_by_state": {
                tableModel.setDataFromPlayers(query.getPlayersByState("GA"));
                break;
            }
        }
        tableModel.fireTableDataChanged();

    }


    private void initTable() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 2;
        c.gridwidth = 5;

        Query query = new Query();

//        table = new JTable(new TeamTableModel(query.getTeams()));
        tableModel = new RosterTableModel();
        tableModel.setDataFromTeams(query.getTeams());
        table = new JTable(tableModel);



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

