package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {
	
	//List<String> paroleITA ;
	List<String> parole ;
	List<RichWord> listaRichWord ;
	
	public Dictionary() {
	//	paroleITA = new ArrayList<String>();
		parole = new ArrayList<String>();
		listaRichWord = new ArrayList<RichWord>();
	}
	
	
	public void loadDictionary(String language) {
		parole.clear();
		
		if(language.equals("English")){
		  try {
	             FileReader fr = new FileReader("src/main/resources/English.txt");
	                    BufferedReader br = new BufferedReader(fr);
	             String word;
	             while ((word = br.readLine()) != null) {
	                          // Aggiungere parola alla struttura dati
	            	 parole.add(word.toLowerCase());
	}
	br.close();
	        } catch (IOException e){
	             System.out.println("Errore nella lettura del file");
	              }
	      
		}else {
			  try {
		             FileReader fr = new FileReader("src/main/resources/Italian.txt");
		                    BufferedReader br = new BufferedReader(fr);
		             String word;
		             while ((word = br.readLine()) != null) {
		                          // Aggiungere parola alla struttura dati
		            	 parole.add(word.toLowerCase());
		}
		br.close();
		        } catch (IOException e){
		             System.out.println("Errore nella lettura del file");
		              }
		      
			
		}
	}

	public List<RichWord> spellCheckText(List<String> inputTextList){
		
		listaRichWord.clear();
		RichWord temp ;
		for(String s: inputTextList) {
			if(parole.contains(s)) {
				temp =new RichWord(s,false);
				listaRichWord.add(temp);
			}else {
				temp =new RichWord(s,true);
				listaRichWord.add(temp);
			}
		}
		return listaRichWord;
	}
	
	
}
