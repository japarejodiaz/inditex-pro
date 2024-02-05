package com.inditex.zarachallenge.infrastructure.external;

import com.inditex.zarachallenge.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class SimilarProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}/similarids")
    public ResponseEntity<String[]> getSimilarProductIds(@PathVariable("productId") String productId) {
        String[] similarProductIds = this.productSimilar(Integer.parseInt(productId));

        if (similarProductIds == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(similarProductIds, HttpStatus.OK);
    }

    public String[] productSimilar(Integer productId) {

        // Crear el mapa
        Map<Integer, List<String>> map = new HashMap<>();

        // Agregar elementos al mapa
        map.put(1, Arrays.asList("2, 3, 4"));
        map.put(2, Arrays.asList("3, 7, 8"));
       /* map.put(3, Arrays.asList("7", "8", 9"));
        map.put(4, Arrays.asList("1", "2", "5"));
        map.put(5, Arrays.asList("1", "2", "6"));
        map.put(9, Arrays.asList("11", "15", "19"));
        map.put(12, Arrays.asList("20", "18", "19"));
        map.put(18, Arrays.asList("1", "2", "10000"));
        map.put(26, Arrays.asList("1", "100", "6"));
        map.put(37, Arrays.asList("1000", "7", "8"));*/

        List<String> listaProductObtenido = map.get(productId);

        // Convertir la lista a un arreglo de String
        String[] result = new String[listaProductObtenido.size()];
        listaProductObtenido.toArray(result);
        return result;
    }
}
