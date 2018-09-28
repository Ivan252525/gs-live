
DROP TABLE IF EXISTS `TB_TEACHER`;
CREATE TABLE TB_TEACHER(
  `teacher_id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '教师id',
  `teacher_name` VARCHAR(32) NOT NULL COMMENT '教师名称'
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='教师表';