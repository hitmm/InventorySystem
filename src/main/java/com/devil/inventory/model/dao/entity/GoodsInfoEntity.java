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
@Table(name = "tb_goods_info", schema = "inventory")
public class GoodsInfoEntity {
    private Long id;
    private String goodsName;
    private String goodsAlias;
    private String originPlace;
    private BigDecimal unitPrice;
    private String unit;
    private String specifications;
    private String pack;
    private String batchNumber;
    private String approvalNumber;
    private String remarks;
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
    @Column(name = "goods_name")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "goods_alias")
    public String getGoodsAlias() {
        return goodsAlias;
    }

    public void setGoodsAlias(String goodsAlias) {
        this.goodsAlias = goodsAlias;
    }

    @Basic
    @Column(name = "origin_place")
    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
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
    @Column(name = "specifications")
    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    @Basic
    @Column(name = "package")
    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    @Basic
    @Column(name = "batch_number")
    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    @Basic
    @Column(name = "approval_number")
    public String getApprovalNumber() {
        return approvalNumber;
    }

    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        GoodsInfoEntity that = (GoodsInfoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(goodsName, that.goodsName) &&
                Objects.equals(goodsAlias, that.goodsAlias) &&
                Objects.equals(originPlace, that.originPlace) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(specifications, that.specifications) &&
                Objects.equals(pack, that.pack) &&
                Objects.equals(batchNumber, that.batchNumber) &&
                Objects.equals(approvalNumber, that.approvalNumber) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goodsName, goodsAlias, originPlace, unitPrice, unit, specifications, pack, batchNumber, approvalNumber, remarks, createTime, updateTime);
    }
}
