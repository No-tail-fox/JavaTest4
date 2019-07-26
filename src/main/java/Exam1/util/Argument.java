package Exam1.util;

import Exam1.domain.Page;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class Argument implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(Page.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String page = request.getHeader("page");
        String pageSize = request.getHeader("pageSize");
        Page pagex= (Page) redisService.find(openId);
        if(currentUser == null){
            List<HaierUser> userList = userRepository.findByMobileAndUserState(openId, "1");
            if(userList.size() > 0 ){
                currentUser = new CurrentUser();
                BeanUtils.copyProperties(userList.get(0), currentUser);
                redisService.add(openId, currentUser);
            }
        }
        return currentUser;
    }

}
}
