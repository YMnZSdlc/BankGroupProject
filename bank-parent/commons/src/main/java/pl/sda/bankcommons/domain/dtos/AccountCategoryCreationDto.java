package pl.sda.bankcommons.domain.dtos;

import lombok.Data;

import java.util.List;

@Data
public class AccountCategoryCreationDto {

    private Integer id;
    private String categoryName;
    private Integer accountId;
}
