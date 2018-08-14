package com.zhangsan.test;

import cn.zhangsan.entity.SysRole;
import cn.zhangsan.entity.SysUser;
import cn.zhangsan.utils.EntityManagerFactotyUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/8/14 20:25
 */
public class JapDemo {

    @Test
    public void getROELSA() {

        EntityManager manager = EntityManagerFactotyUtils.getEntityManager();

        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();

        SysUser u1 = new SysUser();
        u1.setUserName("用户1");

        SysUser u2 = new SysUser();
        u2.setUserName("用户2");

        SysRole r1 = new SysRole();
        r1.setRoleName("角色1");

        SysRole r2 = new SysRole();
        r2.setRoleName("角色2");

        SysRole r3 = new SysRole();
        r3.setRoleName("角色3");

        // * 让 1号用户具有 1号和 2号角色(双向的)
        u1.getSysRoles().add(r1);
        u1.getSysRoles().add(r2);
        // * 让 2号用户具有 2号和 3号角色(双向的)
        u2.getSysRoles().add(r2);
        u2.getSysRoles().add(r3);

        r1.getSysUsers().add(u1);
        r2.getSysUsers().add(u1);
        r2.getSysUsers().add(u2);
        r3.getSysUsers().add(u2);
        //给用户授予角色	(因为用户对象放弃了维护权，所以以下代码可以不写)

        manager.persist(u1);
        manager.persist(u2);
        manager.persist(r1);
        manager.persist(r2);
        manager.persist(r3);

        transaction.commit();

        manager.close();

    }
    @Test
    public void sk() {

        EntityManager entityManager = EntityManagerFactotyUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        SysRole sysRole = entityManager.find(SysRole.class, 1L);
        entityManager.remove(sysRole);

        transaction.commit();
        entityManager.close();

    }

}
