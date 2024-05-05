package com.baitapjava.trangtintuc.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.baitapjava.trangtintuc.Entity.Baibao;
import com.baitapjava.trangtintuc.Repository.BaibaoRepository;
@Service
public class BaibaoServiceImpl implements BaibaoService {
	@Autowired
	private BaibaoRepository res;
	@Override
	public Baibao thembaibaomoi(String tenbaibao, String ngaydang, MultipartFile anh,
			String noidung, String tacgia, String theloai, int luotxem) throws IOException {
		Baibao baibao = new Baibao();
		baibao.setTenbaibao(tenbaibao);
		baibao.setNgaydang(ngaydang);
		baibao.setAnh(anh.getBytes());
		baibao.setNoidung(noidung);
		baibao.setTacgia(tacgia);
		baibao.setTheloai(theloai);
		baibao.setLuotxem(luotxem);
		return res.save(baibao);
	}

	@Override
	public Baibao suabaibao(int id, String tenbaibao, String ngaydang, MultipartFile anh,
			String noidung, String tacgia, String theloai, int luotxem) throws IOException {
		Baibao baoedit = res.findById(id).orElse(null);
		baoedit.setTenbaibao(tenbaibao);
		baoedit.setNgaydang(ngaydang);
		baoedit.setAnh(anh.getBytes());
		baoedit.setNoidung(noidung);
		baoedit.setTacgia(tacgia);
		baoedit.setTheloai(theloai);
		baoedit.setLuotxem(luotxem);
		baoedit = res.save(baoedit);
		return baoedit ;
	}

	@Override
	public void xoabaibao(int id) {
		res.deleteById(id);
		
	}

	@Override
	public List<Baibao> allbaibao() {
		
		return res.findAll();
	}

	@Override
	public Baibao onebaibao(int id) {
		Baibao onebaibao = res.findById(id).orElse(null);
		onebaibao.setLuotxem(onebaibao.getLuotxem() + 1);
		res.save(onebaibao);
		return onebaibao;
	}

	@Override
	public List<Baibao> searchBaibao(String search) {
		
		return res.searchBaibao(search);
	}

	@Override
	public Page<Baibao> listBaoPaging(String search,int pageNumber, int pageSize) {
		Pageable pagingBaiBao = PageRequest.of(pageNumber, pageSize);
		return res.listBaoPaging(search, pagingBaiBao);
	}

	@Override
	public List<Baibao> listLienQuan(String theloai, int id) {
		
		return res.listLienQuan(theloai, id);
	}
	
	@Override
	public List<Baibao> listNoiBat() {
		
		return res.listNoiBat();
	}		

	@Override
	public List<Baibao> listTheLoai(String theloai) {
		
		return res.listTheLoai(theloai);
	}

	@Override
	public Baibao suabaibao2(int id, Baibao baibao) {
		Baibao baoedit = res.findById(id).orElse(null);
		baoedit.setTenbaibao(baibao.getTenbaibao());
		baoedit.setNgaydang(baibao.getNgaydang());
		baoedit.setAnh(baibao.getAnh());
		baoedit.setNoidung(baibao.getNoidung());
		baoedit.setTacgia(baibao.getTacgia());
		baoedit.setTheloai(baibao.getTheloai());
		baoedit.setLuotxem(baibao.getLuotxem());
		baoedit = res.save(baoedit);
		return baoedit ;
	}


}
