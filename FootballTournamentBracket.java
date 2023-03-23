
import java.util.Random;
import java.util.Scanner;

public class FootballTournamentBracket {

    private final BracketNode root;
    private int numTeams;

    public FootballTournamentBracket(int numTeams) {
        this.numTeams = numTeams;
        this.root = createBracket(numTeams);
    }

    public void setTeamName(int index, String name) {
        BracketNode node = getNode(index);
        if (node != null) {
            node.teamName = name;
        }
    }

    public void playMatch(int index) {
        BracketNode node = getNode(index);
        if (node != null && node.left != null && node.right != null) {
            String winner = simulateMatch(node.left.teamName, node.right.teamName);
            node.teamName = winner;
        }
    }

    public String getWinner() {
        return root.teamName;
    }

    private BracketNode getNode(int index) {
        if (index < 0 || index >= numTeams) {
            return null;
        }

        BracketNode node = root;
        int level = (int) (Math.log(numTeams) / Math.log(2));

        while (level > 0) {
            if (index < numTeams / 2) {
                node = node.left;
            } else {
                node = node.right;
                index -= numTeams / 2;
            }
            numTeams /= 2;
            level--;
        }

        return node;
    }

    private String simulateMatch(String team1, String team2) {
        Random rand = new Random();
        int score1 = rand.nextInt(5);
        int score2 = rand.nextInt(5);

        System.out.printf("%s %d - %d %s%n", team1, score1, score2, team2);

        if (score1 > score2) {
            return team1;
        } else if (score2 > score1) {
            return team2;
        } else {
            // in case of a tie, randomly choose a winner
            if (rand.nextBoolean()) {
                return team1;
            } else {
                return team2;
            }
        }
    }

    public static void assignTeamNames(BracketNode node, Scanner scanner) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            System.out.print("Enter the name of team " + node.teamName + ": ");
            node.teamName = scanner.nextLine();
            return;
        }

        assignTeamNames(node.left, scanner);
        assignTeamNames(node.right, scanner);
    }

    public class BracketNode {

        public BracketNode left;
        public BracketNode right;
        public String teamName;

        public BracketNode(String teamName) {
            this.teamName = teamName;
        }
    }

    public BracketNode createBracket(int numTeams) {
        BracketNode root = new BracketNode(null);
        createSubtree(root, numTeams);
        return root;
    }

    private void createSubtree(BracketNode node, int numTeams) {
        if (numTeams == 1) {
            node.teamName = "Team " + numTeams;
            return;
        }

        node.left = new BracketNode(null);
        node.right = new BracketNode(null);

        createSubtree(node.left, numTeams / 2);
        createSubtree(node.right, numTeams / 2);
    }

}
