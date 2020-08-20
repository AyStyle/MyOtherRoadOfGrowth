# GIT 学习笔记

#### 基础配置
```
邮箱：git config --global user.email "your@email.address"
名字：git config --global user.name "your name" 
记住密码：git config --global credential.store
```

#### Git目录结构
> .git
>> config
>> description
>> HEAD
>> hooks/
>> info/
>> objects/
>> refs/

#### Git忽略文件 .gitignore
```
此文件用来配置Git不需要关注的文件
格式：xx.xx或/xx/xx.xx
xx.xx配置的文件是在所有目录下都生效的，包括递归子目录
/xx/xx.xx配置的文件是在该目录下生效的，不包括递归子目录，如果需要递归子目录，则：配置为/xx/**/xx.xx
```

#### Git命令：
|命令|例子|说明|
|:---:|---|---|
|config|git config [\<options\>]|配置git属性：local为仓库级别属性优先使用，global为用户级别属性，system为系统界别属性最后使用|
|init|git init [\<dir\>]|初始化Git仓库，如果没有path，则：在当前目录初始化|
|clone|git clone [\<options\>] [--] \<repo\> [\<dir\>]|Clone一个Git仓库，如果没有dir，则：在当前目录下创建一个目录并克隆项目|
|add|git add [\<options\>] [--] \<pathspec\>|添加需要传入到仓库的文件（标记文件，但不传入到仓库中），不写文件名，则：目录下的全部文件都需要添加到仓库|
|commit|git commit [\<options\>] [--] \<pathspec\>|将需要传入到仓库的文件传入到仓库（将标记的文件传入到仓库中），不写文件名，则：目录下全部需要添加到仓库的文件被传入到仓库。-m 指定一条提交信息，--amend 修改最新一次提交信息|
|status|git status [\<options\>] [--] \<pathspec\>|查看仓库的状态，显示文件有没有传入到仓库或需要传入到仓库|
|rm|git rm [\<options\>] [--] \<file\>|删除git仓库提交的文件，与--cached命令结合使用可以不删除本地文件|
|mv|git mv [\<options\>] \<source\>... \<destination\>|修改git仓库文件的名字
|log|git log [\<options\>] [\<revision-range\>] [[--] \<path\>...]|查看git提交日志，-p 显示详细信息，-n 显示最近n条log，--name-only 只显示文件名，--name-status 显示文件的状态（修改、添加、删除）|