package pers.ninthseason.welltried.dao;

import java.util.List;

public interface WordMapper {
    List<Word> getAllWords();

    int insertWord(String word, String transition);
}
