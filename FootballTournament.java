
/**
 * This class represents the tournament and contains a nested Node class
 * that represents each match in the tournament.
 * <p>
 * The {@code Node} class has a match field that stores the name of the match
 * and left and right fields that store the left and right child nodes of the
 * match, which represent the two teams playing in the match.
 *
 * @author hiram-k
 */
public class FootballTournament {

    private Node root;

    private class Node {

        private String match;
        private Node left;
        private Node right;

        public Node(String match) {
            this.match = match;
            this.left = null;
            this.right = null;
        }
    }

    public FootballTournament(String rootMatch) {
        this.root = new Node(rootMatch);
    }

    public void addMatch(String parentMatch, String leftMatch, String rightMatch) {
        Node parent = findNode(root, parentMatch);
        if (parent != null) {
            parent.left = new Node(leftMatch);
            parent.right = new Node(rightMatch);
        }
    }

    private Node findNode(Node node, String match) {
        if (node == null) {
            return null;
        }
        if (node.match.equals(match)) {
            return node;
        }
        Node left = findNode(node.left, match);
        if (left != null) {
            return left;
        }
        return findNode(node.right, match);
    }

    public void printTournament() {
        printTree(root, 0);
    }

    private void printTree(Node node, int depth) {
        if (node != null) {
            printTree(node.right, depth + 1);
            for (int i = 0; i < depth; i++) {
                System.out.print("\t");
            }
            System.out.println(node.match);
            printTree(node.left, depth + 1);
        }
    }

    public static void main(String[] args) {
        FootballTournament tournament = new FootballTournament("Quarterfinals");
        tournament.addMatch("Quarterfinals", "Match 1", "Match 2");
        tournament.addMatch("Quarterfinals", "Match 3", "Match 4");
        tournament.addMatch("Match 1", "Team A", "Team B");
        tournament.addMatch("Match 2", "Team C", "Team D");
        tournament.addMatch("Match 3", "Team E", "Team F");
        tournament.addMatch("Match 4", "Team G", "Team H");
        tournament.printTournament();
    }
}
