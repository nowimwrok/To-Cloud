package cn.wizzer.app.web.modules.controllers.platform.bpr;

import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.bpr.modules.models.Bpr_delivery;
import cn.wizzer.app.bpr.modules.services.BprDeliveryService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@IocBean
@At("/platform/bpr/delivery")
public class BprDeliveryController{
    private static final Log log = Logs.get();
    @Inject
    private BprDeliveryService bprDeliveryService;

    @At("")
    @Ok("beetl:/platform/bpr/delivery/index.html")
    @RequiresPermissions("platform.bpr.delivery")
    public void index() {
    }

    @At("/data")
    @Ok("json:full")
    @RequiresPermissions("platform.bpr.delivery")
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
		Cnd cnd = Cnd.NEW();
    	return bprDeliveryService.data(length, start, draw, order, columns, cnd, null);
    }

    @At("/add")
    @Ok("beetl:/platform/bpr/delivery/add.html")
    @RequiresPermissions("platform.bpr.delivery")
    public void add() {

    }

    @At("/addDo")
    @Ok("json")
    @RequiresPermissions("platform.bpr.delivery.add")
    @SLog(tag = "Bpr_delivery", msg = "${args[0].id}")
    public Object addDo(@Param("..")Bpr_delivery bprDelivery, HttpServletRequest req) {
		try {
			bprDeliveryService.insert(bprDelivery);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/bpr/delivery/edit.html")
    @RequiresPermissions("platform.bpr.delivery")
    public void edit(String id,HttpServletRequest req) {
		req.setAttribute("obj", bprDeliveryService.fetch(id));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("platform.bpr.delivery.edit")
    @SLog(tag = "Bpr_delivery", msg = "${args[0].id}")
    public Object editDo(@Param("..")Bpr_delivery bprDelivery, HttpServletRequest req) {
		try {
            bprDelivery.setOpBy(StringUtil.getUid());
			bprDelivery.setOpAt((int) (System.currentTimeMillis() / 1000));
			bprDeliveryService.updateIgnoreNull(bprDelivery);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    @RequiresPermissions("platform.bpr.delivery.delete")
    @SLog(tag = "Bpr_delivery", msg = "${req.getAttribute('id')}")
    public Object delete(String id, @Param("ids")  String[] ids, HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				bprDeliveryService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				bprDeliveryService.delete(id);
    			req.setAttribute("id", id);
			}
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/detail/?")
    @Ok("beetl:/platform/bpr/delivery/detail.html")
    @RequiresPermissions("platform.bpr.delivery")
	public void detail(String id, HttpServletRequest req) {
        		if (!Strings.isBlank(id)) {
            req.setAttribute("obj", bprDeliveryService.fetch(id));
		}else{
            req.setAttribute("obj", null);
        }}

}
