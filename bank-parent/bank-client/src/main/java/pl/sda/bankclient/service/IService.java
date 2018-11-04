package pl.sda.bankclient.service;

import java.util.List;

public interface IService<T> {

    T save(T dto);

    void find(T dto);

    List<T> findAll();

}
