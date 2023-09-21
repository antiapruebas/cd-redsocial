package RedSocial;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    protected String userName;
    protected List<Usuario> followList = new ArrayList<Usuario>();
    protected static List<Post> postList = new ArrayList<>();

    public Usuario(String name) {
        this.userName = name;
    }

    public Usuario(String name, List<Usuario> followList, List<Post> postList) {
        this.userName = name;
        this.followList = followList;
        this.postList = postList;
    }

    public static void add(Usuario nuevoUsuario) {
        String nuevoUsuarioName = nuevoUsuario.getName();
        if (!DevNet.userList.contains(nuevoUsuarioName)) {
            DevNet.userList.add(nuevoUsuarioName);
            System.out.println("Usuario " + nuevoUsuarioName + " agregado con éxito.");
        } else {
            System.out.println("Este usuario ya existe.");
        }
    }

    public static void add2(Usuario nuevoUsuario) {
        String nuevoUsuarioName = nuevoUsuario.getName();
        if (!DevNet.userList.contains(nuevoUsuarioName)) {
            DevNet.userList.add(nuevoUsuarioName);
        }
    }

    public static void remove(Usuario usuario) {
        String nombreUsuario = usuario.getName();

        if (DevNet.userList.contains(nombreUsuario)) {
            DevNet.userList.remove(nombreUsuario);
            System.out.println("Usuario " + nombreUsuario + " eliminado");
        } else {
            System.out.println("El usuario no está registrado");
        }
    }



    public String getName() {
        return userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public List<Usuario> getFollowList() {
        return followList;
    }

    public void setFollowList(List<Usuario> followList) {
        this.followList = followList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    //Metodos
    public static void addPost(Post post) {
       postList.add(post);
        System.out.println("Post publicado xd");
    }

    public  void addPost2(Post post) {
        this.postList.add(post);
        }


    public static void usuariosEjemplo(){

        Usuario antia = new Usuario ("Antía");
        Usuario nestor = new Usuario ("Nestor");
        Usuario jose = new Usuario ("Jose");
        Usuario pedro = new Usuario ("Pedro");
        Usuario penedo = new Usuario ("Penedo");


        Usuario.add2(antia );
        Usuario.add2(nestor);
        Usuario.add2(jose);
        Usuario.add2(penedo);


        Post post1 = new Text("Primer post", Utils.obtenerFechaActual(), "Antía", "¿Qué tal vais?");
        Post post2 = new Text("La merienda", Utils.obtenerFechaActual(), "Nestor", "Traeme un sandwich");
        Post post3 = new Image("Vacaciones", Utils.obtenerFechaActual(), "Jose", 800, 600);
        Post post4 = new Video("Cinco minutos", Utils.obtenerFechaActual(), "Penedo", 1080, 5);

        antia.addPost2(post1);
        nestor.addPost2(post2);
        jose.addPost2(post3);
        penedo.addPost2(post4);


        Comentarios comentario1 = new Comentarios(antia.getName(), Utils.obtenerFechaActual(),"Yo también quiero" );
        Comentarios comentario2 = new Comentarios(jose.getName(), Utils.obtenerFechaActual(), "5 horas...");

        post2.addComentario(comentario1);
        post4.addComentario(comentario2);

    }

    public  void seguirUsuario(Usuario amigo) {
        if (!followList.contains(amigo)) {
            followList.add(amigo);
            System.out.println("Has seguido a " + amigo.getName());
        } else {
            System.out.println("Ya estás siguiendo a " + amigo.getName());
        }
    }



}
