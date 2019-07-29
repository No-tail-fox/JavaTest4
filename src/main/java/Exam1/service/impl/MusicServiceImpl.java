package Exam1.service.impl;

import Exam1.dao.MusicDao;
import Exam1.domain.*;
import com.github.pagehelper.PageHelper;
import Exam1.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("musicserviceimpl")
public class MusicServiceImpl implements MusicService {
    @Autowired
    MusicDao musicDao;
    @Override
    public List<MusicInfo> getMusicInfo(MusicInfo musicInfo) {
        return null;
    }

    @Override
    public MapperEntity findById(int id) {
        MapperEntity mapperEntity=musicDao.findById(id);
        return mapperEntity;
    }

    @Override
    public void deleteById(int customer_id) {
        musicDao.deleteById(customer_id);
    }

    @Override
    public Object findByAddress(String address) {
        Object addressId=(Object)musicDao.findByAddress(address);
        return addressId;
    }

    @Override
    public int insertCustomer(Customer customer) {
        musicDao.insertCustomer(customer);
        int customerId=customer.getCustomerId();
        return customerId;
    }

    @Override
    public ArrayList<Film> findByPage(Page page) {
        PageHelper.startPage(page.getPage(),page.getPageSize());
        int pa=(page.getPage()-1)*page.getPageSize();
        page.setPage(pa);
        ArrayList<Film> list=musicDao.findByPage(page);
        return list;
    }

    @Override
    public void updateById(Customer customer) {
        musicDao.updateById(customer);
    }

    @Override
    public Object login(Customer customer) {
        Object id=musicDao.login(customer);
        return id;
    }

}
