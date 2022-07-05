CREATE TABLE teacher (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "姓名",
    username VARCHAR(255) COMMENT "姓名",
    password VARCHAR(255) COMMENT "密码",
    role VARCHAR(255) COMMENT "角色"
) DEFAULT CHARSET UTF8 COMMENT "老师表";

CREATE TABLE student(  
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'Primary Key',
    username VARCHAR(255) COMMENT "姓名",
    password VARCHAR(255) COMMENT "密码",
    class INT COMMENT "班级"
) DEFAULT CHARSET UTF8 COMMENT '学生表';

CREATE Table assignment(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "Primary Key",
    create_id VARCHAR(255) COMMENT "创建人",
    content VARCHAR(512) COMMENT "作业内容",
    create_time DATETIME COMMENT "创建时间",
    deadline DATETIME COMMENT "截至时间"
) DEFAULT CHARSET UTF8 COMMENT "作业表";

CREATE Table t_comment (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "Primary Key",
    comment_id VARCHAR(255) COMMENT "评论人",
    content VARCHAR(255) COMMENT "评论内容",
    create_time DATETIME COMMENT "评论时间"
) DEFAULT CHARSET UTF8 COMMENT "评论表";

CREATE Table class (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT "Primary Key",
    teacher_id INT COMMENT "老师",
    class_id INT COMMENT "接管班级"
) DEFAULT CHARSET UTF8 COMMENT "班级表";
