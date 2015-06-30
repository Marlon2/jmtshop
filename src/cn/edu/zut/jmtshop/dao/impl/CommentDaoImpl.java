package cn.edu.zut.jmtshop.dao.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.edu.zut.jmtshop.dao.CommentDao;
import cn.edu.zut.jmtshop.entity.Comment;
import cn.edu.zut.jmtshop.entity.Product;

public class CommentDaoImpl extends HibernateDaoSupport implements CommentDao {

	@Override
	public int commentAdd(Comment comment) {
		try {
			this.getHibernateTemplate().save(comment);
			return 1;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int commentDelet(Comment comment) {
		try {
			this.getHibernateTemplate().delete(comment);
			return 1;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int commentDeletBeach(List<Comment> comments) {
		try {
			this.getHibernateTemplate().deleteAll(comments);
		    return 1;	
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Comment getCommentById(int id) {
		try {
			return (Comment) this.getHibernateTemplate().find(" from Comment where id = ?",id).get(0);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getCommentsCounts(String productName) {
		try {
			
			if(productName.trim().equals("")||productName==null){				
				Long rows = (Long) this.getHibernateTemplate().find(" select count(*) from Comment").get(0);
				return rows.intValue();
			}else{
				DetachedCriteria criteria = DetachedCriteria.forClass(Comment.class);
				criteria.add(Restrictions.in("product", getCommentByProductName(productName)));
				return this.getHibernateTemplate().findByCriteria(criteria).size();
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getCommentsPrePage(int first, int maxPrePage,String productName) {
		DetachedCriteria criteria =  DetachedCriteria.forClass(Comment.class);
		try {
			if(productName.trim().equals("")||productName==null){								
				return this.getHibernateTemplate().findByCriteria(criteria, first, maxPrePage);
			}else{
				List<Product> products = getCommentByProductName(productName);
				if(products.size()==0){
					return null;
				}else{
					
					criteria.add(Restrictions.in("product", products));
					return this.getHibernateTemplate().findByCriteria(criteria, first, maxPrePage);
				}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getCommentByProductName(String productName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.ilike("productname", productName,MatchMode.ANYWHERE));		
		try {
			return this.getHibernateTemplate().findByCriteria(criteria);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
