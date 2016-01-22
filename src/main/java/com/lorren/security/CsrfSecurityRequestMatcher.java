package com.lorren.security;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.CollectionUtils;

public class CsrfSecurityRequestMatcher implements RequestMatcher {

    private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");

    private List<String> execludeURLs;

    public boolean matches(HttpServletRequest request) {
        if (!CollectionUtils.isEmpty(execludeURLs)) {
            String servletPath = request.getServletPath();
            for (String url : execludeURLs) {
                if (servletPath.contains(url)) {
                    return false;
                }
            }
        }
        return !allowedMethods.matcher(request.getMethod()).matches();
    }

    public List<String> getExecludeURLs() {
        return execludeURLs;
    }
    public void setExecludeURLs(List<String> execludeURLs) {
        this.execludeURLs = execludeURLs;
    }


}
