package com.mr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mr.entity.Goods;
import com.mr.mapper.GoodsMapper;
import com.mr.service.GoodsService;
import com.mr.util.Page;
import com.mr.util.RedisUtil;

@Service
public class GoodsServiceImpl implements GoodsService{
		
		@Autowired
		private GoodsMapper goodsMapper;

		@Override
		public void queryGoods(Page pageUtil) {
			Integer countItem=goodsMapper.queryGoodsCount();
			pageUtil.setCountItem(countItem);
			List<Goods> list=goodsMapper.queryGoodsList(pageUtil);
//			for (int i = 0; i < list.size(); i++) {
//				Goods goods = (Goods) RedisUtil.getObject("goods_"+list.get(i).getGoodsId());
//				list.set(i, goods);
//			}
			pageUtil.setList(list);
		}

}
