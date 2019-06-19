package minijavacompiler;


import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;



/**
 *
 * @author Bianca
 */
public class SymbolTable<T extends STEntry> implements Iterable<T>
{
    SymbolTable<T> parent;
    TreeMap<String, T> symbols;

    SymbolTable()
    {
        symbols = new TreeMap<String, T>();
    }
    
    SymbolTable(SymbolTable<T> p)
    {
        symbols = new TreeMap<String, T>();
        
        parent = p;
    }

    //addType()
    public boolean add(T t)
    {
        
        if (symbols.containsKey(t.lexeme))
                return false;
        symbols.put(t.lexeme, t);
        
        return true;
    }
    
    public boolean addType(T t)
    {
        
        if (symbols.containsKey(t.lexeme))
                return false;
        symbols.put(t.lexeme, t);
        
        return true;
    }

    public boolean remove(String name)
    {
        return symbols.remove(name) != null;
    }

    public void clear()
    {
        symbols.clear();
    }
    public void imprime() {
    	for(Entry<String, T> en : symbols.entrySet())
    	 System.out.println(en.getKey());

	}
    public String busca(String chave){
    	
    	for(Entry<String, T> en : symbols.entrySet())
       	 	if(en.getKey().equals(chave))
       	 		return en.getKey();
    	return null;
    }
    public boolean isEmpty()
    {
        return symbols.isEmpty();
    }

    public T get(String name)
    {
        T s;
        SymbolTable<T> table = this;

        do
        {
            s = table.symbols.get(name);
        } while (s == null && (table = table.parent) != null);
        
        return s;
    }


    public Iterator<T> iterator()
    {
        return symbols.values().iterator();
    } 
}