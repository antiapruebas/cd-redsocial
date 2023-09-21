package RedSocial;

import java.util.ArrayList;
import java.util.List;

public abstract class Post {

    protected String idPost;

    protected  String titlePost;
    protected  List<String> commentsList = new ArrayList<>();
    protected String datePost;
    protected String userName;

    public Post(String titlePost, String datePost, String userName) {
        this.titlePost = titlePost;
        this.datePost = datePost;
        this.userName = userName;
    }

    public Post(String idPost, String titlePost, List<String> commentsList, String datePost, String userName) {
        this.idPost = idPost;
        titlePost = titlePost;
        this.commentsList = commentsList;
        this.datePost = datePost;
        this.userName = userName;
    }

    public String getIdPost() {
        return idPost;
    }

    public String getTitlePost() {
        return titlePost;
    }

    public List<String> getCommentsList() {
        return commentsList;
    }


    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public void setTitlePost(String titlePost) {

        this.titlePost = titlePost;
    }
    public void setCommentsList(List<String> commentsList) {
        this.commentsList = commentsList;
    }

    public String getDatePost() {
        return datePost;
    }

    public void setDatePost(String datePost) {
        this.datePost = datePost;
    }

    public String getUserName() {
        return userName;
    }



    public void addComentario(Comentarios comentario1) {
        this.commentsList.add(String.valueOf(comentario1));

    }
}

