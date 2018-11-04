package pl.sda.bankserver.mappers;

import org.junit.Test;
import pl.sda.bankcommons.domain.dtos.WorkerDto;
import pl.sda.bankserver.domain.Worker;

import static org.junit.Assert.assertEquals;

public class WorkerMapperTest {

    @Test
    public void workerToWorkerDto() {
        //given
        FakeDomains fakeDomains = new FakeDomains();
        fakeDomains.createFakeDomains();
        Worker entityIn = fakeDomains.getWorker();

        //when
        WorkerDto dtoOut = WorkerMapper.INSTANCE.workerToWorkerDto(entityIn);

        //then
        assertEquals(dtoOut.getId(), entityIn.getId());
        assertEquals(dtoOut.getPassword(), entityIn.getPassword());
        assertEquals(dtoOut.getFirstName(), entityIn.getFirstName());
        assertEquals(dtoOut.getLastName(), entityIn.getLastName());
        assertEquals(dtoOut.getSalary(), entityIn.getSalary());
        assertEquals(dtoOut.getPesel(), entityIn.getPesel());
        assertEquals(dtoOut.getEmploymentDate(), entityIn.getEmploymentDate());
        assertEquals(dtoOut.getEmail(), entityIn.getEmail());
        assertEquals(dtoOut.getPhoneNumber(), entityIn.getPhoneNumber());
        assertEquals(dtoOut.getSex(), entityIn.getSex());
        assertEquals(dtoOut.getDateOfBirth(), entityIn.getDateOfBirth());
        assertEquals(dtoOut.getDepartmentId(), entityIn.getDepartment().getId());
        assertEquals(dtoOut.getAddressId(), entityIn.getAddress().getId());

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