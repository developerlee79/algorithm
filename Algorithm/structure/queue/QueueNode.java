package Algorithm.structure.queue;

public class QueueNode {

    int value;
    QueueNode queueNode;

    public QueueNode(int value) {
        this.value = value;
        queueNode = null;
    }

    public int getValue() {
        return value;
    }

    public QueueNode getNextNode() {
        return queueNode;
    }

    public void setNextNode(QueueNode queueNode) {
        this.queueNode = queueNode;
    }
}
