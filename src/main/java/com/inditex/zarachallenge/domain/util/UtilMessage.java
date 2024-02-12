package com.inditex.zarachallenge.domain.util;

import com.inditex.zarachallenge.infrastructure.constant.ErrorEnum;
import com.inditex.zarachallenge.infrastructure.exceptions.ProductNotFoundException;
import com.inditex.zarachallenge.infrastructure.exceptions.ProductSimilarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;

@Component
public class UtilMessage {

    @Autowired
    private MessageSource messageSource;

    public void getProductsSimilarNotFoundException(String productId, String consultationDate) {
        String message = messageSource.getMessage(ErrorEnum.NOT_PRODUCTS_SIMILAR_NOTFOUND.getMessage(), null, Locale.getDefault());
        String formattedMessage = MessageFormat.format(message, productId, consultationDate);
        throw new ProductSimilarNotFoundException(formattedMessage);
    }
}
