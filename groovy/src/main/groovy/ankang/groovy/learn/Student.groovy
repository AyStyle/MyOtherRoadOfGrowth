package ankang.groovy.learn

/**
 * Groovy声明类，没有权限修饰符，默认使用public
 */
class Student {

    /*
     * 1. 可以省略分号
     * 2. 无访问权限时可以自动生成getter和setter
     */
    private String username;
    private String email
    int age

    /**
     * 方法返回值可以省略return关键字
     * @return
     */
    String getUsername() {
        username
    }

    void setUsername(String username) {
        this.username = username
    }
}
