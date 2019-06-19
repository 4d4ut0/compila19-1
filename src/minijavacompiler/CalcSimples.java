package minijavacompiler;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bianca
 */
public class CalcSimples 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
    	MainWindow janela;
    	janela = new MainWindow() {
			@Override
			public void compilarF() {
			if(!filename.equals("new")){
				Parser p = new Parser(filename);
				Parser.Erros = "";
				Parser.Erros = Parser.Erros+("Compilação iniciada");
				Parser.Erros = (Parser.Erros+'\n');
				Parser.Erros = (Parser.Erros+"----------------------------------------");
				Parser.Erros = (Parser.Erros+'\n');
				MainWindow.areaParaExibir.setText(Parser.Erros);
				p.program();
				Parser.Erros = (Parser.Erros+"----------------------------------------");
				Parser.Erros = (Parser.Erros+'\n');
				Parser.Erros = Parser. Erros+("Compilação finalizada!!!");
				MainWindow.areaParaExibir.setText(Parser.Erros);
			}
			else{
				JOptionPane.showMessageDialog(null, "Necessário salvar para poder compilar, por favor, salve dentro da pasta do projeto");
			}
		        
		       
				
			}
		};
       
   	
    }
    
}