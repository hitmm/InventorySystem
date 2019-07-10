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
@Table(name = "tb_warehouse_store_detail", schema = "inventory")
public class WarehouseStoreDetailEntity {
    private Long id;
    private BigDecimal unitPrice;
    private String unit;
    private Integer storeNumber;
    private Long createTime;
    private Long updateTime;
    private Long mainId;
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
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "store_number")
    public Integer getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(Integer storeNumber) {
        this.storeNumber = storeNumber;
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

    @Basic
    @Column(name = "main_id")
    public Long getMainId() {
        return mainId;
    }

    public void setMainId(Long mainId) {
        this.mainId = mainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseStoreDetailEntity that = (WarehouseStoreDetailEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(storeNumber, that.storeNumber) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(mainId, that.mainId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, unitPrice, unit, storeNumber, createTime, updateTime, mainId);
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