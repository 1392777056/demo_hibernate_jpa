package com.zhangsan.test;

import cn.zhangsan.entity.CstLinkMan;
import cn.zhangsan.entity.Customer;
import cn.zhangsan.utils.EntityManagerFactotyUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/8/14 16:00
 */
public class DemoJpaH {

    @Test
    public void getJpa() {

        EntityManager em = EntityManagerFactotyUtils.getEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Customer customer = new Customer();
        customer.setCustName("张三");

        CstLinkMan cstLinkMan = new CstLinkMan();
        cstLinkMan.setLkmName("李四");

        customer.getCstLinkMan().add(cstLinkMan);
        cstLinkMan.setCustomer(customer);

        em.persist(customer);

        em.persist(cstLinkMan);


        transaction.commit();

        em.close();

    }

    @Test
    public void getRemove() {

        EntityManager em = EntityManagerFactotyUtils.getEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Customer customer = em.find(Customer.class, 6L);
        em.remove(customer);

        transaction.commit();

        em.close();

    }

}
