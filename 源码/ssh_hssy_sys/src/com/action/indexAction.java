package com.action;



import java.util.List;
import java.util.Map;


import com.dao.TCatelogDAO;
import com.dao.TGoodsDAO;
import com.model.TCatelog;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class indexAction extends ActionSupport
{
	private TGoodsDAO goodsDAO;
	
	private TCatelogDAO catelogDAO;
	
	
	
	//ÍøÕ¾Ê×Ò³
	public String index()
	{
		String ff="from TCatelog where catelogDel='no'";
		List cateLogList=catelogDAO.getHibernateTemplate().find(ff);
		
		Map session=ActionContext.getContext().getSession();
		session.put("cateLogList", cateLogList);
		return ActionSupport.SUCCESS;
	}
	

	public TGoodsDAO getGoodsDAO()
	{
		return goodsDAO;
	}

	public void setGoodsDAO(TGoodsDAO goodsDAO)
	{
		this.goodsDAO = goodsDAO;
	}



	public TCatelogDAO getCatelogDAO()
	{
		return catelogDAO;
	}


	public void setCatelogDAO(TCatelogDAO catelogDAO)
	{
		this.catelogDAO = catelogDAO;
	}

	
}
