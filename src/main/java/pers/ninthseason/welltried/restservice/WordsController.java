package pers.ninthseason.welltried.restservice;


import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;
import pers.ninthseason.welltried.dao.SqlFactory;
import pers.ninthseason.welltried.dao.Word;
import pers.ninthseason.welltried.dao.WordMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class WordsController {

    @GetMapping("/data")
    public String getAll() {
        List<Word> wordlist;
        try (SqlSession session = SqlFactory.getFactory().openSession()) {
            WordMapper mapper = session.getMapper(WordMapper.class);
            wordlist = mapper.getAllWords();
        }

        if (wordlist == null) {
            return "";
        } else {
            String text = wordlist.toString();
            return "{" + text.substring(1, text.length() - 1) + "}";
        }
    }

    @PostMapping("/data")
    public boolean insertWord(@RequestBody Map<String, String> map) {
        if (!map.get("token").equals("1346")) {
            return false;
        }
        String word = map.get("word").strip();
        String transition = map.get("transition").strip();
        if (word.equals("") || transition.equals("")) {
            return false;
        }
        try (SqlSession session = SqlFactory.getFactory().openSession()) {
            WordMapper mapper = session.getMapper(WordMapper.class);
            int res = mapper.insertWord(word, transition);
            if (res == 1) {
                session.commit();
            }
        }
        return true;
    }
}