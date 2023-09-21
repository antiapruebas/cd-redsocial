package RedSocial;

import java.util.List;

public class Video extends Post {

    protected double quality;
    protected double duration;

    public Video(String titlePost, String datePost, String userName, double quality, double duration) {
        super(titlePost, datePost, userName);
        this.quality = quality;
        this.duration = duration;
    }

    public Video(String idPost, String titlePost, List<String> commentsList, String datePost, String userName, double quality, double duration) {
        super(idPost, titlePost, commentsList, datePost, userName);
        this.quality = quality;
        this.duration = duration;
    }

    public double getQuality() {
        return quality;
    }

    public double getDuration() {
        return duration;
    }

    public void setQuality(double quality) {
        this.quality = quality;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}