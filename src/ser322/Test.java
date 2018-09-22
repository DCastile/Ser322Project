package ser322;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Query query = new Query();

//        ArrayList<Player> players = query.getPlayersByTeam(1);
        ArrayList<Player> players = query.getPlayersByState("CA");

        for (Player player : players) {
            System.out.println(player);
        }

        query.close();

    }

}

