package practica2;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class AnalisisSintactico {
    private ArrayQueue<Token> tokens;
    private File gramatica;
    private FileReader fr;
    private BufferedReader br;
    private ArrayList<Regla> reglas;
    private HashMap<String, String> tablaSimbolos;


    public AnalisisSintactico(ArrayQueue<Token> tokens) throws FileNotFoundException {
        this.tokens = tokens;
        this.gramatica = new File("gramatica.in");
        this.fr = new FileReader(gramatica);
        this.br = new BufferedReader(fr);
        this.reglas = new ArrayList<>();
        this.tablaSimbolos = new HashMap<>();
        this.tablaSimbolos.put("!=","TK_DIFERENTE");
        this.tablaSimbolos.put("%","TK_MOD");
        this.tablaSimbolos.put("%=","TK_MOD_ASIG");
        this.tablaSimbolos.put("(","TK_PAR_IZQ");
        this.tablaSimbolos.put(")","TK_PAR_DER");
        this.tablaSimbolos.put("*","TK_MUL");
        this.tablaSimbolos.put("*=","TK_MUL_ASIG");
        this.tablaSimbolos.put("+","TK_MAS");
        this.tablaSimbolos.put("++","TK_INCREMENTO");
        this.tablaSimbolos.put("+=","TK_SUM_ASIG");
        this.tablaSimbolos.put(",","TK_COMA");
        this.tablaSimbolos.put("-","TK_MENOS");
        this.tablaSimbolos.put("--","TK_DECREMENTO");
        this.tablaSimbolos.put("-=","TK_RES_ASIG");
        this.tablaSimbolos.put("/","TK_DIV");
        this.tablaSimbolos.put("/=","TK_DIV_ASIG");
        this.tablaSimbolos.put(":","TK_DOSPUNTOS");
        this.tablaSimbolos.put(":=","TK_ASIGNACION");
        this.tablaSimbolos.put(";","TK_PUNTOYCOMA");
        this.tablaSimbolos.put("<","TK_MENOR");
        this.tablaSimbolos.put("<=","TK_MENOR_IGUAL");
        this.tablaSimbolos.put("==","TK_IGUALDAD");
        this.tablaSimbolos.put(">","TK_MAYOR");
        this.tablaSimbolos.put(">=","TK_MAYOR_IGUAL");
        this.tablaSimbolos.put("bool","BOOL");
        this.tablaSimbolos.put("end","END");
        this.tablaSimbolos.put("false","FALSE");
        this.tablaSimbolos.put("identificador","ID");
        this.tablaSimbolos.put("identificador de funcion","FID");
        this.tablaSimbolos.put("numero","TK_NUM");
        this.tablaSimbolos.put("true","TRUE");
        this.tablaSimbolos.put("{","TK_LLAVE_IZQ");
        this.tablaSimbolos.put("}","TK_LLAVE_DER");

    }


    public void leerGramatica(){
        try{
            Regla regla = null;
            String noTerminal = "";
            String linea= "";
            while((linea = br.readLine())!=null){
                if(linea.contains(":")){
                    noTerminal = linea.substring(0, linea.length()-1);
                }else if(!linea.equals("")){
                    regla = new Regla(noTerminal, linea);
                    this.reglas.add(regla);
                }
            }
            br.close();
            fr.close();

        }catch(Exception e){

        }finally{

        }
    }

// Reglas de impresion de prueba

    public void imprimirReglas(){
        for(int i=0;i<this.reglas.size();i++){
            System.out.println(this.reglas.get(i).getPar_izq() + " => " + this.reglas.get(i).getPar_der());
        }
        System.out.println(this.reglas.size());
    }

    public void imprimirTokens(){
        while(!this.tokens.isEmpty()){
            Token token = this.tokens.remove();
            System.out.println(token.getLexema());
        }
    }

    public void imprimirPrimeros(){
        for(int i=0;i< this.reglas.size();i++){
            Set<String> primerosRegla = primeros(this.reglas.get(i).getPar_izq());
            System.out.println("Primeros de " + this.reglas.get(i).getPar_izq() + ":");
            for(String p : primerosRegla){
                System.out.println(p);
            }
            System.out.println();
        }
    }

    public void imprimirSiguientes(){
        for(int i=0;i<this.reglas.size();i++){
            Set<String> primerosRegla = siguientes(this.reglas.get(i).getPar_izq());
            System.out.println("Siguientes de " + this.reglas.get(i).getPar_izq() + ":");
            for(String p : primerosRegla){
                System.out.println(p);
            }
            System.out.println();
        }
    }

    public void imprimirPredicciones(){
        for(int i=0;i<this.reglas.size();i++){
            System.out.println("Conjunto de prediccion de " + this.reglas.get(i).getPar_izq() + " => " + this.reglas.get(i).getPar_der());
            Set<String> conPred = prediccion(this.reglas.get(i));
            for(String p : conPred){
                System.out.println(p);
            }
            System.out.println();
        }
    }

// fin
    public void addToken(Token token){
        this.tokens.put(token);
    }



    public ArrayList<String> buscarReglas(String noTerminal){
        ArrayList<String> reglas = new ArrayList<>();
        for(int i=0;i<this.reglas.size();i++){
            if(this.reglas.get(i).getPar_izq().equals(noTerminal)) reglas.add(this.reglas.get(i).getPar_der());
        }
        return reglas;
    }

    public Set<String> primeros(String token){
        ArrayList<String> reglas = buscarReglas(token);
        Set<String> primerosList = new HashSet<>();
        for(int i=0;i<reglas.size();i++){
            StringTokenizer st = new StringTokenizer(reglas.get(i));
            while (st.hasMoreTokens()){
                String primera = st.nextToken();
                if(esTerminal(primera)){
                    primerosList.add(primera);
                    break;
                }else{
                    Set<String> primerosPrimera = primeros(primera);
                    if(perteneceEpsilum(primerosPrimera)){
                        if(st.hasMoreTokens()) primerosPrimera.remove("EPSILUM");
                            primerosList.addAll(primerosPrimera);
                    }else{
                        primerosList.addAll(primerosPrimera);
                        break;
                    }
                }
            }

        }
        return primerosList;
    }

    public Set<String> siguientes(String noTerminal){ // mirar primer simbolo de la gramatica OJO
        Set<String> siguientesSet = new HashSet<>();
        ArrayList<Regla> prod =  apariciones(noTerminal);
        if(noTerminal.equals("prog")) siguientesSet.add("$");
        for(int i=0;i<prod.size();i++){
            String regla = prod.get(i).getPar_der().substring(prod.get(i).getPar_der().indexOf(noTerminal) + noTerminal.length()); // coge el substring desde despues del no terminal
            StringTokenizer linea = new StringTokenizer(regla);
            if(linea.equals(null))siguientes(prod.get(i).getPar_izq()); // comprobar cuando no haya tokens, cuando sea el final de la producicon
            else{
                while(linea.hasMoreTokens()){
                    String primera = linea.nextToken();
                    if(esTerminal(primera)){
                        siguientesSet.add(primera);
                        break;
                    }else{
                        Set<String> primerosPrimera = primeros(primera);
                        if(perteneceEpsilum(primerosPrimera)){
                            primerosPrimera.remove("EPSILUM");
                            siguientesSet.addAll(primerosPrimera);
                            if(!linea.hasMoreTokens()){
                                siguientes(prod.get(i).getPar_izq());
                            }
                        }else{
                            siguientesSet.addAll(primerosPrimera);
                            break;
                        }
                    }
                }
            }

        }
        return siguientesSet;
    }

    public Set<String> prediccion(Regla regla){
        Set<String> predicciones = new HashSet<>();
        StringTokenizer st = new StringTokenizer(regla.getPar_der());
        while(st.hasMoreTokens()){
            String primera = st.nextToken();
            if(esTerminal(primera)){
                predicciones.add(primera);
                break;
            }else{
                Set<String> primerosPrimera = primeros(primera);
                if(perteneceEpsilum(primerosPrimera)) primerosPrimera.remove("EPSILUM");
                predicciones.addAll(primerosPrimera);
                if(!st.hasMoreTokens()) predicciones.addAll(siguientes(regla.getPar_izq()));
            }

        }
        return predicciones;
    }

    public ArrayList<Regla> apariciones(String noTerminal){
        ArrayList<Regla> reglasList = new ArrayList<>();
        for(int i=0;i<this.reglas.size();i++){
            if(this.reglas.get(i).getPar_der().contains(noTerminal)) reglasList.add(this.reglas.get(i));
        }
        return reglasList;
    }

    public boolean esTerminal(String token){
        if(token.equals(token.toUpperCase()) && !token.contains("[") && !token.contains("]")) return true;
        return false;
    }

    public boolean esEpsilum(String token){ // si un String es EPSILUM
        if(token.equals("EPSILUM")) return true;
        return false;
    }

    public boolean perteneceEpsilum(Set<String> primeros){
        for (String primero : primeros) {
            if (esEpsilum(primero)) return true;
        }
        return false;
    }

    public boolean perteneceConjuntoPrediccion(Set<String> conPred, String token){
        for(String p: conPred){
            if(p.equals(token))return true;
        }
        return false;
    }

    public ArrayList<Regla> producciones(String noTerminal){
        ArrayList<Regla> reglasL =new ArrayList<>();
        for(int i=0;i<this.reglas.size();i++){
            if(this.reglas.get(i).getPar_izq().equals(noTerminal))reglasL.add(this.reglas.get(i));
        }
        return reglasL;
    }

    public boolean esta(String s, Set<String> list){
        for(String l: list){
            if(l.equals(s))return true;
        }
        return false;
    }

    public void generarFunciones() throws IOException {
        int ac = 0;
        ArrayList<Regla> reglasList = new ArrayList<>();
        Set<String> reglasAc = new HashSet<>();
        Set<String> conPred = new HashSet<>();
        FileWriter fw = new FileWriter("Generado.java",true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println("class Generado{");
        for(int i=0;i<this.reglas.size();i++){
            if(!esta(this.reglas.get(i).getPar_izq(), reglasAc)){
                reglasAc.add(this.reglas.get(i).getPar_izq());
                reglasList = producciones(this.reglas.get(i).getPar_izq());
                pw.println("    public void "+this.reglas.get(i).getPar_izq()+"(Token token){");
                for(int j=0;j<reglasList.size();j++){
                    conPred= prediccion(reglasList.get(j));
                    if(j<1){
                        pw.print("        if(");
                    }else{
                        pw.print("        else if(");
                    }
                    for(String s: conPred){
                        if(ac == conPred.size()-1){
                            pw.print("token == "+'"'+s+'"');
                            break;
                        }
                        pw.print("token == "+'"'+s+'"'+"||");
                        ac++;
                    }
                    pw.print("){");
                    pw.println();
                    pw.println("        }");
                    ac=0;
                }
            }
        }
        pw.println("}");
        fw.close();
    }

    public void analizar(){
        /*Set<String> tokensEsperados = new HashSet<>();
        if(this.tokens.isEmpty()){
            tokensEsperados.add("END");
            errorSintactico(tokensEsperados, "final del archivo");
        }else {
            int ac=0;
            while(!this.tokens.isEmpty()){
                Regla regla = this.reglas.get(ac);
                Set<String> conPred = prediccion(regla);
                StringTokenizer st = new StringTokenizer(this.reglas.get(ac).getPar_der());
                String primera = st.nextToken();
                if(perteneceConjuntoPrediccion(conPred, this.tokens.getFrontElement().getLexema())){
                    if(esTerminal(primera))emparejar(primera);
                    else{
                        //falta realizar la derivacion cuando no es terminal
                    }
                    // revisar si tiene corchete o parentesis que son los opcionales
                }else{
                    tokensEsperados.addAll(conPred);
                    errorSintactico(tokensEsperados, this.tokens.getFrontElement().getLexema());
                    return;
                }
                ac++;
            }
        }
        */
    }


    public  void emparejar(String tokenEsperado){
        Set<String> tokensEsperados = new HashSet<>();
        if(tokenEsperado.equals(this.tokens.getFrontElement().getLexema())){
            this.tokens.remove();
        }else{
            tokensEsperados.add(this.tokens.getFrontElement().getLexema());
            errorSintactico(tokensEsperados, this.tokens.getFrontElement().getLexema());
        }
    }

    public String getKey(String value) {
        String keyReturn = "";
        for (String key : this.tablaSimbolos.keySet()) {
            if (value.equals(this.tablaSimbolos.get(key))) {
                keyReturn = key;
            }
        }
        return keyReturn;
    }

    public Set<String> traducir(Set<String> tokensEsperados){
        Set<String> valores = new HashSet<>();
        for(String token: tokensEsperados){
            for(String v: this.tablaSimbolos.values()){
                if(v.equals(token)) valores.add(getKey(v));
            }

        }
        return valores;
    }

    public void errorSintactico(Set<String> tokensEsperados, String tokenLeido){
        Set<String> valoresTokens = traducir(tokensEsperados);
        System.out.print("<"+this.tokens.getFrontElement().getFila()+":"+this.tokens.getFrontElement().getColumna()+"> Error sintatico: se encontro: '" + tokenLeido+"';se esperaba:");
        for(String v: valoresTokens){
            System.out.print(v);
        }
    }

}
