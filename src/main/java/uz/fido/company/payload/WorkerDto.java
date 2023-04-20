package uz.fido.company.payload;

import lombok.Data;

@Data
public class WorkerDto {
    private String name;
    private String phoneNumber;
    private Integer address_id;
    private Integer department_id;
}
