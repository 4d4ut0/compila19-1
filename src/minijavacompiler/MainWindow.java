package minijavacompiler;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Rafael Alves
 */
public abstract class MainWindow extends JFrame implements ActionListener
{
    public String filename = "new";
    @SuppressWarnings("FieldMayBeFinal")
    private JTextArea areaDoTexto;
    public  static JTextArea areaParaExibir;
    private JScrollPane scrollArea, scrollArea2;
    private JMenuBar menuBar;
    private JMenu arquivoM, editarM, ferramentasM;
    private JMenuItem sairI, abrirI, salvarComoI, salvarI;//,cutI,copyI,pasteI,selectI,statusI;
    public JMenuItem compilarI;
    public JFileChooser arquivo;
    
    public MainWindow()
    {
// Configura informações sobre a Janela e outras coisas
        super("MiniCompiladorJava");    // Sugestão: nome do arquivo que está sendo editado
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container panel = getContentPane();
        panel.setLayout(new BorderLayout());
        
//Ponteiro para o arquivo que vai ser editado
        arquivo = new JFileChooser();
        arquivo.setName(filename);
// Configuração da caixa de texto editável
        areaDoTexto = new JTextArea(5,20); //Area que será o editor
        scrollArea = new JScrollPane(areaDoTexto); // Faz com que o editor "role"
        areaDoTexto.setLineWrap(true); // Faz quebra de linha
        areaDoTexto.setWrapStyleWord(true); // Faz a quebra de palavras
       
        add(scrollArea, BorderLayout.CENTER); // add na janela
        
// Configuração da caixa de texto de exibição
        areaParaExibir = new JTextArea(30,50); //Area que será o editor
        areaParaExibir.setEditable(false);
       
        scrollArea2 = new JScrollPane(areaParaExibir); // Faz com que o editor "role"
        
        areaParaExibir.setLineWrap(true); // Faz quebra de linha
        areaParaExibir.setWrapStyleWord(true); // Faz a quebra de palavras*/
        add(scrollArea2, BorderLayout.SOUTH); // add na janela
        
// Configuração dos intens na barra de Menu
        menuBar         = new JMenuBar(); //menubar
        arquivoM        = createFileMenu();         //menu Arquivo
        editarM         = createEditMenu();         //menu Editar
        ferramentasM    = new JMenu("Ferramentas"); //menu Ferramentas
        
        setJMenuBar(menuBar);
        menuBar.add(arquivoM);
        menuBar.add(editarM);
        menuBar.add(ferramentasM);
        
//Configuração dos intens no menu "Compilar"
        compilarI = new JMenuItem("Compilar");
        ferramentasM.add(compilarI); // add ao menu Arquivo
        compilarI.addActionListener(this); // ativa event "Abrir"

// Configurações comuns referente a janela
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    protected JMenu createFileMenu() {
        JMenu menu = new JMenu("Arquivo");
        //Configuração e add dos intens no menu "Arquivo"
        abrirI      = new JMenuItem("Abrir");
        abrirI.setAccelerator(KeyStroke.getKeyStroke("control O"));     // add atalhos
        abrirI.addActionListener(this);         // ativa event "Abrir"
        menu.add(abrirI);
        salvarI     = new JMenuItem("Salvar");
        salvarI.setAccelerator(KeyStroke.getKeyStroke("control S"));    // add atalhos
        salvarI.addActionListener(this);        // ativa event "Salvar"
        menu.add(salvarI);
        salvarComoI = new JMenuItem("Salvar como...");
        salvarComoI.setAccelerator(KeyStroke.getKeyStroke("control alt S"));// add atalhos
        salvarComoI.addActionListener(this);    
        menu.add(salvarComoI);
        menu.addSeparator();
        
        sairI       = new JMenuItem("Sair");
        sairI.addActionListener(this);          // ativa event "Sair"
        menu.add(sairI);
        return menu;
    }
    protected JMenu createEditMenu() {
        JMenu menu = new JMenu("Editar");

        /*//Undo and redo are actions of our own creation.
        undoAction = new UndoAction();
        menu.add(undoAction);

        redoAction = new RedoAction();
        menu.add(redoAction);

        menu.addSeparator();

        //These actions come from the default editor kit.
        //Get the ones we want and stick them in the menu.
        /*menu.add(getActionByName(DefaultEditorKit.cutAction));
        menu.add(getActionByName(DefaultEditorKit.copyAction));
        menu.add(getActionByName(DefaultEditorKit.pasteAction));

        menu.addSeparator();*/

        //menu.add(getActionByName(DefaultEditorKit.selectAllAction));
        return menu;
    }
    // Função passada como herança para Parser
    public abstract void compilarF();
    
    private void abrirF()
    {
        int returnVal = arquivo.showOpenDialog(MainWindow.this);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            File file = arquivo.getSelectedFile();
            BufferedReader br;
            filename = file.getAbsolutePath();
            try{
                String sCurrentLine;
                br = new BufferedReader(new FileReader(file.getPath()));
                while ((sCurrentLine = br.readLine()) != null)  areaDoTexto.append(sCurrentLine + "\n");
            }
            catch(FileNotFoundException e){ areaParaExibir.append("O Arquivo "+ filename + " não foi encontrado"); }
            catch(IOException e){ areaParaExibir.append("Erro na leitura do arquivo" + filename); }
        }
        areaDoTexto.setCaretPosition(areaDoTexto.getDocument().getLength());
    }
    public boolean salvarComoF()
    {
        int returnVal;
        int dialogResult = 0;
        File file = null;
        do{
            returnVal = arquivo.showSaveDialog(MainWindow.this);
            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                file = arquivo.getSelectedFile();
                if (!file.exists()) {
                    try {   file.createNewFile(); }
                    catch (IOException ex) {
                        Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
                    dialogResult = JOptionPane.showConfirmDialog (MainWindow.this,
                            "Existe um arquivo com este nome. Deseja realmente salvar?",
                            "Atenção",dialogButton);
                    if(dialogResult == 2) return false;
                }
            }
            else return false;
        }while(dialogResult != 0);
        filename = file.getName();
        FileWriter fw = null;
        try { fw = new FileWriter(file.getAbsoluteFile()); }
        catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.write(areaDoTexto.getText());
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        //tabbedPane.setTitleAt(0, filename);
        areaDoTexto.setCaretPosition(areaDoTexto.getDocument().getLength());
        return true;
    }
    public void salvarF()
    {
        File file = arquivo.getSelectedFile();
        FileWriter fw = null;
        try {
            fw = new FileWriter(file.getAbsoluteFile());
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.write(areaDoTexto.getText());
           
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // TRATAMENTO DE EVENT
    // Somente chama os metodos auxiliares
    @Override
    public void actionPerformed(ActionEvent event) 
    {
        JMenuItem choice = (JMenuItem) event.getSource();
        
        if      (choice == sairI    )   System.exit(0);
        else if (choice == abrirI   )   abrirF();
        else if (choice == salvarComoI) salvarComoF();
        else if (choice == salvarI  )
        {
            String newfile = "new";
            if(filename.equals(newfile)) salvarComoF();//System.out.println("Novo arquivo");
            else salvarF();
        }
        else if(choice == compilarI  )  compilarF();
    }
}
