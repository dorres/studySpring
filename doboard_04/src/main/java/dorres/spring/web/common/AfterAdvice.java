package dorres.spring.web.common;

public class AfterAdvice {
	public void finallyLog() {
		System.out.println("[����ó��] : ����Ͻ� ���� ���� �� ������ ����");
	}
}

//<bean id="after" class="dorres.spring.web.common.AfterAdvice"></bean>
//<aop:config>
//	<aop:pointcut expression="execution(* dorres.spring.web..*Impl.*(..))" id="allPointcut"/>
//	<aop:aspect ref="after">
//		<aop:after method="finallyLog" pointcut-ref="allPointcut"/>
//	</aop:aspect>
//</aop:config>