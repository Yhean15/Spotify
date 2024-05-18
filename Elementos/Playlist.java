package Elementos;
import Nodo.Songs;
import Structures.Stack;
import java.util.Objects;

public class Playlist {
    public String Nombre;
    public Songs head;
    public Stack History = new Stack();




    public Playlist(String nombre){
        this.Nombre=nombre;
    }

    public void InsertSong(Song newSong){
        Songs temp = head;

        if(temp == null){
            temp = new Songs(newSong);
            temp.Next = head;
            head = temp;
        }

        else{

            while(temp.Next!=null){
                temp = temp.Next;
            }
            temp.Next = new Songs(newSong);
        }

    }

    public void PrintP(){
        Songs temp = head;
        if(temp == null){
            System.out.println("La playlist esta vacia");
            return;
        }
        int ciclo = 1;
        while(temp!=null){
            System.out.println("Song N#" + ciclo);
            System.out.println("Nombre: " + temp.Songs.Nombre);
            System.out.println("Autor: " + temp.Songs.Autor);
            System.out.println("Duracion: " + temp.Songs.duracion + " mins");
            System.out.println("=============================");

            temp = temp.Next;
            ciclo++;
        }
    }

    public void DeleteS(String nombre, String autor){
        if(head == null){
            System.out.println("La playlist esta vacia");
            return;
        }

        if(Objects.equals(head.Songs.Nombre, nombre) && Objects.equals(head.Songs.Autor, autor)){
            head = head.Next;
            System.out.println("Se elimino correctamente");
        }
        else{
            Songs prev = null;
            Songs post = head;

            while(post != null){
                if(Objects.equals(post.Songs.Nombre, nombre) && Objects.equals(post.Songs.Autor, autor)){
                 post = post.Next;
                 prev.Next = post;
                 System.out.println("Se elimino correctamente");
                 return;
                }
                prev = post;
                post = post.Next;
            }
            System.out.println("No se encontro la cancion");
        }
    }

    public void Play(){
        if(head == null){
            System.out.println("No hay ninguna cancion en la playlist");
            return;
        }
        System.out.println("Repoduciendo: ");
        System.out.println(head.Songs.Nombre);
        System.out.println("----------------");
        System.out.println(head.Songs.Autor);
        System.out.println("----------------");
        System.out.println(head.Songs.duracion);
        System.out.println("----------------");

        History.PushIn(head.Songs);
        head = head.Next;
    }

    public void History(){
        if(History.Empty()){
            System.out.println("No se ha reproducido ninguna cancion");
            return;
        }

        Song temp = History.Pop();
        System.out.println("Ultima cancion");
        System.out.println("==============");
        System.out.println("Nombre: " + temp.Nombre);
        System.out.println("De: " + temp.Autor);
        System.out.println("Duracion: " + temp.duracion);

        Stack tempS = new Stack();
        tempS.PushIn(temp);


        int ciclo = 2;
        while(History.Top != null){
            temp = History.Pop();
            tempS.PushIn(temp);
            System.out.println("Cancion #" + ciclo);
            System.out.println("Nombre: " + temp.Nombre);
            System.out.println("De: " + temp.Autor);
            System.out.println("Duracion: " + temp.duracion);
            System.out.println("===============");

            ciclo++;
        }

        while(tempS.Top != null){
            temp = tempS.Pop();
            History.PushIn(temp);
        }
    }

}
