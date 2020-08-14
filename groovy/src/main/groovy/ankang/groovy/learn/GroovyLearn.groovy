package ankang.groovy.learn

// 打印
println("Hello World")
// 打印，方法不写括号
println "Hello World"
// 打印，兼容Java代码
System.out.println("Hello World")

println("--------------------------------------------------")
// 测试Student类
Student student = new Student()

// 调用getter和setter
student.setUsername("ankang")
println(student.getUsername())

// 使用点的方式操作字段
student.email = "ankang@demo.com"
println(student.email)

// 调用无权限修饰符的getter和setter
student.setAge(18)
println(student.getAge())

println("--------------------------------------------------")
// 调用默认带有的具名构造器（具名构造器参数个数和参数位置都不限制）
Student ankang = new Student(username: "ankang", age: 18, email: "ankang@demo.com")
println(ankang.username)
println(ankang.email)
println(ankang.age)

ankang.username = 16
println(ankang.username)