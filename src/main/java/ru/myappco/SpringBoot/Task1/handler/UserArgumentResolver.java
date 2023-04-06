package ru.myappco.SpringBoot.Task1.handler;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import ru.myappco.SpringBoot.Task1.entity.User;

public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        String login = webRequest.getParameter("user");
        String password = webRequest.getParameter("password");

        if (isNotSet(login)) {
            login = "empty";
        }

        if (isNotSet(password)) {
            password = "empty";
        }

        return new User(login, password);
    }

    private boolean isNotSet(String value) {
        return value == null;
    }
}
