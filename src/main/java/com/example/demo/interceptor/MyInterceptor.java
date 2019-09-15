package com.example.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class MyInterceptor implements HandlerInterceptor {

    private static final int LENGTH_EMPTY_PATH = 1;
    private static final int LENGTH_PARAMETER_DELETE = 7;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        final Set stopWords = Collections.synchronizedSet(new HashSet(Arrays.asList(".", ",", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "`", "~", "\\", "|", "%3C", "%3E")));

        final String currentPath = request.getRequestURI().substring(1);
        System.out.println(currentPath);
        System.out.println(currentPath.matches("[a-z]+"));

        for (Iterator iter = stopWords.iterator(); iter.hasNext(); ) {
            if (currentPath.contains(iter.next().toString())) {
                response.sendRedirect("/pageFraud");
                return false;
            }
        }

        if (currentPath.length() < LENGTH_EMPTY_PATH) {
            response.sendRedirect("/pageEmptyParam");
            return false;
        } else if (currentPath.length() <= LENGTH_PARAMETER_DELETE && currentPath.toUpperCase().contains("DELETE")) {
            response.sendRedirect("/pageEmptyDelete");
            return false;
        } else if (currentPath.matches("[a-z]+")) {
            response.sendRedirect("/wrongParameterDelete");
            return false;
        }
        return true;
    }
}
