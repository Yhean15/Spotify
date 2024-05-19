import Elementos.Playlist;
import Nodo.Playlists;
import Structures.LinkedList;
import Elementos.Song;
import java.util.Objects;
import java.util.Scanner;

public class APP {

    public boolean CheckPlaylist(boolean existence){
        if(existence){
            return true;
        }
        return false;
    }

    public boolean OpCheck(String op){
        if(op == "si"){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner Keyboard = new Scanner(System.in);
        LinkedList Playlists = new LinkedList();
        String nombre;
        String op;
        int opt;
        String song;
        String Autor;
        String Album;
        double Duracion;


        do{
            System.out.println("Que deseas realizar?");
            System.out.println("1. Agregar una Playlist");
            System.out.println("2. Eliminar una Playlist");
            System.out.println("3. Ver la lista de Playlists");
            System.out.println("4. Agregar cancion a Playlist");
            System.out.println("5. Eliminar una cancion de una playlist");
            System.out.println("6. Ver las canciones de la Playlist");
            System.out.println("7. Reproducir una Playlist");
            System.out.println("8. Ver historial de reproduccion");
            opt = Keyboard.nextInt();


            switch(opt){

                case 1:
                    System.out.print("Ingrese el nombre de la Playlist: ");
                    nombre = Keyboard.next();
                    Playlist NewPlaylist = new Playlist(nombre);
                    Playlists.Insert(NewPlaylist);
                    break;

                case 2:
                    System.out.print("Ingrese el nombre de la Playlist: ");
                    nombre = Keyboard.next();

                    if(Playlists.Search(nombre) == null){
                        System.out.println("Reintente");
                        break;
                    }

                    Playlists.Delete(nombre);
                    break;

                case 3:
                    Playlists.Print();
                    break;
                case 4:
                        System.out.print("Ingrese el nombre de la playlist a la que quiere agregar la cancion: ");
                        nombre = Keyboard.next();
                        if (Playlists.Search(nombre) == null) {
                            System.out.println("Reintente");
                            break;
                        }

                    System.out.print("Ingrese el nombre de la cancion: ");
                    song = Keyboard.next();

                    System.out.print("Ingrese el artista: ");
                    Autor = Keyboard.next();

                    System.out.print("Ingrese el album de la cancion: ");
                    Album = Keyboard.next();

                    System.out.print("Ingrese la duracion[minutos] de la cancion: ");
                    Duracion = Keyboard.nextDouble();

                    Song temp = new Song(song, Album, Duracion);
                    Playlist tempP = Playlists.Search(nombre);

                    tempP.InsertSong(temp);

                    break;

                case 5:
                    System.out.print("Ingrese el nombre de la Playlist: ");
                    nombre = Keyboard.next();

                    if(Playlists.Search(nombre) == null){
                        System.out.println("Reintente");
                        break;
                    }

                    System.out.print("Ingrese el nombre de la cancion: ");
                    song = Keyboard.next();

                    System.out.print("Ingrese el autor de la cancion: ");
                    Autor = Keyboard.next();

                    tempP = Playlists.Search(nombre);

                    tempP.DeleteS(song, Autor);
                    break;

                case 6:
                    System.out.print("Ingrese el Nombre de la Playlist: ");
                    nombre = Keyboard.next();

                    if(Playlists.Search(nombre) == null){
                        System.out.println("Reintente");
                        break;

                    }

                    tempP = Playlists.Search(nombre);

                    tempP.PrintP();

                    break;

                case 7:
                    System.out.print("Ingrese el nombre de la playlist: ");
                    nombre = Keyboard.next();

                    if(Playlists.Search(nombre) == null){
                        System.out.println("Reintente");
                        break;
                    }

                    tempP = Playlists.Search(nombre);
                    tempP.Play();
                    break;

                case 8:
                    System.out.print("Ingrese el nombre de la Playlist: ");
                    nombre = Keyboard.next();

                    if(Playlists.Search(nombre) == null){
                        System.out.println("Reintente");
                        break;
                    }

                    tempP = Playlists.Search(nombre);

                    tempP.History();
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }



            System.out.println("Deseas realizar otra accion?");
            op = Keyboard.next();
        }while(Objects.equals(op, "si"));
    }

}
