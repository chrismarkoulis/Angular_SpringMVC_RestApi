package com.chrismark.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author chris
 */
public class MyDispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class[] {MyWebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        
        return new String[] {"/"};
    }
    
}
