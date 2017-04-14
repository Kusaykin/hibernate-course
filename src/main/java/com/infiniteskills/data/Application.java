package com.infiniteskills.data;

import com.infiniteskills.data.entities.User;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.*;

/**
 * Created by din on 14.03.17.
 */
public class Application {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        final List<Long> ids = new ArrayList<Long>();
        ids.add(new Long(3));
        ids.add(new Long(4));
        ids.add(new Long(5));
        Query q = session.createQuery("from User where userId in (:id)");
        q.setParameterList("id", ids);
        List<User> users = q.list();
        /*User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedDate(new Date());
        user.setCreatedBy("steve");
        user.setEmailAddress("steve@mail.com");
        user.setFirstName("Stive");
        user.setLastName("Konor");
        user.setLastUpdatedBy("stive");
        user.setLastUpdatedDate(new Date());
        session.save(user);
        session.getTransaction().commit();*/
        session.close();
    }
}
