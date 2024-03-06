package com.example.dictionary;

import java.util.List;

public class Meanings {
    String partOfSpeech;
    public class Definitions{
        String definition;

        public String getDefinition() {
            return definition;
        }
    }
    List<Definitions> definitions;

    public String getPartOfSpeech() {
        return partOfSpeech;
    }
}
