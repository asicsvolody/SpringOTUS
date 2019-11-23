/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.answer;
public class Answer implements Answerar{
    private int number;
    private String answer;
    private boolean isTrue;

    public Answer(int number, String answer, boolean isTrue) {
        this.number = number;
        this.answer = answer;
        this.isTrue = isTrue;
    }

    @Override
    public void printAnswer(){
        System.out.printf("%d) %s\n", number, answer);
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public boolean isTrue() {
        return isTrue;
    }
}
