/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.tester;

import org.springframework.stereotype.Service;

@Service
public class AnswerCalculator {
    private int trueAnswers = 0;

    public void addTrue(){
        trueAnswers++;
    }

    public int getTrueAnswers() {
        return trueAnswers;
    }
}
