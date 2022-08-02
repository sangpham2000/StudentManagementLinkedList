public class Pair {
    private Node node;
    private String action;

    public Pair(Node node, String action) {
        this.node = node;
        this.action = action;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Pair [action=" + action + ", node=" + node + "]";
    }
}
