package cn.wizzer.app.web.modules.controllers.platform.bpr;

import cn.wizzer.framework.base.Result;
import cn.wizzer.app.web.commons.slog.annotation.SLog;
import cn.wizzer.framework.page.datatable.DataTableColumn;
import cn.wizzer.framework.page.datatable.DataTableOrder;
import cn.wizzer.framework.util.StringUtil;
import cn.wizzer.app.bpr.modules.models.Bpr_goods;
import cn.wizzer.app.bpr.modules.services.BprGoodsService;
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
@At("/platform/bpr/goods")
public class BprGoodsController{
    private static final Log log = Logs.get();
    @Inject
    private BprGoodsService bprGoodsService;

    @At("")
    @Ok("beetl:/platform/bpr/goods/index.html")
    @RequiresPermissions("platform.bpr.goods")
    public void index() {
    }

    @At("/data")
    @Ok("json:full")
    @RequiresPermissions("platform.bpr.goods")
    public Object data(@Param("length") int length, @Param("start") int start, @Param("draw") int draw, @Param("::order") List<DataTableOrder> order, @Param("::columns") List<DataTableColumn> columns) {
		Cnd cnd = Cnd.NEW();
    	return bprGoodsService.data(length, start, draw, order, columns, cnd, "userUnit");
    }

    @At("/add")
    @Ok("beetl:/platform/bpr/goods/add.html")
    @RequiresPermissions("platform.bpr.goods")
    public void add() {

    }

    @At("/addDo")
    @Ok("json")
    @RequiresPermissions("platform.bpr.goods.add")
    @SLog(tag = "Bpr_goods", msg = "${args[0].id}")
    public Object addDo(@Param("..")Bpr_goods bprGoods, HttpServletRequest req) {
		try {
			bprGoodsService.insert(bprGoods);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At("/edit/?")
    @Ok("beetl:/platform/bpr/goods/edit.html")
    @RequiresPermissions("platform.bpr.goods")
    public void edit(String id,HttpServletRequest req) {
		req.setAttribute("obj", bprGoodsService.fetchLinks(bprGoodsService.fetch(id),"userUnit"));
    }

    @At("/dispatch/?")
    @Ok("beetl:/platform/bpr/goods/dispatch.html")
    @RequiresPermissions("platform.bpr.goods")
    public void toDispatch(@Param("ids")  String[] ids,HttpServletRequest req) {

        req.setAttribute("obj", bprGoodsService.fetch(Cnd.where("id","in",org.apache.shiro.util.StringUtils.toString(ids))));
        //req.setAttribute("obj", bprGoodsService.fetchLinks(bprGoodsService.fetch(ids),"userUnit"));
    }

    @At("/editDo")
    @Ok("json")
    @RequiresPermissions("platform.bpr.goods.edit")
    @SLog(tag = "Bpr_goods", msg = "${args[0].id}")
    public Object editDo(@Param("..")Bpr_goods bprGoods, HttpServletRequest req) {
		try {
            bprGoods.setOpBy(StringUtil.getUid());
			bprGoods.setOpAt((int) (System.currentTimeMillis() / 1000));
			bprGoodsService.updateIgnoreNull(bprGoods);
			return Result.success("system.success");
		} catch (Exception e) {
			return Result.error("system.error");
		}
    }

    @At({"/delete/?", "/delete"})
    @Ok("json")
    @RequiresPermissions("platform.bpr.goods.delete")
    @SLog(tag = "Bpr_goods", msg = "${req.getAttribute('id')}")
    public Object delete(String id, @Param("ids")  String[] ids, HttpServletRequest req) {
		try {
			if(ids!=null&&ids.length>0){
				bprGoodsService.delete(ids);
    			req.setAttribute("id", org.apache.shiro.util.StringUtils.toString(ids));
			}else{
				bprGoodsService.delete(id);
    			req.setAttribute("id", id);
			}
            return Result.success("system.success");
        } catch (Exception e) {
            return Result.error("system.error");
        }
    }

    @At("/detail/?")
    @Ok("beetl:/platform/bpr/goods/detail.html")
    @RequiresPermissions("platform.bpr.goods")
	public void detail(String id, HttpServletRequest req) {
        		if (!Strings.isBlank(id)) {
            req.setAttribute("obj", bprGoodsService.fetch(id));
		}else{
            req.setAttribute("obj", null);
        }}

}
