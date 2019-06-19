package minijavacompiler;

/**
 * 
 * @author Bianca
 */
public class ParserBackUp 
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

	public ParserBackUp(String inputFileName) 
        {
            globalTable = new SymbolTable<STEntry>();
            scanner = new Scanner(inputFileName, globalTable);
            advance();
	}

	private void advance() {
		if (endArq == 0) 
                {
                    lToken = scanner.nextToken(lToken);
                    System.out.println("--------------------------------------");
                    System.out.println("Advance");
                    System.out.println("TOKEN:" + lToken.name);
                    System.out.println("LEXEMA:" + lToken.attribute);
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

	private void error(EnumToken t) {
		if (lToken.name != EnumToken.NULL) {

			if (t == EnumToken.ID) {

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

	private void error(String linha) {
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
	public void program() {
		System.out.println("Linha 1");
		declarationList();
		globalTable.imprime();
	}

        
	// 2 - nao precisa
	private void declarationList() {
		System.out.println("Linha 2");

		System.out.println("Entrou no declaration");
		declaration();
		System.out.println("Saiu do declaration ");

		System.out.println("Entrou no dec ");
		dec();
		System.out.println("Saiu do dec");
	}

	// 3 - diferente
	private void dec() {
		System.out.println("Linha 3");
		if (lToken.name == EnumToken.INT || lToken.name == EnumToken.VOID
				|| lToken.name == EnumToken.BOOL
				|| lToken.name == EnumToken.DOUBLE) {
			System.out.println("Entrou no declaration ");
			declaration();
			System.out.println("Saiu do declaration ");

			System.out.println("entrou no dec ");
			dec();
			System.out.println("saiu do dec ");
		} else if (lToken.name == EnumToken.EOF) {
			return;
		} else {
			match(EnumToken.INT);
			match(EnumToken.VOID);
			match(EnumToken.BOOL);
			match(EnumToken.DOUBLE);
			match(EnumToken.EOF);
			while (lToken.name != EnumToken.BOOL
					&& lToken.name != EnumToken.VOID
					&& lToken.name != EnumToken.DOUBLE
					&& lToken.name != EnumToken.INT
					&& lToken.name != EnumToken.EOF) {
				advance();
			}
			if (lToken.name == EnumToken.INT || lToken.name == EnumToken.VOID
					|| lToken.name == EnumToken.BOOL
					|| lToken.name == EnumToken.DOUBLE) {
				System.out.println("Entrou no declaration ");
				declaration();
				System.out.println("Saiu do declaration ");

				System.out.println("entrou no dec ");
				dec();
				System.out.println("saiu do dec ");
			} else if (lToken.name == EnumToken.EOF) {
				return;
			}
		}

	}

	// 4 - panicada
	private void declaration() {
		Token simpleId;
		System.out.println("Linha 4");
		System.out.println("Entrou no type");
		type();
		/*
		 * if(lToken.inTable == false){
		 * System.out.println("-----------------Erro Semantico BIXoOoOoOoOoOoO"
		 * ); System.out.println(lToken.numberLine);
		 * System.out.println(lToken.name); System.out.println(lToken.inTable);
		 * System.out.println(lToken.attribute); }
		 */
		simpleId = lToken;
		System.out.println("Saiu do type");
		match(EnumToken.ID);
		if (panicMode == ON) {
			while (lToken.name != EnumToken.BOOL
					&& lToken.name != EnumToken.VOID
					&& lToken.name != EnumToken.DOUBLE
					&& lToken.name != EnumToken.INT
					&& lToken.name != EnumToken.EOF) {
				advance();
			}
			panicMode = OFF;
			return;
		}
		System.out.println("Entrou no var");
		if (lToken.name == EnumToken.LBRACKET) {
			var();
			simpleId.isItArray = true;
		} else if (lToken.name == EnumToken.LPARENT) {
			var();

		}

		var();
		System.out.println("Saiu do var");
	}

	// 5 - panicada
	private void var() {
		System.out.println("Linha 5");

		if (lToken.name == EnumToken.COMMAPOINT) {
			match(EnumToken.COMMAPOINT);
			return;
		}

		else if (lToken.name == EnumToken.LBRACKET) {
			match(EnumToken.LBRACKET);

			if (lToken.name == EnumToken.INTERGER_LITERAL) {
				match(EnumToken.INTERGER_LITERAL);

				if (lToken.name == EnumToken.RBRACKET) {
					match(EnumToken.RBRACKET);

					if (lToken.name == EnumToken.COMMAPOINT) {
						match(EnumToken.COMMAPOINT);
					} else {
						match(EnumToken.COMMAPOINT);
						if (panicMode == ON) {
							while (lToken.name != EnumToken.EOF
									&& lToken.name != EnumToken.INT
									&& lToken.name != EnumToken.BOOL
									&& lToken.name != EnumToken.VOID
									&& lToken.name != EnumToken.DOUBLE
									&& lToken.name != EnumToken.INTERGER_LITERAL) {
								advance();
							}
							panicMode = OFF;
							return;
						}
					}

				} else {
					match(EnumToken.RBRACKET);
					if (panicMode == ON) {
						while (lToken.name != EnumToken.EOF
								&& lToken.name != EnumToken.INT
								&& lToken.name != EnumToken.BOOL
								&& lToken.name != EnumToken.VOID
								&& lToken.name != EnumToken.DOUBLE
								&& lToken.name != EnumToken.INTERGER_LITERAL) {
							advance();
						}
						panicMode = OFF;
						return;
					}
				}

			} else {
				match(EnumToken.INTERGER_LITERAL);
				if (panicMode == ON) {
					while (lToken.name != EnumToken.EOF
							&& lToken.name != EnumToken.INT
							&& lToken.name != EnumToken.BOOL
							&& lToken.name != EnumToken.VOID
							&& lToken.name != EnumToken.DOUBLE
							&& lToken.name != EnumToken.INTERGER_LITERAL) {
						advance();
					}
					panicMode = OFF;
					return;
				}
			}

		}

		else if (lToken.name == EnumToken.LPARENT) {
			match(EnumToken.LPARENT);
			System.out.println("Entrou no parameters");
			parameters();
			System.out.println("saiu do parameters");

			if (lToken.name == EnumToken.RPARENT) {
				match(EnumToken.RPARENT);
				System.out.println("Entrou no block");
				block();
				System.out.println("SAiu do block");
			} else {
				match(EnumToken.RPARENT);
				if (panicMode == ON) {
					while (lToken.name != EnumToken.EOF
							&& lToken.name != EnumToken.INT
							&& lToken.name != EnumToken.BOOL
							&& lToken.name != EnumToken.VOID
							&& lToken.name != EnumToken.DOUBLE
							&& lToken.name != EnumToken.INTERGER_LITERAL) {
						advance();
					}
					panicMode = OFF;
					return;
				}
			}

		}

		else {
			// forcar erro
			match(EnumToken.COMMAPOINT);
			match(EnumToken.LPARENT);
			match(EnumToken.LBRACKET);

			if (panicMode == ON) {
				while (lToken.name != EnumToken.EOF
						&& lToken.name != EnumToken.INT
						&& lToken.name != EnumToken.BOOL
						&& lToken.name != EnumToken.VOID
						&& lToken.name != EnumToken.DOUBLE
						&& lToken.name != EnumToken.INTERGER_LITERAL) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 6 - panicada
	private void type() {
		System.out.println("Linha 6");
		if (lToken.name == EnumToken.INT) {
			match(EnumToken.INT);
		} else if (lToken.name == EnumToken.DOUBLE) {
			match(EnumToken.DOUBLE);
		} else if (lToken.name == EnumToken.VOID) {
			match(EnumToken.VOID);
		} else if (lToken.name == EnumToken.BOOL) {
			match(EnumToken.BOOL);
		}

		// forcar erro
		else {
			match(EnumToken.INT);
			match(EnumToken.DOUBLE);
			match(EnumToken.VOID);
			match(EnumToken.BOOL);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.ID
						&& lToken.name != EnumToken.COMMA
						&& lToken.name != EnumToken.RPARENT
						&& lToken.name != EnumToken.EOF) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 7 - nao precisa
	private void parameters() {
		System.out.println("Linha 7");
		System.out.println("Entrou no type");
		type();
		System.out.println("Saiu do type");

		System.out.println("Entrou no parameter");
		parameter();
		System.out.println("Entrou do parameter");

		System.out.println("Entrou no par");
		par();
		System.out.println("Saiu do par");
	}

	// 9 - panicada
	private void par() {

		System.out.println("Linha 9");
		if (lToken.name == EnumToken.COMMA) {
			match(EnumToken.COMMA);

			System.out.println("Entrou no type");
			type();
			System.out.println("Saiu do type");

			System.out.println("Entrou no parameter");
			parameter();
			System.out.println("Entrou do parameter");

			System.out.println("Entrou no par");
			par();
			System.out.println("Saiu do par");
		}

		else if (lToken.name == EnumToken.RPARENT) {
			return;
		}

		else {
			match(EnumToken.COMMA);
			match(EnumToken.RPARENT);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.RPARENT
						&& lToken.name != EnumToken.EOF) {
					advance();
				}
				panicMode = OFF;
				return;
			}

		}

	}

	// 8 - panicada
	private void parameter() {
		System.out.println("Linha 8");
		if (lToken.name == EnumToken.ID) {

			match(EnumToken.ID);
			System.out.println("Entrou no param");
			param();
			System.out.println("Saiu do param");
		}

		else if (lToken.name == EnumToken.COMMA
				|| lToken.name == EnumToken.RPARENT) {
			System.out.println("prox parametro");
			return;
		}

		else {
			match(EnumToken.ID);
			match(EnumToken.COMMA);
			match(EnumToken.RPARENT);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.COMMA
						&& lToken.name != EnumToken.RPARENT
						&& lToken.name != EnumToken.EOF) {
					advance();
				}
				panicMode = OFF;
				return;
			}

		}
	}

	// 10 - panicada
	private void param() {
		System.out.println("Linha 10");
		if (lToken.name == EnumToken.LBRACKET) {
			match(EnumToken.LBRACKET);

			if (lToken.name == EnumToken.RBRACKET) {
				match(EnumToken.RBRACKET);
			} else {
				match(EnumToken.RBRACKET);
				if (panicMode == ON) {
					while (lToken.name != EnumToken.COMMA
							&& lToken.name != EnumToken.RPARENT
							&& lToken.name != EnumToken.EOF) {
						advance();
					}
					panicMode = OFF;
					return;
				}
			}

		}

		else if (lToken.name == EnumToken.COMMA
				|| lToken.name == EnumToken.RPARENT) {
			return;
		}

		else {
			match(EnumToken.LBRACKET);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.COMMA
						&& lToken.name != EnumToken.RPARENT) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 11 - panicada
	private void block() {
		System.out.println("Linha 11");
		if (lToken.name == EnumToken.LBRACE) {
			match(EnumToken.LBRACE);
			System.out.println("Entrou no LocalDeclarations");
			localDeclarations();
			System.out.println("Saiu do LocalDeclarations");

			System.out.println("Entrou no StatementList");
			statementList();
			System.out.println("Saiu do StatementList");

			if (lToken.name == EnumToken.RBRACE) {
				match(EnumToken.RBRACE);
			} else {
				match(EnumToken.RBRACE);
				if (panicMode == ON) {
					while (lToken.name != EnumToken.EOF
							&& lToken.name != EnumToken.INT
							&& lToken.name != EnumToken.BOOL
							&& lToken.name != EnumToken.VOID
							&& lToken.name != EnumToken.DOUBLE) {
						advance();
					}
					panicMode = OFF;
					return;
				}
			}

		} else {
			match(EnumToken.LBRACE);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.EOF
						&& lToken.name != EnumToken.INT
						&& lToken.name != EnumToken.BOOL
						&& lToken.name != EnumToken.VOID
						&& lToken.name != EnumToken.DOUBLE) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 12 - nao precisa
	private void localDeclarations() {
		System.out.println("Linha 12");
		if (lToken.name == EnumToken.INT || lToken.name == EnumToken.VOID
				|| lToken.name == EnumToken.BOOL
				|| lToken.name == EnumToken.DOUBLE) {
			System.out.println("Entrou no declaration");
			declaration();
			System.out.println("Saiu do declaration");

			System.out.println("Entrou no localDeclaration");
			localDeclarations();
			System.out.println("Saiu do LocalDeclaration");
		}

		else if (lToken.name == EnumToken.COMMAPOINT
				|| lToken.name == EnumToken.ID
				|| lToken.name == EnumToken.LBRACE
				|| lToken.name == EnumToken.IF
				|| lToken.name == EnumToken.WHILE
				|| lToken.name == EnumToken.RETURN
				|| lToken.name == EnumToken.UNARYOP
				|| lToken.name == EnumToken.INTERGER_LITERAL
				|| lToken.name == EnumToken.DOUBLE_LITERAL
				|| lToken.name == EnumToken.TRUE
				|| lToken.name == EnumToken.FALSE
				|| lToken.name == EnumToken.LPARENT
				|| lToken.name == EnumToken.RBRACE) {
			return;
		}

		else {
			match(EnumToken.INT);
			match(EnumToken.VOID);
			match(EnumToken.BOOL);
			match(EnumToken.DOUBLE);
			match(EnumToken.COMMAPOINT);
			match(EnumToken.ID);
			match(EnumToken.LBRACE);
			match(EnumToken.IF);
			match(EnumToken.WHILE);
			match(EnumToken.RETURN);
			match(EnumToken.UNARYOP);
			match(EnumToken.INTERGER_LITERAL);
			match(EnumToken.DOUBLE_LITERAL);
			match(EnumToken.TRUE);
			match(EnumToken.FALSE);
			match(EnumToken.LPARENT);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.COMMAPOINT
						&& lToken.name != EnumToken.ID
						&& lToken.name != EnumToken.LBRACE
						&& lToken.name != EnumToken.IF
						&& lToken.name != EnumToken.WHILE
						&& lToken.name != EnumToken.RETURN
						&& lToken.name != EnumToken.UNARYOP
						&& lToken.name != EnumToken.INTERGER_LITERAL
						&& lToken.name != EnumToken.DOUBLE_LITERAL
						&& lToken.name != EnumToken.TRUE
						&& lToken.name != EnumToken.FALSE
						&& lToken.name != EnumToken.LPARENT
						&& lToken.name != EnumToken.EOF) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 13 - nao precisa
	private void statementList() {
		System.out.println("Linha 13");
		if (lToken.name == EnumToken.COMMAPOINT || lToken.name == EnumToken.ID
				|| lToken.name == EnumToken.LBRACE
				|| lToken.name == EnumToken.IF
				|| lToken.name == EnumToken.WHILE
				|| lToken.name == EnumToken.RETURN) {
			System.out.println("Entrou no statement");
			statement();
			System.out.println("Saiu do statement");

			System.out.println("Entrou no statementList");
			statementList();
			System.out.println("Saiu do statementList");
		} else if (lToken.name == EnumToken.RBRACE) {
			return;
		} else {
			match(EnumToken.COMMAPOINT);
			match(EnumToken.ID);
			match(EnumToken.LBRACE);
			match(EnumToken.IF);
			match(EnumToken.WHILE);
			match(EnumToken.RETURN);
			match(EnumToken.RBRACE);

			if (panicMode == ON) {
				while (lToken.name != EnumToken.COMMAPOINT
						&& lToken.name != EnumToken.ID
						&& lToken.name != EnumToken.LBRACE
						&& lToken.name != EnumToken.IF
						&& lToken.name != EnumToken.WHILE
						&& lToken.name != EnumToken.RETURN
						&& lToken.name != EnumToken.UNARYOP
						&& lToken.name != EnumToken.INTERGER_LITERAL
						&& lToken.name != EnumToken.DOUBLE_LITERAL
						&& lToken.name != EnumToken.TRUE
						&& lToken.name != EnumToken.FALSE
						&& lToken.name != EnumToken.LPARENT
						&& lToken.name != EnumToken.EOF) {
					System.out.println("aqui");
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 14 - panicada
	private void statement() {
		System.out.println("Linha 14");
		if (lToken.name == EnumToken.COMMAPOINT) {
			match(EnumToken.COMMAPOINT);
		}

		else if (lToken.name == EnumToken.ID) {
			System.out.println("Entrou no expression");
			expression();
			System.out.println("saiu do expression");
			if (lToken.name == EnumToken.COMMAPOINT) {
				match(EnumToken.COMMAPOINT);
			} else {
				match(EnumToken.COMMAPOINT);
				if (panicMode == ON) {
					while (lToken.name != EnumToken.COMMAPOINT
							&& lToken.name != EnumToken.ID
							&& lToken.name != EnumToken.UNARYOP
							&& lToken.name != EnumToken.LPARENT
							&& lToken.name != EnumToken.INTERGER_LITERAL
							&& lToken.name != EnumToken.DOUBLE_LITERAL
							&& lToken.name != EnumToken.TRUE
							&& lToken.name != EnumToken.FALSE
							&& lToken.name != EnumToken.WHILE
							&& lToken.name != EnumToken.IF
							&& lToken.name != EnumToken.RETURN
							&& lToken.name != EnumToken.LBRACE
							&& lToken.name != EnumToken.EOF) {
						advance();
					}
					panicMode = OFF;
					return;
				}
			}
		}

		else if (lToken.name == EnumToken.LBRACE) {
			System.out.println("Entrou no block");
			block();
			System.out.println("Saiu do block");
		}

		else if (lToken.name == EnumToken.IF) {
			System.out.println("Entrou no ifStatement");
			ifStatement();
			System.out.println("Saiu do ifStatement");
		}

		else if (lToken.name == EnumToken.WHILE) {
			System.out.println("Entrou no WhileStatement");
			whileStatement();
			System.out.println("Saiu do whileStatement");
		}

		else if (lToken.name == EnumToken.RETURN) {
			System.out.println("Entrou no ReturnStmt");
			returnStmt();
			System.out.println("Saiu do ReturnStmt");
		}

		else {
			match(EnumToken.COMMAPOINT);
			match(EnumToken.ID);
			match(EnumToken.LBRACE);
			match(EnumToken.IF);
			match(EnumToken.WHILE);
			match(EnumToken.RETURN);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.COMMAPOINT
						&& lToken.name != EnumToken.ID
						&& lToken.name != EnumToken.UNARYOP
						&& lToken.name != EnumToken.LPARENT
						&& lToken.name != EnumToken.INTERGER_LITERAL
						&& lToken.name != EnumToken.DOUBLE_LITERAL
						&& lToken.name != EnumToken.TRUE
						&& lToken.name != EnumToken.FALSE
						&& lToken.name != EnumToken.EOF) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 15 - panicada
	private void expression() {
		boolean gambs = false;
		System.out.println("Linha 15");
		if (lToken.name == EnumToken.ID) {
			lToken = scanner.nextToken(lToken);
			if (lToken.name == EnumToken.ASSIGNMENT) {
				gambs = true;
			}

			previous();

		}

		if (lToken.name == EnumToken.ID && gambs == true) {
			System.out.println("Entrou em variable");
			variable();
			System.out.println("Saiu do variable");
			if (lToken.name == EnumToken.ASSIGNMENT) {
				match(EnumToken.ASSIGNMENT);
				System.out.println("Entrou no expression");
				expression();
				System.out.println("Saiu do expression");
			} else {
				match(EnumToken.RELOP);
				if (panicMode == ON) {
					while (lToken.name != EnumToken.UNARYOP
							&& lToken.name != EnumToken.LPARENT
							&& lToken.name != EnumToken.ID
							&& lToken.name != EnumToken.INTERGER_LITERAL
							&& lToken.name != EnumToken.DOUBLE_LITERAL
							&& lToken.name != EnumToken.TRUE
							&& lToken.name != EnumToken.FALSE
							&& lToken.name != EnumToken.EOF) {
						advance();
					}
					panicMode = OFF;
					return;
				}
			}
		}

		else if (lToken.name == EnumToken.UNARYOP
				|| lToken.name == EnumToken.LPARENT
				|| lToken.name == EnumToken.ID
				|| lToken.name == EnumToken.INTERGER_LITERAL
				|| lToken.name == EnumToken.DOUBLE_LITERAL
				|| lToken.name == EnumToken.TRUE
				|| lToken.name == EnumToken.FALSE) {
			System.out.println("Entrou no simplesExpression");
			simplesExpression();
			System.out.println("Saiu do simplesExpression");
		}

		else {
			match(EnumToken.ID);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.UNARYOP
						&& lToken.name != EnumToken.LPARENT
						&& lToken.name != EnumToken.ID
						&& lToken.name != EnumToken.INTERGER_LITERAL
						&& lToken.name != EnumToken.DOUBLE_LITERAL
						&& lToken.name != EnumToken.TRUE
						&& lToken.name != EnumToken.FALSE) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 16 - panicada
	private void ifStatement() {
		System.out.println("Linha 16");
		if (lToken.name == EnumToken.IF) {
			match(EnumToken.IF);
			if (lToken.name == EnumToken.LPARENT) {
				match(EnumToken.LPARENT);
				System.out.println("Entrou no expression");
				expression();
				System.out.println("Saiu do expression");
				if (lToken.name == EnumToken.RPARENT) {
					match(EnumToken.RPARENT);
					System.out.println("Entrou no statement");
					statement();
					System.out.println("Saiu do statement");

					System.out.println("Entrou no ifStat");
					ifStat();
					System.out.println("Saiu do ifStat");
				} else {
					match(EnumToken.RPARENT);
					if (panicMode == ON) {
						while (lToken.name != EnumToken.COMMAPOINT
								&& lToken.name != EnumToken.ID
								&& lToken.name != EnumToken.UNARYOP
								&& lToken.name != EnumToken.LPARENT
								&& lToken.name != EnumToken.INTERGER_LITERAL
								&& lToken.name != EnumToken.DOUBLE_LITERAL
								&& lToken.name != EnumToken.TRUE
								&& lToken.name != EnumToken.FALSE
								&& lToken.name != EnumToken.EOF) {
							advance();
						}
						panicMode = OFF;
						return;
					}
				}
			} else {
				match(EnumToken.LPARENT);
				if (panicMode == ON) {
					while (lToken.name != EnumToken.COMMAPOINT
							&& lToken.name != EnumToken.ID
							&& lToken.name != EnumToken.UNARYOP
							&& lToken.name != EnumToken.LPARENT
							&& lToken.name != EnumToken.INTERGER_LITERAL
							&& lToken.name != EnumToken.DOUBLE_LITERAL
							&& lToken.name != EnumToken.TRUE
							&& lToken.name != EnumToken.FALSE) {
						advance();
					}
					panicMode = OFF;
					return;
				}
			}
		} else {
			match(EnumToken.IF);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.COMMAPOINT
						&& lToken.name != EnumToken.ID
						&& lToken.name != EnumToken.UNARYOP
						&& lToken.name != EnumToken.LPARENT
						&& lToken.name != EnumToken.INTERGER_LITERAL
						&& lToken.name != EnumToken.DOUBLE_LITERAL
						&& lToken.name != EnumToken.TRUE
						&& lToken.name != EnumToken.FALSE) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 17 - panicada
	private void ifStat() {
		System.out.println("Linha 17");
		if (lToken.name == EnumToken.ELSE) {
			match(EnumToken.ELSE);
			System.out.println("Entrou no statement");
			statement();
			System.out.println("Saiu do statement");
		}

		else if (lToken.name == EnumToken.COMMAPOINT
				|| lToken.name == EnumToken.ID
				|| lToken.name == EnumToken.UNARYOP
				|| lToken.name == EnumToken.LPARENT
				|| lToken.name == EnumToken.INTERGER_LITERAL
				|| lToken.name == EnumToken.DOUBLE_LITERAL
				|| lToken.name == EnumToken.TRUE
				|| lToken.name == EnumToken.FALSE
				|| lToken.name == EnumToken.WHILE
				|| lToken.name == EnumToken.IF
				|| lToken.name == EnumToken.RETURN
				|| lToken.name == EnumToken.RBRACE) {
			return;
		}

		else {
			match(EnumToken.ELSE);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.COMMAPOINT
						&& lToken.name != EnumToken.ID
						&& lToken.name != EnumToken.UNARYOP
						&& lToken.name != EnumToken.LPARENT
						&& lToken.name != EnumToken.INTERGER_LITERAL
						&& lToken.name != EnumToken.DOUBLE_LITERAL
						&& lToken.name != EnumToken.TRUE
						&& lToken.name != EnumToken.FALSE
						&& lToken.name != EnumToken.WHILE
						&& lToken.name != EnumToken.IF
						&& lToken.name != EnumToken.RETURN
						&& lToken.name != EnumToken.LBRACE
						&& lToken.name != EnumToken.EOF) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 18 - panicada
	private void whileStatement() {
		System.out.println("Linha 18");
		if (lToken.name == EnumToken.WHILE) {
			match(EnumToken.WHILE);
			if (lToken.name == EnumToken.LPARENT) {
				match(EnumToken.LPARENT);
				System.out.println("Entrou no expression");
				expression();
				System.out.println("Saiu do expression");
				if (lToken.name == EnumToken.RPARENT) {
					match(EnumToken.RPARENT);
					System.out.println("Entrou no statement");
					statement();
					System.out.println("Saiu do statement");
				} else {
					match(EnumToken.RPARENT);
					if (panicMode == ON) {
						while (lToken.name != EnumToken.COMMAPOINT
								&& lToken.name != EnumToken.ID
								&& lToken.name != EnumToken.UNARYOP
								&& lToken.name != EnumToken.LPARENT
								&& lToken.name != EnumToken.INTERGER_LITERAL
								&& lToken.name != EnumToken.DOUBLE_LITERAL
								&& lToken.name != EnumToken.TRUE
								&& lToken.name != EnumToken.FALSE
								&& lToken.name != EnumToken.WHILE
								&& lToken.name != EnumToken.IF
								&& lToken.name != EnumToken.RETURN
								&& lToken.name != EnumToken.LBRACE
								&& lToken.name != EnumToken.EOF) {
							advance();
						}
						panicMode = OFF;
						return;
					}
				}
			} else {
				match(EnumToken.LPARENT);
				if (panicMode == ON) {
					while (lToken.name != EnumToken.COMMAPOINT
							&& lToken.name != EnumToken.ID
							&& lToken.name != EnumToken.UNARYOP
							&& lToken.name != EnumToken.LPARENT
							&& lToken.name != EnumToken.INTERGER_LITERAL
							&& lToken.name != EnumToken.DOUBLE_LITERAL
							&& lToken.name != EnumToken.TRUE
							&& lToken.name != EnumToken.FALSE
							&& lToken.name != EnumToken.WHILE
							&& lToken.name != EnumToken.IF
							&& lToken.name != EnumToken.RETURN
							&& lToken.name != EnumToken.LBRACE) {
						advance();
					}
					panicMode = OFF;
					return;
				}
			}
		} else {
			match(EnumToken.WHILE);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.COMMAPOINT
						&& lToken.name != EnumToken.ID
						&& lToken.name != EnumToken.UNARYOP
						&& lToken.name != EnumToken.LPARENT
						&& lToken.name != EnumToken.INTERGER_LITERAL
						&& lToken.name != EnumToken.DOUBLE_LITERAL
						&& lToken.name != EnumToken.TRUE
						&& lToken.name != EnumToken.FALSE
						&& lToken.name != EnumToken.WHILE
						&& lToken.name != EnumToken.IF
						&& lToken.name != EnumToken.RETURN
						&& lToken.name != EnumToken.LBRACE) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 19 - panicada
	private void returnStmt() {
		System.out.println("Linha 19");
		if (lToken.name == EnumToken.RETURN) {
			match(EnumToken.RETURN);
			System.out.println("Entrou no ret");
			ret();
			System.out.println("Saiu do ret");
		} else {
			match(EnumToken.RETURN);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.COMMAPOINT
						&& lToken.name != EnumToken.ID
						&& lToken.name != EnumToken.UNARYOP
						&& lToken.name != EnumToken.LPARENT
						&& lToken.name != EnumToken.INTERGER_LITERAL
						&& lToken.name != EnumToken.DOUBLE_LITERAL
						&& lToken.name != EnumToken.TRUE
						&& lToken.name != EnumToken.FALSE
						&& lToken.name != EnumToken.WHILE
						&& lToken.name != EnumToken.IF
						&& lToken.name != EnumToken.RETURN
						&& lToken.name != EnumToken.LBRACE
						&& lToken.name != EnumToken.EOF) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 20 - panicada
	private void ret() {
		System.out.println("Linha 20");
		if (lToken.name == EnumToken.COMMAPOINT) {
			match(EnumToken.COMMAPOINT);
		} else if (lToken.name == EnumToken.ID
				|| lToken.name == EnumToken.UNARYOP
				|| lToken.name == EnumToken.LPARENT
				|| lToken.name == EnumToken.INTERGER_LITERAL
				|| lToken.name == EnumToken.DOUBLE_LITERAL
				|| lToken.name == EnumToken.TRUE
				|| lToken.name == EnumToken.FALSE) {
			System.out.println("Entrou no expression");
			expression();
			System.out.println("Saiu do expression");

			if (lToken.name == EnumToken.COMMAPOINT) {
				match(EnumToken.COMMAPOINT);
			} else {
				match(EnumToken.COMMAPOINT);
				if (panicMode == ON) {
					while (lToken.name != EnumToken.COMMAPOINT
							&& lToken.name != EnumToken.ID
							&& lToken.name != EnumToken.UNARYOP
							&& lToken.name != EnumToken.LPARENT
							&& lToken.name != EnumToken.INTERGER_LITERAL
							&& lToken.name != EnumToken.DOUBLE_LITERAL
							&& lToken.name != EnumToken.TRUE
							&& lToken.name != EnumToken.FALSE
							&& lToken.name != EnumToken.WHILE
							&& lToken.name != EnumToken.IF
							&& lToken.name != EnumToken.RETURN
							&& lToken.name != EnumToken.LBRACE
							&& lToken.name != EnumToken.EOF) {
						advance();
					}
					panicMode = OFF;
					return;
				}
			}

		} else {
			match(EnumToken.COMMAPOINT);
			match(EnumToken.ID);
			match(EnumToken.UNARYOP);
			match(EnumToken.LPARENT);
			match(EnumToken.INTERGER_LITERAL);
			match(EnumToken.DOUBLE_LITERAL);
			match(EnumToken.TRUE);
			match(EnumToken.FALSE);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.COMMAPOINT
						&& lToken.name != EnumToken.ID
						&& lToken.name != EnumToken.UNARYOP
						&& lToken.name != EnumToken.LPARENT
						&& lToken.name != EnumToken.INTERGER_LITERAL
						&& lToken.name != EnumToken.DOUBLE_LITERAL
						&& lToken.name != EnumToken.TRUE
						&& lToken.name != EnumToken.FALSE
						&& lToken.name != EnumToken.WHILE
						&& lToken.name != EnumToken.IF
						&& lToken.name != EnumToken.RETURN
						&& lToken.name != EnumToken.LBRACE) {
					advance();
				}
				panicMode = OFF;
				return;
			}

		}
	}

	// 21 - panicada
	private void variable() {
		System.out.println("Linha 21");
		if (lToken.name == EnumToken.ID) {
			match(EnumToken.ID);
			System.out.println("Entrou no VariableLine");
			variableLine();
			System.out.println("Saiu do variableLine");
		} else {
			match(EnumToken.ID);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.MULOP
						&& lToken.name != EnumToken.ASSIGNMENT
						&& lToken.name != EnumToken.EOF
						&& lToken.name != EnumToken.MULOP
						&& lToken.name != EnumToken.ADDOP
						&& lToken.name != EnumToken.RELOP
						&& lToken.name != EnumToken.RPARENT
						&& lToken.name != EnumToken.RBRACKET
						&& lToken.name != EnumToken.COMMAPOINT
						&& lToken.name != EnumToken.COMMA) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 22 - panicada
	private void variableLine() {
		System.out.println("Linha 22");
		if (lToken.name == EnumToken.LBRACKET) {
			match(EnumToken.LBRACKET);
			System.out.println("Entrou no expression");
			expression();
			System.out.println("Saiu do expression");
			if (lToken.name == EnumToken.RBRACKET) {
				match(EnumToken.RBRACKET);
			} else {
				match(EnumToken.RBRACKET);
				if (panicMode == ON) {
					while (lToken.name != EnumToken.MULOP
							&& lToken.name != EnumToken.RELOP) {
						advance();
					}
					panicMode = OFF;
					return;
				}
			}
		}

		else if (lToken.name == EnumToken.LPARENT) {
			match(EnumToken.LPARENT);
			System.out.println("Entrou no arguments");
			arguments();
			System.out.println("Saiu do arguments");
			if (lToken.name == EnumToken.RPARENT) {
				match(EnumToken.RPARENT);
			} else {
				match(EnumToken.RPARENT);
				if (panicMode == ON) {
					while (lToken.name != EnumToken.MULOP
							&& lToken.name != EnumToken.RELOP) {
						advance();
					}
					panicMode = OFF;
					return;
				}
			}

		}

		else if (lToken.name == EnumToken.MULOP
				|| lToken.name == EnumToken.RELOP
				|| lToken.name == EnumToken.ASSIGNMENT
				|| lToken.name == EnumToken.ADDOP
				|| lToken.name == EnumToken.UNARYOP
				|| lToken.name == EnumToken.COMMAPOINT
				|| lToken.name == EnumToken.RPARENT
				|| lToken.name == EnumToken.RBRACKET
				|| lToken.name == EnumToken.COMMA) {
			return;
		}

		else {
			match(EnumToken.LBRACKET);
			match(EnumToken.LPARENT);
			match(EnumToken.MULOP);
			match(EnumToken.RELOP);
			match(EnumToken.ASSIGNMENT);
			match(EnumToken.ADDOP);
			match(EnumToken.COMMAPOINT);
			match(EnumToken.RPARENT);
			match(EnumToken.RBRACKET);
			match(EnumToken.COMMA);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.MULOP
						&& lToken.name != EnumToken.RELOP
						&& lToken.name != EnumToken.ADDOP
						&& lToken.name != EnumToken.COMMAPOINT
						&& lToken.name != EnumToken.RPARENT
						&& lToken.name != EnumToken.RBRACKET
						&& lToken.name != EnumToken.COMMA) {
					advance();
					System.out.println("Eu Quero v o ococo");
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 23 - nao precisa
	private void simplesExpression() {
		System.out.println("Linha 23");
		System.out.println("Entrou no additiveExpression");
		additiveExpression();
		System.out.println("Saiu do additiveExpression");

		System.out.println("Entrou no SimpleLine");
		simpleLine();
		System.out.println("Saiu do simpleLine");
	}

	// 24 - panicada
	private void simpleLine() {
		System.out.println("Linha 24");
		if (lToken.name == EnumToken.RELOP) {
			match(EnumToken.RELOP);

			System.out.println("Entrou no additiveExpression");
			additiveExpression();
			System.out.println("Saiu do additiveExpression");
		}

		else if (lToken.name == EnumToken.RPARENT
				|| lToken.name == EnumToken.COMMAPOINT
				|| lToken.name == EnumToken.RBRACKET
				|| lToken.name == EnumToken.COMMA) {
			return;
		}

		else {
			match(EnumToken.RELOP);
			match(EnumToken.RPARENT);
			match(EnumToken.COMMAPOINT);
			match(EnumToken.RBRACKET);
			match(EnumToken.COMMA);

			if (panicMode == ON) {
				while (lToken.name != EnumToken.RPARENT
						&& lToken.name != EnumToken.COMMAPOINT
						&& lToken.name != EnumToken.RBRACKET
						&& lToken.name != EnumToken.COMMA
						&& lToken.name != EnumToken.EOF) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 25 - nao precisa
	private void additiveExpression() {
		System.out.println("Linha 25");

		System.out.println("Entrou em term");
		term();
		System.out.println("Saiu do term");

		System.out.println("Entrou no additLine");
		additLine();
		System.out.println("Saiu do additLine");
	}

	// 26 - panicada
	private void additLine() {
		System.out.println("Linha 26");
		if (lToken.name == EnumToken.ADDOP) {
			match(EnumToken.ADDOP);
			System.out.println("Entrou no term");
			term();
			System.out.println("Saiu do term");

			System.out.println("Entrou no additLine");
			additLine();
			System.out.println("Saiu do additLine");
		}

		else if (lToken.name == EnumToken.RELOP
				|| lToken.name == EnumToken.COMMAPOINT
				|| lToken.name == EnumToken.COMMA
				|| lToken.name == EnumToken.RBRACKET
				|| lToken.name == EnumToken.RPARENT) {
			return;
		}

		else {
			match(EnumToken.ADDOP);
			match(EnumToken.RELOP);
			match(EnumToken.RPARENT);
			match(EnumToken.COMMAPOINT);
			match(EnumToken.RBRACKET);
			match(EnumToken.COMMA);

			if (panicMode == ON) {
				while (lToken.name != EnumToken.RELOP
						&& lToken.name != EnumToken.RPARENT
						&& lToken.name != EnumToken.COMMAPOINT
						&& lToken.name != EnumToken.RBRACKET
						&& lToken.name != EnumToken.COMMA
						&& lToken.name != EnumToken.EOF) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 27 - nao precisa
	private void term() {
		System.out.println("Linha 27");
		System.out.println("Entrou no unaryExpression");
		unaryExpression();
		System.out.println("Saiu do unaryExpression");

		System.out.println("Entrou no termLine");
		termLine();
		System.out.println("Saiu do termLine");
	}

	// 28 - panicada
	private void termLine() {
		System.out.println("Linha 28");
		if (lToken.name == EnumToken.MULOP) {
			match(EnumToken.MULOP);
			System.out.println("Entrou no unaryExpression");
			unaryExpression();
			System.out.println("Saiu do unaryExpression");

			System.out.println("Entrou no termLine");
			termLine();
			System.out.println("Saiu do termLine");
		}

		else if (lToken.name == EnumToken.ADDOP
				|| lToken.name == EnumToken.RELOP
				|| lToken.name == EnumToken.COMMAPOINT
				|| lToken.name == EnumToken.RPARENT
				|| lToken.name == EnumToken.RBRACKET
				|| lToken.name == EnumToken.COMMA) {
			return;
		}

		else {
			match(EnumToken.MULOP);
			match(EnumToken.ADDOP);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.ADDOP
						&& lToken.name != EnumToken.EOF) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}

	}

	// 29 - panicada
	private void unaryExpression() {
		System.out.println("Linha 29");
		if (lToken.name == EnumToken.UNARYOP) {
			match(EnumToken.UNARYOP);
			System.out.println("Entrou no UnaryExpression");
			unaryExpression();
			System.out.println("Saiu do UnaryExpression");
		}

		else if (lToken.name == EnumToken.LPARENT
				|| lToken.name == EnumToken.ID
				|| lToken.name == EnumToken.INTERGER_LITERAL
				|| lToken.name == EnumToken.DOUBLE_LITERAL
				|| lToken.name == EnumToken.TRUE
				|| lToken.name == EnumToken.FALSE) {
			System.out.println("Entrou no factor");
			factor();
			System.out.println("Saiu do factor");
		}

		else {
			match(EnumToken.UNARYOP);
			match(EnumToken.LPARENT);
			match(EnumToken.ID);
			match(EnumToken.INTERGER_LITERAL);
			match(EnumToken.DOUBLE_LITERAL);
			match(EnumToken.TRUE);
			match(EnumToken.FALSE);

			if (panicMode == ON) {
				while (lToken.name != EnumToken.MULOP
						&& lToken.name != EnumToken.EOF) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 30 - panicada
	private void factor() {
		System.out.println("Linha 30");
		if (lToken.name == EnumToken.LPARENT) {
			match(EnumToken.LPARENT);
			System.out.println("Entrou no expression");
			expression();
			System.out.println("Saiu do expression");

			if (lToken.name == EnumToken.RPARENT) {
				match(EnumToken.RPARENT);
			} else {
				match(EnumToken.RPARENT);
				if (panicMode == ON) {
					while (lToken.name != EnumToken.MULOP
							&& lToken.name != EnumToken.EOF) {
						advance();
					}
					panicMode = OFF;
					return;
				}
			}

		}

		else if (lToken.name == EnumToken.ID) {
			System.out.println("Entrou no variable");
			variable();
			System.out.println("Saiu do variable");

		}

		else if (lToken.name == EnumToken.DOUBLE_LITERAL
				|| lToken.name == EnumToken.FALSE
				|| lToken.name == EnumToken.TRUE
				|| lToken.name == EnumToken.INTERGER_LITERAL) {
			System.out.println("Entrou na constant");
			constant();
			System.out.println("Saiud da constant");
		}

		else {
			match(EnumToken.LPARENT);
			match(EnumToken.ID);
			match(EnumToken.DOUBLE_LITERAL);
			match(EnumToken.FALSE);
			match(EnumToken.TRUE);
			match(EnumToken.INTERGER_LITERAL);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.MULOP
						&& lToken.name != EnumToken.EOF) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 31 - panicada
	private void constant() {
		System.out.println("Linha 31");
		if (lToken.name == EnumToken.INTERGER_LITERAL) {
			match(EnumToken.INTERGER_LITERAL);
		}

		else if (lToken.name == EnumToken.DOUBLE_LITERAL) {
			match(EnumToken.DOUBLE_LITERAL);
		}

		else if (lToken.name == EnumToken.TRUE) {
			match(EnumToken.TRUE);
		}

		else if (lToken.name == EnumToken.FALSE) {
			match(EnumToken.FALSE);
		}

		else {
			match(EnumToken.INTERGER_LITERAL);
			match(EnumToken.DOUBLE_LITERAL);
			match(EnumToken.TRUE);
			match(EnumToken.FALSE);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.MULOP
						&& lToken.name != EnumToken.EOF) {
					advance();
				}
				panicMode = OFF;
				return;
			}

		}
	}

	// 32 - panicada
	private void arguments() {
		System.out.println("Linha 32");
		if (lToken.name == EnumToken.ID) {
			System.out.println("Entrou no argumentList");
			argumentList();
			System.out.println("Saiu do argumentList");
		}

		else if (lToken.name == EnumToken.RPARENT) {
			return;
		}

		else {
			match(EnumToken.ID);
			match(EnumToken.RPARENT);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.RPARENT
						&& lToken.name != EnumToken.EOF) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}

	// 33 - nao precisa
	private void argumentList() {
		System.out.println("Linha 33");
		System.out.println("Entrou no expression");
		expression();
		System.out.println("Saiu do expression");

		System.out.println("Entrou no argLine");
		argLine();
		System.out.println("Saiu do argLine");
	}

	// 34 - panicada
	private void argLine() {
		System.out.println("Linha 34");
		if (lToken.name == EnumToken.COMMA) {
			match(EnumToken.COMMA);
			System.out.println("Entrou no expression");
			expression();
			System.out.println("Saiu do expression");

			System.out.println("Entrou no argLine");
			argLine();
			System.out.println("Saiu do argLine");
		}

		else if (lToken.name == EnumToken.RPARENT) {
			return;
		}

		else {
			match(EnumToken.COMMA);
			match(EnumToken.RPARENT);
			if (panicMode == ON) {
				while (lToken.name != EnumToken.RPARENT
						&& lToken.name != EnumToken.EOF) {
					advance();
				}
				panicMode = OFF;
				return;
			}
		}
	}
}