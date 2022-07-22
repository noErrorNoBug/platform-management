package cn.sq.mall.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 会员表
 * </p>
 *  自定义模板
 * @author sunqiang
 * @since 2022-07-14
 */
@TableName("ums_member")
@ApiModel(value = "UmsMember对象", description = "会员表")
public class UmsMember implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("会员编号;会员编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("会员等级编号;会员等级编号")
    private Long memberLevelId;

    @ApiModelProperty("用户名;用户名")
    private String username;

    @ApiModelProperty("密码;密码")
    private String password;

    @ApiModelProperty("昵称;昵称")
    private String nickname;

    @ApiModelProperty("手机号;手机号")
    private String phone;

    @ApiModelProperty("启用状态;是否启用")
    private Integer status;

    @ApiModelProperty("创建时间;创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("头像;头像")
    private String icon;

    @ApiModelProperty("性别;性别")
    private Integer gender;

    @ApiModelProperty("生日;生日")
    private LocalDateTime birthday;

    @ApiModelProperty("城市;城市")
    private String city;

    @ApiModelProperty("工作;工作")
    private String job;

    @ApiModelProperty("个性签名;个性签名")
    private String personalizedSignature;

    @ApiModelProperty("用户来源;用户来源")
    private Integer sourceType;

    @ApiModelProperty("积分;积分")
    private Integer integration;

    @ApiModelProperty("成长值;成长值")
    private Integer growth;

    @ApiModelProperty("剩余抽奖次数;剩余抽奖次数")
    private Integer luckeyCount;

    @ApiModelProperty("历史积分数量;历史积分数量")
    private Integer historyIntegration;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Long memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }

    public Integer getLuckeyCount() {
        return luckeyCount;
    }

    public void setLuckeyCount(Integer luckeyCount) {
        this.luckeyCount = luckeyCount;
    }

    public Integer getHistoryIntegration() {
        return historyIntegration;
    }

    public void setHistoryIntegration(Integer historyIntegration) {
        this.historyIntegration = historyIntegration;
    }

    @Override
    public String toString() {
        return "UmsMember{" +
        "id=" + id +
        ", memberLevelId=" + memberLevelId +
        ", username=" + username +
        ", password=" + password +
        ", nickname=" + nickname +
        ", phone=" + phone +
        ", status=" + status +
        ", createTime=" + createTime +
        ", icon=" + icon +
        ", gender=" + gender +
        ", birthday=" + birthday +
        ", city=" + city +
        ", job=" + job +
        ", personalizedSignature=" + personalizedSignature +
        ", sourceType=" + sourceType +
        ", integration=" + integration +
        ", growth=" + growth +
        ", luckeyCount=" + luckeyCount +
        ", historyIntegration=" + historyIntegration +
        "}";
    }
}
