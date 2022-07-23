package com.gamesmall.daos;

import com.gamesmall.entities.Pregunta;
import com.gamesmall.hibernate.cfg.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PreguntaDAO {

    private Session session;
    private Transaction transaction;

    private void initOperation() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    private void throwsException(HibernateException he) throws HibernateException {
        transaction.rollback();
        throw new HibernateException("An Error has ocurred", he);
    }

    public void save(Pregunta pregunta) {
        try {
            initOperation();
            session.save(pregunta);
            transaction.commit();
        } catch (HibernateException he) {
            throwsException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    public void update(Pregunta pregunta) {
        try {
            initOperation();
            session.update(pregunta);
            transaction.commit();
        } catch (HibernateException he) {
            throwsException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    public void delete(Pregunta pregunta) {
        try {
            initOperation();
            session.delete(pregunta);
            transaction.commit();
        } catch (HibernateException he) {
            throwsException(he);
            throw he;
        } finally {
            session.close();
        }
    }

    public Pregunta getOneById(int id) {
        Pregunta pregunta = null;

        try {
            initOperation();
            pregunta = (Pregunta) session.get(Pregunta.class, id);
        } finally {
            session.close();
        }
        
        return pregunta;
    }
}
