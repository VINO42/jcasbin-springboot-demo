/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : casbin

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 20/11/2021 16:30:19
*/
create database casbin;

use casbin;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for casbin_model
-- ----------------------------
DROP TABLE IF EXISTS `casbin_model`;
CREATE TABLE `casbin_model`  (
  `pid` bigint(0) NOT NULL AUTO_INCREMENT,
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `model_status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'INFORCE',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `model_def` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  PRIMARY KEY (`pid`) USING BTREE,
  INDEX `casbin_model_id_index`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of casbin_model
-- ----------------------------
INSERT INTO `casbin_model` VALUES (1, 'dcd50717e35a46248274102a37a08b8c', 'INFORCE', '2021-11-19 23:53:05', '2021-11-19 23:53:05', '[request_definition]\nr = unit, user, obj, act\n\n[policy_definition]\np = unit, user, obj, act\n\n[policy_effect]\ne = some(where (p.eft == allow))\n\n[matchers]\nm = r.unit == p.unit  && r.user == p.user && keyMatch(r.obj, p.obj) && regexMatch(r.act, p.act)');
INSERT INTO `casbin_model` VALUES (2, '9e0938ebed464f99810c8f15b2ea99f2', 'INFORCE', '2021-11-19 23:54:10', '2021-11-19 23:54:10', '[request_definition]\nr = unit, user, obj, act\n\n[policy_definition]\np = unit, user, obj, act\n\n[policy_effect]\ne = some(where (p.eft == allow))\n\n[matchers]\nm = r.unit == p.unit  && r.user == p.user && keyMatch(r.obj, p.obj) && regexMatch(r.act, p.act)');
INSERT INTO `casbin_model` VALUES (3, '07fb7819d171422d88b1f5c3feaf4044', 'INFORCE', '2021-11-19 23:56:54', '2021-11-19 23:56:54', '[request_definition]\nr = unit, user, obj, act\n\n[policy_definition]\np = unit, user, obj, act\n\n[policy_effect]\ne = some(where (p.eft == allow))\n\n[matchers]\nm = r.unit == p.unit  && r.user == p.user && keyMatch(r.obj, p.obj) && regexMatch(r.act, p.act)');
INSERT INTO `casbin_model` VALUES (4, '7676e669e3ae4f619431c6e2173e34f8', 'INFORCE', '2021-11-19 23:58:12', '2021-11-19 23:58:12', '[request_definition]\nr = unit, user, obj, act\n\n[policy_definition]\np = unit, user, obj, act\n\n[policy_effect]\ne = some(where (p.eft == allow))\n\n[matchers]\nm = r.unit == p.unit  && r.user == p.user && keyMatch(r.obj, p.obj) && regexMatch(r.act, p.act)');

-- ----------------------------
-- Table structure for casbin_rule
-- ----------------------------
DROP TABLE IF EXISTS `casbin_rule`;
CREATE TABLE `casbin_rule`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `ptype` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `v0` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `v1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `v2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `v3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `v4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `v5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of casbin_rule
-- ----------------------------

-- ----------------------------
-- Table structure for rel_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `rel_role_resource`;
CREATE TABLE `rel_role_resource`  (
  `id` int(0) NOT NULL,
  `role_id` int(0) NULL DEFAULT NULL,
  `resource_id` int(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rel_role_resource
-- ----------------------------
INSERT INTO `rel_role_resource` VALUES (1, 1, 1, '2021-11-20 15:08:31', '2021-11-20 15:08:34');
INSERT INTO `rel_role_resource` VALUES (2, 2, 2, '2021-11-20 15:08:40', '2021-11-20 15:08:43');

-- ----------------------------
-- Table structure for rel_user_role
-- ----------------------------
DROP TABLE IF EXISTS `rel_user_role`;
CREATE TABLE `rel_user_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NULL DEFAULT NULL,
  `role_id` int(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rel_user_role
-- ----------------------------
INSERT INTO `rel_user_role` VALUES (1, 1, 1, '2021-11-20 14:09:16', '2021-11-20 14:09:18');
INSERT INTO `rel_user_role` VALUES (2, 2, 2, '2021-11-20 15:03:00', '2021-11-20 15:03:04');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `resource_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_id` int(0) NULL DEFAULT 0,
  `status` tinyint(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES (1, '提问', '/ask', 0, 1, '2021-11-20 14:09:04', '2021-11-20 14:09:06');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, 'admin', '管理员', '1', '2021-11-20 14:08:35', '2021-11-20 14:08:37');
INSERT INTO `sys_role` VALUES (2, 'test', '测试用户', '1', '2021-11-20 15:02:10', '2021-11-20 15:02:12');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `tenant_id` int(0) NULL DEFAULT NULL,
  `login_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `passwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  ` create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `status` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, NULL, 'admin', '123456', 'admin', '2021-11-20 14:08:00', '2021-11-20 14:08:02', 1);
INSERT INTO `sys_user` VALUES (2, NULL, 'alice', '123456', 'admin', '2021-11-20 15:02:27', '2021-11-20 15:02:29', 1);

SET FOREIGN_KEY_CHECKS = 1;
