### 完成度：
* 功能都完成了，well down

__Details:__

- \- Group对象应该包含name属性

### 测试：
* 有Controller层测试，覆盖了Happy Path

__Details:__



### 知识点：
* 需要了解Restful实践
* 需要了解下三层架构
* 了解下lombok的使用

__Details:__

- \- 推荐使用构造器注入
- \- 违反Restful实践, url不合理
- \- 违反Restful实践, Post请求成功后应该返回201
- \- 应该使用Repository层保存数据

### 工程实践：
* 注意单一职责，group和student应该有单独的Controller和Service

__Details:__

- \- 未使用的import语句
- \- 计算id的方式不够健壮，可以使用字段保存最大id
- \- 长方法，建议抽子方法来提高可读性
- \- 为什么不直接使用groups来分组？
- \- Magic Number
- \- 注意代码风格，需要适当的添加空格

### 综合：


__Details:__



