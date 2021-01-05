package com.ly.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect 	//该标签把RoleAop类声明为一个切面
@Order(1)	//设置切面的优先级：如果有多个切面，可通过设置优先级控制切面的执行顺序（数值越小，优先级越高）
@Component  //该标签把RoleAop类放到IOC容器中
public class RoleAop {
	
    /**
     * 定义一个方法，用于声明切入点表达式，方法中一般不需要添加其他代码
     * 使用@Pointcut声明切入点表达式
     * 后面的通知直接使用方法名来引用当前的切点表达式；如果是其他类使用，加上包名即可
     */
	@Pointcut("execution(public * com.ly.controller.*.*(..))")
	public void declearJionPointExpression() {}
	
	
	//前置通知
	//该标签声明次方法是一个前置通知：在目标方法开始之前执行
	@Before("declearJionPointExpression()")
	public void before(JoinPoint point) {
		String name = point.getSignature().getName();
		System.out.println("Before Method name: " + name);
		
	}
	
	//后置通知（无论方法是否发生异常都会执行,所以访问不到方法的返回值）
	@After("declearJionPointExpression()")
	public void after(JoinPoint point) {
		String name = point.getSignature().getName();
		System.out.println("After Method name: " + name);
	}
	
	
	// 返回通知（在方法正常结束执行的代码） 返回通知可以访问到方法的返回值！
	@AfterReturning(value = "declearJionPointExpression()", returning = "result")
	public void afterReturn(JoinPoint point, Object result) {
		String name = point.getSignature().getName();
		System.out.println("AfterReturn Method name: " + name + ", result: " + result);
	}
	
	//异常通知（方法发生异常执行的代码）可以访问到异常对象；且可以指定在出现特定异常时执行的代码
	@AfterThrowing(value = "declearJionPointExpression()", throwing = "ex")
	public void afterThrowing(JoinPoint point, Exception ex) {
		String name = point.getSignature().getName();
		System.out.println("AfterThrowing Method name: " + name + ", exception: " + ex.getMessage());
	}
	
	/**
     * 环绕通知(需要携带类型为ProceedingJoinPoint类型的参数)
     * 环绕通知包含前置、后置、返回、异常通知；ProceedingJoinPoin 类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值，返回值即目标方法的返回值
     * @param point
     */
	@Around("declearJionPointExpression()")
	public Object around(ProceedingJoinPoint point) {
		String name = point.getSignature().getName();
		try {
			System.out.println("Around Method name: " + name);
			//前置通知
			System.out.println("Around Method agrs: " + Arrays.asList(point.getArgs()));
			
			//执行目标方法
			Object result = point.proceed();
			
			//返回通知
			System.out.println("Around Method result: " + result);
			return result;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
}
