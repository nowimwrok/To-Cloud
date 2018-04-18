package cn.wizzer.app.bpr.modules.models;

import cn.wizzer.app.sys.modules.models.Sys_unit;
import cn.wizzer.app.sys.modules.models.Sys_user;
import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;

/***
 * cn.wizzer.app.bpr.modules.models
 * Created By vayne
 * Time on 2018/2/27 上午8:37
 * 项目 To-Cloud
 *
 */
@Table("bpr_order")
@TableIndexes({@Index(name = "INDEX_BPR_ORDERNO", fields = {"orderNo"}, unique = true)})
public class Bpr_order extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column
    @Name
    @Comment("ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    @Prev(els = {@EL("uuid()")})
    private String id;


    @Column
    @Comment("订单号")
    @Prev(els = {@EL("ig(view.bpr_order,'OD')")})
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String orderNo;

    @Column
    @Comment("订单价格")
    @ColDefine(type = ColType.FLOAT, width = 32, precision = 2)
    private String price;

    @Column
    @Comment("运费")
    @ColDefine(type = ColType.FLOAT, width = 32, precision = 2)
    private String freight;

    @Column
    @Comment("订单来源")
    @ColDefine(type = ColType.CHAR, width = 2)
    private String dataSource;

    @Column
    @Comment("托运单位")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String shipperUnitId;

    @One(field = "shipperUnitId")
    private Sys_unit shipperUnit;

    @Column
    @Comment("派单人")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String sendUserId;

    @One(field = "sendUserId")
    private Sys_user shipper;

    @Column
    @Comment("承运方")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String carrierUnitId;

    @One(field = "carrierUnitId")
    private Sys_unit carrierUnit;

    @Column
    @Comment("接单员")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String takerUserId;

    @One(field = "takerUserId")
    private Sys_user taker;

    @Column
    @Comment("支付方式")///0线上、1线下
    @ColDefine(type = ColType.CHAR, width = 2)
    private String payWay;

    @Column
    @Comment("线上支付金额")
    @ColDefine(type = ColType.FLOAT, width = 32, precision = 2)
    private String onlinePay;

    @Column
    @Comment("线下支付金额")
    @ColDefine(type = ColType.FLOAT, width = 32, precision = 2)
    private String linePay;

    @Column
    @Comment("是否预付")
    @ColDefine(type = ColType.CHAR, width = 2)
    private String isPrepay;

    @Column
    @Comment("预付金额")
    @ColDefine(type = ColType.FLOAT, width = 32, precision = 2)
    private String prepay;

    @Column
    @Comment("尾付金额")
    @ColDefine(type = ColType.FLOAT, width = 32, precision = 2)
    private String endpay;

    @Column
    @Comment("实际支付")
    @ColDefine(type = ColType.FLOAT, width = 32, precision = 2)
    private String actualPay;

    @Column
    @Comment("扣费金额")
    @ColDefine(type = ColType.FLOAT, width = 32, precision = 2)
    private String dedMoney;

    @Column
    @Comment("扣费原因")
    @ColDefine(type = ColType.VARCHAR, width = 255)
    private String dedReason;

    @Column
    @Comment("提货状态")
    @ColDefine(type = ColType.CHAR, width = 2)
    private String pickStauts;

    @Column
    @Comment("运输状态")
    @ColDefine(type = ColType.CHAR, width = 2)
    private String cargoStatus;

    @Column
    @Comment("支付状态")
    @ColDefine(type = ColType.CHAR, width = 2)
    private String payStatus;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getShipperUnitId() {
        return shipperUnitId;
    }

    public void setShipperUnitId(String shipperUnitId) {
        this.shipperUnitId = shipperUnitId;
    }

    public Sys_unit getShipperUnit() {
        return shipperUnit;
    }

    public void setShipperUnit(Sys_unit shipperUnit) {
        this.shipperUnit = shipperUnit;
    }

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Sys_user getShipper() {
        return shipper;
    }

    public void setShipper(Sys_user shipper) {
        this.shipper = shipper;
    }

    public String getCarrierUnitId() {
        return carrierUnitId;
    }

    public void setCarrierUnitId(String carrierUnitId) {
        this.carrierUnitId = carrierUnitId;
    }

    public Sys_unit getCarrierUnit() {
        return carrierUnit;
    }

    public void setCarrierUnit(Sys_unit carrierUnit) {
        this.carrierUnit = carrierUnit;
    }

    public String getTakerUserId() {
        return takerUserId;
    }

    public void setTakerUserId(String takerUserId) {
        this.takerUserId = takerUserId;
    }

    public Sys_user getTaker() {
        return taker;
    }

    public void setTaker(Sys_user taker) {
        this.taker = taker;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getOnlinePay() {
        return onlinePay;
    }

    public void setOnlinePay(String onlinePay) {
        this.onlinePay = onlinePay;
    }

    public String getLinePay() {
        return linePay;
    }

    public void setLinePay(String linePay) {
        this.linePay = linePay;
    }

    public String getIsPrepay() {
        return isPrepay;
    }

    public void setIsPrepay(String isPrepay) {
        this.isPrepay = isPrepay;
    }

    public String getPrepay() {
        return prepay;
    }

    public void setPrepay(String prepay) {
        this.prepay = prepay;
    }

    public String getEndpay() {
        return endpay;
    }

    public void setEndpay(String endpay) {
        this.endpay = endpay;
    }

    public String getActualPay() {
        return actualPay;
    }

    public void setActualPay(String actualPay) {
        this.actualPay = actualPay;
    }

    public String getDedMoney() {
        return dedMoney;
    }

    public void setDedMoney(String dedMoney) {
        this.dedMoney = dedMoney;
    }

    public String getDedReason() {
        return dedReason;
    }

    public void setDedReason(String dedReason) {
        this.dedReason = dedReason;
    }

    public String getPickStauts() {
        return pickStauts;
    }

    public void setPickStauts(String pickStauts) {
        this.pickStauts = pickStauts;
    }

    public String getCargoStatus() {
        return cargoStatus;
    }

    public void setCargoStatus(String cargoStatus) {
        this.cargoStatus = cargoStatus;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }


    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
