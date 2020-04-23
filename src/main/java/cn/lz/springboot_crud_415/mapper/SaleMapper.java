package cn.lz.springboot_crud_415.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SaleMapper {

    @Select("select s.*, u.*, p.* from sale s left join product p on s.productid = p.id left join user u on s.userid = u.id order by s.id ")
    List<Map> getAll();

    @Select("select * from sale where id = #{id}")
    Map getSale(Integer id);

    @Delete("delete from sale where id = #{id}")
    Integer del(Integer id);

    @Insert("insert into sale values(null, #{price}, #{quantity}, #{price} * #{quantity}, curdate(), #{userid}, #{productid})")
    Integer add(Map map);

    @Update("update sale set productid = #{productid}, userid = #{userid}, price = #{price}, quantity = #{quantity}, totalPrice = #{price}*#{quantity} where id = #{id}")
    Integer update(Map map);

    @Select("select * from sale where id = #{id}")
    Map getById(Integer id);

    //根据条件查询
    List<Map> getByCondition(Map map);
}
