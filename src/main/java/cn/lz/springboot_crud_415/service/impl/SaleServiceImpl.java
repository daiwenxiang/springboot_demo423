package cn.lz.springboot_crud_415.service.impl;

import cn.lz.springboot_crud_415.mapper.ProductMapper;
import cn.lz.springboot_crud_415.mapper.SaleMapper;
import cn.lz.springboot_crud_415.service.SaleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    @Resource
    SaleMapper saleMapper;

    @Resource
    ProductMapper productMapper;

    @Override
    public List<Map> getAll() {
        return saleMapper.getAll();
    }

    @Override
    public Map getSale(Integer id) {
        return saleMapper.getSale(id);
    }

    @Override
    public Integer del(Integer id) {
        return saleMapper.del(id);
    }

    @Override
    public PageInfo<Map> getByPage(Map map) {
        PageHelper.startPage(Integer.parseInt((String) map.get("pageNum")), 5);
        List<Map> all = saleMapper.getByCondition(map);
        return new PageInfo<>(all, 5);
    }

    //新增
    @Override
    public Integer add(Map map) {
        //判断库存是否足够
        //获得要购买的商品
        Object productid = map.get("productid");
        //根据id查询商品
        Map pro = productMapper.getById(productid);
        //判断库存
        int quantity = (Integer) pro.get("quantity");
        //商品表中的库存数量
        String proQuantity = (String) map.get("quantity");
        int buyQuantity = Integer.parseInt(proQuantity);
        if (quantity < buyQuantity) {
            System.out.println("库存不足");
            return -2;
        } else {
            //库存足够
            //减库存
            //保存新增的数据 交易记录
            productMapper.updateQuantity(map);
            return saleMapper.add(map);
        }
    }

    @Override
    public Integer update(Map map) {
        //根据交易编号 查原来的数量和商品  修改商品表 还原库存
        Map oldSale = saleMapper.getById(Integer.parseInt((String) map.get("id")));
        //还原库存
        productMapper.updateQuantity2(oldSale);
        //根据新的修改数据中的商品编号以及数量 对商品表进行库存修改 (减库存)
        productMapper.updateQuantity(map);
        return saleMapper.update(map);
    }

    @Override
    public Map getById(Integer id) {
        return saleMapper.getById(id);
    }
}
