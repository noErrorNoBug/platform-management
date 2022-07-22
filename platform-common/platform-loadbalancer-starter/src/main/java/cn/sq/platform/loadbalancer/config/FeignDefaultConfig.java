package cn.sq.platform.loadbalancer.config;

import cn.sq.platform.loadbalancer.interceptors.FeignDefaultInterceptor;
import feign.Logger;
import feign.Request;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunqiang
 * @version 1.0
 * @description Feign默认配置
 * @date 2022/7/20 00:27
 */
@Configuration
@EnableFeignClients(basePackages = {"cn.sq"})
public class FeignDefaultConfig {
    /**
     * 日志输出级别，生产环境使用HEADERS即可
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.HEADERS;
    }

    /**
     * 添加默认拦截器
     * @return
     */
    @Bean
    public FeignDefaultInterceptor feignInterceptor() {
        return new FeignDefaultInterceptor();
    }

    /**
     * 配置超时时间
     * @return
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(5000,10000);
    }
}
