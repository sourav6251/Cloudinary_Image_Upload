package com.imageupload.dto;

public class UploadResponse {

    private String userId;
    private String name;
    private String password;
    private String email;
    private String imageURL;
    private String publicId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public UploadResponse() {
    }

    public UploadResponse(UserInfo userInfo, ImageInfo imageInfo) {
        this.userId = userInfo.getUserId();
        this.name = userInfo.getName();
        this.password = userInfo.getPassword();
        this.email = userInfo.getEmail();
        this.imageURL = imageInfo.getImageURL();
        this.publicId = imageInfo.getPublicId();

    }


}
