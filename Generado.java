public void prog(Token token){
    if(token.getLexema().equals("PRINT") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("INPUT") || token.getLexema().equals("REPEAT") || token.getLexema().equals("$") || token.getLexema().equals("LOOP") || token.getLexema().equals("UNLESS") || token.getLexema().equals("FOR") || token.getLexema().equals("DO") || token.getLexema().equals("UNTIL") || token.getLexema().equals("FUNCTION") || token.getLexema().equals("TK_LLAVE_IZQ") || token.getLexema().equals("RETURN") || token.getLexema().equals("WHEN") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("NEXT") || token.getLexema().equals("BREAK") || token.getLexema().equals("TK_END") || token.getLexema().equals("WHILE") || token.getLexema().equals("ID") || token.getLexema().equals("IF")){
        this.tokensEsperados.add("PRINT");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("INPUT");
        this.tokensEsperados.add("REPEAT");
        this.tokensEsperados.add("$");
        this.tokensEsperados.add("LOOP");
        this.tokensEsperados.add("UNLESS");
        this.tokensEsperados.add("FOR");
        this.tokensEsperados.add("DO");
        this.tokensEsperados.add("UNTIL");
        this.tokensEsperados.add("FUNCTION");
        this.tokensEsperados.add("TK_LLAVE_IZQ");
        this.tokensEsperados.add("RETURN");
        this.tokensEsperados.add("WHEN");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("NEXT");
        this.tokensEsperados.add("BREAK");
        this.tokensEsperados.add("TK_END");
        this.tokensEsperados.add("WHILE");
        this.tokensEsperados.add("ID");
        this.tokensEsperados.add("IF");
        f(token);
        main_prog(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void f(Token token){
    if(token.getLexema().equals("PRINT") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("INPUT") || token.getLexema().equals("REPEAT") || token.getLexema().equals("LOOP") || token.getLexema().equals("UNLESS") || token.getLexema().equals("FOR") || token.getLexema().equals("DO") || token.getLexema().equals("UNTIL") || token.getLexema().equals("FUNCTION") || token.getLexema().equals("TK_LLAVE_IZQ") || token.getLexema().equals("RETURN") || token.getLexema().equals("WHEN") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("NEXT") || token.getLexema().equals("BREAK") || token.getLexema().equals("TK_END") || token.getLexema().equals("WHILE") || token.getLexema().equals("ID") || token.getLexema().equals("IF")){
        this.tokensEsperados.add("PRINT");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("INPUT");
        this.tokensEsperados.add("REPEAT");
        this.tokensEsperados.add("LOOP");
        this.tokensEsperados.add("UNLESS");
        this.tokensEsperados.add("FOR");
        this.tokensEsperados.add("DO");
        this.tokensEsperados.add("UNTIL");
        this.tokensEsperados.add("FUNCTION");
        this.tokensEsperados.add("TK_LLAVE_IZQ");
        this.tokensEsperados.add("RETURN");
        this.tokensEsperados.add("WHEN");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("NEXT");
        this.tokensEsperados.add("BREAK");
        this.tokensEsperados.add("TK_END");
        this.tokensEsperados.add("WHILE");
        this.tokensEsperados.add("ID");
        this.tokensEsperados.add("IF");
        fn_decl_list(token);
        f(token);
    }
    else if(token.getLexema().equals("PRINT") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("INPUT") || token.getLexema().equals("REPEAT") || token.getLexema().equals("LOOP") || token.getLexema().equals("UNLESS") || token.getLexema().equals("FOR") || token.getLexema().equals("DO") || token.getLexema().equals("UNTIL") || token.getLexema().equals("TK_LLAVE_IZQ") || token.getLexema().equals("RETURN") || token.getLexema().equals("WHEN") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("NEXT") || token.getLexema().equals("BREAK") || token.getLexema().equals("TK_END") || token.getLexema().equals("WHILE") || token.getLexema().equals("ID") || token.getLexema().equals("IF")){
        this.tokensEsperados.add("PRINT");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("INPUT");
        this.tokensEsperados.add("REPEAT");
        this.tokensEsperados.add("LOOP");
        this.tokensEsperados.add("UNLESS");
        this.tokensEsperados.add("FOR");
        this.tokensEsperados.add("DO");
        this.tokensEsperados.add("UNTIL");
        this.tokensEsperados.add("TK_LLAVE_IZQ");
        this.tokensEsperados.add("RETURN");
        this.tokensEsperados.add("WHEN");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("NEXT");
        this.tokensEsperados.add("BREAK");
        this.tokensEsperados.add("TK_END");
        this.tokensEsperados.add("WHILE");
        this.tokensEsperados.add("ID");
        this.tokensEsperados.add("IF");

    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void fn_decl_list(Token token){
    if(token.getLexema().equals("FUNCTION")){
        this.tokensEsperados.add("FUNCTION");
        emparejarToken("FUNCTION");
        emparejarToken("FID");
        emparejarToken("TK_DOSPUNTOS");
        dataype(token);
        emparejarToken("TK_PAR_IZQ");
        var_decl_op(token);
        emparejarToken("TK_PAR_DER");
        list_var_decl(token);
        stmt_block(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void var_decl_op(Token token){
    if(token.getLexema().equals("PRINT") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("INPUT") || token.getLexema().equals("REPEAT") || token.getLexema().equals("LOOP") || token.getLexema().equals("UNLESS") || token.getLexema().equals("FOR") || token.getLexema().equals("TK_PAR_DER") || token.getLexema().equals("DO") || token.getLexema().equals("UNTIL") || token.getLexema().equals("TK_LLAVE_IZQ") || token.getLexema().equals("RETURN") || token.getLexema().equals("WHEN") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("NEXT") || token.getLexema().equals("BREAK") || token.getLexema().equals("TK_END") || token.getLexema().equals("WHILE") || token.getLexema().equals("ID") || token.getLexema().equals("IF")){
        this.tokensEsperados.add("PRINT");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("INPUT");
        this.tokensEsperados.add("REPEAT");
        this.tokensEsperados.add("LOOP");
        this.tokensEsperados.add("UNLESS");
        this.tokensEsperados.add("FOR");
        this.tokensEsperados.add("TK_PAR_DER");
        this.tokensEsperados.add("DO");
        this.tokensEsperados.add("UNTIL");
        this.tokensEsperados.add("TK_LLAVE_IZQ");
        this.tokensEsperados.add("RETURN");
        this.tokensEsperados.add("WHEN");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("NEXT");
        this.tokensEsperados.add("BREAK");
        this.tokensEsperados.add("TK_END");
        this.tokensEsperados.add("WHILE");
        this.tokensEsperados.add("ID");
        this.tokensEsperados.add("IF");
        var_decl(token);
    }
    else if(token.getLexema().equals("PRINT") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("INPUT") || token.getLexema().equals("REPEAT") || token.getLexema().equals("LOOP") || token.getLexema().equals("UNLESS") || token.getLexema().equals("FOR") || token.getLexema().equals("TK_PAR_DER") || token.getLexema().equals("DO") || token.getLexema().equals("UNTIL") || token.getLexema().equals("TK_LLAVE_IZQ") || token.getLexema().equals("RETURN") || token.getLexema().equals("WHEN") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("NEXT") || token.getLexema().equals("BREAK") || token.getLexema().equals("TK_END") || token.getLexema().equals("WHILE") || token.getLexema().equals("ID") || token.getLexema().equals("IF")){
        this.tokensEsperados.add("PRINT");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("INPUT");
        this.tokensEsperados.add("REPEAT");
        this.tokensEsperados.add("LOOP");
        this.tokensEsperados.add("UNLESS");
        this.tokensEsperados.add("FOR");
        this.tokensEsperados.add("TK_PAR_DER");
        this.tokensEsperados.add("DO");
        this.tokensEsperados.add("UNTIL");
        this.tokensEsperados.add("TK_LLAVE_IZQ");
        this.tokensEsperados.add("RETURN");
        this.tokensEsperados.add("WHEN");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("NEXT");
        this.tokensEsperados.add("BREAK");
        this.tokensEsperados.add("TK_END");
        this.tokensEsperados.add("WHILE");
        this.tokensEsperados.add("ID");
        this.tokensEsperados.add("IF");

    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void list_var_decl(Token token){
    if(token.getLexema().equals("VAR")){
        this.tokensEsperados.add("VAR");
        emparejarToken("VAR");
        var_decl(token);
        emparejarToken("TK_PUNTOYCOMA");
    }
    else if(token.getLexema().equals("PRINT") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("INPUT") || token.getLexema().equals("REPEAT") || token.getLexema().equals("LOOP") || token.getLexema().equals("UNLESS") || token.getLexema().equals("FOR") || token.getLexema().equals("DO") || token.getLexema().equals("UNTIL") || token.getLexema().equals("TK_LLAVE_IZQ") || token.getLexema().equals("RETURN") || token.getLexema().equals("WHEN") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("NEXT") || token.getLexema().equals("BREAK") || token.getLexema().equals("WHILE") || token.getLexema().equals("ID") || token.getLexema().equals("IF")){
        this.tokensEsperados.add("PRINT");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("INPUT");
        this.tokensEsperados.add("REPEAT");
        this.tokensEsperados.add("LOOP");
        this.tokensEsperados.add("UNLESS");
        this.tokensEsperados.add("FOR");
        this.tokensEsperados.add("DO");
        this.tokensEsperados.add("UNTIL");
        this.tokensEsperados.add("TK_LLAVE_IZQ");
        this.tokensEsperados.add("RETURN");
        this.tokensEsperados.add("WHEN");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("NEXT");
        this.tokensEsperados.add("BREAK");
        this.tokensEsperados.add("WHILE");
        this.tokensEsperados.add("ID");
        this.tokensEsperados.add("IF");

    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void main_prog(Token token){
    if(token.getLexema().equals("PRINT") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("INPUT") || token.getLexema().equals("REPEAT") || token.getLexema().equals("LOOP") || token.getLexema().equals("UNLESS") || token.getLexema().equals("FOR") || token.getLexema().equals("DO") || token.getLexema().equals("UNTIL") || token.getLexema().equals("TK_LLAVE_IZQ") || token.getLexema().equals("RETURN") || token.getLexema().equals("WHEN") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("NEXT") || token.getLexema().equals("BREAK") || token.getLexema().equals("TK_END") || token.getLexema().equals("WHILE") || token.getLexema().equals("ID") || token.getLexema().equals("IF")){
        this.tokensEsperados.add("PRINT");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("INPUT");
        this.tokensEsperados.add("REPEAT");
        this.tokensEsperados.add("LOOP");
        this.tokensEsperados.add("UNLESS");
        this.tokensEsperados.add("FOR");
        this.tokensEsperados.add("DO");
        this.tokensEsperados.add("UNTIL");
        this.tokensEsperados.add("TK_LLAVE_IZQ");
        this.tokensEsperados.add("RETURN");
        this.tokensEsperados.add("WHEN");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("NEXT");
        this.tokensEsperados.add("BREAK");
        this.tokensEsperados.add("TK_END");
        this.tokensEsperados.add("WHILE");
        this.tokensEsperados.add("ID");
        this.tokensEsperados.add("IF");
        var_decl_op(token);
        st(token);
        emparejarToken("TK_END");
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void st(Token token){
    if(token.getLexema().equals("PRINT") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("INPUT") || token.getLexema().equals("REPEAT") || token.getLexema().equals("LOOP") || token.getLexema().equals("UNLESS") || token.getLexema().equals("FOR") || token.getLexema().equals("DO") || token.getLexema().equals("UNTIL") || token.getLexema().equals("TK_LLAVE_IZQ") || token.getLexema().equals("FUNCTION") || token.getLexema().equals("RETURN") || token.getLexema().equals("WHEN") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("NEXT") || token.getLexema().equals("BREAK") || token.getLexema().equals("TK_END") || token.getLexema().equals("WHILE") || token.getLexema().equals("ID") || token.getLexema().equals("IF")){
        this.tokensEsperados.add("PRINT");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("INPUT");
        this.tokensEsperados.add("REPEAT");
        this.tokensEsperados.add("LOOP");
        this.tokensEsperados.add("UNLESS");
        this.tokensEsperados.add("FOR");
        this.tokensEsperados.add("DO");
        this.tokensEsperados.add("UNTIL");
        this.tokensEsperados.add("TK_LLAVE_IZQ");
        this.tokensEsperados.add("FUNCTION");
        this.tokensEsperados.add("RETURN");
        this.tokensEsperados.add("WHEN");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("NEXT");
        this.tokensEsperados.add("BREAK");
        this.tokensEsperados.add("TK_END");
        this.tokensEsperados.add("WHILE");
        this.tokensEsperados.add("ID");
        this.tokensEsperados.add("IF");
        stmt_block(token);
        st(token);
    }
    else if(token.getLexema().equals("TK_END") || token.getLexema().equals("FUNCTION")){
        this.tokensEsperados.add("TK_END");
        this.tokensEsperados.add("FUNCTION");

    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void dataype(Token token){
    if(token.getLexema().equals("NUM")){
        this.tokensEsperados.add("NUM");
        emparejarToken("NUM");
    }
    else if(token.getLexema().equals("BOOL")){
        this.tokensEsperados.add("BOOL");
        emparejarToken("BOOL");
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void var_decl(Token token){
    if(token.getLexema().equals("ID")){
        this.tokensEsperados.add("ID");
        emparejarToken("ID");
        emparejarToken("TK_DOSPUNTOS");
        emparejarToken("DATATYPE");
        list_decl(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void list_decl(Token token){
    if(token.getLexema().equals("TK_COMA")){
        this.tokensEsperados.add("TK_COMA");
        emparejarToken("TK_COMA");
        emparejarToken("ID");
        emparejarToken("TK_DOSPUNTOS");
        emparejarToken("DATATYPE");
        list_decl(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void stmt_block(Token token){
    if(token.getLexema().equals("TK_LLAVE_IZQ")){
        this.tokensEsperados.add("TK_LLAVE_IZQ");
        emparejarToken("TK_LLAVE_IZQ");
        stmt(token);
        stm(token);
        emparejarToken("TK_LLAVE_DER");
    }
    else if(token.getLexema().equals("PRINT") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("INPUT") || token.getLexema().equals("REPEAT") || token.getLexema().equals("LOOP") || token.getLexema().equals("UNLESS") || token.getLexema().equals("FOR") || token.getLexema().equals("DO") || token.getLexema().equals("UNTIL") || token.getLexema().equals("TK_LLAVE_IZQ") || token.getLexema().equals("RETURN") || token.getLexema().equals("WHEN") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("NEXT") || token.getLexema().equals("BREAK") || token.getLexema().equals("ELSE") || token.getLexema().equals("WHILE") || token.getLexema().equals("ID") || token.getLexema().equals("IF")){
        this.tokensEsperados.add("PRINT");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("INPUT");
        this.tokensEsperados.add("REPEAT");
        this.tokensEsperados.add("LOOP");
        this.tokensEsperados.add("UNLESS");
        this.tokensEsperados.add("FOR");
        this.tokensEsperados.add("DO");
        this.tokensEsperados.add("UNTIL");
        this.tokensEsperados.add("TK_LLAVE_IZQ");
        this.tokensEsperados.add("RETURN");
        this.tokensEsperados.add("WHEN");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("NEXT");
        this.tokensEsperados.add("BREAK");
        this.tokensEsperados.add("ELSE");
        this.tokensEsperados.add("WHILE");
        this.tokensEsperados.add("ID");
        this.tokensEsperados.add("IF");
        stmt(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void stm(Token token){
    if(token.getLexema().equals("PRINT") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("INPUT") || token.getLexema().equals("REPEAT") || token.getLexema().equals("LOOP") || token.getLexema().equals("UNLESS") || token.getLexema().equals("FOR") || token.getLexema().equals("DO") || token.getLexema().equals("UNTIL") || token.getLexema().equals("RETURN") || token.getLexema().equals("WHEN") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("NEXT") || token.getLexema().equals("BREAK") || token.getLexema().equals("WHILE") || token.getLexema().equals("ID") || token.getLexema().equals("IF")){
        this.tokensEsperados.add("PRINT");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("INPUT");
        this.tokensEsperados.add("REPEAT");
        this.tokensEsperados.add("LOOP");
        this.tokensEsperados.add("UNLESS");
        this.tokensEsperados.add("FOR");
        this.tokensEsperados.add("DO");
        this.tokensEsperados.add("UNTIL");
        this.tokensEsperados.add("RETURN");
        this.tokensEsperados.add("WHEN");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("NEXT");
        this.tokensEsperados.add("BREAK");
        this.tokensEsperados.add("WHILE");
        this.tokensEsperados.add("ID");
        this.tokensEsperados.add("IF");
        stmt(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void stmt(Token token){
    if(token.getLexema().equals("PRINT")){
        this.tokensEsperados.add("PRINT");
        emparejarToken("PRINT");
        lexpr(token);
        emparejarToken("TK_PUNTOYCOMA");
    }
    else if(token.getLexema().equals("INPUT")){
        this.tokensEsperados.add("INPUT");
        emparejarToken("INPUT");
        emparejarToken("ID");
        emparejarToken("TK_PUNTOYCOMA");
    }
    else if(token.getLexema().equals("WHEN")){
        this.tokensEsperados.add("WHEN");
        emparejarToken("WHEN");
        emparejarToken("TK_PAR_IZQ");
        lexpr(token);
        emparejarToken("TK_PAR_DER");
        emparejarToken("DO");
        stmt_block(token);
    }
    else if(token.getLexema().equals("IF")){
        this.tokensEsperados.add("IF");
        emparejarToken("IF");
        lexpr(token);
        emparejarToken("DO");
        stmt_block(token);
        emparejarToken("ELSE");
        stmt_block(token);
    }
    else if(token.getLexema().equals("UNLESS")){
        this.tokensEsperados.add("UNLESS");
        emparejarToken("UNLESS");
        emparejarToken("TK_PAR_IZQ");
        lexpr(token);
        emparejarToken("TK_PAR_DER");
        emparejarToken("DO");
        stmt_block(token);
    }
    else if(token.getLexema().equals("WHILE")){
        this.tokensEsperados.add("WHILE");
        emparejarToken("WHILE");
        emparejarToken("TK_PAR_IZQ");
        lexpr(token);
        emparejarToken("TK_PAR_DER");
        emparejarToken("DO");
        stmt_block(token);
    }
    else if(token.getLexema().equals("RETURN")){
        this.tokensEsperados.add("RETURN");
        emparejarToken("RETURN");
        lexpr(token);
        emparejarToken("TK_PUNTOYCOMA");
    }
    else if(token.getLexema().equals("UNTIL")){
        this.tokensEsperados.add("UNTIL");
        emparejarToken("UNTIL");
        emparejarToken("TK_PAR_IZQ");
        lexpr(token);
        emparejarToken("TK_PAR_DER");
        emparejarToken("DO");
        stmt_block(token);
    }
    else if(token.getLexema().equals("LOOP")){
        this.tokensEsperados.add("LOOP");
        emparejarToken("LOOP");
        stmt_block(token);
    }
    else if(token.getLexema().equals("DO")){
        this.tokensEsperados.add("DO");
        emparejarToken("DO");
        stmt_block(token);
        do_stmt(token);
    }
    else if(token.getLexema().equals("REPEAT")){
        this.tokensEsperados.add("REPEAT");
        emparejarToken("REPEAT");
        emparejarToken("TK_NUM");
        emparejarToken("TK_DOSPUNTOS");
        stmt_block(token);
    }
    else if(token.getLexema().equals("FOR")){
        this.tokensEsperados.add("FOR");
        emparejarToken("FOR");
        emparejarToken("TK_PAR_IZQ");
        lexpr(token);
        emparejarToken("TK_PUNTOYCOMA");
        lexpr(token);
        emparejarToken("TK_PUNTOYCOMA");
        lexpr(token);
        emparejarToken("TK_PAR_DER");
        emparejarToken("TK_DO");
        stmt_block(token);
    }
    else if(token.getLexema().equals("NEXT")){
        this.tokensEsperados.add("NEXT");
        emparejarToken("NEXT");
        emparejarToken("TK_PUNTOYCOMA");
    }
    else if(token.getLexema().equals("BREAK")){
        this.tokensEsperados.add("BREAK");
        emparejarToken("BREAK");
        emparejarToken("TK_PUNTOYCOMA");
    }
    else if(token.getLexema().equals("ID")){
        this.tokensEsperados.add("ID");
        emparejarToken("ID");
        expr(token);
    }
    else if(token.getLexema().equals("TK_DECREMENTO")){
        this.tokensEsperados.add("TK_DECREMENTO");
        emparejarToken("TK_DECREMENTO");
        emparejarToken("ID");
        emparejarToken("TK_PUNTOYCOMA");
    }
    else if(token.getLexema().equals("TK_INCREMENTO")){
        this.tokensEsperados.add("TK_INCREMENTO");
        emparejarToken("TK_INCREMENTO");
        emparejarToken("ID");
        emparejarToken("TK_PUNTOYCOMA");
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void do_stmt(Token token){
    if(token.getLexema().equals("WHILE")){
        this.tokensEsperados.add("WHILE");
        emparejarToken("WHILE");
        emparejarToken("TK_PAR_IZQ");
        lexpr(token);
        emparejarToken("TK_PAR_DER");
    }
    else if(token.getLexema().equals("UNTIL")){
        this.tokensEsperados.add("UNTIL");
        emparejarToken("UNTIL");
        emparejarToken("TK_PAR_IZQ");
        lexpr(token);
        emparejarToken("TK_PAR_DER");
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void expr(Token token){
    if(token.getLexema().equals("TK_ASIGNACION")){
        this.tokensEsperados.add("TK_ASIGNACION");
        emparejarToken("TK_ASIGNACION");
        lexpr(token);
        emparejarToken("TK_PUNTOYCOMA");
    }
    else if(token.getLexema().equals("TK_SUM_ASIG")){
        this.tokensEsperados.add("TK_SUM_ASIG");
        emparejarToken("TK_SUM_ASIG");
        lexpr(token);
        emparejarToken("TK_PUNTOYCOMA");
    }
    else if(token.getLexema().equals("TK_RES_ASIG")){
        this.tokensEsperados.add("TK_RES_ASIG");
        emparejarToken("TK_RES_ASIG");
        lexpr(token);
        emparejarToken("TK_PUNTOYCOMA");
    }
    else if(token.getLexema().equals("TK_MUL_ASIG")){
        this.tokensEsperados.add("TK_MUL_ASIG");
        emparejarToken("TK_MUL_ASIG");
        lexpr(token);
        emparejarToken("TK_PUNTOYCOMA");
    }
    else if(token.getLexema().equals("TK_DIV_ASIG")){
        this.tokensEsperados.add("TK_DIV_ASIG");
        emparejarToken("TK_DIV_ASIG");
        lexpr(token);
        emparejarToken("TK_PUNTOYCOMA");
    }
    else if(token.getLexema().equals("TK_MOD_ASIG")){
        this.tokensEsperados.add("TK_MOD_ASIG");
        emparejarToken("TK_MOD_ASIG");
        lexpr(token);
        emparejarToken("TK_PUNTOYCOMA");
    }
    else if(token.getLexema().equals("TK_INCREMENTO")){
        this.tokensEsperados.add("TK_INCREMENTO");
        emparejarToken("TK_INCREMENTO");
        emparejarToken("TK_PUNTOYCOMA");
    }
    else if(token.getLexema().equals("TK_DECREMENTO")){
        this.tokensEsperados.add("TK_DECREMENTO");
        emparejarToken("TK_DECREMENTO");
        emparejarToken("TK_PUNTOYCOMA");
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void lexpr(Token token){
    if(token.getLexema().equals("FID") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("TK_OR") || token.getLexema().equals("TRUE") || token.getLexema().equals("TK_PAR_DER") || token.getLexema().equals("TK_COMA") || token.getLexema().equals("TK_AND") || token.getLexema().equals("DO") || token.getLexema().equals("TK_NOT") || token.getLexema().equals("TK_PUNTOYCOMA") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("TK_PAR_IZQ") || token.getLexema().equals("TK_NUM") || token.getLexema().equals("FALSE") || token.getLexema().equals("ID")){
        this.tokensEsperados.add("FID");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("TK_OR");
        this.tokensEsperados.add("TRUE");
        this.tokensEsperados.add("TK_PAR_DER");
        this.tokensEsperados.add("TK_COMA");
        this.tokensEsperados.add("TK_AND");
        this.tokensEsperados.add("DO");
        this.tokensEsperados.add("TK_NOT");
        this.tokensEsperados.add("TK_PUNTOYCOMA");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("TK_PAR_IZQ");
        this.tokensEsperados.add("TK_NUM");
        this.tokensEsperados.add("FALSE");
        this.tokensEsperados.add("ID");
        nexpr(token);
        and_or_nexpr(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void and_or_nexpr(Token token){
    if(token.getLexema().equals("TK_AND")){
        this.tokensEsperados.add("TK_AND");
        and_nexpr(token);
    }
    else if(token.getLexema().equals("TK_OR")){
        this.tokensEsperados.add("TK_OR");
        or_nexpr(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void and_nexpr(Token token){
    if(token.getLexema().equals("TK_AND")){
        this.tokensEsperados.add("TK_AND");
        emparejarToken("TK_AND");
        nexpr(token);
        and_nexpr(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void or_nexpr(Token token){
    if(token.getLexema().equals("TK_OR")){
        this.tokensEsperados.add("TK_OR");
        emparejarToken("TK_OR");
        nexpr(token);
        or_nexpr(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void nexpr(Token token){
    if(token.getLexema().equals("TK_NOT")){
        this.tokensEsperados.add("TK_NOT");
        emparejarToken("TK_NOT");
        emparejarToken("TK_PAR_IZQ");
        lexpr(token);
        emparejarToken("TK_PAR_DER");
    }
    else if(token.getLexema().equals("FID") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("TK_PAR_IZQ") || token.getLexema().equals("TK_OR") || token.getLexema().equals("TRUE") || token.getLexema().equals("TK_NUM") || token.getLexema().equals("FALSE") || token.getLexema().equals("ID") || token.getLexema().equals("TK_AND")){
        this.tokensEsperados.add("FID");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("TK_PAR_IZQ");
        this.tokensEsperados.add("TK_OR");
        this.tokensEsperados.add("TRUE");
        this.tokensEsperados.add("TK_NUM");
        this.tokensEsperados.add("FALSE");
        this.tokensEsperados.add("ID");
        this.tokensEsperados.add("TK_AND");
        rexpr(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void rexpr(Token token){
    if(token.getLexema().equals("FID") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("TK_MENOR") || token.getLexema().equals("TK_DIFERENTE") || token.getLexema().equals("TRUE") || token.getLexema().equals("TK_IGUALDAD") || token.getLexema().equals("TK_MAYOR") || token.getLexema().equals("TK_MAYOR_IGUAL") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("TK_MENOR_IGUAL") || token.getLexema().equals("TK_PAR_IZQ") || token.getLexema().equals("TK_NUM") || token.getLexema().equals("FALSE") || token.getLexema().equals("ID")){
        this.tokensEsperados.add("FID");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("TK_MENOR");
        this.tokensEsperados.add("TK_DIFERENTE");
        this.tokensEsperados.add("TRUE");
        this.tokensEsperados.add("TK_IGUALDAD");
        this.tokensEsperados.add("TK_MAYOR");
        this.tokensEsperados.add("TK_MAYOR_IGUAL");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("TK_MENOR_IGUAL");
        this.tokensEsperados.add("TK_PAR_IZQ");
        this.tokensEsperados.add("TK_NUM");
        this.tokensEsperados.add("FALSE");
        this.tokensEsperados.add("ID");
        simple_expr(token);
        op_simple_expr(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void op_simple_expr(Token token){
    if(token.getLexema().equals("TK_MENOR")){
        this.tokensEsperados.add("TK_MENOR");
        emparejarToken("TK_MENOR");
        simple_expr(token);
    }
    else if(token.getLexema().equals("TK_IGUALDAD")){
        this.tokensEsperados.add("TK_IGUALDAD");
        emparejarToken("TK_IGUALDAD");
        simple_expr(token);
    }
    else if(token.getLexema().equals("TK_MENOR_IGUAL")){
        this.tokensEsperados.add("TK_MENOR_IGUAL");
        emparejarToken("TK_MENOR_IGUAL");
        simple_expr(token);
    }
    else if(token.getLexema().equals("TK_MAYOR")){
        this.tokensEsperados.add("TK_MAYOR");
        emparejarToken("TK_MAYOR");
        simple_expr(token);
    }
    else if(token.getLexema().equals("TK_MAYOR_IGUAL")){
        this.tokensEsperados.add("TK_MAYOR_IGUAL");
        emparejarToken("TK_MAYOR_IGUAL");
    }
    else if(token.getLexema().equals("TK_DIFERENTE")){
        this.tokensEsperados.add("TK_DIFERENTE");
        emparejarToken("TK_DIFERENTE");
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void simple_expr(Token token){
    if(token.getLexema().equals("FID") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("TK_MENOR") || token.getLexema().equals("TK_MENOS") || token.getLexema().equals("TK_DIFERENTE") || token.getLexema().equals("TRUE") || token.getLexema().equals("TK_IGUALDAD") || token.getLexema().equals("TK_MAYOR") || token.getLexema().equals("TK_MAYOR_IGUAL") || token.getLexema().equals("TK_MAS") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("TK_MENOR_IGUAL") || token.getLexema().equals("TK_PAR_IZQ") || token.getLexema().equals("TK_NUM") || token.getLexema().equals("FALSE") || token.getLexema().equals("ID")){
        this.tokensEsperados.add("FID");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("TK_MENOR");
        this.tokensEsperados.add("TK_MENOS");
        this.tokensEsperados.add("TK_DIFERENTE");
        this.tokensEsperados.add("TRUE");
        this.tokensEsperados.add("TK_IGUALDAD");
        this.tokensEsperados.add("TK_MAYOR");
        this.tokensEsperados.add("TK_MAYOR_IGUAL");
        this.tokensEsperados.add("TK_MAS");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("TK_MENOR_IGUAL");
        this.tokensEsperados.add("TK_PAR_IZQ");
        this.tokensEsperados.add("TK_NUM");
        this.tokensEsperados.add("FALSE");
        this.tokensEsperados.add("ID");
        term(token);
        mas_menos_term(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void mas_menos_term(Token token){
    if(token.getLexema().equals("TK_MAS")){
        this.tokensEsperados.add("TK_MAS");
        emparejarToken("TK_MAS");
        term(token);
        mas_menos_term(token);
    }
    else if(token.getLexema().equals("TK_MENOS")){
        this.tokensEsperados.add("TK_MENOS");
        emparejarToken("TK_MENOS");
        term(token);
        mas_menos_term(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void term(Token token){
    if(token.getLexema().equals("FID") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("TK_MENOS") || token.getLexema().equals("TRUE") || token.getLexema().equals("TK_DIV") || token.getLexema().equals("TK_MAS") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("TK_PAR_IZQ") || token.getLexema().equals("TK_MUL") || token.getLexema().equals("TK_NUM") || token.getLexema().equals("FALSE") || token.getLexema().equals("ID") || token.getLexema().equals("TK_MOD")){
        this.tokensEsperados.add("FID");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("TK_MENOS");
        this.tokensEsperados.add("TRUE");
        this.tokensEsperados.add("TK_DIV");
        this.tokensEsperados.add("TK_MAS");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("TK_PAR_IZQ");
        this.tokensEsperados.add("TK_MUL");
        this.tokensEsperados.add("TK_NUM");
        this.tokensEsperados.add("FALSE");
        this.tokensEsperados.add("ID");
        this.tokensEsperados.add("TK_MOD");
        factor(token);
        op_factor(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void op_factor(Token token){
    if(token.getLexema().equals("TK_MUL")){
        this.tokensEsperados.add("TK_MUL");
        emparejarToken("TK_MUL");
        factor(token);
        op_factor(token);
    }
    else if(token.getLexema().equals("TK_DIV")){
        this.tokensEsperados.add("TK_DIV");
        emparejarToken("TK_DIV");
        factor(token);
        op_factor(token);
    }
    else if(token.getLexema().equals("TK_MOD")){
        this.tokensEsperados.add("TK_MOD");
        emparejarToken("TK_MOD");
        factor(token);
        op_factor(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void factor(Token token){
    if(token.getLexema().equals("TK_NUM")){
        this.tokensEsperados.add("TK_NUM");
        emparejarToken("TK_NUM");
    }
    else if(token.getLexema().equals("TRUE")){
        this.tokensEsperados.add("TRUE");
        emparejarToken("TRUE");
    }
    else if(token.getLexema().equals("FALSE")){
        this.tokensEsperados.add("FALSE");
        emparejarToken("FALSE");
    }
    else if(token.getLexema().equals("ID")){
        this.tokensEsperados.add("ID");
        emparejarToken("ID");
        incremento_decremento(token);
    }
    else if(token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("ID")){
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("ID");
        incremento_decremento(token);
        emparejarToken("ID");
    }
    else if(token.getLexema().equals("ID")){
        this.tokensEsperados.add("ID");
        emparejarToken("ID");
    }
    else if(token.getLexema().equals("TK_PAR_IZQ")){
        this.tokensEsperados.add("TK_PAR_IZQ");
        emparejarToken("TK_PAR_IZQ");
        lexpr(token);
        emparejarToken("TK_PAR_DER");
    }
    else if(token.getLexema().equals("FID")){
        this.tokensEsperados.add("FID");
        emparejarToken("FID");
        emparejarToken("TK_PAR_IZQ");
        con_lexpr(token);
        emparejarToken("TK_PAR_DER");
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void incremento_decremento(Token token){
    if(token.getLexema().equals("TK_INCREMENTO")){
        this.tokensEsperados.add("TK_INCREMENTO");
        emparejarToken("TK_INCREMENTO");
    }
    else if(token.getLexema().equals("TK_DECREMENTO")){
        this.tokensEsperados.add("TK_DECREMENTO");
        emparejarToken("TK_DECREMENTO");
    }
    else if(token.getLexema().equals("ID")){
        this.tokensEsperados.add("ID");

    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void con_lexpr(Token token){
    if(token.getLexema().equals("FID") || token.getLexema().equals("TK_DECREMENTO") || token.getLexema().equals("TK_INCREMENTO") || token.getLexema().equals("TK_PAR_IZQ") || token.getLexema().equals("TRUE") || token.getLexema().equals("TK_COMA") || token.getLexema().equals("TK_PAR_DER") || token.getLexema().equals("TK_NUM") || token.getLexema().equals("FALSE") || token.getLexema().equals("ID") || token.getLexema().equals("TK_NOT")){
        this.tokensEsperados.add("FID");
        this.tokensEsperados.add("TK_DECREMENTO");
        this.tokensEsperados.add("TK_INCREMENTO");
        this.tokensEsperados.add("TK_PAR_IZQ");
        this.tokensEsperados.add("TRUE");
        this.tokensEsperados.add("TK_COMA");
        this.tokensEsperados.add("TK_PAR_DER");
        this.tokensEsperados.add("TK_NUM");
        this.tokensEsperados.add("FALSE");
        this.tokensEsperados.add("ID");
        this.tokensEsperados.add("TK_NOT");
        lexpr(token);
        coma_lexpr(token);
    }
    else if(token.getLexema().equals("TK_PAR_DER")){
        this.tokensEsperados.add("TK_PAR_DER");

    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
public void coma_lexpr(Token token){
    if(token.getLexema().equals("TK_COMA")){
        this.tokensEsperados.add("TK_COMA");
        emparejarToken("TK_COMA");
        lexpr(token);
        coma_lexpr(token);
    }
    else{
        errorSintacticoToken(tokensEsperados, token.getLexema());
        this.tokensEsperados.clear();
    }
}
