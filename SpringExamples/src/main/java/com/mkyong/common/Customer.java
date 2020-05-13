package com.mkyong.common;
 
public class Customer 
{
	private Address address1;

	public Address getAddress() {
		return address1;
	}

	public void setAddress(Address address) {
		this.address1 = address;
	}

	@Override
	public String toString() {
		return "Customer [address=" + address1 + "]";
	}

}