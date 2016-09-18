/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50547
 Source Host           : localhost
 Source Database       : db_inventory

 Target Server Type    : MySQL
 Target Server Version : 50547
 File Encoding         : utf-8

 Date: 06/04/2016 01:53:33 AM
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `inout_log`
-- ----------------------------
DROP TABLE IF EXISTS `inout_log`;
CREATE TABLE `inout_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inout_code` varchar(64) NOT NULL DEFAULT '' COMMENT '出库入库单code',
  `inventory_sku_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存商品code',
  `inventory_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存code',
  `inventory_item_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存明细code',
  `type` varchar(32) NOT NULL DEFAULT '' COMMENT 'INVENTORY_OUT--出库，INVENTORY_IN--入库',
  `reason` varchar(64) NOT NULL DEFAULT '' COMMENT '原因',
  `old_stock_number` int(11) NOT NULL DEFAULT '0' COMMENT '原始现有库存',
  `old_available_stock_number` int(11) NOT NULL DEFAULT '0' COMMENT '原始可用库存',
  `old_occupy_stock_number` int(11) NOT NULL DEFAULT '0' COMMENT '原始占用库存',
  `change_stock_number` int(11) NOT NULL DEFAULT '0' COMMENT '库存变化值',
  `new_stock_number` int(11) NOT NULL DEFAULT '0' COMMENT '变化后现有库存s',
  `new_available_stock_number` int(11) NOT NULL DEFAULT '0' COMMENT '变化后可用库存',
  `new_occupy_stock_number` int(11) NOT NULL DEFAULT '0' COMMENT '新的占用库存',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `create_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '创建人code',
  `create_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='出库入库流水表';

-- ----------------------------
--  Table structure for `inventory`
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inventory_code` varchar(64) NOT NULL COMMENT '库存code',
  `inventory_name` varchar(32) NOT NULL DEFAULT '' COMMENT '仓库名称',
  `parent_code` varchar(64) NOT NULL DEFAULT '' COMMENT '父仓code',
  `child_code` varchar(64) NOT NULL DEFAULT '' COMMENT '子仓code',
  `inventory_type` varchar(16) NOT NULL DEFAULT '1' COMMENT '父仓，子仓',
  `status` varchar(32) NOT NULL DEFAULT '' COMMENT '状态:NORMAL--正常;',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `create_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '创建人code',
  `create_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `update_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '更新人code',
  `update_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '更新人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT=' 库存表';

-- ----------------------------
--  Table structure for `inventory_apply`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_apply`;
CREATE TABLE `inventory_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apply_code` varchar(64) NOT NULL DEFAULT '' COMMENT '申请单code',
  `inventory_code` varchar(64) NOT NULL DEFAULT '' COMMENT '店code',
  `inventory_name` varchar(32) NOT NULL DEFAULT '' COMMENT '店名称',
  `to_code` varchar(64) NOT NULL DEFAULT '' COMMENT '被申请方code',
  `to_name` varchar(32) NOT NULL DEFAULT '' COMMENT '被申请方名称',
  `comments` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `original_document` varchar(64) NOT NULL DEFAULT '' COMMENT '原始单据号',
  `type` varchar(32) NOT NULL DEFAULT '' COMMENT 'ZONGYUANDIAOHUI--院长总院调回，SHENQINGDIAOHUO--店长申请调货，XIAFADAODIAN--院长下发到店',
  `status` varchar(32) NOT NULL DEFAULT '' COMMENT '状态：XIAFADAODIANWAIT--等待到店；XIAFADAODIANSUCCESS--下发到店完成；XIAFADAODIANREJECT--下发到店拒绝；DAIWOSHENPI--待我审批',
  `create_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '申请人code',
  `create_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '申请人姓名',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '申请时间',
  `update_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '审批人code',
  `update_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '审批人姓名',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '审批时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='申请单';

-- ----------------------------
--  Table structure for `inventory_apply_item`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_apply_item`;
CREATE TABLE `inventory_apply_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apply_item_code` varchar(64) NOT NULL DEFAULT '' COMMENT '申请单明细code',
  `apply_code` varchar(64) NOT NULL DEFAULT '' COMMENT '申请单code',
  `inventory_sku_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存商品code',
  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '数量',
  `create_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '创建人code',
  `create_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='申请单明细';

-- ----------------------------
--  Table structure for `inventory_apply_log`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_apply_log`;
CREATE TABLE `inventory_apply_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apply_log_code` varchar(64) NOT NULL DEFAULT '' COMMENT '申请单日志code',
  `apply_code` varchar(64) NOT NULL DEFAULT '' COMMENT '申请单code',
  `new_status` varchar(32) NOT NULL DEFAULT '' COMMENT '最新状态',
  `description` varchar(255) NOT NULL DEFAULT '' COMMENT '描述',
  `operator_code` varchar(64) NOT NULL DEFAULT '' COMMENT '操作人',
  `operate_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='申请单日志';

-- ----------------------------
--  Table structure for `inventory_in`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_in`;
CREATE TABLE `inventory_in` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `in_code` varchar(64) NOT NULL COMMENT '入库单编码',
  `inventory_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存code',
  `original_document` varchar(64) NOT NULL DEFAULT '' COMMENT '原始单据号',
  `product_type` varchar(32) NOT NULL DEFAULT '' COMMENT '院装，客装',
  `status` varchar(32) NOT NULL DEFAULT '' COMMENT '状态',
  `in_type` varchar(32) NOT NULL DEFAULT '' COMMENT '入库类型：采购入库，申请入库，退货',
  `from_code` varchar(64) NOT NULL DEFAULT '' COMMENT '提供者',
  `create_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '创建人code',
  `create_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='入库单';

-- ----------------------------
--  Table structure for `inventory_in_item`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_in_item`;
CREATE TABLE `inventory_in_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `in_item_code` varchar(64) NOT NULL DEFAULT '' COMMENT '入库单编码',
  `in_code` varchar(64) NOT NULL DEFAULT '' COMMENT '入库单code',
  `inventory_sku_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存商品code',
  `production_time` int(11) NOT NULL DEFAULT '0' COMMENT '生产日期',
  `product_expired_time` int(11) NOT NULL DEFAULT '0' COMMENT '过期时间',
  `single_price` double NOT NULL DEFAULT '0' COMMENT '单价',
  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '数量',
  `status` varchar(32) NOT NULL DEFAULT '' COMMENT '状态',
  `create_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '创建人code',
  `create_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='入库单明细';

