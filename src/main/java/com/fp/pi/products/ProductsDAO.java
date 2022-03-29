package com.fp.pi.products;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fp.pi.SiteOption;
import com.fp.pi.SiteOption2;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class ProductsDAO {
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private SiteOption2 so;
	
	private int allProductCount;
	
	public int getAllProductCount() {
		return allProductCount;
	}

	public void setAllProductCount(int allProductCount) {
		this.allProductCount = allProductCount;
	}

	
	public void getProducts(int pageNo, HttpServletRequest request) {
		try {
			String p_type = request.getParameter("p_type");
			
			allProductCount = ss.getMapper(ProductsMapper.class).getproductcount(p_type);
			int count = so.getSnsCountPerpage();
			int start = (pageNo - 1) * count + 1;
			int end = start + (count - 1);
			
			ProductSort ps = (ProductSort) request.getSession().getAttribute("search");
			int productCount = 0;
			
			ps = new ProductSort("p_name", p_type, "",new BigDecimal(1) ,new BigDecimal(start), new BigDecimal(end));
			productCount = allProductCount; // 전체 개시글 수
			
			System.out.println(ps.getP_sort());
			request.setAttribute("products", ss.getMapper(ProductsMapper.class).getProductSort(ps));
			
			int pageCount = (int) Math.ceil(productCount / (double) count);
			request.setAttribute("pageCount", pageCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getProductDetail(Product p, HttpServletRequest request) {
		try {
			request.setAttribute("productDetail", ss.getMapper(ProductsMapper.class).getProduct(p));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void IncreaseBuyCount(Product p, HttpServletRequest request) {
		
		try {
			if (ss.getMapper(ProductsMapper.class).increaseBuyCount(p) == 1) {
				request.setAttribute("result", "성공");
			} else {
				request.setAttribute("result", "실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "실패");
		}
	}

	public Products getProductsSort(ProductSort ps, HttpServletRequest request) {
		
		allProductCount = ss.getMapper(ProductsMapper.class).getproductcount(ps.getP_type());
		
		int pageNo = ps.getPageNo().intValue();
		
		int count = so.getSnsCountPerpage();
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);
		
		int productCount = allProductCount;
		
		ps.setStart(new BigDecimal(start));
		ps.setEnd(new BigDecimal(end));
		
		if (ps.getP_sort().equals("p_priceToLow")) {
			ps.setP_sort("p_price");
			ps.setOrder("ASC");
		} else if(ps.getP_sort().equals("p_priceTohigh")) {
			ps.setP_sort("p_price");
			ps.setOrder("DESC");
		} else if(ps.getP_sort().equals("p_cnt")) {
			ps.setOrder("DESC");			
		}
		
		
		List<Product> product = ss.getMapper(ProductsMapper.class).getProductSort(ps);
		
		int pageCount = (int) Math.ceil(productCount / (double) count);
		request.setAttribute("pageCount", pageCount);
				
		Products p = new Products(product);
		return p;
	}

	public void regProduct(Product p, HttpServletRequest request) {
		try {
			String saveDerectory = request.getSession().getServletContext().getRealPath("resources/file");
			MultipartRequest mr = new MultipartRequest(request, saveDerectory, 1024 * 1024 * 30, "UTF-8", new DefaultFileRenamePolicy());
			
			p.setP_name(mr.getParameter("p_name"));
			int p_price = Integer.parseInt(mr.getParameter("p_price"));
			p.setP_price(p_price);
			p.setP_type(mr.getParameter("p_type"));
			p.setP_info(mr.getParameter("p_info"));
			p.setP_img(mr.getFilesystemName("p_img"));
			
			System.out.println(mr.getFilesystemName("p_img"));
			
			if (ss.getMapper(ProductsMapper.class).regProduct(p)==1) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delProduct(HttpServletRequest request) {
		String p_no = request.getParameter("p_no");
		System.out.println(p_no);
		
		if (ss.getMapper(ProductsMapper.class).delProduct(p_no)==1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");			
		}
	}

	public void updateProduct(Product p, HttpServletRequest request) {
		try {
			String saveDerectory = request.getSession().getServletContext().getRealPath("resources/file");
			MultipartRequest mr = new MultipartRequest(request, saveDerectory, 1024 * 1024 * 30, "UTF-8", new DefaultFileRenamePolicy());
			
			p.setP_name(mr.getParameter("p_name"));
			int p_price = Integer.parseInt(mr.getParameter("p_price"));
			int p_no = Integer.parseInt(mr.getParameter("p_no"));
			p.setP_no(p_no);
			p.setP_price(p_price);
			p.setP_type(mr.getParameter("p_type"));
			p.setP_info(mr.getParameter("p_info"));
			p.setP_img(mr.getFilesystemName("p_img"));
			
			if (ss.getMapper(ProductsMapper.class).updateProduct(p)==1) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
