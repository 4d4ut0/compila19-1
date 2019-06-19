package minijavacompiler;

/**
 * @author bianca
 */
public class Token 
{
    public EnumToken name;
    public EnumToken attribute;
    public boolean inTable = false;
    public boolean isItArray = false;
    public int numParameter;
    public String value;
    public int numberLine;
    
    public Token(EnumToken name)
    {
        this.name = name;
        attribute = EnumToken.UNDEF;
    }
    
    public Token(EnumToken name, EnumToken attr)
    {
        this.name = name;
        attribute = attr;
    }
}
