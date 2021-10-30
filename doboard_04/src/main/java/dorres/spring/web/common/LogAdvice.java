package dorres.spring.web.common;

public class LogAdvice {
	public void printLog() {
		System.out.println("[로그] : 비즈니스 로직 수행 전 동작");
	}
}

//<bean id="log" class="dorres.spring.web.common.LogAdvice"></bean>
//<aop:config>
//	<aop:pointcut expression="execution(* dorres.spring.web..*Impl.*(..))" id="allPointcut"/>
//	<aop:aspect ref="log">
//		<aop:before method="printLog" pointcut-ref="allPointcut"/>
//	</aop:aspect>
//</aop:config>