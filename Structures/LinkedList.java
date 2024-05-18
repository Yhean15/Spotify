package Structures;
import Nodo.Playlists;
import Elementos.Playlist;

import java.util.Objects;

public class LinkedList {
    public Playlists head;

    public LinkedList (){}

    public void Insert(Playlist newPlaylist){
        if(head == null){
            Playlists temp = new Playlists(newPlaylist);
            temp.Next = head;
            head = temp;
            return;
        }

        Playlists temp = head;

        while(temp.Next != null){
            temp = temp.Next;
        }

        temp.Next = new Playlists(newPlaylist);
    }

    public void Print(){
        if(head == null){
            System.out.println("No hay ninguna Playlist agregada");
            return;
        }

        Playlists temp = head;

        System.out.println("Playlists: ");
        System.out.println("==========");
        while(temp != null){
            System.out.println(temp.Playlists.Nombre);
            temp = temp.Next;
        }
        System.out.println("===============");
    }

    public void Delete(String nombre){
        if(head == null){
            System.out.println("No hay ninguna playlist creada >:(");
            return;
        }

        if(Objects.equals(head.Playlists.Nombre, nombre)){
            head = head.Next;
            System.out.println("Se elimino correctamente la Playlist: " + nombre);
            return;
        }
        Playlists post = head;
        Playlists prev = null;

        while(post != null){
            if(Objects.equals(post.Playlists.Nombre, nombre)){
                post = post.Next;
                prev.Next = post;

                System.out.println("Se elimino correctamente la Playlist: " + nombre);
            }
            prev = post;
            post = post.Next;
        }
        System.out.println("No se encontro la Playlist " + nombre);
    }

    public Playlist Search(String nombre){
        if(head == null){
            System.out.println("No hay ninguna Playlist");
            return null;
        }
        Playlists temp = head;

        while(temp!=null){
            if(Objects.equals(temp.Playlists.Nombre, nombre)){
                return temp.Playlists;
            }
            temp = temp.Next;
        }
        System.out.println("No se encontro la Playlist");
        return null;
    }
}
