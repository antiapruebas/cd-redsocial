package RedSocial;

import java.util.ArrayList;
import java.util.List;


import static RedSocial.Usuario.postList;
import static java.lang.System.exit;

public class DevNet {
    protected static List<String> userList = new ArrayList<>();
    private String username;

    public static void main(String[] args) {
        DevNet devNet = new DevNet();
        Usuario.usuariosEjemplo();
        devNet.home();

    }

    protected void agregarUsuario() {
        String name = Utils.string("Ingrese el nombre del usuario a registrar: ");
        Usuario nuevoUsuario = new Usuario(name);
        Usuario.add(nuevoUsuario);
    }

    protected void borrarUsuario() {
        String name = Utils.string("Indica el nombre del usuario a borrar: ");
        Usuario borrarUsuario = new Usuario(name);
        Usuario.remove(borrarUsuario);
    }

    public void createPost() {

        System.out.println("Elige el tipo de post que vas a publicar:");
        System.out.println("1. Imagen");
        System.out.println("2. Video");
        System.out.println("3. Texto");

        int option = Utils.integer("Seleccione una opción: ");

        String titulo;
        String fecha = Utils.obtenerFechaActual();

        switch (option) {
            case 1:
                titulo = Utils.string("Título de la imagen: ");
                double altura = Utils.real("Altura de la imagen: ");
                double ancho = Utils.real("Ancho de la imagen: ");
                Image image = new Image(titulo, fecha, username, altura, ancho);
                Usuario.addPost(image);
                break;
            case 2:
                titulo = Utils.string("Título del video: ");
                double calidad = Utils.real("Calidad del video: ");
                double duracion = Utils.real("Duración del video: ");
                Video video = new Video(titulo, fecha, username, calidad, duracion);
                Usuario.addPost(video);
                break;
            case 3:
                titulo = Utils.string("Ingrese el título del texto: ");
                String texto = Utils.string("Ingrese el contenido del texto: ");
                Text textoPost = new Text(titulo, fecha, username, texto);
                Usuario.addPost(textoPost);
                break;
            default:
                System.out.println("Eso no se puede publicar. Fuera!!");
                break;
        }
    }

    public void home() {
        System.out.println("Bienvenido a DevNet");
        System.out.println("1. Registro");
        System.out.println("2. Login");
        System.out.println("3. Cerrar");
        int option = Utils.integer("Seleccione una opción: ");
        ;
        switch (option) {
            case 1:
                username = Utils.string("¿Cual sera tu usuario?");
                if (!DevNet.userList.contains(username)) {
                    DevNet.userList.add(username);
                    System.out.println("Usuario " + username + " agregado con éxito.");
                    perfil();
                } else {
                    System.out.println("Este usuario ya existe.");
                    this.home();
                }
                ;
                break;
            case 2:
                this.username = Utils.string("¿Cual es tu usuario?");
                if (DevNet.userList.contains(this.username)) {
                    System.out.println("Inicio de sesión correcto");
                    perfil();
                } else {
                    System.out.println("No existe el usuario. Inténtelo de nuevo");
                    this.home();
                }
                break;
            case 3:
                exit(0);
                break;
            default:
                System.out.println("No es una opción");
                break;
        }
    }

    public void perfil() {
        System.out.println("Ya estás en tu perfil");
        System.out.println("1.Mis posts");
        System.out.println("2 Amigos");
        System.out.println("3.Muro");
        System.out.println("4.Salir");
        int option = Utils.integer("Selecciona una opción: ");
        switch (option) {
            case 1:
                postMenu();
                break;
            case 2:
                System.out.println("Esto es el menú de Amigos que aún no hicimos");
                break;
            case 3:
                menuAmigos();
                perfil();
                break;
            case 4:
                home();
                break;
            default:
                System.out.println("No es una opción válida, prueba otra vez");
                perfil();

        }
    }


