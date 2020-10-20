package practica2;


import java.io.FileNotFoundException;
import java.util.*;
/*Practica 1 Lenguajes de programación
 * Juan Camilo Acosta Rojas
 * Juan Andres Gonzales Arias*/


public class main {

    private static String lexema = "";
    private static int colAgregadas = 0;
    /*public static class Token{
        public int fila;
        public int columna;
        public String lexema;

        public Token(int fila, int columna, String lexema) {
            this.fila = fila;
            this.columna = columna;
            this.lexema = lexema;
        }
    }*/
    private static ArrayQueue<Token> colaTokens = new ArrayQueue<Token>();


    public static void crearToken(String lexema, int fila, int columna){
        Token token = new Token(lexema, fila, columna);
        colaTokens.put(token);
    }
    public static  void imprimirCola(){
        while(!colaTokens.isEmpty()){
            Token token = colaTokens.remove();
            System.out.println("<"+token.getLexema()+","+token.getFila() + ","+token.getColumna()+">");
        }
    }

    public static void vaciar(){
        while(!colaTokens.isEmpty()){
            colaTokens.remove();
        }
    }

    public static boolean esDigito(char x) {
        if ((int) x >= 48 && (int) x <= 57) {
            return true;
        }
        return false;
    }

    public static boolean esLetra(char x) {
        if (((int) x >= 97 && (int) x <= 122) || ((int) x >=65 && (int) x <= 90) || x=='_') {
            return true;
        }
        return false;
    }

    public static int deltaFunction(int estado, char c, HashMap<String, String> sim_simple, HashMap<String, String> sim_simple_rechazado, HashMap<String, String> sim_compuesto) {
        int retorno = 0; // -1 = error, 0 = aceptacion
        switch (estado) {
            case 0:
                if (esLetra(c)) {
                    return 1;
                } else if (c == '@') {
                    return 2;
                } else if (sim_simple.containsValue(Character.toString(c))) {
                    lexema += c;
                    return 5;
                } else if (sim_simple_rechazado.containsValue(Character.toString(c))) {
                    lexema += c;
                    return 8;
                } else if (esDigito(c)) {
                    return 10;
                } else {
                    retorno = -1; //error
                }
                break;
            case 1:
                if (esLetra(c) || esDigito(c)) {
                    return 1;
                } else {
                    retorno = 0; //aceptacion
                }
                break;
            case 2:
                if (esLetra(c)) {
                    return 3;
                } else {
                    retorno = -1;
                }
                break;
            case 3:
                if (esLetra(c) || esDigito(c)) {
                    return 3;
                } else {
                    retorno = 4;
                }
                break;
            case 4:
                retorno = 0;
                break;
            case 5:
                if (sim_compuesto.containsValue(lexema + c)) {
                    lexema += c;
                    return 6;
                } else {
                    retorno = 7;
                }
                //
                break;
            case 6:
                lexema = "";
                retorno = 0;
                break;
            case 7:
                lexema = "";
                retorno = 0;
                break;
            case 8:
                if (sim_compuesto.containsValue(lexema + c)) {
                    return 9;
                } else {
                    retorno = -1;
                }
                break;
            case 9:
                lexema = "";
                retorno = 0;
                break;
            case 10:
                if (esDigito(c)) {
                    return 10;
                } else if (c == '.') {
                    return 12;
                } else {
                    retorno = 11;
                }
                break;
            case 11:
                retorno = 0;
                break;
            case 12:
                if (esDigito(c)) {
                    return 13;
                } else {
                    retorno = -1;
                }
                break;
            case 13:
                if (esDigito(c)) {
                    return 13;
                } else {
                    retorno = 14;
                }
                break;
            case 14:
                retorno = 0;
                break;
            default:
                //error

        }
        return retorno;

    }

    public static boolean esPalabraReservada(ArrayList<String> reservadas, String palabra) {
        for (int i = 0; i < reservadas.size(); i++) {
            if (reservadas.get(i).equals(palabra)) {
                return true;
            }
        }
        return false;
    }

