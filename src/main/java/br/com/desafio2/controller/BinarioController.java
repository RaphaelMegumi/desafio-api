package br.com.desafio2.controller;

import br.com.desafio2.services.dto.BinarioDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@CrossOrigin("*")
public class BinarioController {

    @PostMapping("calcular")
    public ResponseEntity<String> criar(@RequestBody final BinarioDTO dto) {
        return ResponseEntity.ok(calcularBinario(dto.getNumero1(), dto.getNumero2(), dto.getOperacao()));
    }

    public String calcularBinario(String numero1, String numero2, String operacao) {

        int tam1 = numero1.length();
        int tam2 = numero2.length();
        int convertido1 = Integer.parseInt(numero1, 2);
        int convertido2 = Integer.parseInt(numero2, 2);
        int resutado = 0;

        if ((convertido1 >= 0 && convertido1 <= 255) && (convertido2 >= 0 && convertido2 <= 255)) {
            switch (operacao) {
                case "+":
                    resutado = convertido1 + convertido2;
                    break;
                case "-":
                    resutado = convertido1 - convertido2;
                    break;
                case "*":
                    resutado = convertido1 * convertido2;
                    break;
                case "/":
                    resutado = convertido1 / convertido2;
                    break;
                case "%":
                    resutado = convertido1 % convertido2;
                    break;
                default:
                    System.out.println("Operador inválido");
                    break;
            }

            String x = Integer.toBinaryString(Integer.parseInt(String.valueOf(resutado)));
            int tamanho = tam1 > tam2 ? tam1 : tam2;
            String resultado = "";
            for (int i = 0; i < tamanho - x.length(); i++) {
                resultado = "0".concat(resultado);
            }
            return resultado.concat(x);
        }else {
            System.out.println("Numeros inválidos - necessário 8 digitos");
        }
        throw new IllegalArgumentException();
    }
}


