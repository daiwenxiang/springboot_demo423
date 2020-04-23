package cn.lz.springboot_crud_415.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ProductMapper {
    @Select("select * from product")
    List<Map> findAll();

    //根据id查商品
    @Select("select * from product where id = #{id}")
    Map getById(Object id);

    //减库存
    @Update("update product set quantity = quantity - #{quantity} where id = #{productid}")
    int updateQuantity(Map map);

    //还原库存
    @Update("update product set quantity = quantity + #{quantity} where id = #{productid}")
    int updateQuantity2(Map map);
}
