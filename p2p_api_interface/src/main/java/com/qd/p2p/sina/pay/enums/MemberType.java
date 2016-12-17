package com.qd.p2p.sina.pay.enums;

public enum MemberType {

	person(1, "个人会员"),
	company(2, "企业会员");

	int memberType;
	String memberName;
	
	MemberType(int memberType, String memberName) {
		this.memberType = memberType;
		this.memberName = memberName;
	}

	public static MemberType getMemberByType(int type){
		for(MemberType entry: MemberType.values()){
			if(entry.memberType == type){
				return entry;
			}
		}
		return person;
	}
	
	@Override
	public String toString() {
		return String.valueOf(memberType);
	}
	
}
