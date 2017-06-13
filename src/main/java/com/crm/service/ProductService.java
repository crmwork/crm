package com.crm.service;

import com.crm.model.Product;

import java.util.List;
import java.util.Map;
/**
 * Created by Administrator on 2017/6/12.
 */
public interface ProductService {
    public Product getProduct(int id);

    public List<Product> find(Map<String, Object> map);

    public long getTotal(Map<String, Object> map);

    public int addProduct(Product product);

    public int updateProduct(Product product);
}
