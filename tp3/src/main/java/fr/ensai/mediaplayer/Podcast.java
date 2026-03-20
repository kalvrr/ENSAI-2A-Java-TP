package fr.ensai.mediaplayer;

public class Podcast {
    
    // Attributes
    private String title;
    private String host;
    private String topic;
    private int duration;
    private int year;
    private String subtitles;

    /**
     * Constructs a new Artist object.
     * @param title
     * @param host
     * @param topic
     * @param duration
     * @param year
     * @param subtitles
     */
    public Podcast(String title, String host, String topic, int duration, int year, String subtitles) {
        this.title = title;
        this.host = host;
        this.topic = topic;
        this.duration = duration;
        this.year = year;
        this.subtitles = subtitles;

    }

    public void play() {
        String[] mots = this.subtitles.split(" ");
        for (String mot : mots){
            try {
                Thread.sleep(100);
                System.out.println(mot + " ");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted");
            }
        }
        
    }

    /**
     * String representation of the Podcast.
     */
    @Override
    public String toString() {
        return String.format("Podcast %s by %s",this.title, this.host);
    }
}
