package cn.lz.springboot_crud_415;

import cn.lz.springboot_crud_415.mapper.ProductMapper;
import cn.lz.springboot_crud_415.mapper.SaleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootCrud415ApplicationTests {
    @Autowired
    SaleMapper saleMapper;
    @Autowired
    ProductMapper productMapper;

    @Test
    void contextLoads() {
        List<Map> all = saleMapper.getAll();
        System.out.println("all = " + all);
    }

    @Test
    void contextLoads2() {
        Map<String, String> map = new HashMap<>();
        map.put("price", "10");
        map.put("quantity", "2");
        map.put("userid", "1");
        map.put("productid", "1");
        Integer add = saleMapper.add(map);
        System.out.println("add = " + add);
    }

    @Test
    void contextLoads3() {
        Object pid = "1";
        Map byId = productMapper.getById(pid);
        Integer add = saleMapper.add(byId);
        System.out.println("add = " + add);
    }
}
