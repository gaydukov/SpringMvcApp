package com.springmvcrest;


import com.springmvcrest.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInit implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class);
        //LoaderListener
        servletContext.addListener(new ContextLoaderListener(ctx));
        //DispatcherServlet
        ServletRegistration.Dynamic servlet=servletContext.addServlet("dispatcher",new DispatcherServlet(ctx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        // Filter
        FilterRegistration.Dynamic filterEncoding = servletContext.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
        filterEncoding.setInitParameter("encoding", "UTF-8");
        filterEncoding.setInitParameter("forceEncoding", "true");
        filterEncoding.addMappingForServletNames(null, true, "dispatcher");
    }
}
