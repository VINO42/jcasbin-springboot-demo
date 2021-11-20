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

 Date: 21/11/2021 00:34:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of casbin_rule
-- ----------------------------
INSERT INTO `casbin_rule` VALUES (234, 'p', 'user_3', '/user/allocate/role/*', 'POST||GET||PUT', NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (235, 'g', 'user_3', 'role_1', NULL, NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (236, 'g', 'user_6', 'role_1', NULL, NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (237, 'p', 'user_7', '/love', 'POST||GET||PUT', NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (238, 'g', 'user_1', 'role_1', NULL, NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (239, 'p', 'user_2', '/test', 'POST||GET||PUT', NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (240, 'g2', '/user/allocate/role/*', 'role_1', NULL, NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (241, 'p', 'user_1', '/user/allocate/role/*', 'POST||GET||PUT', NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (242, 'p', 'user_4', '/user/allocate/role/*', 'POST||GET||PUT', NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (243, 'g', 'user_2', 'role_2', NULL, NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (244, 'g2', '/ask', 'role_1', NULL, NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (245, 'p', 'user_6', '/go', 'POST||GET||PUT', NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (246, 'g', 'user_4', 'role_1', NULL, NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (247, 'p', 'user_1', '/ask', 'POST', NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (248, 'g2', '/go', 'role_1', NULL, NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (249, 'g', 'user_7', 'role_2', NULL, NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (250, 'g2', '/test', 'role_2', NULL, NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (251, 'p', 'user_1', '/go', 'POST||GET||PUT', NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (252, 'p', 'user_4', '/ask', 'POST', NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (253, 'p', 'user_7', '/test', 'POST||GET||PUT', NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (254, 'p', 'user_3', '/go', 'POST||GET||PUT', NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (255, 'p', 'user_3', '/ask', 'POST', NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (256, 'g2', '/love', 'role_3', NULL, NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (257, 'p', 'user_4', '/go', 'POST||GET||PUT', NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (258, 'g', 'user_7', 'role_3', NULL, NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (259, 'p', 'user_6', '/user/allocate/role/*', 'POST||GET||PUT', NULL, NULL, NULL);
INSERT INTO `casbin_rule` VALUES (260, 'p', 'user_6', '/ask', 'POST', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for rel_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `rel_role_resource`;
CREATE TABLE `rel_role_resource`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
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
INSERT INTO `rel_role_resource` VALUES (3, 1, 3, '2021-11-20 20:55:28', '2021-11-20 20:55:30');
INSERT INTO `rel_role_resource` VALUES (4, 1, 4, '2021-11-21 00:33:43', '2021-11-21 00:33:45');
INSERT INTO `rel_role_resource` VALUES (5, 3, 6, '2021-11-21 00:13:35', '2021-11-21 00:13:35');

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
INSERT INTO `rel_user_role` VALUES (3, 4, 1, '2021-11-20 23:00:04', '2021-11-20 23:00:04');
INSERT INTO `rel_user_role` VALUES (6, 3, 1, '2021-11-20 23:07:55', '2021-11-20 23:07:55');
INSERT INTO `rel_user_role` VALUES (8, 6, 1, '2021-11-20 23:55:59', '2021-11-20 23:55:59');
INSERT INTO `rel_user_role` VALUES (9, 7, 2, '2021-11-21 00:02:51', '2021-11-21 00:02:51');
INSERT INTO `rel_user_role` VALUES (10, 7, 3, '2021-11-21 00:14:20', '2021-11-21 00:14:20');

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
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES (1, '提问', '/ask', 0, 1, '2021-11-20 14:09:04', '2021-11-20 21:22:33', 'POST');
INSERT INTO `sys_resource` VALUES (2, '测试', '/test', 0, 1, '2021-11-20 20:48:31', '2021-11-20 21:15:58', 'POST||GET||PUT');
INSERT INTO `sys_resource` VALUES (3, '去', '/go', 0, 1, '2021-11-20 20:55:08', '2021-11-20 21:15:53', 'POST||GET||PUT');
INSERT INTO `sys_resource` VALUES (4, '为用户分配角色', '/user/allocate/role/*', 0, 1, '2021-11-20 22:58:24', '2021-11-20 22:58:35', 'POST||GET||PUT');
INSERT INTO `sys_resource` VALUES (5, '为角色添加资源权限', '/user/allocate/role/resource', 0, 1, '2021-11-21 00:33:59', '2021-11-21 00:34:00', 'POST||GET||PUT');
INSERT INTO `sys_resource` VALUES (6, '爱', '/love', 0, 1, '2021-11-21 00:34:02', '2021-11-21 00:34:03', 'POST||GET||PUT');
INSERT INTO `sys_resource` VALUES (7, '生活', '/live', 0, 1, '2021-11-21 00:34:04', '2021-11-21 00:34:05', 'POST||GET||PUT');
INSERT INTO `sys_resource` VALUES (8, '笑', '/laugh', 0, 1, '2021-11-21 00:34:06', '2021-11-21 00:34:09', 'POST||GET||PUT');

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
INSERT INTO `sys_role` VALUES (3, 'opt', '运营', '1', '2021-11-21 00:08:16', '2021-11-21 00:08:18');

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
INSERT INTO `sys_user` VALUES (3, NULL, 'oldMan', '123456', 'admin', '2021-11-20 22:54:46', '2021-11-20 22:54:49', 1);
INSERT INTO `sys_user` VALUES (4, NULL, 'vino', '123456', 'vino', '2021-11-21 00:34:28', '2021-11-21 00:34:29', 1);
INSERT INTO `sys_user` VALUES (5, NULL, 'adam', '123456', 'adam', '2021-11-21 00:34:30', '2021-11-21 00:34:31', 1);
INSERT INTO `sys_user` VALUES (6, NULL, 'andrew', '123456', 'andrew', '2021-11-21 00:34:32', '2021-11-21 00:34:34', 1);
INSERT INTO `sys_user` VALUES (7, NULL, 'tony', '123456', 'tony', '2021-11-21 00:34:34', '2021-11-21 00:34:36', 1);

SET FOREIGN_KEY_CHECKS = 1;
