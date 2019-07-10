package com.devil.inventory.model.dao.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @Description TODO
 * @Author huguangyin
 * @Date 2019/7/9-19:41
 *  
 */
@Entity
@Table(name = "tb_sell_main", schema = "inventory")
public class SellMainEntity {
    private Long id;
    private Integer varietiesNum;
    private BigDecimal totalMoney;
    private String accConclusion;
    private Long saleTime;
    private String tradesWay;
    private Long createTime;
    private Long updateTime;
    private CustomerInfoEntity tbCustomerInfoByCustomerId;
    private HandlerInfoEntity tbHandlerByHandlerId;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "varieties_num")
    public Integer getVarietiesNum() {
        return varietiesNum;
    }

    public void setVarietiesNum(Integer varietiesNum) {
        this.varietiesNum = varietiesNum;
    }

    @Basic
    @Column(name = "total_money")
    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Basic
    @Column(name = "acc_conclusion")
    public String getAccConclusion() {
        return accConclusion;
    }

    public void setAccConclusion(String accConclusion) {
        this.accConclusion = accConclusion;
    }

    @Basic
    @Column(name = "sale_time")
    public Long getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Long saleTime) {
        this.saleTime = saleTime;
    }

    @Basic
    @Column(name = "trades_way")
    public String getTradesWay() {
        return tradesWay;
    }

    public void setTradesWay(String tradesWay) {
        this.tradesWay = tradesWay;
    }

    @Basic
    @Column(name = "create_time")
    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellMainEntity that = (SellMainEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(varietiesNum, that.varietiesNum) &&
                Objects.equals(totalMoney, that.totalMoney) &&
                Objects.equals(accConclusion, that.accConclusion) &&
                Objects.equals(saleTime, that.saleTime) &&
                Objects.equals(tradesWay, that.tradesWay) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, varietiesNum, totalMoney, accConclusion, saleTime, tradesWay, createTime, updateTime);
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    public CustomerInfoEntity getTbCustomerInfoByCustomerId() {
        return tbCustomerInfoByCustomerId;
    }

    public void setTbCustomerInfoByCustomerId(CustomerInfoEntity tbCustomerInfoByCustomerId) {
        this.tbCustomerInfoByCustomerId = tbCustomerInfoByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "handler_id", referencedColumnName = "id", nullable = false)
    public HandlerInfoEntity getTbHandlerByHandlerId() {
        return tbHandlerByHandlerId;
    }

    public void setTbHandlerByHandlerId(HandlerInfoEntity tbHandlerByHandlerId) {
        this.tbHandlerByHandlerId = tbHandlerByHandlerId;
    }
}
