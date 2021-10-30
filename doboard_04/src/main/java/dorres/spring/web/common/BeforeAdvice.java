package dorres.spring.web.common;

public class BeforeAdvice {
	public void beforeLog() {
		System.out.println("[사전처리] : 비즈니스 로직 수행 전 동작");
	}
}

//<bean id="before" class="dorres.spring.web.common.BeforeAdvice"></bean>
//<aop:config>
//	<aop:pointcut expression="execution(* dorres.spring.web..*Impl.*(..))" id="allPointcut"/>
//	<aop:aspect ref="before">
//		<aop:before method="beforeLog" pointcut-ref="allPointcut"/>
//	</aop:aspect>
//</aop:config>