-- ----------------------------
--  Table structure for `inventory_item`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_item`;
CREATE TABLE `inventory_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inventory_item_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存明细code',
  `inventory_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存code',
  `inventory_sku_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存商品code',
  `average_price` double NOT NULL DEFAULT '0' COMMENT '加权平均价',
  `stock_number` int(11) NOT NULL DEFAULT '0' COMMENT '现有库存',
  `available_stock_number` int(11) NOT NULL DEFAULT '0' COMMENT '可用库存',
  `occupy_stock_number` int(11) NOT NULL DEFAULT '0' COMMENT '占用库存',
  `status` varchar(32) NOT NULL DEFAULT '' COMMENT '状态：NORMAL--正常；',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '乐观锁版本',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `create_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '创建人code',
  `create_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  `update_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '更新人code',
  `update_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '更新人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='库存明细';

-- ----------------------------
--  Table structure for `inventory_out`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_out`;
CREATE TABLE `inventory_out` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `out_code` varchar(64) NOT NULL DEFAULT '' COMMENT '出库单code',
  `out_type` varchar(32) NOT NULL DEFAULT '' COMMENT '出库类型：手动出库，扫码出库，下发到店，销售出库，总院回调',
  `out_pattern` varchar(32) NOT NULL DEFAULT '' COMMENT '出库方式：美容师领取，调配仓',
  `product_type` varchar(32) NOT NULL DEFAULT '' COMMENT '院装，客装',
  `original_document` varchar(64) NOT NULL DEFAULT '' COMMENT '原始单据号',
  `to_code` varchar(64) NOT NULL DEFAULT '' COMMENT '接收者',
  `to_name` varchar(32) NOT NULL DEFAULT '' COMMENT '接收人姓名',
  `inventory_code` varchar(64) NOT NULL DEFAULT '' COMMENT '子仓code',
  `status` varchar(32) NOT NULL DEFAULT '' COMMENT '状态',
  `jingshouren_code` varchar(64) NOT NULL DEFAULT '' COMMENT '经手人code',
  `jingshouren_name` varchar(32) NOT NULL DEFAULT '' COMMENT '经手人姓名',
  `create_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `inventory_out_item`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_out_item`;
CREATE TABLE `inventory_out_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `out_item_code` varchar(64) NOT NULL DEFAULT '' COMMENT '出库单详情code',
  `out_code` varchar(64) NOT NULL DEFAULT '' COMMENT '出库单code',
  `inventory_sku_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存商品code',
  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '数量',
  `status` varchar(32) NOT NULL DEFAULT '' COMMENT '状态',
  `create_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `inventory_sku`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_sku`;
CREATE TABLE `inventory_sku` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inventory_sku_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存商品code',
  `parent_code` varchar(64) NOT NULL,
  `product_brand_code` varchar(64) NOT NULL DEFAULT '' COMMENT '商品品牌code',
  `product_brand_name` varchar(32) NOT NULL DEFAULT '' COMMENT '商品品牌名称',
  `product_unit` varchar(10) NOT NULL DEFAULT '' COMMENT '商品单位',
  `product_code` varchar(64) NOT NULL DEFAULT '' COMMENT '商品code',
  `product_name` varchar(32) NOT NULL DEFAULT '' COMMENT '商品名称',
  `product_type` varchar(16) NOT NULL DEFAULT '' COMMENT '院装，客装',
  `market_price` double NOT NULL DEFAULT '0' COMMENT '市场价',
  `discount_price` double NOT NULL DEFAULT '0' COMMENT '优惠价',
  `status` varchar(32) NOT NULL DEFAULT '' COMMENT 'NORMAL--正常；',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='库存商品表';

-- ----------------------------
--  Table structure for `inventory_stock_check`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_stock_check`;
CREATE TABLE `inventory_stock_check` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_check_code` varchar(64) NOT NULL DEFAULT '' COMMENT '盘点code',
  `inventory_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存code',
  `status` varchar(32) NOT NULL DEFAULT '' COMMENT '状态',
  `start_time` int(11) NOT NULL DEFAULT '0' COMMENT '开始时间',
  `end_time` int(11) NOT NULL DEFAULT '0' COMMENT '结束时间',
  `create_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '创建人code',
  `create_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `inventory_stock_check_item`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_stock_check_item`;
CREATE TABLE `inventory_stock_check_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_check_item_code` varchar(64) NOT NULL DEFAULT '' COMMENT '盘点明细code',
  `stock_check_code` varchar(64) NOT NULL DEFAULT '' COMMENT '盘点code',
  `inventory_sku_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存商品code',
  `stock_quantity` int(11) NOT NULL DEFAULT '0' COMMENT '库存数量',
  `fact_quantity` int(11) NOT NULL DEFAULT '0' COMMENT '实际数量',
  `difference_quantity` int(11) NOT NULL DEFAULT '0' COMMENT '差异数量',
  `status` varchar(32) NOT NULL DEFAULT '' COMMENT '状态:已平仓，未平仓',
  `create_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '创建人code',
  `create_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '更新人code',
  `update_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '更新人姓名',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `inventory_stock_check_log`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_stock_check_log`;
