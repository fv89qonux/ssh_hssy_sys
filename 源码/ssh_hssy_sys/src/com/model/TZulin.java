package com.model;

/**
 * TZulin generated by MyEclipse Persistence Tools
 */

public class TZulin implements java.io.Serializable
{

	private Integer id;
	private int goodsId;
	private String kehuming;
	private String shenfenzheng;

	private String kaishishijian;
	private Integer yajin;
	private String beizhu;
	private String shifouhuan;//�Ƿ�
	
	private String jieshushijian;
	private Integer feiyong;
	
	private TGoods goods;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public TGoods getGoods() {
		return goods;
	}

	public void setGoods(TGoods goods) {
		this.goods = goods;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getKehuming() {
		return kehuming;
	}

	public String getShifouhuan() {
		return shifouhuan;
	}

	public void setShifouhuan(String shifouhuan) {
		this.shifouhuan = shifouhuan;
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
	
}