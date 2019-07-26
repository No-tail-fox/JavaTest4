package Exam1.service;

import Exam1.domain.*;

import java.util.ArrayList;
import java.util.List;

public interface MusicService {
    public List<MusicInfo> getMusicInfo(MusicInfo musicInfo);
    public MapperEntity findById(int id);

    public void deleteById(int customer_id);
    public Object findByAddress(String address);
    public int insertCustomer(Customer customer);
    public ArrayList<Film> findByPage(Page page);
    public void updateById(Customer customer);
    public Object login(Customer customer);
}
