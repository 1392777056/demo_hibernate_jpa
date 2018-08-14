package cn.zhangsan.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Create with www.dezhe.com
 *
 * @Author 德哲
 * @Date 2018/8/13 15:02
 */
@Entity   // 声明实体类
@Table(name = "cst_customer")  //  实体类与表产生关系
public class Customer {

    @Id     // 声明当前属性为主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // 配置主键生成策略
    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_source")
    private String custSource;

    @Column(name = "cust_industry")
    private String custIndustry;

    @Column(name = "cust_level")
    private String custLevel;

    @Column(name = "cust_address")
    private String custAddress;

    @Column(name = "cust_phone")
    private String custPhone;

    // @mappedBy ： 放弃外键维护权
    // CascadeType : 设置级别关系
    @OneToMany(targetEntity = CstLinkMan.class,mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<CstLinkMan> cstLinkMan = new HashSet<CstLinkMan>(0);

    public Set<CstLinkMan> getCstLinkMan() {
        return cstLinkMan;
    }

    public void setCstLinkMan(Set<CstLinkMan> cstLinkMan) {
        this.cstLinkMan = cstLinkMan;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }
}