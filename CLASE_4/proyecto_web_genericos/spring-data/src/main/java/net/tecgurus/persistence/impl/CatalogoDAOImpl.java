package net.tecgurus.persistence.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.persistence.CatalogoDAO;
import net.tecgurus.persistence.dao.impl.GenericDAOImpl;

@Repository
@Transactional
public class CatalogoDAOImpl extends GenericDAOImpl<CatalogoGeneral, Integer> implements CatalogoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void queryTest() {
		Object o = sessionFactory.getCurrentSession().get(CatalogoGeneral.class, new Integer(2));
		System.out.println(o);
	}

	@Override
	public List<CatalogoGeneral> findAll() {
		/*
		 * String hql = "Select c from CatalogoGeneral c"; Query q =
		 * sessionFactory.getCurrentSession().createQuery("");
		 * List<CatalogoGeneral> l = q.list(); return l;
		 */
		return sessionFactory.getCurrentSession().createQuery("Select c from CatalogoGeneral c").list();
	}

	@Override
	public CatalogoGeneral findById(Integer id) {
		CatalogoGeneral c = (CatalogoGeneral) sessionFactory.getCurrentSession().get(CatalogoGeneral.class, id);
		return c;
	}



	@Override
	public List<CatalogoGeneral> findByDscCrt(String dsc) {
		/*
		 * String hql =
		 * "Select c From CatalogoGeneral c WHERE c.dscCorCat = :dsclocal";
		 * Query q = sessionFactory.getCurrentSession().createQuery(hql);
		 * q.setParameter("dsclocal", dsc); //q.setParameter(1, dsc);
		 * List<CatalogoGeneral> list = q.list(); return list;
		 */
		Criteria c = sessionFactory.getCurrentSession().createCriteria(CatalogoGeneral.class);
		c = c.add(Restrictions.ilike("dscCorCat", dsc));
		List<CatalogoGeneral> l = c.list();
		return l;
	}

	@Override
	public List<CatalogoGeneral> findByDscCrtAndDscCmp(String dscCrt, String dscCmp) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(CatalogoGeneral.class);
		c = c.add(Restrictions.ilike("dscCorCat", dscCrt));
		c = c.add(Restrictions.ilike("dscComCat", dscCmp));
		List<CatalogoGeneral> l = c.list();
		return l;
	}

}
