package dorres.spring.web.common;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice1 {
	public void exceptionLog(JoinPoint joinPoint, Exception e) {
		String method = joinPoint.getSignature().getName();
		System.out.println("[예외처리] : " + method + "() 메서드 수행 중 발생된 예외 메세지 : " + e.getMessage());
	}
}
//<bean id="afterThrowing" class="dorres.spring.web.common.AfterThrowingAdvice1"></bean>
//<aop:config>
//	<aop:pointcut expression="execution(* dorres.spring.web..*Impl.*(..))" id="allPointcut"/>
//	<aop:pointcut expression="execution(* tommy.spring.web..*Impl.get*(..))" id="getPointcut"/>
//	<aop:aspect ref="afterThrowing">
//		<aop:after-throwing method="exceptionLog" pointcut-ref="allPointcut"/>
//		<aop:after-throwing method="exceptionLog" pointcut-ref="getPointcut"/>
//	</aop:aspect>
//</aop:config>