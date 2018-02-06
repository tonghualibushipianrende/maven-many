package com.mr.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mr.entity.Goods;
import com.mr.service.GoodsService;
import com.mr.util.Page;
import com.mr.util.RedisUtil;

@Controller
@RequestMapping(value="goods")
public class GoodsController {
	
		@Autowired
		private GoodsService goodsService;
		
		@RequestMapping(value="queryGoods")
		@ResponseBody
		public Map queryGoods(Integer page,Integer rows,Page pageUtil){
			pageUtil.setCurrentPage(page);
			pageUtil.setPageItem(rows);
			goodsService.queryGoods(pageUtil);
			Map<String, Object> map=new HashMap<String,Object>();
			map.put("total", pageUtil.getCountItem());
			map.put("rows", pageUtil.getList());
			return map;
		}
		@RequestMapping(value="toGoodsInfo")
		public String toGoodsInfo(Integer goodsId,ModelMap map){
			System.out.println(goodsId);
			Goods goods = (Goods)RedisUtil.getObject("goods_"+goodsId);
			map.put("goods", goods);
			return "goods/goods-info";
		}
		
		

}
