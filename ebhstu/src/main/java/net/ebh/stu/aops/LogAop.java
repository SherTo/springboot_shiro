package net.ebh.stu.aops;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 *
 * AOP DEMO
 */
@Aspect
@Order(1)
@Configuration
public class LogAop {
    public static final Logger logger = LoggerFactory.getLogger(LogAop.class);

    @Pointcut("execution(* net.ebh.stu.controller.*.*(..))")
    private void anyMethod(){}

    @Before("anyMethod()")
    public void doBefore(JoinPoint point) {
        System.out.println("@Before：模拟权限检查...");
        System.out.println("@Before：目标方法为：" +
                point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("@Before：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("@Before：被织入的目标对象为：" + point.getTarget());
    }

    @AfterReturning(pointcut="anyMethod()",
            returning="returnValue")
    public void log(JoinPoint point, Object returnValue) {
        System.out.println("@AfterReturning：模拟日志记录功能...");
        System.out.println("@AfterReturning：目标方法为：" +
                point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("@AfterReturning：参数为：" +
                Arrays.toString(point.getArgs()));
        System.out.println("@AfterReturning：返回值为：" + returnValue);
        System.out.println("@AfterReturning：被织入的目标对象为：" + point.getTarget());

    }

    @After("anyMethod()")
    public void releaseResource(JoinPoint point) {
        System.out.println("@After：模拟释放资源...");
        System.out.println("@After：目标方法为：" +
                point.getSignature().getDeclaringTypeName() +
                "." + point.getSignature().getName());
        System.out.println("@After：参数为：" + Arrays.toString(point.getArgs()));
        System.out.println("@After：被织入的目标对象为：" + point.getTarget());
    }
}
