package Algorithm.structure.queue;


public class QueueNodeManager {
    QueueNode front, rear;

    public QueueNodeManager() {
        front = rear = null;
    }

    public boolean isQueueEmpty() {
        return front == null && rear == null;
    }

    public void push(int value) {
        QueueNode queueNode = new QueueNode(value);
        if (isQueueEmpty()) {
            front = rear = queueNode;
        } else {
            front.setNextNode(queueNode);
            front = queueNode;
        }
    }

    public QueueNode pop() {
        if (isQueueEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        } else {
            QueueNode popNode = rear;
            rear = rear.getNextNode();
            return popNode;
        }
    }

    public QueueNode peek() {
        if (isQueueEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        } else {
            return rear;
        }
    }

    public int size() {
        QueueNode front2 = front;
        QueueNode rear2 = rear;
        int count = 0;
        while (front2 != rear2 && rear2 != null) {
            count++;
            rear2 = rear2.getNextNode();
        }
        return count;
    }
}
