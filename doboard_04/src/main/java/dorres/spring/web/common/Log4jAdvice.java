package dorres.spring.web.common;

public class Log4jAdvice {
	public void printLogging() {
		System.out.println("[�α� - Log4jAdvice] : ����Ͻ� ���� ���� �� ����");
	}
}
//<bean id="log" class="dorres.spring.web.common.Log4jAdvice"></bean>
//<aop:config>
//	<aop:pointcut expression="execution(* dorres.spring.web..*Impl.*(..))" id="allPointcut"/>
//	<aop:aspect ref="log">
//		<aop:before method="printLogging" pointcut-ref="allPointcut"/>
//	</aop:aspect>
//</aop:config>


//<aop:config>
//	<aop:pointcut expression="execution(* tommy.spring.web..*Impl.*(..))" id="allPointcut"/>
//	<aop:pointcut expression="execution(* tommy.spring.web..*Impl.get*(..))" id="getPointcut"/>
//	<aop:aspect ref="log">
//		<aop:before method="printLogging" pointcut-ref="getPointcut"/>
//	</aop:aspect>
//</aop:config>
