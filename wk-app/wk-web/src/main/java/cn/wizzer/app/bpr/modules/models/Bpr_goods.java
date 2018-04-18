package cn.wizzer.app.bpr.modules.models;

import cn.wizzer.app.sys.modules.models.Sys_unit;
import cn.wizzer.app.sys.modules.models.Sys_user;
import cn.wizzer.framework.base.model.BaseModel;
import org.nutz.dao.entity.annotation.*;


import java.io.Serializable;
import java.util.List;

/***
 * cn.wizzer.app.bpr.modules.models
 * Created By vayne
 * Time on 2018/2/26 下午5:11
 * 项目 To-Cloud
 *
 */
@Table("bpr_goods")
@TableIndexes({@Index(name = "INDEX_BPR_GOODSNAME", fields = {"goodsname"}, unique = true)})
public class Bpr_goods extends BaseModel implements Serializable {
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

    @One(field = "unitid")
    private Sys_unit userUnit;

    @Column
    @Comment("用户ID")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String userId;

    @One(field = "userId")
    private Sys_user user;

    @Column
    @Comment("货源名称")
    @ColDefine(type = ColType.VARCHAR, width = 120)
    private String goodsname;

    @Column
    @Comment("仓库名称")
    @ColDefine(type = ColType.VARCHAR, width = 120)
    private String warehouse;

    @Column
    @Comment("批号")
    @ColDefine(type = ColType.VARCHAR, width = 120)
    private String batch;

    @Column
    @Comment("规格")
    @ColDefine(type = ColType.VARCHAR, width = 120)
    private String spec;

    @Column
    @Comment("重量")
    @ColDefine(type = ColType.FLOAT, width = 32, precision = 3)
    private String weight;

    @Column
    @Comment("数量")
    @ColDefine(type = ColType.INT, width = 32)
    private String number;

    @Column
    @Comment("剩余数量")
    @ColDefine(type = ColType.INT, width = 32)
    private String surplusNumber;

    @Column
    @Comment("总运量")//=重量*数量
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
    @Comment("单位")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String unit;

    @Column
    @Comment("材质")
    @ColDefine(type = ColType.VARCHAR, width = 120)
    private String texture;

    @Column
    @Comment("类型")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String type;


    @Column
    @Comment("状态")
    @ColDefine(type = ColType.VARCHAR, width = 32)
    private String status;

    @Column
    @Comment("备注")
    @ColDefine(type = ColType.VARCHAR,width = 255)
    private String remarks;

    protected List<Bpr_goods> patchList;///调度list

    private String [] ids;

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public List<Bpr_goods> getPatchList() {
        return patchList;
    }

    public void setPatchList(List<Bpr_goods> patchList) {
        this.patchList = patchList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getSurplusNumber() {
        return surplusNumber;
    }

    public void setSurplusNumber(String surplusNumber) {
        this.surplusNumber = surplusNumber;
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
}
