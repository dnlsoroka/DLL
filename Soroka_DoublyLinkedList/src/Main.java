import java.util.List;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        // sample albums
        Album a1 = new Album(1, List.of("Artist1"),"Album1",11);
        Album a2 = new Album(2, List.of("Artist2"),"Album2",13);
        Album a3 = new Album(3, List.of("Artist3"),"Album3",9);

        // append albums to dll
        dll.append(a1);
        dll.append(a2);
        dll.append(a3);

        // print the dll
        Album.printAlbums(dll);
        //append new Node
        Album a4 = new Album(4, List.of("Artist4"),"Album4",13);
        dll.append(a4);
        System.out.println("===============\nDLL after appending new node:");
        Album.printAlbums(dll);

        //insert node at a specific location
        Album a5 = new Album(5, List.of("Artist5"), "Album 5", 3);
        dll.insert(2,a5);
        System.out.println("===============\nDLL after Inserting new node");
        Album.printAlbums(dll);

        //delete node
        dll.delete(1);
        System.out.println("===============\nDLL after deleting node");
        Album.printAlbums(dll);

        // get Index
        System.out.println("===============\nget index of album 5:");
        int index = dll.getIndex(a5);
        System.out.println("Index " + index);

        // shuffled list
        System.out.println("===============\nshuffled list: ");
        System.out.println(dll.shuffle().toString());

    }
}