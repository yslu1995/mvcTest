package com.upload;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: yslu
 * @Date: 2019/7/3 7:21
 * @description：上传控制器（此为图片）
 *
 * 在UploadedImageFile中封装MultipartFile类型的字段 image ，用于接受页面的注入
 * 这里的字段 image必须和上传页面upload.jsp中的image
 * <input type="file" name="image" accept="image/*" />
 * 保持一致
 *
 */
public class UploadedImageFile {
    MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
