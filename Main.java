package Biblioteca; //dichiara che la classe fa parte del package Biblioteca
import java.util.Scanner; //importa la classe Scanner per input da tastiera
import java.util.ArrayList; //importa la classe ArrayList per gestire liste dinamiche
import java.util.List; //importa l'interfaccia List

public class Main { //classe principale con il metodo main
    public static void main(String[] args) { //punto di ingresso del programma
        Biblioteca bib = new Biblioteca(); //crea una nuova biblioteca
        Scanner scanner = new Scanner(System.in); //scanner per input utente

        while (true) { //ciclo infinito per il menu
            System.out.println("\nMenu Biblioteca:");
            System.out.println("1. Aggiungi Libro");
            System.out.println("2. Rimuovi Libro");
            System.out.println("3. Cerca Libro per Titolo");
            System.out.println("4. Cerca Libro per Autore");
            System.out.println("5. Visualizza Tutti i Libri");
            System.out.println("6. Presta Libro");
            System.out.println("7. Restituisci Libro");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            String scelta = scanner.nextLine().trim(); //legge la scelta utente

            switch (scelta) { //gestisce le opzioni del menu
                case "1": //aggiungi libro
                    System.out.print("Titolo libro: ");
                    String titolo = scanner.nextLine().trim();
                    System.out.print("Autore: ");
                    String autore = scanner.nextLine().trim();
                    System.out.print("Anno pubblicazione: ");
                    int anno = Integer.parseInt(scanner.nextLine().trim());
                    Libro nuovoLibro = new Libro(titolo, autore, anno);
                    bib.aggiungiLibro(nuovoLibro);
                    System.out.println("Libro aggiunto.");
                    break;
                case "2": //rimuovi libro
                    System.out.print("Titolo libro da rimuovere: ");
                    String titoloRimuovi = scanner.nextLine().trim();
                    if (bib.rimuoviLibro(titoloRimuovi)) {
                        System.out.println("Libro rimosso.");
                    } else {
                        System.out.println("Libro non trovato.");
                    }
                    break;
                case "3": //cerca per titolo
                    System.out.print("Titolo da cercare: ");
                    String titoloCerca = scanner.nextLine().trim();
                    List<Libro> risultatiTitolo = bib.cercaPerTitolo(titoloCerca);
                    if (risultatiTitolo.isEmpty()) {
                        System.out.println("Nessun libro trovato con quel titolo.");
                    } else {
                        System.out.println("Libri trovati: " + risultatiTitolo);
                    }
                    break;
                case "4": //cerca per autore
                    System.out.print("Autore da cercare: ");
                    String autorecerca = scanner.nextLine().trim();
                    List<Libro> risultatiAutore = bib.cercaPerAutore(autorecerca);
                    if (risultatiAutore.isEmpty()) {
                        System.out.println("Nessun libro trovato per quell'autore.");
                    } else {
                        System.out.println("Libri trovati: " + risultatiAutore);
                    }
                    break;
                case "5": //visualizza tutti i libri
                    List<Libro> tuttiLibri = bib.getLibri();
                    if (tuttiLibri.isEmpty()) {
                        System.out.println("Nessun libro presente in biblioteca.");
                    } else {
                        System.out.println("Libri in biblioteca: " + tuttiLibri);
                    }
                    break;
                case "6": //presta libro
                    System.out.print("Titolo del libro da prestare: ");
                    String titoloPresta = scanner.nextLine().trim();
                    System.out.print("Nome del prestatore: ");
                    String prestatore = scanner.nextLine().trim();
                    if (bib.prestaLibro(titoloPresta, prestatore)) {
                        System.out.println("Libro prestato a " + prestatore + ".");
                    } else {
                        System.out.println("Impossibile prestare il libro.");
                    }
                    break;
                case "7": //restituisci libro
                    System.out.print("Titolo del libro da restituire: ");
                    String titoloRestituisci = scanner.nextLine().trim();
                    boolean trovato = false; // variabile per tracciare se il libro è stato trovato
                    for (Libro l : bib.getLibri()) { //cerca il libro da restituire
                        if (l.getTitolo().equalsIgnoreCase(titoloRestituisci)) {
                            if (!l.isDisponibile()) {
                                l.setDisponibile(true);
                                l.setPrestatore(null);
                                System.out.println("Libro restituito.");
                                trovato = true;
                                break;
                            } else {
                                System.out.println("Il libro non era in prestito.");
                                trovato = true;
                                break;
                            }
                        }
                    } // <-- chiusura corretta del ciclo for
                    if (!trovato) {
                        System.out.println("Libro non trovato.");
                    }
                    break;
                case "0": //uscita dal programma
                    System.out.println("Uscita dal programma.");
                    scanner.close();
                    System.exit(0);
                    break;
                default: //opzione non valida
                    System.out.println("Opzione non valida.");
                    break;
            }
        }
    }
}
