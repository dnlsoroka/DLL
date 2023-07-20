public class Node {
    private Album data;
    private Node prev;
    private Node next;


    //Constructor
    public Node(Album data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
    public Album getData() {
        return data;
    }

    public void setData(Album data) {
        this.data = data;
    }

    // Getters and setters for prev and next
    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
