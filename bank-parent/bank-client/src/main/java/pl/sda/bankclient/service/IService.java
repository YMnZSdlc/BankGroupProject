package pl.sda.bankclient.service;

public interface IService<T> {

    T save(T dto);

    void find(T dto);

}
