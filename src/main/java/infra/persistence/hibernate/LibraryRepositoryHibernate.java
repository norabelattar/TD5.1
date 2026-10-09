package infra.persistence.hibernate;

import domain.Library;
import domain.LibraryName;
import domain.LibraryRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LibraryRepositoryHibernate implements LibraryRepository {
    private static final Logger logger = LoggerFactory.getLogger(LibraryRepositoryHibernate.class.getName());

    @Override
    public Library findByName(LibraryName name) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Library.class, name);
        } catch (Exception e) {
            logger.error("Error while trying to find library by name: " + name, e);
        }
        return null;
    }

    @Override
    public void saveOrUpdate(Library library) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(library); // Méthode Obsolete qui fera l'affaire pour ce TP

            transaction.commit();
        } catch (Exception e) {
            logger.error("Error while trying to save library: " + library, e);
            if (transaction != null) {
                transaction.rollback();
            }

            throw e;
        }
    }
}
