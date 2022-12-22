package com.SpringP2PG.NumerosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanos
{
    @GetMapping("/convertir-a-romano/{numero}")
    public String devolverNumero(@PathVariable int numero)
    {
        if (numero >= 1 && numero < 4)
        {
            String retorno = "";

            for (int i = 0; i < numero; i++)
            {
                retorno = retorno + "I";
            }
            return retorno;
        }
        else if (numero == 4)
        {
            return "IV";
        }
        else if (numero > 4 && numero < 9)
        {
            if (numero == 5)
            {
                return "V";
            }
            else
            {
                String retorno = "V";

                for (int i = 5; i < numero; i++)
                {
                    retorno = retorno + "I";
                }
                return retorno;
            }
        }
        else if (numero == 9)
        {
            return "IX";
        }
        else if( numero == 10)
        {
            return "X";
        }
        else if (numero > 10 && numero < 20)
        {
            String retorno = "X";

            if( numero >= 11 && numero < 14)
            {
                for (int i = 10; i < numero; i++)
                {
                    retorno = retorno + "I";
                }

                return retorno;
            }
            else if (numero == 14)
            {
                return "XIV";
            }
            else if (numero == 15)
            {
                return "XV";
            }
            else if (numero > 15 && numero < 19)
            {
                retorno = "XV";
                for (int i = 15; i < numero; i++)
                {
                    retorno = retorno + "I";
                }
                return retorno;
            }
            else
            {
                return "XIX";
            }
        }
        else if (numero == 20)
        {
            return "XX";
        }
        else if (numero > 20 && numero < 30)
        {
            String retorno = "XX";

            if( numero >= 21 && numero < 24)
            {
                for (int i = 20; i < numero; i++)
                {
                    retorno = retorno + "I";
                }

                return retorno;
            }
            else if (numero == 24)
            {
                return retorno + "IV";
            }
            else if (numero == 25)
            {
                return retorno + "V";
            }
            else if (numero > 25 && numero < 29)
            {
                retorno = "XXV";
                for (int i = 25; i < numero; i++)
                {
                    retorno = retorno + "I";
                }
                return retorno;
            }
            else
            {
                return "XXIX";
            }
        }
        else if (numero == 50)
        {
            return "L";
        }
        else if (numero == 100)
        {
            return "C";
        }
        else if (numero == 500)
        {
            return "C";
        }
        else if (numero == 1000)
        {
            return "M";
        }
        else
        {
            return "No implementado";
        }
    }
}
