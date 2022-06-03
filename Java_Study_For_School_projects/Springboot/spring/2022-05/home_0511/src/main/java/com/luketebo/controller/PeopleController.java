package com.luketebo.controller;

import com.luketebo.entity.People;
import com.luketebo.service.PeopleService;
import com.luketebo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @Value("${photo.file.dir}")
    private String realpath;

    // 测试

    // 清空缓存 很重要
    @GetMapping("getPeo/{id}")
    public void getPeo(@PathVariable Integer id) {
        People people = peopleService.getOne(id);
    }

    // 图片上传
    private String uploadPhoto(MultipartFile img, String originalFilename) throws IOException {
        String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFilename = fileName + ext;
        img.transferTo(new File(realpath, newFilename));
        return newFilename;
    }

    @PostMapping("/update")
    public String updatePeo(People people, MultipartFile img) throws IOException {
        String originalFilename = img.getOriginalFilename();
        String newFilename = uploadPhoto(img, originalFilename);
        people.setPhoto(newFilename);
        peopleService.updateById(people);
        return "redirect:/people";
    }

    // 通过people 访问 people.html
    @GetMapping("/people")
    public String people(Model model){
        List<People> list = peopleService.list();
        model.addAttribute("people", list);
        return "people";
    }
    // 访问people-edit.html
    @GetMapping("/people-edit")
    public String peopleEdit(Integer id, Model model){
        People people = peopleService.getOne(id);
        model.addAttribute("people", people);
        return "people-edit";
    }
    // 访问people-add.html
    @GetMapping("/people-add")
    public String peopleAdd(){
        return "people-add";
    }
    // 更新people
    @PostMapping("/people-update")
    public String peopleUpdate(People people) {
        peopleService.updateById(people);
        return "redirect:/people";
    }
    // 删除
    @GetMapping("/people-delete-one")
    public String peopleDeleteOne(Integer id) {
        peopleService.removeById(id);
        return "redirect:/people";
    }
    // 文件传输
    @RequestMapping("/people-upload")
    public void uploadImage(MultipartFile file) throws IOException {
        if(file.isEmpty()){
            System.out.println("file is Empty");
        }
        Date date = new Date();
        String dateForm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        // 地址合并path.getFileImage 是存放实体类的路径 不会写可以写 D:\\
//        String casePath = path.getFilePath() + dateForm + file.getOriginalFilename();
        String casePath = "D:\\" + dateForm;
        String imgFormat = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        // 判断文件是否存在
        File f = new File(casePath);
        try {
            if(!f.exists()){
                f.mkdirs();
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }
        // 重新命名
        String name = UUID.randomUUID().toString() + imgFormat;

        file.transferTo(new File(casePath + name));


    }


}
