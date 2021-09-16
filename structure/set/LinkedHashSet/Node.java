package Algorithm.structure.set.LinkedHashSet;

class Node<E> {

    final int hash;
    final E key;

    Node<E> next;

    Node<E> nextLink;
    Node<E> prevLink;

    public Node(int hash, E key, Node<E> next) {
        this.hash = hash;
        this.key = key;
        this.next = next;

        this.nextLink = null;
        this.prevLink = null;
    }
}
