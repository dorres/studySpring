package dorres.spring.web.common;

public class AfterReturningAdvice {
	public void afterLog() {
		System.out.println("[사후처리] : 비즈니스 로직 수행 후 처리");
	}
}

//<bean id="afterReturning" class="dorres.spring.web.common.AfterReturningAdvice"></bean>
//<aop:config>
//	<aop:pointcut expression="execution(* dorres.spring.web..*Impl.*(..))" id="allPointcut"/>
//	<aop:aspect ref="afterReturning">
//		<aop:after-returning method="afterLog" pointcut-ref="allPointcut"/>
//	</aop:aspect>
//</aop:config>