package com.vti.loship.services;


import com.vti.loship.database.SequenceGeneratorService;
import com.vti.loship.models.Image;
import com.vti.loship.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image saveImage(MultipartFile file) throws IOException {
        byte[] data = file.getBytes();
        Image image = new Image();

        Long id = sequenceGeneratorService.generateSequence(Image.SEQUENCE_NAME);
        image.setId(id);
        image.setData(data);
        return imageRepository.save(image);
    }

    public Optional<Image> getImage(Long id) {
        return imageRepository.findById(id);
    }
}
