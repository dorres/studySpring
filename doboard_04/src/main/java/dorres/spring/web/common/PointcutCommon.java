package dorres.spring.web.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	@Pointcut("execution(* dorres.spring.web..*Impl.*(..))")
	public void allPointcut() {
	}
	@Pointcut("execution(* dorres.spring.web..*Impl.get*(..))")
	public void getPointcut() {
	}
}
