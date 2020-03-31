
package utility;


import soccer.Player;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class PlayerDatabase {

    public PlayerDatabase() {
        StringTokenizer authorTokens =
                new StringTokenizer(authorList, ",");

        players = new ArrayList();

        while (authorTokens.hasMoreTokens()) {
            players.add(new Player(authorTokens.nextToken()));
        }

    }

    public Player[] getTeam(int numberOfPlayers) throws PlayerDatabaseException {

        Player[] teamPlayers = new Player[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {

            int playerIndex = (int) (Math.random() * players.size());
            try {
                teamPlayers[i] = players.get(playerIndex);
                players.remove(playerIndex);
            }
            catch (IndexOutOfBoundsException ie){

                throw new PlayerDatabaseException("Not enough players in the database for the team selected");
            }



        }
        return teamPlayers;
    }

    /* Practice 11-1. Declare an ArrayList here */

    private ArrayList<Player> players;


    /* Practice 11-1. Add Constructor here */

    /* Practice 11-1. Add getTeam() method here */

    String authorList =
            "Agatha Christie," +
                    "Alan Patton," +
                    "Alexander Solzhenitsyn," +
                    "Arthur Conan Doyle," +
                    "Anthony Trollope," +
                    "Baroness Orczy," +
                    "Brendan Behan," +
                    "Brian Moore," +
                    "Boris Pasternik," +
                    "Charles Dickens," +
                    "Charlotte Bronte," +
                    "Dorothy Parker," +
                    "Emile Zola," +
                    "Frank O'Connor," +
                    "Geoffrey Chaucer," +
                    "George Eliot," +
                    "G. K. Chesterton," +
                    "Graham Green," +
                    "Henry James," +
                    "James Joyce," +
                    "J. M. Synge," +
                    "J. R. Tolkien," +
                    "Jane Austin," +
                    "Leo Tolstoy," +
                    "Liam O'Flaherty," +
                    "Marcel Proust," +
                    "Mark Twain," +
                    "Oscar Wilde," +
                    "O. Henry," +
                    "Samuel Beckett," +
                    "Sean O'Casey," +
                    "William Shakespeare," +
                    "William Makepeace Thackeray," +
                    "W. B. Yeats," +
                    "Wilkie Collins";

}