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

 Date: 20/12/2019 11:11:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `detail_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_default` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `u`(`user_id`) USING BTREE,
  CONSTRAINT `u` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, '潍城区', '潍坊站', '李浪', '18988885555', '1', 1, '山东省', '潍坊市');
INSERT INTO `address` VALUES (2, '历下区', '天安门', '李浪', '19936658888', NULL, 1, '山东省', '济南市');
INSERT INTO `address` VALUES (3, '东城区', '天安门', '李浪', '18855556666', NULL, 1, '北京市', '北京市');
INSERT INTO `address` VALUES (4, '和平区', '化工厂', '李狼', '15569995556', NULL, 2, '天津市', '天津市');
INSERT INTO `address` VALUES (5, '兴宁区', '123', 'qq ww', '19936653856', NULL, 7, '广西壮族自治区', '南宁市');
INSERT INTO `address` VALUES (6, '历下区', '江西', 'qq ww', '19936653856', NULL, 8, '山东省', '济南市');

-- ----------------------------
-- Table structure for bbs
-- ----------------------------
DROP TABLE IF EXISTS `bbs`;
CREATE TABLE `bbs`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info` varchar(2555) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ewfewfewf`(`user_id`) USING BTREE,
  CONSTRAINT `ewfewfewf` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bbs
-- ----------------------------
INSERT INTO `bbs` VALUES (1, 5, '华为Mate30', '感觉在商城买的好像不是正品', '2019-12-18 18:11:04');
INSERT INTO `bbs` VALUES (2, 3, '剪刀', '这次买的见到很锋利，也非常好', '2019-12-18 18:12:26');
INSERT INTO `bbs` VALUES (13, 2, 'hhhhh', '416513', '2019-12-19 02:27:51');

