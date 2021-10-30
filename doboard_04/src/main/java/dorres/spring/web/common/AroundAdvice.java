package dorres.spring.web.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("[BEFORE] : ����Ͻ� �޼��� ���� ���� ó���� ���� ...");
		Object returnObj = joinPoint.proceed();
		System.out.println("[AFTER] ����Ͻ� �޼��� ���� �Ŀ� ó���� ���� ...");
		return returnObj;
	}
}
//<bean id="around" class="dorres.spring.web.common.AroundAdvice"></bean>
//<aop:config>
//	<aop:pointcut expression="execution(* dorres.spring.web..*Impl.*(..))" id="allPointcut"/>
//	<aop:aspect ref="around">
//		<aop:around method="aroundLog" pointcut-ref="allPointcut"/>
//	</aop:aspect>
//</aop:config>