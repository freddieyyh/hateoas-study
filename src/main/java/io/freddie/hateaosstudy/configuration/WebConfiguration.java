package io.freddie.hateaosstudy.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@Configuration
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean<ShallowEtagHeaderFilter> etagFilter() {
        FilterRegistrationBean<ShallowEtagHeaderFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new ShallowEtagHeaderFilter());
        registrationBean.addUrlPatterns("/companies/*");

        return registrationBean;
    }
}
