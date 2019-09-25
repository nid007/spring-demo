# Readme

这个项目是一个mybatis mysql 数据库的单元测试示例.

使用前请修改 application.yml里的数据库相关配置。数据库表依赖如下：

```
CREATE TABLE `student` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

本示例同时集成了jacoco, 可以通过以下命令生成jacoco报表
```
mvn clean jacoco:prepare-agent install jacoco:report
```
