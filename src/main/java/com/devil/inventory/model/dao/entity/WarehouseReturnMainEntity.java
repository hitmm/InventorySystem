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
@Table(name = "tb_warehouse_return_main", schema = "inventory")
public class WarehouseReturnMainEntity {
    private Long id;
    private Integer varietiesNum;
    private BigDecimal totalMoney;
    private String accConclusion;
    private Long customerId;
    private Long saleTime;
    private Long operatorId;
    private Long handlerId;
    private String tradesWay;
    private Long createTime;
    private Long updateTime;

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
    @Column(name = "customer_id")
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
    @Column(name = "operator_id")
    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    @Basic
    @Column(name = "handler_id")
    public Long getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(Long handlerId) {
        this.handlerId = handlerId;
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
        WarehouseReturnMainEntity that = (WarehouseReturnMainEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(varietiesNum, that.varietiesNum) &&
                Objects.equals(totalMoney, that.totalMoney) &&
                Objects.equals(accConclusion, that.accConclusion) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(saleTime, that.saleTime) &&
                Objects.equals(operatorId, that.operatorId) &&
                Objects.equals(handlerId, that.handlerId) &&
                Objects.equals(tradesWay, that.tradesWay) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, varietiesNum, totalMoney, accConclusion, customerId, saleTime, operatorId, handlerId, tradesWay, createTime, updateTime);
    }
}
