package dorres.spring.web.common;

public class AfterThrowingAdvice {
	public void exceptionLog() {
		System.out.println("[����ó��] : ����Ͻ� ���� ���� �� ���� �߻�");
	}
}
//���ܸ� �߻���Ű�� ���ؼ� BoardServiceImpl Ŭ���� insert�޼��带 �����ؾ���
//if(vo.getSeq() == 0) {
//	throw new IllegalArgumentException("0�� ���� ����� �� �����ϴ�.");
//}


//<bean id="afterThrowing" class="dorres.spring.web.common.AfterThrowingAdvice"></bean>
//<aop:config>
//	<aop:pointcut expression="execution(* dorres.spring.web..*Impl.*(..))" id="allPointcut"/>
//	<aop:aspect ref="afterThrowing">
//		<aop:after-throwing method="exceptionLog" pointcut-ref="allPointcut"/>
//	</aop:aspect>
//</aop:config>