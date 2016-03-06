package com.mybatis.mapper;

import com.mybatis.entity.Orderdetial;
import com.mybatis.entity.OrderdetialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderdetialMapper {
    int countByExample(OrderdetialExample example);

    int deleteByExample(OrderdetialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Orderdetial record);

    int insertSelective(Orderdetial record);

    List<Orderdetial> selectByExample(OrderdetialExample example);

    Orderdetial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Orderdetial record, @Param("example") OrderdetialExample example);

    int updateByExample(@Param("record") Orderdetial record, @Param("example") OrderdetialExample example);

    int updateByPrimaryKeySelective(Orderdetial record);

    int updateByPrimaryKey(Orderdetial record);
}