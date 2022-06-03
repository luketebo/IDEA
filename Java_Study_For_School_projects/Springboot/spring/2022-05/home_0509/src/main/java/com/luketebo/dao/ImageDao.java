package com.luketebo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luketebo.entity.Image;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface ImageDao extends BaseMapper<Image> {
    @Insert("INSERT INTO file_information(title, upload_time, image_name, file_name) values(#{title}, #{upload_date}, #{image_name}, #{file_name})")
    public int insert(@Param("title") String title, @Param("upload_date") String uploadDate, @Param("image_name") String imageName, @Param("file_name") String fileName);
    @Select("SELECT id, title, upload_time uploadDate, image_name imageName, file_name fileName from file_information")
    public List<Image> findAllFile();
}
