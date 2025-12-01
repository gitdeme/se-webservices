package org.wldu.webservices.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig {
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "persons")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema personSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("PersonPort");
        definition.setTargetNamespace("http://example.com/person");
        definition.setLocationUri("/ws");
        definition.setSchema(personSchema);
        return definition;
    }

    @Bean
    public XsdSchema personSchema() {
        return new SimpleXsdSchema(new ClassPathResource("person.xsd"));
    }

    // ========== COURSE SERVICE ==========
    @Bean(name = "courses")
    public DefaultWsdl11Definition courseWsdl(XsdSchema courseSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("CoursePort");
        wsdl.setTargetNamespace("http://example.com/course");
        wsdl.setLocationUri("/ws/course");
        wsdl.setSchema(courseSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema courseSchema() {
        return new SimpleXsdSchema(new ClassPathResource("course.xsd"));
    }
    @Bean(name = "calculator")
    public DefaultWsdl11Definition calculatorWsdl11Definition(XsdSchema calculatorSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("CalculatorPort");
        wsdl.setTargetNamespace("http://example.com/calculator");
        wsdl.setLocationUri("/ws");
        wsdl.setSchema(calculatorSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema calculatorSchema() {
        return new SimpleXsdSchema(new ClassPathResource("calculator.xsd"));
    }


}