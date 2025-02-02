package com.imageupload.dto;

public class ImageInfo {
    private String imageURL;
    private String publicId;

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

    public ImageInfo(String imageURL, String publicId) {
        this.imageURL = imageURL;
        this.publicId = publicId;
    }

    public ImageInfo() {
    }
}
