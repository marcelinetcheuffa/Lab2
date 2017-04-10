package it.polito.tdp.alien;

import java.util.*;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

public class AlienDictionary {
	private Set<Word> dictionary;

	public AlienDictionary() {
		this.dictionary = new HashSet<>();
	}

	public void addWord(String alienWord, String translation) {
		Word w = this.getWord(alienWord);
		if (w == null) {
			w = new Word(alienWord, translation);
			dictionary.add(w);
		} else {
			w.setTranslation(translation);
			dictionary.add(w);
		}
	}

	public String translateWord(String alienWord) {
	  Word word = this.getWord(alienWord);
	  if(word!=null){
	    return word.getTranslation();
	  }
	  return null;
	}

	public String compare(String alienWord) {
		Word w = this.getWord(alienWord);
		if (w != null) {
			return w.getAlienWord();
		}
		return null;
	}

	public Word getWord(String alienWord) {
		for (Word word : dictionary) {
			if (word.getAlienWord().equals(alienWord)) {
				return word;
			}
		}
		return null;
	}

}
