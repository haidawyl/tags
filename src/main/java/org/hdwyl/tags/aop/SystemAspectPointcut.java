package org.hdwyl.tags.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SystemAspectPointcut {

	// 所有Service方法的切入点
	@Pointcut("within(com.atme8.ddmp.service..*)")
	public void allServiceMethodsPointcut() {
	}

	@Before("allServiceMethodsPointcut()")
	public void beforeAllServiceMethodsAdvice() {
	}

	@After("allServiceMethodsPointcut()")
	public void afterAllServiceMethodsAdvice() {
	}

}
