package dorres.spring.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice2 {
	@Pointcut("execution(* dorres.spring.web..*Impl.*(..))")
	public void allPointcut() {
	}

	@Before("allPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("[사전처리] : " + method + "() 메서드의 ARGS 정보 : " + args[0].toString());
	}
}
//<aop:aspectj-autoproxy></aop:aspectj-autoproxy>

//@Before("PointcutCommon.allPointcut()")
//이것도 가능