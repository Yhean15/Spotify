package Structures;
import Nodo.Songs;
import Elementos.Song;

public class Stack {
    public Songs Top;

    public Stack(){}

    public void PushIn(Song newSong){
            Songs temp = new Songs(newSong);
            temp.Next = Top;
            Top = temp;
    }

    public boolean Empty(){
        if(Top == null){
            return true;
        }
        return false;
    }

    public void Peek(){
        System.out.println("Cancion: " + Top.Songs.Nombre);
        System.out.println("De: " + Top.Songs.Autor);
        System.out.println("Duracion: " + Top.Songs.duracion);
    }

    public Song Pop(){
        if(Top == null){
            return null;
        }

        Song temp;

        temp = Top.Songs;
        Top = Top.Next;
        return temp;
    }
}
