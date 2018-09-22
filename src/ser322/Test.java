package ser322;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Query query = new Query();

        ArrayList<Player> players = query.getPlayers(1);

        for (Player player : players) {
            System.out.println(player);
        }

        query.close();

    }

}
