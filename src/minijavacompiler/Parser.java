package minijavacompiler;

/**
 * 
 * @author Bianca
 */
public class Parser 
{
    private Token lToken;
    private Scanner scanner;
    SymbolTable globalTable;
    // ////////////////////////////////////////////
    private int panicMode = 0;
    public static final int ON = 1;
    public static final int OFF = 0;
    private int endArq = 0;
    public static String Erros;

    // ////////////////////////////////////////////

    public Parser(String inputFileName) 
    {
        globalTable = new SymbolTable<STEntry>();
        scanner = new Scanner(inputFileName, globalTable);
        advance();
    }

    private void advance() 
    {
        if (endArq == 0) 
        {
            lToken = scanner.nextToken(lToken);
            System.out.println("Advance--------------------------------------");
            System.out.println("TOKEN:" + lToken.name);
            System.out.println("ATRIBUTO:" + lToken.attribute);
            System.out.println("LEXEMA:" + lToken.value);
        }

        if (lToken.name == EnumToken.EOF)
            endArq = 1;
    }

    private void previous() 
    {
        lToken = scanner.previousToken();
    }

    private void match(EnumToken t) 
    {
        if (t == lToken.name) 
        {
            advance();
        } 
        else 
        {
            panicMode = ON;
            error(t);
        }
    }

    private boolean addType(Token token, SymbolTable<STEntry> table) 
    {
        if (token.value != null) 
        {
            if (table.add(new STEntry(token, true))) 
            {
                return true;
            }
        }
        return false;
    }

    private String lookupType(Token token, SymbolTable<STEntry> table) 
    {
        token.value = table.busca(token.value);
        return token.value;
    }

