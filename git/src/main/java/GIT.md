# GIT 学习笔记

#### 基础配置
```
邮箱：git config --global user.email "your@email.address"
名字：git config --global user.name "your name" 
记住密码：git config --global credential.store
命令别名设置：git config --global alias.<new_cmd> git_cmd
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
|branch|git branch [\<options\>]|创建一个分支，与-d参数结合可以删除分支，-D强制删除分支（慎用），与--merged和--no-merged配合可以查看哪些分支被合并或者哪些分支未被合并|
|checkout|git checkout [\<options\>] \<branch\>|切换分支，与-b一起使用可以创建一个新分支，并切换到该分支下|
|merge|git merge [\<options\>] [\<commit\>...]|合并分支|
|stash|git stash [cmd] [\<options\>]|cmd不写，则：创建一个stash，cmd为list，则：列出所有stash，cmd为drop，则：删除stash，cmd为pop（删除）或apply（不删除），则：恢复stash|
|tag|git tag [-a &#124; -s &#124; -u \<key-id\>] [-f] [-m \<msg\> &#124; -F \<file\>]|打标签|
|archive|git archive branch_name|归档分支，--prefix归档文件前缀，--format压缩格式，-o压缩文件名称|


#### Git版本冲突
+ 为什么会冲突？
  ```
  假设有三个分支：master，subA，subB
  如果分支subA和subB都修改了同一个文件，那么在mastermerge时就会产生冲突
  因为此时git不知道该选择使用哪个文件的内容
  ```

+ 如何解决冲突？
  ```
  在要merge的分支上（master要merge subA和subB，那么merge分支就是master）
  修改冲突的文件，然后重新提交即可
  ```

#### [下一集](https://www.bilibili.com/video/av56582999?p=22)
