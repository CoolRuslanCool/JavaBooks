package ru.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.entities.Book;
import ru.enums.RestrictionAlready;
import ru.enums.RestrictionSearch;
import ru.enums.RestrictionYear;
import ru.filters.SearchFilter;
import ru.interfaces.BookDAO;

import java.util.List;

/**
 * Created by ruslan on 13.10.17.
 */

@Repository
public class BookDAOImpl implements BookDAO {
    @Autowired
    private SessionFactory sessionFactory;
    private DetachedCriteria detachedCriteria;

    @Override
    @Transactional
    @Deprecated
    @SuppressWarnings("unchecked")
    public List<Book> allBooks(SearchFilter searchFilter) {
        detachedCriteria = DetachedCriteria.forClass(Book.class);
        countRows(searchFilter);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class);
        criteria.setFirstResult(searchFilter.getFirst());
        criteria.setMaxResults(searchFilter.getBookOnPage());
        return criteria.list();
    }

    @Override
    @Transactional
    @Deprecated
    @SuppressWarnings("unchecked")
    public List<Book> booksBySearch(SearchFilter searchFilter) {
        detachedCriteria = DetachedCriteria.forClass(Book.class);
        if (searchFilter.getSearchString() == null || (searchFilter.getSearchString().trim().length() < 1 && searchFilter.getRestrictionAlready().equals(RestrictionAlready.ALL))) {
            return allBooks(searchFilter);
        }
        if (searchFilter.getRestrictionSearch().equals(RestrictionSearch.TITLE)) {
            addRestrictionTitle(searchFilter);
        }
        if (searchFilter.getRestrictionSearch().equals(RestrictionSearch.AUTHOR)) {
            addRestrictionAuthor(searchFilter);
        }
        if (searchFilter.getYear().trim().length() != 0) {
            addRestrictionYear(searchFilter);
        }
        if (!searchFilter.getRestrictionAlready().equals(RestrictionAlready.ALL)) {
            addRestrictionAlready(searchFilter);
        }
        countRows(searchFilter);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Book.class);
        if (searchFilter.getRestrictionSearch().equals(RestrictionSearch.TITLE)) {
            addRestrictionTitle(criteria, searchFilter);
        }
        if (searchFilter.getRestrictionSearch().equals(RestrictionSearch.AUTHOR)) {
            addRestrictionAuthor(criteria, searchFilter);
        }
        if (searchFilter.getYear().trim().length() != 0) {
            addRestrictionYear(criteria, searchFilter);
        }
        if (!searchFilter.getRestrictionAlready().equals(RestrictionAlready.ALL)) {
            addRestrictionAlready(criteria, searchFilter);
        }
        criteria.setFirstResult(searchFilter.getFirst());
        criteria.setMaxResults(searchFilter.getBookOnPage());

        return criteria.list();
    }

    @Override
    @Transactional
    @Deprecated
    public Book bookById(int id) {
        return (Book) sessionFactory.getCurrentSession().createCriteria(Book.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        sessionFactory.getCurrentSession().update(book);
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        sessionFactory.getCurrentSession().createQuery("delete Book where id=" + id).executeUpdate();
    }

    private void addRestrictionAlready(SearchFilter searchFilter) {
        if (searchFilter.getRestrictionAlready().equals(RestrictionAlready.IS_ALREADY)) {
            detachedCriteria.add(Restrictions.eq("readAlready", (byte) 1));
        }
        if (searchFilter.getRestrictionAlready().equals(RestrictionAlready.NOT_ALREADY)) {
            detachedCriteria.add(Restrictions.eq("readAlready", (byte) 0));
        }
    }

    private void addRestrictionYear(SearchFilter searchFilter) {
        if (searchFilter.getRestrictionYear().equals(RestrictionYear.LE)) {
            detachedCriteria.add(Restrictions.le("printYear", Integer.valueOf(searchFilter.getYear().trim())));
        } else if (searchFilter.getRestrictionYear().equals(RestrictionYear.GE)) {
            detachedCriteria.add(Restrictions.ge("printYear", Integer.valueOf(searchFilter.getYear().trim())));
        } else
            detachedCriteria.add(Restrictions.eq("printYear", Integer.valueOf(searchFilter.getYear().trim())));

    }

    private void addRestrictionAuthor(SearchFilter searchFilter) {
        detachedCriteria.add(Restrictions.ilike("author", searchFilter.getSearchString(), MatchMode.ANYWHERE));
    }

    private void addRestrictionTitle(SearchFilter searchFilter) {
        detachedCriteria.add(Restrictions.ilike("title", searchFilter.getSearchString(), MatchMode.ANYWHERE));
    }



    private void addRestrictionAlready(Criteria criteria, SearchFilter searchFilter) {
        if (searchFilter.getRestrictionAlready().equals(RestrictionAlready.IS_ALREADY)) {
            criteria.add(Restrictions.eq("readAlready", (byte) 1));
        }
        if (searchFilter.getRestrictionAlready().equals(RestrictionAlready.NOT_ALREADY)) {
            criteria.add(Restrictions.eq("readAlready", (byte) 0));
        }
    }

    private void addRestrictionYear(Criteria criteria, SearchFilter searchFilter) {
        if (searchFilter.getRestrictionYear().equals(RestrictionYear.LE)) {
            criteria.add(Restrictions.le("printYear", Integer.valueOf(searchFilter.getYear().trim())));
        } else if (searchFilter.getRestrictionYear().equals(RestrictionYear.GE)) {
            criteria.add(Restrictions.ge("printYear", Integer.valueOf(searchFilter.getYear().trim())));
        } else
            criteria.add(Restrictions.eq("printYear", Integer.valueOf(searchFilter.getYear().trim())));

    }

    private void addRestrictionAuthor(Criteria criteria, SearchFilter searchFilter) {
        criteria.add(Restrictions.ilike("author", searchFilter.getSearchString(), MatchMode.ANYWHERE));
    }

    private void addRestrictionTitle(Criteria criteria, SearchFilter searchFilter) {
        criteria.add(Restrictions.ilike("title", searchFilter.getSearchString(), MatchMode.ANYWHERE));
    }


    private void countRows(SearchFilter searchFilter) {
        Criteria criteria = detachedCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        searchFilter.setTotalBook(((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue());
    }
}
