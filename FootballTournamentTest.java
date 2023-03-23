import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FootballTournamentTest {

    @Test
    public void testFootballTournament() {
        FootballTournament tournament = new FootballTournament("Quarterfinals");
        tournament.addMatch("Quarterfinals", "Match 1", "Match 2");
        tournament.addMatch("Quarterfinals", "Match 3", "Match 4");
        tournament.addMatch("Match 1", "Team A", "Team B");
        tournament.addMatch("Match 2", "Team C", "Team D");
        tournament.addMatch("Match 3", "Team E", "Team F");
        tournament.addMatch("Match 4", "Team G", "Team H");

        String expectedOutput = "\t\tTeam D\n" +
                                "\tMatch 2\n" +
                                "\t\tTeam C\n" +
                                "Quarterfinals\n" +
                                "\t\tTeam B\n" +
                                "\tMatch 1\n" +
                                "\t\tTeam A\n" +
                                "\t\tTeam H\n" +
                                "\tMatch 4\n" +
                                "\t\tTeam G\n" +
                                "\t\tTeam F\n" +
                                "\tMatch 3\n" +
                                "\t\tTeam E\n";

        Assertions.assertEquals(expectedOutput, getActualOutput(tournament));
    }

    private String getActualOutput(FootballTournament tournament) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        tournament.printTournament();

        return outputStream.toString();
    }
}
