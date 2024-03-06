package com.example.dictionary;

import java.util.List;

public class Model {
    String word;
    List<Phonetics> phonetics;
    List<Meanings> meanings;

    public String getWord() {
        return word;
    }

    public List<Phonetics> getPhonetics() {
        return phonetics;
    }

    public List<Meanings> getMeanings() {
        return meanings;
    }
}
