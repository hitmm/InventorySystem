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
@Table(name = "tb_sell_detail", schema = "inventory")
public class SellDetailEntity {
    private Long id;
    private BigDecimal unitPrice;
    private Double saleNumber;
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
    @Column(name = "sale_number")
    public Double getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(Double saleNumber) {
        this.saleNumber = saleNumber;
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
        SellDetailEntity that = (SellDetailEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                Objects.equals(saleNumber, that.saleNumber) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, unitPrice, saleNumber, createTime, updateTime);
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
