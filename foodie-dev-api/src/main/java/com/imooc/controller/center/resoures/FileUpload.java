package com.imooc.controller.center.resoures;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @PACKAGE_NAME: com.imooc.controller.center.resoures
 * @NAME: FileUpload
 * @USER: code.rookie
 * @DATE: 2020/6/27
 * @TIME: 10:50 上午
 * @DAY_NAME_SHORT: 周六
 * @PROJECT_NAME: foodie-dev
 * @Desc:
 */
@Component
@ConfigurationProperties(prefix = "file")
@PropertySource("classpath:file-upload-prod.properties")
public class FileUpload {

    private String imageUserFaceLocation;
    private String imageServerUrl;

    public String getImageServerUrl() {
        return imageServerUrl;
    }

    public void setImageServerUrl(String imageServerUrl) {
        this.imageServerUrl = imageServerUrl;
    }

    public String getImageUserFaceLocation() {
        return imageUserFaceLocation;
    }

    public void setImageUserFaceLocation(String imageUserFaceLocation) {
        this.imageUserFaceLocation = imageUserFaceLocation;
    }
}
