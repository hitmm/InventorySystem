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
@Table(name = "tb_sales_return_detail", schema = "inventory")
public class SalesReturnDetailEntity {
    private Long id;
    private BigDecimal unitPrice;
    private Integer returnNumber;
    private Long createTime;
    private Long updateTime;
    private GoodsInfoEntity tbGoodsInfoByGoodsId;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "unit_price")
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "return_number")
    public Integer getReturnNumber() {
        return returnNumber;
    }

    public void setReturnNumber(Integer returnNumber) {
        this.returnNumber = returnNumber;
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
        SalesReturnDetailEntity that = (SalesReturnDetailEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                Objects.equals(returnNumber, that.returnNumber) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, unitPrice, returnNumber, createTime, updateTime);
    }

    @ManyToOne
    @JoinColumn(name = "goods_id", referencedColumnName = "id", nullable = false)
    public GoodsInfoEntity getTbGoodsInfoByGoodsId() {
        return tbGoodsInfoByGoodsId;
    }

    public void setTbGoodsInfoByGoodsId(GoodsInfoEntity tbGoodsInfoByGoodsId) {
        this.tbGoodsInfoByGoodsId = tbGoodsInfoByGoodsId;
    }
}
