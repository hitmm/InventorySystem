/*
 Navicat Premium Data Transfer

 Source Server         : report
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : inventory

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 09/07/2019 19:18:28
*/
create database inventory;
use inventory;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_company_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_company_info`;
CREATE TABLE `tb_company_info`  (
  `id` bigint(20) NOT NULL COMMENT '公司id',
  `company_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公司名称',
  `ceo_id` bigint(20) NULL DEFAULT NULL COMMENT 'ceo id',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ceooid`(`ceo_id`) USING BTREE,
  CONSTRAINT `ceooid` FOREIGN KEY (`ceo_id`) REFERENCES `tb_user_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_customer_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_customer_info`;
CREATE TABLE `tb_customer_info`  (
  `id` bigint(20) NOT NULL COMMENT '客户id',
  `customer_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户全称',
  `customer_alias` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户简称',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户地址',
  `postal_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户的邮政编码',
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户电话',
  `fax` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '传真',
  `contacts` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系人',
  `contacts_tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人电话',
  `mail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人邮箱',
  `bank_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户行',
  `bank_number` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行账号',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_goods_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods_info`;
CREATE TABLE `tb_goods_info`  (
  `id` bigint(20) NOT NULL COMMENT '商品id',
  `goods_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `goods_alias` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品简称',
  `origin_place` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产地',
  `unit_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品单价',
  `unit` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位',
  `specifications` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '规格',
  `package` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '包装',
  `batch_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '批号',
  `approval_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '批准文号',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `supplier_id` bigint(20) NULL DEFAULT NULL COMMENT '供应商id',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `supplier_id1`(`supplier_id`) USING BTREE,
  CONSTRAINT `supplier_id1` FOREIGN KEY (`supplier_id`) REFERENCES `tb_supplier_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_handler
-- ----------------------------
DROP TABLE IF EXISTS `tb_handler`;
CREATE TABLE `tb_handler`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '经手人id',
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '经手人姓名',
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经手人性别',
  `age` int(11) NULL DEFAULT NULL COMMENT '经手人年龄',
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经手人联系方式',
  `enable` int(11) NOT NULL COMMENT '是否启用',
  `user_id` bigint(20) NOT NULL COMMENT '对应的用户id',
  `company_id` bigint(20) NOT NULL COMMENT '所属公司id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `iid`(`user_id`) USING BTREE,
  INDEX `companyiid`(`company_id`) USING BTREE,
  CONSTRAINT `iid` FOREIGN KEY (`user_id`) REFERENCES `tb_user_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `companyiid` FOREIGN KEY (`company_id`) REFERENCES `tb_company_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_sales_return_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_sales_return_detail`;
CREATE TABLE `tb_sales_return_detail`  (
  `id` bigint(20) NOT NULL COMMENT '销售退货id',
  `goods_id` bigint(20) NOT NULL COMMENT '关联商品id',
  `unit_price` decimal(10, 2) NOT NULL COMMENT '单价',
  `return_number` int(11) NOT NULL COMMENT '销售退货数量',
  `main_id` bigint(20) NOT NULL COMMENT '对应的主表id',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goodsid`(`goods_id`) USING BTREE,
  INDEX `salesmainid`(`main_id`) USING BTREE,
  CONSTRAINT `goodsid` FOREIGN KEY (`goods_id`) REFERENCES `tb_goods_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `salesmainid` FOREIGN KEY (`main_id`) REFERENCES `tb_sales_return_main` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_sales_return_main
-- ----------------------------
DROP TABLE IF EXISTS `tb_sales_return_main`;
CREATE TABLE `tb_sales_return_main`  (
  `id` bigint(20) NOT NULL COMMENT '销退票号',
  `varieties_num` int(11) NOT NULL COMMENT '品种数量',
  `total_money` decimal(10, 2) NOT NULL COMMENT '总计金额',
  `acc_conclusion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '验收结论',
  `customer_id` bigint(20) NOT NULL COMMENT '客户id',
  `return_time` bigint(20) NOT NULL COMMENT '退货日期',
  `operator_id` bigint(20) NOT NULL COMMENT '操作员',
  `handler_id` bigint(20) NOT NULL COMMENT '经手人',
  `trades_way` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '结算方式',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `handlerid`(`handler_id`) USING BTREE,
  INDEX `operatorid`(`operator_id`) USING BTREE,
  INDEX `customerid`(`customer_id`) USING BTREE,
  CONSTRAINT `handlerid` FOREIGN KEY (`handler_id`) REFERENCES `tb_handler` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `operatorid` FOREIGN KEY (`operator_id`) REFERENCES `tb_user_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `customerid` FOREIGN KEY (`customer_id`) REFERENCES `tb_customer_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_sell_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell_detail`;
CREATE TABLE `tb_sell_detail`  (
  `id` bigint(20) NOT NULL COMMENT '流水号',
  `goods_id` bigint(50) NOT NULL COMMENT '商品编号',
  `unit_price` decimal(10, 2) NOT NULL COMMENT '销售单价',
  `sale_number` float NOT NULL COMMENT '销售数量',
  `main_id` bigint(20) NOT NULL COMMENT '对应的主表id',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sellgoodsid`(`goods_id`) USING BTREE,
  INDEX `sellmainid`(`main_id`) USING BTREE,
  CONSTRAINT `sellgoodsid` FOREIGN KEY (`goods_id`) REFERENCES `tb_goods_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `sellmainid` FOREIGN KEY (`main_id`) REFERENCES `tb_sell_main` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_sell_main
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell_main`;
CREATE TABLE `tb_sell_main`  (
  `id` bigint(20) NOT NULL COMMENT '销售主表id',
  `varieties_num` int(11) NOT NULL COMMENT '销售品种数目',
  `total_money` decimal(10, 2) NOT NULL COMMENT '总计金额',
  `acc_conclusion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '验收结论',
  `customer_id` bigint(20) NOT NULL COMMENT '客户id',
  `sale_time` bigint(20) NOT NULL COMMENT '销售时间',
  `operator_id` bigint(20) NOT NULL COMMENT '操作员id',
  `handler_id` bigint(20) NOT NULL COMMENT '经手人id',
  `trades_way` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易方式',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `customerid1`(`customer_id`) USING BTREE,
  INDEX `operatorid1`(`operator_id`) USING BTREE,
  INDEX `handlerid1`(`handler_id`) USING BTREE,
  CONSTRAINT `customerid1` FOREIGN KEY (`customer_id`) REFERENCES `tb_customer_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `operatorid1` FOREIGN KEY (`operator_id`) REFERENCES `tb_user_info` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `handlerid1` FOREIGN KEY (`handler_id`) REFERENCES `tb_handler` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_stock
-- ----------------------------
DROP TABLE IF EXISTS `tb_stock`;
CREATE TABLE `tb_stock`  (
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '商品id',
  `goods_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品id',
  `storage_capacity` int(11) NULL DEFAULT NULL COMMENT '库存数量',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_supplier_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_supplier_info`;
CREATE TABLE `tb_supplier_info`  (
  `id` bigint(20) NOT NULL COMMENT '供应商id',
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '供应商全称',
  `alias` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商简称',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `postal_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮政编码',
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `fax` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '传真',
  `contacts` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `contacts_tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人电话',
  `bank` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户银行',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `bank_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行账号',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_user_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_info`;
CREATE TABLE `tb_user_info`  (
  `id` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `age` int(11) NULL DEFAULT 0 COMMENT '年龄',
  `sex` tinyint(1) NOT NULL COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录ip',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `idcard` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `imei` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '移动端设备标识',
  `cityId` int(11) NULL DEFAULT NULL COMMENT '用户所在城市Id',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_info
-- ----------------------------
INSERT INTO `tb_user_info` VALUES (0, 'tsoft', '111', 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);

-- ----------------------------
-- Table structure for tb_warehouse_return_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_warehouse_return_detail`;
CREATE TABLE `tb_warehouse_return_detail`  (
  `id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '进货退货id',
  `goods_id` bigint(20) NOT NULL COMMENT '商品id',
  `unit_price` decimal(10, 2) NOT NULL COMMENT '单价',
  `return_number` int(11) NOT NULL COMMENT '退回数量',
  `main_id` bigint(20) NOT NULL COMMENT '关联主表id',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) NOT NULL COMMENT '更新时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_warehouse_return_main
-- ----------------------------
DROP TABLE IF EXISTS `tb_warehouse_return_main`;
CREATE TABLE `tb_warehouse_return_main`  (
  `id` bigint(20) NOT NULL COMMENT '进货退货编号',
  `varieties_num` int(11) NOT NULL COMMENT '进货退货品种数目',
  `total_money` decimal(10, 2) NOT NULL COMMENT '总计金额',
  `acc_conclusion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '验收结论',
  `customer_id` bigint(20) NOT NULL COMMENT '客户id',
  `sale_time` bigint(20) NOT NULL COMMENT '进货退货时间',
  `operator_id` bigint(20) NOT NULL COMMENT '操作员id',
  `handler_id` bigint(20) NOT NULL COMMENT '经手人id',
  `trades_way` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易方式',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_warehouse_store_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_warehouse_store_detail`;
CREATE TABLE `tb_warehouse_store_detail`  (
  `id` bigint(20) NOT NULL COMMENT '入库流水号',
  `goods_id` bigint(20) NOT NULL COMMENT '商品id',
  `unit_price` decimal(10, 2) NOT NULL COMMENT '进价',
  `unit` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '价格单位',
  `store_number` int(11) NOT NULL COMMENT '入库数量',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) NOT NULL COMMENT '更新时间',
  `main_id` bigint(20) NOT NULL COMMENT '关联主表id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `goodsid2`(`goods_id`) USING BTREE,
  CONSTRAINT `goodsid2` FOREIGN KEY (`goods_id`) REFERENCES `tb_goods_info` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_warehouse_store_main
-- ----------------------------
DROP TABLE IF EXISTS `tb_warehouse_store_main`;
CREATE TABLE `tb_warehouse_store_main`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `varieties_num` int(11) NOT NULL COMMENT '品种数量',
  `total_money` decimal(10, 2) NOT NULL COMMENT '总计金额',
  `acc_conclusion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '验收结论',
  `customer_id` bigint(20) NOT NULL COMMENT '客户id',
  `return_time` bigint(20) NOT NULL COMMENT '退货日期',
  `operator_id` bigint(20) NOT NULL COMMENT '操作员',
  `handler_id` bigint(20) NOT NULL COMMENT '经手人',
  `trades_way` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '结算方式',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `update_time` bigint(20) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- View structure for v_rukuview
-- ----------------------------
DROP VIEW IF EXISTS `v_rukuview`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `v_rukuview` AS select `tb_ruku_main`.`rkID` AS `rkID`,`tb_ruku_detail`.`spid` AS `spid`,`tb_spinfo`.`spname` AS `spname`,`tb_spinfo`.`gg` AS `gg`,`tb_ruku_detail`.`dj` AS `dj`,`tb_ruku_detail`.`sl` AS `sl`,(`tb_ruku_detail`.`dj` * `tb_ruku_detail`.`sl`) AS `je`,`tb_spinfo`.`gysname` AS `gysname`,`tb_ruku_main`.`rkdate` AS `rkdate`,`tb_ruku_main`.`czy` AS `czy`,`tb_ruku_main`.`jsr` AS `jsr`,`tb_ruku_main`.`jsfs` AS `jsfs` from ((`tb_ruku_detail` join `tb_ruku_main` on((`tb_ruku_detail`.`rkID` = `tb_ruku_main`.`rkID`))) join `tb_spinfo` on((`tb_ruku_detail`.`spid` = `tb_spinfo`.`id`)));

-- ----------------------------
-- View structure for v_sellview
-- ----------------------------
DROP VIEW IF EXISTS `v_sellview`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `v_sellview` AS select `tb_sell_main`.`sellID` AS `sellID`,`tb_spinfo`.`spname` AS `spname`,`tb_sell_detail`.`spid` AS `spid`,`tb_spinfo`.`gg` AS `gg`,`tb_sell_detail`.`dj` AS `dj`,`tb_sell_detail`.`sl` AS `sl`,(`tb_sell_detail`.`sl` * `tb_sell_detail`.`dj`) AS `je`,`tb_sell_main`.`khname` AS `khname`,`tb_sell_main`.`xsdate` AS `xsdate`,`tb_sell_main`.`czy` AS `czy`,`tb_sell_main`.`jsr` AS `jsr`,`tb_sell_main`.`jsfs` AS `jsfs` from ((`tb_sell_detail` join `tb_sell_main` on((`tb_sell_detail`.`sellID` = `tb_sell_main`.`sellID`))) join `tb_spinfo` on((`tb_sell_detail`.`spid` = `tb_spinfo`.`id`)));

SET FOREIGN_KEY_CHECKS = 1;
