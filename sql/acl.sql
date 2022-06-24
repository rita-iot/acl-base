/*
 Navicat Premium Data Transfer

 Source Server         : 42.192.37.49
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 42.192.37.49:3306
 Source Schema         : acl

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 07/06/2022 10:14:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for acl_dept
-- ----------------------------
DROP TABLE IF EXISTS `acl_dept`;
CREATE TABLE `acl_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of acl_dept
-- ----------------------------

-- ----------------------------
-- Table structure for acl_emo
-- ----------------------------
DROP TABLE IF EXISTS `acl_emo`;
CREATE TABLE `acl_emo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11111169 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of acl_emo
-- ----------------------------
INSERT INTO `acl_emo` VALUES (11111155, '阿达', '2022-03-25 18:55:03');
INSERT INTO `acl_emo` VALUES (11111165, '吹过你吹过的晚风 走过你走过的路 看过你看过的晚霞 可身边缺没有你', '2022-03-30 08:54:54');
INSERT INTO `acl_emo` VALUES (11111166, '怎样的雨 怎样的夜， 怎样的我能让你更想念， 雨要多大， 天要多黑 才能够有你的体贴。', '2022-03-30 09:01:48');
INSERT INTO `acl_emo` VALUES (11111167, '爱情不是一个人的旅途，双向的奔赴才有意义…', '2022-04-05 21:03:53');
INSERT INTO `acl_emo` VALUES (11111168, '我们总以为来日方长,却忘记了世事无常。愿疫情早日结束,静候春暖花开，去见想见的人', '2022-04-07 08:57:47');

-- ----------------------------
-- Table structure for acl_log
-- ----------------------------
DROP TABLE IF EXISTS `acl_log`;
CREATE TABLE `acl_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '日志类型，1登录日志，2操作日志',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `remote_ip` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'ip',
  `request_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'url',
  `method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `params` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '请求参数',
  `opsTime` int(11) NULL DEFAULT NULL COMMENT '请求时长 ms',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `remarks` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `request_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '请求方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 299 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of acl_log
-- ----------------------------
INSERT INTO `acl_log` VALUES (2, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 86, '2022-03-29 13:33:40', NULL, NULL, 'GET');
INSERT INTO `acl_log` VALUES (3, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 109, '2022-03-29 13:36:05', NULL, NULL, 'PUT');
INSERT INTO `acl_log` VALUES (4, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 84, '2022-03-29 13:36:09', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (5, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 85, '2022-03-29 13:36:13', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (6, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 81, '2022-03-29 13:36:27', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (8, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 533, '2022-03-29 13:45:19', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (9, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 592, '2022-03-29 13:45:19', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (10, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 566, '2022-03-29 13:46:54', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (11, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 580, '2022-03-29 13:47:58', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (12, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 96, '2022-03-29 13:48:09', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (13, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 100, '2022-03-29 13:48:10', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (14, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 99, '2022-03-29 13:48:11', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (15, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 66, '2022-03-29 13:48:11', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (16, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 69, '2022-03-29 13:48:11', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (17, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 99, '2022-03-29 13:48:17', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (18, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 67, '2022-03-29 13:48:17', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (19, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 65, '2022-03-29 13:48:18', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (20, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 70, '2022-03-29 13:48:18', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (21, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 67, '2022-03-29 13:48:19', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (22, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 67, '2022-03-29 13:48:19', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (23, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 65, '2022-03-29 13:48:19', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (24, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 65, '2022-03-29 13:48:20', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (25, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 66, '2022-03-29 13:48:20', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (26, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 75, '2022-03-29 13:48:21', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (27, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 65, '2022-03-29 13:48:21', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (28, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 63, '2022-03-29 13:48:21', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (29, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 62, '2022-03-29 13:48:21', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (32, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 66, '2022-03-29 13:48:22', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (34, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 64, '2022-03-29 13:48:23', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (35, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 68, '2022-03-29 13:48:23', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (36, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 65, '2022-03-29 13:48:24', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (37, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 65, '2022-03-29 13:48:24', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (38, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', '  role: Role(id=null, roleName=null, roleCode=null, remark=null, isDeleted=null, createTime=null, updateTime=null)', 99, '2022-03-29 13:48:27', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (40, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 14:23:22', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (41, '2', '分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 96, '2022-03-29 14:25:55', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (42, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 522, '2022-03-29 14:26:28', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (43, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 85, '2022-03-29 14:26:54', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (44, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 14:31:42', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (45, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 141, '2022-03-29 14:31:44', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (46, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 32, '2022-03-29 14:31:52', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (47, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 23, '2022-03-29 14:32:01', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (48, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-29 14:32:33', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (49, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-29 14:32:39', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (50, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 31, '2022-03-29 14:33:25', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (51, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-29 14:33:26', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (52, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 31, '2022-03-29 14:35:03', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (53, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 14:35:24', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (54, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 14:37:52', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (55, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 14:37:59', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (56, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 14:38:33', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (57, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 17, '2022-03-29 14:38:34', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (58, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 14:39:03', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (59, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-29 14:39:41', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (60, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-29 14:43:29', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (61, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 14:47:12', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (62, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 14:58:17', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (63, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-29 14:58:36', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (64, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 15:13:09', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (65, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 21, '2022-03-29 15:13:23', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (66, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 18, '2022-03-29 15:15:16', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (67, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-29 15:15:20', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (68, '1', 'xizi', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 15:39:59', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (69, '2', '角色管理-分页', '219.157.255.234', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 0, '2022-03-29 15:39:59', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (70, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 15:41:05', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (71, '2', '角色管理-分页', '219.157.255.234', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 31, '2022-03-29 15:41:06', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (72, '2', '角色管理-分页', '219.157.255.234', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-29 15:41:13', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (73, '1', 'xizi', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 15:41:25', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (74, '2', '角色管理-分页', '219.157.255.234', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-29 15:41:25', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (75, '1', 'xizi211', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 15:41:35', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (76, '2', '角色管理-分页', '219.157.255.234', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 17, '2022-03-29 15:41:35', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (77, '1', 'xizi', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 15:42:42', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (78, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-29 15:42:47', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (79, '1', 'xizi', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 15:42:58', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (80, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 31, '2022-03-29 15:50:22', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (81, '2', '角色管理-分页', '219.157.255.234', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 31, '2022-03-29 15:59:39', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (82, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 31, '2022-03-29 16:02:56', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (83, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-29 16:02:58', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (84, '1', 'xizi', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 16:03:07', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (85, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-29 16:03:08', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (86, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 0, '2022-03-29 16:03:46', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (87, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-29 16:04:49', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (88, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-29 16:04:53', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (89, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 21, '2022-03-29 16:05:04', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (90, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 16:22:12', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (91, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-29 16:22:22', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (92, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 16:26:51', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (93, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-29 16:51:36', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (94, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-29 16:51:50', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (95, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-29 16:51:51', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (96, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-29 16:51:55', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (97, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 17:07:22', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (98, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 47, '2022-03-29 17:07:34', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (99, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 18:26:45', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (100, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 19:03:04', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (101, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-29 19:03:16', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (102, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-29 19:18:55', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (104, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 21, '2022-03-29 19:20:04', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (105, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-29 19:20:08', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (106, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 31, '2022-03-29 19:23:01', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (107, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-29 19:23:14', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (108, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-29 19:30:17', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (109, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-29 20:51:43', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (110, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 20, '2022-03-29 20:51:43', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (111, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-29 20:57:36', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (112, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-29 21:26:17', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (113, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-30 08:39:49', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (114, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-30 08:40:04', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (115, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-30 08:40:17', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (116, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 18, '2022-03-30 08:49:40', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (117, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-30 09:00:07', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (118, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-30 09:27:24', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (119, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-30 10:01:30', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (120, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-30 10:01:35', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (121, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-30 10:02:48', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (122, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-30 12:54:14', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (123, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-30 13:47:44', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (124, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-30 22:23:35', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (125, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 62, '2022-03-30 22:23:48', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (126, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-30 22:23:51', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (127, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 31, '2022-03-30 22:25:16', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (128, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-03-30 22:31:11', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (129, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-31 08:37:54', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (130, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-03-31 08:38:01', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (131, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-03-31 17:55:30', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (132, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-01 09:37:18', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (133, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-01 09:39:50', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (134, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-01 09:50:10', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (135, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-01 11:59:53', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (136, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-01 15:20:42', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (137, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-01 17:03:34', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (138, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-04-01 17:03:43', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (139, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 17, '2022-04-01 17:04:04', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (140, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-01 18:27:35', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (141, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-04-01 18:29:58', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (142, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-02 09:13:32', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (143, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-02 15:10:46', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (144, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-04-02 15:10:54', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (145, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-04-02 15:46:16', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (146, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-04-02 15:47:15', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (147, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-04-02 15:47:20', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (148, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-04-02 15:47:21', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (149, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-03 18:59:56', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (150, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-04-03 19:00:27', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (151, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-03 21:29:16', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (152, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-05 20:56:58', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (153, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-04-05 20:57:04', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (154, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-05 22:26:57', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (155, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-04-05 22:27:26', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (156, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-05 22:40:05', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (157, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-05 22:40:21', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (158, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 09:13:44', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (159, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 19, '2022-04-06 09:17:48', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (160, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 09:27:59', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (161, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 09:28:20', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (162, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 09:33:00', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (163, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 10:39:27', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (164, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 10:39:31', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (165, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 10:39:53', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (166, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 93, '2022-04-06 10:39:57', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (167, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 10095, '2022-04-06 10:55:49', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (168, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 11:02:00', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (169, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 11:02:03', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (170, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 20, '2022-04-06 11:02:10', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (171, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-04-06 11:02:26', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (172, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 11:03:17', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (173, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-04-06 11:03:20', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (174, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 11:04:14', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (175, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 11:04:33', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (176, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 11:55:06', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (177, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 11:55:08', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (178, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 11:55:08', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (179, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-06 15:16:58', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (180, '2', '角色管理-分页', '219.157.255.234', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-04-06 15:25:02', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (181, '2', '角色管理-分页', '219.157.255.234', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-04-06 15:26:11', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (182, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-07 08:57:42', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (183, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-08 19:05:24', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (184, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-09 19:49:28', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (185, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-10 14:59:47', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (186, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-10 15:06:29', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (187, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-10 15:06:31', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (188, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-10 16:20:30', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (189, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-12 17:01:14', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (190, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-16 10:55:59', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (191, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-17 11:40:41', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (192, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-25 14:31:28', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (193, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-04-25 14:33:25', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (194, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-04-26 16:23:01', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (195, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-03 16:10:36', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (196, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-04 08:25:30', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (197, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-06 21:47:03', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (198, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-16 16:33:20', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (199, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-16 16:34:00', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (200, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 47, '2022-05-16 16:34:04', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (201, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-16 16:34:43', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (202, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-05-16 16:35:02', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (203, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-05-16 16:35:12', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (204, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-05-16 16:35:18', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (205, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 6, '2022-05-16 16:39:44', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (206, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-05-16 16:39:48', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (207, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-16 19:32:56', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (208, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-19 21:36:17', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (209, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 47, '2022-05-19 21:38:38', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (210, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-20 11:41:41', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (211, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 17, '2022-05-20 11:41:54', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (212, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-24 14:38:12', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (213, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-05-24 14:38:20', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (214, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-05-24 14:38:22', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (215, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-24 14:40:54', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (216, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-25 01:03:35', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (217, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-25 07:14:17', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (218, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-25 07:41:47', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (219, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-25 08:07:20', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (220, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-25 08:25:38', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (221, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-25 13:43:55', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (222, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-25 14:10:30', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (223, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-25 15:07:19', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (224, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-25 15:28:00', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (225, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-25 15:43:27', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (226, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-25 15:45:57', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (227, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-25 19:46:57', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (228, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-25 22:37:27', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (229, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-25 23:16:05', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (230, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-26 05:56:55', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (231, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-26 06:34:24', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (232, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-26 11:48:04', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (233, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-26 15:28:23', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (234, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-05-26 15:28:30', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (235, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-27 04:39:07', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (236, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-27 16:24:40', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (237, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-28 04:33:34', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (238, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-28 08:14:18', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (239, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-28 10:14:37', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (240, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-28 11:45:33', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (241, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-28 12:59:03', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (242, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-28 21:00:14', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (243, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-29 22:40:58', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (244, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-30 03:07:54', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (245, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-30 03:52:33', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (246, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-30 07:58:24', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (247, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-30 08:39:04', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (248, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-30 15:56:59', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (249, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-30 19:37:28', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (250, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-31 01:58:39', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (251, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-31 09:50:05', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (252, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 16, '2022-05-31 09:50:11', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (253, '2', '角色管理-分页', '0:0:0:0:0:0:0:1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 15, '2022-05-31 09:50:23', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (254, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-31 13:37:41', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (255, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-31 14:36:46', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (256, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-31 21:29:52', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (257, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-05-31 21:49:36', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (258, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-01 00:09:16', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (259, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-01 01:50:34', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (260, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-01 05:41:51', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (261, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-01 06:02:37', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (262, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-01 10:51:29', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (263, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-01 12:23:59', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (264, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-01 13:11:36', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (265, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-01 13:29:32', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (266, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-01 17:35:37', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (267, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-01 19:09:16', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (268, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-02 02:02:15', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (269, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-02 18:21:05', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (270, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-02 21:40:41', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (271, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-03 00:45:53', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (272, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-03 08:52:10', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (273, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-03 17:16:12', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (274, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-04 08:34:30', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (275, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-04 14:38:12', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (276, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-04 15:25:51', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (277, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-04 16:29:25', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (278, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-04 16:55:07', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (279, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-04 18:03:56', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (280, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-05 00:01:38', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (281, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-05 00:29:14', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (282, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-05 05:55:35', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (283, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-05 11:05:38', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (284, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-05 20:53:43', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (285, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-06 09:24:54', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (286, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-06 13:34:59', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (287, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-06 15:19:18', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (288, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-06 18:17:38', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (289, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 666, '2022-06-06 19:03:03', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (290, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-06 20:43:09', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (291, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-06 20:58:44', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (292, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-06 20:59:49', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (293, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 93, '2022-06-06 21:51:43', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (294, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-06 22:01:52', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (295, '2', '角色管理-分页', '127.0.0.1', '/role/page', 'com.tx.base.primary.controller.RoleController.page()', NULL, 121, '2022-06-06 22:01:53', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (296, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-07 06:52:07', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (297, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-07 07:19:45', NULL, NULL, 'POST');
INSERT INTO `acl_log` VALUES (298, '1', 'admin', '127.0.0.1', '/admin/login', NULL, NULL, NULL, '2022-06-07 07:51:20', NULL, NULL, 'POST');

-- ----------------------------
-- Table structure for acl_permission
-- ----------------------------
DROP TABLE IF EXISTS `acl_permission`;
CREATE TABLE `acl_permission`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '编号',
  `pid` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '所属上级',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `type` tinyint(3) NOT NULL DEFAULT 0 COMMENT '类型(1:菜单,2:按钮)',
  `permission_value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限值',
  `path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '访问路径',
  `component` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态(0:禁止,1:正常)',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_pid`(`pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of acl_permission
-- ----------------------------
INSERT INTO `acl_permission` VALUES ('1195268474480156673', '0', '权限管理', 1, NULL, '/acl', 'Layout', NULL, 1, 0, '2019-11-15 17:13:06', '2019-11-18 13:54:25');
INSERT INTO `acl_permission` VALUES ('1195268616021139457', '1195268474480156673', '用户管理', 1, NULL, 'user/list', '/acl/user/list', NULL, 1, 0, '2019-11-15 17:13:40', '2019-11-18 13:53:12');
INSERT INTO `acl_permission` VALUES ('1195268788138598401', '1195268474480156673', '角色管理', 1, NULL, 'role/list', '/acl/role/list', NULL, 1, 0, '2019-11-15 17:14:21', '2019-11-15 17:14:21');
INSERT INTO `acl_permission` VALUES ('1195268893830864898', '1195268474480156673', '菜单管理', 1, NULL, 'menu/list', '/acl/menu/list', NULL, 1, 0, '2019-11-15 17:14:46', '2019-11-15 17:14:46');
INSERT INTO `acl_permission` VALUES ('1195269143060602882', '1195268616021139457', '查看', 2, 'user.list', '', '', NULL, 1, 0, '2019-11-15 17:15:45', '2019-11-17 21:57:16');
INSERT INTO `acl_permission` VALUES ('1195269295926206466', '1195268616021139457', '添加', 2, 'user.add', 'user/add', '/acl/user/form', NULL, 1, 0, '2019-11-15 17:16:22', '2019-11-15 17:16:22');
INSERT INTO `acl_permission` VALUES ('1195269473479483394', '1195268616021139457', '修改', 2, 'user.update', 'user/update/:id', '/acl/user/form', NULL, 1, 0, '2019-11-15 17:17:04', '2019-11-15 17:17:04');
INSERT INTO `acl_permission` VALUES ('1195269547269873666', '1195268616021139457', '删除', 2, 'user.remove', '', '', NULL, 1, 0, '2019-11-15 17:17:22', '2019-11-15 17:17:22');
INSERT INTO `acl_permission` VALUES ('1195269821262782465', '1195268788138598401', '修改', 2, 'role.update', 'role/update/:id', '/acl/role/form', NULL, 1, 0, '2019-11-15 17:18:27', '2019-11-15 17:19:53');
INSERT INTO `acl_permission` VALUES ('1195269903542444034', '1195268788138598401', '查看', 2, 'role.list', '', '', NULL, 1, 0, '2019-11-15 17:18:47', '2019-11-15 17:18:47');
INSERT INTO `acl_permission` VALUES ('1195270037005197313', '1195268788138598401', '添加', 2, 'role.add', 'role/add', '/acl/role/form', NULL, 1, 0, '2019-11-15 17:19:19', '2019-11-18 11:05:42');
INSERT INTO `acl_permission` VALUES ('1195270442602782721', '1195268788138598401', '删除', 2, 'role.remove', '', '', NULL, 1, 0, '2019-11-15 17:20:55', '2019-11-15 17:20:55');
INSERT INTO `acl_permission` VALUES ('1195270621548568578', '1195268788138598401', '角色权限', 2, 'role.acl', 'role/distribution/:id', '/acl/role/roleForm', NULL, 1, 0, '2019-11-15 17:21:38', '2019-11-15 17:21:38');
INSERT INTO `acl_permission` VALUES ('1195270744097742849', '1195268893830864898', '查看', 2, 'permission.list', '', '', NULL, 1, 0, '2019-11-15 17:22:07', '2019-11-15 17:22:07');
INSERT INTO `acl_permission` VALUES ('1195270810560684034', '1195268893830864898', '添加', 2, 'permission.add', '', '', NULL, 1, 0, '2019-11-15 17:22:23', '2019-11-15 17:22:23');
INSERT INTO `acl_permission` VALUES ('1195270862100291586', '1195268893830864898', '修改', 2, 'permission.update', '', '', NULL, 1, 0, '2019-11-15 17:22:35', '2019-11-15 17:22:35');
INSERT INTO `acl_permission` VALUES ('1195270887933009922', '1195268893830864898', '删除', 2, 'permission.remove', '', '', NULL, 1, 0, '2019-11-15 17:22:41', '2019-11-15 17:22:41');
INSERT INTO `acl_permission` VALUES ('1195349439240048642', '0', '讲师管理', 1, NULL, '/edu/teacher', 'Layout', NULL, 1, 0, '2019-11-15 22:34:49', '2019-11-15 22:34:49');
INSERT INTO `acl_permission` VALUES ('1195349699995734017', '1195349439240048642', '讲师列表', 1, NULL, 'list', '/edu/teacher/list', NULL, 1, 0, '2019-11-15 22:35:52', '2019-11-15 22:35:52');
INSERT INTO `acl_permission` VALUES ('1195349810561781761', '1195349439240048642', '添加讲师', 1, NULL, 'create', '/edu/teacher/form', NULL, 1, 0, '2019-11-15 22:36:18', '2019-11-15 22:36:18');
INSERT INTO `acl_permission` VALUES ('1195349876252971010', '1195349810561781761', '添加', 2, 'teacher.add', '', '', NULL, 1, 0, '2019-11-15 22:36:34', '2019-11-15 22:36:34');
INSERT INTO `acl_permission` VALUES ('1195349979797753857', '1195349699995734017', '查看', 2, 'teacher.list', '', '', NULL, 1, 0, '2019-11-15 22:36:58', '2019-11-15 22:36:58');
INSERT INTO `acl_permission` VALUES ('1195350117270261762', '1195349699995734017', '修改', 2, 'teacher.update', 'edit/:id', '/edu/teacher/form', NULL, 1, 0, '2019-11-15 22:37:31', '2019-11-15 22:37:31');
INSERT INTO `acl_permission` VALUES ('1195350188359520258', '1195349699995734017', '删除', 2, 'teacher.remove', '', '', NULL, 1, 0, '2019-11-15 22:37:48', '2019-11-15 22:37:48');
INSERT INTO `acl_permission` VALUES ('1195350299365969922', '0', '课程分类', 1, NULL, '/edu/subject', 'Layout', NULL, 1, 0, '2019-11-15 22:38:15', '2019-11-15 22:38:15');
INSERT INTO `acl_permission` VALUES ('1195350397751758850', '1195350299365969922', '课程分类列表', 1, NULL, 'list', '/edu/subject/list', NULL, 1, 0, '2019-11-15 22:38:38', '2019-11-15 22:38:38');
INSERT INTO `acl_permission` VALUES ('1195350500512206850', '1195350299365969922', '导入课程分类', 1, NULL, 'import', '/edu/subject/import', NULL, 1, 0, '2019-11-15 22:39:03', '2019-11-15 22:39:03');
INSERT INTO `acl_permission` VALUES ('1195350612172967938', '1195350397751758850', '查看', 2, 'subject.list', '', '', NULL, 1, 0, '2019-11-15 22:39:29', '2019-11-15 22:39:29');
INSERT INTO `acl_permission` VALUES ('1195350687590748161', '1195350500512206850', '导入', 2, 'subject.import', '', '', NULL, 1, 0, '2019-11-15 22:39:47', '2019-11-15 22:39:47');
INSERT INTO `acl_permission` VALUES ('1195350831744782337', '0', '课程管理', 1, NULL, '/edu/course', 'Layout', NULL, 1, 0, '2019-11-15 22:40:21', '2019-11-15 22:40:21');
INSERT INTO `acl_permission` VALUES ('1195350919074385921', '1195350831744782337', '课程列表', 1, NULL, 'list', '/edu/course/list', NULL, 1, 0, '2019-11-15 22:40:42', '2019-11-15 22:40:42');
INSERT INTO `acl_permission` VALUES ('1195351020463296513', '1195350831744782337', '发布课程', 1, NULL, 'info', '/edu/course/info', NULL, 1, 0, '2019-11-15 22:41:06', '2019-11-15 22:41:06');
INSERT INTO `acl_permission` VALUES ('1195351159672246274', '1195350919074385921', '完成发布', 2, 'course.publish', 'publish/:id', '/edu/course/publish', NULL, 1, 0, '2019-11-15 22:41:40', '2019-11-15 22:44:01');
INSERT INTO `acl_permission` VALUES ('1195351326706208770', '1195350919074385921', '编辑课程', 2, 'course.update', 'info/:id', '/edu/course/info', NULL, 1, 0, '2019-11-15 22:42:19', '2019-11-15 22:42:19');
INSERT INTO `acl_permission` VALUES ('1195351566221938690', '1195350919074385921', '编辑课程大纲', 2, 'chapter.update', 'chapter/:id', '/edu/course/chapter', NULL, 1, 0, '2019-11-15 22:43:17', '2019-11-15 22:43:17');
INSERT INTO `acl_permission` VALUES ('1195351862889254913', '0', '统计分析', 1, NULL, '/statistics/daily', 'Layout', NULL, 1, 0, '2019-11-15 22:44:27', '2019-11-15 22:44:27');
INSERT INTO `acl_permission` VALUES ('1195351968841568257', '1195351862889254913', '生成统计', 1, NULL, 'create', '/statistics/daily/create', NULL, 1, 0, '2019-11-15 22:44:53', '2019-11-15 22:44:53');
INSERT INTO `acl_permission` VALUES ('1195352054917074946', '1195351862889254913', '统计图表', 1, NULL, 'chart', '/statistics/daily/chart', NULL, 1, 0, '2019-11-15 22:45:13', '2019-11-15 22:45:13');
INSERT INTO `acl_permission` VALUES ('1195352127734386690', '1195352054917074946', '查看', 2, 'daily.list', '', '', NULL, 1, 0, '2019-11-15 22:45:30', '2019-11-15 22:45:30');
INSERT INTO `acl_permission` VALUES ('1195352215768633346', '1195351968841568257', '生成', 2, 'daily.add', '', '', NULL, 1, 0, '2019-11-15 22:45:51', '2019-11-15 22:45:51');
INSERT INTO `acl_permission` VALUES ('1195352547621965825', '0', 'CMS管理', 1, NULL, '/cms', 'Layout', NULL, 1, 0, '2019-11-15 22:47:11', '2019-11-18 10:51:46');
INSERT INTO `acl_permission` VALUES ('1195352856645701633', '1195353513549205505', '查看', 2, 'banner.list', '', NULL, NULL, 1, 0, '2019-11-15 22:48:24', '2019-11-15 22:48:24');
INSERT INTO `acl_permission` VALUES ('1195352909401657346', '1195353513549205505', '添加', 2, 'banner.add', 'banner/add', '/cms/banner/form', NULL, 1, 0, '2019-11-15 22:48:37', '2019-11-18 10:52:10');
INSERT INTO `acl_permission` VALUES ('1195353051395624961', '1195353513549205505', '修改', 2, 'banner.update', 'banner/update/:id', '/cms/banner/form', NULL, 1, 0, '2019-11-15 22:49:11', '2019-11-18 10:52:05');
INSERT INTO `acl_permission` VALUES ('1195353513549205505', '1195352547621965825', 'Bander列表', 1, NULL, 'banner/list', '/cms/banner/list', NULL, 1, 0, '2019-11-15 22:51:01', '2019-11-18 10:51:29');
INSERT INTO `acl_permission` VALUES ('1195353672110673921', '1195353513549205505', '删除', 2, 'banner.remove', '', '', NULL, 1, 0, '2019-11-15 22:51:39', '2019-11-15 22:51:39');
INSERT INTO `acl_permission` VALUES ('1195354076890370050', '0', '订单管理', 1, NULL, '/order', 'Layout', NULL, 1, 0, '2019-11-15 22:53:15', '2019-11-15 22:53:15');
INSERT INTO `acl_permission` VALUES ('1195354153482555393', '1195354076890370050', '订单列表', 1, NULL, 'list', '/order/list', NULL, 1, 0, '2019-11-15 22:53:33', '2019-11-15 22:53:58');
INSERT INTO `acl_permission` VALUES ('1195354315093282817', '1195354153482555393', '查看', 2, 'order.list', '', '', NULL, 1, 0, '2019-11-15 22:54:12', '2019-11-15 22:54:12');
INSERT INTO `acl_permission` VALUES ('1196301740985311234', '1195268616021139457', '分配角色', 2, 'user.assgin', 'user/role/:id', '/acl/user/roleForm', NULL, 1, 0, '2019-11-18 13:38:56', '2019-11-18 13:38:56');

-- ----------------------------
-- Table structure for acl_post
-- ----------------------------
DROP TABLE IF EXISTS `acl_post`;
CREATE TABLE `acl_post`  (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '岗位名称',
  `post_sort` int(4) NULL DEFAULT NULL COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '岗位信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of acl_post
-- ----------------------------
INSERT INTO `acl_post` VALUES (6, '222', '222', 222, NULL, '', '2022-03-28 21:31:19', '', NULL, NULL);
INSERT INTO `acl_post` VALUES (7, '3', '3', 3, NULL, '', '2022-03-28 21:32:24', '', NULL, NULL);
INSERT INTO `acl_post` VALUES (8, 'zong', '总经理', 1, NULL, '', '2022-03-28 21:38:03', '', NULL, NULL);
INSERT INTO `acl_post` VALUES (9, 'dong', '董事长', 2, NULL, '', '2022-03-28 21:41:30', '', NULL, NULL);

-- ----------------------------
-- Table structure for acl_role
-- ----------------------------
DROP TABLE IF EXISTS `acl_role`;
CREATE TABLE `acl_role`  (
  `id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色id',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编码',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of acl_role
-- ----------------------------
INSERT INTO `acl_role` VALUES ('1', '普通管理员', '1', '3', 0, '2019-11-11 13:09:32', '2019-11-18 10:27:18');
INSERT INTO `acl_role` VALUES ('1193757683205607426', '课程管理员', '1', '2', 0, '2019-11-11 13:09:45', '2019-11-18 10:25:44');
INSERT INTO `acl_role` VALUES ('1196300996034977794', 'test', '1', '1', 0, '2019-11-18 13:35:58', '2019-11-18 13:35:58');

-- ----------------------------
-- Table structure for acl_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `acl_role_permission`;
CREATE TABLE `acl_role_permission`  (
  `id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `role_id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `permission_id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_id`(`role_id`) USING BTREE,
  INDEX `idx_permission_id`(`permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of acl_role_permission
-- ----------------------------
INSERT INTO `acl_role_permission` VALUES ('1196301979754455041', '1', '1', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301979792203778', '1', '1195268474480156673', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301979821563906', '1', '1195268616021139457', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301979842535426', '1', '1195269143060602882', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301979855118338', '1', '1195269295926206466', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301979880284161', '1', '1195269473479483394', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301979913838593', '1', '1195269547269873666', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301979926421506', '1', '1196301740985311234', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301979951587330', '1', '1195268788138598401', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980014501889', '1', '1195269821262782465', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980035473410', '1', '1195269903542444034', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980052250626', '1', '1195270037005197313', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980077416450', '1', '1195270442602782721', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980094193665', '1', '1195270621548568578', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980119359489', '1', '1195268893830864898', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980136136706', '1', '1195270744097742849', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980249382913', '1', '1195270810560684034', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980270354434', '1', '1195270862100291586', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980287131649', '1', '1195270887933009922', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980303908866', '1', '1195349439240048642', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980320686082', '1', '1195349699995734017', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980345851905', '1', '1195349979797753857', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980362629121', '1', '1195350117270261762', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980383600641', '1', '1195350188359520258', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980408766465', '1', '1195349810561781761', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980421349378', '1', '1195349876252971010', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980438126593', '1', '1195350299365969922', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980450709506', '1', '1195350397751758850', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980501041153', '1', '1195350612172967938', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980517818370', '1', '1195350500512206850', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980538789889', '1', '1195350687590748161', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980622675970', '1', '1195350831744782337', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980639453186', '1', '1195350919074385921', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980660424705', '1', '1195351159672246274', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980677201922', '1', '1195351326706208770', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980698173441', '1', '1195351566221938690', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980714950658', '1', '1195351020463296513', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980723339266', '1', '1195351862889254913', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980744310786', '1', '1195351968841568257', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980761088001', '1', '1195352215768633346', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980777865217', '1', '1195352054917074946', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980794642434', '1', '1195352127734386690', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980811419650', '1', '1195352547621965825', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980828196865', '1', '1195353513549205505', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980844974082', '1', '1195352856645701633', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980861751298', '1', '1195352909401657346', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980886917122', '1', '1195353051395624961', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980928860162', '1', '1195353672110673921', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980954025986', '1', '1195354076890370050', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980970803201', '1', '1195354153482555393', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196301980987580418', '1', '1195354315093282817', 1, '2019-11-18 13:39:53', '2019-11-18 13:39:53');
INSERT INTO `acl_role_permission` VALUES ('1196305293070077953', '1', '1', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293099438081', '1', '1195268474480156673', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293120409602', '1', '1195268616021139457', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293153964034', '1', '1195269143060602882', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293183324162', '1', '1195269295926206466', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293212684290', '1', '1195269473479483394', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293237850114', '1', '1195269547269873666', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293271404545', '1', '1196301740985311234', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293485314049', '1', '1195268788138598401', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293506285569', '1', '1195269821262782465', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293527257089', '1', '1195269903542444034', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293552422914', '1', '1195270037005197313', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293565005825', '1', '1195270442602782721', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293594365954', '1', '1195270621548568578', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293611143169', '1', '1195268893830864898', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293627920385', '1', '1195270744097742849', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293657280513', '1', '1195349439240048642', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293674057729', '1', '1195349699995734017', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293690834946', '1', '1195349979797753857', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293716000770', '1', '1195350117270261762', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293736972290', '1', '1195350188359520258', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293749555202', '1', '1195349810561781761', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293766332417', '1', '1195349876252971010', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293795692546', '1', '1195350299365969922', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293812469762', '1', '1195350397751758850', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293837635586', '1', '1195350612172967938', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293858607106', '1', '1195350500512206850', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293875384322', '1', '1195350687590748161', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293892161538', '1', '1195350831744782337', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293950881794', '1', '1195350919074385921', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305293976047617', '1', '1195351159672246274', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294127042561', '1', '1195351326706208770', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294156402690', '1', '1195351566221938690', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294177374209', '1', '1195351862889254913', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294194151425', '1', '1195351968841568257', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294223511554', '1', '1195352215768633346', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294240288770', '1', '1195352054917074946', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294248677377', '1', '1195352127734386690', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294248677378', '1', '1195352547621965825', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294319980546', '1', '1195353513549205505', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294319980547', '1', '1195352856645701633', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294319980548', '1', '1195352909401657346', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294378700802', '1', '1195353051395624961', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294378700803', '1', '1195353672110673921', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294458392577', '1', '1195354076890370050', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294483558402', '1', '1195354153482555393', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305294500335618', '1', '1195354315093282817', 1, '2019-11-18 13:53:03', '2019-11-18 13:53:03');
INSERT INTO `acl_role_permission` VALUES ('1196305566656139266', '1', '1', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305566689693698', '1', '1195268474480156673', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305566706470913', '1', '1195268616021139457', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305566740025346', '1', '1195269143060602882', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305566756802561', '1', '1195269295926206466', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305566781968385', '1', '1195269473479483394', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305566811328514', '1', '1195269547269873666', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305566828105730', '1', '1196301740985311234', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305566853271554', '1', '1195268788138598401', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305566878437378', '1', '1195269821262782465', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305566895214593', '1', '1195269903542444034', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305566916186113', '1', '1195270037005197313', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305566949740546', '1', '1195270442602782721', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305566966517761', '1', '1195270621548568578', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305566991683585', '1', '1195268893830864898', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567012655106', '1', '1195270744097742849', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567029432322', '1', '1195270810560684034', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567042015233', '1', '1195270862100291586', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567100735490', '1', '1195270887933009922', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567117512705', '1', '1195349439240048642', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567142678530', '1', '1195349699995734017', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567155261442', '1', '1195349979797753857', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567172038658', '1', '1195350117270261762', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567188815873', '1', '1195350188359520258', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567218176001', '1', '1195349810561781761', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567234953217', '1', '1195349876252971010', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567251730434', '1', '1195350299365969922', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567272701954', '1', '1195350397751758850', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567289479170', '1', '1195350612172967938', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567310450690', '1', '1195350500512206850', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567327227905', '1', '1195350687590748161', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567448862722', '1', '1195350831744782337', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567478222850', '1', '1195350919074385921', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567495000065', '1', '1195351159672246274', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567520165889', '1', '1195351326706208770', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567541137409', '1', '1195351566221938690', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567570497538', '1', '1195351862889254913', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567587274754', '1', '1195351968841568257', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567604051970', '1', '1195352215768633346', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567633412098', '1', '1195352054917074946', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567683743745', '1', '1195352127734386690', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567721492481', '1', '1195352547621965825', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567742464002', '1', '1195353513549205505', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567771824129', '1', '1195352856645701633', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567792795650', '1', '1195352909401657346', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567809572866', '1', '1195353051395624961', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567843127298', '1', '1195353672110673921', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567868293122', '1', '1195354076890370050', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567885070338', '1', '1195354153482555393', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196305567910236162', '1', '1195354315093282817', 1, '2019-11-18 13:54:08', '2019-11-18 13:54:08');
INSERT INTO `acl_role_permission` VALUES ('1196312702601695234', '1', '1', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702652026881', '1', '1195268474480156673', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702668804098', '1', '1195268616021139457', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702698164226', '1', '1195269143060602882', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702723330049', '1', '1195269295926206466', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702744301569', '1', '1195269473479483394', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702765273089', '1', '1195269547269873666', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702790438913', '1', '1196301740985311234', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702945628161', '1', '1195268788138598401', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312702970793985', '1', '1195269821262782465', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312703000154114', '1', '1195269903542444034', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312703025319938', '1', '1195270037005197313', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312703046291458', '1', '1195270442602782721', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312703063068673', '1', '1195270621548568578', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312703084040193', '1', '1195268893830864898', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312703113400321', '1', '1195270744097742849', 0, '2019-11-18 14:22:29', '2019-11-18 14:22:29');
INSERT INTO `acl_role_permission` VALUES ('1196312703134371842', '1', '1195270810560684034', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703159537665', '1', '1195270862100291586', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703184703490', '1', '1195270887933009922', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703209869313', '1', '1195349439240048642', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703230840834', '1', '1195349699995734017', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703251812354', '1', '1195349979797753857', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703272783873', '1', '1195350117270261762', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703293755394', '1', '1195350188359520258', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703327309826', '1', '1195349810561781761', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703348281345', '1', '1195349876252971010', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703365058561', '1', '1195350299365969922', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703386030082', '1', '1195350397751758850', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703440556034', '1', '1195350612172967938', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703486693378', '1', '1195350500512206850', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703511859202', '1', '1195350687590748161', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703654465537', '1', '1195350831744782337', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703683825665', '1', '1195350919074385921', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703700602882', '1', '1195351159672246274', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703717380098', '1', '1195351326706208770', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703738351618', '1', '1195351566221938690', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703759323137', '1', '1195351020463296513', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703776100353', '1', '1195351862889254913', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703792877570', '1', '1195351968841568257', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703830626305', '1', '1195352215768633346', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703843209217', '1', '1195352054917074946', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703868375041', '1', '1195352127734386690', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703889346561', '1', '1195352547621965825', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703901929473', '1', '1195353513549205505', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703918706689', '1', '1195352856645701633', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703952261121', '1', '1195352909401657346', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703973232642', '1', '1195353051395624961', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312703990009857', '1', '1195353672110673921', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312704048730114', '1', '1195354076890370050', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312704069701633', '1', '1195354153482555393', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');
INSERT INTO `acl_role_permission` VALUES ('1196312704094867457', '1', '1195354315093282817', 0, '2019-11-18 14:22:30', '2019-11-18 14:22:30');

-- ----------------------------
-- Table structure for acl_user
-- ----------------------------
DROP TABLE IF EXISTS `acl_user`;
CREATE TABLE `acl_user`  (
  `id` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会员id',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '微信openid',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `nick_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `token` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户签名',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of acl_user
-- ----------------------------
INSERT INTO `acl_user` VALUES ('1', 'admin', '$2a$10$tZaRDfnRpFye1t5Ih2atlOpcK5kJPxNhX7TMQi625kTm.GbNRRVvS', 'admin', '', NULL, 0, '2019-11-01 10:39:47', '2019-11-01 10:39:47');
INSERT INTO `acl_user` VALUES ('1507549298823933954', '211', '$2a$10$B/lGLevMnqxTj6eTsLNki.D/xACsPQ2QmU02uRMYlaXrhqg4JFFZi', '2111', NULL, NULL, 0, '2022-03-26 10:45:36', '2022-03-26 10:45:36');

-- ----------------------------
-- Table structure for acl_user_role
-- ----------------------------
DROP TABLE IF EXISTS `acl_user_role`;
CREATE TABLE `acl_user_role`  (
  `id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '主键id',
  `role_id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '角色id',
  `user_id` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '用户id',
  `is_deleted` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除 1（true）已删除， 0（false）未删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_id`(`role_id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of acl_user_role
-- ----------------------------
INSERT INTO `acl_user_role` VALUES ('1', '1', '2', 0, '2019-11-11 13:09:53', '2019-11-11 13:09:53');

SET FOREIGN_KEY_CHECKS = 1;
