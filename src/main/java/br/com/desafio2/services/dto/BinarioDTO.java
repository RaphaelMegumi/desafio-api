package br.com.desafio2.services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BinarioDTO {

    private Integer id;
    private String numero1;
    private String numero2;
    private String operacao;

}
