package dorres.spring.web.common;

public class AfterThrowingAdvice {
	public void exceptionLog() {
		System.out.println("[예외처리] : 비즈니스 로직 수행 중 예외 발생");
	}
}
//예외를 발생시키기 위해서 BoardServiceImpl 클래스 insert메서드를 수정해야함
//if(vo.getSeq() == 0) {
//	throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
//}


//<bean id="afterThrowing" class="dorres.spring.web.common.AfterThrowingAdvice"></bean>
//<aop:config>
//	<aop:pointcut expression="execution(* dorres.spring.web..*Impl.*(..))" id="allPointcut"/>
//	<aop:aspect ref="afterThrowing">
//		<aop:after-throwing method="exceptionLog" pointcut-ref="allPointcut"/>
//	</aop:aspect>
//</aop:config>