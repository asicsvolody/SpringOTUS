/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.question;

import java.util.*;
import java.util.stream.Collectors;

public class Question implements Questioner{
    private String question;
    private List<Answer> answers;

    //    ---question---,---trueAns---,---falseAns1---,---falseAns2---,---falseAns3---
    public Question(String line) {
        String[] dataArr = line.split(",");
        this.question = dataArr[0].trim();
        this.answers = readAnswers(dataArr[1], Arrays.copyOfRange(dataArr, 2, dataArr.length));
    }

    public String getQuestion() {
        return question;
    }

    @Override
    public boolean askQuestion(Scanner in){
        System.out.println(question);
        for (Answer answer : answers) {
            answer.printAnswer();
        }
        return isTrue(in.nextInt());

    }

    private List<Answer> readAnswers(String trueAns, String ... falseAns){
        final int countAnswer = falseAns.length + 1;
        int numberOfAnswer = ((int) (Math.random() * countAnswer-1))+1;

        List<Answer> resList = new ArrayList<>(countAnswer);
        resList.add(new Answer(numberOfAnswer, trueAns.trim(), true));

        for (String falseAn : falseAns) {
            numberOfAnswer = (numberOfAnswer == countAnswer) ? 1 : numberOfAnswer + 1;
            resList.add(new Answer(numberOfAnswer, falseAn.trim(), false));
        }
        return resList
                .stream()
                .sorted(Comparator.comparingInt(Answer::getNumber))
                .collect(Collectors.toList());
    }

    private boolean isTrue(int answer){
        return answers.stream()
                .filter(v -> v.getNumber() == answer)
                .anyMatch(Answer::isTrue);
    }
}
