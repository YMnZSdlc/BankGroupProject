package pl.sda.bankserver.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.sda.bankcommons.domain.dtos.WorkerDto;
import pl.sda.bankserver.domain.Worker;

@Mapper
public interface WorkerMapper {

    WorkerMapper INSTANCE = Mappers.getMapper(WorkerMapper.class);

    @Mappings({@Mapping(target = "departmentId", source = "entity.department.id"),
            @Mapping(target = "addressId", source = "entity.address.id")})
    WorkerDto workerToWorkerRegistrationDto(Worker entity);

    @Mappings({@Mapping(target = "department.id", source = "dto.departmentId"),
            @Mapping(target = "address.id", source = "dto.addressId")})
    Worker workerRegistrationDtoToWorker(WorkerDto dto);
}
