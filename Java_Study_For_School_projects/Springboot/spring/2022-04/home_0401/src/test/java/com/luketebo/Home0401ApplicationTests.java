package com.luketebo;


import com.luketebo.dao.Cla;
import com.luketebo.dao.Stu;
import com.luketebo.doamin.Classes;
import com.luketebo.doamin.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Home0401ApplicationTests {

    @Autowired
    private Stu st;

    @Autowired
    private Cla cla;

    @Test
    void testMP(){
        List<Classes> cl = cla.selectList(null);
       for(Classes c : cl){
           System.out.println(c);
       }
    }

    @Test
    void testMP_insert(){
        cla.deleteById(3);
        List<Classes> cl = cla.selectList(null);
        for(Classes c : cl){
            System.out.println(c);
        }
    }



    @Test
    void contextLoads() {

    }
    @Test
    void testFind(){
        List<Student> stu = st.findAll();
        for(Student s : stu){
            System.out.println(s);
        }
    }
    @Test
    void testInsert(){
        st.insertData();
        List<Student> stu = st.findAll();
        for(Student s : stu){
            System.out.println(s);
        }
    }
    @Test
    void testDelete(){
        st.deleteData();
        List<Student> stu = st.findAll();
        for(Student s : stu){
            System.out.println(s);
        }
    }
    @Test
    void testUpdate(){
        st.updateData();
        List<Student> stu = st.findAll();
        for(Student s : stu){
            System.out.println(s);
        }
    }


}
