package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.WorkerDto;
import pl.sda.bankserver.domain.Worker;

import static org.junit.Assert.assertEquals;

public class WorkerMapperTest {

    @Test
    public void workerToWorkerDto() {

    }

    @Test
    public void workerDtoToWorker() {
        //given
        WorkerDto dto = FakeDtos.createWorkerDto();

        //when
        Worker entity = WorkerMapper.INSTANCE.workerDtoToWorker(dto);

        //then
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getPassword(), dto.getPassword());
        assertEquals(entity.getFirstName(), dto.getFirstName());
        assertEquals(entity.getLastName(), dto.getLastName());
        assertEquals(entity.getSalary(), dto.getSalary());
        assertEquals(entity.getPesel(), dto.getPesel());
        assertEquals(entity.getEmploymentDate(), dto.getEmploymentDate());
        assertEquals(entity.getEmail(), dto.getEmail());
        assertEquals(entity.getPhoneNumber(), dto.getPhoneNumber());
        assertEquals(entity.getSex(), dto.getSex());
        assertEquals(entity.getDateOfBirth(), dto.getDateOfBirth());
        assertEquals(entity.getDepartment().getId(), dto.getDepartmentId());
        assertEquals(entity.getAddress().getId(), dto.getAddressId());
    }
}