package com.fp.pi.tips;

import java.io.File;

import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fp.pi.SiteOption;
import com.fp.pi.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class tipsDAO {

	@Autowired
	private SqlSession ss;
	
	@Autowired
	private SiteOption so;
	
	
private int allMsgCount;
	
	public int getAllMsgCount() {
		allMsgCount = ss.getMapper(TipsMapper.class).getmsgcount();
		return allMsgCount;
	}
	public void setAllMsgCount(int allMsgCount) {
		this.allMsgCount = allMsgCount;
	}

	
	public void getMsg(int pageNo, HttpServletRequest req) {
		allMsgCount = ss.getMapper(TipsMapper.class).getmsgcount();	
		int count = so.getSnsCountPerpage();
		int start = (pageNo - 1) * count + 1;  // 0
		int end = start + (count - 1);   		//	1

		Selector search = (Selector) req.getSession().getAttribute("search");
		int msgCount = 0;

		if (search == null) {
			search = new Selector("", new BigDecimal(start), new BigDecimal(end));
			msgCount = getContent(req); // 전체 개시글 수     
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
		}
		
		List<community_review> reviews = ss.getMapper(TipsMapper.class).getMsgCount(search);
		
		req.setAttribute("reviews", reviews);
		int pageCount = (int) Math.ceil(msgCount / (double) count);
		System.out.println(msgCount);
		System.out.println(count);
		req.setAttribute("pageCount", pageCount);
		System.out.println(pageCount);
		req.setAttribute("curPage", pageNo);
	}
	
	

	public int getContent(HttpServletRequest req) {
		List<community_review> reviews = ss.getMapper(TipsMapper.class).reviews();
		allMsgCount = reviews.size();
		return reviews.size();
	}

	public void insertCon(HttpServletRequest req, community_review cr) {
		try {
		System.out.println(cr.getCr_title());	
		Member mmm = (Member) req.getSession().getAttribute("loginMember");
		
		cr.setCr_nickname(mmm.getM_name());
		cr.setCr_tips("zz");
		cr.setCr_bodyProfile("aaaa");
		cr.setCr_productReview("굿");
		cr.setCr_email("zzz");
	
		if (ss.getMapper(TipsMapper.class).writeCon(cr) == 1) {
			req.setAttribute("result", "등록성공");
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "등록실패");
			
		}
		
	
	}

	public void getDetail(HttpServletRequest req, community_review cr) {
		
	req.setAttribute("tippp", ss.getMapper(TipsMapper.class).getDetail(cr));	
		
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

	public void delete(HttpServletRequest req, community_review cr) {

		System.out.println(cr.getCr_content());
		String iii = req.getParameter("iii");
		System.out.println(iii);
		iii = iii.replace("resources/file/", "");
		System.out.println(iii);
		
		try {
			
			if (ss.getMapper(TipsMapper.class).delete(cr) == 1) {
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

	public void update(HttpServletRequest req, community_review cr) {
		
		System.out.println(cr.getCr_content());
		String iii = req.getParameter("iii");
		System.out.println(iii);
		iii = iii.replace("resources/file/", "");
		System.out.println(cr.getCr_title());
		System.out.println(cr.getCr_content());
		System.out.println(cr.getCr_no());
		
		try {
			if (ss.getMapper(TipsMapper.class).update(cr) == 1) {
				
				
				
				req.setAttribute("result", "글수정성공");
			} else {
				req.setAttribute("result", "글수정실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "db서버문제");
		}
	}
	public void writeReply(HttpServletRequest req, community_review_reply crr, community_review cr) {
		try {
			String token = req.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("successToken");
			
			if (successToken != null && token.equals(successToken)) {
				return;
			}

			
		Member m = (Member) req.getSession().getAttribute("loginMember");
		crr.setCrr_cr_nickname(m.getM_name());
		crr.setCrr_cr_no(Integer.parseInt(req.getParameter("cr_no")));
		crr.setCrr_text(req.getParameter("crr_text"));
		System.out.println("=================================");
		System.out.println(crr.getCrr_cr_nickname());
		System.out.println(crr.getCrr_text());
		System.out.println(crr.getCrr_no());
		
		if (ss.getMapper(TipsMapper.class).getReply(crr) == 1) {
			req.setAttribute("result", "댓글쓰기성공");
			req.getSession().setAttribute("successToken", token);

			
		} else {
			req.setAttribute("result", "댓글쓰기실패");
		}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "db문제");		}
		
	}
	
	
	public void getReply(HttpServletRequest req, community_review_reply crr) {
		
		
		crr.setCrr_cr_no(Integer.parseInt(req.getParameter("cr_no")));
		List<community_review_reply> replyss = ss.getMapper(TipsMapper.class).replys(crr);
		req.setAttribute("re", replyss);
		req.setAttribute("recnt", replyss.size());
	}
	
	
	
	
	public void delReply(HttpServletRequest req, community_review_reply crr) {
		
	try {
		System.out.println("======================");
		System.out.println(crr.getCrr_no());
			
			if (ss.getMapper(TipsMapper.class).delReply(crr) == 1) {
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
	public void updateReply(HttpServletRequest req, community_review_reply crr) {

		
		try {
			if (ss.getMapper(TipsMapper.class).upReply(crr) == 1) {
				
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
	public void viewCount(HttpServletRequest req, community_review cr) {
		
		ss.getMapper(TipsMapper.class).views(cr);
		
	}
		
	}
