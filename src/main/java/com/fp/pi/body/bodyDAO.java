package com.fp.pi.body;

import java.io.File;



import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fp.pi.SiteOption3;
import com.fp.pi.member.Member;
import com.fp.pi.member.MemberMapper;
import com.fp.pi.point.PointBean;
import com.fp.pi.point.PointMapper;
import com.fp.pi.review.Review2Mapper;
import com.fp.pi.review.community_review2;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class bodyDAO {
	
	@Autowired
	private SqlSession ss;

	@Autowired
	private SiteOption3 so3;
	
private int allMsgCount;
	
	public int getAllMsgCount() {
		allMsgCount = ss.getMapper(BodyMapper.class).getmsgcount();
		return allMsgCount;
	}
	public void setAllMsgCount(int allMsgCount) {
		this.allMsgCount = allMsgCount;
	}

	
	public void getMsg(int pageNo, HttpServletRequest req) {
		allMsgCount = ss.getMapper(BodyMapper.class).getmsgcount();	
		int count = so3.getSnsCountPerpage();
		int start = (pageNo - 1) * count + 1;  // 0
		int end = start + (count - 1);   		//	1

		Selector3 search = (Selector3) req.getSession().getAttribute("search");
		int msgCount = 0;

		if (search == null) {
			search = new Selector3("", new BigDecimal(start), new BigDecimal(end));
			msgCount = getContent(req); // 전체 개시글 수     
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
		}
		
		List<body_review> reviews = ss.getMapper(BodyMapper.class).getMsgCount(search);
		for (body_review r : reviews) {
			System.out.println(r.getBr_no()+"----");
			r.setBr_like(likeCnt(req, r));
		/*	if(r.getBr_like() % 3 == 0) {
				PointBean p = new
				ss.getMapper(PointMapper.class).pushPoint(p);
			}*/
			r.setBr_bodyProfile(getReply2(req,r) + "");
			System.out.println(r.getBr_like() +"~~~~~~~");
			
		}
		
		
		req.setAttribute("bodys", reviews);
		int pageCount = (int) Math.ceil(msgCount / (double) count);
		System.out.println(msgCount);
		System.out.println(count);
		req.setAttribute("pageCount", pageCount);
		System.out.println(pageCount);
		req.setAttribute("curPage", pageNo);
	}
	
	

	
	public int getContent(HttpServletRequest req) {
		List<body_review> reviews = ss.getMapper(BodyMapper.class).reviews();
		allMsgCount = reviews.size();
		System.out.println(allMsgCount);
		return reviews.size();
	}

	public void insertCon(HttpServletRequest req, body_review cr) {
		try {
		System.out.println(cr.getBr_title());	
		Member mmm = (Member) req.getSession().getAttribute("loginMember");
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		if (successToken != null && token.equals(successToken)) {
			return;
		}
		cr.setBr_nickname(mmm.getM_name());
		cr.setBr_tips("zz");
		cr.setBr_bodyProfile("0");
		cr.setBr_productReview("굿");
		cr.setBr_email(mmm.getM_email());
		
		if (ss.getMapper(BodyMapper.class).writeCon(cr) == 1) {
			req.setAttribute("result", "등록성공");
			req.getSession().setAttribute("successToken", token);
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록실패");
			
		}
		
	
	}

	public body_review getDetail(HttpServletRequest req, body_review cr) {
		body_review body = ss.getMapper(BodyMapper.class).getDetail(cr);
	    req.setAttribute("tippp", body);	
	    return body;
	}

	public String getSummorJSON(HttpServletRequest request) {
		  // 이미지 업로드할 경로
		String uploadPath = request.getSession().getServletContext().getRealPath("resources/file");
		System.out.println(uploadPath);
	    int size = 10 * 1024 * 1024;  // 업로드 사이즈 제한 10M 이하
		
		String fileName = ""; // 파일명
		
		try{
	        // 파일업로드 및 업로드 후 파일명 가져옴
			MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
			Enumeration files = multi.getFileNames();
			String file = (String)files.nextElement(); 
			fileName = multi.getFilesystemName(file); 
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	    // 업로드된 경로와 파일명을 통해 이미지의 경로를 생성
		uploadPath = "resources/file/" + fileName;
		
	    // 생성된 경로를 JSON 형식으로 보내주기 위한 설정
		JSONObject jobj = new JSONObject();
		jobj.put("url", uploadPath);
		
		return jobj.toJSONString();
	}

	public void delete(HttpServletRequest req, body_review cr) {

		System.out.println(cr.getBr_content());
		String iii = req.getParameter("iii");
		System.out.println(iii);
		iii = iii.replace("resources/file/", "");
		System.out.println(iii);
		
		try {
			
			if (ss.getMapper(BodyMapper.class).delete(cr) == 1) {
				req.setAttribute("result", "삭제성공");
				String path = req.getSession().getServletContext().getRealPath("resources/file");
				new File(path + "/" + iii).delete();
				System.out.println("삭제성공");
			} else {
				req.setAttribute("result", "삭제실패");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "db서버문제");
		}
		
		
		
	}

	public void update(HttpServletRequest req, body_review cr) {
		
		System.out.println(cr.getBr_content());
		String iii = req.getParameter("iii");
		System.out.println(iii);
		iii = iii.replace("resources/file/", "");
		System.out.println(cr.getBr_title());
		System.out.println(cr.getBr_content());
		System.out.println(cr.getBr_no());
		
		try {
			if (ss.getMapper(BodyMapper.class).update(cr) == 1) {
				
				/*if (cr.getCr_content() != null) {  //이미지 존재할경우 
						String path = req.getSession().getServletContext().getRealPath("resources/file");
						new File(path + "/" + iii).delete(); // 기존이미지 삭제 
					cr.getCr_content();
						
					
				}else { // 이미지 없을경우
					cr.getCr_content();
				}*/

				
				
				req.setAttribute("result", "글수정성공");
			} else {
				req.setAttribute("result", "글수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "db서버문제");
		}
	}
	public void writeReply(HttpServletRequest req, body_review_reply crr, body_review cr) {
		try {
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken2");
			
		if (successToken != null && token.equals(successToken)) {
				return;
			}

			System.out.println("++++++++++++++++++++++++++++++++++++");
			
			
		Member m = (Member) req.getSession().getAttribute("loginMember");
		crr.setBrr_br_nickname(m.getM_name());
		System.out.println(crr.getBrr_br_no());
		crr.setBrr_text(req.getParameter("brr_text"));
		System.out.println("=================================");
		System.out.println(crr.getBrr_br_nickname());
		System.out.println(crr.getBrr_text());
		System.out.println(crr.getBrr_no());
		
		if (ss.getMapper(BodyMapper.class).getReply(crr) == 1) {
			req.setAttribute("result", "댓글쓰기성공");
			req.getSession().setAttribute("successToken2", token);

			
		} else {
			req.setAttribute("result", "댓글쓰기실패");
		}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "db문제");		}
		
	}
	
	
	public void getReply(HttpServletRequest req, body_review_reply crr) {
		
		
		crr.setBrr_br_no(Integer.parseInt(req.getParameter("br_no")));
		List<body_review_reply> replyss = ss.getMapper(BodyMapper.class).replys(crr);
		for (body_review_reply rr : replyss) {
			System.out.println(rr);
		}
		req.setAttribute("re", replyss);
		req.setAttribute("recnt", replyss.size());
	}
	
	public int getReply2(HttpServletRequest req, body_review cr) {
		return ss.getMapper(BodyMapper.class).replys2(cr);
	}
	
	
	public void delReply(HttpServletRequest req, body_review_reply crr) {
		
	try {
		System.out.println("======================");
		System.out.println(crr.getBrr_no());
			
			if (ss.getMapper(BodyMapper.class).delReply(crr) == 1) {
				req.setAttribute("result", "삭제성공");
				System.out.println("삭제성공");
			} else {
				req.setAttribute("result", "삭제실패");
				System.out.println("삭제실패");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "db서버문제");
		}
		
		
	}
	public void updateReply(HttpServletRequest req, body_review_reply crr) {

		
		try {
			if (ss.getMapper(BodyMapper.class).upReply(crr) == 1) {
				
				req.setAttribute("result", "댓글 수정성공");
				System.out.println("댓글수정 성공");
			} else {
				req.setAttribute("result", "댓글 수정실패");
				System.out.println("댓글수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "db서버문제");
			System.out.println("db 서버문제");
		}
		
	}
	public void viewCount(HttpServletRequest req, body_review cr) {
		String token = req.getParameter("token4");
		System.out.println(req.getParameter("token4") + ":D"); 
		String successToken = (String) req.getSession().getAttribute("successToken4");
	    System.out.println("토큰 값111" + token);
	    System.out.println("--------------111" + successToken);
		if (successToken != null) {
			if (token.equals(successToken)) {
				
				return;
			}	
		}
	    
	    req.getSession().setAttribute("successToken4", token);
	    System.out.println("토큰 값222" + token);
	    System.out.println("--------------222" + successToken);
		ss.getMapper(BodyMapper.class).views(cr);
		
		
		}
	public int likeCnt(HttpServletRequest req, body_review cr) {
		int likeCnt =  ss.getMapper(BodyMapper.class).allLike2(cr);
		cr.setBr_like(likeCnt);
		ss.getMapper(BodyMapper.class).likePush2(cr);
		return likeCnt;
		
		
		
	}
	
	public int likeOfTips(HttpServletRequest req) {
		Map<String, String> vals = new HashMap<String, String>();
		String aa = req.getParameter("ajaxId");
		String bb = req.getParameter("ajaxEmail");
		
		vals.put("idd", aa);
		vals.put("emaill", bb);
		
		HeartDTO3 heart = ss.getMapper(BodyMapper.class).likeOfTips(vals);
		System.out.println(heart);
	
		if(heart == null) {
			return 0;
		}else {
			return 1;
		}
		
	}
	
	public int likeOfTipsUpdate(HttpServletRequest req) {
		
		int aa = Integer.parseInt(req.getParameter("ajaxId"));
		String bb = req.getParameter("ajaxEmail");
		HeartDTO3 h = new HeartDTO3(0, aa, bb);
		System.out.println(aa);
		System.out.println(bb);
		System.out.println(h.getH3_br_no());
		System.out.println(h.getH3_m_email());
		
		int val = Integer.parseInt(req.getParameter("val"));
		if(val == 0) {
			ss.getMapper(BodyMapper.class).likeOfTipsInsert(h);
			body_review cr = new body_review();
			cr.setBr_no(aa);
			// 하트 누른 그 게시글에 하트 몇갠지
			if(likeCnt(req, cr) % 2 == 0) {
				body_review body = getDetail(req, cr);
				PointBean p = new PointBean();
				p.setP_no(body.getBr_no());
				p.setP_email(body.getBr_email());
				p.setP_type("body");
				PointBean pb = ss.getMapper(PointMapper.class).getPoint(p);
				if(pb == null) {
					p.setP_check(2);
					ss.getMapper(PointMapper.class).pushPoint(p);
					ss.getMapper(PointMapper.class).pushPointMember(p);
	
				} else {
					if(likeCnt(req, cr) != pb.getP_check()) {
						ss.getMapper(PointMapper.class).updatePoint(p);
						pb = ss.getMapper(PointMapper.class).getPoint(p);
						p.setP_check(pb.getP_check());
						ss.getMapper(PointMapper.class).pushPointMember(p);
					}
					
				}
				
			}
				
				
				}else {
			ss.getMapper(BodyMapper.class).likeOfTipsDelete(h);
		}
		return likeOfTips(req);
	}

		
	

}
