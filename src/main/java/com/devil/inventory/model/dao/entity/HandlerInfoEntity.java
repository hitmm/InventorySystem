package com.devil.inventory.model.dao.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Description TODO
 * @Author huguangyin
 * @Date 2019/7/9-19:41
 *  
 */
@Entity
@Table(name = "tb_handler_info", schema = "inventory")
public class HandlerInfoEntity {
    private Long id;
    private String name;
    private String sex;
    private Integer age;
    private String tel;
    private Integer enable;
    private CompanyInfoEntity tbCompanyInfoByCompanyId;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "enable")
    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandlerInfoEntity that = (HandlerInfoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(age, that.age) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(enable, that.enable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, age, tel, enable);
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    public CompanyInfoEntity getTbCompanyInfoByCompanyId() {
        return tbCompanyInfoByCompanyId;
    }

    public void setTbCompanyInfoByCompanyId(CompanyInfoEntity tbCompanyInfoByCompanyId) {
        this.tbCompanyInfoByCompanyId = tbCompanyInfoByCompanyId;
    }
}
