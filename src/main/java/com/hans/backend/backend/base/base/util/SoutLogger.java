package com.hans.backend.backend.base.base.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class SoutLogger {

    /*
    execution => method level
    within => class or package level

    execution syntax :
    - <returnType> <class: FQCN> <method> (<arguments>)
    - * be.cvofocus.registrations.registration.service.service.RegistrationService..*(..):
            - <returnType> = * => any
            - <class> = be.cvofocus.registrations.registration.service.service.RegistrationService
            - <method> = ..* => any (ex. ..find* = all methods starting with find)
            - <arguments> = (..) => any (other ex. (Long, ..) => first arg = Long and then others)
     */

//     @Before(value = "execution(* be.cvofocus.*..getAllForOrganizer(..))")
//     public void beforeAdvice(JoinPoint jp){
//         System.out.println("args : " + Arrays.toString(jp.getArgs()));
//         System.out.println("HANS : " + jp.getSignature().getName());
//         System.out.println(">>>> Before <<<<");
//     }

//    @After(value = "execution(* be.cvofocus.registrations.registration.service.service.RegistrationService..*(..))")
//    public void afterAdvice(JoinPoint jp){
//        System.out.println("target : " + jp.getTarget());
//        System.out.println(">>>> After <<<<");
//    }
//
//    @AfterReturning(value = "execution(* be.cvofocus.registrations.registration.service.service.RegistrationService..*(..))")
//    public void afterReturnAdvice(JoinPoint jp){
//        System.out.println(">>>> AfterReturn <<<<");
//    }
//
//    @Around(value = "execution(* be.cvofocus.registrations.registration.service.service.RegistrationService..*(..))")
//    public void aroundAdvice(ProceedingJoinPoint pjp){
//        System.out.println(">>>> Start around <<<<");
//        try{
//            pjp.proceed();
//            System.out.println(">>>> End around in try<<<<");
//        } catch (Throwable e) {
//            throw new RuntimeException(e);
//        }
//    }
}