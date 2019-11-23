/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.tester;

import org.springframework.stereotype.Service;
import ru.yakimov.question.Question;
import ru.yakimov.question.Questioner;

import java.util.List;
import java.util.Scanner;

@Service
public class Tester {
    private AnswerCalculator answerCalculator;
    private List<Questioner> questions;

    private String name;
    private String surname;

    public Tester(AnswerCalculator answerCalculator, List<Questioner> questions) {
        this.answerCalculator = answerCalculator;
        this.questions = questions;
    }

    public void testing(){
        Scanner in = new Scanner(System.in);
        System.out.print("Name: " );
        name = in.nextLine();
        System.out.print("\nSurname: ");
        surname = in.nextLine();

        int answer;
        for (Questioner question : questions) {
            question.askQuestion();
            answer = in.nextInt();
            if(question.isTrue(answer))
                answerCalculator.addTrue();

        }
        System.out.printf("Results %s %s is %d",name,surname,answerCalculator.getTrueAnswers());

        in.close();
    }

}
