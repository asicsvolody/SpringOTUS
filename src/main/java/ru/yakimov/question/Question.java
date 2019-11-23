/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.question;
import ru.yakimov.answer.Answer;
import ru.yakimov.answer.Answerar;

import java.util.Arrays;
import java.util.List;

public class Question implements Questioner{
    private String question;
    private List<Answerar> answers;

    public Question(String question, Answerar... answers) {
        this.question = question;
        this.answers = Arrays.asList(answers);
    }

    @Override
    public void askQuestion(){
        System.out.println(question);
        for (Answerar answer : answers) {
            answer.printAnswer();
        }
    }

    @Override
    public boolean isTrue(int answer){
        return answers.stream()
                .filter(v -> v.getNumber() == answer)
                .anyMatch(Answerar::isTrue);
    }
}
