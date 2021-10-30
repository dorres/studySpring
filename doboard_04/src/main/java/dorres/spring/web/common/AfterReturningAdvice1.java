package dorres.spring.web.common;

import org.aspectj.lang.JoinPoint;

import dorres.spring.web.user.UserVO;

public class AfterReturningAdvice1 {
	public void afterLog(JoinPoint joinPoint, Object returnObj) {
		String method = joinPoint.getSignature().getName();
		if (returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if (user.getRole().equals("admin")) {
				System.out.println(user.getName() + " 로그인(Admin)");
			}
		}
		System.out.println("[사후처리] : " + method + "() 메서드 리턴값 : " + returnObj.toString());
	}
}
//<bean id="afterReturning" class="dorres.spring.web.common.AfterReturningAdvice1"></bean>
//<aop:config>
//	<aop:pointcut expression="execution(* dorres.spring.web..*Impl.*(..))" id="allPointcut"/>
//	<aop:pointcut expression="execution(* tommy.spring.web..*Impl.get*(..))" id="getPointcut"/>
//	<aop:aspect ref="afterReturning">
//		<aop:after-returning method="aroundLog" pointcut-ref="allPointcut"/>
//		<aop:after-returning method="beforeLog" pointcut-ref="getPointcut"/>
//	</aop:aspect>
//</aop:config>