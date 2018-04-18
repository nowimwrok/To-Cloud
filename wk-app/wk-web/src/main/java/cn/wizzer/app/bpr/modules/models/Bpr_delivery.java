package cn.wizzer.app.bpr.modules.models;

import cn.wizzer.app.sys.modules.models.Sys_unit;
import cn.wizzer.app.sys.modules.models.Sys_user;
import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/***
 * cn.wizzer.app.bpr.modules.models
 * Created By vayne
 * Time on 2018/2/27 下午5:32
 * 项目 To-Cloud
 *
 */
@Table("bpr_delivery")
@TableIndexes({@Index(name = "INDEX_BPR_DLUNITID", fields = {"unitid"}, unique = true)})
public class Bpr_delivery extends BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;

    @Column
    @Comment("所属单位")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String unitid;

    @Column
    @Comment("订单ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String orderId;


    @One(field = "unitid")
    private Sys_unit userUnit;

    @Column
    @Comment("用户ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String userId;

    @One(field = "userId")
    private Sys_user user;

    @Column
    @Comment("货源ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String goodsId;

    @One(field = "goodsId")
    private Bpr_goods bprGoods;

    @Column
    @Comment("父级ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String parentId;

    @Column
    @Comment("是否是子级")
    @ColDefine(type = ColType.CHAR, width = 32)
    private String isChild;

    @Column
    @Comment("配送单号")
    @Prev(els = {@EL("ig(view.bpr_delivery,'DL')")})
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String deliveryNo;

    @Column
    @Comment("数量")
    @ColDefine(type = ColType.INT, width = 32)
    private String number;

    @Column
    @Comment("剩余数量")
    @ColDefine(type = ColType.INT, width = 32)
    private String surplusNumber;

    @Column
    @Comment("运量")
    @ColDefine(type = ColType.FLOAT, width = 32, precision = 3)
    private String toalVolume;


    @Column
    @Comment("剩余运量")
    @ColDefine(type = ColType.FLOAT, width = 32, precision = 3)
    private String surplusVolume;

    @Column
    @Comment("已运量")
    @ColDefine(type = ColType.FLOAT, width = 32, precision = 3)
    private String transVolume;

    @Column
    @Comment("发货地址-省")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String fromProvince;

    @Column
    @Comment("发货地址-市")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String fromCity;

    @Column
    @Comment("发货地址-区")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String fromArea;

    @Column
    @Comment("发货地址-详细地址")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String fromAddress;

    @Column
    @Comment("收货地址-省")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String toProvince;

    @Column
    @Comment("收货地址-市")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String toCity;

    @Column
    @Comment("收货地址-区")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String toArea;

    @Column
    @Comment("收货地址-详细地址")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String toAddress;


    @Column
    @Comment("发货联系人")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String shipper;

    @Column
    @Comment("发货联系电话")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String shipperPhone;

    @Column
    @Comment("收货联系人")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String carrier;

    @Column
    @Comment("收货联系电话")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String carrierPhone;

    @Column
    @Comment("运输状态")
    @ColDefine(type = ColType.CHAR, width = 2)
    private String status;

    @Column
    @Comment("提货凭据")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String pickUrl;

    @Column
    @Comment("提货时间")
    @Prev(els = @EL("$me.now()"))
    @ColDefine(type = ColType.INT)
    private Integer picTime;

    @Column
    @Comment("卸货凭据")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String unloadUrl;

    @Column
    @Comment("卸货时间")
    @Prev(els = @EL("$me.now()"))
    @ColDefine(type = ColType.INT)
    private Integer unloadTime;

    @Column
    @Comment("提货码")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String pickCode;

    @Column
    @Comment("提货码图片")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String pickCodeImg;

    @Column
    @Comment("备注")
    @ColDefine(type = ColType.VARCHAR,width = 255)
    private String remarks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }

    public Sys_unit getUserUnit() {
        return userUnit;
    }

    public void setUserUnit(Sys_unit userUnit) {
        this.userUnit = userUnit;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public Bpr_goods getBprGoods() {
        return bprGoods;
    }

    public void setBprGoods(Bpr_goods bprGoods) {
        this.bprGoods = bprGoods;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getIsChild() {
        return isChild;
    }

    public void setIsChild(String isChild) {
        this.isChild = isChild;
    }

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSurplusNumber() {
        return surplusNumber;
    }

    public void setSurplusNumber(String surplusNumber) {
        this.surplusNumber = surplusNumber;
    }

    public String getToalVolume() {
        return toalVolume;
    }

    public void setToalVolume(String toalVolume) {
        this.toalVolume = toalVolume;
    }

    public String getSurplusVolume() {
        return surplusVolume;
    }

    public void setSurplusVolume(String surplusVolume) {
        this.surplusVolume = surplusVolume;
    }

    public String getTransVolume() {
        return transVolume;
    }

    public void setTransVolume(String transVolume) {
        this.transVolume = transVolume;
    }

    public String getFromProvince() {
        return fromProvince;
    }

    public void setFromProvince(String fromProvince) {
        this.fromProvince = fromProvince;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getFromArea() {
        return fromArea;
    }

    public void setFromArea(String fromArea) {
        this.fromArea = fromArea;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToProvince() {
        return toProvince;
    }

    public void setToProvince(String toProvince) {
        this.toProvince = toProvince;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getToArea() {
        return toArea;
    }

    public void setToArea(String toArea) {
        this.toArea = toArea;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public String getShipperPhone() {
        return shipperPhone;
    }

    public void setShipperPhone(String shipperPhone) {
        this.shipperPhone = shipperPhone;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getCarrierPhone() {
        return carrierPhone;
    }

    public void setCarrierPhone(String carrierPhone) {
        this.carrierPhone = carrierPhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPickUrl() {
        return pickUrl;
    }

    public void setPickUrl(String pickUrl) {
        this.pickUrl = pickUrl;
    }

    public Integer getPicTime() {
        return picTime;
    }

    public void setPicTime(Integer picTime) {
        this.picTime = picTime;
    }

    public String getUnloadUrl() {
        return unloadUrl;
    }

    public void setUnloadUrl(String unloadUrl) {
        this.unloadUrl = unloadUrl;
    }

    public Integer getUnloadTime() {
        return unloadTime;
    }

    public void setUnloadTime(Integer unloadTime) {
        this.unloadTime = unloadTime;
    }

    public String getPickCode() {
        return pickCode;
    }

    public void setPickCode(String pickCode) {
        this.pickCode = pickCode;
    }

    public String getPickCodeImg() {
        return pickCodeImg;
    }

    public void setPickCodeImg(String pickCodeImg) {
        this.pickCodeImg = pickCodeImg;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Sys_user getUser() {
        return user;
    }

    public void setUser(Sys_user user) {
        this.user = user;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
