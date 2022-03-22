package com.fp.pi.review;

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

import com.fp.pi.SiteOption2;
import com.fp.pi.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class reviewDAO {
	
	@Autowired
	private SqlSession ss;

	@Autowired
	private SiteOption2 so2;
	
private int allMsgCount;
	
	public int getAllMsgCount() {
		allMsgCount = ss.getMapper(Review2Mapper.class).getmsgcount();
		return allMsgCount;
	}
	public void setAllMsgCount(int allMsgCount) {
		this.allMsgCount = allMsgCount;
	}

	
	public void getMsg(int pageNo, HttpServletRequest req) {
		allMsgCount = ss.getMapper(Review2Mapper.class).getmsgcount();	
		int count = so2.getSnsCountPerpage();
		int start = (pageNo - 1) * count + 1;  // 0
		int end = start + (count - 1);   		//	1

		Selector2 search = (Selector2) req.getSession().getAttribute("search");
		int msgCount = 0;

		if (search == null) {
			search = new Selector2("", new BigDecimal(start), new BigDecimal(end));
			msgCount = getContent(req); // 전체 개시글 수     
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
		}
		
		List<community_review2> reviews = ss.getMapper(Review2Mapper.class).getMsgCount(search);
		for (community_review2 r : reviews) {
			System.out.println(r.getC2_no()+"----");
			r.setC2_like(likeCnt(req, r));
			r.setC2_bodyProfile(getReply2(req,r) + "");
			System.out.println(r.getC2_like() +"~~~~~~~");
			
		}
		
		
		req.setAttribute("reviews", reviews);
		int pageCount = (int) Math.ceil(msgCount / (double) count);
		System.out.println(msgCount);
		System.out.println(count);
		req.setAttribute("pageCount", pageCount);
		System.out.println(pageCount);
		req.setAttribute("curPage", pageNo);
	}
	
	

	
	public int getContent(HttpServletRequest req) {
		List<community_review2> reviews = ss.getMapper(Review2Mapper.class).reviews();
		allMsgCount = reviews.size();
		System.out.println(allMsgCount);
		return reviews.size();
	}

	public void insertCon(HttpServletRequest req, community_review2 cr) {
		try {
		System.out.println(cr.getC2_title());	
		Member mmm = (Member) req.getSession().getAttribute("loginMember");
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		if (successToken != null && token.equals(successToken)) {
			return;
		}
		cr.setC2_nickname(mmm.getM_name());
		cr.setC2_tips("zz");
		cr.setC2_bodyProfile("aaaa");
		cr.setC2_productReview("굿");
		cr.setC2_email("zzz");
		
		if (ss.getMapper(Review2Mapper.class).writeCon(cr) == 1) {
			req.setAttribute("result", "등록성공");
			req.getSession().setAttribute("successToken", token);
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록실패");
			
		}
		
	
	}

	public void getDetail(HttpServletRequest req, community_review2 cr) {
		
	    req.setAttribute("tippp", ss.getMapper(Review2Mapper.class).getDetail(cr));	
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

	public void delete(HttpServletRequest req, community_review2 cr) {

		System.out.println(cr.getC2_content());
		String iii = req.getParameter("iii");
		System.out.println(iii);
		iii = iii.replace("resources/file/", "");
		System.out.println(iii);
		
		try {
			
			if (ss.getMapper(Review2Mapper.class).delete(cr) == 1) {
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

	public void update(HttpServletRequest req, community_review2 cr) {
		
		System.out.println(cr.getC2_content());
		String iii = req.getParameter("iii");
		System.out.println(iii);
		iii = iii.replace("resources/file/", "");
		System.out.println(cr.getC2_title());
		System.out.println(cr.getC2_content());
		System.out.println(cr.getC2_no());
		
		try {
			if (ss.getMapper(Review2Mapper.class).update(cr) == 1) {
				
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
	public void writeReply(HttpServletRequest req, community_review2_reply crr, community_review2 cr) {
		try {
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken2");
			
		if (successToken != null && token.equals(successToken)) {
				return;
			}

			System.out.println("++++++++++++++++++++++++++++++++++++");
			
			
		Member m = (Member) req.getSession().getAttribute("loginMember");
		crr.setC2r_c2_nickname(m.getM_name());
		System.out.println(crr.getC2r_c2_no());
		crr.setC2r_text(req.getParameter("c2r_text"));
		System.out.println("=================================");
		System.out.println(crr.getC2r_c2_nickname());
		System.out.println(crr.getC2r_text());
		System.out.println(crr.getC2r_no());
		
		if (ss.getMapper(Review2Mapper.class).getReply(crr) == 1) {
			req.setAttribute("result", "댓글쓰기성공");
			req.getSession().setAttribute("successToken2", token);

			
		} else {
			req.setAttribute("result", "댓글쓰기실패");
		}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "db문제");		}
		
	}
	
	
	public void getReply(HttpServletRequest req, community_review2_reply crr) {
		
		
		crr.setC2r_c2_no(Integer.parseInt(req.getParameter("c2_no")));
		List<community_review2_reply> replyss = ss.getMapper(Review2Mapper.class).replys(crr);
		for (community_review2_reply rr : replyss) {
			System.out.println(rr);
		}
		req.setAttribute("re", replyss);
		req.setAttribute("recnt", replyss.size());
	}
	
	public int getReply2(HttpServletRequest req, community_review2 cr) {
		return ss.getMapper(Review2Mapper.class).replys2(cr);
	}
	
	
	public void delReply(HttpServletRequest req, community_review2_reply crr) {
		
	try {
		System.out.println("======================");
		System.out.println(crr.getC2r_no());
			
			if (ss.getMapper(Review2Mapper.class).delReply(crr) == 1) {
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
	public void updateReply(HttpServletRequest req, community_review2_reply crr) {

		
		try {
			if (ss.getMapper(Review2Mapper.class).upReply(crr) == 1) {
				
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
	public void viewCount(HttpServletRequest req, community_review2 cr) {
		String token = req.getParameter("token3");
		System.out.println(req.getParameter("token3") + ":D"); 
		String successToken = (String) req.getSession().getAttribute("successToken3");
	    System.out.println("토큰 값111" + token);
	    System.out.println("--------------111" + successToken);
		if (successToken != null) {
			if (token.equals(successToken)) {
				
				return;
			}	
		}
	    
	    req.getSession().setAttribute("successToken3", token);
	    System.out.println("토큰 값222" + token);
	    System.out.println("--------------222" + successToken);
		ss.getMapper(Review2Mapper.class).views(cr);
		
		
		}
	public int likeCnt(HttpServletRequest req, community_review2 cr) {
		return ss.getMapper(Review2Mapper.class).allLike(cr);
	}
	
	public int likeOfTips(HttpServletRequest req) {
		Map<String, String> vals = new HashMap<String, String>();
		String aa = req.getParameter("ajaxId");
		String bb = req.getParameter("ajaxEmail");
		
		vals.put("idd", aa);
		vals.put("emaill", bb);
		
		HeartDTO2 heart = ss.getMapper(Review2Mapper.class).likeOfTips(vals);
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
		HeartDTO2 h = new HeartDTO2(0, aa, bb);
		System.out.println(aa);
		System.out.println(bb);
		System.out.println(h.getH2_c2_no());
		System.out.println(h.getH2_m_email());
		
		int val = Integer.parseInt(req.getParameter("val"));
		if(val == 0) {
			ss.getMapper(Review2Mapper.class).likeOfTipsInsert(h);
		}else {
			ss.getMapper(Review2Mapper.class).likeOfTipsDelete(h);
		}
		return likeOfTips(req);
	}

		
	

}
