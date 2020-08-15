package ankang.groovy.learn

println("------------------------ 基本语法定义 --------------------------")

// 变量声明
def name = "ankang"

// 特有语法，可以省略def
age = 18

// 调用带参数的方法时可以省略括号
println(name + " " + age + " 有括号")
println name + " " + age + " 无括号"

// 断言 assert
//assert age == 19

println("------------------------ 字符串的定义 --------------------------")
str1 = '单引号字符串：不可以引用变量'
str2 = "双引号字符串，可以引用变量：${name}"
str3 = '''三个单引号字符串
可以实现换行，不可以引用变量
'''
str4 = """三个双引号字符串，
可以实现换行，可以引用变量：${name}
"""

println(str1)
println(str2)
println(str3)
println(str4)

println(null.equals("ankang"))
println("ankang".equals(null))

println("------------------------ 集合定义 --------------------------")
// list集合定义：使用[]来声明list集合
list = [1, 2, 3, "a", "b", "c"]
println(list)

// 给list添加数据
list.add('4') // Java语法
list << 5 // Groovy特有语法
println(list)
println(list.getClass())

// map集合定义：使用[key:value]来声明map集合
map = ['a': "A", 'b': "B"]
println(map)

// 给map赋值
map['d'] = 'D'
map.put('e', 'E') // Java语法
map << ['f': 'F'] // Groovy特有语法
println(map)
println(map.getClass())

println("------------------------ 闭包定义 --------------------------")
closureNoParam = {
    println("不带参数的闭包")
}

closureWithParam = {
    value -> println("带参数的闭包：${value}")
}

// 直接使用闭包
closureNoParam()
closureWithParam("ankang")

// 使用闭包特有的方法调用闭包
closureNoParam.call()
closureWithParam.call("ankangkang")

// 定义一个方法，接受不带参数的闭包
def methodNoParamClosure(Closure closure) {
    closure()
}

// 定义一个方法，接受带参数的闭包
// 定义方法时，可以只写变量名不写变量类型
def methodWithParamClosure(closure, param) {
    closure(param)
}

methodNoParamClosure(closureNoParam)
methodWithParamClosure(closureWithParam, "ak")

// 使用方法调用匿名闭包对象
methodNoParamClosure {
    println("匿名闭包对象")
}



