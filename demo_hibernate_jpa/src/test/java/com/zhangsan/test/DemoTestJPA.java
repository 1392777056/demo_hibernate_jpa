package com.zhangsan.test;

import cn.zhangsan.entity.Customer;
import cn.zhangsan.utils.EntityManagerFactotyUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/8/13 15:17
 */
public class DemoTestJPA {

    @Test
    public void saveCustomer() {

        // 实体类管理工厂
        // EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPAUnit");

        //EntityManager manager = factory.createEntityManager();      // 创建实体类管理对象

        EntityManager manager = EntityManagerFactotyUtils.getEntityManager();

        EntityTransaction transaction = manager.getTransaction();   // 获取事务对象

        transaction.begin();  // 开启事务

        Customer customer = new Customer();

        customer.setCustName("sfds");

        manager.persist(customer);   // 保存数据方法

        transaction.commit();  // 事务提交

        manager.close();  // 释放资源

    }

    @Test
    public void findCustomer() {

        // 实体类管理工厂
        // EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPAUnit");

        //EntityManager manager = factory.createEntityManager();      // 创建实体类管理对象

        EntityManager manager = EntityManagerFactotyUtils.getEntityManager();

        EntityTransaction transaction = manager.getTransaction();   // 获取事务对象

        transaction.begin();  // 开启事务

        // find 立即加载    getReference 懒加载，延迟加载
       /* Customer customer = manager.find(Customer.class,2L);*/
       Customer customer = manager.getReference(Customer.class,2L);
        System.out.println(customer);

        manager.persist(customer);   // 保存数据方法

        transaction.commit();  // 事务提交

        manager.close();  // 释放资源

    }

    @Test
    public void UpdateCustomer() {

        // 实体类管理工厂
        // EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPAUnit");

        //EntityManager manager = factory.createEntityManager();      // 创建实体类管理对象

        EntityManager manager = EntityManagerFactotyUtils.getEntityManager();

        EntityTransaction transaction = manager.getTransaction();   // 获取事务对象

        transaction.begin();  // 开启事务

        Customer customer = manager.find(Customer.class,2L);
        customer.setCustName("1236");

        manager.merge(customer);  // 修改方法

        manager.persist(customer);   // 保存数据方法

        transaction.commit();  // 事务提交

        manager.close();  // 释放资源

    }

    @Test
    public void DeleteCustomer() {

        // 实体类管理工厂
        // EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPAUnit");

        //EntityManager manager = factory.createEntityManager();      // 创建实体类管理对象

        EntityManager manager = EntityManagerFactotyUtils.getEntityManager();

        EntityTransaction transaction = manager.getTransaction();   // 获取事务对象

        transaction.begin();  // 开启事务

        Customer customer = manager.find(Customer.class,5L);

        manager.remove(customer);  // 删除方法

        transaction.commit();  // 事务提交

        manager.close();  // 释放资源

    }

    @Test
    public void Querys() {

        EntityManager entityManager = EntityManagerFactotyUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        /*Query query = entityManager.createQuery("from Customer where custId = ? ");
        query.setParameter(1,1L);*/

        Query query = entityManager.createQuery("from Customer order by custId desc");

        query.setFirstResult(0);
        query.setMaxResults(2);

        List<Customer> resultList = query.getResultList();
        for (Customer o : resultList) {
            System.out.println(o);
        }


        transaction.commit();
        entityManager.close();


    }

}
