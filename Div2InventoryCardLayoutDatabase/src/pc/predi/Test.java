package pc.predi;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import pc.predi.InventorySystemDivsionCardLayout.WeaponVariantsTable.WeaponVariants;

public class Test {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("1");
		
		Iterator<String> i = set.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		EntityManager em = Persistence.createEntityManagerFactory("SelectStatements").createEntityManager();
		em.getTransaction().begin();
		//List<WeaponVariants> test = em.createQuery("select :field FROM WeaponVariants").getResultList();
		String field = "ACR";
		field = "WeaponVariant";
		String table = "WeaponVariants";
//		String selectQuery = "select " + field +  "FROM " +  " WHERE ";
//		Query query = em.createQuery("select WeaponType FROM WeaponVariants a WHERE a.WeaponVariant = :field");
//		query.setParameter("field", field);
//		List<Object> test = query.getResultList();
		//Query query = em.createQuery("select " + field + " FROM " + table);
		Query query = em.createQuery("select distinct WeaponType from WeaponVariants");
		List<Object> test = query.getResultList();
//		@SuppressWarnings("unchecked")
//		List<String> test = query.getResultList();
		String[] arrayST = new String[test.size()];
//		for(Object w : test) {
//			System.out.println(w);
		test.toArray(arrayST);
		
//		}
//		for(int index = 0; index < arrayST.length; index++) {
//			arrayST[index] = test.get(index).toString();
//		}
		for(String s : arrayST) {
			System.out.println(s);
		}
//		for(String s : test) {
//			System.out.println(s);
//		}
		em.close();
	}
	
	static void selectStatement() {
		EntityManager em = Persistence.createEntityManagerFactory("SelectStatements").createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select distinct WeaponType from WeaponVariants");
		List<Object> test = query.getResultList();
		for (Object w : test) {
			System.out.println(w);
		}
		em.close();
	}
	
	static void selectStatementParameter() {
		EntityManager em = Persistence.createEntityManagerFactory("SelectStatements").createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select WeaponType FROM WeaponVariants a WHERE a.WeaponVariant = :field");
		String field = "ACR";
		query.setParameter("field", field);
		List<Object> test = query.getResultList();
		for (Object w : test) {
			System.out.println(w);
		}
		em.close();
	}
	
	static void selectStatementCovertToString() {
		EntityManager em = Persistence.createEntityManagerFactory("SelectStatements").createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select distinct WeaponType from WeaponVariants");
		List<Object> test = query.getResultList();
		String[] arrayST = new String[test.size()];
		for(int index = 0; index < arrayST.length; index++) {
			arrayST[index] = test.get(index).toString();
		}
		for(String s : arrayST) {
			System.out.println(s);
		}
		em.close();
	}
}
