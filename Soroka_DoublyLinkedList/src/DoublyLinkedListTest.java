import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class DoublyLinkedListTest {

    @Test
    public void testAppend() {
        DoublyLinkedList dll = new DoublyLinkedList();
        // sample data (albums)
        Album a1 = new Album(1, List.of("Artist1"), "Album1", 11);
        Album a2 = new Album(2, List.of("Artist2"), "Album2", 13);
        //append albums to list
        dll.append(a1);
        dll.append(a2);

        //check if DLL is in correct order
        List<Album> expected = List.of(a1, a2);
        List<Album> actual = new ArrayList<>();

        Node currentNode = dll.getHead();
        // iterate through the list , retrieve Node data and add it to the 'actual'
        while (currentNode != null) {
            actual.add(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testInsert() {
        DoublyLinkedList dll = new DoublyLinkedList();
        // sample data (albums)
        Album a1 = new Album(1, List.of("Artist1"), "Album1", 11);
        Album a2 = new Album(2, List.of("Artist2"), "Album2", 13);
        Album a3 = new Album(3, List.of("Artist3"), "Album3", 10);
        Album a4 = new Album(4, List.of("Artist4"), "Album4", 6);
        //append albums to list
        dll.append(a1);
        dll.append(a2);
        dll.append(a3);


        // Insert a4 at index 1
        dll.insert(1, a4);

        //check if DLL is in correct order
        List<Album> expected = List.of(a1, a4, a2, a3);
        List<Album> actual = new ArrayList<>();

        Node currentNode = dll.getHead();
        // iterate through the list , retrieve Node data and add it to the 'actual'
        while (currentNode != null) {
            actual.add(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDelete() {
        DoublyLinkedList dll = new DoublyLinkedList();
        // sample data (albums)
        Album a1 = new Album(1, List.of("Artist1"), "Album1", 11);
        Album a2 = new Album(2, List.of("Artist2"), "Album2", 13);
        Album a3 = new Album(3, List.of("Artist3"), "Album3", 10);
        Album a4 = new Album(4, List.of("Artist4"), "Album4", 6);

        dll.append(a1);
        dll.append(a2);
        dll.append(a3);
        dll.append(a4);
        // delete node at index 1
        dll.delete(1);
        //check if DLL is in correct order after delete
        List<Album> expected = List.of(a1, a3, a4);
        List<Album> actual = new ArrayList<>();

        Node currentNode = dll.getHead();
        // iterate through the list , retrieve Node data and add it to the 'actual'
        while (currentNode != null) {
            actual.add(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetIndex() {
        DoublyLinkedList dll = new DoublyLinkedList();
        // sample data (albums)
        Album a1 = new Album(1, List.of("Artist1"), "Album1", 11);
        Album a2 = new Album(2, List.of("Artist2"), "Album2", 13);
        Album a3 = new Album(3, List.of("Artist3"), "Album3", 10);
        Album a4 = new Album(4, List.of("Artist4"), "Album4", 6);

        dll.append(a1);
        dll.append(a2);
        dll.append(a3);
       // dll.append(a4);

        // Test getIndex with an item in the list
        int index1 = dll.getIndex(a2);
        Assert.assertEquals(1, index1);

        //Test with item not in the list
        int index2 = dll.getIndex(a4);
        Assert.assertEquals(-1, index2);
    }

    @Test
    public void testShuffle() {
        DoublyLinkedList dll = new DoublyLinkedList();
        // sample data (albums)
        Album a1 = new Album(1, List.of("Artist1"), "Album1", 11);
        Album a2 = new Album(2, List.of("Artist2"), "Album2", 13);
        Album a3 = new Album(3, List.of("Artist3"), "Album3", 10);
        Album a4 = new Album(4, List.of("Artist4"), "Album4", 6);

        dll.append(a1);
        dll.append(a2);
        dll.append(a3);
        dll.append(a4);
        // Shuffle the list
        DoublyLinkedList shuffledList = dll.shuffle();

        // Get the data of the shuffled list nodes
        List<Album> shuffledAlbums = getNodeData(shuffledList);

        // Define the expected shuffled order
        List<Album> expectedShuffledAlbums = Arrays.asList(a2, a1, a4, a3);


        Assert.assertEquals(expectedShuffledAlbums, shuffledAlbums);
    }
    @Test
    public void testPartition() {
        DoublyLinkedList dll = new DoublyLinkedList();
        // sample data (albums)
        Album a1 = new Album(1, List.of("Artist1"), "Album1", 11);
        Album a2 = new Album(2, List.of("Artist2"), "Album2", 13);
        Album a3 = new Album(3, List.of("Artist3"), "Album3", 10);
        Album a4 = new Album(4, List.of("Artist4"), "Album4", 6);

        // Append the albums to the linked list
        dll.append(a1);
        dll.append(a2);
        dll.append(a3);
        dll.append(a4);

        // Partition the list with data value 12
        DoublyLinkedList partitionedList = dll.partition(11);

        // Get the data of the partitioned list nodes
        List<Album> partitionedAlbums = getNodeData(partitionedList);

        // Define the expected order
        List<Album> expectedPartitionedAlbums = List.of(a1 ,a2);

        Assert.assertEquals(expectedPartitionedAlbums, partitionedAlbums);
    }
    // get data of nodes in a dll
    private List<Album> getNodeData(DoublyLinkedList dll) {
        Node currentNode = dll.getHead();
        List<Album> nodeDataList = new ArrayList<>();

        while (currentNode != null) {
            nodeDataList.add(currentNode.getData());
            currentNode = currentNode.getNext();
        }

        return nodeDataList;
    }
}
