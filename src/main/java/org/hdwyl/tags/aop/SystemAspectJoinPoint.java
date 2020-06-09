package org.hdwyl.tags.aop;

import com.atme8.project.insuser.model.InsuserModel;
import org.hdwyl.tags.common.Constants;
import org.hdwyl.tags.service.BaseService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class SystemAspectJoinPoint {

    /**
     * 在调用所有Service方法前注入loginUser
     *
     * @param joinPoint
     */
    @Before("execution(* com.atme8.ddmp.service.*.*.*(..))")
    public void beforeAllServiceAdvice(JoinPoint joinPoint) {
        // 从Session中获取loginUser
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        InsuserModel loginUser = (InsuserModel) request.getSession().getAttribute(
                Constants.KEY_LOGIN_USER);
        // 注入loginUser
        Object obj = joinPoint.getTarget();

        if (BaseService.class.isAssignableFrom(obj.getClass())) {
            ((BaseService) obj).setLoginUser(loginUser);
        }
    }

}
