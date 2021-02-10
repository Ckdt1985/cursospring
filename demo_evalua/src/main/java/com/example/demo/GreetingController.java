package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

enum Estados {INICIAL, PRIMER_NUMERO, SEGUNDO_NUMERO, RESULTADO};

@Controller
public class GreetingController {
    Estados estado = Estados.INICIAL;
    int op1 = 0;
    int op2 = 0;
    String operador = "";
    long resultado = 0;

    @GetMapping("/evalua")
    public String greeting(@RequestParam(name="expresion", required=false, defaultValue="World") String cadena, Model model) {
        model.addAttribute("expresion", cadena + this.resultado);
        int index = 0;
        for (index=0;index<cadena.length();index++)
            try {
                int numero = Integer.parseInt(String.valueOf(cadena.charAt(index)));
                this.procesaNumero(numero);
            } catch (Exception e) {
                this.procesaSimbolo(cadena.substring(index, index + 1));
            }
        return "greeting";
    }

    void procesaNumero(int numero){
        switch (this.estado) {
            case INICIAL:
                this.op1 = numero;
                this.estado = Estados.PRIMER_NUMERO;
                break;
            case PRIMER_NUMERO:
                this.op1 = this.op1 * 10 + numero;
                break;
            case SEGUNDO_NUMERO:
                this.op2 = this.op2 * 10 + numero;
                break;
            case RESULTADO:
                
                break;
        
            default:
                break;
        }
    }

    void procesaSimbolo(String simbolo){
        switch (this.estado) {
            case INICIAL:
                break;
            case PRIMER_NUMERO:
                if(simbolo.equals("*") || simbolo.equals("/") || simbolo.equals("-") || simbolo.equals("%2B") ){
                    this.operador = simbolo;
                    this.estado = Estados.SEGUNDO_NUMERO;
                }
                break;
            case SEGUNDO_NUMERO:
                if(simbolo.equals("=")){
                    this.resultado = this.resuelve();
                    this.op1 = 0;
                    this.op2=0;
                    this.operador="";
                    this.estado = Estados.INICIAL;
                }
                break;
            case RESULTADO:
                
                break;
        
            default:
                break;
        }

    }

    long resuelve(){
        System.out.println("Evaluo");
        switch (this.operador) {
            case "%2B":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                return op1 / op2;
            default:
                System.out.println("No entro en ninguna opción");
                break;
        }
        return -1L;
    }
}
