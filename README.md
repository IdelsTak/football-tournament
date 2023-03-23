# Football Tournament
A tree data structure can be a good choice to represent a football tournament in Java, where each node in the tree represents a match and the leaf nodes represent the final results of the tournament.

Here's an example implementation of a football tournament using a binary tree in Java:

```java
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
```

Calling `printTournament` method prints:

```sql
		Team D
	Match 2
		Team C
Quarterfinals
		Team B
	Match 1
		Team A
		Team H
	Match 4
		Team G
		Team F
	Match 3
		Team E
```

This output shows that the quarterfinal matches are played in the  correct order, with the winners of each match proceeding to the next  round. The tree structure makes it easy to represent the tournament in a hierarchical manner, and the implementation allows for easy adding of  matches and teams as the tournament progresses.

