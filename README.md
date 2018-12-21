# Design
基于SpringBoot的毕业设计选题系统

## 接口设计

### 分页获取教师信息
接口名：listTeacherByCurr  
请求参数：  

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| page | Integer | 页码数 |
| num | Integer | 每页数量 |

返回参数：

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| is | Boolean | 是否成功 |
| total | Integer | 数据总数 |
| count | Integer | 当前页数据数 |
| list | List | 数据信息 |

### 根据ID获取教师信息
接口名：getTeacherById  
请求参数：  

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| id | Integer | 教师ID |

返回参数：

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| is | Boolean | 是否成功 |
| data | Entity | 教师信息 |