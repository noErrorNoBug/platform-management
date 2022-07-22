## 依赖
```shell
yum install gcc‐c++;
yum install ‐y pcre pcre‐devel;
yum -y install pcre-devel
yum install ‐y zlib zlib‐devel
yum install ‐y zlib‐devel
yum install ‐y openssl openssl‐devel
yum install ‐y openssl‐devel
```

## 安装
```shell
# 指定安装目录
./configure --prefix=/data/nginx
# 不指定的话直接编译
./configure  &  make  & make install
# 验证配置文件
./nginx -t
```

## 自动启动
```shell
# 创建service
vim usr/lib/systemd/system/nginx.service
# 写入自启动逻辑
[Unit]
Description=nginx - high performance web server
After=network.target remote-fs.target nss-lookup.target

[Service]
Type=forking
ExecStart=/learn-chen/tool/tool/nginx/sbin/nginx
ExecStop=/learn-chen/tool/tool/nginx/sbin/nginx -s stop
ExecReload=/learn-chen/tool/tool/nginx/sbin/nginx -s reload
PrivateTmp=true

[Install]
WantedBy=multi-user.target

# 设置自启动
vim /etc/rc.local
# 路径为自己的安装路径
/****/nginx/sbin/nginx
# 授予权限
chmod +x /etc/rc.d/rc.local
```

## 环境变量
```profile
export PATH=/data/nginx/sbin:$PATH
```

## 常用命令
```shell
# 版本
./nginx -v
# 启动
./nginx
# 检查配置文件
 ./nginx -t
# 指定配置文件启动
./nginx -c /usr/local/nginx/conf/nginx.conf
# 停止
./nginx -s stop
# 退出
./nginx -s quit
# 重新加载配置文件
./nginx -s reload

```