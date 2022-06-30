package com.pos.sale.controller;

import java.io.Serializable;
import java.util.Arrays;

import com.pos.accessories.controller.AddAccessoriesVO;
import com.pos.customer.controller.CustomerVO;
import com.pos.product.controller.ProductInventoryVO;

public class PosVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String saleId;
	private String invoiceNo;
	private String imei;
	private String productId;
	private String quantity;
	private String price;
	private String amount;
	private String discount;
	private String productName;
	private String promoDiscount;
	private String[] discountList;
	private String[] quantityList;
	private String category;

	private ProductInventoryVO otherBrand = new ProductInventoryVO();
	private CustomerVO customer = new CustomerVO();

	private AddAccessoriesVO accessories = new AddAccessoriesVO();
	private TradeinVO tradein =new TradeinVO();

	public String getPromoDiscount() {
		return promoDiscount;
	}

	public void setPromoDiscount(String promoDiscount) {
		this.promoDiscount = promoDiscount;
	}

	public String[] getQuantityList() {
		return quantityList;
	}

	public void setQuantityList(String[] quantityList) {
		this.quantityList = quantityList;
	}

	public ProductInventoryVO getOtherBrand() {
		return otherBrand;
	}

	public void setOtherBrand(ProductInventoryVO otherBrand) {
		this.otherBrand = otherBrand;
	}

	public String[] getDiscountList() {
		return discountList;
	}

	public void setDiscountList(String[] discountList) {
		this.discountList = discountList;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public CustomerVO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerVO customer) {
		this.customer = customer;
	}

	public AddAccessoriesVO getAccessories() {
		return accessories;
	}

	public void setAccessories(AddAccessoriesVO accessories) {
		this.accessories = accessories;
	}
	

	public TradeinVO getTradein() {
		return tradein;
	}

	public void setTradein(TradeinVO tradein) {
		this.tradein = tradein;
	}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "PosVO [saleId=" + saleId + ", invoiceNo=" + invoiceNo
				+ ", imei=" + imei + ", productId=" + productId + ", quantity="
				+ quantity + ", price=" + price + ", amount=" + amount
				+ ", discount=" + discount + ", productName=" + productName
				+ ", promoDiscount=" + promoDiscount + ", discountList="
				+ Arrays.toString(discountList) + ", quantityList="
				+ Arrays.toString(quantityList) + ", category=" + category
				+ ", otherBrand=" + otherBrand + ", customer=" + customer
				+ ", accessories=" + accessories + ", tradeinVO=" + tradein
				+ ", getPromoDiscount()=" + getPromoDiscount()
				+ ", getQuantityList()=" + Arrays.toString(getQuantityList())
				+ ", getOtherBrand()=" + getOtherBrand()
				+ ", getDiscountList()=" + Arrays.toString(getDiscountList())
				+ ", getProductName()=" + getProductName() + ", getCustomer()="
				+ getCustomer() + ", getAccessories()=" + getAccessories()
				+ ", getTradeinVO()=" + getTradein() + ", getSaleId()="
				+ getSaleId() + ", getInvoiceNo()=" + getInvoiceNo()
				+ ", getImei()=" + getImei() + ", getProductId()="
				+ getProductId() + ", getQuantity()=" + getQuantity()
				+ ", getPrice()=" + getPrice() + ", getAmount()=" + getAmount()
				+ ", getDiscount()=" + getDiscount() + ", getCategory()="
				+ getCategory() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public boolean equals(Object object) {
		System.out.println("Inside equals");
		boolean result = false;
		if (object == null || object.getClass() != getClass()) {
			System.out.println("Null Obj");
			result = false;
		} else {
			System.out.println("Not Null Obj");
			PosVO posVO = (PosVO) object;
			System.out.println("this.imei :"+ this.imei);
			System.out.println("posVO.getImei():"+ posVO.getImei());
			if (this.imei.equals(posVO.getImei())) {
				System.out.println("INside true");
				result = true;
			}
		}
		System.out.println("Inside equals return obj: "+result);
		return result;
	}
}
