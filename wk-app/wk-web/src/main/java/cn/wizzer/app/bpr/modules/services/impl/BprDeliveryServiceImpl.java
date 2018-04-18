package cn.wizzer.app.bpr.modules.services.impl;

import cn.wizzer.framework.base.service.BaseServiceImpl;
import cn.wizzer.app.bpr.modules.models.Bpr_delivery;
import cn.wizzer.app.bpr.modules.services.BprDeliveryService;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

@IocBean(args = {"refer:dao"})
public class BprDeliveryServiceImpl extends BaseServiceImpl<Bpr_delivery> implements BprDeliveryService {
    public BprDeliveryServiceImpl(Dao dao) {
        super(dao);
    }
}
