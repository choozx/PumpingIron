package com.fp.pi.tips;

import java.util.List;

import java.util.Map;


public interface TipsMapper {
	


	List<community_review> reviews();
	
	community_review getDetail(community_review cr);
	
	public abstract int writeCon(community_review cr);

	public int delete(community_review cr);

	public int update(community_review cr);

	List<community_review> getMsgCount(Selector search);

	int getReply(community_review_reply crr);
	int getmsgcount();

	List<community_review_reply> replys(community_review_reply crr);

	int delReply(community_review_reply crr);

	int upReply(community_review_reply crr);

	int views(community_review cr);

	void likeOfTips();

	HeartDTO likeOfTips(Map<String, String> vals);

	int likeOfTipsInsert(HeartDTO vals);

	int likeOfTipsDelete(HeartDTO vals);

	int allLike(community_review aa);
	

}
