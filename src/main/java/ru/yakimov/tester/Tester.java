/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.tester;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import ru.yakimov.quesReader.QuestionReader;
import ru.yakimov.question.Questioner;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Service
public class Tester {
    private AnswerCalculator answerCalculator;
    private List<Questioner> questions;

    private String name;
    private String surname;

    public Tester(AnswerCalculator answerCalculator, QuestionReader questionRider) throws IOException {
        this.answerCalculator = answerCalculator;
        this.questions = questionRider.readCsvQuestions();
    }

    public void testing(){
        Scanner in = new Scanner(System.in);
        System.out.print("Name: " );
        name = in.nextLine();
        System.out.print("\nSurname: ");
        surname = in.nextLine();

        for (Questioner question : questions) {
            if(ask(question,in))
                answerCalculator.addTrue();
        }
        System.out.printf("Results %s %s is %d\n",name,surname,answerCalculator.getTrueAnswers());
        in.close();
    }

    public boolean ask(Questioner question, Scanner in){
        return question.askQuestion(in);
    }

    public void askFirst(){
        System.out.println("Hello!!!!!!");
    }

}