    private void error(EnumToken t) 
    {
            if (lToken.name != EnumToken.NULL) 
            {

                    if (t == EnumToken.ID) 
                    {

                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());

                    } else if (t == EnumToken.RELOP) {

                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.ASSIGNMENT) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.ADDOP) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.MULOP) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.UNARYOP) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.INTERGER_LITERAL) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.DOUBLE_LITERAL) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.INT) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.DOUBLE) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.VOID) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.BOOL) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.IF) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.ELSE) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.WHILE) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.TRUE) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.FALSE) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.UNDEF) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.RBRACE) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.LBRACE) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.RPARENT) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.LPARENT) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.RBRACKET) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.LBRACKET) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.COMMA) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.COMMAPOINT) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.RETURN) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.EOF) {
                            Erros = Erros
                                            + ("� " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("� " + lToken.name + ",mas espera-se "
                                            + t.name());
                    }
                    MainWindow.areaParaExibir.setText(Erros);
            } else {
                    Erros = Erros + ("Erro semantico na linha" + lToken.numberLine);
                    Erros = (Erros + '\n');
                    MainWindow.areaParaExibir.setText(Erros);
                    System.err.println("Erro semantico na linha" + lToken.numberLine);
            }

    }

    private void error(String linha) 
    {
            // linha 1
            if (linha.equals("Program")) 
            {

            }
            // linha 2
            else if (linha.equals("ClassList")) 
            {

            }
            // linha 3
            else if (linha.equals("ClassList_line")) 
            {

            }
            // linha 4
            else if (linha.equals("ClassDecl")) 
            {

            }
            // linha 5
            else if (linha.equals("ClassBody_line")) 
            {

            }
            // linha 6
            else if (linha.equals("ClassBody")) 
            {

            }
            // linha 7
            else if (linha.equals("VarDeclListOpt")) 
            {

            }
            // linha 8
            else if (linha.equals("VarDeclList")) 
            {

            }
            // linha 9
            else if (linha.equals("VarDeclList_line")) 
            {

            }
            // linha 10
            else if (linha.equals("VarDecl")) 
            {

            }
            // linha 11
            else if (linha.equals("VarDecl_line")) 
            {

            }
            // linha 12
            else if (linha.equals("VarDeclOpt")) 
            {

            }
            // linha 13
            else if (linha.equals("Type")) 
            {

            }
            // linha 14
            else if (linha.equals("ConstructDeclListOpt")) 
            {

            }
            // linha 15
            else if (linha.equals("ConstructDeclList")) 
            {

            }
            // linha 16
            else if (linha.equals("ConstructDeclList_line")) 
            {

            }
            // linha 17
            else if (linha.equals("ConstructDecl")) 
            {

            }
            // linha 18
            else if (linha.equals("MethodDeclListOpt")) 
            {

            }
            // linha 19
            else if (linha.equals("MethodDeclList")) 
            {

            }
            // linha 20
            else if (linha.equals("MethodDeclList_line")) 
            {

            }
            // linha 21
            else if (linha.equals("MethodDecl")) 
            {

            }
            // linha 22
            else if (linha.equals("MethodDecl_line")) 
            {

            }
            // linha 23
            else if (linha.equals("MethodBody")) 
            {

            }
            // linha 24
            else if (linha.equals("ParamListOpt")) 
            {

            }
            // linha 25
            else if (linha.equals("ParamList")) 
            {

            }
            // linha 26
            else if (linha.equals("ParamList_line")) 
            {

            }
            // linha 27
            else if (linha.equals("Param")) 
            {

            }
            // linha 28
            else if (linha.equals("Param_line")) 
            {

            }
            // linha 29
            else if (linha.equals("StatementsOpt")) 
            {

            }
            // linha 30
            else if (linha.equals("Statements")) 
            {

            }
            // linha 31
            else if (linha.equals("Statements_line")) 
            {

            }
            // linha 32
            else if (linha.equals("Statement")) 
            {

            }
            // linha 33
            else if (linha.equals("AtribStat")) 
            {

            }
            // linha 34
            else if (linha.equals("AtribStat_line")) 
            {

            }
            // linha 35
            else if (linha.equals("PrintStat")) 
            {

            }
            // linha 36
            else if (linha.equals("ReadStat")) 
            {

            }
            // linha 37
            else if (linha.equals("ReturnStat")) 
            {

            }
            // linha 38
            else if (linha.equals("SuperStat")) 
            {

            }
            // linha 39
            else if (linha.equals("IfStat")) 
            {

            }
            // linha 40
            else if (linha.equals("IfStat_line")) 
            {

            }
            // linha 41
            else if (linha.equals("ForStat")) 
            {

            }
            // linha 42
            else if (linha.equals("AtribStatOpt")) 
            {

            }
            // linha 43
            else if (linha.equals("ExpressionOpt")) 
            {

            }
            // linha 44
            else if (linha.equals("LValue")) 
            {

            }
            // linha 45
            else if (linha.equals("LValue_line")) 
            {

            }
            // linha 46
            else if (linha.equals("LValueComp")) 
            {

            }
            // linha 47
            else if (linha.equals("LValueComp_line")) 
            {

            }
            // linha 48
            else if (linha.equals("Expression")) 
            {

            }
            // linha 49
            else if (linha.equals("Expression_line")) 
            {

            }
            // linha 50
            else if (linha.equals("AllocExpression")) 
            {

            }
            // linha 51
            else if (linha.equals("NumExpression")) 
            {

            }
            // linha 52
            else if (linha.equals("NumExpression_line")) 
            {

            }
            // linha 53
            else if (linha.equals("Term")) 
            {

            }
            // linha 54
            else if (linha.equals("Term_line")) 
            {

            }
            // linha 55
            else if (linha.equals("UnaryExpression")) 
            {

            }
            // linha 56
            else if (linha.equals("Factor")) 
            {

            }
            // linha 57
            else if (linha.equals("ArgListOpt")) 
            {

            }
            // linha 58
            else if (linha.equals("ArgList")) 
            {

            }
            // linha 59
            else if (linha.equals("ArgList_line")) 
            {

            }
    }

    // 1 - nao precisa
    public void program() 
    {
        System.out.println("Linha 1");
        ClassList();
        globalTable.imprime();
    }

    //2 -
    public void ClassList()
    {
        ClassDecl();
        ClassList_line();
    }

    //3 -
    public void ClassList_line()
    {
        if(lToken.name == EnumToken.CLASS)
            ClassList();

        //epsolon
    }

    //4 -
    public void ClassDecl()
    {
        if(lToken.name == EnumToken.CLASS)
        {
            match(lToken.name);
            if(lToken.name == EnumToken.ID)
            {
                match(lToken.name);
                ClassBody_line();
            }

            else
            {
                //erro
            }
        }

        else
        {
            //erro
        }
    }

    //5 -
    public void ClassBody_line()
    {
        if(lToken.name == EnumToken.EXTENDS)
        {
            match(lToken.name);
            if(lToken.name == EnumToken.ID)
            {
                match(lToken.name);
                ClassBody();
            }
            else
            {
                //erro
            }
        }

        else
        {
            ClassBody();
        }
    }

    //6 -
    public void ClassBody()
    {
        if(lToken.name == EnumToken.LBRACE)
        {
            match(lToken.name);
            VarDeclListOpt();
            ConstructDeclListOpt();
            MethodDeclListOpt();

            if(lToken.name == EnumToken.RBRACE)
            {
                 match(lToken.name);
            }
            else
            {
                //erro
            }
        }
        else
        {
            //erro
        }
    }

    //7 -
    public void VarDeclListOpt()
    {
        if(lToken.name == EnumToken.INT  || lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID)
        {
            VarDeclList();
        }

        //epsulon
    }

    //8 -
    public void VarDeclList()
    {
        VarDecl();
        VarDeclList_line();
    }

    //9 -
    public void VarDeclList_line()
    {
        if(lToken.name == EnumToken.INT  || lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID)
        {
            VarDecl();
            VarDeclList_line();
        }

        //epsulon
    }

    //10 -
    public void VarDecl()
    {
        Type();
        VarDecl_line();
    }

    //11 -
    public void VarDecl_line()
    {
        if(lToken.name == EnumToken.ID)
        {
            match(lToken.name);
            VarDeclOpt();
            if(lToken.name == EnumToken.COMMAPOINT)
            {
                match(lToken.name);
            }
            else
            {
                //erro
            }
        }

        else if(lToken.name == EnumToken.LBRACKET)
        {
            match(lToken.name);
            if(lToken.name == EnumToken.RBRACKET)
            {
                match(lToken.name);
                if(lToken.name == EnumToken.ID)
                {
                    match(lToken.name);
                    VarDeclOpt();
                    if(lToken.name == EnumToken.COMMAPOINT)
                    {
                        match(lToken.name);
                    }
                    else
                    {
                        //erro
                    }
                }
                else
                {
                    //erro
                }
            }
            else
            {
                //erro
            }
        }
        else
        {
            //erro
        }
    }

    //12 -
    public void VarDeclOpt()
    {
       if(lToken.name == EnumToken.COMMA)
       {
           match(lToken.name);
           if(lToken.name == EnumToken.ID)
           {
               match(lToken.name);
               VarDeclListOpt();
           }
           else
           {
               //erro
           }
       }
    }

    //13 -
    public void Type()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        {
            match(lToken.name);
        }
        else
        {
            //erro
        }
    }

    //14 -
    public void ConstructDeclListOpt()
    {
        if(lToken.name == EnumToken.CONSTRUCTOR)
        {
            ConstructDeclList();
        }

        //epsulon
    }

    //15 -
    public void ConstructDeclList()
    {
        ConstructDecl();
        ConstructDeclList_line();
    }

    //16 -
    public void ConstructDeclList_line()
    {
        if(lToken.name == EnumToken.CONSTRUCTOR)
        {
            ConstructDecl();
            ConstructDeclList_line();
        }

        //epsulon
    }

    //17 -
    public void ConstructDecl()
    {
       if(lToken.name == EnumToken.CONSTRUCTOR)
       {
            match(lToken.name);
            MethodBody();
       }
       else
       {
           //erro
       }
    }

    //18 -
    public void MethodDeclListOpt()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        {
            MethodDeclList();
        }

        //epsulon
    }

    //19 -
    public void MethodDeclList()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        {
            MethodDecl();
            MethodDeclList_line();
        }

        else
        {
            //erro
        }
    }

    //20 -
    public void MethodDeclList_line()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        {
            MethodDecl();
            MethodDeclList_line();
        }

        //epsulon
    }

    //21 -
    public void MethodDecl()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        {
            Type();
            MethodDecl_line();
        }
        else
        {
            //erro
        }
    }

    //22 -
    public void MethodDecl_line()
    {
        if(lToken.name == EnumToken.ID)
        {
            match(lToken.name);
            MethodBody();
        }
        else if(lToken.name == EnumToken.LBRACKET)
        {
            match(lToken.name);
            if(lToken.name == EnumToken.RBRACKET)
            {
                match(lToken.name);
                if(lToken.name == EnumToken.ID)
                {
                    match(lToken.name);
                    MethodBody();
                }
                else
                {
                    //erro
                }
            }
            else
            {
                //erro
            }
        }
        else
        {
            //erro
        } 
    }

    //23 -
    public void MethodBody()
    {
        if(lToken.name == EnumToken.LPARENT)
        {
            match(lToken.name);
            ParamListOpt();
            if(lToken.name == EnumToken.RPARENT)
            {
                match(lToken.name);
                if(lToken.name == EnumToken.LBRACE)
                {
                    match(lToken.name);
                    StatementsOpt();
                    if(lToken.name == EnumToken.RBRACE)
                    {
                        match(lToken.name);
                    }
                    else
                    {
                        //erro
                    }
                }
                else
                {
                    //erro
                }
            }
            else
            {
                //erro
            }
        }
        else 
        {
            //erro
        }
    }

    //24 -
    public void ParamListOpt()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        { 
            ParamList();
        }

        //epsulon
    }

    //25 -
    public void ParamList()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        { 
            Param();
            Param_line();
        }
        else
        {
            //erro
        }
    }

    //26 -
    public void ParamList_line()
    {
        if(lToken.name == EnumToken.COMMA)
        { 
            match(lToken.name);
            Param();
            Param_line();
        }

        //epsulon
    }

    //27 -
    public void Param()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        { 
            Type();
            Param_line();
        }
        else
        {
            //erro
        }
    }

    //28 -
    public void Param_line()
    {
        if(lToken.name == EnumToken.ID)
        {
            match(lToken.name);
        }
        else if(lToken.name == EnumToken.LBRACKET)
        {
            match(lToken.name);
            if(lToken.name == EnumToken.RBRACKET)
            {
                match(lToken.name);
                if(lToken.name == EnumToken.ID)
                {
                    match(lToken.name);
                }
                else
                {
                    //erro
                }
            }
            else
            {
                //erro
            }
        }
        else
        {
            //erro
        } 
    }

    //29 -
    public void StatementsOpt()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING 
                || lToken.name == EnumToken.ID || lToken.name == EnumToken.PRINT 
                || lToken.name == EnumToken.READ || lToken.name == EnumToken.RETURN
                || lToken.name == EnumToken.SUPER || lToken.name == EnumToken.IF
                || lToken.name == EnumToken.FOR || lToken.name == EnumToken.BREAK
                || lToken.name == EnumToken.COMMAPOINT)
        { 
            Statements();
        }

        //epsulon
    }

    //30 -
    public void Statements()
    {
        Statement();
        Statements_line();
    }

    //31 -
    public void Statements_line()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING 
                || lToken.name == EnumToken.ID || lToken.name == EnumToken.PRINT 
                || lToken.name == EnumToken.READ || lToken.name == EnumToken.RETURN
                || lToken.name == EnumToken.SUPER || lToken.name == EnumToken.IF
                || lToken.name == EnumToken.FOR || lToken.name == EnumToken.BREAK
                || lToken.name == EnumToken.COMMAPOINT)
        { 
            Statement();
            Statements_line();
        }

        //epsulon
    }

    //32 -
    public void Statement()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING)
        {
            match(lToken.name);
            VarDecl_line();
            VarDeclList_line();
        }

        else if(lToken.name == EnumToken.ID)
        {
            match(lToken.name);
            Id_line();
        }

        else if(lToken.name == EnumToken.PRINT)
        {
            PrintStat();
            if(lToken.name == EnumToken.COMMAPOINT)
            {
                match(lToken.name);
            }
            else
            {
                //erro
            }
        }

        else if(lToken.name == EnumToken.READ)
        {
            ReadStat();
            if(lToken.name == EnumToken.COMMAPOINT)
            {
                match(lToken.name);
            }
            else
            {
                //erro
            }
        }

        else if(lToken.name == EnumToken.RETURN)
        {
            ReturnStat();
            if(lToken.name == EnumToken.COMMAPOINT)
            {
                match(lToken.name);
            }
            else
            {
                //erro
            }
        }

        else if(lToken.name == EnumToken.SUPER)
        {
            SuperStat();
            if(lToken.name == EnumToken.COMMAPOINT)
            {
                match(lToken.name);
            }
            else
            {
                //erro
            }
        }

        else if(lToken.name == EnumToken.IF)
        {
            IfStat();
        }

        else if(lToken.name == EnumToken.FOR)
        {
            ForStat();
        }

        else if(lToken.name == EnumToken.BREAK)
        {
            match(lToken.name);
            if(lToken.name == EnumToken.COMMAPOINT)
            {
                match(lToken.name);
            }
            else
            {
                //erro
            }
        }

        else if(lToken.name == EnumToken.COMMAPOINT)
        {
            match(lToken.name);
        }

        else
        {
            //erro
        }
    }

    //33 -
    public void AtribStat()
    {
        LValue();
        if(lToken.name == EnumToken.ATTRIB)
        {
            match(lToken.name);
            AtribStat_line();
        }
        else
        {
            //erro
        }
    }

    //34 - aqui eu estava com sono e mudei coisas
    public void AtribStat_line()
    {
        if(lToken.name == EnumToken.PLUS ||lToken.name == EnumToken.MINUS)
        {
            Expression();
        }

        else if(lToken.name == EnumToken.NEW)
        {
            AllocExpression();
        }

        else
        {
            //erro
        }
    }

    //35 -
    public void PrintStat()
    {
        if(lToken.name == EnumToken.PRINT)
        {
            match(lToken.name);
            Expression();
        }
        else
        {
            //erro
        }
    }

    //36 -
    public void ReadStat()
    {
        if(lToken.name == EnumToken.READ)
        {
            match(lToken.name);
            Expression();
        }
        else
        {
            //erro
        }
    }

    //37 -
    public void ReturnStat()
    {
        if(lToken.name == EnumToken.RETURN)
        {
            match(lToken.name);
            Expression();
        }
        else
        {
            //erro
        }
    }

    //38 -
    public void SuperStat()
    {
        if(lToken.name == EnumToken.SUPER)
        {
            match(lToken.name);
            if(lToken.name == EnumToken.LPARENT)
            {
                 match(lToken.name);
                 ArgListOpt();
                 if(lToken.name == EnumToken.RPARENT)
                 {
                     match(lToken.name);
                 }
                 else
                 {
                     //erro
                 }
            }
            else
            {
                //erro
            }
        }
        else
        {
            //erro
        }
    }

    //39 -
    public void IfStat()
    {
        if(lToken.name == EnumToken.IF)
        {
            match(lToken.name);
            if(lToken.name == EnumToken.LPARENT)
            {
                match(lToken.name);
                Expression();
                if(lToken.name == EnumToken.RPARENT)
                {
                    match(lToken.name);
                    if(lToken.name == EnumToken.LBRACE)
                    {
                        match(lToken.name);
                        Statements();
                        if(lToken.name == EnumToken.RBRACE)
                        {
                            match(lToken.name);
                            IfStat_line();
                        }
                        else
                        {
                            //erro
                        }
                    }
                    else
                    {
                        //erro
                    }
                }
                else
                {
                    //erro
                }
            }
            else
            {
                //erro
            }
        }
        else
        {
            //erro
        }
    }

    //40 -
    public void IfStat_line()
    {
        if(lToken.name == EnumToken.ELSE)
        {
            match(lToken.name);
            if(lToken.name == EnumToken.LBRACE)
            {
                match(lToken.name);
                Statements();
                if(lToken.name == EnumToken.RBRACE)
                {
                    match(lToken.name);
                }
                else
                {
                    //erro
                }
            }
            else
            {
                //erro
            }
        }

        //epsulon
    }

    //41 -
    public void ForStat()
    {
        if(lToken.name == EnumToken.FOR)
        {
            match(lToken.name);
            if(lToken.name == EnumToken.LPARENT)
            {
                match(lToken.name);
                AtribStatOpt();
                if(lToken.name == EnumToken.COMMAPOINT)
                {
                    match(lToken.name);
                    ExpressionOpt();
                    if(lToken.name == EnumToken.COMMAPOINT)
                    {
                        match(lToken.name);
                        AtribStatOpt();
                        if(lToken.name == EnumToken.RPARENT)
                        {
                            match(lToken.name);
                            if(lToken.name == EnumToken.LBRACE)
                            {
                                match(lToken.name);
                                Statements();
                                if(lToken.name == EnumToken.RBRACE)
                                {
                                    match(lToken.name);
                                }
                                else
                                {
                                    //erro
                                }
                            }
                            else
                            {
                                //erro
                            }
                        }
                        else
                        {
                            //erro
                        }
                    }
                    else
                    {
                         //erro
                    }
                }
                else
                {
                    //erro
                }
            }
            else
            {
                //erro
            }
        }
        else
        {
            //erro
        }
    }

    //42 -
    public void AtribStatOpt()
    {
        if(lToken.name == EnumToken.ID)
        {
            AtribStat();
        }
    }

    //43 -
    public void ExpressionOpt()
    {
        if(lToken.name == EnumToken.PLUS || lToken.name == EnumToken.MINUS)
        {
            Expression();
        }
    }

    //44 -
    public void LValue()
    {
        if(lToken.name == EnumToken.ID)
        {
            match(lToken.name);
            LValue_line();
        }
        else
        {
            //erro
        }
    }

    //45 -
    public void LValue_line()
    {
        if(lToken.name == EnumToken.LBRACKET)
        {
            match(lToken.name);
            Expression();
            if(lToken.name == EnumToken.RBRACKET)
            {
                match(lToken.name);
                LValueComp();
            }
            else
            {
                //erro
            }
        }
        else if(lToken.name == EnumToken.POINT || lToken.name == EnumToken.ATTRIB ||
                lToken.name == EnumToken.MULT || lToken.name == EnumToken.DIV ||
                lToken.name == EnumToken.MOD || lToken.name == EnumToken.PLUS ||
                lToken.name == EnumToken.MINUS || lToken.name == EnumToken.RELOP ||
                lToken.name == EnumToken.RPARENT || lToken.name == EnumToken.RBRACKET ||
                lToken.name == EnumToken.COMMA || lToken.name == EnumToken.COMMAPOINT)
        {
            LValueComp();
        }
        else
        {
            //erro
        }
    }

    //46 -
    public void LValueComp()
    {
        if(lToken.name == EnumToken.POINT)
        {
            match(lToken.name);
            if(lToken.name == EnumToken.ID)
            {
                match(lToken.name);
                LValue_line();
            }
            else
            {
                //erro
            }
        }

        //epsulon
    }

    //47 -
    /*public void LValueComp_line()
    {

    }*/

    //48 -
    public void Expression()
    {
        NumExpression();
        NumExpression_line();
    }

    //49 -
    public void Expression_line()
    {
        if(lToken.name == EnumToken.RELOP)
        {
            match(lToken.name);
            NumExpression();
        }

        //epsulon
    }

    //50 -
    public void AllocExpression()
    {
        if(lToken.name == EnumToken.NEW)
        {
            match(lToken.name);
            if(lToken.name == EnumToken.ID)
            {
                match(lToken.name);
                if(lToken.name == EnumToken.LPARENT)
                {
                    match(lToken.name);
                    ArgListOpt();
                    if(lToken.name == EnumToken.RPARENT)
                    {
                        match(lToken.name);
                    }
                    else
                    {
                        //erro
                    }
                }
                else
                {
                    //erro
                }
            }
            else
            {
                //erro
            }
        }
        else if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        {
            Type();
            if(lToken.name == EnumToken.LBRACKET)
            {
                match(lToken.name);
                Expression(); 
                if(lToken.name == EnumToken.RBRACKET)
                {
                    match(lToken.name);
                }
                else
                {
                    //erro
                }
            }
            else
            {
                //erro
            }
        }
        else
        {

        }
    }

    //51 -
    public void NumExpression()
    {
        Term();
        NumExpression_line();
    }

    //52 -
    public void NumExpression_line()
    {
        if(lToken.name == EnumToken.PLUS || lToken.name == EnumToken.MINUS || lToken.name == EnumToken.RELOP)
        {
            match(lToken.name);
            Term();
        }

        //epsulon
    }

    //53 -
    public void Term()
    {
        UnaryExpression();
        Term_line();
    }

    //54 -
    public void Term_line()
    {
        if(lToken.name == EnumToken.MULT || lToken.name == EnumToken.DIV || lToken.name == EnumToken.MOD)
        {
            match(lToken.name);
            UnaryExpression();
        }

        //epsulon
    }

    //55 -
    public void UnaryExpression()
    {
        if(lToken.name == EnumToken.PLUS || lToken.name == EnumToken.MINUS)
        {
            match(lToken.name);
            Factor();
        }
        else
        {
            //erro
        }
    }

    //56 -
    public void Factor()
    {
        if(lToken.name == EnumToken.INTERGER_LITERAL || lToken.name == EnumToken.STRING_LITERAL)
        {
            match(lToken.name);
        }
        else if(lToken.name == EnumToken.ID)
        {
            LValue();
        }
        else if(lToken.name == EnumToken.LPARENT)
        {
            match(lToken.name);
            Expression();
            if(lToken.name == EnumToken.RPARENT)
            {
                match(lToken.name);
            }
            else
            {
                //erro
            }
        }
        else
        {
            //erro
        }
    }

    //57 -
    public void ArgListOpt()
    {
        if(lToken.name == EnumToken.PLUS || lToken.name == EnumToken.MINUS)
        {
            ArgList();
        }

        //epsulon
    }

    //58 -
    public void ArgList()
    {
        Expression();
        ArgList_line();
    }

    //59 -
    public void ArgList_line()
    {
        if(lToken.name == EnumToken.COMMA)
        {
            match(lToken.name);
            Expression();
            ArgList_line();
        }
        else
        {
            //erro
        }
    }

    //60 -
    public void Id_line()
    {
        if(lToken.name == EnumToken.ID)
        {
            match(lToken.name);
            VarDeclOpt();
            if(lToken.name == EnumToken.COMMAPOINT)
            {
                 match(lToken.name);
                 VarDeclList_line();
            }
            else
            {
                //erro
            }
        }
        else if(lToken.name == EnumToken.LBRACKET)
        {
            match(lToken.name);
            if(lToken.name == EnumToken.RBRACKET)
            {
                match(lToken.name);
                if(lToken.name == EnumToken.ID)
                {
                    match(lToken.name);
                    VarDeclListOpt();
                    if(lToken.name == EnumToken.COMMAPOINT)
                    {
                        match(lToken.name);
                        VarDeclList_line();
                    }
                    else
                    {
                        //erro
                    }
                }
                else
                {
                    //erro
                }
            }
            else if(lToken.name == EnumToken.PLUS ||lToken.name == EnumToken.MINUS)
            {
                Expression();
                if(lToken.name == EnumToken.RBRACKET)
                {
                    match(lToken.name);
                    LValueComp();
                    if(lToken.name == EnumToken.ATTRIB)
                    {
                        match(lToken.name);
                        AtribStat_line();
                        if(lToken.name == EnumToken.COMMAPOINT)
                        {
                            match(lToken.name);
                        }
                        else
                        {
                            //erro
                        }
                    }
                    else
                    {
                        //erro
                    }

                }
                else
                {
                    //erro
                }
            }
            else
            {
                //erro
            }
        }
        else if(lToken.name == EnumToken.COMMA)
        {
            LValueComp();
            if(lToken.name == EnumToken.ATTRIB)
            {
                match(lToken.name);
                AtribStat_line();
                if(lToken.name == EnumToken.COMMAPOINT)
                {
                   match(lToken.name);
                }
                else
                {
                    //erro
                }
            }
            else
            {
                //erro
            }
        }
        else
        {
            //erro
        }
    }
}