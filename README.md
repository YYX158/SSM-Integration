# SSM整合项目
本项目主要是SSM整合项目，利用tomcat作为服务器来启动项目。
用Spring来整合SpringMVC和Mybatis，Spring主要用来管理控制层，SpringMVC用来处理控制层层，Mybtis则充当持久层组件，服务器的话采用Tomcat，需要注意的是需要使用10以下的tomcat服务器，否则将会报错。Spring主要处理除了控制层以外的bean容器，所以在配置的时候需要用context:exclude-filter />标签将控制层给抛开。
在整个项目中数据库的话采用的是Mysql服务器，因此需要引入mysql的核心依赖以及jdbc依赖，从而引入数据库。
