package practica2;

public class Token {
    private String lexema;
    private int fila;
    private int columna;

    public Token(String lexema, int fila, int columna) {
        this.lexema = lexema.toUpperCase();
        this.fila = fila;
        this.columna = columna;
    }

    public String getLexema() {
        return lexema;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}
