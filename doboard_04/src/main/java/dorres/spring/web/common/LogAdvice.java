package dorres.spring.web.common;

public class LogAdvice {
	public void printLog() {
		System.out.println("[�α�] : ����Ͻ� ���� ���� �� ����");
	}
}

//<bean id="log" class="dorres.spring.web.common.LogAdvice"></bean>
//<aop:config>
//	<aop:pointcut expression="execution(* dorres.spring.web..*Impl.*(..))" id="allPointcut"/>
//	<aop:aspect ref="log">
//		<aop:before method="printLog" pointcut-ref="allPointcut"/>
//	</aop:aspect>
//</aop:config>