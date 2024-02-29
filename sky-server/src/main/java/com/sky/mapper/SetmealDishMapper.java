package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据菜品id查询对应的套餐id
     * @param dishIds
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    /**
     * 根据套餐id查询菜品相关数据
     * @param SetmealId
     * @return
     */
    @Select("select * from sky_take_out.setmeal_dish where setmeal_id = #{SetmealId}")
    List<SetmealDish> getDishBySetmealId(Long SetmealId);


    /**
     * 批量保存套餐和菜品的关联关系
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);

    /**
     * 批量删除套餐和菜品的关联关系
     * @param ids
     */
    void deleteBatchBySetmealId(List<Long> ids);
}
