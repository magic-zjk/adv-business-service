package com.imopan.adv.platform.mapper.fos;

import com.imopan.adv.platform.entity.fos.FosHistory;
import com.imopan.adv.platform.entity.fos.FosHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FosHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    int countByExample(FosHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    int insert(FosHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    int insertSelective(FosHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    List<FosHistory> selectByExample(FosHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    FosHistory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") FosHistory record, @Param("example") FosHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") FosHistory record, @Param("example") FosHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(FosHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fos_history
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(FosHistory record);
}