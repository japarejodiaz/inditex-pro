package com.inditex.zarachallenge.infrastructure.external.service.impl;


import com.inditex.zarachallenge.infrastructure.external.service.ProductExternalSimilarService;
import com.inditex.zarachallenge.infrastructure.util.UtilMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductExternalSimilarServiceImpl implements ProductExternalSimilarService {

    @Autowired
    private UtilMessage utilMessage;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    @Override
    public String findProductSimilar(Integer productId) {

        String result;

        Map<Integer, List<String>> map = new HashMap<>();
        map.put(1, Arrays.asList("[2, 3, 4]"));
        map.put(2, Arrays.asList("[3, 7, 8]"));
        map.put(3, Arrays.asList("[7, 8, 9]"));
        map.put(4, Arrays.asList("[1, 2, 5]"));
        map.put(5, Arrays.asList("[1, 2, 6]"));
        map.put(9, Arrays.asList("[11, 15, 19]"));
        map.put(12, Arrays.asList("[20, 18, 19]"));
        map.put(18, Arrays.asList("[1, 2, 10000]"));
        map.put(26, Arrays.asList("[1, 100, 6]"));
        map.put(37, Arrays.asList("[1000, 7, 8]"));


        List<String> valueList = map.get(productId);
        if (valueList != null && !valueList.isEmpty()) {
            return valueList.get(0);
        } else {
            utilMessage.getProductsSimilarNotFoundException(productId.toString(), LocalDateTime.now().format(formatter));
        }

        return null;   // Nunca llegaria pasaria por el manejador de excepciones.

    }

}
