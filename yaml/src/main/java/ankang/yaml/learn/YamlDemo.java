package ankang.yaml.learn;

import com.amihaiemil.eoyaml.Yaml;
import com.amihaiemil.eoyaml.YamlInput;
import com.amihaiemil.eoyaml.YamlMapping;
import com.amihaiemil.eoyaml.YamlSequence;

import java.io.IOException;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-08-27
 */
public class YamlDemo {

    public static void main(String[] args) throws IOException {
        // 读取yaml文件
        final YamlInput yaml = Yaml.createYamlInput(YamlDemo.class.getClassLoader().getResourceAsStream("yaml-learn.yml"));
        final YamlMapping mapping = yaml.readYamlMapping();

        System.out.println(mapping.string("name"));
        System.out.println(mapping.string("age"));
        System.out.println(mapping.string("money"));
        // 获取日期类型变量
        System.out.println(mapping.dateTime("birthday"));

        // 获取list类型变量
        final YamlSequence interests = mapping.yamlSequence("interests");
        for (int i = 0 ; i < interests.size() ; i++) {
            System.out.println("interest: " + interests.string(i));
        }

        final YamlSequence friends = mapping.yamlSequence("friends");
        for (int i = 0 ; i < friends.size() ; i++) {
            final YamlMapping friend = friends.yamlMapping(i);
            System.out.println(String.format("friend: name -> %s, age -> %s" , friend.string("name") , friend.string("age")));
        }

        // 获取map类型变量
        final YamlMapping relation = mapping.yamlMapping("relation");
        final YamlMapping mather = relation.yamlMapping("mather");
        System.out.println(String.format("mather: %s, %s" , mather.string("name") , mather.integer("age")));

        final YamlMapping father = relation.yamlMapping("father");
        System.out.println(String.format("father: %s, %s" , father.string("name") , father.integer("age")));

        System.out.println(mapping.string("line2"));
        System.out.println(mapping.string("line3"));



    }

}
