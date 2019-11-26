/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.question;
public class Answer{
    private int number;
    private String answer;
    private boolean isTrue;

    public Answer(int number, String answer, boolean isTrue) {
        this.number = number;
        this.answer = answer;
        this.isTrue = isTrue;
    }

    public void printAnswer(){
        System.out.printf("%d) %s\n", number, answer);
    }
    public int getNumber() {
        return number;
    }
    public boolean isTrue() {
        return isTrue;
    }
}
