package Exam1.domain;

import java.util.ArrayList;

public class Film {
    private int filmId;
    private String film_title;
    private String customerId;
    private String addressId;
    private String address;
    private Customer customer;
    private ArrayList<Customer> list;

    public ArrayList<Customer> getList() {
        return list;
    }

    public void setList(ArrayList<Customer> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", film_title='" + film_title + '\'' +
                ", customerId='" + customerId + '\'' +
                ", addressId='" + addressId + '\'' +
                ", address='" + address + '\'' +
                ", customer=" + customer +
                '}';
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilm_title() {
        return film_title;
    }

    public void setFilm_title(String film_title) {
        this.film_title = film_title;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
