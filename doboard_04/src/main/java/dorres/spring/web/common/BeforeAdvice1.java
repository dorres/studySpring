package dorres.spring.web.common;

import org.aspectj.lang.JoinPoint;

public class BeforeAdvice1 {
	public void beforeLog(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("[사전처리] : " + method + "() 메서드의 ARGS 정보 : " + args[0].toString());
	}
}
//<bean id="before" class="dorres.spring.web.common.BeforeAdvice1"></bean>
//<aop:config>
//	<aop:pointcut expression="execution(* dorres.spring.web..*Impl.*(..))" id="allPointcut"/>
//	<aop:pointcut expression="execution(* tommy.spring.web..*Impl.get*(..))" id="getPointcut"/>
//	<aop:aspect ref="before">
//		<aop:before method="beforeLog" pointcut-ref="allPointcut"/>
//		<aop:before method="beforeLog" pointcut-ref="getPointcut"/>
//	</aop:aspect>
//</aop:config>