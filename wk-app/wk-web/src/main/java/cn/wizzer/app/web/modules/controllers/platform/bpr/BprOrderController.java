package cn.wizzer.app.web.modules.controllers.platform.bpr;

import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.bpr.modules.models.Bpr_order;
import cn.wizzer.app.bpr.modules.services.BprOrderService;
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
@At("/platform/bpr/order")
public class BprOrderController{
    private static final Log log = Logs.get();
    @Inject
    private BprOrderService bprOrderService;

    @At("")
    @Ok("beetl:/platform/bpr/order/index.html")
    @RequiresPermissions("platform.bpr.order")
    public void index() {
    }

    @At("/data")
    @Ok("json:full")
    @RequiresPermissions("platform.bpr.order")
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
		Cnd cnd = Cnd.NEW();
    	return bprOrderService.data(length, start, draw, order, columns, cnd, null);
    }

    @At("/add")
    @Ok("beetl:/platform/bpr/order/add.html")
    @RequiresPermissions("platform.bpr.order")
    public void add() {

    }

    @At("/addDo")
    @Ok("json")
    @RequiresPermissions("platform.bpr.order.add")
    @SLog(tag = "Bpr_order", msg = "${args[0].id}")
    public Object addDo(@Param("..")Bpr_order bprOrder, HttpServletRequest req) {
		try {
			bprOrderService.insert(bprOrder);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/bpr/order/edit.html")
    @RequiresPermissions("platform.bpr.order")
    public void edit(String id,HttpServletRequest req) {
		req.setAttribute("obj", bprOrderService.fetch(id));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("platform.bpr.order.edit")
    @SLog(tag = "Bpr_order", msg = "${args[0].id}")
    public Object editDo(@Param("..")Bpr_order bprOrder, HttpServletRequest req) {
		try {
            bprOrder.setOpBy(StringUtil.getUid());
			bprOrder.setOpAt((int) (System.currentTimeMillis() / 1000));
			bprOrderService.updateIgnoreNull(bprOrder);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    @RequiresPermissions("platform.bpr.order.delete")
    @SLog(tag = "Bpr_order", msg = "${req.getAttribute('id')}")
    public Object delete(String id, @Param("ids")  String[] ids, HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				bprOrderService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				bprOrderService.delete(id);
    			req.setAttribute("id", id);
			}
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/detail/?")
    @Ok("beetl:/platform/bpr/order/detail.html")
    @RequiresPermissions("platform.bpr.order")
	public void detail(String id, HttpServletRequest req) {
        		if (!Strings.isBlank(id)) {
            req.setAttribute("obj", bprOrderService.fetch(id));
		}else{
            req.setAttribute("obj", null);
        }}

}
