package minijavacompiler;



/**
 * @author facom
 */
public class STEntry 
{    
    public String lexeme;
    public boolean reserved;
    public Token token;
    public STEntry()
    {}
    
    public STEntry(String lex)
    {        
        lexeme = lex;
        reserved = false;
        
        //double var = 2.e+24;
    }
    
    public STEntry(Token tok, boolean res)
    {
        token = tok;
        lexeme = tok.value;
        reserved = res;
    }
    
    public STEntry(String lex, boolean res)
    {
        lexeme = lex;
        reserved = res;
    }

}