package Biblioteca;

public class Libro { //dichiarazione della classe Libro
    private String titolo; //attributi privati della classe
    private String autore;
    private int anno;
    private boolean disponibile = true; //inizializzo disponibile a true
    private String prestatore;

    public boolean isDisponibile() { //metodo per controllare se il libro e' disponibile
        return disponibile;
    }

    public String getPrestatore() {
        return prestatore;
    }

    public void setPrestatore(String prestatore) {
        this.prestatore = prestatore;
    }
    public void setDisponibile(boolean disponibile) { //metodo per impostare la disponibilita' del libro
        this.disponibile = disponibile;
    }
    public Libro(String titolo, String autore, int anno) { //costruttore della classe Libro
        this.titolo = titolo; //si usa this per distinguere tra attributo e parametro
        this.autore = autore;
        this.anno = anno;
    }

    public String getTitolo() { //prendo il titolo e ottengo il valore
        return titolo;
    }

    public String getAutore() { //prendo l'autore e ottengo il valore
        return autore;
    }

    public int getAnno() { //prendo l'anno e ottengo il valore
        return anno;
    }

    @Override //si usa override per forzare la riscrittura del metodo toString
    public String toString() {
        return "\"" + titolo + "\" di " + autore + " (" + anno + ")";
    }
}

