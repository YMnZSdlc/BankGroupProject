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

    public void createFakeDomains (){
        this.account = createAccount();
        this.accountCategory = createAccountCategory();
        this.accountHistory = createAccountHistory();
        this.address = createAddress();
        this.card = createCard();
        this.customer = createCustomer();
        this.department = createDepartment();
        this.service = createService();
        this.worker = createWorker();

        fillEmptyFields();
    }

    private void fillEmptyFields() {
        this.account.getServices().add(this.service);
        this.account.getCards().add(this.card);
        this.account.setAccountCategory(this.accountCategory);
        this.account.getAccountHistories().add(this.accountHistory);

        this.accountCategory.setAccount(this.account);

        this.accountHistory.setAccount(this.account);

        this.address.getCustomersAddresses().add(this.customer);
        this.address.getWorkerAddresses().add(this.worker);
//    TODO    this.address.getDepartmentsAddresses().add(this.worker);

        this.card.setAccount(this.account);

        this.customer.getAccounts().add(this.account);
        this.customer.setDepartment(this.department);
        this.customer.setAddress(this.address);

        this.department.getCustomers().add(this.customer);
        this.department.getWorkers().add(this.worker);
        this.department.setAddress(address);

        this.service.setAccount(this.account);

        this.worker.setDepartment(this.department);
        this.worker.setAddress(this.address);
    }


    private Account createAccount() {
        Account account = new Account();

        account.setId(1234);
        account.setNumber("1234");
        account.setCreateDate(LocalDateTime.of(2018, 10, 20, 12, 22));
        account.setBalance(new BigDecimal("12345.6"));
        List<Service> services = new ArrayList<>();
        account.setServices(services);
        List<Card> cards = new ArrayList<>();
        account.setCards(cards);
        account.setAccountCategory(new AccountCategory());
        List<AccountHistory> accountHistories = new ArrayList<>();
        account.setAccountHistories(accountHistories);

        return account;
    }

    private AccountCategory createAccountCategory() {
        AccountCategory accountCategory = new AccountCategory();

        accountCategory.setId(1234);
        accountCategory.setCategoryName("1234");
        accountCategory.setAccount(new Account());

        return accountCategory;
    }

    private AccountHistory createAccountHistory() {
        AccountHistory accountHistory = new AccountHistory();

        accountHistory.setId(1234);
        accountHistory.setBalanceBefore(new BigDecimal("123.4"));
        accountHistory.setBalanceAfter(new BigDecimal("567.8"));
        accountHistory.setAccount(new Account());

        return accountHistory;
    }

    private Address createAddress() {
        Address address = new Address();

        address.setId(1234);
        address.setStreetName("Zgierska");
        address.setStreetNo("99");
        address.setHomeNo("66");
        address.setCity("Zgierz");
        address.setZipCode("12-345");
        List<Customer> customers = new ArrayList<>();
        address.setCustomersAddresses(customers);
        List<Worker> workers = new ArrayList<>();
        address.setWorkerAddresses(workers);
        List<Department> workersDep = new ArrayList<>();
        address.setDepartmentsAddresses(workersDep);

        return address;
    }

    private Card createCard() {
        Card card = new Card();

        card.setId(1243);
        card.setCardType(CardTypeEnum.MASTERCARD);
        card.setCardNo(243547374L);
        card.setCvcCvvCode(123);
        card.setActivationDate(LocalDate.of(2018, 10, 20));
        card.setExpireDate(LocalDate.of(2020, 10, 19));
        card.setAccount(new Account());

        return card;
    }

    private Customer createCustomer() {
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
        customer.setAccounts(accounts);
        customer.setDepartment(createDepartment());
        customer.setAddress(new Address());

        return customer;
    }

    private Department createDepartment() {
        Department department = new Department();

        department.setId(7654);
        department.setDeptName("Oddział w Zgierzu");
        department.setDeptNo(5);
        department.setPhoneNumber("987 765 543");
        List<Customer> customers = new ArrayList<>();
        department.setCustomers(customers);
        List<Worker> workers = new ArrayList<>();
        department.setWorkers(workers);
        department.setAddress(new Address());

        return department;
    }

    private Service createService() {
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
        service.setAccount(new Account());

        return service;
    }

    private Worker createWorker() {
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
        worker.setDepartment(new Department());
        worker.setAddress(new Address());

        return worker;
    }



    public FakeDomains() {
    }

    public Account getAccount() {
        return account;
    }

    public AccountCategory getAccountCategory() {
        return accountCategory;
    }

    public AccountHistory getAccountHistory() {
        return accountHistory;
    }

    public Address getAddress() {
        return address;
    }

    public Card getCard() {
        return card;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Department getDepartment() {
        return department;
    }

    public Service getService() {
        return service;
    }

    public Worker getWorker() {
        return worker;
    }
}
