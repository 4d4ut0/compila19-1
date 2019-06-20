/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package minijavacompiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.StringCharacterIterator;
import javax.sound.midi.SysexMessage;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author bianca
 */
public class Scanner 
{
    private static String input;
    private StringCharacterIterator inputIt;
    private int contador = 0;
    Token nowtok = new Token(EnumToken.UNDEF);  
    SymbolTable<STEntry> tableCurrent;

    public  int cont=1;
    public Scanner(String inputFileName, SymbolTable<STEntry> table)
    {
    	
        File inputFile = new File(inputFileName);
        tableCurrent = table;
        
        try
        {
            FileReader fr = new FileReader(inputFile);
            int size = (int)inputFile.length();            
            char[] buffer = new char[size];
        
            fr.read(buffer, 0, size);
            
            input = new String(buffer);
            
            
            inputIt = new StringCharacterIterator(input);
            
            System.out.println(input);
        }
        catch(FileNotFoundException e)
        {
            System.err.println("Arquivo não encontrado");
        }
        catch(IOException e)
        {
            System.err.println("Erro na leitura do arquivo");
        }
    }
   
    public Token previousToken()
    {
    	while(contador != 0)
        {
            inputIt.previous();
            contador--;
    	}
    	
    	return nowtok;
    }
      
