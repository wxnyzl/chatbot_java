package com.chatbot.core.request.vo;

public class SmallProgramVo {

    private String toUser;
    /**
     * 缩略图地址
     */
    private String thumbUrl;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String des;
    /**
     * 地址
     */
    private String url;
    /**
     * 来源用户名
     */
    private String sourceUsername;
    /**
     * 来源显示名
     */
    private String sourceDisplayName;
    /**
     * 用户名
     */
    private String username;
    /**
     * 小程序 APPID
     */
    private String appid;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 版本
     */
    private Integer version;
    /**
     * 图标地址
     */
    private String iconUrl;
    /**
     * 启动页
     */
    private String pagePath;

    public String getToUser() {
        return toUser;
    }

    public SmallProgramVo setToUser(String toUser) {
        this.toUser = toUser;
        return this;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public SmallProgramVo setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SmallProgramVo setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDes() {
        return des;
    }

    public SmallProgramVo setDes(String des) {
        this.des = des;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public SmallProgramVo setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getSourceUsername() {
        return sourceUsername;
    }

    public SmallProgramVo setSourceUsername(String sourceUsername) {
        this.sourceUsername = sourceUsername;
        return this;
    }

    public String getSourceDisplayName() {
        return sourceDisplayName;
    }

    public SmallProgramVo setSourceDisplayName(String sourceDisplayName) {
        this.sourceDisplayName = sourceDisplayName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SmallProgramVo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getAppid() {
        return appid;
    }

    public SmallProgramVo setAppid(String appid) {
        this.appid = appid;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public SmallProgramVo setType(Integer type) {
        this.type = type;
        return this;
    }

    public Integer getVersion() {
        return version;
    }

    public SmallProgramVo setVersion(Integer version) {
        this.version = version;
        return this;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public SmallProgramVo setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public String getPagePath() {
        return pagePath;
    }

    public SmallProgramVo setPagePath(String pagePath) {
        this.pagePath = pagePath;
        return this;
    }
}
