/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.configuratiions;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.yakimov.answer.Answer;
import ru.yakimov.question.Question;

@Configuration
@PropertySource("classpath:app.properties")
public class AppConfiguration {

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
//        return new PropertySourcesPlaceholderConfigurer();
//    }

    @Bean
    public Answer qw1Ans1(@Value("${qw1.ans1.number}") int number, @Value("${qw1.ans1.value}")  String answer, @Value("${qw1.ans1.isTrue}")boolean isTrue){
        return new Answer(number, answer, isTrue);
    }

    @Bean
    public Answer qw1Ans2(@Value("${qw1.ans2.number}") int number,@Value("${qw1.ans2.value}")  String answer, @Value("${qw1.ans2.isTrue}")boolean isTrue){
        return new Answer(number, answer, isTrue);
    }

    @Bean
    public Answer qw1Ans3(@Value("${qw1.ans3.number}") int number,@Value("${qw1.ans3.value}")  String answer, @Value("${qw1.ans3.isTrue}")boolean isTrue){
        return new Answer(number, answer, isTrue);
    }


    @Bean
    public Question question1 (@Value("${qw1.name}") String name, @Qualifier("qw1Ans1") Answer answer1, @Qualifier("qw1Ans2") Answer answer2, @Qualifier("qw1Ans3") Answer answer3){
        return new Question(name, answer1, answer2, answer3);
    }

    @Bean
    public Answer qw2Ans1(@Value("${qw2.ans1.number}") int number,@Value("${qw2.ans1.value}")  String answer, @Value("${qw2.ans1.isTrue}")boolean isTrue){
        return new Answer(number, answer, isTrue);
    }

    @Bean
    public Answer qw2Ans2(@Value("${qw2.ans2.number}") int number,@Value("${qw2.ans2.value}")  String answer, @Value("${qw2.ans2.isTrue}")boolean isTrue){
        return new Answer(number, answer, isTrue);
    }

    @Bean
    public Answer qw2Ans3(@Value("${qw2.ans3.number}") int number,@Value("${qw2.ans3.value}")  String answer, @Value("${qw2.ans3.isTrue}")boolean isTrue){
        return new Answer(number, answer, isTrue);
    }

    @Bean
    public Question question2 (@Value("${qw2.name}") String name, @Qualifier("qw2Ans1") Answer answer1, @Qualifier("qw2Ans2") Answer answer2, @Qualifier("qw2Ans3") Answer answer3){
        return new Question(name, answer1, answer2, answer3);
    }


}
