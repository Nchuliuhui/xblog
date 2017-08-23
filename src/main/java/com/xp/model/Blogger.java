package com.xp.model;

public class Blogger {
    /**
     * 博主id
     */
    private Integer id;

    /**
     * 博主姓名
     */
    private String username;

    /**
     * 博主密码
     */
    private String password;

    /**
     * 博主昵称
     */
    private String nickname;

    /**
     * 博主签名
     */
    private String sign;

    /**
     * 博主头像路径
     */
    private String imagename;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 博主信息
     */
    private String profile;

    /**
     * 博主id
     * @return id 博主id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 博主id
     * @param id 博主id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 博主姓名
     * @return username 博主姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 博主姓名
     * @param username 博主姓名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 博主密码
     * @return password 博主密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 博主密码
     * @param password 博主密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 博主昵称
     * @return nickname 博主昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 博主昵称
     * @param nickname 博主昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 博主签名
     * @return sign 博主签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * 博主签名
     * @param sign 博主签名
     */
    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    /**
     * 博主头像路径
     * @return imagename 博主头像路径
     */
    public String getImagename() {
        return imagename;
    }

    /**
     * 博主头像路径
     * @param imagename 博主头像路径
     */
    public void setImagename(String imagename) {
        this.imagename = imagename == null ? null : imagename.trim();
    }

    /**
     * 地址
     * @return address 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 博主信息
     * @return profile 博主信息
     */
    public String getProfile() {
        return profile;
    }

    /**
     * 博主信息
     * @param profile 博主信息
     */
    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
    }
}