    public Token nextToken(Token previous)
    {
        contador = 0;	
        nowtok = previous;  
        Token tok = new Token(EnumToken.UNDEF);   
        
        String lexema = ""; 
        
        if (inputIt.getIndex() >= inputIt.getEndIndex())  
        {	  
            tok.name = EnumToken.EOF;
            return tok;	
        }
        
        else
        {
            while (true)
            {   
                //Espaços brancos
            	if(Character.isSpace(inputIt.current()))
            	{
                    while(Character.isSpace(inputIt.current()) && !(inputIt.getIndex() >= inputIt.getEndIndex()))
                    {
                        if(inputIt.current() == '\n')
                        {
                            cont++;
                            System.out.println("linha"+cont);
                            tok.numberLine = cont;
                        }
                        inputIt.next(); 
                        contador++;
                    }
            		
            	}
                
                //Final de arquivo
            	else if(inputIt.getIndex() >= inputIt.getEndIndex())
            	{
                    tok.name = EnumToken.EOF;
                    return tok;
            	}
                
            	//Deconsidera comentarios
            	else if(inputIt.current() == '/')
            	{
                    int x = 0;
                    inputIt.next(); 
                    contador++;
                    
                    //Ignora comentario tipo //...
                    if(inputIt.current() == '/')
                        while(inputIt.current() != '\n')
                        {
                                inputIt.next(); 
                                contador++;
                        }

                    //Ignora comentario tipo /*...*/
                    else if(inputIt.current() == '*')
                    {
                        inputIt.next();
                        contador++;
                        while(x != 1)
                        {
                            if(inputIt.current() == '*')
                            {
                                inputIt.next(); 
                                contador++;
                                if(inputIt.current() == '/')
                                {
                                    x = 1;
                                    inputIt.next(); 
                                    contador++;
                                }
                            }
                            
                            else
                            {
                                inputIt.next(); 
                                contador++;
                            }
                        }
                    }
                    
                    //Div
                    else
                    {
                        lexema = lexema + inputIt.current(); 
                        inputIt.next(); 
                        contador++;

                        tok.name = EnumToken.DIV;
                        tok.attribute = EnumToken.DIV;
                        tok.value = lexema;
                        return tok;	
                    }
            	}
            	
                //Integer_literal
            	else if(Character.isDigit(inputIt.current() ))
            	{
                    lexema = lexema+inputIt.current();
                    inputIt.next(); 
                    contador++;
                    while (Character.isDigit(inputIt.current() )) 
                    {
                        lexema = lexema + inputIt.current();
                        inputIt.next(); 
                        contador++;
                    }		  
                    tok.name = EnumToken.INTERGER_LITERAL;
                    tok.attribute = EnumToken.INTERGER_LITERAL;
                    tok.value = lexema;	
                    return tok;
            	}
                
                //Strings
                else if(inputIt.current() == '"')
                {
                    lexema = lexema + inputIt.current();
                    inputIt.next(); 
                    contador++;
                    while(inputIt.current() != '"')
                    {
                        lexema = lexema + inputIt.current();
                        inputIt.next(); 
                        contador++;
                    }
                    lexema = lexema + inputIt.current();
                    inputIt.next(); 
                    contador++;
                    
                    tok.name = EnumToken.STRING_LITERAL;
                    tok.attribute = EnumToken.STRING_LITERAL;
                    tok.value = lexema;
                    return tok;  
                }
                
            	//ID ou Palavra reservada
            	else if(inputIt.current() == '_' || Character.isLetter(inputIt.current()))
            	{
                    while(inputIt.current() == '_' || Character.isLetter(inputIt.current()) || Character.isDigit(inputIt.current()) )
                    {
                        lexema = lexema+inputIt.current(); 
                        inputIt.next(); contador++;
                    }

                    //palavra reservada int
                    if(lexema.equals("int"))
                    {          			  
                        tok.name = EnumToken.INT;
                        tok.attribute = EnumToken.INT;
                    }

                    //palavra reservada class
                    else if(lexema.equals("class"))
                    {
                        tok.name = EnumToken.CLASS;
                        tok.attribute = EnumToken.CLASS;
                    }

                    //palavra reservada extends
                    else if(lexema.equals("extends"))
                    {            			  
                        tok.name = EnumToken.EXTENDS;
                        tok.attribute = EnumToken.EXTENDS;
                    }

                    //palavra reservada string
                    else if(lexema.equals("string"))
                    {
                        tok.name = EnumToken.STRING;
                        tok.attribute = EnumToken.STRING;
                    }

                    //palavra reservada break 
                    else if(lexema.equals("break"))
                    {
                        tok.name = EnumToken.BREAK;
                        tok.attribute =  EnumToken.BREAK;
                    }

                    //palavra reservada print
                    else if(lexema.equals("print"))
                    {
                        tok.name = EnumToken.PRINT;
                        tok.attribute = EnumToken.PRINT;
                    }

                    //palavra reservada if
                    else if(lexema.equals("if"))
                    {
                        tok.name = EnumToken.IF;
                        tok.attribute =  EnumToken.IF;
                    }

                    //palavra reservada else
                    else if(lexema.equals("else"))
                    {
                        tok.name = EnumToken.ELSE;
                        tok.attribute = EnumToken.ELSE;
                    }

                    //palavra reservada for
                    else if(lexema.equals("for"))
                    {
                        tok.name = EnumToken.FOR;
                        tok.attribute = EnumToken.FOR;
                    }

                    //palavra reservada return
                    else if(lexema.equals("return"))
                    {
                        tok.name = EnumToken.RETURN;
                    }

                    //palavra reservada read
                    else if(lexema.equals("read"))
                    {
                        tok.name = EnumToken.READ;
                        tok.attribute = EnumToken.READ;
                    }

                    //palavra reservada super
                    else if(lexema.equals("super"))
                    {
                        tok.name = EnumToken.SUPER;
                        tok.attribute = EnumToken.SUPER;
                    }

                    //palavra reservada new
                    else if(lexema.equals("new"))
                    {
                        tok.name = EnumToken.NEW;
                        tok.attribute = EnumToken.NEW;
                    }

                    //palavra reservada constructor
                    else if(lexema.equals("constructor"))
                    {
                        tok.name = EnumToken.CONSTRUCTOR;
                        tok.attribute = EnumToken.CONSTRUCTOR;
                    }

                    //ID
                    else
                    {
                        tok.name = EnumToken.ID;
                        tok.numberLine = cont;
                        tok.attribute = EnumToken.ID;
                        tok.value=lexema;
                        System.out.println(tok.value);
                        if(tableCurrent.symbols.get(lexema) != null)
                        {
                            return tok; 
                        }
                        else
                        {
                            tok.inTable = true;
                            tableCurrent.add(new STEntry(tok.value, false));
                        }
                    }
                    tok.value=lexema;
                    return tok;
            	}
            	
                //LParent
            	else if(inputIt.current() == '(')
            	{   
                    lexema = lexema + inputIt.current();
                    inputIt.next(); 
                    contador++;

                    tok.name = EnumToken.LPARENT;
                    tok.attribute = EnumToken.LPARENT;
                    tok.value = lexema;
                    return tok;
            	}
            	
                //RParent
            	else if(inputIt.current() == ')')
            	{
                    lexema = lexema + inputIt.current(); 
                    inputIt.next(); 
                    contador++;

                    tok.name = EnumToken.RPARENT;
                    tok.attribute = EnumToken.RPARENT;
                    tok.value = lexema;

                    return tok;
            	}
                
                //LBracket
                else if(inputIt.current() == '[')
            	{
                    lexema = lexema + inputIt.current(); 
                    inputIt.next(); 
                    contador++;

                    tok.name = EnumToken.LBRACKET;
                    tok.attribute = EnumToken.LBRACKET;
                    tok.value = lexema;
                    return tok;
            	}
            	
                //RBracket
            	else if(inputIt.current() == ']')
            	{
                    lexema = lexema+inputIt.current(); 
                    inputIt.next(); 
                    contador++;

                    tok.name = EnumToken.RBRACKET;
                    tok.attribute = EnumToken.LBRACKET;
                    tok.value = lexema;
                    return tok;
            	}
            	
                //LBrace
            	else if(inputIt.current() == '{')
            	{
                    lexema = lexema+inputIt.current(); 
                    inputIt.next(); 
                    contador++;

                    tok.name = EnumToken.LBRACE;
                    tok.attribute = EnumToken.LBRACE;
                    tok.value = lexema;
                    return tok;
            	}
            	
                //RBrace
            	else if(inputIt.current() == '}')
            	{
                    lexema = lexema+inputIt.current(); 
                    inputIt.next(); 
                    contador++;

                    tok.name = EnumToken.RBRACE;
                    tok.attribute = EnumToken.RBRACE;
                    tok.value = lexema;
                    return tok;
            	}
                
                //CommaPoint
                else if(inputIt.current() == ';')
            	{
                    lexema = lexema + inputIt.current(); 
                    inputIt.next(); 
                    contador++;

                    tok.name = EnumToken.COMMAPOINT;
                    tok.attribute = EnumToken.COMMAPOINT;
                    tok.value = lexema ; 
                    return tok;
            	}
            	
                //Comma
            	else if(inputIt.current() == ',')
            	{
                    lexema = lexema + inputIt.current(); 
                    inputIt.next(); 
                    contador++;

                    tok.name = EnumToken.COMMA;
                    tok.attribute = EnumToken.COMMA;
                    tok.value = lexema;
                    return tok;
            	}
                
                //Point
                else if(inputIt.current() == '.')
            	{
                    lexema = lexema + inputIt.current(); 
                    inputIt.next(); 
                    contador++;

                    tok.name = EnumToken.POINT;
                    tok.attribute = EnumToken.POINT;
                    tok.value = lexema;
                    return tok;
            	}
                
                //Plus
                else if(inputIt.current() == '+')
            	{
                    lexema = lexema + inputIt.current(); 
                    inputIt.next(); 
                    contador++;

                    tok.name = EnumToken.PLUS;
                    tok.attribute = EnumToken.PLUS;
                    tok.value = lexema;
                    return tok;	
            	}
                
                //Minus
                else if(inputIt.current() == '-')
            	{
                    lexema = lexema + inputIt.current(); 
                    inputIt.next(); 
                    contador++;

                    tok.name = EnumToken.MINUS;
                    tok.attribute = EnumToken.MINUS;
                    tok.value = lexema;
                    return tok;	
            	}
                
                //Mult
                else if(inputIt.current() == '*')
            	{
                    lexema = lexema + inputIt.current(); 
                    inputIt.next(); 
                    contador++;

                    tok.name = EnumToken.MULT;
                    tok.attribute = EnumToken.MULT;
                    tok.value = lexema;
                    return tok;	
            	}
                
                //Mod
                else if(inputIt.current() == '%')
            	{
                    lexema = lexema + inputIt.current(); 
                    inputIt.next(); 
                    contador++;

                    tok.name = EnumToken.MOD;
                    tok.attribute = EnumToken.MOD;
                    tok.value = lexema;
                    return tok;	
            	}
                
                //Menor igual e Menor
                else if(inputIt.current() == '<')
                {
                    lexema = lexema + inputIt.current(); 
                    inputIt.next(); 
                    contador++;
                    
                    if(inputIt.current() == '=')
                    {
                        tok.name = EnumToken.RELOP;
                        tok.attribute = EnumToken.LE;
                    }
                    
                    else
                    {
                        tok.name = EnumToken.RELOP;
                        tok.attribute = EnumToken.LT;          
                    }
                    
                    tok.value = lexema;
                    return tok;	            
                }
                
                //Maior igual e Maior
                else if(inputIt.current() == '>')
                {
                    lexema = lexema + inputIt.current(); 
                    inputIt.next(); 
                    contador++;
                    
                    if(inputIt.current() == '=')
                    {
                        tok.name = EnumToken.RELOP;
                        tok.attribute = EnumToken.GE;
                    }
                    
                    else
                    {
                        tok.name = EnumToken.RELOP;
                        tok.attribute = EnumToken.GT;          
                    }
                    
                    tok.value = lexema;
                    return tok;	            
                }
                
                //Igual e atribuição
                else if(inputIt.current() == '=')
                {
                    lexema = lexema + inputIt.current(); 
                    inputIt.next(); 
                    contador++;
                    
                    if(inputIt.current() == '=')
                    {
                        tok.name = EnumToken.RELOP;
                        tok.attribute = EnumToken.EQ;
                    }
                    
                    else
                    {
                        tok.name = EnumToken.ATTRIB;
                        tok.attribute = EnumToken.ATTRIB;          
                    }
                    
                    tok.value = lexema;
                    return tok;	            
                }
                
                //Diferente
                else if(inputIt.current() == '!')
                {
                    lexema = lexema + inputIt.current(); 
                    inputIt.next(); 
                    contador++;
                    
                    if(inputIt.current() == '=')
                    {
                        tok.name = EnumToken.RELOP;
                        tok.attribute = EnumToken.NE;
                        tok.value = lexema;
                        return tok;
                    }	            
                }
            }
        }
    }

}
