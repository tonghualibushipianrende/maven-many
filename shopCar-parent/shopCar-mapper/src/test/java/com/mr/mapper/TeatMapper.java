package com.mr.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-common.xml"})
public class TeatMapper {
	
		@Autowired
		private GoodsMapper goodsMapper;
		
		@Test
		public void test(){
			Integer queryGoodsCount = goodsMapper.queryGoodsCount();
			System.err.println(queryGoodsCount);
		}

}
