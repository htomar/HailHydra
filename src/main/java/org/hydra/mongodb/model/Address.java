package org.hydra.mongodb.model;

public class Address {

	private String address1;
    private String address2;
    public Address(){}
    public Address(String a1, String a2){
        
        this.address1=a1;
        this.address2=a2;
    }
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

}
