package pl.sda.bankclient.service;

public interface IService<T> {

    T save(T dto);

}
