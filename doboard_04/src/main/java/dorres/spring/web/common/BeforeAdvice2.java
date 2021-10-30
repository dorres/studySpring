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
		System.out.println("[����ó��] : " + method + "() �޼����� ARGS ���� : " + args[0].toString());
	}
}
//<aop:aspectj-autoproxy></aop:aspectj-autoproxy>

//@Before("PointcutCommon.allPointcut()")
//�̰͵� ����