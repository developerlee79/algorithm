package Algorithm.structure.tree;

public class RedBlackTree {
    private static final int BLACK = 0;
    private static final int RED = 1;

    private static Node root;

    private static class Node {
        private int value;
        private int color;

        Node left;
        Node right;
        Node parent;

        Node(int value) {
            this.value = value;
            color = BLACK;

            left = null;
            right = null;
            parent = null;
        }

        Node() {
            this(-1);
        }

        int getValue() {
            return value;
        }

        String getColor() {
            return color == RED ? "RED" : "BLACK";
        }

        void setColor(int color) {
            this.color = color;
        }
    }

    public static void printTree(Node node) {
        if (node == null)
            return;

        System.out.println(node.getValue() + "(" + node.getColor() + ")");
        printTree(node.left);
        printTree(node.right);
    }

    public static Node findNode(Node goal, Node node) {
        if (node == null)
            return null;

        if (goal.getValue() < node.getValue()) {
            if (node.left != null)
                return findNode(goal, node.left);
        } else if (goal.getValue() > node.getValue()) {
            if (node.right != null)
                return findNode(goal, node.right);
        } else {
            return node;
        }

        return null;
    }

    public static void insertNode(Node node) {
        if (root == null) {
            root = node;

            System.out.println("Created RBT !!!\n");
        } else {
            Node parent = root;

            node.setColor(RED);

            while (true) {
                if (parent.getValue() < node.getValue()) {
                    if (parent.right == null) {
                        parent.right = node;
                        node.parent = parent;
                        break;
                    } else {
                        parent = parent.right;
                    }
                } else {
                    if (parent.left == null) {
                        parent.left = node;
                        node.parent = parent;
                        break;
                    } else {
                        parent = parent.left;
                    }
                }
            }

            recolorTree(node);
        }

        System.out.println("Inserted " + node.getValue());
    }

    private static void recolorTree(Node node) {
        while (node.parent != null && "RED".equals(node.parent.getColor())) {
            Node next = null;

            if (node.parent == node.parent.parent.left) {
                next = node.parent.parent.right;

                if (next != null && "RED".equals(next.getColor())) {
                    node.parent.setColor(BLACK);
                    next.setColor(BLACK);
                    node.parent.parent.setColor(RED);
                    node = node.parent.parent;
                    continue;
                }

                if (node == node.parent.right) {
                    node = node.parent;

                    rotateLeft(node);
                }

                node.parent.setColor(BLACK);
                node.parent.parent.setColor(RED);

                rotateRight(node.parent.parent);
                break;
            } else {
                next = node.parent.parent.left;

                if (next != null && "RED".equals(next.getColor())) {
                    node.parent.setColor(BLACK);
                    next.setColor(BLACK);
                    node.parent.parent.setColor(RED);
                    node = node.parent.parent;
                    continue;
                }

                if (node == node.parent.left) {
                    node = node.parent;

                    rotateRight(node);
                }

                node.parent.setColor(BLACK);
                node.parent.parent.setColor(RED);

                rotateLeft(node.parent.parent);
                break;
            }
        }

        root.setColor(BLACK);
    }

    private static void rotateLeft(Node node) {
        if (node.parent == null) {
            Node right = root.right;
            root.right = root.right.left;
            right.left = new Node();
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = null;
            root = right;
        } else {
            if (node == node.parent.left)
                node.parent.left = node.right;
            else
                node.parent.right = node.right;

            node.right.parent = node.parent;
            node.parent = node.right;

            if (node.right.left != null)
                node.right.left.parent = node;

            node.right = node.right.left;
            node.parent.left = node;
        }
    }

    private static void rotateRight(Node node) {
        if (node.parent == null) {
            Node left = root.left;
            root.left = root.left.right;
            left.right = new Node();
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = null;
            root = left;
        } else {
            if (node == node.parent.left)
                node.parent.left = node.left;
            else
                node.parent.right = node.left;

            node.left.parent = node.parent;
            node.parent = node.left;

            if (node.left.right != null)
                node.left.right.parent = node;

            node.left = node.left.right;
            node.parent.right = node;
        }
    }

}
