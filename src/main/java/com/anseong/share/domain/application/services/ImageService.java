package com.anseong.share.domain.application.services;

import com.anseong.share.domain.model.image.ImageId;
import com.anseong.share.domain.model.image.ShareTemplateImage;

public interface ImageService {
	ShareTemplateImage findImageForShareTemplateImage(ImageId imageId);
}
