package RedSocial;

public class Comentarios{

    protected String username;
    protected String dateComment;
    protected String comment;

    public Comentarios( String username, String dateComment, String comment){

       this.username = username;
        this.dateComment = dateComment;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comentarios:" +
                "Usuario: " + username + '\'' +
                " Fecha: " + dateComment + '\'' +
                "Comentario: '" + comment + '\'' ;
    }





    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setDateComment(String dateComment) {
        this.dateComment = dateComment;
    }
    public String getDateComment() {
        return dateComment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getComment() {
        return comment;
    }
}
