package Six_A;
import java.lang.Comparable;
//music playlist alternate question
public class choice implements Comparable<choice>{ 
    String song_name;
    String movie_name;
    public choice(String song_name,String movie_name)
    {
        this.song_name = song_name;
        this.movie_name = movie_name;
    }
    public String getSong_name()
    {
        return song_name;
    }
    public void setSong_name(String song_name)
    {
        this.song_name = song_name;
    }
    public String getMovie_name()
    {
        return movie_name;
    }
    public void setmovie_name(String movie_name)
    {
        this.movie_name = movie_name;
    }
    public int compareTo(choice other) {
        // Example natural order 
        return this.song_name.compareTo(other.song_name);
    }

}


