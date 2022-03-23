package com.fp.pi.body;

import java.util.List;



import java.util.Map;

import com.fp.pi.best.BestBean;
import com.fp.pi.review.community_review2;



public interface BodyMapper {


	List<body_review> reviews();
	
	body_review getDetail(body_review cr);
	
	public abstract int writeCon(body_review cr);

	public int delete(body_review cr);

	public int update(body_review cr);

	List<body_review> getMsgCount(Selector3 search);

	int getReply(body_review_reply crr);
	int getmsgcount();

	List<body_review_reply> replys(body_review_reply crr);

	int delReply(body_review_reply crr);

	int upReply(body_review_reply crr);

	int views(body_review cr);

	void likeOfTips();

	HeartDTO3 likeOfTips(Map<String, String> vals);

	int likeOfTipsInsert(HeartDTO3 vals);

	int likeOfTipsDelete(HeartDTO3 vals);

	int allLike2(body_review aa);

	int replys2(body_review cr);

	int likePush2(body_review cr);
	

	
}
