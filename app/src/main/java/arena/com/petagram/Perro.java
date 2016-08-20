package arena.com.petagram;

/**
 * Created by PC-1 on 19/08/2016.
 */
public class Perro {

    String nombre;
    int likes;
    int imagen;

    public Perro(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes() {this.likes=likes;}


    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void aumentarLikes()
    {
        likes++;
    }
}
