package cn.sq.platform.mvc.log;

import java.util.Objects;

/**
 * @author sunqiang
 * @version 1.0
 * @description Controller层日志
 * @date 2022/7/14 13:37
 */
public class ControllerLog {
    /**
     * 操作描述
     */
    private String description;

    /**
     * 操作用户
     */
    private String username;

    /**
     * 操作时间
     */
    private Long startTime;

    /**
     * 消耗时间
     */
    private Integer spendTime;

    /**
     * 根路径
     */
    private String basePath;

    /**
     * URI
     */
    private String uri;

    /**
     * URL
     */
    private String url;

    /**
     * 请求类型
     */
    private String method;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 请求参数
     */
    private Object parameter;

    /**
     * 返回结果
     */
    private Object result;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Integer getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(Integer spendTime) {
        this.spendTime = spendTime;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Object getParameter() {
        return parameter;
    }

    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ControllerLog{" +
                "description='" + description + '\'' +
                ", username='" + username + '\'' +
                ", startTime=" + startTime +
                ", spendTime=" + spendTime +
                ", basePath='" + basePath + '\'' +
                ", uri='" + uri + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", ip='" + ip + '\'' +
                ", parameter=" + parameter +
                ", result=" + result +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ControllerLog that = (ControllerLog) o;
        return Objects.equals(description, that.description) && Objects.equals(username, that.username) && Objects.equals(startTime, that.startTime) && Objects.equals(spendTime, that.spendTime) && Objects.equals(basePath, that.basePath) && Objects.equals(uri, that.uri) && Objects.equals(url, that.url) && Objects.equals(method, that.method) && Objects.equals(ip, that.ip) && Objects.equals(parameter, that.parameter) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, username, startTime, spendTime, basePath, uri, url, method, ip, parameter, result);
    }
}
