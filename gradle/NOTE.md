# Gradle 学习笔记

##### Gradle文件说明
1. build.gradle类似Maven中的pom.xml文件


##### 构建脚本概要
+ Gradle构建脚本中最重要的两个概念是Project和Task，任何一个Gradle构建都由一个或者多个Project组成。
每个Project包括许多的构建部分，可以是jar包，也可以是web应用，也可以是多个jar的整合，也可以部署应用和搭建环境。
每个Project由一个或多个Task组成，每个Task表示在构建执行过程中的一个原子操作，例如：编译、打包、发布等。
    
+ Project对象介绍：
    
      一个Project代表一个正在构建的组件（jar/war文件）。
      当构建开始时，Gradle会基于build.gradle实例化一个org.gradle.api.Project对象，
      并通过project变量来隐式调用其成员：
        
     |成员|类型|默认值|
     |:---:|:---:|:---|
     |project|Project|project实例（其实就是this）|
     |group|Object|项目分组|
     |name|String|项目名称|
     |version|Object|项目版本|
     |path|String|项目路径，路径是项目的全限定名|
     |description|String|项目描述|
     |projectDir|File|项目脚本构建文件路径|
     |buildDir|File|项目构建目录，默认：projectDir/build|
     |plugins|-|用来引入插件|
     |apply plugin|-|用来引入插件|
     |dependencies|-|依赖配置|
     |repositories|-|仓库配置|
     |task|-|任务书写|
     |ext|-|-|
     |properties|-|属性配置|

+ Task任务介绍：

      每个任务在构建执行过程中会被封装成org.gradle.api.Task对象。
      主要包括任务的动作和依赖。
      任务动作定义了一个原子操作，可以定义依赖其他任务、动作顺序和执行条件。
      
      dependsOn：依赖其他任务
      doFirst：任务执行之前执行的动作
      doLast：任务执行之后执行的动作
      
##### Gradle项目构建生命周期
1. 初始化阶段

       通过settings.gradle判断有哪些项目需要初始化，
       加载所有需要初始化项目的build.gradle文件，并为每个项目创建project对象

2. 配置阶段

       执行各项目下的build.gradle脚本，完成project配置，
       并构造task任务的依赖关系图，以便在执行阶段按照依赖关系执行task中的配置代码

3. 执行阶段

       按照配置阶段的task依赖关系图，按顺序执行各个任务中的动作代码
       
##### Gradle依赖管理
1. 工作坐标（jar包标志）：

       group：指定jar包所在的分组
       name：指定jar包的名称
       version：指定jar包的版本
       
2. 仓库（jar包的存放位置）：
   1. 公共仓库（中央仓库）：mavenCentral/jcenter，Gradle没有自己的中央仓库，但可以使用maven的中央参考
   2. 私有仓库：mavenLocal，配置本地maven仓库
   3. 私服仓库：maven，配置公司的私服仓库
   4. 文件仓库：很少使用
   
3. 依赖配置
   1. compile：编译、运行和测试存在，与Maven的\<scope>compile\</scope>一致
   2. runtime：运行和测试存在，与Maven的\<scope>runtime\</scope>一致
   3. providedCompile：编译存在，与Maven的\<scope>provided\</scope>一致
   4. providedRuntime：
   5. testCompile：编译和测试存在，与Maven的\<scope>test\</scope>一致
   6. testRuntime：测试存在

4. 依赖冲突解决：使用版本最高的