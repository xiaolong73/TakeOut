# TakeOut System
This is a takeout project leaded by lina and done by lina, xiaolong, zhengxia, guoli, zhangchen, yangyuqing.
This project mainly written by java and html. Also, we used tomcat(8.5.8) and linux(Ubuntu16.04) to run this project.

### Here are some basic information about this project.
#### 1. The system strcture
[![2xv639.png](https://z3.ax1x.com/2021/06/17/2xv639.png)](https://imgtu.com/i/2xv639)
#### 2. The database
```sql
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `goods`;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `rider`;
DROP TABLE IF EXISTS `manage`;
DROP TABLE IF EXISTS `shop`;
DROP TABLE IF EXISTS `Entity1`;
DROP TABLE IF EXISTS `user`;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `goods` (
    `goods_ID` VARCHAR(32) NOT NULL,
    `goods_name` CHAR(20) NOT NULL,
    `goods_inventory` INTEGER(10) NOT NULL,
    `goods_price` DOUBLE(10) NOT NULL,
    `goods_status` INTEGER(2) NOT NULL,
    `good_type` INTEGER(10) NOT NULL,
    PRIMARY KEY (`goods_ID`)
);

CREATE TABLE `order` (
    `orede_ID` VARCHAR(32) NOT NULL,
    `user_ID` VARCHAR(32) NOT NULL,
    `user_name` VARCHAR(10) NOT NULL,
    `order_time` TIME NOT NULL,
    `order_address` CHAR(50) NOT NULL,
    `order_totalAmount` DOUBLE(20) NOT NULL,
    `order_status` INTEGER(2) NOT NULL,
    `goods_name` CHAR(20) NOT NULL,
    `goods_quantity` INTEGER(10) NOT NULL,
    `goods_price` DOUBLE(20) NOT NULL,
    `goods_evaluation` TEXT(50) NOT NULL,
    `rider_evaluation` TEXT(50) NOT NULL,
    PRIMARY KEY (`orede_ID`)
);

CREATE TABLE `rider` (
    `rider_ID` VARCHAR(32) NOT NULL,
    `rider_name` VARCHAR(10) NOT NULL,
    `rider_password` VARCHAR(32) NOT NULL,
    `rider_phone` INTEGER(11) NOT NULL,
    `rider_address` CHAR(50) NOT NULL,
    `orede_ID` VARCHAR(32) NOT NULL,
    `take_status` INTEGER(2) NOT NULL,
    PRIMARY KEY (`rider_ID`)
);

CREATE TABLE `manage` (
    `manage_ID` VARCHAR(32) NOT NULL,
    `manage_password` VARCHAR(6) NOT NULL,
    PRIMARY KEY (`manage_ID`)
);

CREATE TABLE `shop` (
    `shop_ID` VARCHAR(32) NOT NULL,
    `shop_name` VARCHAR(10) NOT NULL,
    `shop_tel` INTEGER(11) NOT NULL,
    `shop_address` CHAR(50) NOT NULL,
    PRIMARY KEY (`shop_ID`)
);

CREATE TABLE `Entity1` (
);

CREATE TABLE `user` (
    `user_ID` VARCHAR(32) NOT NULL,
    `user_Name` VARCHAR(10) NOT NULL,
    `user_passWord` INTEGER(32) NOT NULL,
    `user_tel` INTEGRr(20) NOT NULL,
    `user_Address` CHAR(10) NOT NULL,
    `user_time` CHAR(10) NOT NULL,
    PRIMARY KEY (`user_ID`)
);

```
