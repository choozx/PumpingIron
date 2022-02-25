package com.fp.pi.tips;

import java.util.List;

public interface TipsMapper {
	
	List<community_review> reviews();
	
	community_review getDetail(community_review cr);
	
	public abstract int writeCon(community_review cr);

	

	

}
