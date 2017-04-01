package com.primaryschool.home.service.impl;

import org.springframework.stereotype.Service;

import com.primaryschool.global.util.PageHelper;
import com.primaryschool.home.service.IPageHelperService;

@Service
public class PageHelperService implements IPageHelperService {
	
	@Override
	public String createToolBar(int total, int pageSize, String url, int index) {
		// TODO Auto-generated method stub
		PageHelper   phelper=new PageHelper();
		//设置总记录数
		phelper.setTotal(total);
		//设置每页显示记录数量
		phelper.setPageSize(pageSize);
		//设置当前页码
		int p=index;
		phelper.setIndex(p);
		//设置url
        String turl=url;
        //去掉 url中的单引号
        turl=turl.replace("'", "");
		phelper.setPath(turl); 
		//获取导航条
		String toolBar=phelper.getPageHTML();
		return toolBar;
	}

}
