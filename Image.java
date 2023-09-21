package RedSocial;

import java.util.List;

public class Image extends Post {

    protected double height;

    protected double width;


    public Image(String titlePost, String datePost, String userName, double height, double width) {
        super(titlePost, datePost, userName);
        this.height = height;
        this.width = width;
    }

    public Image(String idPost, String titlePost, List<String> commentsList, String datePost, String userName, double height, double width) {
        super(idPost, titlePost, commentsList, datePost, userName);
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }


}