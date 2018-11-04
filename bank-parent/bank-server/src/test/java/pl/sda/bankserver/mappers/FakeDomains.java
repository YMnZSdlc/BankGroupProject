package pl.sda.bankserver.mappers;

import pl.sda.bankcommons.domain.enums.CardTypeEnum;
import pl.sda.bankcommons.domain.enums.ServiceEnum;
import pl.sda.bankcommons.domain.enums.Sex;
import pl.sda.bankserver.domain.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FakeDomains {

    private Account account;
    private AccountCategory accountCategory;
    private AccountHistory accountHistory;
    private Address address;
    private Card card;
    private Customer customer;
    private Department department;
    private Service service;
    private Worker worker;

    public Account createAccount() {
        Account account = new Account();

        account.setId(1234);
        account.setNumber("1234");
        account.setCreateDate(LocalDateTime.of(2018, 10, 20, 12, 22));
        account.setBalance(new BigDecimal("12345.6"));
        List<Service> services = new ArrayList<>();
        services.add(createService());
        account.setServices(services);
        List<Card> cards = new ArrayList<>();
        cards.add(createCard());
        account.setCards(cards);
        AccountCategory accountCategory = new AccountCategory();
        account.setAccountCategory(accountCategory);
        List<AccountHistory> accountHistories = new ArrayList<>();
        account.setAccountHistories(accountHistories);
        List<Customer> customers = new ArrayList<>();

        return account;
    }

    public AccountCategory createAccountCategory() {
        AccountCategory accountCategory = new AccountCategory();

        accountCategory.setId(1234);
        accountCategory.setCategoryName("1234");
        accountCategory.setAccount(createAccount());

        return accountCategory;
    }

    public AccountHistory createAccountHistory() {
        AccountHistory accountHistory = new AccountHistory();

        accountHistory.setId(1234);
        accountHistory.setBalanceBefore(new BigDecimal("123.4"));
        accountHistory.setBalanceAfter(new BigDecimal("567.8"));
        accountHistory.setAccount(createAccount());

        return accountHistory;
    }

    public Address createAddress() {
        Address address = new Address();

        address.setId(1234);
        address.setStreetName("Zgierska");
        address.setStreetNo("99");
        address.setHomeNo("66");
        address.setCity("Zgierz");
        address.setZipCode("12-345");
        List<Customer> customers = new ArrayList<>();
        customers.add(createCustomer());
        address.setCustomersAddresses(customers);
        List<Worker> workers = new ArrayList<>();
        workers.add(createWorker());
        address.setWorkerAddresses(workers);
        List<Worker> workersDep = new ArrayList<>();
        workersDep.add(createWorker());
        address.setDepartmentsAddresses(workersDep);

        return address;
    }

    public Card createCard() {
        Card card = new Card();

        card.setId(1243);
        card.setCardType(CardTypeEnum.MASTERCARD);
        card.setCardNo(243547374L);
        card.setCvcCvvCode(123);
        card.setActivationDate(LocalDate.of(2018, 10, 20));
        card.setExpireDate(LocalDate.of(2020, 10, 19));
        card.setAccount(createAccount());

        return card;
    }

    public Customer createCustomer() {
        Customer customer = new Customer();

        customer.setId(6578);
        customer.setPassword("TrudneHasło");
        customer.setFirstName("Adam");
        customer.setLastName("Miałczyński");
        customer.setPesel("12345678901");
        customer.setCreateDate(LocalDateTime.of(2017, 10, 20, 10, 45, 23));
        customer.setEmail("adam@wp.pl");
        customer.setPhoneNumber("123 456 789");
        customer.setDateOfBirth(LocalDate.of(1990, 10, 12));
        customer.setSex(Sex.M);
        List<Account> accounts = new ArrayList<>();
        accounts.add(createAccount());
        customer.setAccounts(accounts);
        customer.setDepartment(createDepartment());
        customer.setAddress(createAddress());

        return customer;
    }

    public Department createDepartment() {
        Department department = new Department();

        department.setId(7654);
        department.setDeptName("Oddział w Zgierzu");
        department.setDeptNo(5);
        department.setPhoneNumber("987 765 543");
        List<Customer> customers = new ArrayList<>();
        customers.add(createCustomer());
        department.setCustomers(customers);
        List<Worker> workers = new ArrayList<>();
        workers.add(createWorker());
        department.setWorkers(workers);
        department.setAddress(createAddress());

        return department;
    }

    public Service createService() {
        Service service = new Service();

        service.setId(5432);
        service.setService(ServiceEnum.DEPOSIT);
        service.setNumber(0);
        service.setTitle("Depozyt");
        service.setDate(LocalDateTime.of(2017, 10, 10, 12, 12, 12));
        service.setAmount(new BigDecimal("123.4"));
        service.setCurrency("bla bla");
        service.setStartTime(LocalDateTime.of(2018, 10, 10, 12, 12, 12));
        service.setEndTime(LocalDateTime.of(2022, 10, 10, 12, 12, 12));
        service.setSenderAccount("BLA bla BLa");
        service.setRecipientAccount("lorem");
//        service.setAccount(createAccount());

        return service;
    }

    public Worker createWorker() {
        Worker worker = new Worker();

        worker.setId(6578);
        worker.setPassword("TrudneHasło");
        worker.setFirstName("Adam");
        worker.setLastName("Miałczyński");
        worker.setSalary(new BigDecimal("2223.4"));
        worker.setPesel("12345678901");
        worker.setEmploymentDate(LocalDate.of(2017, 10, 20));
        worker.setEmail("adam@wp.pl");
        worker.setPhoneNumber("123 456 789");
        worker.setSex(Sex.M);
        worker.setDateOfBirth(LocalDate.of(1988, 10, 12));
        worker.setDepartment(createDepartment());
        worker.setAddress(createAddress());

        return worker;
    }
}
