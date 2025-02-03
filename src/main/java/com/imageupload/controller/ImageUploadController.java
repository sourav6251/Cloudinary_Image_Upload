package com.imageupload.controller;

import com.imageupload.dto.ImageInfo;
import com.imageupload.dto.UploadResponse;
import com.imageupload.dto.UserInfo;
import com.imageupload.service.ImageUpload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageUploadController {

    private final ImageUpload imageUpload;


    public ImageUploadController(ImageUpload imageUpload) {
        this.imageUpload = imageUpload;
    }

    UserInfo userInformation;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestPart("file") MultipartFile file, @RequestPart("userdata") UserInfo userInfo) {

        userInformation = new UserInfo(userInfo.getUserId(), userInfo.getName(), userInfo.getPassword(), userInfo.getEmail());
        try {

            ImageInfo output = imageUpload.uploadImage(file);
            UploadResponse response = new UploadResponse(userInfo, output);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
           return ResponseEntity.internalServerError().body(e.getMessage());
        }


    }

    @DeleteMapping("/delete")
    public String deleteImage(@RequestParam("publicId") String publicId) {
        return imageUpload.deleteImage(publicId);
    }
}