CREATE TABLE `inventory_stock_check_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stock_check_item_code` varchar(64) NOT NULL DEFAULT '' COMMENT '盘点明细code',
  `descripe` varchar(255) NOT NULL DEFAULT '' COMMENT '描述',
  `operator_code` varchar(64) NOT NULL DEFAULT '' COMMENT '操作人',
  `operate_time` int(11) NOT NULL DEFAULT '0' COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `inventory_stock_check_profit_shortages`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_stock_check_profit_shortages`;
CREATE TABLE `inventory_stock_check_profit_shortages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `profit_shortages_code` varchar(255) NOT NULL DEFAULT '' COMMENT '盘盈盘亏code',
  `stock_check_item_code` varchar(64) NOT NULL DEFAULT '' COMMENT '盘点明细code',
  `inventory_sku_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存商品code',
  `comment` varchar(255) NOT NULL DEFAULT '' COMMENT '备注信息',
  `original_document` varchar(64) NOT NULL DEFAULT '' COMMENT '原始单据号',
  `warehouse_code` varchar(64) NOT NULL DEFAULT '' COMMENT '补货仓code',
  `warehouse_name` varchar(32) NOT NULL DEFAULT '' COMMENT '补货仓名称',
  `type` varchar(32) NOT NULL DEFAULT '' COMMENT 'PROFIT--盘盈, SHORTAGES--盘亏',
  `create_user_code` varchar(64) NOT NULL DEFAULT '' COMMENT '创建人code',
  `create_user_name` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人姓名',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `inventory_warning`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_warning`;
CREATE TABLE `inventory_warning` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inventory_warnning_code` varchar(64) NOT NULL DEFAULT '' COMMENT '提醒code',
  `inventory_sku_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存商品code',
  `inventory_code` varchar(64) NOT NULL DEFAULT '' COMMENT '子仓code',
  `is_send` varchar(16) NOT NULL DEFAULT '' COMMENT '是否发送',
  `is_read` varchar(16) NOT NULL DEFAULT '' COMMENT '是否已读',
  `type` varchar(32) NOT NULL DEFAULT '' COMMENT '提醒类型',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='库存提醒';

-- ----------------------------
--  Table structure for `inventory_warnning_setting`
-- ----------------------------
DROP TABLE IF EXISTS `inventory_warnning_setting`;
CREATE TABLE `inventory_warnning_setting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inventory_code` varchar(64) NOT NULL DEFAULT '' COMMENT '子仓code',
  `inventory_sku_code` varchar(64) NOT NULL DEFAULT '' COMMENT '库存商品code',
  `is_send` varchar(16) NOT NULL DEFAULT '' COMMENT 'SENDED--已发送；UNSEND--未发送',
  `type` varchar(16) NOT NULL DEFAULT '' COMMENT '提醒类型：STOCK_WARNNING-存量提醒；',
  `condition` varchar(64) NOT NULL DEFAULT '' COMMENT '提醒条件',
  `create_time` int(11) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_time` int(11) NOT NULL DEFAULT '0' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存提醒设置';

SET FOREIGN_KEY_CHECKS = 1;
