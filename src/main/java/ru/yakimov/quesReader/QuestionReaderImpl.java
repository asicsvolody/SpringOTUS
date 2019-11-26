/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.quesReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.yakimov.question.Question;
import ru.yakimov.question.Questioner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@PropertySource("classpath:app.properties")
public class QuestionReaderImpl implements QuestionReader {
    private String url;

    public QuestionReaderImpl(@Value("${qw.file.url}") String url) {
        this.url = url;
    }

    //    ---question---,---trueAns---,---falseAns1---,---falseAns2---,---falseAns3---
    @Override
    public List<Questioner> readCsvQuestions() throws IOException {
        return Files.readAllLines(Paths.get(url))
                .stream()
                .filter(v -> !v.startsWith("---question---,"))
                .map(Question::new)
                .collect(Collectors.toList());
    }
}
