# JavaSimpleFrame
模仿SpringBoot写的一个JavaEE版的注解小框架

jdk版本号 jdk1.8(因为用到了新特性)

此框架简单,轻便,很适合用来理解自动创建对象,自动注入对象的思想

用到的模式：观察者模式 单例模式

Java技术：反射技术

使用方式：
下载后使用Eclipse工具中，直接运行RunApplication.java即可看到效果

目前只用到了三个注解
@ComponentScan: 用来通知框架需要扫描哪个包下的文件
@BeanObj: 用来告诉框架需要装载这个Bean
@Autoload: 用来自动注入


