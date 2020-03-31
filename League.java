package soccer;

import utility.PlayerDatabase;
import utility.PlayerDatabaseException;

import java.time.*;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class League {

    public String getLeagueAnnouncement(Game[] theGames) {

        Period thePeriod = Period.between(theGames[0].getTheDateTime().toLocalDate(), theGames[theGames.length - 1].getTheDateTime().toLocalDate());

        return "The League is scheduled to run for " + thePeriod.getMonths() + " month(s), and " + thePeriod.getDays() + " day(s)\n";
    }


    public void showBestTeam(Team[] theTeams) {

        Arrays.sort(theTeams);

        Team currBestTeam = theTeams[0];
        System.out.println("\nTeam Points");

        for (Team currTeam : theTeams) {
            System.out.println(currTeam.getTeamName() + ":" +
                    currTeam.getPointsTotal());
            currBestTeam = currTeam.getPointsTotal() > currBestTeam.getPointsTotal() ? currTeam : currBestTeam;
        }

        System.out.println("Winner of the league is " + currBestTeam.getTeamName());
    }


    public Team[] createTeams(String teamNames, int teamSize) throws PlayerDatabaseException {

        PlayerDatabase playerDB = new PlayerDatabase();

        StringTokenizer teamNameTokens = new StringTokenizer(teamNames, ",");
        Team[] theTeams = new Team[teamNameTokens.countTokens()];

        for (int i = 0; i < theTeams.length; i++) {
            theTeams[i] = new Team(teamNameTokens.nextToken(), playerDB.getTeam(teamSize));
        }


        return theTeams;
    }

    public Game[] createGames(Team[] theTeams) {

        int daysBetweenGames = 0;

        ArrayList<Game> theGames = new ArrayList<>();

        for (Team homeTeam : theTeams) {
            for (Team awayTeam : theTeams) {
                if (homeTeam != awayTeam) {
                    daysBetweenGames += 7;
                    theGames.add(new Game(homeTeam, awayTeam, LocalDateTime.now().plusDays(daysBetweenGames)));
                }
            }

        }
        return theGames.toArray(new Game[1]);
    }

    public static void main(String[] args) {

        League theLeague = new League();

        try {

            Team[] theTeams = theLeague.createTeams
                    ("The Robins,The Crows,The Swallows,The Owls", 11);

            Game[] theGames = theLeague.createGames(theTeams);

            System.out.println(theLeague.getLeagueAnnouncement(theGames));
            for (Game currGame : theGames) {
                currGame.playGame();
                //break;
                System.out.println(currGame.getDescription());
            }

            theLeague.showBestTeam(theTeams);
        }
        catch (Exception e){
            e.printStackTrace(System.err);
        }

    }
}