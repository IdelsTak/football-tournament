
public class FootballTournamentBracket {

    public static String[] generateBracket(int numTeams) {
        if (numTeams < 2 || numTeams % 2 != 0) {
            return null;
        }
        int numRounds = (int) (Math.log(numTeams) / Math.log(2));
        int numMatches = numTeams / 2;
        String[] bracket = new String[numMatches * numRounds];
        int matchIndex = 0;
        for (int round = 1; round <= numRounds; round++) {
            int numMatchesThisRound = numMatches / (int) Math.pow(2, round - 1);
            for (int match = 1; match <= numMatchesThisRound; match++) {
                int team1 = (match - 1) * (int) Math.pow(2, round - 1) + 1;
                int team2 = team1 + (int) Math.pow(2, round - 1);
                bracket[matchIndex++] = team1 + " vs. " + team2;
            }
        }
        return bracket;
    }

    public static void main(String[] args) {
        int numTeams = 16;
        String[] bracket = generateBracket(numTeams);
        if (bracket == null) {
            System.out.println("Invalid number of teams.");
        } else {
            for (int i = 0; i < bracket.length; i++) {
                System.out.println("Match " + (i + 1) + ": " + bracket[i]);
            }
        }
    }
}
