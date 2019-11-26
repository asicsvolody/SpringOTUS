/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.quesReader;

import ru.yakimov.question.Questioner;

import java.io.IOException;
import java.util.List;

public interface QuestionReader {
    List<Questioner> readCsvQuestions() throws IOException;
}
