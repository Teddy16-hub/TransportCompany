package dao;

import configuration.SessionFactoryUtil;
import entity.Good;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GoodDAO {
    public static void saveGood(Good good){
        try(Session session = SessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(good);
            transaction.commit();
        }
    }

    public static void saveGoods(List<Good> goodList) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            goodList.stream().forEach(good -> session.save(good));
            transaction.commit();
        }
    }

    public static void saveOrUpdateGood(Good good){
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(good);
            transaction.commit();
        }
    }

    public static List<Good> readGoods() {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM Good a", Good.class).getResultList();
        }
    }

    public static Good getGood(long id) {
        Good good;
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            good = session.get(Good.class, id);
            transaction.commit();
        }
        return good;
    }

    public static void deleteGood(Good good) {
        try (Session session = configuration.SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(good);
            transaction.commit();
        }
    }
}
