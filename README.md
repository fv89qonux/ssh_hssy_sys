## 本项目实现的最终作用是基于SSH婚纱摄影工作室网站平台
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 会员信息管理
 - 婚纱信息管理
 - 婚纱款式管理
 - 租赁信息管理
 - 管理员登陆
 - 订单信息管理
### 第2个角色为用户角色，实现了如下功能：
 - 按照款式查看
 - 提交订单
 - 查看婚纱
 - 查看婚纱详情
 - 用户登录注册
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_hssy_sys

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [t_admin](#t_admin) | 管理员表 |
| [t_catelog](#t_catelog) |  |
| [t_goods](#t_goods) |  |
| [t_order](#t_order) |  |
| [t_orderitem](#t_orderitem) |  |
| [t_pinglun](#t_pinglun) |  |
| [t_user](#t_user) | 用户表 |
| [t_zulin](#t_zulin) |  |

**表名：** <a id="t_admin">t_admin</a>

**说明：** 管理员表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | UserId |   int   | 10 |   0    |    N     |  Y   |       | 用户ID  |
|  2   | username |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  3   | userPw |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |

**表名：** <a id="t_catelog">t_catelog</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | catelog_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | catelog_name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | catelog_del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_goods">t_goods</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | goods_id |   int   | 10 |   0    |    N     |  Y   |       | 商品ID  |
|  2   | catelog_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | goods_name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | goods_jieshao |   varchar   | 4000 |   0    |    Y     |  N   |   NULL    |   |
|  5   | goods_pic |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 商品图片  |
|  6   | goods_shichangjia |   int   | 10 |   0    |    Y     |  N   |   NULL    | 市场价  |
|  7   | goods_tejia |   int   | 10 |   0    |    Y     |  N   |   NULL    | 特价  |
|  8   | kucun |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  9   | fabushi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  10   | goods_Del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_order">t_order</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | order_id |   int   | 10 |   0    |    N     |  Y   |       | 订单ID  |
|  2   | order_bianhao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | order_date |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | order_zhuangtai |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | order_songhuodizhi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | order_fukuangfangshi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | order_jine |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  8   | order_user_id |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_orderitem">t_orderitem</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | orderItem_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | order_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 订单ID  |
|  3   | goods_id |   int   | 10 |   0    |    Y     |  N   |   NULL    | 商品ID  |
|  4   | goods_quantity |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_pinglun">t_pinglun</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |   0    |   |
|  2   | neirong |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 内容  |
|  3   | shijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 创建时间  |
|  4   | goodsId |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  5   | userid |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |

**表名：** <a id="t_user">t_user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | user_id |   int   | 10 |   0    |    N     |  Y   |       | 用户ID  |
|  2   | user_name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  3   | user_pw |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户密码  |
|  4   | user_realname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户真实名字  |
|  5   | user_sex |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户性别  |
|  6   | user_age |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户年龄  |
|  7   | user_address |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户地址  |
|  8   | user_tel |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户电话  |
|  9   | user_email |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户邮箱  |
|  10   | user_del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_zulin">t_zulin</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | ID  |
|  2   | goodsId |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | kehuming |   varchar   | 66 |   0    |    Y     |  N   |   NULL    |   |
|  4   | shenfenzheng |   varchar   | 77 |   0    |    Y     |  N   |   NULL    |   |
|  5   | kaishishijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | yajin |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  7   | beizhu |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |
|  8   | shifouhuan |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  9   | jieshushijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  10   | feiyong |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |

