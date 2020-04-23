package cn.lz.springboot_crud_415.controller;

import cn.lz.springboot_crud_415.service.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ProductController {
    @Resource
    ProductService productService;

    @GetMapping("getAllPro")
    public List<Map> findAll() {
        return productService.findAll();
    }
}
