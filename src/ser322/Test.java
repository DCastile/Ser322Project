package ser322;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        Query query = new Query();
        ArrayList<Object> objects;

        System.out.println("Printing all ASU Players:");
        printObjects(query.getPlayersByTeam(1));

        System.out.println("\n\n\n\n");
        System.out.println("Printing all players from California:");
        printObjects(query.getPlayersByState("CA"));


        System.out.println("\n\n\n\n");
        System.out.println("Printing all ASU Coaches:");
        printObjects(query.getCoachesByTeam(1));

        System.out.println("\n\n\n\n");
        System.out.println("Printing all Teams:");
        printObjects(query.getTeams());

        System.out.println("\n\n\n\n");
        System.out.println("Printing all Teams from AZ:");
        printObjects(query.getTeamByState("AZ"));


        query.close();

    }


    private static void printObjects(ArrayList<?> objs) {
        for (Object obj: objs) {
            System.out.println(obj);
        }
    }


}

