package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TGoodsDAO;
import com.dao.TZulinDAO;
import com.model.TZulin;
import com.opensymphony.xwork2.ActionSupport;

public class zulinAction extends ActionSupport
{
	private Integer id;
	private int goodsId;
	private String kehuming;
	private String shenfenzheng;

	private String kaishishijian;
	private Integer yajin;
	private String beizhu;
	private String shifouhuan;
	
	private String jieshushijian;
	private Integer feiyong;
	
	private TGoodsDAO goodsDAO;
	private TZulinDAO zulinDAO;
	
	public String zulinAdd()
	{
		TZulin zulin=new TZulin();
		
		zulin.setGoodsId(goodsId);
		zulin.setKehuming(kehuming);
		zulin.setShenfenzheng(shenfenzheng);
		zulin.setKaishishijian(kaishishijian);
		
		zulin.setYajin(yajin);
		zulin.setBeizhu(beizhu);
		zulin.setShifouhuan("否");
		zulin.setJieshushijian("");
		
		zulin.setFeiyong(0);
		
		zulinDAO.save(zulin);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "租赁信息添加成功");
		return "msg";
	}
	
	
	public String zulinMana()
	{
		String sql="from TZulin order by shifouhuan";
		List zulinList=zulinDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<zulinList.size();i++)
		{
			TZulin zulin=(TZulin)zulinList.get(i);
			zulin.setGoods(goodsDAO.findById(zulin.getGoodsId()));
		}
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("zulinList", zulinList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String zulinDel()
	{
		TZulin zulin=zulinDAO.findById(id);
		zulinDAO.delete(zulin);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "租赁信息删除成功");
		return "msg";
	}
	
	
	public String zulinHuan()
	{
		TZulin zulin=zulinDAO.findById(id);
		zulin.setShifouhuan("是");
		zulin.setJieshushijian(jieshushijian);
		zulin.setFeiyong(feiyong);
		
		zulinDAO.attachDirty(zulin);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "租赁信息删除成功");
		return "msg";
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getGoodsId() {
		return goodsId;
	}


	public String getShifouhuan() {
		return shifouhuan;
	}


	public void setShifouhuan(String shifouhuan) {
		this.shifouhuan = shifouhuan;
	}


	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}


	public String getKehuming() {
		return kehuming;
	}


	public void setKehuming(String kehuming) {
		this.kehuming = kehuming;
	}


	public String getShenfenzheng() {
		return shenfenzheng;
	}


	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}


	public String getKaishishijian() {
		return kaishishijian;
	}


	public void setKaishishijian(String kaishishijian) {
		this.kaishishijian = kaishishijian;
	}


	public Integer getYajin() {
		return yajin;
	}


	public void setYajin(Integer yajin) {
		this.yajin = yajin;
	}


	public String getBeizhu() {
		return beizhu;
	}


	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}


	public String getJieshushijian() {
		return jieshushijian;
	}


	public void setJieshushijian(String jieshushijian) {
		this.jieshushijian = jieshushijian;
	}


	public Integer getFeiyong() {
		return feiyong;
	}


	public void setFeiyong(Integer feiyong) {
		this.feiyong = feiyong;
	}


	public TGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}


	public void setGoodsDAO(TGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}


	public TZulinDAO getZulinDAO() {
		return zulinDAO;
	}


	public void setZulinDAO(TZulinDAO zulinDAO) {
		this.zulinDAO = zulinDAO;
	}
	
}
