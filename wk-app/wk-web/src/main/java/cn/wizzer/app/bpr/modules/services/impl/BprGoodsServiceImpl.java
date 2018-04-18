package cn.wizzer.app.bpr.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.bpr.modules.models.Bpr_goods;
import cn.wizzer.app.bpr.modules.services.BprGoodsService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class BprGoodsServiceImpl extends BaseServiceImpl<Bpr_goods> implements BprGoodsService {
    public BprGoodsServiceImpl(Dao dao) {
        super(dao);
    }
}
