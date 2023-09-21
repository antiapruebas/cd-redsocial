package RedSocial;

import java.util.List;

public class Text extends Post {
    protected String bodyPost;


    public Text(String titlePost, String datePost, String userName, String bodyPost) {
        super(titlePost, datePost, userName);
        this.bodyPost = bodyPost;
    }

    public Text(String idPost, String titlePost, List<String> commentsList, String datePost, String userName, String bodyPost) {
        super(idPost, titlePost, commentsList, datePost, userName);
        this.bodyPost = bodyPost;
    }

    public String getBodyPost() {
        return bodyPost;
    }

    public void setBodyPost(String bodyPost) {
        this.bodyPost = bodyPost;
    }
}
