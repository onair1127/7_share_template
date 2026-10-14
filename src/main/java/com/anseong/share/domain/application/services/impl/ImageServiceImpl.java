package com.anseong.share.domain.application.services.impl;

import com.anseong.share.domain.application.services.ImageService;
import com.anseong.share.domain.model.image.ImageId;
import com.anseong.share.domain.model.image.ShareTemplateImage;
import com.anseong.share.domain.model.image.repository.ImageRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class ImageServiceImpl implements ImageService {

     private ImageRepository imageRepository;

     public ImageServiceImpl(
               ImageRepository imageRepository
     ) {
          this.imageRepository = imageRepository;
     }

     @Override
     @Transactional(isolation = Isolation.READ_COMMITTED)
     public ShareTemplateImage findImageForShareTemplateImage(ImageId imageId) {
          Assert.notNull(imageId, "파라미터 imageId는 반드시 존재하여야 합니다.");

          return imageRepository.findImageForShareTemplateImage(imageId);
     }
}
