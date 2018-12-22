# Design
基于SpringBoot的毕业设计选题系统

## 接口设计

### 分页获取教师信息
接口名：listTeachersByCurr  
请求参数：  

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| page | Integer | 页码数 |
| num | Integer | 每页数量 |

返回参数：

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| isSuccessful | Boolean | 是否成功 |
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
| isSuccessful | Boolean | 是否成功 |
| data | Entity | 教师信息 |

### 分页获取学生信息
接口名：listStudentsByCurr  
请求参数：  

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| page | Integer | 页码数 |
| num | Integer | 每页数量 |

返回参数：

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| isSuccessful | Boolean | 是否成功 |
| total | Integer | 数据总数 |
| count | Integer | 当前页数据数 |
| list | List | 数据信息 |

### 根据学生ID获取学生信息
接口名：getStudentById  
请求参数：  

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| id | Integer | 学生ID |

返回参数：

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| isSuccessful | Boolean | 是否成功 |
| data | Entity | 学生信息 |

### 根据教师ID和登录密码修改教师登录密码
接口名：updatePasswordById  
请求参数：  

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| id | Integer | 教师ID |
| password | String | 教师登录密码 |
| newPassword | String | 新登录密码 |

返回参数：

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| isSuccessful | Boolean | 是否成功 |
| message | String | 消息 |
### 根据学生ID和登录密码修改学生登录密码
接口名：updatePasswordById  
请求参数：  

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| id | Integer | 学生ID |
| password | String | 学生登录密码 |
| newPassword | String | 新登录密码 |

返回参数：

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| isSuccessful | Boolean | 是否成功 |
| message | String | 消息 |
### 根据ID修改教师院系和专长

### 根据ID修改学生院系和班级

### 分页获取所有院系信息
接口名：listCollegesByCurr  
请求参数：  

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| page | Integer | 页码数 |
| num | Integer | 每页数量 |

返回参数：

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| isSuccessful | Boolean | 是否成功 |
| total | Integer | 数据总数 |
| count | Integer | 当前页数据数 |
| list | List | 数据信息 |
### 分页获取所有班级信息
接口名：listClassesByCurr  
请求参数：  

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| page | Integer | 页码数 |
| num | Integer | 每页数量 |

返回参数：

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| isSuccessful | Boolean | 是否成功 |
| total | Integer | 数据总数 |
| count | Integer | 当前页数据数 |
| list | List | 数据信息 |
### 分页获取所有老师专长信息
接口名：listExpertisesByCurr  
请求参数：  

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| page | Integer | 页码数 |
| num | Integer | 每页数量 |

返回参数：

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| isSuccessful | Boolean | 是否成功 |
| total | Integer | 数据总数 |
| count | Integer | 当前页数据数 |
| list | List | 数据信息 |
### 根据毕业设计课题ID修改课题审核状态
接口名：updateStatusById  
请求参数：  

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| id | Integer | 课题ID |
| roleType | Integer | 角色类型 |

返回参数：

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| isSuccessful | Boolean | 是否成功 |
| message | String | 消息 |
### 设置学生的毕业设计课题
接口名：setDesigntopicForStudent
请求参数：  

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| sId | Integer |学生ID |
| dId | Integer |课题ID |
| roleType | Integer | 角色类型 |

返回参数：

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| isSuccessful | Boolean | 是否成功 |
| message | String | 消息 |
### 设置课题的指导老师
接口名：setGuideTeacherForDesigntopic
请求参数：  

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| dId | Integer | 课题ID |
| tId | Integer | 教师ID |
| roleType | Integer | 角色类型 |

返回参数：

| 参数名 | 类型 | 说明 | 备注 |
|:---- |:---- |:---- |:---- |
| isSuccessful | Boolean | 是否成功 |
| message | String | 消息 |