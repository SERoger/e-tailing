package com.crow.file.service;

import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.crow.file.model.Image;
import com.crow.file.repo.ImageRepository;
import com.crow.file.util.ImageUtils;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;

@Service
public class ImageService {

    @Autowired
    ImageRepository imageRepository;

    public String uploadImage(MultipartFile imageFile) throws IOException {
       Image image=new Image();
       image.setName(imageFile.getOriginalFilename());
       image.setType(imageFile.getContentType());
       image.setImageData(ImageUtils.compressImage(imageFile.getBytes()));
        imageRepository.save(image);
        return "file uploaded successfully : " + imageFile.getOriginalFilename();
    }

    public byte[] downloadImage(String imageName) {
        Optional<Image> dbImage = imageRepository.findByName(imageName);
        return dbImage.map(image -> {
            try {
                return ImageUtils.decompressImage(image.getImageData());
            } catch (DataFormatException | IOException exception) {
                throw new ContextedRuntimeException("Error downloading an image", exception)
                        .addContextValue("Image ID",  image.getId())
                        .addContextValue("Image name", imageName);
            }
        }).orElse(null);
    }
}