// Common Interface for Music Player
interface MusicPlayer {
    void play();
}

// Adapter Pattern Implementation

// Local File Music Player
class LocalFilePlayer implements MusicPlayer {
    private String filePath;

    public LocalFilePlayer(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void play() {
        System.out.println("Playing local file: " + filePath);
    }
}

// Online Streaming Music Player
class OnlineStreamingPlayer implements MusicPlayer {
    private String url;

    public OnlineStreamingPlayer(String url) {
        this.url = url;
    }

    @Override
    public void play() {
        System.out.println("Playing online streaming from: " + url);
    }
}

// Radio Station Music Player
class RadioStationPlayer implements MusicPlayer {
    private String station;

    public RadioStationPlayer(String station) {
        this.station = station;
    }

    @Override
    public void play() {
        System.out.println("Playing radio station: " + station);
    }
}

// Decorator Pattern Implementation

// Base Decorator Class
abstract class MusicPlayerDecorator implements MusicPlayer {
    protected MusicPlayer decoratedPlayer;

    public MusicPlayerDecorator(MusicPlayer decoratedPlayer) {
        this.decoratedPlayer = decoratedPlayer;
    }

    @Override
    public void play() {
        decoratedPlayer.play();
    }
}

// Equalizer Decorator
class EqualizerDecorator extends MusicPlayerDecorator {
    public EqualizerDecorator(MusicPlayer decoratedPlayer) {
        super(decoratedPlayer);
    }

    @Override
    public void play() {
        super.play();
        setEqualizer();
    }

    private void setEqualizer() {
        System.out.println("Applying equalizer settings...");
    }
}

// Volume Control Decorator
class VolumeControlDecorator extends MusicPlayerDecorator {
    public VolumeControlDecorator(MusicPlayer decoratedPlayer) {
        super(decoratedPlayer);
    }

    @Override
    public void play() {
        super.play();
        setVolumeControl();
    }

    private void setVolumeControl() {
        System.out.println("Setting volume control...");
    }
}
public class MusicStreamingApp {
    public static void main(String[] args) {
        MusicPlayer localPlayer = new LocalFilePlayer("song.mp3");
        MusicPlayer onlinePlayer = new OnlineStreamingPlayer("http://streaming.service/song");
        MusicPlayer radioPlayer = new RadioStationPlayer("FM 101.1");

        // Decorate players with additional features
        MusicPlayer localPlayerWithEqualizer = new EqualizerDecorator(localPlayer);
        MusicPlayer onlinePlayerWithVolumeControl = new VolumeControlDecorator(onlinePlayer);
        MusicPlayer radioPlayerWithAllFeatures = new VolumeControlDecorator(new EqualizerDecorator(radioPlayer));

        System.out.println("Playing local file with equalizer:");
        localPlayerWithEqualizer.play();

        System.out.println("\nPlaying online streaming with volume control:");
        onlinePlayerWithVolumeControl.play();

        System.out.println("\nPlaying radio station with all features:");
        radioPlayerWithAllFeatures.play();
    }
}