    public static void sendError(int fila, int col) {
        System.out.println(">>> Error léxico(línea:" + fila + ",posición:" + col+")");
        vaciar();
        System.exit(0);
    }

    public static String getKey(HashMap<String, String> map, String value) {
        String keyReturn = "";
        for (String key : map.keySet()) {
            if (value.equals(map.get(key))) {
                keyReturn = key;
            }
        }
        return keyReturn;
    }

    public static void makeToken(String cadena, HashMap<String, String> sim_simple, HashMap<String, String> sim_simple_rechazado, HashMap<String, String> sim_compuesto, ArrayList<String> reservadas, int fila) {
        int columna = 0;
        String token = "";
        int ac = 0;
        for (int i = 0; i < cadena.length(); i++) {
            columna= i+1;
            switch(cadena.charAt(i)){
                case ' ':
                    break;
                case '#':
                    i = cadena.length()-1;
                    break;
                default:
                    if(cadena.charAt(i)=='\t' && i<cadena.length()){
                        i++;
                        colAgregadas+=4;
                    }
                    if(i==cadena.length()){
                        colAgregadas = 0;
                        return;
                    }
                    if(cadena.charAt(0)=='\t' && i>1){ // machetazo && i>=12
                        colAgregadas = 0;
                        colAgregadas+=3;
                    }

                    int estado = deltaFunction(0, cadena.charAt(i), sim_simple, sim_simple_rechazado, sim_compuesto);
                    switch (estado) {
                        case 1:
                            token += cadena.charAt(i);
                            ac = i + 1;
                            while (ac < cadena.length() && (deltaFunction(estado, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto) == 1)) {
                                token += cadena.charAt(ac);

                                ac++;
                            }
                            i = ac - 1;
                            if (esPalabraReservada(reservadas, token)) {
                                System.out.println("<" + token + ","+fila+","+(columna+colAgregadas)+">");
                                crearToken(token, fila, (columna+colAgregadas));



                            } else {
                                System.out.println("<id," + token + ","+fila+","+(columna+colAgregadas)+">");
                                crearToken("id,"+ token, fila, (columna+colAgregadas));
                                token = "";
                            }
                            token = "";
                            break;
                        case 2:
                            token += cadena.charAt(i);
                            ac = i + 1;
                            if(ac==cadena.length()){
                                sendError(fila,columna);
                            }
                            if (deltaFunction(estado, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto) == 3) {
                                while (ac < cadena.length() && (deltaFunction(estado + 1, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto) == 3)) {
                                    token += cadena.charAt(ac);
                                    ac++;
                                }
                                i = ac - 1;
                                System.out.println("<fid," + token +","+fila+","+(columna+colAgregadas)+ ">");
                                crearToken("fid,"+token, fila, (columna+colAgregadas));
                                token = "";
                            } else {
                                sendError(fila, columna);
                            }
                            //duda
                            break;
                        case 5:
                            token += cadena.charAt(i);
                            ac = i+ 1;
                            if (ac < cadena.length() && deltaFunction(estado, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto) == 6) {
                                token += cadena.charAt(ac);
                                deltaFunction(estado+1, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto);
                                System.out.println("<" + getKey(sim_compuesto, token) +","+fila+","+(columna+colAgregadas)+ ">");
                                crearToken(getKey(sim_compuesto, token), fila, (columna+colAgregadas));

                            }else if (ac < cadena.length() && deltaFunction(estado, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto) == 7) {
                                deltaFunction(estado+2, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto);
                                System.out.println("<" + getKey(sim_simple, token) +","+fila+","+(columna+colAgregadas)+ ">");
                                crearToken(getKey(sim_simple, token), fila, (columna+colAgregadas));
                                ac--;
                                token="";

                            }else if(ac== cadena.length()){
                                deltaFunction(estado+2, cadena.charAt(ac-1), sim_simple, sim_simple_rechazado, sim_compuesto);
                                System.out.println("<" + getKey(sim_simple, token) + ","+fila+","+(columna+colAgregadas)+">");
                                crearToken(getKey(sim_simple, token), fila, (columna+colAgregadas));
                                i= ac;
                            }else{
                                sendError(fila, columna);
                            }
                            i = ac;
                            token="";
                            break;
                        case 8:
                            token += cadena.charAt(i);
                            ac = i + 1;
                            if (ac < cadena.length() && deltaFunction(estado, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto) == 9) {
                                token += cadena.charAt(ac);
                                deltaFunction(estado+1, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto);
                                System.out.println("<" + getKey(sim_compuesto, token) +","+fila+","+(columna+colAgregadas)+ ">");
                                crearToken(getKey(sim_compuesto, token), fila, (columna+colAgregadas));
                            }else{
                                sendError(fila, columna);
                            }
                            i = ac;
                            token = "";
                            break;
                        case 10:
                            token += cadena.charAt(i);
                            ac = i + 1;
                            if(ac < cadena.length() && deltaFunction(estado, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto) == 10){
                                while (ac < cadena.length() && deltaFunction(estado, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto) == 10) {
                                    token += cadena.charAt(ac);
                                    ac++;
                                }
                                if(ac < cadena.length() && deltaFunction(estado, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto) == 11){
                                    deltaFunction(estado+1, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto);
                                    System.out.println("<tk_num," + token +","+fila+","+(columna+colAgregadas)+ ">");
                                    crearToken("tk_num,"+token, fila, (columna+colAgregadas));
                                    ac--;
                                    i=ac;
                                }else if(ac < cadena.length() && deltaFunction(estado, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto) == 12){
                                    token += cadena.charAt(ac);
                                    //ac--; error .
                                    if(ac+1 < cadena.length() && deltaFunction(estado+2, cadena.charAt(ac+1), sim_simple, sim_simple_rechazado, sim_compuesto) == 13){
                                        deltaFunction(estado+2, cadena.charAt(ac+1), sim_simple, sim_simple_rechazado, sim_compuesto);
                                        token += cadena.charAt(ac+1);
                                        while (ac+2 < cadena.length() && deltaFunction(estado+3, cadena.charAt(ac+2), sim_simple, sim_simple_rechazado, sim_compuesto) == 13) {
                                            token += cadena.charAt(ac+2);
                                            ac++;
                                        }
                                        deltaFunction(estado+4, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto);
                                        System.out.println("<tk_num," + token +","+fila+","+(columna+colAgregadas)+ ">");
                                        crearToken("tk_num,"+token, fila, (columna+colAgregadas));
                                        i=ac+1;
                                    }
                                }else{
                                    System.out.println("<tk_num," + token +","+fila+","+(columna+colAgregadas)+ ">");
                                    crearToken("tk_num,"+token, fila, (columna+colAgregadas));

                                    i=ac-1;
                                }


                            }else if(ac == cadena.length()){
                                System.out.println("<tk_num," + token +","+fila+","+(columna+colAgregadas)+ ">");
                                crearToken("tk_num,"+token, fila, (columna+colAgregadas));

                            }else if(ac < cadena.length() && deltaFunction(estado, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto) == 11){
                                deltaFunction(estado+1, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto);
                                System.out.println("<tk_num," + token +","+fila+","+(columna+colAgregadas)+ ">");
                                crearToken("tk_num,"+token, fila, (columna+colAgregadas));
                                ac--;
                                i=ac;
                            }else if(ac < cadena.length() && deltaFunction(estado, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto) == 12){
                                token += cadena.charAt(ac);

                                if(ac+1 < cadena.length() && deltaFunction(estado+2, cadena.charAt(ac+1), sim_simple, sim_simple_rechazado, sim_compuesto) == 13){
                                    deltaFunction(estado+2, cadena.charAt(ac+1), sim_simple, sim_simple_rechazado, sim_compuesto);
                                    token += cadena.charAt(ac+1);
                                    while (ac+2 < cadena.length() && deltaFunction(estado+3, cadena.charAt(ac+2), sim_simple, sim_simple_rechazado, sim_compuesto) == 13) {
                                        token += cadena.charAt(ac+2);
                                        ac++;
                                    }
                                    deltaFunction(estado+4, cadena.charAt(ac), sim_simple, sim_simple_rechazado, sim_compuesto);
                                    System.out.println("<tk_num," + token +","+fila+","+(columna+colAgregadas)+ ">");
                                    crearToken("tk_num,", fila, (columna+colAgregadas));
                                    i=ac+1;
                                }else{
                                    sendError(fila,columna+1);
                                }

                            }else{
                                sendError(fila, columna-1);


                            }

                            token = "";
                            break;
                        default:
                            sendError(fila, columna);

                    }
                    token="";

            }

        }
        colAgregadas = 0;
    }



    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, String> sim_simple = new HashMap<>();
        HashMap<String, String> sim_simple_rechazado = new HashMap<>();
        HashMap<String, String> sim_compuesto = new HashMap<>();
        ArrayList<String> reservadas = new ArrayList<>();
        // Lista de simbolos simples válidos
        sim_simple.put("tk_mayor", ">");
        sim_simple.put("tk_menor", "<");
        sim_simple.put("tk_llave_izq", "{");
        sim_simple.put("tk_llave_der", "}");
        sim_simple.put("tk_par_izq", "(");
        sim_simple.put("tk_par_der", ")");
        sim_simple.put("tk_mas", "+");
        sim_simple.put("tk_menos", "-");
        sim_simple.put("tk_mul", "*");
        sim_simple.put("tk_div", "/");
        sim_simple.put("tk_mod", "%");
        sim_simple.put("tk_coma", ",");
        sim_simple.put("tk_puntoycoma", ";");
        sim_simple.put("tk_dospuntos", ":");
        //

