package com.crm.controller;

import com.crm.model.Product;
import com.crm.service.ProductService;
import com.crm.util.DateJsonValueProcessor;
import com.crm.util.Json;
import com.crm.util.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/12.
 */

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    private static final transient Logger log = org.slf4j.LoggerFactory.getLogger(OrganizationController.class);
    @Resource
    private ProductService productService;

    @RequestMapping(value = "/List",method = RequestMethod.POST)
    @ResponseBody
    public Object productList(@RequestParam(value = "page",required = false)String page,
                                   @RequestParam(value = "rows",required = false)String rows,
                                   Product product){
        //初始化分页信息
        PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));

        Map<String,Object> map = new HashMap<String, Object>();

        if (product.getProductName() != null){
            map.put("productName",product.getProductName());
        }

        if (product.getProductNumber() != null){
            map.put("productNumber",product.getProductNumber());
        }

        if (product.getPartNumber() != null){
            map.put("productName",product.getPartNumber());
        }

        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());

        List<Product>products = productService.find(map);
        Long total=productService.getTotal(map);

        JSONObject result=new JSONObject();
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class,new DateJsonValueProcessor("yyyy-MM-dd hh:mm:ss"));
        JSONArray jsonArray= JSONArray.fromObject(products,jsonConfig);
        result.put("rows", jsonArray);
        result.put("total",total);
        log.debug("产品列表"+result.toString());
        return result;
    }

    //增加产品
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Object addProduct(Product product) {
        //获取上面取得的json数据
        Json json = new Json();
        //添加失败。必要字段信息缺失
        if(product.getProductName()==null||product.getProductNumber()==null){
            log.debug("添加产品失败"+" 必要信息没有填写");
            json.setSuccess(false);
            json.setMsg("添加产品失败"+" 必要信息产品名称或指定处理人没有填写");
        }
        else{
            //核心语句。判断操作是否成功
//            int result= campaignService.addCampaign(campaign);
            int result = productService.addProduct(product);
            if (result > 0){
                log.debug("添加产品成功");
                json.setSuccess(true);
            }else {
                log.debug("添加产品失败");
                json.setSuccess(false);
                json.setMsg("添加产品失败");
            }
        }
        return json;
    }

    //更新产品
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public Object updateProduct(Product product){
        Json json = new Json();
        if (product.getProductName() == null||product.getProductNumber()==null){
            log.debug("更新产品失败"+":id不能为空");
            json.setSuccess(false);
            json.setMsg("更新差评失败"+":id不能为空");
        }else {
            int result = productService.updateProduct(product);

            if (result > 0){
                log.debug("更新产品"+product.getProductName()+"成功");
                json.setSuccess(true);
            }else {
                log.debug("更新产品失败");
                json.setSuccess(false);
                json.setMsg("更新产品失败");
            }
        }
        return json;
    }

    //跳转到产品详情页面
    //异常处理
    @RequestMapping(value = "/{productId}",method = RequestMethod.GET)
    public String getProduct(@PathVariable("productId")String productId){
        if (productId == null){
            return "/404";
        }
        return "/product/"+productId;
    }

    //获取产品详情
    @RequestMapping(value = "/{productId}",method = RequestMethod.POST)
    @ResponseBody
    public Object getProductDetail(@PathVariable("productId")Integer productId){
        Json json = new Json();
        if (productId == null){
            log.debug("产品详情获取失败"+":id不准确");
            json.setSuccess(false);
            json.setMsg("产品详情获取失败"+":id不准确");
            return json;
        }


        Product product = productService.getProduct(productId);

        if (product != null){
            log.debug("查询产品"+productId+"成功");
            json.setSuccess(true);
            json.setObj(product);
        }else {
            log.debug("查询产品"+productId+"失败");
            json.setSuccess(false);
            json.setMsg("查询产品"+productId+"失败");
        }
        return json;
    }

}
