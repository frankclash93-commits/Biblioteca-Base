package Biblioteca; //dichiara che la classe fa parte del package Biblioteca

import java.util.ArrayList; //importa la classe ArrayList per gestire liste dinamiche
import java.util.List; //importa l'interfaccia List

public class Biblioteca { //dichiarazione della classe Biblioteca
    private List<Libro> libri; //lista privata di oggetti Libro
    

    public Biblioteca() { //costruttore della classe Biblioteca pubblico
        this.libri = new ArrayList<>(); //inizializza la lista dei libri come ArrayList vuoto
    }

    public void aggiungiLibro(Libro libro) { //metodo per aggiungere un libro alla lista
        libri.add(libro); //aggiunge il libro passato come parametro alla lista
    }

    public boolean prestaLibro(String titolo, String prestatore) { //metodo per prestare un libro
    for (Libro l : libri) { //cicla tutti i libri nella lista
        if (l.getTitolo().equalsIgnoreCase(titolo)) { //controlla se il titolo corrisponde
            if (l.isDisponibile()) { //controlla se il libro è disponibile
                l.setDisponibile(false); //imposta il libro come non disponibile
                l.setPrestatore(prestatore); //imposta il nome del prestatore
                return true; //prestito riuscito
            } else {
                return false; //libro già in prestito
            }
        }
    }
    return false; //libro non trovato
}
    public boolean rimuoviLibro(String titolo) { //metodo per rimuovere un libro tramite il titolo
        //rimuove tutti i libri che hanno il titolo uguale (ignorando maiuscole/minuscole)
        return libri.removeIf(l -> l.getTitolo().equalsIgnoreCase(titolo));
    }

    public List<Libro> cercaPerTitolo(String titolo) { //metodo per cercare libri tramite una parte del titolo
        List<Libro> risultati = new ArrayList<>(); //crea una lista per i risultati
        for (Libro l : libri) { //cicla tutti i libri nella lista
            //se il titolo del libro contiene la stringa cercata (ignorando maiuscole/minuscole)
            if (l.getTitolo().toLowerCase().contains(titolo.toLowerCase())) {
                risultati.add(l); //aggiunge il libro ai risultati
            }
        }
        return risultati; //restituisce la lista dei risultati
    }

    public List<Libro> cercaPerAutore(String autore) { //metodo per cercare libri tramite una parte del nome autore
        List<Libro> risultati = new ArrayList<>(); //crea una lista per i risultati
        for (Libro l : libri) { //cicla tutti i libri nella lista
            //se l'autore del libro contiene la stringa cercata (ignorando maiuscole/minuscole)
            if (l.getAutore().toLowerCase().contains(autore.toLowerCase())) {
                risultati.add(l); //aggiunge il libro ai risultati
            }
        }
        return risultati; //restituisce la lista dei risultati
    }

    public List<Libro> getLibri() { //metodo per ottenere la lista completa dei libri
        return libri; //restituisce la lista dei libri
    }
}
