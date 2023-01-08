package io.marabezzi.jwtsecuritycrud.user;

public enum RoleType {
  ADMIN(1, "ROLE_ADMIN"), USER(2, "ROLE_USER"), VIEWER(3, "ROLE_VIEWER");
	
	private long cod;
	private String desc;
	
	private RoleType(long cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}
	
	public long getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
}
