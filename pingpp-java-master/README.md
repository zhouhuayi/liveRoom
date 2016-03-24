ping++ java SDK
============

### 简介
 1. docs 目录下为 Ping++ Java SDK 的使用文档。
 2. example 目录下面为一个 Eclipse IDE 的示例工程。
 3. libs 为 Ping++ Java SDK 的 jar 包和 Ping++ Java SDK 所依赖的Gson 包。
 4. src 为 Ping++ Java SDK 的源代码，可以关联到 pingpp-java-x.x.x.jar 文件。或者直接把源代码引入到工程之中。


### 版本要求

Java SDK 要求 JDK 版本 1.6 及以上
  
### 安装

##### 手动安装
将libs/下面的jar包导入工程

##### maven 安装 

maven 远程仓库

    <repository>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
        <id>central</id>
        <name>bintray</name>
        <url>http://jcenter.bintray.com</url>
    </repository>

安装 Ping++ SDK

    <dependency>
        <groupId>Pingplusplus</groupId>
        <artifactId>pingpp-java</artifactId>
        <version>2.1.1</version>
        <type>jar</type>
    </dependency>

##### gradle 安装

gradle 远程仓库

    repositories {
        maven {
            url  "http://jcenter.bintray.com" 
        }
    }

安装 Ping++ SDK

    compile 'Pingplusplus:pingpp-java:2.1.1'

### 初始化

    Pingpp.apiKey = "YOUR-KEY"; 
    
#### 使用示例
    
    参考 example/SimpleExample 示例项目工程。改工程提供了付款、退款、微信公共号付款相关的 demo。
