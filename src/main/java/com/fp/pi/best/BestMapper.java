package com.fp.pi.best;

import java.util.List;
import java.util.Map;

import com.fp.pi.best.Selector4;
import com.fp.pi.body.HeartDTO3;
import com.fp.pi.body.body_review;
import com.fp.pi.review.community_review2;

public interface BestMapper {

public List<body_review> bestFromBody();

public List<community_review2> bestFromReview2();
	
List<BestBean> getMsgCount(Selector4 search);

int allLike(BestBean aa);

int replys2(BestBean cr);
 
int getmsgcount();

List<BestBean> reviews();

int views(BestBean cr);

public HeartDTO3 likeOfTips(Map<String, String> vals);

int likeOfTipsInsert(HeartDTO3 h);

int likeOfTipsDelete(HeartDTO3 h);



int detail(BestBean cr);

public body_review getDetailBody(BestBean br);

public community_review2 getDetailReview2(BestBean c2);

	
}
