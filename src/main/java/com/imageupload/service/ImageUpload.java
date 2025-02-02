package com.imageupload.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.imageupload.dto.ImageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageUpload {

    @Autowired
    private Cloudinary cloudinary;

    public ImageInfo uploadImage(org.springframework.web.multipart.MultipartFile file) throws IOException {
        Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        System.out.println(uploadResult);
        ImageInfo imageInfo = new ImageInfo(uploadResult.get("url").toString(), uploadResult.get("public_id").toString());
        return imageInfo;  // Returns image URL
    }

    public String deleteImage(String publicId) {
        try {
            Map<?, ?> deleteResult = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
            return deleteResult.get("result").toString();  // Should return "ok" if deleted successfully
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to delete image: " + e.getMessage();
        }
    }
}
