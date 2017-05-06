package cn.reader.book.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.reader.book.dao.CategoryDao;
import cn.reader.book.entity.BigCategory;
import cn.reader.book.entity.SmallCategory;
import cn.reader.core.base.BaseDao;
import cn.reader.core.base.BaseServiceImpl;
import cn.reader.core.page.PageModel;


// 此处表示自动完成事物的开始和提交
@Transactional
// 注册CategoryServiceImpl为一个名为：categoryService的逻辑业务，在action中的名称要一致
@Service("categoryService")
public class CaregoryServiceImpl extends BaseServiceImpl implements ICategoryService {

	// 注入大类别Dao
	@Resource
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	/************** 大类别管理 ***********************/
	@Override
	public List<BigCategory> findbgclist() throws Exception {
		// TODO Auto-generated method stub
		return this.categoryDao.findbgclist();
	}
	
	/**
	 * 分页查询所有大类别,按大类别名称查询
	 */
	@Override
	public void findbgcbybgcName(PageModel<BigCategory> bigCategory, String bgcName) throws Exception {
		this.categoryDao.findbgcbybgcName(bigCategory, bgcName);
	}
	
	@Override
	public void delbgcbyid(String bid) {
		// TODO Auto-generated method stub
		this.categoryDao.delete(BigCategory.class, bid);
	}
	
	
	@Override
	public BigCategory findbgcbyId(String id) throws Exception {
		
		// TODO Auto-generated method stub
		return this.categoryDao.findbgcbyId(id);
	}
	
	//判断大类编号或大类名称是否已存在
	@Override
	public String bgclist(String bgcId, String bgcName) throws Exception {
		// TODO Auto-generated method stub
		return this.categoryDao.bgclist(bgcId, bgcName);
	}

	
	@Override
	public void savebgc(BigCategory bigCategory) throws Exception {
		// TODO Auto-generated method stub
		this.categoryDao.save(bigCategory);
	}

	@Override
	public void updatebgc(BigCategory bigCategory) throws Exception {
		// TODO Auto-generated method stub
		this.categoryDao.updatebgc(bigCategory);
	}
	
	/*******************************************/

	/************** 小类别管理 ***********************/
	
	@Override
	public void findslc(PageModel<SmallCategory> smallCategory, String bgcName,String slcName) throws Exception {
		// TODO Auto-generated method stub

		this.categoryDao.findslc(smallCategory,bgcName,slcName);
	}


	@Override
	public List<SmallCategory> findslcbybid(String bid) throws Exception {
		// TODO Auto-generated method stub
		return this.categoryDao.findslcbybid(bid);
	}
	
	//删除小类组
	@Override
	public void delscllist(List<SmallCategory> scllist) throws Exception {
		// TODO Auto-generated method stub
		if(scllist!=null&&scllist.size()>0){
			for(int i=0;i<scllist.size();i++)
				this.delslcbyid(scllist.get(i).getId());
				
		}
		
		
	}
	
	//删除小类
	@Override
	public void delslcbyid(String sid) {
		// TODO Auto-generated method stub
		this.categoryDao.delete(SmallCategory.class, sid);
	}
	

	@Override
	public SmallCategory findslcbyId(String id) throws Exception {
		// TODO Auto-generated method stub
		return this.categoryDao.findslcbyId(id);
	}

	
	@Override
	public void updateslc(SmallCategory smallCategory) throws Exception {
		// TODO Auto-generated method stub
		this.categoryDao.updateslc(smallCategory);
	}
	

	@Override
	public String slclist(String slcId, String slcName) throws Exception {
		// TODO Auto-generated method stub
		return this.categoryDao.slclist(slcId, slcName);
	}
	
	@Override
	public void saveslc(SmallCategory smallCategory) throws Exception {
		// TODO Auto-generated method stub
		this.categoryDao.save(smallCategory);
	}

	/*******************************************/

	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 动态获取所有大类
	 */
	@Override
	public List<BigCategory> findAllBigcategory() throws Exception {
		return this.categoryDao.findAllBigcategory();
	}

	/**
	 * 根据大类id查询对应小类
	 */
	@Override
	public List<SmallCategory> getSmallcategoryByBigcategoryId(String id) throws Exception {
		return this.categoryDao.getSmallcategoryByBigcategoryId(id);
	}



}