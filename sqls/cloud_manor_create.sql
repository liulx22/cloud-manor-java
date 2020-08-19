/*
Navicat MySQL Data Transfer

Source Server         : localhost2
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : cloud_manor

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2020-07-30 19:22:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `p_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for agriculture
-- ----------------------------
DROP TABLE IF EXISTS `agriculture`;
CREATE TABLE `agriculture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `operation_time` datetime DEFAULT NULL,
  `put_time` datetime DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agriculture
-- ----------------------------

-- ----------------------------
-- Table structure for agriculture_operation
-- ----------------------------
DROP TABLE IF EXISTS `agriculture_operation`;
CREATE TABLE `agriculture_operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) DEFAULT NULL,
  `oper_time` datetime DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of agriculture_operation
-- ----------------------------

-- ----------------------------
-- Table structure for attention
-- ----------------------------
DROP TABLE IF EXISTS `attention`;
CREATE TABLE `attention` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code_type` int(11) DEFAULT NULL,
  `dest_user_id` int(11) DEFAULT NULL,
  `from_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attention
-- ----------------------------

-- ----------------------------
-- Table structure for band_card_and_user
-- ----------------------------
DROP TABLE IF EXISTS `band_card_and_user`;
CREATE TABLE `band_card_and_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of band_card_and_user
-- ----------------------------

-- ----------------------------
-- Table structure for bank_card
-- ----------------------------
DROP TABLE IF EXISTS `bank_card`;
CREATE TABLE `bank_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(255) DEFAULT NULL,
  `bank_type` varchar(255) DEFAULT NULL,
  `card_num` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_card
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for digital
-- ----------------------------
DROP TABLE IF EXISTS `digital`;
CREATE TABLE `digital` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of digital
-- ----------------------------

-- ----------------------------
-- Table structure for favorite_relation
-- ----------------------------
DROP TABLE IF EXISTS `favorite_relation`;
CREATE TABLE `favorite_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of favorite_relation
-- ----------------------------



-- ----------------------------
-- Table structure for id_card
-- ----------------------------
DROP TABLE IF EXISTS `id_card`;
CREATE TABLE `id_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_num` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of id_card
-- ----------------------------

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img_dir` varchar(255) DEFAULT NULL,
  `img_name` varchar(255) DEFAULT NULL,
  `type_code` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------

-- ----------------------------
-- Table structure for img_rlation
-- ----------------------------
DROP TABLE IF EXISTS `img_rlation`;
CREATE TABLE `img_rlation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_code` int(11) DEFAULT NULL,
  `image_id` int(11) DEFAULT NULL,
  `other_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of img_rlation
-- ----------------------------

-- ----------------------------
-- Table structure for manor_account
-- ----------------------------
DROP TABLE IF EXISTS `manor_account`;
CREATE TABLE `manor_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info` varchar(255) DEFAULT NULL,
  `master_id` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `paccount_code` varchar(255) DEFAULT NULL,
  `record_time` datetime DEFAULT NULL,
  `tag` tinyint(4) NOT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manor_account
-- ----------------------------

-- ----------------------------
-- Table structure for master_account
-- ----------------------------
DROP TABLE IF EXISTS `master_account`;
CREATE TABLE `master_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info` varchar(255) DEFAULT NULL,
  `master_id` int(11) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `remaind_money` double DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master_account
-- ----------------------------

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_id` int(11) DEFAULT NULL,
  `img_dir` varchar(255) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `public_date` datetime DEFAULT NULL,
  `re_type_code` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------

-- ----------------------------
-- Table structure for resource_type
-- ----------------------------
DROP TABLE IF EXISTS `resource_type`;
CREATE TABLE `resource_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_type
-- ----------------------------

-- ----------------------------
-- Table structure for total_account
-- ----------------------------
DROP TABLE IF EXISTS `total_account`;
CREATE TABLE `total_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_code` varchar(255) DEFAULT NULL,
  `cloud_money` double DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `manor_id` int(11) DEFAULT NULL,
  `master_id` int(11) DEFAULT NULL,
  `none_record_money` double DEFAULT NULL,
  `record_money` double DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `total_money` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of total_account
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(255) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `image_id` int(11) DEFAULT NULL,
  `img_dir` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `id_card_id` int(11) DEFAULT NULL,
  `none_recode_money` double DEFAULT NULL,
  `recode_money` double DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_like
-- ----------------------------
DROP TABLE IF EXISTS `user_like`;
CREATE TABLE `user_like` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_like
-- ----------------------------


-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` bigint(255) NULL DEFAULT NULL COMMENT '订单编号',
  `order_time` datetime(0) NULL DEFAULT NULL COMMENT '下单时间',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '下单人id',
  `resource_id` int(11) NULL DEFAULT NULL COMMENT '资源id',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注留言信息',
  `money` double(10, 2) NULL DEFAULT NULL COMMENT '金额',
  `digital_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单状态  （待支付，已支付，已完成，已取消，未退款，）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------


-- ----------------------------
-- Table structure for user_business
-- ----------------------------
DROP TABLE IF EXISTS `user_business`;
CREATE TABLE `user_business` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_type_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL COMMENT '业务详情',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_business
-- ----------------------------