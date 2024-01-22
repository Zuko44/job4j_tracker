package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();
    private final Logger logger = LoggerFactory.getLogger(Item.class);

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            logger.error("Error, item not saved", ex);
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(Integer id, Item item) {
        Session session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            Query query = session.createQuery(
                    "UPDATE items SET name = :fName WHERE id = :fId");
            query.setParameter("fName", item.getName())
                    .setParameter("fId", id);
            result = query.executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            logger.error("Error, item not replaced", ex);
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void delete(Integer id) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery(
                            "DELETE items WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            logger.error("Error, item not deleted", ex);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        List<Item> items = new ArrayList<>();
        try {
            session.beginTransaction();
            items = session.createQuery("from Item", Item.class).list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            logger.error("Error, items not found", ex);
        } finally {
            session.close();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        List<Item> items = new ArrayList<>();
        try {
            session.beginTransaction();
            items = session.createQuery("from items where name=:login", Item.class)
                    .setParameter("login", key)
                    .list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            logger.error("Error, items not found", ex);
        } finally {
            session.close();
        }
        return items;
    }

    @Override
    public Item findById(Integer id) {
        Session session = sf.openSession();
        Item item = null;
        try {
            session.beginTransaction();
            item = session.createQuery(
                            "from items as i where i.id = :fId", Item.class)
                    .setParameter("fId", id)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            logger.error("Error, item not found", ex);
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
