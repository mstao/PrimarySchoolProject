/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : school

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2017-05-11 06:16:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ps_apply
-- ----------------------------
DROP TABLE IF EXISTS `ps_apply`;
CREATE TABLE `ps_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(10) NOT NULL,
  `stu_sex` varchar(2) NOT NULL,
  `stu_nation` varchar(10) NOT NULL,
  `stu_idnum` varchar(50) NOT NULL COMMENT '学生身份证号码',
  `original_school` varchar(255) DEFAULT NULL COMMENT '原学校名称',
  `address` varchar(255) NOT NULL COMMENT '现住址',
  `register` varchar(255) NOT NULL COMMENT '户籍',
  `father_name` varchar(10) NOT NULL,
  `father_idnum` varchar(50) NOT NULL COMMENT '父亲身份证号码',
  `father_phone` varchar(255) DEFAULT NULL COMMENT '父亲电话',
  `mother_name` varchar(10) NOT NULL,
  `mother_idnum` varchar(50) NOT NULL COMMENT '母亲身份证号码',
  `mother_phone` varchar(255) DEFAULT NULL COMMENT '母亲电话',
  `status` int(11) DEFAULT '0' COMMENT '审核状态,0正在审核，1报名成功，2报名失败',
  `uid` int(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `reason` text,
  `date_id` int(11) DEFAULT NULL COMMENT '报名日期',
  `img_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_apply_stuIdNum` (`stu_idnum`) USING BTREE,
  UNIQUE KEY `idx_sys_apply_uid` (`uid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_apply
-- ----------------------------
INSERT INTO `ps_apply` VALUES ('4', '刀剑', '男', '汉', '510302199404106988', '小学', '河南郑州市33', '河南郑州市科学大道', '啊啊啊', '510302199404106988', '13592531024', '水水水', '230000199301301805', '', '2', '1', '2017-05-07 15:14:24', '', '2', '/PrimaryScoolProject/resources/Uploads/images/bf844ac204824829937ea417b06859d5.png');

