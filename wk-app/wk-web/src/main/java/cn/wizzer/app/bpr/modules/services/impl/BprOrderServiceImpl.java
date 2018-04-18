package cn.wizzer.app.bpr.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.bpr.modules.models.Bpr_order;
import cn.wizzer.app.bpr.modules.services.BprOrderService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class BprOrderServiceImpl extends BaseServiceImpl<Bpr_order> implements BprOrderService {
    public BprOrderServiceImpl(Dao dao) {
        super(dao);
    }
}
