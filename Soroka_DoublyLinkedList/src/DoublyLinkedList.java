public class DoublyLinkedList {

    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    //    public  DoublyLinkedList(){}
    //Append : Returns appended Node
    public void append(Album album) {
        Node newNode = new Node(album);

        if (head == null) {

            head = newNode;
            tail = newNode;
        } else {
            // Append newNode to the end of the list
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;

        }
    }

    // Insert operation
    // accepts location (index) and data (album)
    public void insert(int index, Album album) {
        Node newNode = new Node(album);
        //if index <= 0 , the newNode is inserted at beginning and becomes the head
        if (index <= 0) {
            newNode.setNext(head);
            if (head != null) {
                head.setPrev(newNode);
            }
            head = newNode;
            if (tail == null) {// list is empty , newNode is head and tail
                tail = newNode;
            }
        } else {
            Node currentNode = head;
            int currentIndex = 0;
            //if index > 0, traverse the list to index position or to the end of the list (whichever is first) to insert the new node
            while (currentNode != null && currentIndex < index - 1) {
                currentNode = currentNode.getNext();
                currentIndex++;
            }
            if (currentNode == null) {
                // Index is out of bounds, insert at the end of the list
                tail.setNext(newNode);
                newNode.setPrev(tail);
                tail = newNode;
            } else {
                // Insert the new node at the specified position
                newNode.setNext(currentNode.getNext());
                newNode.setPrev(currentNode);
                if (currentNode.getNext() != null) {
                    currentNode.getNext().setPrev(newNode);
                }
                currentNode.setNext(newNode);
            }
        }
    }

    //delete operation
    public void delete(int index) {
        // if list is empty or index is out of bound
        if (index < 0 || head == null) {
            return;
        }
        if (index == 0) {
            // delete head
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
            if (head == null) {
                //empty after delete
                tail = null;
            }
            return;
        }
        Node currentNode = head;
        int currentIndex = 0;
        // traverse list to the index
        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        if (currentNode == null) {
            // Index is out of bounds
            return;
        }
        if (currentNode == tail) {
            // delete tail node
            tail = tail.getPrev();
            if (tail != null) {
                tail.setNext(null);
            }
            return;
        }
        // Delete a node in the middle of the list
        Node prevNode = currentNode.getPrev();
        Node nextNode = currentNode.getNext();
        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);
    }

    public int getIndex(Album item) {
        Node currentNode = head;
        int currentIndex = 0;
        //traverse list
        while (currentNode != null) {
            // check if data in current node matches data of item that is being searched for
            if (currentNode.getData().equals(item)) {
                // return current index if match is found
                return currentIndex;
            }
            // if not match is found move to the next node
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        // Item not found in the list
        return -1;
    }
    // Shuffle the list and return the head of the shuffled list
    public DoublyLinkedList shuffle() {
        DoublyLinkedList shuffledList = new DoublyLinkedList();
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.getNext() != null) {
                // Remove the next node from the original list
                Node nextNode = currentNode.getNext();
                currentNode.setNext(nextNode.getNext());
                if (nextNode.getNext() != null) {
                    nextNode.getNext().setPrev(currentNode);
                }
                // Append the next node to the shuffled list
                shuffledList.append(nextNode.getData());
            }
            // Append the current node to the shuffled list
            shuffledList.append(currentNode.getData());
            // Move to the next node
            currentNode = currentNode.getNext();
        }
        // If the original list has an odd number of nodes, append the last node to the shuffled list
        if (currentNode != null) {
            shuffledList.append(currentNode.getData());}
        return shuffledList;
    }
    // Partition the list and return a new DoublyLinkedList containing nodes with data greater than or equal to the given value
    public DoublyLinkedList partition(int data) {
        // Create a new DoublyLinkedList to hold the partitioned albums
        DoublyLinkedList partitionedList = new DoublyLinkedList();
        // Start from the head of the original list
        Node currentNode = head;
        // Traverse the original list
        while (currentNode != null) {
            // Get the album from the current node
            Album album = currentNode.getData();
            // Check if the album's numSongs is greater than or equal to the given data value
            if (album.getNumSongs() >= data) {
                // Append the album to the partitioned list
                partitionedList.append(album);
            }
            // Move to the next node
            currentNode = currentNode.getNext();
        }
        return partitionedList;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        Node currentNode = head;

        while (currentNode != null) {
            stb.append(currentNode.getData());
            if (currentNode.getNext() != null) {
                stb.append(" -> ");
            }
            currentNode = currentNode.getNext();
        }

        stb.append(" -> NULL");
        return stb.toString();
    }

}