package com.fp.pi.review;

import java.util.List;



import java.util.Map;

import com.fp.pi.body.body_review;


public interface Review2Mapper {


	List<community_review2> reviews();
	
	community_review2 getDetail2(community_review2 cr);
	
	public abstract int writeCon(community_review2 cr);

	public int delete(community_review2 cr);

	public int update(community_review2 cr);

	List<community_review2> getMsgCount(Selector2 search);

	int getReply(community_review2_reply crr);
	int getmsgcount();

	List<community_review2_reply> replys(community_review2_reply crr);

	int delReply(community_review2_reply crr);

	int upReply(community_review2_reply crr);

	int views(community_review2 cr);

	void likeOfTips();

	HeartDTO2 likeOfTips(Map<String, String> vals);

	int likeOfTipsInsert(HeartDTO2 vals);

	int likeOfTipsDelete(HeartDTO2 vals);

	int allLike(community_review2 aa);

	int replys2(community_review2 cr);

	int likePush(community_review2 cr);



	
	
}
