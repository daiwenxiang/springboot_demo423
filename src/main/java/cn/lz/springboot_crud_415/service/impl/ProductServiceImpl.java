package cn.lz.springboot_crud_415.service.impl;

import cn.lz.springboot_crud_415.mapper.ProductMapper;
import cn.lz.springboot_crud_415.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductMapper productMapper;

    @Override
    public List<Map> findAll() {
        return productMapper.findAll();
    }
}
