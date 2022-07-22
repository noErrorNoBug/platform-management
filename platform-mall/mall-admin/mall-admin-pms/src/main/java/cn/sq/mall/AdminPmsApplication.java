package cn.sq.mall;

import cn.sq.platform.loadbalancer.annotations.EnableFeignClientsDefault;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sunqiang
 * @version 1.0
 * @description 商城后台(商户)商品管理服务
 * @date 2022/7/14 14:11
 */
@EnableFeignClientsDefault
@SpringBootApplication
public class AdminPmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminPmsApplication.class);
    }
}
