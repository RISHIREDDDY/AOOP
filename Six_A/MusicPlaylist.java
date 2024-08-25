package Six_A;
import java.util.*;
public class MusicPlaylist {
    public static void main(String[] args) {
        ArrayList<String> music = new ArrayList<>();
        music.add("song1");
        music.add("song2");
        music.add("song3");
        music.add("song4");
        music.remove("song2");
        music.add("song5");
        Iterator<String>iterator = music.iterator();
        while(iterator.hasNext())  
        {
            System.out.println(iterator.next());
        }
    }
}