    public void postMenu() {
        System.out.println("Qué quieres hacer?");
        System.out.println("1.Publicar un post");
        System.out.println("2. Ver mis posts");
        System.out.println("3. Eliminar un post");
        System.out.println("4.Salir");

        int option = Utils.integer("Selecciona una opción: ");
        switch (option) {
            case 1:
                createPost();
                postMenu();
                break;
            case 2:
                verMisPosts();

                break;
            case 3:
                System.out.println("Esto es eliminar  post que aún no hicimos");
                postMenu();
                break;
            case 4:
                perfil();
                break;
            default:
                System.out.println("No es una opción válida, prueba otra vez");
                postMenu();


        }


    }


    private void verMisPosts() {  //instance of, sirve para ver si pertence a una lista, no me suena que lo hayamos visto pero es lo que encontré para esto
        System.out.println("Mis Posts:");
        for (Post post : postList) {

            if (post.getUserName().equals(username)) {
                System.out.println(post.getTitlePost());
                System.out.println(post.datePost);

                if (post instanceof Text) {
                    Text textoPost = (Text) post;
                    System.out.println(textoPost.getBodyPost());
                } else if (post instanceof Image) {
                    Image imagenPost = (Image) post;
                    System.out.println("Altura: " + imagenPost.getHeight());
                    System.out.println("Ancho: " + imagenPost.getWidth());
                } else if (post instanceof Video) {
                    Video videoPost = (Video) post;
                    String quality = String.valueOf(videoPost.getQuality());
                    String duration = String.valueOf(videoPost.getDuration());
                    System.out.println("Calidad: " + quality);
                    System.out.println("Duración: " + duration);
                }

                int option = Utils.integer("¿Quieres ir a los comentarios? (1: Sí, 2: No): ");
                if (option == 1) {
                    menuComentarios(post);
                }
                int option2 = Utils.integer("¿Quieres eliminar el post? (1: Sí, 2: No): ");
                if (option == 1) { eliminarPost(post);
                    return;
                }

            }
        }
        postMenu();
    }

    public void menuComentarios(Post post) {
        System.out.println("Comentarios");
        System.out.println("1. Ver comentarios");
        System.out.println("2. Crear comentarios");
        System.out.println("3.Salir");

        int option = Utils.integer("Selecciona una opción: ");
        switch (option) {

            case 1:
                verComentarios(post);
                break;
            case 2:
                crearComentario(post);
                break;
            case 3:
                perfil();
                break;
            default:
                System.out.println("No es una opción válida, prueba otra vez");
                postMenu();

        }


    }
    public void verComentarios(Post post) {
        System.out.println("Comentarios de '" + post.getTitlePost() + "':");
        for (String comentario : post.getCommentsList()) {
            System.out.println(comentario);

            System.out.println("Quieres borrar este comentario? 1.Sí 2.No");

            int option = Utils.integer("Selecciona una opción: ");
            if (option == 1) {
                eliminarComentarios(post, comentario);
                return;
            }
    }
   menuComentarios(post);}

    public void crearComentario(Post post) {
        String comentario = Utils.string("Qué quieres comentar");
        String date=Utils.obtenerFechaActual();
        Comentarios comentarios = new Comentarios(username,date, comentario);
        post.addComentario(comentarios);
        System.out.println("Has comentado");

    }

 public void eliminarComentarios(Post post, String comentario){
        post.getCommentsList().remove(comentario);
        System.out.println("Comentario eliminado");

         }
// Esto aún no va
         public void eliminarPost (Post post) {
        postList.remove(post);
        System.out.println("Post eliminado");
        }

     public void menuAmigos(){
         System.out.println("Mis amigos");
         System.out.println("1. Añadir amigos");
         System.out.println("2. Ver mis amigos");
         System.out.println("3.Salir");

         int option = Utils.integer("Selecciona una opción: ");
         switch (option) {

             case 1:
                 System.out.println("Todavía no puedes añadir amigos ");

                 break;
             case 2:
                 System.out.println("Todavía no puedes ver tus amigos");
                 break;
             case 3:
                 perfil();
                 break;
             default:
                 System.out.println("No es una opción válida, prueba otra vez");
                 postMenu();

         }

     }
}




