package com.luketebo.mapper;


import com.luketebo.entity.FileInformation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface FileMapper {


    @Insert("INSERT INTO file_information (title,upload_date,image_name,file_name) VALUES(#{title},#{upload_date},#{image_name},#{file_name})")
    public int insert(@Param("title")String title,@Param("upload_date")String uploadDate,@Param("image_name")String imageName,@Param("file_name")String fileName);

    //查询
    @Select("SELECT id,title,upload_date uploadDate,image_name imageName,file_name fileName from file_information")
    public List<FileInformation> findAllFile();
}
