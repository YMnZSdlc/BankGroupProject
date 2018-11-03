package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankserver.domain.Worker;

import java.math.BigDecimal;

public class WorkerMapperTest {

    @Test
    public void workerToWorkerDto() {
        Worker entity = new Worker();
        entity.setPassword("sadfda");
        entity.setFirstName("Mateusz");
        entity.setLastName("Nowak");
        entity.setSalary(new BigDecimal("12345.6"));
        entity.setPesel("96060448644");
    }

    @Test
    public void workerDtoToWorker() {
    }
}