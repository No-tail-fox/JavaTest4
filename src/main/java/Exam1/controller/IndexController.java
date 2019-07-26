package Exam1.controller;

import Exam1.dao.MusicDao;
import Exam1.domain.Page;
import Exam1.domain.Customer;
import Exam1.domain.Film;
import Exam1.service.MusicService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class IndexController {
    @Autowired
    MusicService musicService;
    @Autowired
    MusicDao musicDao;
    @Autowired
    ApplicationContext applicationContext;
    Logger logger =LoggerFactory.getLogger(IndexController.class);

//    @RequestMapping(value = "/listall",method = RequestMethod.GET)
//    public Film getIndex(@RequestParam("filmId") int id) {
//        logger.info("进行了get请求,获取到的参数为："+id);
//        Film film=new Film();
//        film.setFilm_title("好看的电影");
//        return film;
//    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam("name") String first_name,@RequestParam("password")String last_name){
        logger.info("尝试进行登陆");
        return "登陆成功";
    }


    @RequestMapping(value = "/listall",method = RequestMethod.GET)
    public ArrayList<Film> getList(Page page) {
        logger.info("进行了list请求,获取到的参数为："+page.toString());
        ArrayList<Film> list=musicService.findByPage(page);
        logger.info("list请求完成，请求页码为："+page.toString()+1);
        return list;
    }
    /*插入用户*/
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert(@RequestParam("first_name") String first_name,@RequestParam("last_name") String last_name,@RequestParam("email") String email,@RequestParam("address")String address) {
        logger.info("进行了插入请求,获取到的参数为："+first_name);
        Customer customer=new Customer();
        customer.setFirstName(first_name);
        customer.setLastName(last_name);
        customer.setEmail(email);
        Object object=musicService.findByAddress(address);
        if (object!=null)
        {
            int addressid=(Integer)object;
            customer.setAddressId(addressid);
        }
        musicService.insertCustomer(customer);
        logger.info("进行了插入完成，插入的id值为 ："+customer.getCustomerId());
        return customer.getCustomerId();
    }

    @RequestMapping(value = "/updatebyid",method = RequestMethod.PUT)
    public int update(@RequestParam("customerid") int customerId,@RequestParam("first_name") String first_name,@RequestParam("last_name") String last_name,@RequestParam("email") String email,@RequestParam("address")String address) {
        logger.info("进行了修改请求,获取到的参数为："+customerId);
        Customer customer=new Customer();
        customer.setFirstName(first_name);
        customer.setLastName(last_name);
        customer.setEmail(email);
        Object addressid=musicService.findByAddress(address);
        if (addressid!=null)
        {
            customer.setAddressId((Integer)addressid);
        }
        customer.setCustomerId(customerId);
        musicService.updateById(customer);
        logger.info("修改完成，修改后的customerid为"+customer.getCustomerId()+" addressId: "+customer.getAddressId());
        return customer.getCustomerId();
    }

    @RequestMapping(value = "/deletebyid",method = RequestMethod.DELETE)
    public String deleteById(@RequestParam("customerid") int customerid) {
        logger.info("进行了delete请求,获取到的参数为："+customerid);
        musicService.deleteById(customerid);
        logger.info("进行了delete请求成功，删除的customerid值为"+customerid);
        return "进行了delete请求成功，删除的customerid值为";
    }

//    @RequestMapping(value = "/insert",method = RequestMethod.PUT)
//    public String insert(@RequestParam("filmId") int id,@RequestParam("title") String title) {
//        logger.info("进行了put请求,获取到的参数为："+id+","+title);
//        return "10";
//    }

//    @RequestMapping(value = "/deletebyid",method = RequestMethod.DELETE)
//    public String deleteById(@RequestParam("filmId") int id) {
//        logger.info("进行了delete请求,获取到的参数为："+id);
//        return "10";
//    }

//    @RequestMapping("/upload")
//    @ResponseBody
//    public String upLoad(@RequestParam("file") MultipartFile file){
//        String fileName = file.getOriginalFilename();
//        // 获取后缀名
//        // String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        // 文件保存路径
//        String filePath = "d:/upload/";
//        // 文件重命名，防止重复
//        fileName = filePath + UUID.randomUUID() + fileName;
//        // 文件对象
//        File dest = new File(fileName);
//        // 判断路径是否存在，如果不存在则创建
//        if(!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdirs();
//        }
//        try {
//            // 保存到服务器中
//            file.transferTo(dest);
//            return "上传成功";
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "上传成功";
//    }
//
//    @RequestMapping("/download")
//    @ResponseBody
//    public String download(HttpServletResponse response) throws IOException {
//        File file=new File("d:\\upload\\82e2d716-49b2-453b-b66b-579e42de7c6c2c2df5ec043a27c6e3d286bf85aa9568_hd.jpg");
//        FileInputStream fileInputStream=new FileInputStream(file);
//        response.setContentType("application/force-download");
//        response.addHeader("Content-disposition","attachment;fileName="+"a.txt");
//        OutputStream outputStream=response.getOutputStream();
//        byte[] bytes=new byte[1024];
//        int len=0;
//        while((len=fileInputStream.read(bytes))!=-1){
//            outputStream.write(bytes);
//        }
//        fileInputStream.close();
//        outputStream.close();
//        return "下载成功";
//    }
}
