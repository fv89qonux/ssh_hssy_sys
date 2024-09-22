package com.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TCatelogDAO;
import com.dao.TGoodsDAO;
import com.dao.TOrderItemDAO;
import com.model.TGoods;
import com.opensymphony.xwork2.ActionSupport;

public class goodsAction extends ActionSupport
{
	private Integer goodsId;
	private Integer catelogId;
	private String goodsName;

	private String goodsJieshao;
	private String fujian;
	private Integer goodsShichangjia;
	private Integer goodsTejia;
	private Integer kucun;

	private String fabushi;
	private String goodsDel;
	
	private String message;
	private String path;
	
	private TGoodsDAO goodsDAO;
	private TOrderItemDAO orderItemDAO;
	
	
	
	public String goodsAdd()
	{
		TGoods goods=new TGoods();
		
		goods.setCatelogId(catelogId);
		goods.setGoodsName(goodsName);
		goods.setGoodsJieshao(goodsJieshao);
		
		goods.setGoodsPic(fujian);
		goods.setGoodsShichangjia(goodsShichangjia);
		goods.setGoodsTejia(goodsShichangjia);
		goods.setKucun(kucun);
		goods.setFabushi(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
		goods.setGoodsDel("no");
		
		goodsDAO.save(goods);
		this.setMessage("操作成功");
		this.setPath("goodsMana.action");
		return "succeed";
		
	}
	
	
	public String goodsDel()
	{
		TGoods goods=goodsDAO.findById(goodsId);
		goods.setGoodsDel("yes");
		goodsDAO.attachDirty(goods);
		this.setMessage("操作成功");
		this.setPath("goodsMana.action");
		return "succeed";
	}
	
	
	public String goodsMana()
	{
		String sql="from TGoods where goodsDel='no'";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}
	
	

	public String goodsEditPre()
	{
		TGoods goods=goodsDAO.findById(goodsId);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}
	
	
	public String goodsEdit()
	{
		TGoods goods=goodsDAO.findById(goodsId);
		
		goods.setCatelogId(catelogId);
		goods.setGoodsName(goodsName);
		goods.setGoodsJieshao(goodsJieshao);
		
		goods.setGoodsPic(fujian);
		goods.setGoodsShichangjia(goodsShichangjia);
		goods.setGoodsTejia(goodsShichangjia);
		goods.setKucun(kucun);
		
		goodsDAO.attachDirty(goods);
		
		this.setMessage("操作成功");
		this.setPath("goodsMana.action");
		return "succeed";
	}
	
	
	
	
	public String goodsDetailHou()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		TGoods goods=goodsDAO.findById(goodsId);
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String goodsDetailQian()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		TGoods goods=goodsDAO.findById(goodsId);
		request.put("goods", goods);
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	public String goodsAll()
	{
        HttpServletRequest request=ServletActionContext.getRequest();
		
        String sql="from TGoods where goodsDel='no' order by catelogId";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		
		
		request.setAttribute("goodsList", goodsList);
		return ActionSupport.SUCCESS;
		
	}
	
	
	
	
	public String goods_catelog()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TGoods where goodsDel='no' and catelogId=?";
		Object[] con={catelogId};
		List goodsList=goodsDAO.getHibernateTemplate().find(sql,con);
		request.put("goodsList", goodsList);
		
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	//服装查询
	public String goodsSearch()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TGoods where goodsDel='no' and goodsName like '%"+goodsName.trim()+"%'";
		
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		request.put("goodsList", goodsList);
		
		return ActionSupport.SUCCESS;
	}

	public String goodsNew()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TGoods where goodsDel='no' order by fabushi desc";
		
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		
		if(goodsList.size()>8)
		{
			goodsList=goodsList.subList(0, 8);
		}
		
		request.put("goodsList", goodsList);
		
		return ActionSupport.SUCCESS;
	}

	
	public String goodsPaihang()
	{
        Map request=(Map)ServletActionContext.getContext().get("request");
		
        List goodsList=new ArrayList();
		String sql="select sum(goodsQuantity),goodsId from TOrderItem group by goodsId order by sum(goodsQuantity) desc";
		List list=orderItemDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<list.size();i++)
		{
			Object[] b=(Object[])list.get(i);
			int goodsId=Integer.parseInt(b[1].toString());
			System.out.println(goodsId+"&&");
			TGoods goods=goodsDAO.findById(goodsId);
			goodsList.add(goods);
		}
		if(goodsList.size()>8)
		{
			goodsList=goodsList.subList(0, 8);
		}
		
		request.put("goodsList", goodsList);
		
		return ActionSupport.SUCCESS;
	}


	public String goodsSelect()
	{
		String sql="from TGoods where goodsDel='no'";
		List goodsList=goodsDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return ActionSupport.SUCCESS;
	}

	public Integer getKucun()
	{
		return kucun;
	}




	public void setKucun(Integer kucun)
	{
		this.kucun = kucun;
	}




	public Integer getCatelogId()
	{
		return catelogId;
	}




	public void setCatelogId(Integer catelogId)
	{
		this.catelogId = catelogId;
	}




	public String getFabushi()
	{
		return fabushi;
	}




	public void setFabushi(String fabushi)
	{
		this.fabushi = fabushi;
	}




	public String getFujian()
	{
		return fujian;
	}




	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}




	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}




	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}




	public String getGoodsDel()
	{
		return goodsDel;
	}




	public void setGoodsDel(String goodsDel)
	{
		this.goodsDel = goodsDel;
	}




	public Integer getGoodsId()
	{
		return goodsId;
	}




	public void setGoodsId(Integer goodsId)
	{
		this.goodsId = goodsId;
	}




	public String getGoodsJieshao()
	{
		return goodsJieshao;
	}




	public void setGoodsJieshao(String goodsJieshao)
	{
		this.goodsJieshao = goodsJieshao;
	}




	public String getGoodsName()
	{
		return goodsName;
	}




	public void setGoodsName(String goodsName)
	{
		this.goodsName = goodsName;
	}




	public Integer getGoodsShichangjia()
	{
		return goodsShichangjia;
	}




	public void setGoodsShichangjia(Integer goodsShichangjia)
	{
		this.goodsShichangjia = goodsShichangjia;
	}




	public Integer getGoodsTejia()
	{
		return goodsTejia;
	}




	public void setGoodsTejia(Integer goodsTejia)
	{
		this.goodsTejia = goodsTejia;
	}




	public String getMessage()
	{
		return message;
	}




	public void setMessage(String message)
	{
		this.message = message;
	}




	public TOrderItemDAO getOrderItemDAO()
	{
		return orderItemDAO;
	}




	public void setOrderItemDAO(TOrderItemDAO orderItemDAO)
	{
		this.orderItemDAO = orderItemDAO;
	}




	public String getPath()
	{
		return path;
	}




	public void setPath(String path)
	{
		this.path = path;
	}
	
	
}
