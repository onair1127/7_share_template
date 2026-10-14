package com.anseong.share.domain.model.image.repository;

import com.anseong.share.domain.model.image.ImageId;
import com.anseong.share.domain.model.image.ShareTemplateImage;

public interface ImageRepository {

	ShareTemplateImage findImageForShareTemplateImage(ImageId imageId);
}
