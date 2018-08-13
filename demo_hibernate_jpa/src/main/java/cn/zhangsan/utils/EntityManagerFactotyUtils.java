package cn.zhangsan.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/8/13 15:25
 */
public class EntityManagerFactotyUtils {

    private static EntityManagerFactory entityManagerFactory;

    static {

        entityManagerFactory = Persistence.createEntityManagerFactory("myJPAUnit");

    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
