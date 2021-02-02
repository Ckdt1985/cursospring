package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class GreetingController {
    @GetMapping("/calculadora")
    public String calculadora(
        @RequestParam(name="operando1", required=true) String op1,
        @RequestParam(name="operador", required=false, defaultValue="") String operacion,
        @RequestParam(name="operando2", required=false, defaultValue="") String op2, 
        Model model) {
            int resultado = this.resolve(op1,operacion,op2);

            model.addAttribute("operando1", op1);
            model.addAttribute("operacion", operacion);
            model.addAttribute("operando2", op2);
            model.addAttribute("resultado", resultado);
            return "calculadora";
    }

    private int resolve(String op1, String operacion, String op2){
        int operador1;
        try {
            operador1 = Integer.parseInt(op1);            
        } catch (NumberFormatException e) {
            operador1 = 0;
            System.out.println("Ha llegado mal el primer operador: " + operador1);
        }
        int operador2 = Integer.parseInt(op2);
        switch (operacion) {
            case "+":
                return operador1 + operador2;       
            case "-":
                return operador1 - operador2;       
            case "*":
                return operador1 * operador2;       
            case "/":
                return operador1 / operador2;       
            default:
                return 0;
        }
    }
}
