package cn.lz.springboot_crud_415.service;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface SaleService {
    List<Map> getAll();

    Map getSale(Integer id);

    Integer del(Integer id);

    PageInfo<Map> getByPage(Map map);

    Integer add(Map map);

    Integer update(Map map);

    Map getById(Integer id);
}
