package practica2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class mainPruebas {
    public static void main(String[] args) throws IOException {
        Set<String> tokensPrueba = new HashSet<>();
        tokensPrueba.add("TK_DECREMENTO");
        ArrayQueue<Token> tokens = new ArrayQueue<>();
        Token token = new Token("FUNCTION",1,1);
        tokens.put(token);
        AnalisisSintactico as = new AnalisisSintactico(tokens);
        as.leerGramatica();
        //as.analizar();
        //as.generarFunciones();
        //as.imprimirReglas();
        //as.imprimirPrimeros();
        as.imprimirSiguientes();
        //as.imprimirPredicciones();
        /*Set<String> traducciones = as.traducir(tokensPrueba);
        for(String s: traducciones){
            System.out.println(s);
        }
        */
    }
}
