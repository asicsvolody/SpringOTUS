/**
 * Created by IntelliJ Idea.
 * User: Якимов В.Н.
 * E-mail: yakimovvn@bk.ru
 */

package ru.yakimov.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {

    @Around("execution(* ru.yakimov.tester.Tester.*(..))")
    public Object logQuestion(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Ask question");
        Object res = joinPoint.proceed();
        System.out.println("Answer is "+ res);
        return res;
    }

}
