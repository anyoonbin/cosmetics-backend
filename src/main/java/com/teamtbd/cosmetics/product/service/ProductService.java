package com.teamtbd.cosmetics.product.service;

import com.teamtbd.cosmetics.domain.Category;
import com.teamtbd.cosmetics.domain.Site;
import com.teamtbd.cosmetics.product.Product;
import com.teamtbd.cosmetics.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product getProductFromJsonObject(JSONObject jsonObject) {
        return Product.builder()
                .id(String.valueOf(jsonObject.get("id")))
                .name(String.valueOf(jsonObject.get("name")))
                .price(Integer.parseInt(String.valueOf(jsonObject.get("price"))))
                .brand(String.valueOf(jsonObject.get("brand")))
                .imageUrl(String.valueOf(jsonObject.get("image_url")))
                .category(Category.valueOf(Integer.parseInt(String.valueOf(jsonObject.get("category")))))
                .site(Site.valueOf(Integer.parseInt(String.valueOf(jsonObject.get("site")))))
                .siteProductId(String.valueOf(jsonObject.get("site_id")))
                .link(String.valueOf(jsonObject.get("link")))
                .siteCategoryId(String.valueOf(jsonObject.get("site_category")))
                .volume(String.valueOf(jsonObject.get("volume")))
                .expirationDate(String.valueOf(jsonObject.get("expiration_date")))
                .prodUsage(String.valueOf(jsonObject.get("usage")))
                .origin(String.valueOf(jsonObject.get("origin")))
                .ingredients(String.valueOf(jsonObject.get("ingredients")))
                .caution(String.valueOf(jsonObject.get("caution")))
                .build();
    }

    public List<Product> getProductsFromJsonArray(JSONArray jsonArray){
        List<Product> productList = new ArrayList<>();

        for(int i = 0; i<jsonArray.size(); i++){
            productList.add(getProductFromJsonObject((JSONObject) jsonArray.get(i)));
        }

        return productList;
    }

    public void JsonFileRead(String dir) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        //String dataDir; 디렉토리랑 파일명 분리해서 받아올 예정
        Reader reader = new FileReader(dir);
        Object obj = parser.parse(reader);

        if (obj instanceof JSONObject){
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(getProductFromJsonObject(jsonObject));

        } else if (obj instanceof JSONArray){
            JSONArray jsonArray = (JSONArray) obj;
            System.out.println(getProductsFromJsonArray(jsonArray));

        } else {
            System.out.println("null 값");
        }
    }
}
