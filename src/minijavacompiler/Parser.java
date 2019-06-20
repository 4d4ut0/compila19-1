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
                                            + ("linha " + lToken.numberLine + ": "+ lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": "+ lToken.name + ",mas espera-se "
                                            + t.name());

                    } else if (t == EnumToken.RELOP) {

                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.ASSIGNMENT) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.ADDOP) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.MULOP) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.UNARYOP) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.INTERGER_LITERAL) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.DOUBLE_LITERAL) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.INT) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.DOUBLE) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.VOID) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.BOOL) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.IF) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.ELSE) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.WHILE) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.TRUE) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.FALSE) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.UNDEF) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.RBRACE) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.LBRACE) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.RPARENT) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.LPARENT) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.RBRACKET) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.LBRACKET) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.COMMA) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.COMMAPOINT) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.RETURN) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
                                            + t.name());
                    } else if (t == EnumToken.EOF) {
                            Erros = Erros
                                            + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + t.name());
                            Erros = (Erros + '\n');

                            System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se "
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

    private void error(String conjunto) 
    {
        Erros = Erros + ("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + conjunto);
        Erros = (Erros + '\n');
        System.err.println("linha " + lToken.numberLine + ": " + lToken.name + ",mas espera-se " + conjunto);
    }

    // 1 - nao precisa
    public void program() 
    {
        System.out.println("Linha 1");
        ClassList();
        //globalTable.imprime();
    }

    //2 - no error
    public void ClassList()
    {
        ClassDecl();
        ClassList_line();
    }

    //3 - epsulon
    public void ClassList_line()
    {
        if(lToken.name == EnumToken.CLASS)
            ClassList();

        //epsolon
    }

    //4 - error_2
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
                error(EnumToken.ID);
            }
        }

        else
        {
            error(EnumToken.CLASS);
        }
    }

    //5 - error_propagado
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
                error(EnumToken.ID);
            }
        }

        else
        {
            ClassBody();
        }
    }

    //6 - error_2
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
                error(EnumToken.RBRACE);
            }
        }
        else
        {
            error(EnumToken.LBRACE);
        }
    }

    //7 - epsulon
    public void VarDeclListOpt()
    {
        if(lToken.name == EnumToken.INT  || lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID)
        {
            VarDeclList();
        }

        //epsulon
    }

    //8 - no error
    public void VarDeclList()
    {
        VarDecl();
        VarDeclList_line();
    }

    //9 - epsulon
    public void VarDeclList_line()
    {
        if(lToken.name == EnumToken.INT  || lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID)
        {
            VarDecl();
            VarDeclList_line();
        }

        //epsulon
    }

    //10 - no error
    public void VarDecl()
    {
        Type();
        VarDecl_line();
    }

    //11 - error_1_4
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
                error(EnumToken.COMMAPOINT);
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
                        error(EnumToken.COMMAPOINT);
                    }
                }
                else
                {
                    error(EnumToken.ID);
                }
            }
            else
            {
                error(EnumToken.RBRACKET);
            }
        }
        else
        {
            error(EnumToken.LBRACKET);
        }
    }

    //12 - epsulon
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
               error(EnumToken.ID);
           }
       }
       
       //epsulon
    }

    //13 - error generico
    public void Type()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        {
            match(lToken.name);
        }
        else
        {
            error("INT ou STRING ou ID");
        }
    }

    //14 - epsulon
    public void ConstructDeclListOpt()
    {
        if(lToken.name == EnumToken.CONSTRUCTOR)
        {
            ConstructDeclList();
        }

        //epsulon
    }

    //15 - no error
    public void ConstructDeclList()
    {
        ConstructDecl();
        ConstructDeclList_line();
    }

    //16 - epsulon
    public void ConstructDeclList_line()
    {
        if(lToken.name == EnumToken.CONSTRUCTOR)
        {
            ConstructDecl();
            ConstructDeclList_line();
        }

        //epsulon
    }

    //17 - error_1
    public void ConstructDecl()
    {
       if(lToken.name == EnumToken.CONSTRUCTOR)
       {
            match(lToken.name);
            MethodBody();
       }
       else
       {
           error(EnumToken.CONSTRUCTOR);
       }
    }

    //18 - epsulon
    public void MethodDeclListOpt()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        {
            MethodDeclList();
        }

        //epsulon
    }

    //19 - error generico
    public void MethodDeclList()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        {
            MethodDecl();
            MethodDeclList_line();
        }

        else
        {
            error("INT ou STRING ou ID");
        }
    }

    //20 - epsulon
    public void MethodDeclList_line()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        {
            MethodDecl();
            MethodDeclList_line();
        }

        //epsulon
    }

    //21 - error generico
    public void MethodDecl()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        {
            Type();
            MethodDecl_line();
        }
        else
        {
            error("INT ou STRING ou ID");
        }
    }

    //22 - error_3
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
                    error(EnumToken.ID);
                }
            }
            else
            {
                error(EnumToken.RBRACKET);
            }
        }
        else
        {
            error(EnumToken.LBRACKET);
        } 
    }

    //23 - error_4
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
                        error(EnumToken.RBRACE);
                    }
                }
                else
                {
                    error(EnumToken.LBRACE);
                }
            }
            else
            {
                error(EnumToken.RPARENT);
            }
        }
        else 
        {
            error(EnumToken.LPARENT);
        }
    }

    //24 - epsulon
    public void ParamListOpt()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        { 
            ParamList();
        }

        //epsulon
    }

    //25 - error generico
    public void ParamList()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        { 
            Param();
            Param_line();
        }
        else
        {
            error("INT ou STRING ou ID");
        }
    }

    //26 - epsulon
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

    //27 - error generico
    public void Param()
    {
        if(lToken.name == EnumToken.INT ||lToken.name == EnumToken.STRING || lToken.name == EnumToken.ID )
        { 
            Type();
            Param_line();
        }
        else
        {
            error("INT ou STRING ou ID");
        }
    }

    //28 - error generico
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
                    error(EnumToken.ID);
                }
            }
            else
            {
                error(EnumToken.RBRACKET);
            }
        }
        else
        {
            error("ID ou [");
        } 
    }

    //29 - epsulon
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

    //30 - no error
    public void Statements()
    {
        Statement();
        Statements_line();
    }

    //31 - epsulon
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

    //32 - ERROR GENERICO
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
                error(EnumToken.COMMAPOINT);
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
                error(EnumToken.COMMAPOINT);
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
                error(EnumToken.COMMAPOINT);
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
                error(EnumToken.COMMAPOINT);
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
                error(EnumToken.COMMAPOINT);
            }
        }

        else if(lToken.name == EnumToken.COMMAPOINT)
        {
            match(lToken.name);
        }

        else
        {
            error("INT ou STRING ou ID ou PRINT ou READ ou RETURN ou SUPER ou IF ou FOR ou BREAK");
        }
    }

    //33 - error_1
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
            error(EnumToken.ATTRIB);
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
            error("+ ou -");
        }
    }

    //35 - error_1
    public void PrintStat()
    {
        if(lToken.name == EnumToken.PRINT)
        {
            match(lToken.name);
            Expression();
        }
        else
        {
            error(EnumToken.PRINT);
        }
    }

    //36 - error_1
    public void ReadStat()
    {
        if(lToken.name == EnumToken.READ)
        {
            match(lToken.name);
            Expression();
        }
        else
        {
            error(EnumToken.READ);
        }
    }

    //37 - error_1
    public void ReturnStat()
    {
        if(lToken.name == EnumToken.RETURN)
        {
            match(lToken.name);
            Expression();
        }
        else
        {
            error(EnumToken.RETURN);
        }
    }

    //38 - error_3
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
                     error(EnumToken.RPARENT);
                 }
            }
            else
            {
                error(EnumToken.LPARENT);
            }
        }
        else
        {
            error(EnumToken.SUPER);
        }
    }

    //39 - error_5
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
                            error(EnumToken.RBRACE);
                        }
                    }
                    else
                    {
                        error(EnumToken.LBRACE);
                    }
                }
                else
                {
                   error(EnumToken.RPARENT);
                }
            }
            else
            {
                error(EnumToken.LPARENT);
            }
        }
        else
        {
            error(EnumToken.IF);
        }
    }

    //40 -error_2 epsulon
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
                    error(EnumToken.RBRACE);
                }
            }
            else
            {
                error(EnumToken.LBRACE);
            }
        }

        //epsulon
    }

    //41 - error_7
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
                                    error(EnumToken.RBRACE);
                                }
                            }
                            else
                            {
                                error(EnumToken.LBRACE);
                            }
                        }
                        else
                        {
                            error(EnumToken.RPARENT);
                        }
                    }
                    else
                    {
                       error(EnumToken.COMMAPOINT);
                    }
                }
                else
                {
                    error(EnumToken.COMMAPOINT);
                }
            }
            else
            {
                error(EnumToken.LPARENT);
            }
        }
        else
        {
            error(EnumToken.FOR);
        }
    }

    //42 - no error
    public void AtribStatOpt()
    {
        if(lToken.name == EnumToken.ID)
        {
            AtribStat();
        }
    }

    //43 - no error
    public void ExpressionOpt()
    {
        if(lToken.name == EnumToken.PLUS || lToken.name == EnumToken.MINUS)
        {
            Expression();
        }
    }

    //44 - error_1
    public void LValue()
    {
        if(lToken.name == EnumToken.ID)
        {
            match(lToken.name);
            LValue_line();
        }
        else
        {
            error(EnumToken.ID);
        }
    }

    //45 - error generico
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
                error(EnumToken.RBRACKET);
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
            error("[ ou . ou = ou * ou / ou % ou + ou - ou RELOP ou ) ou ] ou , ou ;");
        }
    }

    //46 - error_1 epsulon
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
                error(EnumToken.ID);
            }
        }

        //epsulon
    }

    //48 - no error
    public void Expression()
    {
        NumExpression();
        NumExpression_line();
    }

    //49 - epsulon
    public void Expression_line()
    {
        if(lToken.name == EnumToken.RELOP)
        {
            match(lToken.name);
            NumExpression();
        }

        //epsulon
    }

    //50 - error generico
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
                        error(EnumToken.RPARENT);
                    }
                }
                else
                {
                    error(EnumToken.LPARENT);
                }
            }
            else
            {
                error(EnumToken.ID);
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
                    error(EnumToken.RBRACKET);
                }
            }
            else
            {
                error(EnumToken.LBRACKET);
            }
        }
        else
        {
            error("NEW ou INT ou STRING ou ID");
        }
    }

    //51 - no error 
    public void NumExpression()
    {
        Term();
        NumExpression_line();
    }

    //52 - epsulon
    public void NumExpression_line()
    {
        if(lToken.name == EnumToken.PLUS || lToken.name == EnumToken.MINUS || lToken.name == EnumToken.RELOP)
        {
            match(lToken.name);
            Term();
        }

        //epsulon
    }

    //53 - no error
    public void Term()
    {
        UnaryExpression();
        Term_line();
    }

    //54 - epsulon
    public void Term_line()
    {
        if(lToken.name == EnumToken.MULT || lToken.name == EnumToken.DIV || lToken.name == EnumToken.MOD)
        {
            match(lToken.name);
            UnaryExpression();
        }

        //epsulon
    }

    //55 - error generico
    public void UnaryExpression()
    {
        if(lToken.name == EnumToken.PLUS || lToken.name == EnumToken.MINUS)
        {
            match(lToken.name);
            Factor();
        }
        else
        {
            error("+ ou -");
        }
    }

    //56 - error generico
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
                error(EnumToken.RPARENT);
            }
        }
        else
        {
            error("INTEGER_LITERAL ou STRING_LITERAL ou ID ou (");
        }
    }

    //57 - epsulon
    public void ArgListOpt()
    {
        if(lToken.name == EnumToken.PLUS || lToken.name == EnumToken.MINUS)
        {
            ArgList();
        }

        //epsulon
    }

    //58 - no error
    public void ArgList()
    {
        Expression();
        ArgList_line();
    }

    //59 - error_1
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
            error(EnumToken.COMMA);
        }
    }

    //60 - erro generico
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
                error(EnumToken.COMMAPOINT);
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
                        error(EnumToken.COMMAPOINT);
                    }
                }
                else
                {
                    error(EnumToken.ID);
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
                            error(EnumToken.COMMAPOINT);
                        }
                    }
                    else
                    {
                        error(EnumToken.ATTRIB);
                    }

                }
                else
                {
                    error(EnumToken.RBRACKET);
                }
            }
            else
            {
                error("} ou + ou -");
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
                    error(EnumToken.COMMAPOINT);
                }
            }
            else
            {
                error(EnumToken.ATTRIB);
            }
        }
        else
        {
            error("ID ou { ou ,");
        }
    }
}