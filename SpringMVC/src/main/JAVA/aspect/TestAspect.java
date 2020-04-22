package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class TestAspect {

    @Pointcut("execution(* service..*.*(..))")
    public void service(){

    }
    //Advice
    @Before("service()")
    public void beforeService(){
        System.out.println("Before Service.");
    }

    @After("service()")
    public void afterService(){
        System.out.println("After Service.");
    }

    //before /after
    @Around("service()")
    public Object aroundService(ProceedingJoinPoint jp){
        Object object=null;
        try{
            System.out.println("Before Around Service.");
            object=jp.proceed();
            System.out.println("After Around Service.");
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return object;
    }
}
