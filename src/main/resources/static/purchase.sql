/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : purchase

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 12/12/2019 09:43:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` int(11) NOT NULL,
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_default` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for boss
-- ----------------------------
DROP TABLE IF EXISTS `boss`;
CREATE TABLE `boss`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `thing`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of boss
-- ----------------------------
INSERT INTO `boss` VALUES (1, '华为官方旗舰店');
INSERT INTO `boss` VALUES (8, '华硕旗舰店');
INSERT INTO `boss` VALUES (4, '家具自营店');
INSERT INTO `boss` VALUES (7, '小米官方旗舰店');
INSERT INTO `boss` VALUES (9, '数码自营店');
INSERT INTO `boss` VALUES (5, '服装自营店');
INSERT INTO `boss` VALUES (6, '母婴自营店');
INSERT INTO `boss` VALUES (2, '百货自营店');
INSERT INTO `boss` VALUES (3, '美妆自营店');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int(11) NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `thing_id` int(11) NULL DEFAULT NULL,
  `count` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `thing1`(`thing_id`) USING BTREE,
  INDEX `user1`(`user_id`) USING BTREE,
  CONSTRAINT `thing1` FOREIGN KEY (`thing_id`) REFERENCES `thing` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate`  (
  `id` int(11) NOT NULL,
  `thing_id` int(11) NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `star_num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `thing2`(`thing_id`) USING BTREE,
  CONSTRAINT `thing2` FOREIGN KEY (`thing_id`) REFERENCES `thing` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL,
  `order_num` int(11) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `address_id` int(11) NULL DEFAULT NULL,
  `order_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `us`(`user_id`) USING BTREE,
  INDEX `addre`(`address_id`) USING BTREE,
  CONSTRAINT `addre` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `us` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for oredr_item
-- ----------------------------
DROP TABLE IF EXISTS `oredr_item`;
CREATE TABLE `oredr_item`  (
  `id` int(11) NOT NULL,
  `order_id` int(11) NULL DEFAULT NULL,
  `thing_id` int(11) NULL DEFAULT NULL,
  `count` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `use`(`order_id`) USING BTREE,
  INDEX `th`(`thing_id`) USING BTREE,
  CONSTRAINT `th` FOREIGN KEY (`thing_id`) REFERENCES `thing` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `use` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for thing
-- ----------------------------
DROP TABLE IF EXISTS `thing`;
CREATE TABLE `thing`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `boss_id` int(11) NULL DEFAULT NULL,
  `old_price` decimal(10, 2) NULL DEFAULT NULL,
  `new_price` decimal(10, 2) NULL DEFAULT NULL,
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `bos`(`boss_id`) USING BTREE,
  CONSTRAINT `bos` FOREIGN KEY (`boss_id`) REFERENCES `boss` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thing
-- ----------------------------
INSERT INTO `thing` VALUES (1, '华为mate30', 1, 9999.00, 4099.00, '6', '华为mate30', 'mate30.jpg');
INSERT INTO `thing` VALUES (2, '剪刀', 2, 10.00, 5.00, '1', '最新款锋利剪刀', 'jiandao.jpg');
INSERT INTO `thing` VALUES (3, '中性笔', 2, 15.00, 12.00, '1', '中性笔10支装', 'bi.jpg');
INSERT INTO `thing` VALUES (4, '笔记本', 2, 16.00, 9.00, '1', 'A3笔记本', 'bijiben.jpg');
INSERT INTO `thing` VALUES (5, '保温杯', 2, 26.00, 19.00, '1', '600ml水杯', 'shuibei.jpg');
INSERT INTO `thing` VALUES (6, '小辣椒', 3, 190.00, 159.00, '2', 'MAC小辣椒，送女朋友的不二之选', 'mac.jpg');
INSERT INTO `thing` VALUES (7, '神仙水', 3, 1700.00, 1590.00, '2', '神仙水，见前男友神器', 'shenxian.jpg');
INSERT INTO `thing` VALUES (8, '眉笔', 3, 36.00, 27.00, '2', '眉笔，斩男神器', 'meibi.jpg');
INSERT INTO `thing` VALUES (9, '雅诗兰黛小棕瓶', 3, 220.00, 190.00, '2', '雅诗兰黛小棕瓶眼霜，提拉不紧绷', 'yanshaung.jpg');
INSERT INTO `thing` VALUES (10, '男士面膜', 3, 120.00, 89.00, '2', '去黑头，杜绝干燥肌肤', 'mianmo.jpg');
INSERT INTO `thing` VALUES (11, '沙发', 4, 2900.00, 1955.00, '3', '舒服的沙发，家的感觉', 'shafa.jpg');
INSERT INTO `thing` VALUES (12, '电视柜', 4, 1600.00, 999.00, '3', '一个没有什么用却必不可少的家具', 'dianshigui.jpg');
INSERT INTO `thing` VALUES (13, '床', 4, 2500.00, 1999.00, '3', '996之后最大的安慰', 'chuang.jpg');
INSERT INTO `thing` VALUES (14, ' 衣柜', 4, 100.00, 59.90, '3', '格子衬衫都要挂在这里哦', 'yigui.jpg');
INSERT INTO `thing` VALUES (15, ' 羽绒服', 5, 599.00, 499.00, '4', '林更新同款', 'shangyinan.jpg');
INSERT INTO `thing` VALUES (16, '休闲裤', 5, 269.00, 199.00, '4', '花花公子休闲裤', 'kuzinan.jpg');
INSERT INTO `thing` VALUES (17, '休闲鞋', 5, 199.00, 159.00, '4', '皮卡丘鞋子', 'xiezinan.jpg');
INSERT INTO `thing` VALUES (18, '棒球帽', 5, 88.00, 69.00, '4', 'GitHub棒球帽，彰显身份', 'maozinan.jpg');
INSERT INTO `thing` VALUES (19, '女生羽绒服上衣', 5, 499.00, 399.00, '5', '女生羽绒服', 'shangyinv.jpg');
INSERT INTO `thing` VALUES (20, '女生连衣裙', 5, 599.00, 399.00, '5', '连衣裙可爱', 'nvzhuangqun.jpg');
INSERT INTO `thing` VALUES (21, ' 高跟鞋', 5, 699.00, 299.00, '5', '女生高跟鞋，男生不要尝试', 'xiezinv.jpg');
INSERT INTO `thing` VALUES (22, ' 绒帽', 5, 199.00, 59.00, '5', '女生白色帽子', 'maozinv.jpg');
INSERT INTO `thing` VALUES (23, '小米9', 7, 3999.00, 2999.00, '6', '小米9', 'xiaomi9.jpg');
INSERT INTO `thing` VALUES (24, '神舟笔记本', 9, 4999.00, 4099.00, '6', '神船，精盾上船吧骚年', 'shenchuan.jpg');
INSERT INTO `thing` VALUES (25, '飞行堡垒7', 8, 6999.00, 6599.00, '6', '飞行堡垒7', 'feixingbaolei.jpg');
INSERT INTO `thing` VALUES (26, '婴儿指甲钳', 6, 36.00, 19.00, '7', '婴儿指甲钳，不伤手更安全', 'zhijiaqian.jpg');
INSERT INTO `thing` VALUES (27, '两用棉签', 6, 15.00, 9.00, '7', '棉签，呵护肌肤', 'mianqian.jpg');
INSERT INTO `thing` VALUES (28, '婴儿背带', 6, 55.00, 39.00, '7', '婴儿背带，安全', 'beidai.jpg');
INSERT INTO `thing` VALUES (29, '纸尿裤10片', 6, 99.00, 59.00, '7', '纸尿裤', 'zhiniaoku.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
