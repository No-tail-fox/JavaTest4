package Exam1.dao;

import Exam1.domain.Customer;
import Exam1.domain.Film;
import Exam1.domain.MapperEntity;
import Exam1.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("musicDao")
public interface MusicDao {
    void deleteById(int customer_id);
    Object findByAddress(String address);
    void insertCustomer(Customer customer);
    ArrayList<Film> findByPage(Page page);
    void updateById(Customer customer);
    Object login(Customer customer);

    MapperEntity findById(int id);
    Film findByFilmId(int id);
    int insertFilm(Film film);
    Film findByTitle(int filmId);
}
