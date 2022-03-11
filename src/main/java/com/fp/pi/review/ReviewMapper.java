package com.fp.pi.review;

import java.util.List;

import com.fp.pi.tips.community_review;

public interface ReviewMapper {

	List<community_review> reviews();

	int upload(community_review cr);

	

	
	
}