        //Lista de Simbolos simples invalidos
        sim_simple_rechazado.put("tk_igual", "=");
        sim_simple_rechazado.put("tk_admiración", "!");
        //

        //lista de simbolos compuestos válidos
        sim_compuesto.put("tk_mayor_igual", ">=");
        sim_compuesto.put("tk_menor_igual", "<=");
        sim_compuesto.put("tk_asignacion", ":=");
        sim_compuesto.put("tk_sum_asig", "+=");
        sim_compuesto.put("tk_res_asig", "-=");
        sim_compuesto.put("tk_mul_asig", "*=");
        sim_compuesto.put("tk_div_asig", "/=");
        sim_compuesto.put("tk_mod_asig", "%=");
        sim_compuesto.put("tk_igualdad", "==");
        sim_compuesto.put("tk_diferente", "!=");
        sim_compuesto.put("tk_incremento", "++");
        sim_compuesto.put("tk_decremento", "--");
        //

        //Lista de palabras reservadas
        reservadas.add("function");
        reservadas.add("var");
        reservadas.add("num");
        reservadas.add("bool");
        reservadas.add("true");
        reservadas.add("false");
        reservadas.add("print");
        reservadas.add("input");
        reservadas.add("when");
        reservadas.add("do");
        reservadas.add("if");
        reservadas.add("else");
        reservadas.add("unless");
        reservadas.add("while");
        reservadas.add("return");
        reservadas.add("until");
        reservadas.add("loop");
        reservadas.add("repeat");//duda
        reservadas.add("for");
        reservadas.add("end");
        reservadas.add("next");
        reservadas.add("break");
        reservadas.add("and");
        reservadas.add("or");
        reservadas.add("not");
        Scanner x = new Scanner(System.in);
        //Object linea = x.nextLine();
        //linea != null &&
        Object linea ="";
        int fila = 0;

        while (x.hasNextLine()) {
            fila++;
            linea = x.nextLine();
            if (!linea.equals("")) {
                makeToken(linea.toString(), sim_simple, sim_simple_rechazado, sim_compuesto, reservadas,fila);
            }
        }
        imprimirCola();
        AnalisisSintactico analisis= new AnalisisSintactico(colaTokens);
        analisis.imprimirTokens();

    }

}
