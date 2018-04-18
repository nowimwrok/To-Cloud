package cn.wizzer.app.web.commons.base;

import cn.wizzer.app.bpr.modules.models.Bpr_delivery;

import cn.wizzer.app.bpr.modules.models.Bpr_goods;
import cn.wizzer.app.bpr.modules.models.Bpr_order;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;


/***
 * cn.wizzer.app.web.commons.base
 * Created By vayne
 * Time on 2018/2/27 上午8:43
 * 项目 To-Cloud
 *
 */
public class CodeDao {

    public static void main(String[] args) {
        createTable();
    }

    public static void createTable() {
    /*    Ioc ioc = new NutIoc(new JsonLoader("code.js"));
        DataSource ds = ioc.get(DataSource.class);
        Dao dao = new NutDao(ds); //如果已经定义了dao,那么改成dao = ioc.get(Dao.class);

        dao.create(Bpr_goods.class, true);
        // dao.insert(User.create("wendal","123456"));

        ioc.depose(); //关闭Ioc容器*/

        // 创建一个数据源
        SimpleDataSource dataSource = new SimpleDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost/nutzwk?useUnicode=true&characterEncoding=utf8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("imwork");

// 创建一个NutDao实例,在真实项目中, NutDao通常由ioc托管, 使用注入的方式获得.
        Dao dao = new NutDao(dataSource);

// 创建表
        dao.create(Bpr_delivery.class, true); // false的含义是,如果表已经存在,就不要删除重建了.

    }
}