-- ----------------------------
-- Table structure for boss
-- ----------------------------
DROP TABLE IF EXISTS `boss`;
CREATE TABLE `boss`  (
  `id` int(11) NOT NULL,
  `shopname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `thing`(`shopname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of boss
-- ----------------------------
INSERT INTO `boss` VALUES (1, '华为官方旗舰店', 'huawei', '123456');
INSERT INTO `boss` VALUES (2, '百货自营店', 'baihuo', '123456');
INSERT INTO `boss` VALUES (3, '美妆自营店', 'meizhuang', '123456');
INSERT INTO `boss` VALUES (4, '家具自营店', 'jiaju', '123456');
INSERT INTO `boss` VALUES (5, '服装自营店', 'fuzhuang', '123456');
INSERT INTO `boss` VALUES (6, '母婴自营店', 'muying', '123456');
INSERT INTO `boss` VALUES (7, '小米官方旗舰店', 'xiaomi', '123456');
INSERT INTO `boss` VALUES (8, '华硕旗舰店', 'huashuo', '123456');
INSERT INTO `boss` VALUES (9, '数码自营店', 'shuma', '123456');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `thing_id` int(11) NULL DEFAULT NULL,
  `count` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `u1`(`user_id`) USING BTREE,
  INDEX `t1`(`thing_id`) USING BTREE,
  CONSTRAINT `t1` FOREIGN KEY (`thing_id`) REFERENCES `thing` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `u1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (7, 5, 2, 2);

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `thing_id` int(11) NULL DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `th2`(`thing_id`) USING BTREE,
  INDEX `ghg`(`user_id`) USING BTREE,
  CONSTRAINT `ghg` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `th2` FOREIGN KEY (`thing_id`) REFERENCES `thing` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES (1, 2, '收到了，宝贝不错', 1);
INSERT INTO `evaluate` VALUES (2, 2, '大家千万不要买，真的太垃圾了', 2);
INSERT INTO `evaluate` VALUES (3, 1, '是正品', 4);
INSERT INTO `evaluate` VALUES (4, 2, '不错的', 3);
INSERT INTO `evaluate` VALUES (5, 3, '质量还可以', 6);
INSERT INTO `evaluate` VALUES (6, 4, '不行，太垃圾了', 5);
INSERT INTO `evaluate` VALUES (7, 1, '真的很酷', 6);
INSERT INTO `evaluate` VALUES (8, 2, '11', 2);
INSERT INTO `evaluate` VALUES (9, 2, '11', 2);
INSERT INTO `evaluate` VALUES (10, 7, '给女朋友的', 2);
INSERT INTO `evaluate` VALUES (11, 7, '不错', 7);
INSERT INTO `evaluate` VALUES (12, 3, '给女朋友的', 2);

-- ----------------------------
-- Table structure for order1
-- ----------------------------
DROP TABLE IF EXISTS `order1`;
CREATE TABLE `order1`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `address_id` int(11) NULL DEFAULT NULL,
  `order_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ewf`(`user_id`) USING BTREE,
  INDEX `rrhythty`(`address_id`) USING BTREE,
  CONSTRAINT `ewf` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `rrhythty` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order1
-- ----------------------------
INSERT INTO `order1` VALUES (10, '2019121617220001', '2019-12-16 09:22:01', 2, 4, '1');
INSERT INTO `order1` VALUES (11, '2019121617220002', '2019-12-16 09:22:32', 2, 4, '1');
INSERT INTO `order1` VALUES (12, '2019121617310001', '2019-12-16 09:31:24', 2, 4, '1');
INSERT INTO `order1` VALUES (13, '2019121617330001', '2019-12-16 09:33:43', 2, 4, '1');
INSERT INTO `order1` VALUES (14, '2019121720150001', '2019-12-17 12:15:17', 7, 5, '1');
INSERT INTO `order1` VALUES (15, '2019121811170001', '2019-12-18 03:17:27', 2, 4, '1');
INSERT INTO `order1` VALUES (16, '2019121814100001', '2019-12-18 06:10:52', 8, 6, '1');
INSERT INTO `order1` VALUES (17, '2019121910280001', '2019-12-19 02:28:57', 2, 4, '1');

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NULL DEFAULT NULL,
  `thing_id` int(11) NULL DEFAULT NULL,
  `count` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `yyugug`(`order_id`) USING BTREE,
  INDEX `ycyfdyt`(`thing_id`) USING BTREE,
  CONSTRAINT `ycyfdyt` FOREIGN KEY (`thing_id`) REFERENCES `thing` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `yyugug` FOREIGN KEY (`order_id`) REFERENCES `order1` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES (1, 10, 2, 2);
INSERT INTO `order_item` VALUES (2, 10, 13, 2);
INSERT INTO `order_item` VALUES (3, 11, 7, 1);
INSERT INTO `order_item` VALUES (4, 12, 8, 2);
INSERT INTO `order_item` VALUES (5, 13, 16, 1);
INSERT INTO `order_item` VALUES (6, 14, 7, 1);
INSERT INTO `order_item` VALUES (7, 15, 2, 2);
INSERT INTO `order_item` VALUES (8, 16, 2, 2);
INSERT INTO `order_item` VALUES (9, 17, 3, 1);

-- ----------------------------
-- Table structure for superadmin
-- ----------------------------
DROP TABLE IF EXISTS `superadmin`;
CREATE TABLE `superadmin`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of superadmin
-- ----------------------------
INSERT INTO `superadmin` VALUES ('test', '123456');

-- ----------------------------
-- Table structure for thing
-- ----------------------------
DROP TABLE IF EXISTS `thing`;
CREATE TABLE `thing`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `boss_id` int(11) NULL DEFAULT NULL,
  `old_price` decimal(10, 2) NULL DEFAULT NULL,
  `new_price` decimal(10, 2) NULL DEFAULT NULL,
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rtt`(`boss_id`) USING BTREE,
  CONSTRAINT `rtt` FOREIGN KEY (`boss_id`) REFERENCES `boss` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `thing` VALUES (30, 'lmd', 1, 23.00, 12.00, '1', 'dvrtrvrv', NULL);
INSERT INTO `thing` VALUES (31, 'lmd', 1, 23.00, 12.00, '1', 'dvrtrvrv', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'jack', '123456', '15966106855', 'ncu');
INSERT INTO `user` VALUES (2, '6109117123', '123456', '19936653856', 'ncu');
INSERT INTO `user` VALUES (3, '1250445798', '123456', '19936653856', 'ncu');
INSERT INTO `user` VALUES (4, 'zs', '123456', '18936653856', 'ncu');
INSERT INTO `user` VALUES (5, '18923729888', '123456', '18923729888', 'ncu');
INSERT INTO `user` VALUES (6, '125044579', '123456', '19936653856', '新日暮里');
INSERT INTO `user` VALUES (7, 'ly', '123456', '18923711111', '南昌大学');
INSERT INTO `user` VALUES (8, '6109117122', '123456', '19936653856', 'ncu');

SET FOREIGN_KEY_CHECKS = 1;
