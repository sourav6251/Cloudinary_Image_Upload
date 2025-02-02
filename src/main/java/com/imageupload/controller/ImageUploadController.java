package com.imageupload.controller;

import com.imageupload.dto.ImageInfo;
import com.imageupload.service.ImageUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ImageUploadController {

    @Autowired
    private ImageUpload imageUpload;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") org.springframework.web.multipart.MultipartFile file) {
        try {
            return (ResponseEntity.ok(imageUpload.uploadImage(file)));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public String deleteImage(@RequestParam("publicId") String publicId) {
        return imageUpload.deleteImage(publicId);
    }
}
