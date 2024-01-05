package location;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import max.RegistDTO;
@Component
public class LocationDAO {
	@Autowired
	SessionFactory sessionFactory;
	public 	List<StateBean> getState()
	{
		Session s = sessionFactory.openSession();
		 Transaction tx = s.beginTransaction();
		Criteria cr = s.createCriteria(StateBean.class);
		//cr.addOrder(Order.asc("stName"));
		tx.commit();
		List<StateBean> list= cr.list();
		//System.out.println("listdao "+list.size());
		 return list;
	}
	public 	List<DistBean> getDistList(String stcode)
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria cr = s.createCriteria(DistBean.class);
		cr.add(Restrictions.eq("stCode",stcode));
		cr.addOrder(Order.asc("distName"));
		tx.commit();
		List<DistBean> list= cr.list();
		System.out.println("listdao "+list.size());
		return list;
	}
	//data insert krne ke liye db me
	public boolean saveDetail(RegistDTO  registDTO)
	{
		Session s = sessionFactory.openSession();
		 Transaction tx = s.beginTransaction();
		Integer i = (Integer) s.save(registDTO);
		tx.commit();
		if(i>0)
			return true;
		
		return false;
			
	}
	//data view krne ke liye statecoce pr dist code
	public List<RegistDTO> viewDetail()
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria cr = s.createCriteria(RegistDTO.class);
		List<RegistDTO> list = cr.list();
		tx.commit();
		return list;	
	}
	// view kr liya ,,ab stcode ke base pr statename leke ana hai
	public String getStateNameByCode(int stCode)
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria cr = s.createCriteria(StateBean.class);
		cr.add(Restrictions.eq("stCode", stCode));
		tx.commit();
		List<StateBean> list = cr.list();
		return list.get(0).getStName();
				
	}
	//distcode pr dist name ,viewcontroller
	public String getDistNameByCode(String distCodee)
	{
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Criteria cr = s.createCriteria(DistBean.class);
		cr.add(Restrictions.eq("distCode", distCodee));
		tx.commit();
		List<DistBean> list = cr.list();
		return list.get(0).getDistName();
		
	}
	
}
