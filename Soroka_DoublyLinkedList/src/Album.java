import java.util.List;

//Create a new class named Album that implements comparable,

public class Album implements Comparable<Album>{

    private int id;
    private List<String> artists;
    private String title;
    public int getNumSongs() {
        return numSongs;
    }
    private int numSongs;

    //Constructor
    public Album(int id, List<String> artists, String title, int numSongs){
        this.id = id;
        this.artists = artists;
        this.title = title;
        this.numSongs = numSongs;
    }
    public static void printAlbums(DoublyLinkedList dll) {
        Node currentNode = dll.getHead();
        while (currentNode != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }

    //Compare number of songs
    @Override
    public int compareTo(Album other){
        return Integer.compare(this.numSongs, other.numSongs);
    }

    // toString
    public String toString(){
        return "ID: " + id + " -- " + artists +" "+ title + ": " + numSongs+ " songs";    }
}