-- ----------------------------
-- Table structure for ps_apply_date
-- ----------------------------
DROP TABLE IF EXISTS `ps_apply_date`;
CREATE TABLE `ps_apply_date` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `begin_apply` int(1) DEFAULT '0' COMMENT '是否开启报名 0,开启，1不开启',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_apply_date_year` (`year`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_apply_date
-- ----------------------------
INSERT INTO `ps_apply_date` VALUES ('2', '2017', '2017-05-04', '2017-05-29', '1');

-- ----------------------------
-- Table structure for ps_apply_user
-- ----------------------------
DROP TABLE IF EXISTS `ps_apply_user`;
CREATE TABLE `ps_apply_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `card_code` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `out_date` double DEFAULT NULL,
  `validataCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_apply_user_cardCode` (`card_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_apply_user
-- ----------------------------
INSERT INTO `ps_apply_user` VALUES ('1', '韩俊涛', null, '412821199506086011 ', '5bc825fd22394119b18269981367ea09', '2017-04-30 00:00:00', '韩俊涛', null, null);
INSERT INTO `ps_apply_user` VALUES ('3', '水涛宁', null, '330782197805275038', '4d19f24913e3b2ddc25c5773f935f2b5', '2017-05-04 00:00:00', '水涛宁', null, null);
INSERT INTO `ps_apply_user` VALUES ('5', 'hq', 'ldfwoxihuanni@163.com', '612429199606200172', '98f9647a0e4b2ce82909f5c5a23e2d89', '2017-05-08 00:00:00', 'hq', null, null);

-- ----------------------------
-- Table structure for ps_campus_scenery
-- ----------------------------
DROP TABLE IF EXISTS `ps_campus_scenery`;
CREATE TABLE `ps_campus_scenery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_path` varchar(255) DEFAULT NULL,
  `add_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_campus_scenery
-- ----------------------------
INSERT INTO `ps_campus_scenery` VALUES ('3', '/PrimaryScoolProject/resources/Uploads/images/624fb2993b394939b564a7230872f24d.jpg', '2017-05-06');
INSERT INTO `ps_campus_scenery` VALUES ('4', '/PrimaryScoolProject/resources/Uploads/images/9f9e0487ad7447e7aef9e07663337344.png', '2017-05-06');
INSERT INTO `ps_campus_scenery` VALUES ('6', '/PrimaryScoolProject/resources/Uploads/images/44bc8313eb664875a5d79b9ac8c8dba2.png', '2017-05-06');
INSERT INTO `ps_campus_scenery` VALUES ('7', '/PrimaryScoolProject/resources/Uploads/images/edcbe931a169486ca9ad257ba4876887.png', '2017-05-06');
INSERT INTO `ps_campus_scenery` VALUES ('8', '/PrimaryScoolProject/resources/Uploads/images/530dba2483d444c4aee9375b474dee76.png', '2017-05-06');
INSERT INTO `ps_campus_scenery` VALUES ('9', '/PrimaryScoolProject/resources/Uploads/images/3f3c1fce480c4801a7c93543be4b8362.png', '2017-05-06');

-- ----------------------------
-- Table structure for ps_class
-- ----------------------------
DROP TABLE IF EXISTS `ps_class`;
CREATE TABLE `ps_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(25) DEFAULT NULL,
  `grade_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_class
-- ----------------------------
INSERT INTO `ps_class` VALUES ('2', '2', '1');
INSERT INTO `ps_class` VALUES ('3', '1', '2');
INSERT INTO `ps_class` VALUES ('4', '3', '1');
INSERT INTO `ps_class` VALUES ('5', '2', '2');
INSERT INTO `ps_class` VALUES ('6', '3', '2');
INSERT INTO `ps_class` VALUES ('8', '1', '3');
INSERT INTO `ps_class` VALUES ('9', '2', '3');
INSERT INTO `ps_class` VALUES ('10', '3', '3');
INSERT INTO `ps_class` VALUES ('11', '1', '4');
INSERT INTO `ps_class` VALUES ('12', '2', '4');
INSERT INTO `ps_class` VALUES ('13', '3', '4');
INSERT INTO `ps_class` VALUES ('14', '1', '5');
INSERT INTO `ps_class` VALUES ('15', '2', '5');
INSERT INTO `ps_class` VALUES ('16', '3', '5');
INSERT INTO `ps_class` VALUES ('17', '1', '6');
INSERT INTO `ps_class` VALUES ('18', '2', '6');
INSERT INTO `ps_class` VALUES ('19', '3', '6');
INSERT INTO `ps_class` VALUES ('24', '1', '1');
INSERT INTO `ps_class` VALUES ('25', '1', '8');
INSERT INTO `ps_class` VALUES ('27', '2', '8');
INSERT INTO `ps_class` VALUES ('28', '3', '8');
INSERT INTO `ps_class` VALUES ('30', '4', '8');
INSERT INTO `ps_class` VALUES ('33', '4', '6');
INSERT INTO `ps_class` VALUES ('42', '5', '8');
INSERT INTO `ps_class` VALUES ('43', '2', '5');
INSERT INTO `ps_class` VALUES ('46', '6', '8');
INSERT INTO `ps_class` VALUES ('47', '5', '6');
INSERT INTO `ps_class` VALUES ('48', '6', '6');

-- ----------------------------
-- Table structure for ps_class_homepage
-- ----------------------------
DROP TABLE IF EXISTS `ps_class_homepage`;
CREATE TABLE `ps_class_homepage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `item_content` text COMMENT '内容',
  `type_id` int(2) DEFAULT NULL,
  `add_time` date DEFAULT NULL,
  `view_count` int(11) DEFAULT NULL COMMENT '浏览量',
  `is_image` int(2) DEFAULT NULL COMMENT '是否包含图片',
  `is_publish` int(2) DEFAULT NULL COMMENT '是否发布',
  `class_id` int(11) NOT NULL,
  `item_author` varchar(50) DEFAULT NULL,
  `className` varchar(255) DEFAULT NULL,
  `gradeName` varchar(255) DEFAULT NULL,
  `gradeCode` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_class_homepage
-- ----------------------------
INSERT INTO `ps_class_homepage` VALUES ('8', 'sdfs ', '<p>sdfsds<br></p><p><img src=\"/PrimaryScoolProject/resources/Uploads/images/72e349d9-f451-4618-98e3-246941be7235.png\" alt=\"2017-04-19_130552\" style=\"max-width: 100%; width: 650px; height: 335px;\" class=\"\"></p><p><br></p>', '1', '2017-05-09', '6', '1', '1', '25', '万科小学', null, null, '0');
INSERT INTO `ps_class_homepage` VALUES ('9', 'sdfs ', '<p>sdfsds<br></p><p><img src=\"/PrimaryScoolProject/resources/Uploads/images/77b4ebda-1995-4428-ba69-44195e58c4d2.png\" alt=\"2017-04-19_130831\" style=\"max-width: 100%; width: 696px; height: 450px;\" class=\"\"></p><p><br></p>', '1', '2017-05-09', '1', '1', '1', '25', '万科小学', null, null, '0');
INSERT INTO `ps_class_homepage` VALUES ('10', '1241434423424234', '<p>234234234234233242<br></p>', '3', '2017-05-10', '12', '0', '1', '14', '万科小学', null, null, '0');

-- ----------------------------
-- Table structure for ps_class_homepage_type
-- ----------------------------
DROP TABLE IF EXISTS `ps_class_homepage_type`;
CREATE TABLE `ps_class_homepage_type` (
  `id` int(11) NOT NULL,
  `item_type_name` varchar(25) DEFAULT NULL,
  `item_type_flag` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_sys_classhomepage_type_name` (`item_type_name`),
  KEY `idx_sys_classhomepage_type_flag` (`item_type_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_class_homepage_type
-- ----------------------------
INSERT INTO `ps_class_homepage_type` VALUES ('1', '班级动态', 'dynamic');
INSERT INTO `ps_class_homepage_type` VALUES ('2', '成长故事', 'growthstory');
INSERT INTO `ps_class_homepage_type` VALUES ('3', '学生文章', 'article');
INSERT INTO `ps_class_homepage_type` VALUES ('4', '班级风采', 'style');

-- ----------------------------
-- Table structure for ps_class_style
-- ----------------------------
DROP TABLE IF EXISTS `ps_class_style`;
CREATE TABLE `ps_class_style` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_path` varchar(255) DEFAULT NULL,
  `img_name` varchar(255) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_class_style
-- ----------------------------
INSERT INTO `ps_class_style` VALUES ('1', '/PrimaryScoolProject/resources/Uploads/images/2.jpg', '运动会', '2017-05-07 00:00:00', '25');
INSERT INTO `ps_class_style` VALUES ('3', '/PrimaryScoolProject/resources/Uploads/images/3.jpg', '运动健儿', '2017-05-05 00:00:00', '25');
INSERT INTO `ps_class_style` VALUES ('8', '/PrimaryScoolProject/resources/Uploads/images/5dc6c6bdf9e2454e8cb8ed4bd5dc9ec6.png', '哈哈哈哈', '2017-05-11 00:00:00', '25');
INSERT INTO `ps_class_style` VALUES ('9', '/PrimaryScoolProject/resources/Uploads/images/87aec7636efa43028a4f7da42e2e3183.png', '哈哈哈哈按时大大', '2017-05-11 00:00:00', '25');

-- ----------------------------
-- Table structure for ps_class_synopsis
-- ----------------------------
DROP TABLE IF EXISTS `ps_class_synopsis`;
CREATE TABLE `ps_class_synopsis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(255) DEFAULT NULL,
  `class_synopsis` text,
  PRIMARY KEY (`id`),
  KEY `idx_sys_class_class_synopsis` (`class_synopsis`(255)),
  KEY `idx_sys_class_class_id` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_class_synopsis
-- ----------------------------
INSERT INTO `ps_class_synopsis` VALUES ('1', '1', null);

-- ----------------------------
-- Table structure for ps_contact
-- ----------------------------
DROP TABLE IF EXISTS `ps_contact`;
CREATE TABLE `ps_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `add_time` date DEFAULT NULL,
  `is_publish` int(2) DEFAULT NULL,
  `author` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_contact
-- ----------------------------
INSERT INTO `ps_contact` VALUES ('2', '<p>地址：科学大道166号<br></p><p><iframe class=\"ueditor_baidumap\" src=\"http://ueditor.baidu.com/ueditor/dialogs/map/show.html#center=113.540633,34.822825&zoom=13&amp;width=478&amp;height=258&amp;markers=113.521661,34.815239&amp;markerStyles=l,A\" frameborder=\"0\" height=\"258\" width=\"478\"><br></iframe></p><p><br></p>', '2017-04-21', '1', '万科小学');

-- ----------------------------
-- Table structure for ps_copyright
-- ----------------------------
DROP TABLE IF EXISTS `ps_copyright`;
CREATE TABLE `ps_copyright` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `add_time` date DEFAULT NULL,
  `is_publish` int(11) DEFAULT NULL,
  `author` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_copyright
-- ----------------------------
INSERT INTO `ps_copyright` VALUES ('1', '<p>QWEEWQEQE<br></p><p><br></p>', '2017-04-21', '0', '万科小学');

-- ----------------------------
-- Table structure for ps_course_score
-- ----------------------------
DROP TABLE IF EXISTS `ps_course_score`;
CREATE TABLE `ps_course_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stuinfo_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `course_id` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT '0',
  `addTime` date DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_course_score
-- ----------------------------
INSERT INTO `ps_course_score` VALUES ('2', '2', '25', '2', '90', '2017-04-29', '万科小学');
INSERT INTO `ps_course_score` VALUES ('5', '2', '25', '1', '55', '2017-04-29', '万科小学');
INSERT INTO `ps_course_score` VALUES ('6', '2', '25', '3', '59', '2017-04-29', '万科小学');
INSERT INTO `ps_course_score` VALUES ('22', '1', '25', '1', '95', '2017-05-01', '万科小学');
INSERT INTO `ps_course_score` VALUES ('23', '1', '25', '2', '94', '2017-05-01', '万科小学');
INSERT INTO `ps_course_score` VALUES ('24', '1', '25', '3', '93', '2017-05-01', '万科小学');
INSERT INTO `ps_course_score` VALUES ('31', '2', '25', '1', '87', '2017-05-01', '万科小学');
INSERT INTO `ps_course_score` VALUES ('32', '2', '25', '2', '88', '2017-05-01', '万科小学');
INSERT INTO `ps_course_score` VALUES ('33', '2', '25', '3', '89', '2017-05-01', '万科小学');
INSERT INTO `ps_course_score` VALUES ('34', '19', '25', '1', '33', '2017-05-09', '万科小学');
INSERT INTO `ps_course_score` VALUES ('35', '19', '25', '2', '44', '2017-05-09', '万科小学');
INSERT INTO `ps_course_score` VALUES ('36', '19', '25', '3', '55', '2017-05-09', '万科小学');

-- ----------------------------
-- Table structure for ps_course_studentinfo
-- ----------------------------
DROP TABLE IF EXISTS `ps_course_studentinfo`;
CREATE TABLE `ps_course_studentinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` varchar(255) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `stu_name` varchar(255) DEFAULT NULL,
  `stu_age` int(11) DEFAULT NULL,
  `stu_nation` varchar(255) DEFAULT NULL,
  `stu_sex` varchar(255) DEFAULT NULL,
  `stu_birthday` date DEFAULT NULL,
  `stu_cardId` varchar(255) DEFAULT NULL,
  `stu_address` varchar(255) DEFAULT NULL,
  `stu_phone` varchar(255) DEFAULT NULL,
  `stu_parent` varchar(255) DEFAULT NULL,
  `stu_author` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_student_card_id` (`stu_cardId`) USING BTREE,
  UNIQUE KEY `idx_sys_student_id` (`stu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_course_studentinfo
-- ----------------------------
INSERT INTO `ps_course_studentinfo` VALUES ('1', '6666', '25', '小红', '5', '汉', '男', '2012-02-15', '123456789123456789', '河南省南阳市晁陂镇减肥开', '132456875', '多少', '万科小学');
INSERT INTO `ps_course_studentinfo` VALUES ('2', '66662', '25', '小李', '5', '汉', '女', '2012-03-09', '123456789789456123', '万科城', '4585425', '征程', '万科小学');
INSERT INTO `ps_course_studentinfo` VALUES ('14', '666', '25', '张思', '5', '汉', '男', '2012-05-04', '123456789123456785', '万科城', '1528974523', '张三', '万科小学');
INSERT INTO `ps_course_studentinfo` VALUES ('18', '56226', '25', '', '4', '', '男', '2013-05-09', '265656565669592522', '', '', ' ', '万科小学');
INSERT INTO `ps_course_studentinfo` VALUES ('19', '2222', '25', '张三', '5', '汉', '男', '2012-05-04', '987654321123456789', '万科城', '1452785445', '张胜利', '万科小学');
INSERT INTO `ps_course_studentinfo` VALUES ('20', '2', '25', '测试', '0', '汉', '男', '2017-05-03', '123123123123123123', '万科城', '32328943', '一班', '万科小学');
INSERT INTO `ps_course_studentinfo` VALUES ('22', '1', '25', '第三方', '0', '多少', '男', '2017-05-03', '789789789456456456', '说的', '说的', '说的', '万科小学');

-- ----------------------------
-- Table structure for ps_course_type
-- ----------------------------
DROP TABLE IF EXISTS `ps_course_type`;
CREATE TABLE `ps_course_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_course_type
-- ----------------------------
INSERT INTO `ps_course_type` VALUES ('1', '语文');
INSERT INTO `ps_course_type` VALUES ('2', '英语');
INSERT INTO `ps_course_type` VALUES ('3', '数学');

-- ----------------------------
-- Table structure for ps_culture
-- ----------------------------
DROP TABLE IF EXISTS `ps_culture`;
CREATE TABLE `ps_culture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `item_content` text COMMENT '内容',
  `type_id` int(2) DEFAULT NULL,
  `add_time` date DEFAULT NULL,
  `view_count` int(11) DEFAULT NULL COMMENT '浏览量',
  `is_image` int(2) DEFAULT NULL COMMENT '是否包含图片',
  `is_publish` int(2) DEFAULT NULL COMMENT '是否发布',
  `author` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_culture
-- ----------------------------
INSERT INTO `ps_culture` VALUES ('1', '校务公开222222', '<p>下达是的飒飒大大大大<br></p>', '2', '2017-04-26', '0', '0', '1', '万科小学');
INSERT INTO `ps_culture` VALUES ('2', '校务公开胜多负少第三方', '<p>大声道撒大所多<br></p>', '2', '2017-04-26', '0', '0', '1', '万科小学');
INSERT INTO `ps_culture` VALUES ('3', 'wqeqwwqewqeqeqe', '<p>qweqe<br></p>', '2', '2017-04-26', '0', '0', '1', '万科小学');
INSERT INTO `ps_culture` VALUES ('4', 'asddsaddsad', '<p>asdad<br></p>', '2', '2017-04-26', '0', '0', '1', '万科小学');
INSERT INTO `ps_culture` VALUES ('5', '学校简介', '<p>请问请问群翁<br></p>', '1', '2017-05-09', '0', '0', '1', '万科小学');

-- ----------------------------
-- Table structure for ps_culture_type
-- ----------------------------
DROP TABLE IF EXISTS `ps_culture_type`;
CREATE TABLE `ps_culture_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_type_name` varchar(25) DEFAULT NULL COMMENT '类型名称',
  `item_type_flag` varchar(11) DEFAULT NULL COMMENT '标志',
  PRIMARY KEY (`id`),
  KEY `idx_sys_culture_type_name` (`item_type_name`),
  KEY `idx_sys_culture_type_flag` (`item_type_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_culture_type
-- ----------------------------
INSERT INTO `ps_culture_type` VALUES ('1', '学校简介', 'introduce');
INSERT INTO `ps_culture_type` VALUES ('2', '校务公开', 'affairs');
INSERT INTO `ps_culture_type` VALUES ('3', '校园风光', 'sight');

-- ----------------------------
-- Table structure for ps_departmentlink_content
-- ----------------------------
DROP TABLE IF EXISTS `ps_departmentlink_content`;
CREATE TABLE `ps_departmentlink_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `item_content` text COMMENT '内容',
  `type_id` int(2) DEFAULT NULL,
  `add_time` date DEFAULT NULL,
  `view_count` int(11) DEFAULT NULL COMMENT '浏览量',
  `is_image` int(2) DEFAULT NULL COMMENT '是否包含图片',
  `is_publish` int(2) DEFAULT NULL COMMENT '是否发布',
  `item_author` varchar(50) DEFAULT NULL,
  `department_id` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_departmentlink_content
-- ----------------------------
INSERT INTO `ps_departmentlink_content` VALUES ('1', '第一个工作是遮掩是多大撒大大奥大大大大大大大大奥所大大大大啊大艾斯德斯大', '快干活了<p><br></p>', '1', '2017-03-27', '22', '0', '1', 'ss', '1');
INSERT INTO `ps_departmentlink_content` VALUES ('2', '第二个工作', '干活发工资', '1', '2017-03-29', '13', '0', '1', 'ss', '1');
INSERT INTO `ps_departmentlink_content` VALUES ('3', '第三个工作', '干活要有热情', '2', '2017-03-29', '5', '0', '1', 'ss', '1');
INSERT INTO `ps_departmentlink_content` VALUES ('4', '第四个工作', '我是为了测试而生', '2', '2017-04-06', '1', '0', '1', 'ss', '1');
INSERT INTO `ps_departmentlink_content` VALUES ('7', '第七个工作', '我是为了测试而生7', '1', '2017-04-22', '1', '0', '1', 'zsk', '2');
INSERT INTO `ps_departmentlink_content` VALUES ('8', '第八个工作', '我是为了测试而生8', '1', '2017-04-22', '1', '1', '1', 'zsk', '2');
INSERT INTO `ps_departmentlink_content` VALUES ('9', '第九个工作', '我为了测试而生9', '2', '2017-04-22', '1', '1', '1', 'zsk', '2');
INSERT INTO `ps_departmentlink_content` VALUES ('10', '试试', '<p><img src=\"/PrimaryScoolProject/resources/Uploads/images/28eeefb4-25af-40e9-851b-275db8aa6021.jpg\" alt=\"2\" style=\"max-width:100%;\">试试<br></p><p>试试才<br></p><p><br></p>', '2', '2017-04-23', '0', '1', '1', '万科小学', '5');

-- ----------------------------
-- Table structure for ps_departmentlink_content_type
-- ----------------------------
DROP TABLE IF EXISTS `ps_departmentlink_content_type`;
CREATE TABLE `ps_departmentlink_content_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_type_name` varchar(25) DEFAULT NULL COMMENT '类型名称',
  `item_type_flag` varchar(11) DEFAULT NULL COMMENT '标志',
  PRIMARY KEY (`id`),
  KEY `idx_sys_culture_type_name` (`item_type_name`),
  KEY `idx_sys_culture_type_flag` (`item_type_flag`),
  KEY `idx_sys_department_type_name` (`item_type_name`),
  KEY `idx_sys_department_type_flag` (`item_type_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_departmentlink_content_type
-- ----------------------------
INSERT INTO `ps_departmentlink_content_type` VALUES ('1', '人员安排', 'staff');
INSERT INTO `ps_departmentlink_content_type` VALUES ('2', '工作安排', 'job');

-- ----------------------------
-- Table structure for ps_departmentlink_namelist
-- ----------------------------
DROP TABLE IF EXISTS `ps_departmentlink_namelist`;
CREATE TABLE `ps_departmentlink_namelist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(25) DEFAULT NULL COMMENT '类型名称',
  `department_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_sys_education_type_name` (`department_name`),
  KEY `idx_sys_department_type_name` (`department_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_departmentlink_namelist
-- ----------------------------
INSERT INTO `ps_departmentlink_namelist` VALUES ('1', '教导处', 'teach');
INSERT INTO `ps_departmentlink_namelist` VALUES ('2', '安保处', 'security');
INSERT INTO `ps_departmentlink_namelist` VALUES ('3', '德育处', 'education');
INSERT INTO `ps_departmentlink_namelist` VALUES ('4', '办公室', 'office');
INSERT INTO `ps_departmentlink_namelist` VALUES ('5', '测试', 'test');

-- ----------------------------
-- Table structure for ps_education
-- ----------------------------
DROP TABLE IF EXISTS `ps_education`;
CREATE TABLE `ps_education` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `item_content` text COMMENT '内容',
  `type_id` int(2) DEFAULT NULL,
  `add_time` date DEFAULT NULL,
  `view_count` int(11) DEFAULT NULL COMMENT '浏览量',
  `is_image` int(2) DEFAULT NULL COMMENT '是否包含图片',
  `is_publish` int(2) DEFAULT NULL COMMENT '是否发布',
  `author` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_education
-- ----------------------------
INSERT INTO `ps_education` VALUES ('1', '郑州大学曹少魁教授做“侧链挂接金属配合物的共轭聚合物合成与表征”学术报告与表征”学术报告', '<p>但是对方是谁说的是</p><p><img src=\"/PrimaryScoolProject/resources/Uploads/images/3027d660-3318-49fa-9e53-a24607634b83.jpg\" alt=\"inde33x\" style=\"max-width:100%;\"></p><p><br></p>', '2', '2017-03-27', '42', '1', '1', '万科小学');
INSERT INTO `ps_education` VALUES ('2', '郑州大学曹少魁教授做“侧链挂接金属配合物的共轭聚合物合成与表征”学术报告与表征”学术报告', '的委屈饿温热微软<p><br></p>', '3', '2017-03-29', '16', '0', '1', '万科小学');
INSERT INTO `ps_education` VALUES ('3', 'saa啊啊三大', '的撒大苏打倒萨啊', '3', '2017-03-29', '5', '0', '1', null);

-- ----------------------------
-- Table structure for ps_education_type
-- ----------------------------
DROP TABLE IF EXISTS `ps_education_type`;
CREATE TABLE `ps_education_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_type_name` varchar(25) DEFAULT NULL COMMENT '类型名称',
  `item_type_flag` varchar(11) DEFAULT NULL COMMENT '标志',
  PRIMARY KEY (`id`),
  KEY `idx_sys_education_type_name` (`item_type_name`),
  KEY `idx_sys_education_type_flag` (`item_type_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_education_type
-- ----------------------------
INSERT INTO `ps_education_type` VALUES ('1', '少先队活动', 'active');
INSERT INTO `ps_education_type` VALUES ('2', '主题教育', 'education');
INSERT INTO `ps_education_type` VALUES ('3', '国旗下讲话', 'speak');
INSERT INTO `ps_education_type` VALUES ('4', '家长委员会', 'parents');
INSERT INTO `ps_education_type` VALUES ('5', '心灵驿站', 'stagent');

-- ----------------------------
-- Table structure for ps_file
-- ----------------------------
DROP TABLE IF EXISTS `ps_file`;
CREATE TABLE `ps_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `file_belong_id` int(11) DEFAULT NULL,
  `add_time` datetime DEFAULT NULL,
  `item_id` int(20) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_file
-- ----------------------------
INSERT INTO `ps_file` VALUES ('43', '20170228网站栏目规划-万科城小学.doc', 'b56ae5a8b38a4927bfbdc2de2e72396c.doc', '1', '2017-04-21 00:00:00', '13', null);
INSERT INTO `ps_file` VALUES ('45', 'ChessBoard.cpp', 'e00c86d39b344d5489c4d11aca807061.cpp', '1', '2017-04-21 00:00:00', '13', null);
INSERT INTO `ps_file` VALUES ('46', 'PHP SDK Topic开发指南(Linux).pdf', 'f860c3e72b0c4d6289bd7b9f4cc43981.pdf', '1', '2017-04-22 00:00:00', '12', null);
INSERT INTO `ps_file` VALUES ('47', 'Snipaste-1.11.0-x86.zip', '7740e9ca7e914bc89c8782b539877860.zip', '1', '2017-04-24 00:00:00', '14', null);
INSERT INTO `ps_file` VALUES ('48', 'ps_departmentlink_content.sql', 'b7d0d0c3bfff4c61a964aef5d496e55d.sql', '5', '2017-04-24 00:00:00', '3', null);
INSERT INTO `ps_file` VALUES ('51', '20170504实验报告Ajax技术541413260106韩俊涛.doc', '2056473f586d4069b211a1680551da11.doc', '8', '2017-05-09 05:12:16', '1', null);
INSERT INTO `ps_file` VALUES ('52', 'mingzhi.sql', '779e044cc29c444cb7958a104dcd1b8f.sql', '8', '2017-05-09 05:12:24', '1', null);
INSERT INTO `ps_file` VALUES ('53', 'manageClass.jsp', 'e6f5b810545f4bdd861912f19e1aea66.jsp', '8', '2017-05-09 05:12:40', '1', null);
INSERT INTO `ps_file` VALUES ('54', '2017-04-19_130831.png', 'af0553f82ef1464b838e5e0dbc7dac89.png', '8', '2017-05-09 05:12:48', '1', null);
INSERT INTO `ps_file` VALUES ('55', 'select-tether.rar', '53ffec594ea24236a9bd5761172b456a.rar', '8', '2017-05-09 05:12:58', '1', null);
INSERT INTO `ps_file` VALUES ('56', '20170504实验报告Ajax技术541413260106韩俊涛.doc', 'a14369d043e14321bdd177c30e7c6071.doc', '8', '2017-05-09 05:13:05', '1', null);
INSERT INTO `ps_file` VALUES ('57', '动态知识分享平台设计与实现项目申报书.doc', '71c1acf9a9bb4ab284495c33f2162f23.doc', '8', '2017-05-09 05:13:13', '1', null);
INSERT INTO `ps_file` VALUES ('58', '20170504实验报告Ajax技术541413260106韩俊涛.doc', 'c177291feae94f34a93d67214f669539.doc', '4', '2017-05-09 09:43:37', '6', null);
INSERT INTO `ps_file` VALUES ('59', '表界面logo最终.jpg', '3dd2ddc561f3440891f9f08b8005ea23.jpg', '9', '2017-05-10 10:03:40', '1', null);

-- ----------------------------
-- Table structure for ps_file_belong
-- ----------------------------
DROP TABLE IF EXISTS `ps_file_belong`;
CREATE TABLE `ps_file_belong` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `belong_name` varchar(50) DEFAULT NULL,
  `type_flag` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_file_belong
-- ----------------------------
INSERT INTO `ps_file_belong` VALUES ('1', '学校动态', 'ftrends');
INSERT INTO `ps_file_belong` VALUES ('2', '学校文化', 'fculture');
INSERT INTO `ps_file_belong` VALUES ('3', '阳光德育', 'feducati');
INSERT INTO `ps_file_belong` VALUES ('4', '学生天地', 'fstudent');
INSERT INTO `ps_file_belong` VALUES ('5', '教师园地', 'fteacher');
INSERT INTO `ps_file_belong` VALUES ('6', '党务工会', 'fparty');
INSERT INTO `ps_file_belong` VALUES ('7', '学校管理', 'fmanage');
INSERT INTO `ps_file_belong` VALUES ('8', '作息时间', 'frestTime');
INSERT INTO `ps_file_belong` VALUES ('9', '帮助文档', 'fhelpdoc');

-- ----------------------------
-- Table structure for ps_grade
-- ----------------------------
DROP TABLE IF EXISTS `ps_grade`;
CREATE TABLE `ps_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `grade_name` varchar(25) DEFAULT NULL,
  `grade_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_grade
-- ----------------------------
INSERT INTO `ps_grade` VALUES ('2', '2012级', '2012');
INSERT INTO `ps_grade` VALUES ('3', '2013级', '2013');
INSERT INTO `ps_grade` VALUES ('4', '2014级', '2014');
INSERT INTO `ps_grade` VALUES ('5', '2015级', '2015');
INSERT INTO `ps_grade` VALUES ('6', '2016级', '2016');
INSERT INTO `ps_grade` VALUES ('8', '2017级', '2017');

-- ----------------------------
-- Table structure for ps_headmaster
-- ----------------------------
DROP TABLE IF EXISTS `ps_headmaster`;
CREATE TABLE `ps_headmaster` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `headmaster_name` varchar(20) DEFAULT NULL,
  `headmaster_work` varchar(255) DEFAULT NULL,
  `headmaster_email` varchar(50) DEFAULT NULL,
  `headmaster_avatar` varchar(255) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  `is_publish` int(11) DEFAULT '1',
  `add_time` date DEFAULT NULL,
  `addTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_headmaster
-- ----------------------------
INSERT INTO `ps_headmaster` VALUES ('2', '小明2', '负责学校的日常的管理工作', '4991234@qq.com', '/PrimaryScoolProject/resources/Uploads/images/50e8682a7de046a7a8b1a786b09d5b1d.jpg', '2', '1', null, '2017-04-29');
INSERT INTO `ps_headmaster` VALUES ('4', '小明4', '负责学校的日常的管理工作', '4991234@qq.com', '/PrimaryScoolProject/resources/Uploads/images/c13036bb4f1548ee866cce3a993f3273.jpg', '2', '1', null, '2017-04-29');
INSERT INTO `ps_headmaster` VALUES ('5', '啊啊', '负责宣传工作', '12345566@qq.com', '/PrimaryScoolProject/resources/Uploads/images/8637c829a2ad4a639ee404a9d889f964.jpg', '2', '1', null, '2017-04-29');
INSERT INTO `ps_headmaster` VALUES ('6', '对对对w', '负责大部分工作', '234424@qq.com', '/PrimaryScoolProject/resources/Uploads/images/83641c24ad2047ec8ebec3c23979567c.jpg', '1', '1', null, '2017-04-29');

-- ----------------------------
-- Table structure for ps_headmaster_post
-- ----------------------------
DROP TABLE IF EXISTS `ps_headmaster_post`;
CREATE TABLE `ps_headmaster_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_headmaster_post
-- ----------------------------
INSERT INTO `ps_headmaster_post` VALUES ('1', '校长');
INSERT INTO `ps_headmaster_post` VALUES ('2', '副校长');

-- ----------------------------
-- Table structure for ps_index_images
-- ----------------------------
DROP TABLE IF EXISTS `ps_index_images`;
CREATE TABLE `ps_index_images` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_path` varchar(255) NOT NULL,
  `add_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_index_images
-- ----------------------------

-- ----------------------------
-- Table structure for ps_manage
-- ----------------------------
DROP TABLE IF EXISTS `ps_manage`;
CREATE TABLE `ps_manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `item_content` text COMMENT '内容',
  `type_id` int(2) DEFAULT NULL,
  `add_time` date DEFAULT NULL,
  `view_count` int(11) DEFAULT NULL COMMENT '浏览量',
  `is_image` int(2) DEFAULT NULL COMMENT '是否包含图片',
  `is_publish` int(2) DEFAULT NULL COMMENT '是否发布',
  `author` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_manage
-- ----------------------------
INSERT INTO `ps_manage` VALUES ('1', '学校管理test', '去问问去文万琴俄文全额', '1', '2017-03-28', '4', '0', '1', null);

-- ----------------------------
-- Table structure for ps_manage_type
-- ----------------------------
DROP TABLE IF EXISTS `ps_manage_type`;
CREATE TABLE `ps_manage_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_type_name` varchar(25) DEFAULT NULL COMMENT '类型名称',
  `item_type_flag` varchar(25) DEFAULT NULL COMMENT '标志',
  PRIMARY KEY (`id`),
  KEY `idx_sys_manage_type_name` (`item_type_name`),
  KEY `idx_sys_manage_type_flag` (`item_type_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_manage_type
-- ----------------------------
INSERT INTO `ps_manage_type` VALUES ('1', '部门链接', 'department');
INSERT INTO `ps_manage_type` VALUES ('2', '评职评优', 'recommendation');
INSERT INTO `ps_manage_type` VALUES ('3', '教师会议', 'notice');
INSERT INTO `ps_manage_type` VALUES ('4', '规章制度', 'rules');
INSERT INTO `ps_manage_type` VALUES ('5', '校长信箱', 'email');

-- ----------------------------
-- Table structure for ps_party
-- ----------------------------
DROP TABLE IF EXISTS `ps_party`;
CREATE TABLE `ps_party` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `item_content` text COMMENT '内容',
  `type_id` int(2) DEFAULT NULL,
  `add_time` date DEFAULT NULL,
  `view_count` int(11) DEFAULT NULL COMMENT '浏览量',
  `is_image` int(2) DEFAULT NULL COMMENT '是否包含图片',
  `is_publish` int(2) DEFAULT NULL COMMENT '是否发布',
  `author` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_party
-- ----------------------------
INSERT INTO `ps_party` VALUES ('1', '支部活动test', '我的亲吻全额企鹅企鹅请问', '1', '2017-03-28', '7', '0', '1', null);

-- ----------------------------
-- Table structure for ps_party_type
-- ----------------------------
DROP TABLE IF EXISTS `ps_party_type`;
CREATE TABLE `ps_party_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_type_name` varchar(25) DEFAULT NULL COMMENT '类型名称',
  `item_type_flag` varchar(11) DEFAULT NULL COMMENT '标志',
  PRIMARY KEY (`id`),
  KEY `idx_sys_party_type_flag` (`item_type_flag`),
  KEY `idx_sys_party_type_name` (`item_type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_party_type
-- ----------------------------
INSERT INTO `ps_party_type` VALUES ('1', '支部活动', 'branch');
INSERT INTO `ps_party_type` VALUES ('2', '工会活动', 'trade_union');

-- ----------------------------
-- Table structure for ps_security_permission
-- ----------------------------
DROP TABLE IF EXISTS `ps_security_permission`;
CREATE TABLE `ps_security_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_security_permission
-- ----------------------------
INSERT INTO `ps_security_permission` VALUES ('1', 'super:*');
INSERT INTO `ps_security_permission` VALUES ('2', 'education:*');
INSERT INTO `ps_security_permission` VALUES ('3', 'headteacher:*');
INSERT INTO `ps_security_permission` VALUES ('4', 'supervisor:*');
INSERT INTO `ps_security_permission` VALUES ('5', 'deanoffice:*');
INSERT INTO `ps_security_permission` VALUES ('6', 'office:*');

-- ----------------------------
-- Table structure for ps_security_resources
-- ----------------------------
DROP TABLE IF EXISTS `ps_security_resources`;
CREATE TABLE `ps_security_resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) DEFAULT NULL COMMENT 'url',
  `permission` varchar(255) DEFAULT NULL COMMENT 'permission',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_security_resources
-- ----------------------------
INSERT INTO `ps_security_resources` VALUES ('1', '/admin/loginRegister/**', 'anon');
INSERT INTO `ps_security_resources` VALUES ('3', '/admin/upload/**', 'anon');
INSERT INTO `ps_security_resources` VALUES ('4', '/admin/list/culture', 'roles[superadmin]');
INSERT INTO `ps_security_resources` VALUES ('5', '/admin/list/party', 'roles[superadmin]');
INSERT INTO `ps_security_resources` VALUES ('6', '/admin/list/education', 'roleOrFilter[\"superadmin,education\"]');
INSERT INTO `ps_security_resources` VALUES ('7', '/admin/list/teachingResource', 'roleOrFilter[\"superadmin,supervisor\"]');
INSERT INTO `ps_security_resources` VALUES ('8', '/admin/list/teacher', 'roleOrFilter[\"superadmin,deanoffice\"]');
INSERT INTO `ps_security_resources` VALUES ('9', '/admin/list/manageDepartment', 'roleOrFilter[\"superadmin,deanoffice\"]');
INSERT INTO `ps_security_resources` VALUES ('10', '/admin/list/manage', 'roleOrFilter[\"superadmin,office\"]');
INSERT INTO `ps_security_resources` VALUES ('11', '/admin/authority/**', 'roles[superadmin]');
INSERT INTO `ps_security_resources` VALUES ('12', '/admin/list/apply/**', 'roles[superadmin]');
INSERT INTO `ps_security_resources` VALUES ('14', '/admin/write/culture', 'perms[super:*]');
INSERT INTO `ps_security_resources` VALUES ('15', '/admin/distribute/culture', 'perms[super:*]');
INSERT INTO `ps_security_resources` VALUES ('16', '/admin/delete/culture', 'perms[super:*]');
INSERT INTO `ps_security_resources` VALUES ('17', '/admin/write/trends', 'perms[super:*]');
INSERT INTO `ps_security_resources` VALUES ('18', '/admin/distribute/trends', 'perms[super:*]');
INSERT INTO `ps_security_resources` VALUES ('19', '/admin/delete/trends', 'perms[super:*]');
INSERT INTO `ps_security_resources` VALUES ('20', '/admin/write/party', 'perms[super:*]');
INSERT INTO `ps_security_resources` VALUES ('21', '/admin/distribute/party', 'perms[super:*]');
INSERT INTO `ps_security_resources` VALUES ('22', '/admin/delete/party', 'perms[super:*]');

-- ----------------------------
-- Table structure for ps_security_role
-- ----------------------------
DROP TABLE IF EXISTS `ps_security_role`;
CREATE TABLE `ps_security_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `idx_sys_security_role_name` (`role_name`) USING BTREE,
  UNIQUE KEY `idx_sys_security_role_code` (`role_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_security_role
-- ----------------------------
INSERT INTO `ps_security_role` VALUES ('1', 'superadmin', '超级管理员', null);
INSERT INTO `ps_security_role` VALUES ('2', 'guest', '游客', null);
INSERT INTO `ps_security_role` VALUES ('3', 'education', '德育处', null);
INSERT INTO `ps_security_role` VALUES ('4', 'headteacher', '班主任', null);
INSERT INTO `ps_security_role` VALUES ('5', 'supervisor', '教研组长', null);
INSERT INTO `ps_security_role` VALUES ('6', 'deanoffice', '教导处', null);
INSERT INTO `ps_security_role` VALUES ('7', 'office', '办公室', null);

-- ----------------------------
-- Table structure for ps_security_role_to_permission
-- ----------------------------
DROP TABLE IF EXISTS `ps_security_role_to_permission`;
CREATE TABLE `ps_security_role_to_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `idx_sys_security_role_to_resource_role_id` (`role_id`),
  KEY `idx_sys_security_role_to_resource_resource_id` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_security_role_to_permission
-- ----------------------------
INSERT INTO `ps_security_role_to_permission` VALUES ('1', '1', '1');
INSERT INTO `ps_security_role_to_permission` VALUES ('2', '2', '3');
INSERT INTO `ps_security_role_to_permission` VALUES ('3', '3', '4');
INSERT INTO `ps_security_role_to_permission` VALUES ('4', '4', '5');
INSERT INTO `ps_security_role_to_permission` VALUES ('5', '5', '6');
INSERT INTO `ps_security_role_to_permission` VALUES ('6', '6', '7');

-- ----------------------------
-- Table structure for ps_security_user
-- ----------------------------
DROP TABLE IF EXISTS `ps_security_user`;
CREATE TABLE `ps_security_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '用户状态 1为正常，0为禁用',
  `email` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL COMMENT '工号',
  `add_time` datetime DEFAULT NULL,
  `out_date` double DEFAULT NULL,
  `validataCode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `idx_sys_security_username` (`username`) USING BTREE,
  UNIQUE KEY `idx_sys_security_email` (`email`) USING BTREE,
  UNIQUE KEY `idx_sys_security_number` (`number`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_security_user
-- ----------------------------
INSERT INTO `ps_security_user` VALUES ('2', 'mingshan', '5f9d2c655e00de34e468083421a4d4ef', 'mingshan', '1', '715604127@qq.com', '345', '2017-04-22 00:00:00', null, null);
INSERT INTO `ps_security_user` VALUES ('3', 'admin', '038bdaf98f2037b31f1e75b5b4c9b26e', 'admin', '1', '499445428@qq.com', '2233', '2017-04-22 00:00:00', null, null);
INSERT INTO `ps_security_user` VALUES ('14', '哇哇哇哇哇', 'b21c6c8d7b350edd8927ce2f79533183', '哇哇哇哇哇', '1', '123456789@qq.com', '23344', '2017-04-22 00:00:00', null, null);
INSERT INTO `ps_security_user` VALUES ('15', 'hq', '98f9647a0e4b2ce82909f5c5a23e2d89', 'hq', '1', '1872069226@qq.com', '666', '2017-05-07 00:00:00', null, null);

-- ----------------------------
-- Table structure for ps_security_user_to_role
-- ----------------------------
DROP TABLE IF EXISTS `ps_security_user_to_role`;
CREATE TABLE `ps_security_user_to_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `sys_security_user_to_role_user_id` (`user_id`) USING BTREE,
  KEY `sys_security_user_to_role_role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_security_user_to_role
-- ----------------------------
INSERT INTO `ps_security_user_to_role` VALUES ('1', '1', '3');
INSERT INTO `ps_security_user_to_role` VALUES ('2', '3', '2');
INSERT INTO `ps_security_user_to_role` VALUES ('3', '5', '14');
INSERT INTO `ps_security_user_to_role` VALUES ('4', '2', '15');

-- ----------------------------
-- Table structure for ps_student
-- ----------------------------
DROP TABLE IF EXISTS `ps_student`;
CREATE TABLE `ps_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `item_content` text COMMENT '内容',
  `type_id` int(2) DEFAULT NULL,
  `add_time` date DEFAULT NULL,
  `view_count` int(11) DEFAULT NULL COMMENT '浏览量',
  `is_image` int(2) DEFAULT NULL COMMENT '是否包含图片',
  `is_publish` int(2) DEFAULT NULL COMMENT '是否发布',
  `author` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_student
-- ----------------------------
INSERT INTO `ps_student` VALUES ('1', '沐浴额的亲吻全额', '234244为而我却发我', '1', '2017-03-28', '15', '0', '1', null);

-- ----------------------------
-- Table structure for ps_student_lab
-- ----------------------------
DROP TABLE IF EXISTS `ps_student_lab`;
CREATE TABLE `ps_student_lab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lab_name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_student_lab
-- ----------------------------
INSERT INTO `ps_student_lab` VALUES ('1', '篮球社团');
INSERT INTO `ps_student_lab` VALUES ('2', '足球社团');
INSERT INTO `ps_student_lab` VALUES ('3', '健身操');
INSERT INTO `ps_student_lab` VALUES ('4', '经典阅读');
INSERT INTO `ps_student_lab` VALUES ('5', '魔方七巧板');
INSERT INTO `ps_student_lab` VALUES ('6', '创客社团');
INSERT INTO `ps_student_lab` VALUES ('7', '趣味数学');
INSERT INTO `ps_student_lab` VALUES ('8', '合唱社团');
INSERT INTO `ps_student_lab` VALUES ('9', '心理社团');
INSERT INTO `ps_student_lab` VALUES ('10', '礼仪社团');
INSERT INTO `ps_student_lab` VALUES ('11', '趣味英语');
INSERT INTO `ps_student_lab` VALUES ('12', '信息社团');
INSERT INTO `ps_student_lab` VALUES ('13', '书法社团');
INSERT INTO `ps_student_lab` VALUES ('14', '棋类社团');
INSERT INTO `ps_student_lab` VALUES ('15', '舞蹈社团');
INSERT INTO `ps_student_lab` VALUES ('16', '美术社团');
INSERT INTO `ps_student_lab` VALUES ('17', '食品社团');

-- ----------------------------
-- Table structure for ps_student_lab_menu
-- ----------------------------
DROP TABLE IF EXISTS `ps_student_lab_menu`;
CREATE TABLE `ps_student_lab_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(255) DEFAULT NULL,
  `item_type_flag` varchar(255) DEFAULT NULL,
  `itemTitle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_student_lab_menu
-- ----------------------------
INSERT INTO `ps_student_lab_menu` VALUES ('1', '课程简介', 'intro', null);
INSERT INTO `ps_student_lab_menu` VALUES ('2', '每周主题', 'topic', null);
INSERT INTO `ps_student_lab_menu` VALUES ('3', '成果展示', 'show', null);

-- ----------------------------
-- Table structure for ps_student_lab_menu_content
-- ----------------------------
DROP TABLE IF EXISTS `ps_student_lab_menu_content`;
CREATE TABLE `ps_student_lab_menu_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(255) DEFAULT NULL,
  `item_content` text,
  `menu_id` int(11) DEFAULT NULL,
  `add_time` date DEFAULT NULL,
  `view_count` int(11) DEFAULT '0',
  `is_publish` int(2) DEFAULT '1',
  `is_image` int(2) DEFAULT '0',
  `lab_id` int(11) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_student_lab_menu_content
-- ----------------------------
INSERT INTO `ps_student_lab_menu_content` VALUES ('1', '每周主题1', '啊实打实大大', '2', '2017-04-07', '23', '1', '0', '1', '万科小学');
INSERT INTO `ps_student_lab_menu_content` VALUES ('2', '成果展示2', '的肤色收费方式', '3', '2017-04-07', '6', '1', '0', '1', null);
INSERT INTO `ps_student_lab_menu_content` VALUES ('3', '1312', '<p>123313<br></p>', '2', '2017-05-09', '0', '1', '0', '1', '万科小学');
INSERT INTO `ps_student_lab_menu_content` VALUES ('4', '12333', '<p>1231<br></p>', '2', '2017-05-09', '0', '1', '0', '1', '万科小学');
INSERT INTO `ps_student_lab_menu_content` VALUES ('5', '123123', '<p>3123123<br></p>', '2', '2017-05-09', '0', '1', '0', '1', '万科小学');
INSERT INTO `ps_student_lab_menu_content` VALUES ('6', 'sdd', '<p>fsdfs<br></p>', '2', '2017-05-09', '0', '1', '0', '1', '万科小学');

-- ----------------------------
-- Table structure for ps_student_lab_menu_intro
-- ----------------------------
DROP TABLE IF EXISTS `ps_student_lab_menu_intro`;
CREATE TABLE `ps_student_lab_menu_intro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `introduce` text,
  `menu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_student_lab_menu_intro
-- ----------------------------
INSERT INTO `ps_student_lab_menu_intro` VALUES ('1', '这个一个篮球社团简介', '1');

-- ----------------------------
-- Table structure for ps_student_type
-- ----------------------------
DROP TABLE IF EXISTS `ps_student_type`;
CREATE TABLE `ps_student_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_type_name` varchar(25) DEFAULT NULL COMMENT '类型名称',
  `item_type_flag` varchar(11) DEFAULT NULL COMMENT '标志',
  PRIMARY KEY (`id`),
  KEY `idx_sys_student_type_name` (`item_type_name`),
  KEY `idx_sys_student_type_flag` (`item_type_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_student_type
-- ----------------------------
INSERT INTO `ps_student_type` VALUES ('1', '沐浴书香', 'book');
INSERT INTO `ps_student_type` VALUES ('2', '活动风采', 'activity');
INSERT INTO `ps_student_type` VALUES ('3', '班级主页', 'class');
INSERT INTO `ps_student_type` VALUES ('4', '综合实验课', 'lab');

-- ----------------------------
-- Table structure for ps_teacher
-- ----------------------------
DROP TABLE IF EXISTS `ps_teacher`;
CREATE TABLE `ps_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `item_content` text COMMENT '内容',
  `type_id` int(2) DEFAULT NULL,
  `add_time` date DEFAULT NULL,
  `view_count` int(11) DEFAULT NULL COMMENT '浏览量',
  `is_image` int(2) DEFAULT NULL COMMENT '是否包含图片',
  `is_publish` int(2) DEFAULT NULL COMMENT '是否发布',
  `author` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_teacher
-- ----------------------------
INSERT INTO `ps_teacher` VALUES ('1', '教师xxxxx', '的权威地位啊上次', '1', '2017-03-28', '8', '0', '1', null);

-- ----------------------------
-- Table structure for ps_teacher_type
-- ----------------------------
DROP TABLE IF EXISTS `ps_teacher_type`;
CREATE TABLE `ps_teacher_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_type_name` varchar(25) DEFAULT NULL COMMENT '类型名称',
  `item_type_flag` varchar(25) DEFAULT NULL COMMENT '标志',
  PRIMARY KEY (`id`),
  KEY `idx_sys_teacher_type_flag` (`item_type_flag`),
  KEY `idx_sys_teacher_type_name` (`item_type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_teacher_type
-- ----------------------------
INSERT INTO `ps_teacher_type` VALUES ('1', '教学资源', 'resources');
INSERT INTO `ps_teacher_type` VALUES ('2', '教师风采', 'teachers');
INSERT INTO `ps_teacher_type` VALUES ('3', '教师培训', 'train');
INSERT INTO `ps_teacher_type` VALUES ('4', '获奖登记', 'prize');

-- ----------------------------
-- Table structure for ps_teaching_resources_class
-- ----------------------------
DROP TABLE IF EXISTS `ps_teaching_resources_class`;
CREATE TABLE `ps_teaching_resources_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_teaching_resources_class
-- ----------------------------
INSERT INTO `ps_teaching_resources_class` VALUES ('1', '一年级');
INSERT INTO `ps_teaching_resources_class` VALUES ('2', '二年级');
INSERT INTO `ps_teaching_resources_class` VALUES ('3', '三年级');
INSERT INTO `ps_teaching_resources_class` VALUES ('4', '四年级');
INSERT INTO `ps_teaching_resources_class` VALUES ('5', '五年级');
INSERT INTO `ps_teaching_resources_class` VALUES ('6', '六年级');

-- ----------------------------
-- Table structure for ps_teaching_resources_content
-- ----------------------------
DROP TABLE IF EXISTS `ps_teaching_resources_content`;
CREATE TABLE `ps_teaching_resources_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(255) DEFAULT NULL,
  `item_content` text,
  `menu_id` int(11) DEFAULT NULL,
  `add_time` date DEFAULT NULL,
  `view_count` int(11) DEFAULT '0',
  `is_publish` int(2) DEFAULT '1',
  `is_image` int(2) DEFAULT '0',
  `class_id` int(11) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_teaching_resources_content
-- ----------------------------
INSERT INTO `ps_teaching_resources_content` VALUES ('3', 'qwqe', 'eqweq<p><br></p>', '1', '2017-04-09', '0', '1', '0', '1', '万科小学', '1');
INSERT INTO `ps_teaching_resources_content` VALUES ('4', '12231', '<p>1231233<br></p>', '1', '2017-05-09', '0', '1', '0', '1', '万科小学', '1');
INSERT INTO `ps_teaching_resources_content` VALUES ('5', '12313', '<p>3123123<br></p>', '1', '2017-05-09', '0', '1', '0', '1', '万科小学', '1');
INSERT INTO `ps_teaching_resources_content` VALUES ('6', '231312', '<p>312313<br></p>', '1', '2017-05-09', '0', '1', '0', '1', '万科小学', '1');

-- ----------------------------
-- Table structure for ps_teaching_resources_content_type
-- ----------------------------
DROP TABLE IF EXISTS `ps_teaching_resources_content_type`;
CREATE TABLE `ps_teaching_resources_content_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_type_name` varchar(25) DEFAULT NULL COMMENT '类型名称',
  `item_type_flag` varchar(25) DEFAULT NULL COMMENT '标志',
  PRIMARY KEY (`id`),
  KEY `idx_sys_student_type_name` (`item_type_name`),
  KEY `idx_sys_student_type_flag` (`item_type_flag`),
  KEY `idx_sys_resources_content_type_name` (`item_type_name`),
  KEY `idx_sys_resources_content_type_flag` (`item_type_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_teaching_resources_content_type
-- ----------------------------
INSERT INTO `ps_teaching_resources_content_type` VALUES ('1', '教学研讨', 'discuss');
INSERT INTO `ps_teaching_resources_content_type` VALUES ('2', '教学设计', 'design');
INSERT INTO `ps_teaching_resources_content_type` VALUES ('3', '课件', 'courseware');
INSERT INTO `ps_teaching_resources_content_type` VALUES ('4', '微课', 'microlecture');
INSERT INTO `ps_teaching_resources_content_type` VALUES ('5', '题库', 'question-bank');

-- ----------------------------
-- Table structure for ps_teaching_resources_menu
-- ----------------------------
DROP TABLE IF EXISTS `ps_teaching_resources_menu`;
CREATE TABLE `ps_teaching_resources_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_teaching_resources_menu
-- ----------------------------
INSERT INTO `ps_teaching_resources_menu` VALUES ('1', '语文');
INSERT INTO `ps_teaching_resources_menu` VALUES ('2', '数学');
INSERT INTO `ps_teaching_resources_menu` VALUES ('3', '英语');
INSERT INTO `ps_teaching_resources_menu` VALUES ('4', '品德');
INSERT INTO `ps_teaching_resources_menu` VALUES ('5', '信息技术');
INSERT INTO `ps_teaching_resources_menu` VALUES ('6', '科学');
INSERT INTO `ps_teaching_resources_menu` VALUES ('7', '心理');
INSERT INTO `ps_teaching_resources_menu` VALUES ('8', '音乐');
INSERT INTO `ps_teaching_resources_menu` VALUES ('9', '美术');
INSERT INTO `ps_teaching_resources_menu` VALUES ('10', '体育');

-- ----------------------------
-- Table structure for ps_trends
-- ----------------------------
DROP TABLE IF EXISTS `ps_trends`;
CREATE TABLE `ps_trends` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_title` varchar(255) DEFAULT NULL COMMENT '标题',
  `item_content` text COMMENT '内容',
  `type_id` int(2) DEFAULT NULL,
  `add_time` date DEFAULT NULL,
  `view_count` int(11) DEFAULT NULL COMMENT '浏览量',
  `is_image` int(2) DEFAULT NULL COMMENT '是否包含图片',
  `is_publish` int(2) DEFAULT NULL COMMENT '是否发布',
  `author` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_trends
-- ----------------------------
INSERT INTO `ps_trends` VALUES ('10', '啊是大', '<p>啊是大<br></p><p><br></p>', '2', '2017-04-16', '0', '0', '0', '万科小学');
INSERT INTO `ps_trends` VALUES ('12', '风格豆腐干', '<p>但是反复<br></p><p><br></p>', '2', '2017-04-16', '4', '0', '1', '万科小学');
INSERT INTO `ps_trends` VALUES ('13', '好看的风景好看的风景好看的风景好看的风景', '<p>水水水水水水水水sssssss</p><p><br></p><p>&nbsp;&nbsp; 4月14日，应材料与化学工程学院邀请，郑州大学博士生导师曹少魁教授在科学校区化工楼222室作了题为“侧链挂接金属配合物的共轭聚合物合成与表征”的学术报告，我院相关专业教师、学生参加了此次报告。</p><p>&nbsp;&nbsp;\n\n    曹少魁教授介绍了将金属元素引入聚合物链可以赋予聚合物材料独特的光物理、电化学及光化学性能及其在电致发光、光伏器件、传感器和非线性光学等领域所具有的潜在的应用价值；结合课题组相关研究，详细讲解了侧链挂接金属配合物的制备方法以及影响其三阶非线性光学性质的因素；曹教授重点介绍了含金属聚合物在传感器和非线性光学方面的应用。 <br></p><p>&nbsp;&nbsp;\n    会后，曹教授结合自己多年撰写和评审国基金的经验，现场点评指导了我院相关专业教师的国基金申请书。 </p><p> 4月14日，应材料与化学工程学院邀请，郑州大学博士生导师曹少魁教授在科学校区化工楼222室作了题为“侧链挂接金属配合物的共轭聚合物合成与表征”的学术报告，我院相关专业教师、学生参加了此次报告。\n\n   曹少魁教授介绍了将金属元素引入聚合物链可以赋予聚合物材料独特的光物理、电化学及光化学性能及其在电致发光、光伏器件、传感器和非线性光学等领域所具有的潜在的应用价值；结合课题组相关研究，详细讲解了侧链挂接金属配合物的制备方法以及影响其三阶非线性光学性质的因素；曹教授重点介绍了含金属聚合物在传感器和非线性光学方面的应用。\n\n   会后，曹教授结合自己多年撰写和评审国基金的经验，现场点评指导了我院相关专业教师的国基金申请书。 </p><p> 4月14日，应材料与化学工程学院邀请，郑州大学博士生导师曹少魁教授在科学校区化工楼222室作了题为“侧链挂接金属配合物的共轭聚合物合成与表征”的学术报告，我院相关专业教师、学生参加了此次报告。\n\n   曹少魁教授介绍了将金属元素引入聚合物链可以赋予聚合物材料独特的光物理、电化学及光化学性能及其在电致发光、光伏器件、传感器和非线性光学等领域所具有的潜在的应用价值；结合课题组相关研究，详细讲解了侧链挂接金属配合物的制备方法以及影响其三阶非线性光学性质的因素；曹教授重点介绍了含金属聚合物在传感器和非线性光学方面的应用。\n\n   会后，曹教授结合自己多年撰写和评审国基金的经验，现场点评指导了我院相关专业教师的国基金申请书。 </p><p> 4月14日，应材料与化学工程学院邀请，郑州大学博士生导师曹少魁教授在科学校区化工楼222室作了题为“侧链挂接金属配合物的共轭聚合物合成与表征”的学术报告，我院相关专业教师、学生参加了此次报告。\n\n   曹少魁教授介绍了将金属元素引入聚合物链可以赋予聚合物材料独特的光物理、电化学及光化学性能及其在电致发光、光伏器件、传感器和非线性光学等领域所具有的潜在的应用价值；结合课题组相关研究，详细讲解了侧链挂接金属配合物的制备方法以及影响其三阶非线性光学性质的因素；曹教授重点介绍了含金属聚合物在传感器和非线性光学方面的应用。\n\n   会后，曹教授结合自己多年撰写和评审国基金的经验，现场点评指导了我院相关专业教师的国基金申请书。 </p><p> 4月14日，应材料与化学工程学院邀请，郑州大学博士生导师曹少魁教授在科学校区化工楼222室作了题为“侧链挂接金属配合物的共轭聚合物合成与表征”的学术报告，我院相关专业教师、学生参加了此次报告。\n\n   曹少魁教授介绍了将金属元素引入聚合物链可以赋予聚合物材料独特的光物理、电化学及光化学性能及其在电致发光、光伏器件、传感器和非线性光学等领域所具有的潜在的应用价值；结合课题组相关研究，详细讲解了侧链挂接金属配合物的制备方法以及影响其三阶非线性光学性质的因素；曹教授重点介绍了含金属聚合物在传感器和非线性光学方面的应用。\n\n   会后，曹教授结合自己多年撰写和评审国基金的经验，现场点评指导了我院相关专业教师的国基金申请书。 </p><p> 4月14日，应材料与化学工程学院邀请，郑州大学博士生导师曹少魁教授在科学校区化工楼222室作了题为“侧链挂接金属配合物的共轭聚合物合成与表征”的学术报告，我院相关专业教师、学生参加了此次报告。\n\n   曹少魁教授介绍了将金属元素引入聚合物链可以赋予聚合物材料独特的光物理、电化学及光化学性能及其在电致发光、光伏器件、传感器和非线性光学等领域所具有的潜在的应用价值；结合课题组相关研究，详细讲解了侧链挂接金属配合物的制备方法以及影响其三阶非线性光学性质的因素；曹教授重点介绍了含金属聚合物在传感器和非线性光学方面的应用。\n\n   会后，曹教授结合自己多年撰写和评审国基金的经验，现场点评指导了我院相关专业教师的国基金申请书。 </p><p><img src=\"/PrimaryScoolProject/resources/Uploads/images/2aafc8cb-d301-4136-8249-35e299495f55.png\" alt=\"2017-04-19_130831\" style=\"max-width: 100%; width: 719px; height: 494px;\" class=\"\"></p><p><br></p>', '1', '2017-04-19', '154', '1', '1', '万科小学');
INSERT INTO `ps_trends` VALUES ('14', '郑州大学曹少魁教授做“侧链挂接金属配合物的共轭聚合物合成与表征”学术报告与表征”学术报告', '<p>请问饿企鹅恶气呃呃呃请问王企</p><p>鹅请问而且请问饿<br></p><p>的请问企鹅<br></p><p><br></p>', '1', '2017-04-16', '30', '0', '1', '万科小学');
INSERT INTO `ps_trends` VALUES ('15', 'w\'q\'e\'e', '<p>&nbsp;请问请问去<br></p>', '2', '2017-04-16', '0', '0', '1', '万科小学');
INSERT INTO `ps_trends` VALUES ('16', 'ewerwr', '<p>wewr<br></p>', '1', '2017-05-09', '1', '0', '1', '万科小学');
INSERT INTO `ps_trends` VALUES ('17', 'rwer', '<p>wer<br></p>', '1', '2017-05-09', '0', '0', '1', '万科小学');
INSERT INTO `ps_trends` VALUES ('18', 'rwerwrr', '<p>rwerwrwerwe<br></p>', '1', '2017-05-09', '0', '0', '1', '万科小学');
INSERT INTO `ps_trends` VALUES ('19', 'qweqe', '<p>eqweqqw<br></p>', '1', '2017-05-09', '0', '0', '1', '万科小学');
INSERT INTO `ps_trends` VALUES ('20', 'wdqwfsdcs', '<p>sdfsfsfdfsfsd <br></p><p>fd s <br></p>', '1', '2017-05-09', '0', '0', '1', '万科小学');

-- ----------------------------
-- Table structure for ps_trends_type
-- ----------------------------
DROP TABLE IF EXISTS `ps_trends_type`;
CREATE TABLE `ps_trends_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_type_name` varchar(25) DEFAULT NULL COMMENT '类型名称',
  `item_type_flag` varchar(11) DEFAULT NULL COMMENT '标志',
  PRIMARY KEY (`id`),
  KEY `idx_sys_trends_type_flag` (`item_type_flag`),
  KEY `idx_sys_trends_type_name` (`item_type_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ps_trends_type
-- ----------------------------
INSERT INTO `ps_trends_type` VALUES ('1', '校内新闻', 'news');
INSERT INTO `ps_trends_type` VALUES ('2', '通知公告', 'notice');
