package dorres.spring.web.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice2 {
	@Pointcut("execution(* dorres.spring.web..*Impl.*(..))")
	public void allPointcut() {
	}

	@After("allPointcut()")
	public void finallyLog() {
		System.out.println("[사후처리 : 비즈니스 로직 수행 후 무조건 동작");
	}
}

//<aop:aspectj-autoproxy></aop:aspectj-autoproxy>

//@After("PointcutCommon.allPointcut()")