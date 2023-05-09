package com.projectstudy.all_utils.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class StaticConfig {

    /**
     * 정적 리소스 커스텀 방법
     * addResourceHandler - 어느 경로로 들어왔을 때 매핑해줄 것인지
     * addResourceLocations - 실제 어디 경로를 보는지
     * setCachePeriod - 캐시를 얼마나 지속할 것인지??? (다시 로딩[다운] 받는 것인듯..)
     */
    @Configuration
    public class staticConfiguration implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/js/**")
                    .addResourceLocations("classpath:/static/js")
                    .setCachePeriod(20);

            registry.addResourceHandler("/css/**")
                    .addResourceLocations("classpath:/static/css")
                    .setCachePeriod(20);

            registry.addResourceHandler("/layout/**")
                    .addResourceLocations("classpath:/templates/layout")
                    .setCachePeriod(20);
        }

    }
}

