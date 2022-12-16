package com.company;

public class Main {

    public static void main(String[] args) {
	    String Ciudades[] = {"Londres", "Madrid", "Nueva york", "Buenos Aires", "Asunción", "São Paulo", "Lima",
							 "Santiago de Chile", "Lisboa", "Tokio"};
		String CiudadMayor = "";
	    String CiudadMenor = "";
	    int Temperaturas[][] = {{-2,33}, {-3, 32},{-8,27}, {4,37}, {6,42}, {5,43}, {0,39}, {-7,26}, {-1,31}, {-10,35}};

		int mayor = 0;
		int menor = Temperaturas[0][0];

	    for (int i = 0; i < Temperaturas.length; i++){
	        for (int j = 0; j < Temperaturas[i].length; j++){
                if(Temperaturas[i][j] > mayor){
                	mayor = Temperaturas[i][j];
                	CiudadMayor = Ciudades[i];
				}
                if(Temperaturas[i][j] < menor){
                	menor = Temperaturas[i][j];
					CiudadMenor = Ciudades[i];
				}
            }

        }

		System.out.println("La mayor temperatura la tuvo "+CiudadMayor+", con "+mayor+" º C.");
		System.out.println("La menor temperatura la tuvo "+CiudadMenor+", con "+menor+" º C.");

    }
}
